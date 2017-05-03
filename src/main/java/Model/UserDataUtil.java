package Model;

import java.util.ArrayList;
import java.util.List;

public class UserDataUtil {



  public  List<User> getListOfUsers(){

        List<User>listOfUsers=new ArrayList<>();

        listOfUsers.add(new User("ala","nowak","aaa","123","234@wp.pl"));
        listOfUsers.add(new User("zenek","wiaderek","bbb","123","345@wp.pl"));
        listOfUsers.add(new User("wojtek","ccc","wojo","456","456@wp.pl"));

     return listOfUsers;
    }
}
