import java.sql.*;
public class delete{
    private static final String url="jdbc:mysql://localhost:3306/JDBC";
    private static final String username="root";
    private static final String password="*************";
    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        try{
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            String query = "delete from students where id=2";
            int rowsAffected = statement.executeUpdate(query);
            if(rowsAffected>0){
                System.out.println("data deleted successfully");
            }else{
                System.out.println("data not deleted successfully");
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}        
