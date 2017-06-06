package Utility;

import Model.Partner;
import Model.User;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by a on 2017-06-01.
 */
public class ConnectionDbUtil {

// @PersistenceUnit(unitName = "fxdatabase-persistence-unit")
// EntityManager entityManager;
     EntityManagerFactory emf = Persistence.createEntityManagerFactory("fxdatabase-persistence-unit");
     EntityManager entityManager = emf.createEntityManager();

    public ConnectionDbUtil(){
    }






////        String sql = "INSERT INTO `fxdatabase`.`partner` (`idPartner`,`firstName`,`lastName`,`login`,`password`,`email`) VALUES (null,?,?,?,?,?)";
//


    public  List<User> getListOfAllUsers(){

        List<User> listOfAllUsers=new ArrayList<>();
        Query query = entityManager.createQuery(" SELECT e FROM User e", User.class);

        listOfAllUsers=query.getResultList();

//        for(User value: listOfAllUsers){
//            System.out.println("--- USERS --"+value.getLogin()+" "+value.getEmail());
//        }
        return listOfAllUsers;
    }

     public List<Partner> getListOfAllPartners(){

        List<Partner> listOfAllPartners=new ArrayList<>();
        Query query = entityManager.createQuery(" SELECT e FROM Partner e", Partner.class);

        listOfAllPartners=query.getResultList();

//        for(Partner value: listOfAllPartners){
//            System.out.println("--- Partners --"+value.getLogin()+" "+value.getEmail());
//        }
        return listOfAllPartners;
    }

     public void addPartner(Partner partner){

        entityManager.getTransaction().begin();

//        partner.setFirstName("z");
//        partner.setLastName("z");
//        partner.setEmail("z");
//        partner.setLogin("z");
//        partner.setPassword("z");
        entityManager.persist(partner);

        entityManager.getTransaction().commit();
         System.out.println("--------------------- ADDING ---------------");
//        getListOfAllPartners();
//        entityManager.close();
    }
}