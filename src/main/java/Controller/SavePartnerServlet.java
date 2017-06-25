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

/**
 * Created by a on 25/06/2017.
 */
@WebServlet("/SavePartnerServlet")
public class SavePartnerServlet extends HttpServlet {
    Partner partner;
    List<Partner> listOfAllPartners;
    Session sessionClass;
    HttpSession session;
    ObjectPersist objectPersist;
    public SavePartnerServlet() {

        sessionClass = new Session();
        listOfAllPartners = new ArrayList<>();
        objectPersist =new ObjectPersist();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        partner = new Partner();

        session = sessionClass.getSession(request);
        partner.setPartnerId(Integer.parseInt(request.getParameter("partnerId")));
        partner.setFirstName(request.getParameter("firstName"));
        partner.setLastName(request.getParameter("lastName"));
        partner.setLogin(request.getParameter("login"));
        partner.setPassword(request.getParameter("password"));
        partner.setEmail(request.getParameter("email"));
//        partner.setJoinedDate((Date) request.getParameter("joinedDate")));

        objectPersist.updateObject(partner);

        request.setAttribute("partnerDetails",objectPersist.findObjectById(partner.getPartnerId()));

        RequestDispatcher dispatcher = request.getRequestDispatcher("/editPartner.jsp");
        dispatcher.forward(request, response);
    }
}
