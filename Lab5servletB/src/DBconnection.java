
import java.sql.*;

public class DBconnection {
    private String dbURL = "jdbc:mysql://localhost:3306/servlets";
    private String username = "root";
    private String password = "";
    private Connection connection;
    public void DbConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(dbURL,username,password);
            if(connection!=null){
                System.out.println("Success");
            }
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void insertRecord(String fname, String firstName, String lastName, String email, String Address1, String Address2, String city, String state, String zipcode){
        try {
            String sqlQuery = "INSERT INTO student(firstname,lastname,phoneno,email,Address1,Address2,city,state,zipcode) VALUES(?,?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            preparedStatement.setString(3, email);
            preparedStatement.setString(4, Address1);
            preparedStatement.setString(5, Address2);
            preparedStatement.setString(6, city);
            preparedStatement.setString(7, state);
            preparedStatement.setString(8, zipcode);
            int noOfRowsInserted = preparedStatement.executeUpdate();
            if(noOfRowsInserted>0){
                System.out.println(noOfRowsInserted + " rows inserted!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
