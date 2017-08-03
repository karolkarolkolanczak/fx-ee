package Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * Created by a on 2017-05-02.
 */
public class Session {

    HttpSession getSession(HttpServletRequest request){
        HttpSession session=request.getSession(true);
        Date createTime = new Date(session.getCreationTime());
        Date lastAccessTime = new Date(session.getLastAccessedTime());
        System.out.println(session.toString());
        return session;
    }
}
