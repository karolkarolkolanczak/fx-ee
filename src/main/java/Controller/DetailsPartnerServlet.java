package Controller;

import Model.ClosedTradesTransaction;
import Model.ClosedTradesTransactionStrategy1;
import Model.Partner;
import Utility.ObjectPersist;
import Utility.StrategyChooser;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by a on 20/06/2017.
 */
@WebServlet("/DetailsPartnerServlet")
public class DetailsPartnerServlet extends HttpServlet{

    ObjectPersist objectPersist;
    Partner partner;
    List<ClosedTradesTransaction> closedTradesTransactionslist;
    StrategyChooser strategyChooser;

    public DetailsPartnerServlet() {
        objectPersist=new ObjectPersist();
        closedTradesTransactionslist=new ArrayList<>();
        strategyChooser=new StrategyChooser();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        partner = new Partner();
        String className=partner.getClass().getSimpleName().toLowerCase();
        int partnerId= Integer.parseInt(request.getParameter("parameterPartnerId"));
        partner=(Partner)objectPersist.findObjectById(partnerId);
        closedTradesTransactionslist=objectPersist.getClosedTradesTransactionslist(strategyChooser.getClosedTradesStrategyNewObjectByChosenStrategyNumber(partner.getClosedTradesTransactionStrategyNumber()));

        request.setAttribute("partnerDetails",partner);
        request.setAttribute("closedTradesTransactionslist", closedTradesTransactionslist);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/partnerDetails.jsp");
        dispatcher.forward(request, response);
    }
}
