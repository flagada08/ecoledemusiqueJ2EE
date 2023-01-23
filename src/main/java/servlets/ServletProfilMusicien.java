package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ServletProfilMusicien
 */
@WebServlet("/profil-musicien")
public class ServletProfilMusicien extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public static final String VUE_MUSICIEN = "/restrictions/profilMusicien.jsp";
	public static final String VUE_PUBLIC = "/public.jsp";
	
	public static final String ATT_SESSION_MUSICIEN = "sessionMusicien";
   
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		 
		if (session.getAttribute(ATT_SESSION_MUSICIEN) == null) {
            response.sendRedirect(request.getContextPath() + VUE_PUBLIC);
        } else {
            this.getServletContext().getRequestDispatcher(VUE_MUSICIEN).forward(request, response);
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
