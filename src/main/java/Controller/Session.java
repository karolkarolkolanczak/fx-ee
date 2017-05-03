package Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * Created by a on 2017-05-02.
 */
public class Session {

    HttpSession getSession(HttpServletRequest request){
        System.out.println("IN SESSION METHOD");

        HttpSession session=request.getSession(true);
//
        Date createTime = new Date(session.getCreationTime());
//
        Date lastAccessTime = new Date(session.getLastAccessedTime());


        System.out.println(session.toString());
        System.out.println("Id: "+ session.getId());
        System.out.println("creation time: "+session.getCreationTime());
        System.out.println("names: "+session.getAttributeNames());
        System.out.println("is new? "+session.isNew());
        System.out.println("------------------");

        return session;
    }
}
