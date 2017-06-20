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
 * Created by a on 19/06/2017.
 */
@WebServlet("/DeletePartnerServlet")
public class DeletePartnerServlet extends HttpServlet{

    ObjectPersist objectPersist;
    Partner partner;
    List<Partner> listOfAllPartners;

    public DeletePartnerServlet() {
        objectPersist=new ObjectPersist();
        listOfAllPartners = new ArrayList<>();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        partner = new Partner();
        String className=partner.getClass().getSimpleName().toLowerCase();
        int partnerId= Integer.parseInt(request.getParameter("parameterPartnerId"));

        objectPersist.deleteObject( className, partnerId);

        listOfAllPartners= objectPersist.getListOfAllPartners();

        request.setAttribute("listOfAllPartners", listOfAllPartners);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/admin.jsp");
        dispatcher.forward(request, response);
    }
}
