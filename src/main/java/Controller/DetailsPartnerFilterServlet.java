package Controller;

import Model.ClosedTradesTransaction;
import Model.Partner;
import Utility.ObjectPersist;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by a on 27/06/2017.
 */
@WebServlet("/DetailsPartnerFilterServlet")
public class DetailsPartnerFilterServlet extends HttpServlet{

    ObjectPersist objectPersist;
    Partner partner;
    List<ClosedTradesTransaction> closedTradesTransactionslist;

    public DetailsPartnerFilterServlet() {
        objectPersist=new ObjectPersist();
        closedTradesTransactionslist=new ArrayList<>();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        partner = new Partner();
        String className=partner.getClass().getSimpleName().toLowerCase();
        int partnerId= Integer.parseInt(request.getParameter("parameterPartnerId"));

        String closedTradesFrom=request.getParameter("closedTradesFrom");
        String closedTradesTo=request.getParameter("closedTradesTo");

        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!: "+closedTradesFrom+" "+closedTradesTo);
        partner=(Partner)objectPersist.findObjectById(partnerId);
        closedTradesTransactionslist=  objectPersist.getClosedTradesTransactionslistFiltered(closedTradesFrom,closedTradesTo);
        request.setAttribute("partnerDetails",partner);
        request.setAttribute("closedTradesTransactionslist", closedTradesTransactionslist);
        for(ClosedTradesTransaction value: closedTradesTransactionslist){
            System.out.println(value.getTransactionId()+" "+value.getCloseDate());
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("/partnerDetails.jsp");
        dispatcher.forward(request, response);
    }
}
