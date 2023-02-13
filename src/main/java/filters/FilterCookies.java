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

import org.apache.catalina.User;

import beans.Musicien;

/**
 * Servlet Filter implementation class FilterCookies
 */
@WebFilter("/*")
public class FilterCookies extends HttpFilter implements Filter {
   	private static final long serialVersionUID = 1L;

   	public static final String VUE_PUBLIC = "/public.jsp";
   	
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
        
//        /* Non-filtrage des ressources statiques */
//        String chemin = req.getRequestURI().substring( req.getContextPath().length() );
//        if ( chemin.startsWith( "/css" ) ) {
//            chain.doFilter( request, response );
//            return;
//        }
        
        // Récupération des cookies
        Cookie[] cookies = req.getCookies();
        
        if (cookies != null) {        	
        	for (Cookie cookie : cookies) {
        		if (cookie.getName().equals("auth-token") && cookie.getValue().equals(cookie.toString())) {
        			
        		} else {
        			/* Redirection vers la page publique */
//                	res.sendRedirect(req.getContextPath() + VUE_PUBLIC);
        		}
        	}
        }
        // pass the request along the filter chain
        chain.doFilter(req, res);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
