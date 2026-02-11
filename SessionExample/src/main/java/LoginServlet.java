import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.*;

public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Dummy authentication
        if (username.equals("admin") && password.equals("1234")) {

            // Create session
            HttpSession session = request.getSession();
            session.setAttribute("user", username);

            response.sendRedirect("dashboard");
        } else {
            response.getWriter().println("Invalid Username or Password");
        }
    }
}