package Utility;

import Model.ClosedTradesTransaction;
import Model.ClosedTradesTransactionStrategy1;
import Model.ClosedTradesTransactionStrategy2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by a on 28/06/2017.
 */
public class StrategyChooser {

    List<String> listOfClosedTradesStrategiesResources;
    List<ClosedTradesTransaction> listOfClosedTradesStrategies;
    ClosedTradesTransactionStrategy1 closedTradesTransactionStrategy1;
    ClosedTradesTransactionStrategy2 closedTradesTransactionStrategy2;

    public StrategyChooser() {
        listOfClosedTradesStrategiesResources=new ArrayList<>();
        listOfClosedTradesStrategies=new ArrayList<>();
        closedTradesTransactionStrategy1=new ClosedTradesTransactionStrategy1();
        closedTradesTransactionStrategy2=new ClosedTradesTransactionStrategy2();
    }

    public List<String> getListOfClosedTradesStrategiesResources(){
        listOfClosedTradesStrategiesResources.add("/Transactions/closedTradesStrategy1.csv");
        listOfClosedTradesStrategiesResources.add("/Transactions/closedTradesStrategy2.csv");
        return listOfClosedTradesStrategiesResources;
    }

    public List<ClosedTradesTransaction> getListOfClosedTradesStrategies(){
        listOfClosedTradesStrategies.add(closedTradesTransactionStrategy1);
        listOfClosedTradesStrategies.add(closedTradesTransactionStrategy2);
        return listOfClosedTradesStrategies;
    }

//    Object chooseClosedTradesStrategy(Object object){
//        if(object instanceof ClosedTradesTransactionStrategy1){
//            ClosedTradesTransaction closedTradesTransactionStrategy1=new ClosedTradesTransactionStrategy1();
//            return closedTradesTransactionStrategy1;
//        }
//    }


}


//public class Main {
//
//    public static void main(String[] args) {
//        method(new Dog());
//        method(new Bird());
//    }
//    static void method(Object object){
//        if(object.getClass().getSimpleName().equals(Bird.class.getSimpleName()) ){
//            Animal bird=new Bird();
//            System.out.println(((Bird)bird).x);
//            bird.print();
//        }
//        if(object  instanceof Dog){
//            Animal dog=new Dog();
//            System.out.println(((Dog)dog).x);
//            dog.print();
//        }
//    }
//}
//
//class Animal{
//    String x="animal";
//    void print(){
//        System.out.println("text from Animal");
//    }
//}
//class Bird extends Animal{
//    String x="Bird";
//    void print(){
//        System.out.println("text from Bird");
//    }
//}
//class Dog extends Animal{
//    String x="Dog";
//    void print(){
//        System.out.println("text from Dog");
//    }
//}

/// answer

//Dog
//text from Dog
//Bird
//text from Bird