package Controller;

import Model.Partner;
import Utility.ObjectPersist;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by a on 20/06/2017.
 */
@WebServlet("/GoToAdminServlet")
public class GoToAdminServlet extends HttpServlet {

    List<Partner> listOfAllPartners;
    ObjectPersist objectPersist;

    public GoToAdminServlet() {
        objectPersist =new ObjectPersist();
        listOfAllPartners=new ArrayList<>();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        listOfAllPartners= objectPersist.getListOfAllPartners();
        request.setAttribute("listOfAllPartners", listOfAllPartners);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/admin.jsp");
        dispatcher.forward(request, response);
    }
}