package Controller;

import Utility.FxQuotesParser;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

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
 * Created by a on 25/06/2017.
 */
@WebServlet("/QuotesData")
public class QuotesData extends HttpServlet {
    List<Model.QuotesData> listOfQuotes;
    FxQuotesParser fxQuotesParser;
    static int counter=0;

    public QuotesData() {
        listOfQuotes=new ArrayList<>();
        fxQuotesParser=new FxQuotesParser();
        System.out.println("   ------   COUNTERrrrrrrrrr: '"+counter+"'");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        counter++;
        System.out.println("   ?????   COUNTER: '"+counter+"'");

        try {
            listOfQuotes=fxQuotesParser.getListOfQuotes();
            request.setAttribute("listOfQuotes",listOfQuotes);
//            RequestDispatcher dispatcher=request.getRequestDispatcher("/currencyFeed.jsp");
//            dispatcher.forward(request,response);
//            RequestDispatcher dispatcher = request.getRequestDispatcher("/currencyFeed.jsp");
//            dispatcher.include(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
