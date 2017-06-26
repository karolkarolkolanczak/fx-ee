package Utility;

import Model.ClosedTradesTransaction;
import com.opencsv.CSVReader;

import javax.validation.constraints.NotNull;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * Created by a on 26/06/2017.
 */
// using open source APIs for working with "CSV – OpenCSV"
// description: http://opencsv.sourceforge.net/
// download: https://sourceforge.net/projects/opencsv/
public class ClosedTradesTransactionCsvReader {
    static int counter =1000;
    private List<ClosedTradesTransaction> closedTradesTransactionslist;

    // musi to byc by zlapac sciezke relatywna  zklonowana w targecie w "WEB-INF/classes/eurusd.csv"
    URL u = this.getClass().getResource("/closedTradesEurUsdStrategy1.csv");
    String urlToString = u.toString().substring(5); // to by obciac tekst "vfs..."

    public ClosedTradesTransactionCsvReader() throws IOException, ParseException {
        System.out.println("===== urlToString: " + urlToString);

//System.out.println("+++++++++++"+u.getPath());
        closedTradesTransactionslist = new ArrayList<>();

//  CSVReader reader = new CSVReader(new FileReader("C:\\java\\EEFive\\src\\main\\resources\\eurusd.csv"), ',');
//CSVReader reader = new CSVReader(new FileReader("C:\\java3\\1part-java\\src\\main\\java\\com\\projectForex\\data\\eurusd.csv"), ',');
        CSVReader reader = new CSVReader(new FileReader(urlToString), ',');

        //read all lines at once
        List<String[]> records = reader.readAll();

        Iterator<String[]> iterator = records.iterator();
        //skip header row
        iterator.next();

        while (iterator.hasNext()   && counter>0 ) {
            counter--;
            System.out.println("COUNTER: "+counter);
            String[] record = iterator.next();
            ClosedTradesTransaction closedTradesTransaction = new ClosedTradesTransaction();

                //              0          1        2     3     4     5  6       7           8       9     10      11                                               12
//          Open Date,Close Date,Symbol,Action,Lots, SL, TP, Open Price,Close Price,Pips,Profit,Duration (DD:HH:MM:SS),Change %
                SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
                String dateInString1 = record[0].substring(0, 10);
                String dateInString2 = record[1].substring(0, 10);
                Date opendate = formatter.parse(dateInString1);
                Date closedate = formatter.parse(dateInString2);
                double lots = Double.parseDouble(record[4]);
                double openPrice = Double.parseDouble(record[7]);
                double closePrice = Double.parseDouble(record[8]);
                double profit = Double.parseDouble(record[10]);
                System.out.println("opendate: " + opendate + " " + opendate.getClass() + " | closedate:" + closedate + " | symbol:" + record[2] + " | action: " + record[3] + " | lots: " + lots + " | open price: " + openPrice + " | close price: " + closePrice + " | profit: " + profit);

                try {
                    closedTradesTransaction.setOpenDate(opendate);
                    closedTradesTransaction.setCloseDate(closedate);
                    closedTradesTransaction.setSymbol(record[2]);
                    closedTradesTransaction.setAction(record[3]);
                    closedTradesTransaction.setLots(lots);
                    closedTradesTransaction.setOpenPrice(openPrice);
                    closedTradesTransaction.setClosePrice(closePrice);
                    closedTradesTransaction.setProfit(profit);
//                                             forexTradings(record[3]);
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println(e);
                }
                closedTradesTransactionslist.add(closedTradesTransaction);

        }

        reader.close();

    }

    public List<ClosedTradesTransaction> getClosedTradesTransactionslist() {
        return closedTradesTransactionslist;
    }



}
