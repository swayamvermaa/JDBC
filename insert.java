import java.sql.*;
public class insert{
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
            Statement statement = connection.createStatement();
            String query = String.format("insert into students(name, age, marks) values('%s', %o, %f)","rahul",26,74.5); 
            int rowsAffected = statement.executeUpdate(query);
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