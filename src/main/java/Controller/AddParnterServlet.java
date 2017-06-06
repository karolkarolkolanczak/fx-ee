package Controller;

import Model.Partner;
import Utility.ConnectionDbUtil;
import Utility.PartnerDataUtil;


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
    ConnectionDbUtil connectionDbUtil;
    public AddParnterServlet() {

        sessionClass = new Session();
        listOfAllPartners = new ArrayList<>();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("----------- FROM ADD PARTNER SERVLET -----------");

        partner = new Partner();
        connectionDbUtil=new ConnectionDbUtil();

        session = sessionClass.getSession(request);

        System.out.println(request.getParameter("firstName"));

        partner.setFirstName(request.getParameter("firstName"));
        partner.setLastName(request.getParameter("lastName"));
        partner.setLogin(request.getParameter("login"));
        partner.setPassword(request.getParameter("password"));
        partner.setEmail(request.getParameter("email"));
//        partner.setJoinedDate((Date) request.getParameter("joinedDate")));

connectionDbUtil.addPartner(partner);

//        listOfPartners = partnerDataUtil.addToListOfPartners(listOfPartners, partner);

//        partnerDataUtil.addToListOfPartners(partner);


//        session.setAttribute("listOfPartners", listOfPartners);

//      System.out.println("FROM SESSION - LOGIN "+((User)session.getAttribute("userSessionData")).getLogin());
        System.out.println("-------ADDING END-----------");

        listOfAllPartners=connectionDbUtil.getListOfAllPartners();

        request.setAttribute("listOfAllPartners", listOfAllPartners);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/admin.jsp");
        dispatcher.forward(request, response);
    }


}
