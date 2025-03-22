import java.sql.*;
public class prepaidinsert{
    private static final String url="jdbc:mysql://localhost:3306/JDBC";
    private static final String username="root";
    private static final String password="vermaswayam@225346";
    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        try{
            Connection connection = DriverManager.getConnection(url, username, password);
            // Statement statement = connection.createStatement();
            // using prepaid statement for insert query
            String query = "insert into students(name, age, marks) values(?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,"ankita");
            preparedStatement.setInt(2,26);
            preparedStatement.setDouble(3,88.8);
            int rowsAffected = preparedStatement.executeUpdate();
            if(rowsAffected>0){
                System.out.println("data inserted successfully");
            }else{
                System.out.println("data not inserted successfully");
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}        