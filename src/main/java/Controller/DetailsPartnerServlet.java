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
import java.util.Date;
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
    float totalLotsTurnoverForPeriod;

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
        String closedTradesFrom="2017-01-01";
        String closedTradesTo="2017-06-30";
//        closedTradesTransactionslist=objectPersist.getClosedTradesTransactionslist(strategyChooser.getClosedTradesStrategyNewObjectByChosenStrategyNumber(partner.getClosedTradesTransactionStrategyNumber()));
        closedTradesTransactionslist=  objectPersist.getClosedTradesTransactionslistFiltered(strategyChooser.getClosedTradesStrategyNewObjectByChosenStrategyNumber(partner.getClosedTradesTransactionStrategyNumber()),closedTradesFrom,closedTradesTo);
        //        W przypadku pary walutowej EURUSD stawka bonusowa dla Partnera wynosi 16 USD za 1 Lota. Zatem za dany okres Partner otrzyma: USD 16 * 3,84 Lota = USD 61.44 .

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
