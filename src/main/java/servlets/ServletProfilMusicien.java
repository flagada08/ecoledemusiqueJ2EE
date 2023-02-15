package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletProfilMusicien
 */
@WebServlet("/profil-musicien")
public class ServletProfilMusicien extends HttpServlet {
	private static final long serialVersionUID = 1L;
		
	public static final String ATT_FORM = "form";
    public static final String ATT_MUSICIEN = "musicien";
    public static final String ATT_SESSION_MUSICIEN = "sessionMusicien";
	
	public static final String VUE_MUSICIEN = "/restrictions/profilMusicien.jsp";
   
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("auth-token")) {
                    request.setAttribute("token", cookie.getValue());
                }
            }
        }
		
		this.getServletContext().getRequestDispatcher(VUE_MUSICIEN).forward(request, response);
        }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
