package filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Musicien;

/**
 * Servlet Filter implementation class FilterCookies
 */
@WebFilter("/")
public class FilterCookies extends HttpFilter implements Filter {
   	private static final long serialVersionUID = 1L;

	private static final String email = new Musicien().getEmail();
	private static final String password = new Musicien().getPassword();
	
    /**
     * @see HttpFilter#HttpFilter()
     */
    public FilterCookies() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// Cast des objets request et response
		HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        
        // Récupération des cookies
        Cookie[] cookies = req.getCookies();
        
        for (Cookie cookie : cookies) {
        	if (cookie.getName().equals("auth-token")) {
        		res.addCookie(cookie);
        	}
        }
        
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
