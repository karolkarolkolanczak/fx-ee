package Model;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class PartnerDataUtil {
    List<Partner> listOfPartners =new ArrayList<>();

    public List<Partner> getListOfAllPartners(){

//        listOfPartners.add(new Partner("ala","nowak","234@wp.pl"));
//        listOfPartners.add(new Partner("zenek","wiaderek","345@wp.pl"));
//        listOfPartners.add(new Partner("wojtek","ccc","456@wp.pl"));

        String sql = "select * from partner";
        ConnectionDbUtil connectionDbUtil =new ConnectionDbUtil();
        listOfPartners=connectionDbUtil.getListOfPartners(sql);

        return listOfPartners;
    }



    public List<Partner> addToListOfPartners(List<Partner> listOfPartners, Partner partner){
        listOfPartners.add(partner);
        return listOfPartners;
    }

}
