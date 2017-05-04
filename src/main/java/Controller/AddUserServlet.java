package Controller;

import Model.User;
import Model.UserDataUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by a on 2017-05-01.
 */
@WebServlet("/AddUserServlet")
public class AddUserServlet extends HttpServlet {

    User user;
    Session sessionClass;
    HttpSession session;
    UserDataUtil userDataUtil;

    public AddUserServlet() {
        user = new User();
        sessionClass = new Session();
        userDataUtil=new UserDataUtil();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("-----");

        session=sessionClass.getSession(request);

        System.out.println(request.getParameter("firstName"));

//        user.setFirstName(request.getParameter("firstName"));
//        user.setLastName(request.getParameter("lastName"));
//        user.setLogin(request.getParameter("login"));
//        user.setPassword(request.getParameter("password"));
//        user.setEmail(request.getParameter("email"));
//        user.setJoinedDate(((Date)request.getParameter("joinedDate")));

//        session.setAttribute("userSessionData",user);



        System.out.println("in ADUSER");
        System.out.println(session.toString());
        System.out.println("Id: "+ session.getId());
        System.out.println("creation time: "+session.getCreationTime());
        System.out.println("names: "+session.getAttributeNames());
        System.out.println("is new? "+session.isNew());
        System.out.println("FROM SESSION - LOGIN "+((User)session.getAttribute("userSessionData")).getLogin());
        System.out.println("------------------");


        RequestDispatcher dispatcher=request.getRequestDispatcher("/index.jsp");
        dispatcher.forward(request,response);
    }


}
