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
        System.out.println("IN LOG OUTTTT");

        session=sessionClass.getSession(request);

        System.out.println(session.toString());
        System.out.println("Id: "+ session.getId());
        System.out.println("creation time: "+session.getCreationTime());
        System.out.println("names: "+session.getAttributeNames());
        System.out.println("is new? "+session.isNew());
        System.out.println("------------------");
        System.out.println("CLOSE SESSION");
        session.invalidate();
//        HttpSession session=request.getSession(true);
        System.out.println(session.toString());

//        System.out.println("Id: "+ session.getId());
//        System.out.println("creation time: "+session.getCreationTime());
//        System.out.println("names: "+session.getAttributeNames());
//        System.out.println("is new? "+session.isNew());
        System.out.println("---------------------------");

        response.sendRedirect("login.jsp");


    }
}
