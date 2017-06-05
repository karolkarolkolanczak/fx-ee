package Controller;

import Model.Partner;

import Model.User;
import Utility.ConnectionToDb;
import Utility.PartnerDataUtil;
import Utility.UserDataUtil;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by a on 2017-05-03.
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet{
    User user;
    List<Partner> listOfPartners;
    PartnerDataUtil partnerDataUtil;
    Session sessionClass;
    HttpSession session;
    UserDataUtil userDataUtil;
    Boolean isLogged;
    ConnectionToDb connectionToDb;

    public LoginServlet() {
        user = new User();
        sessionClass = new Session();
        userDataUtil=new UserDataUtil();
        isLogged=false;
        partnerDataUtil=new PartnerDataUtil();
        listOfPartners=new ArrayList<>();
        connectionToDb=new ConnectionToDb();
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        session=sessionClass.getSession(request);

        session.setAttribute("isLogged",isLogged(request));
        session.setAttribute("listOfUsers",connectionToDb.getListOfAllUsers());
        session.setAttribute("listOfPartners",connectionToDb.getListOfAllPartners());

        request.setAttribute("listOfPartners", listOfPartners);

        if(session.getAttribute("isLogged").equals(true)){

            System.out.println("FROM SESSION - LOGIN: "+((User)session.getAttribute("userSessionData")).getLogin());
            RequestDispatcher dispatcher=request.getRequestDispatcher("/admin.jsp");
            dispatcher.forward(request,response);
        }
        else{
            RequestDispatcher dispatcher=request.getRequestDispatcher("/login.jsp");
            dispatcher.forward(request,response);
        }

    }
    Boolean isLogged(HttpServletRequest request){

        for(User value: connectionToDb.getListOfAllUsers()){
            if(value.getLogin().equals(request.getParameter("login")) && value.getPassword().equals(request.getParameter("password"))){

                user.setLogin(request.getParameter("login"));
                user.setPassword(request.getParameter("password"));

                session.setAttribute("userSessionData",user);

                isLogged=true;
                System.out.println("--> Logged succesfully");
                return isLogged;
            }
            else{
                isLogged=false;
                System.out.println("---> wrong password or login");
            }
        }
        return isLogged;
    }
}

