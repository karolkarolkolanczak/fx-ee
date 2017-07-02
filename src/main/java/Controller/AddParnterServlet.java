package Controller;

import Model.Partner;
import Utility.ObjectPersist;


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

@WebServlet("/AddParnterServlet")
public class AddParnterServlet extends HttpServlet {

    Partner partner;
    List<Partner> listOfAllPartners;
    Session sessionClass;
    HttpSession session;
    ObjectPersist objectPersist;
    public AddParnterServlet() {

        sessionClass = new Session();
        listOfAllPartners = new ArrayList<>();
        objectPersist =new ObjectPersist();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        partner = new Partner();

        session = sessionClass.getSession(request);

        partner.setFirstName(request.getParameter("firstName"));
        partner.setLastName(request.getParameter("lastName"));
        partner.setLogin(request.getParameter("login"));
        partner.setPassword(request.getParameter("password"));
        partner.setEmail(request.getParameter("email"));
        partner.setClosedTradesTransactionStrategyNumber(Integer.parseInt(request.getParameter("transactionStrategy")));
//        partner.setJoinedDate((Date) request.getParameter("joinedDate")));

objectPersist.addObject(partner);

//        listOfPartners = partnerDataUtil.addToListOfPartners(listOfPartners, partner);

//        partnerDataUtil.addToListOfPartners(partner);


//        session.setAttribute("listOfPartners", listOfPartners);

//      System.out.println("FROM SESSION - LOGIN "+((User)session.getAttribute("userSessionData")).getLogin());
        System.out.println("-------ADDING END-----------");

        listOfAllPartners= objectPersist.getListOfAllPartners();

        request.setAttribute("listOfAllPartners", listOfAllPartners);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/admin.jsp");
        dispatcher.forward(request, response);
    }


}
