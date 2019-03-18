package account;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Join")
public class JoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;



	public JoinServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SignDAO dao = new SignDAO();

		request.setCharacterEncoding("UTF-8");

		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");

		HttpSession session = request.getSession();

		if (dao.insert(id, pw, name) == 0) {
			System.out.println("insert fail");
			response.sendRedirect("join.jsp");
		} else {
			System.out.println("insert success");
			response.sendRedirect("joinResult.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}