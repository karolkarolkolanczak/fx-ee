package Controller;

import javax.annotation.Resource;
import javax.naming.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.*;

@WebServlet("/TestConnectionServlet")
public class TestConnectionServlet extends HttpServlet {

//    @Resource(lookup = "java:/fxdatabase")
//    private DataSource dataSource;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        Connection connection=null;
        Statement statement=null;
        ResultSet resultSet=null;


        try {

//            connection=dataSource.getConnection();
//            connection= DriverManager.getConnection("jdbc:mysql://hostname:port/dbname","username", "password");
            connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/fxdatabase?useSSL=false&useLegacyDatetimeCode=false&serverTimezone=UTC","admin", "admin");

            System.out.println(connection.getClientInfo()+" | "+connection.getMetaData());
            statement=connection.createStatement();
            String sql="select * from partner";
            resultSet=statement.executeQuery(sql);

            while(resultSet.next()) {
                System.out.println("----" + resultSet.getString("email"));
                System.out.println("KONIECCCCCCCC");
            }
        } catch (SQLException e) {
            System.out.println("%%%%%%: "+e.getMessage()+" | "+e.getSQLState()+" | "+e.getLocalizedMessage()+" | "+e.getStackTrace());

        }


    }
}
