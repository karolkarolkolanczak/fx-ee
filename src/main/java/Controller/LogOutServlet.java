package Controller;

import Model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.transform.sax.SAXSource;
import java.io.IOException;



@WebServlet("/LogOutServlet")
public class LogOutServlet extends HttpServlet {
    Session sessionClass;
    HttpSession session;

    public LogOutServlet() {
        sessionClass = new Session();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        session=sessionClass.getSession(request);
        session.invalidate();
        System.out.println(session.toString());
        response.sendRedirect("login.jsp");
    }
}
