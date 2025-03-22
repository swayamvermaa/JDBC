import java.sql.*;
public class prepaidup{
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
            // using prepaid statement for retrive data query
            String query = "update students set marks = ? where id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setDouble(1,38.9);
            preparedStatement.setInt(2,3);
            int rowsAffected = preparedStatement.executeUpdate();
            if(rowsAffected>0){
                System.out.println("data updated successfully");
            }else{
                System.out.println("data not updated successfully");
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}        