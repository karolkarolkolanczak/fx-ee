package Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.sql.DataSource;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class ConnectionDbUtil {

    DataSource dataSource;

    public ConnectionDbUtil() {
        dataSource = getMySQLDataSource();
    }

    public List<Partner> getListOfPartners(String sql) {
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
//            sql = "select * from partner";
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

                Partner tempPartner = new Partner(partnerId, firstName, lastName,login,password, email);

                listOfPartners.add(tempPartner);
            }

        } catch (SQLException e) {
            System.out.println("%%%%%%: " + e.getMessage() + " | " + e.getSQLState() + " | " + e.getLocalizedMessage() + " | " + e.getStackTrace());
        } finally {
            close(connection, statement, resultSet);
            System.out.println("KONIECCCCCCCC");
        }
        return listOfPartners;
    }

    public static DataSource getMySQLDataSource() {

        MysqlDataSource mysqlDataSource = new MysqlDataSource();
        mysqlDataSource.setURL("jdbc:mysql://localhost:3306/fxdatabase");
        mysqlDataSource.setUser("admin");
        mysqlDataSource.setPassword("admin");

        return mysqlDataSource;
    }

    private void close(Connection connection, Statement statement, ResultSet resultSet) {
        try {
            if (resultSet != null) resultSet.close();
            if (statement != null) statement.close();
            if (connection != null) connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
