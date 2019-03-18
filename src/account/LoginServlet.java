package account;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		LoginDAO dao = new LoginDAO();
		if (dao.Login(id, pw, name) == 0) {
			System.out.println("insert fail");
			response.sendRedirect("join.jsp");
		} else {
			System.out.println("insert success");
			response.sendRedirect("joinResult.jsp");
		}
	

		HttpSession httpSession=request.getSession();
		httpSession.setAttribute("id", id);
		httpSession.setAttribute("pw", pw);
		httpSession.setAttribute("name", name);


		System.out.println("name="+name);
		response.sendRedirect("loginresult.jsp");
		}





	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
