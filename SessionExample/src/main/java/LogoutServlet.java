import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.*;

public class LogoutServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

        HttpSession session = request.getSession(false);

        if (session != null) {
            session.invalidate();
        }

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body style='background-color: #d4edda; text-align: center; padding: 50px;'>");
        out.println("<h2 style='color: #155724;'>✓ You are logged out successfully.</h2>");
        out.println("<p><a href='index.html' style='color: #0d6efd;'>Login Again</a></p>");
        out.println("</body></html>");
    }
}