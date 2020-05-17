package login;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "DetailsFromLogin", urlPatterns = "/login")
public class DetailsFromLogin extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Validate validate = new Validate();
        Boolean redirectBoolean = validate.authorize(request.getParameter("username"),request.getParameter("password"));
        HttpSession httpSession = request.getSession();
        if (redirectBoolean == true) {
            httpSession.setAttribute("JSESSIONID","LOGGEDIN");
            response.sendRedirect("/login/success");
        }
        else
            response.sendRedirect("login/failure");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
