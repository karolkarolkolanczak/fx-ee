package Utility;

import Model.Partner;

import java.util.ArrayList;
import java.util.List;

public class PartnerDataUtil {
    List<Partner> listOfPartners =new ArrayList<>();
    ConnectionDbUtil connectionDbUtil =new ConnectionDbUtil();

    public List<Partner> getListOfAllPartners(){

//        listOfPartners.add(new Partner("ala","nowak","234@wp.pl"));
//        listOfPartners.add(new Partner("zenek","wiaderek","345@wp.pl"));
//        listOfPartners.add(new Partner("wojtek","ccc","456@wp.pl"));

        listOfPartners=connectionDbUtil.getListOfAllPartners();

        return listOfPartners;
    }

//    public void addToListOfPartners(Partner partner){
//        connectionDbUtil.addToListOfPartners(partner);
//    }

}
