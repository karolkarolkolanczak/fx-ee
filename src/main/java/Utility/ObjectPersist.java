package Utility;

import Model.ClosedTradesTransaction;
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

//        String sql = "INSERT INTO `fxdatabase`.`partner` (`idPartner`,`firstName`,`lastName`,`login`,`password`,`email`) VALUES (null,?,?,?,?,?)";

    public  List<User> getListOfAllUsers(){

        List<User> listOfAllUsers=new ArrayList<>();
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery(" SELECT e FROM User e", User.class);
        listOfAllUsers=query.getResultList();
        entityManager.flush();
        entityManager.clear();
        entityManager.getTransaction().commit();
//        for(User value: listOfAllUsers){
//            System.out.println("--- USERS --"+value.getLogin()+" "+value.getEmail());
//        }
        return listOfAllUsers;
    }

     public List<Partner> getListOfAllPartners(){

        List<Partner> listOfAllPartners=new ArrayList<>();

        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery(" SELECT e FROM Partner e", Partner.class);
        listOfAllPartners=query.getResultList();
        entityManager.flush();
        entityManager.clear();
        entityManager.getTransaction().commit();
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
        entityManager.flush();
        entityManager.clear();
        entityManager.getTransaction().commit();
    }

    public void addclosedTradesTransactionslist(List<ClosedTradesTransaction> closedTradesTransactionslist){

        for(int i=0;i< closedTradesTransactionslist.size();i++){
            entityManager.getTransaction().begin();
            // must be "entityManager.merge" instead "entityManager.persist " if not will be "detached entity passed to persist"
            entityManager.persist (closedTradesTransactionslist.get(i));
            entityManager.flush();
            entityManager.clear();
            entityManager.getTransaction().commit();
        }
    }

    public List<ClosedTradesTransaction> getClosedTradesTransactionslist(ClosedTradesTransaction closedTradesTransaction){
        List<ClosedTradesTransaction>closedTradesTransactionslist=new ArrayList<>();
        entityManager.getTransaction().begin();
        String queryString="SELECT e FROM "+closedTradesTransaction.getClass().getSimpleName()+" e";
        Query query = entityManager.createQuery(queryString, ClosedTradesTransaction.class);
        closedTradesTransactionslist=query.getResultList();
        entityManager.flush();
        entityManager.clear();
        entityManager.getTransaction().commit();
        return closedTradesTransactionslist;
    }

    public List<ClosedTradesTransaction> getClosedTradesTransactionslistFiltered(ClosedTradesTransaction closedTradesTransaction,String closedTradesFrom, String closedTradesTo){
        List<ClosedTradesTransaction>closedTradesTransactionslist=new ArrayList<>();
        entityManager.getTransaction().begin();
        String queryString="SELECT * FROM "+closedTradesTransaction.getClass().getSimpleName()+" WHERE closeDate between '"+closedTradesFrom+"' and '"+closedTradesTo+"'";
//        "SELECT * FROM ClosedTradesTransaction WHERE closeDate between '2017-01-01' and '2017-02-01'"
        Query query = entityManager.createNativeQuery(queryString, closedTradesTransaction.getClass());
        closedTradesTransactionslist=query.getResultList();
        entityManager.flush();
        entityManager.clear();
        entityManager.getTransaction().commit();
        return closedTradesTransactionslist;
    }

    public void deleteObject(String className, int id){

        String queryString="DELETE FROM "+className+" WHERE partnerId ="+id;
        Query query=entityManager.createNativeQuery(queryString);

        entityManager.getTransaction().begin();
        query.executeUpdate();
        entityManager.flush();
        entityManager.clear();
        entityManager.getTransaction().commit();
    }

    public void updateObject(Object object){

        Partner partner=(Partner) object;

        entityManager.getTransaction().begin();
        entityManager.merge(partner);
        entityManager.flush();
        entityManager.clear();
        entityManager.getTransaction().commit();
    }

    public Object findObjectById(int parnterId){

        entityManager.getTransaction().begin();
        Partner partner =new Partner();

        partner = entityManager.find(Partner.class, parnterId);
//      Query query=entityManager.createQuery("SELECT e FROM Partner e WHERE e.partnerId=4", Partner.class);
//      partner= (Partner) query.getSingleResult();
        entityManager.flush();
        entityManager.clear();
        entityManager.getTransaction().commit();
        return partner;
    }

}