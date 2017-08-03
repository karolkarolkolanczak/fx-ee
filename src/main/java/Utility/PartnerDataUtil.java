package Utility;

import Model.Partner;

import java.util.ArrayList;
import java.util.List;

public class PartnerDataUtil {
    List<Partner> listOfPartners =new ArrayList<>();
    ObjectPersist objectPersist =new ObjectPersist();

    public List<Partner> getListOfAllPartners(){
        listOfPartners= objectPersist.getListOfAllPartners();
        return listOfPartners;
    }

}
