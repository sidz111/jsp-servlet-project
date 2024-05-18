package mypackage;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/MySurvlet")
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MyServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		String myname = request.getParameter("username");
		String pass = request.getParameter("pass");
		String username2 = null;
		String pass1 = null;
		String pass2 = null;
		String rsusername = null;
		String rspass = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String url = "jdbc:mysql://localhost:3303/servlet";
		String sqluser = "root";
		String sqlpass = "root";
		PrintWriter out = response.getWriter();
		if (myname != null) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			try {
				connection = DriverManager.getConnection(url, sqluser, sqlpass);
				preparedStatement = connection.prepareStatement("select * from logintbl where username = ?");
				preparedStatement.setString(1, myname);
				ResultSet resultSet = preparedStatement.executeQuery();
				while (resultSet.next()) {
					rsusername = resultSet.getString("username");
					rspass = resultSet.getString("password");
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		if (myname != null && pass != null) {

			if (myname.equals(rsusername) && pass.equals(rspass)) {
				RequestDispatcher rd = request.getRequestDispatcher("/profile.jsp");
				rd.forward(request, response);

			} else {
				RequestDispatcher rd = request.getRequestDispatcher("/error.jsp");
				rd.forward(request, response);
			}
		} else {

			// For Registration process
			username2 = request.getParameter("username2");
			pass1 = request.getParameter("pass1");
			pass2 = request.getParameter("pass2");

			PrintWriter pw2 = response.getWriter();
			for (int i = 0; i < username2.length(); i++) {
				if (username2.charAt(i) > 48 && username2.charAt(i) < 57) {
					RequestDispatcher rd = request.getRequestDispatcher("/validation.jsp");
					rd.forward(request, response);

				} else {
					if (pass1.equals(pass2)) {
						RequestDispatcher rd = request.getRequestDispatcher("/afterregistration.jsp");
						rd.forward(request, response);

						// codes here
						try {
							Class.forName("com.mysql.cj.jdbc.Driver");

							try {
								connection = DriverManager.getConnection(url, sqluser, sqlpass);
								String query = "insert into logintbl(username, password) values(?,?)";
								preparedStatement = connection.prepareStatement(query);

								if (pass1.equals(pass2)) {
									preparedStatement.setString(1, username2);
									preparedStatement.setString(2, pass1);
								} else {
									out.print("<h1>Password not match</h1>");
								}
								int count = preparedStatement.executeUpdate();
								if (count > 0) {
									out.print("<h2>Record Inserted....!!!</h2>");
									RequestDispatcher requestDispatcher = request.getRequestDispatcher("/profile.jsp");
									requestDispatcher.forward(request, response);
								} else {
									out.print("<h2>Record NOT Inserted....!!!</h2>");
									RequestDispatcher requestDispatcher = request.getRequestDispatcher("/index.jsp");
									requestDispatcher.forward(request, response);
								}
							} catch (SQLException e) {
								e.printStackTrace();
							}
						} catch (ClassNotFoundException e) {
							e.printStackTrace();
						}

					} else {
						RequestDispatcher rd = request.getRequestDispatcher("/registrationerror.jsp");
						rd.forward(request, response);
					}
				}
			}

		}

	}

//	protected void doPost(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//
//		String myname = request.getParameter("myname");
//		String pass = request.getParameter("pass");
//		String username2 = request.getParameter("username2");
//		String pass1 = request.getParameter("pass1");
//		String pass2 = request.getParameter("pass2");
//		doGet(request, response);
//	}
}
