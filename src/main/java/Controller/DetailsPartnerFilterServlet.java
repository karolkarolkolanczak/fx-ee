package Controller;

import Model.ClosedTradesTransaction;
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
    StrategyChooser strategyChooser;
    float totalLotsTurnoverForPeriod;

    public DetailsPartnerFilterServlet() {
        objectPersist=new ObjectPersist();
        closedTradesTransactionslist=new ArrayList<>();
        strategyChooser=new StrategyChooser();

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        partner = new Partner();
        String className=partner.getClass().getSimpleName().toLowerCase();
        int partnerId= Integer.parseInt(request.getParameter("parameterPartnerId"));
        String closedTradesFrom=request.getParameter("closedTradesFrom");
        String closedTradesTo=request.getParameter("closedTradesTo");
        partner=(Partner)objectPersist.findObjectById(partnerId);
        closedTradesTransactionslist=  objectPersist.getClosedTradesTransactionslistFiltered(strategyChooser.getClosedTradesStrategyNewObjectByChosenStrategyNumber(partner.getClosedTradesTransactionStrategyNumber()),closedTradesFrom,closedTradesTo);
        totalLotsTurnoverForPeriod=0;
        float totalLotsTurnoverForPeriod=sum();
        float totalBonusForPeriod=16 *totalLotsTurnoverForPeriod;

        request.setAttribute("closedTradesFrom",closedTradesFrom);
        request.setAttribute("closedTradesTo",closedTradesTo);
        request.setAttribute("partnerDetails",partner);
        request.setAttribute("closedTradesTransactionslist", closedTradesTransactionslist);
        request.setAttribute("totalLotsTurnoverForPeriod",totalLotsTurnoverForPeriod);
        request.setAttribute("totalBonusForPeriod",totalBonusForPeriod);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/partnerDetails.jsp");
        dispatcher.forward(request, response);
    }
    float sum(){
        for(int i=0;i<closedTradesTransactionslist.size();i++){
            totalLotsTurnoverForPeriod= (float) (totalLotsTurnoverForPeriod+closedTradesTransactionslist.get(i).getLots());
        }
        return totalLotsTurnoverForPeriod;
    }
}
