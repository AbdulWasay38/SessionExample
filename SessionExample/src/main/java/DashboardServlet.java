import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.*;

public class DashboardServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

        // Get existing session
        HttpSession session = request.getSession(false);

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        out.println("<body style='background-color: #e3f2fd; margin: 0; height: 100vh;'>");

        if (session == null) {
            out.println("<div style='text-align:center; padding:50px;'>");
            out.println("<h3 style='color:red;'>Session expired. Please login again.</h3>");
            out.println("</div>");
            return;
        }

        String user = (String) session.getAttribute("user");

        if (user != null) {
            out.println("<div style='text-align:center; padding:50px;'>");
            out.println("<h2>Welcome " + user + " 👋</h2>");
            out.println("<p><a href='logout' style='padding:10px 20px; background:red; color:white; text-decoration:none; border-radius:5px;'>Logout</a></p>");
            out.println("</div>");
        } else {
            out.println("<div style='text-align:center; padding:50px;'>");
            out.println("<h3>Please login first.</h3>");
            out.println("</div>");
        }
        
        out.println("</body>");
    }
}