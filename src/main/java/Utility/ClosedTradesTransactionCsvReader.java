package Utility;

import Model.ClosedTradesTransaction;
import Model.ClosedTradesTransactionStrategy1;
import Model.ClosedTradesTransactionStrategy2;
import com.opencsv.CSVReader;

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
    int counter =0;
    ClosedTradesTransaction closedTradesTransaction;
    List<ClosedTradesTransaction> closedTradesTransactionslist;
    StrategyChooser strategyChooser;

    public ClosedTradesTransactionCsvReader() {
        closedTradesTransaction=new ClosedTradesTransaction();
        closedTradesTransactionslist = new ArrayList<>();
        strategyChooser=new StrategyChooser();
    }

    public List<ClosedTradesTransaction> getClosedTradesTransactionslist(ClosedTradesTransaction closedTradesTransaction) throws IOException, ParseException {


        //        "/Transactions/closedTradesStrategy4.csv"
        URL u = this.getClass().getResource(closedTradesTransaction.getResource());

        String urlToString = u.toString().substring(5); // to by obciac tekst "vfs..."

        //  CSVReader reader = new CSVReader(new FileReader("C:\\java\\EEFive\\src\\main\\resources\\eurusd.csv"), ',');
        //CSVReader reader = new CSVReader(new FileReader("C:\\java3\\1part-java\\src\\main\\java\\com\\projectForex\\data\\eurusd.csv"), ',');
        CSVReader reader = new CSVReader(new FileReader(urlToString), ',');

        //read all lines at once
        List<String[]> records = reader.readAll();

        Iterator<String[]> iterator = records.iterator();
        //skip header row
        iterator.next();

            while (iterator.hasNext() && counter < 100) {

                ClosedTradesTransaction closedTradesTransactionTemp=new ClosedTradesTransaction();

                closedTradesTransactionTemp=strategyChooser.getClosedTradesStrategyReferenceByObjectType(closedTradesTransaction);

                counter++;
                System.out.println("COUNTER: " + counter);
                String[] record = iterator.next();

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

                    closedTradesTransactionTemp.setOpenDate(opendate);
                    closedTradesTransactionTemp.setCloseDate(closedate);
                    closedTradesTransactionTemp.setSymbol(record[2]);
                    closedTradesTransactionTemp.setAction(record[3]);
                    closedTradesTransactionTemp.setLots(lots);
                    closedTradesTransactionTemp.setOpenPrice(openPrice);
                    closedTradesTransactionTemp.setClosePrice(closePrice);
                    closedTradesTransactionTemp.setProfit(profit);
//                                             forexTradings(record[3]);
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println(e);
                }
                closedTradesTransactionslist.add(closedTradesTransactionTemp);
            }

        reader.close();

        return closedTradesTransactionslist;
        }

    }
