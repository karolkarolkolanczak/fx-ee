package Controller;

import Model.Partner;

import Model.QuotesData;
import Model.User;
import Utility.FxQuotesParser;
import Utility.ObjectPersist;
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
    List<Partner> listOfAllPartners;
    List<User> listOfAllUsers;
    Session sessionClass;
    HttpSession session;
    UserDataUtil userDataUtil;
    Boolean isLogged;
    ObjectPersist objectPersist;


    public LoginServlet() {
        user = new User();
        sessionClass = new Session();
        userDataUtil=new UserDataUtil();
        isLogged=false;
        listOfAllPartners=new ArrayList<>();
        listOfAllUsers=new ArrayList<>();
        objectPersist =new ObjectPersist();
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        listOfAllUsers= objectPersist.getListOfAllUsers();
        listOfAllPartners= objectPersist.getListOfAllPartners();
        session=sessionClass.getSession(request);

        session.setAttribute("isLogged",isLogged(request));
        session.setAttribute("listOfUsers", listOfAllUsers);

        request.setAttribute("listOfAllPartners", listOfAllPartners);

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

        for(User value: listOfAllUsers){
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

