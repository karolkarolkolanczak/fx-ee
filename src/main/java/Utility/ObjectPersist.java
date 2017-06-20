package Utility;

import Model.Partner;
import Model.User;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by a on 2017-06-01.
 */
public class ObjectPersist {

// @PersistenceContext(unitName = "fxdatabase-persistence-unit")
// private EntityManager entityManager;
     EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("fxdatabase-persistence-unit");
     EntityManager entityManager = entityManagerFactory.createEntityManager();

    public ObjectPersist(){
    }

////        String sql = "INSERT INTO `fxdatabase`.`partner` (`idPartner`,`firstName`,`lastName`,`login`,`password`,`email`) VALUES (null,?,?,?,?,?)";

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

     public void addObject(Object object){

        entityManager.getTransaction().begin();

//        partner.setFirstName("z");
//        partner.setLastName("z");
//        partner.setEmail("z");
//        partner.setLogin("z");
//        partner.setPassword("z");
        entityManager.persist(object);

        entityManager.getTransaction().commit();
         System.out.println("--------------------- ADDING ---------------");
//        getListOfAllPartners();
//        entityManager.close();
    }

    public void deleteObject(String className, int id){

        String queryString="DELETE FROM "+className+" WHERE partnerId ="+id;
        Query query=entityManager.createNativeQuery(queryString);

        entityManager.getTransaction().begin();
        query.executeUpdate();
        entityManager.getTransaction().commit();
    }
}