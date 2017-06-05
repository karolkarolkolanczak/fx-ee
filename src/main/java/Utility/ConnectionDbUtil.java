package Utility;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.sql.DataSource;

import Model.Partner;
//import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class ConnectionDbUtil {

    DataSource dataSource;

    public ConnectionDbUtil() {
//        dataSource = getMySQLDataSource();
    }

    public List<Partner> getListOfPartners() {
        List<Partner> listOfPartners = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = dataSource.getConnection();
//          connection= DriverManager.getConnection("jdbc:mysql://hostname:port/dbname","username", "password");
//          connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/fxdatabase?useSSL=false&useLegacyDatetimeCode=false&serverTimezone=UTC","admin", "admin");

            System.out.println(connection.getClientInfo() + " | " + connection.getMetaData());
            statement = connection.createStatement();
            String sql = "select * from partner";
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                System.out.println("----" + resultSet.getString("email"));

                // retrieve data from result set row
                int partnerId = resultSet.getInt("idPartner");
                String firstName = resultSet.getString("firstName");
                String lastName = resultSet.getString("lastName");
                String login=resultSet.getString("login");;
                String password=resultSet.getString("password");;
                String email = resultSet.getString("email");
//              Date joinedDate = resultSet.getString("joinedDate");

//                Partner tempPartner = new Partner(partnerId, firstName, lastName,login,password, email);

//                listOfPartners.add(tempPartner);
            }

        } catch (SQLException e) {
            System.out.println("%%%%%%: " + e.getMessage() + " | " + e.getSQLState() + " | " + e.getLocalizedMessage() + " | " + e.getStackTrace());
        } finally {
            close(connection, statement, resultSet);
            System.out.println(" - END OF GET ALL PARTNERS - ");
        }
        return listOfPartners;
    }

   public void addToListOfPartners(Partner partner){

        // http://alvinalexander.com/java/java-mysql-insert-example-preparedstatement
        // https://www.mkyong.com/jdbc/jdbc-preparestatement-example-insert-a-record/

        List<Partner> listOfPartners = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        PreparedStatement preparedStatement=null;

        try {
            connection = dataSource.getConnection();

            System.out.println(connection.getClientInfo() + " | " + connection.getMetaData());

            statement = connection.createStatement();

            String sql = "INSERT INTO `fxdatabase`.`partner` (`idPartner`,`firstName`,`lastName`,`login`,`password`,`email`) VALUES (null,?,?,?,?,?)";

            // create the mysql insert preparedstatement
            preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString (1, partner.getFirstName());
                preparedStatement.setString (2, partner.getLastName());
                preparedStatement.setString (3, partner.getLogin());
                preparedStatement.setString (4, partner.getPassword());
                preparedStatement.setString (5, partner.getEmail());

            // execute the preparedstatement
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.out.println("%%%%%%: " + e.getMessage() + " | " + e.getSQLState() + " | " + e.getLocalizedMessage() + " | " + e.getStackTrace());
        } finally {
            close(connection, statement, preparedStatement);
            System.out.println(" - END OF ADD NEW PARTNER - ");
        }
    }

//    public static DataSource getMySQLDataSource() {
//
//        MysqlDataSource mysqlDataSource = new MysqlDataSource();
//        mysqlDataSource.setURL("jdbc:mysql://localhost:3306/fxdatabase");
//        mysqlDataSource.setUser("admin");
//        mysqlDataSource.setPassword("admin");
//
//        return mysqlDataSource;
//    }

    private void close(Connection connection, Statement statement, ResultSet resultSet) {
        try {
            if (resultSet != null) resultSet.close();
            if (statement != null) statement.close();
            if (connection != null) connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private void close(Connection connection, Statement statement,PreparedStatement preparedStatement) {
        try {
            if (preparedStatement != null) preparedStatement.close();
            if (statement != null) statement.close();
            if (connection != null) connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
