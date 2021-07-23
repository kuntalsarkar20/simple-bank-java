import java.sql.*;

public class JDBCConnection {
    private static final String url = "jdbc:mysql://localhost:3306/java_test";
    private static Statement statement=null;
    protected static Statement getConnection(){
        try{
            Connection connection = DriverManager.getConnection(url, "root","");
            statement = connection.createStatement();
//            ResultSet resultSet = statement.executeQuery("Select * from customers");
//            while (resultSet.next()) {
//                System.out.println(resultSet.getString("cname"));
//            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return statement;
    }
}
