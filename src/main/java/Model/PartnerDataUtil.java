package Model;


import java.util.ArrayList;
import java.util.List;

public class PartnerDataUtil {
    List<Partner> listOfPartners;



    public List<Partner> getListOfPartners(){

        List<Partner> listOfPartners=new ArrayList<>();
        listOfPartners.add(new Partner("ala","nowak","234@wp.pl"));
        listOfPartners.add(new Partner("zenek","wiaderek","345@wp.pl"));
        listOfPartners.add(new Partner("wojtek","ccc","456@wp.pl"));
        return listOfPartners;
    }

    public List<Partner> addToListOfPartners(List<Partner> listOfPartners, Partner partner){
        listOfPartners.add(partner);
        return listOfPartners;
    }

}
