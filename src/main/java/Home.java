import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/home")
public class Home extends HttpServlet {
	public Home() {
		super();
	}

	public void init(ServletConfig config) throws ServletException {
		System.out.println("init");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doGet");
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("home").forward(request, response);
		doGet(request, response);
		String nome = request.getParameter("nome");
		String senha = request.getParameter("senha");
		String mensagem = "Logado com sucesso!";
		if (!"123456".equals(senha)) {
			mensagem = "Login inválido";
		}
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		System.out.println("""
				<html>
				<head>
				<meta http-equiv='Content-Type' content='text/html; charset=ISO-8859-1'>
				<title>Insert title here</title>
				</head>
				<body>
				Nome: " + nome +" <br>
				<b> " + mensagem + "</b>
				</body>
				</html>
								""");
	}
}
