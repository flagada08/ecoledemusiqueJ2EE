package filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class FilterRestriction
 */
@WebFilter("/restrictions/*")
public class FilterRestriction extends HttpFilter implements Filter {
	private static final long serialVersionUID = 1L;

	public static final String VUE_PUBLIC = "/public.jsp";
	public static final String ATT_SESSION_MUSICIEN = "sessionMusicien";
	/**
     * @see HttpFilter#HttpFilter()
     */
    public FilterRestriction() {
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
		/* Cast des objets request et response */
		HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        
        /* Récupération de la session depuis la requête */
        HttpSession session = req.getSession();
        
        /**
         * Si l'objet utilisateur n'existe pas dans la session en cours, alors
         * l'utilisateur n'est pas connecté.
         */
        if (session.getAttribute(ATT_SESSION_MUSICIEN) == null) {
            /* Redirection vers la page publique */
            res.sendRedirect(req.getContextPath() + VUE_PUBLIC);
        } else {
            /* Affichage de la page restreinte */
            chain.doFilter(req, res);
        }
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
