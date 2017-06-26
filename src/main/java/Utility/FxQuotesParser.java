package Utility;

import Model.QuotesData;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.URL;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by a on 22/06/2017.
 */
// JSON Parser
public class FxQuotesParser {

    List<QuotesData>listOfQuotes=new ArrayList<>();

    public FxQuotesParser() {
    }

    public List <QuotesData> getListOfQuotes() throws Exception {

        String dataFromUrl = readJsonFromUrl("https://quotes.instaforex.com/api/quotesTick?m=json");

        Gson gson = new Gson();

        Type type = new TypeToken<List<QuotesData>>() {}.getType();

        listOfQuotes = gson.fromJson(dataFromUrl, type);

        for(QuotesData value: listOfQuotes){
            System.out.println("SYMBOL:  "+value.getSymbol()+" | ask: "+value.getAsk()+" | bid: "+value.getBid()+" | "+value.getChange());
        }
        return listOfQuotes;
    }

    static String readJsonFromUrl(String urlString) throws Exception {
        BufferedReader reader = null;
        try {
            URL url = new URL(urlString);
            reader = new BufferedReader(new InputStreamReader(url.openStream()));
            StringBuffer buffer = new StringBuffer();
            int read;
            char[] chars = new char[1024];
            while ((read = reader.read(chars)) != -1)
                buffer.append(chars, 0, read);

            return buffer.toString();
        } finally {
            if (reader != null)
                reader.close();
        }
    }
}
