import java.sql.*;
public class prepaidretrive{
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
            String query = "select marks from students where id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,1);
            // resultset use for data retrive
            ResultSet result = preparedStatement.executeQuery();
            if(result.next()){
                double marks = result.getDouble("marks");
                System.out.println("marks :"+marks);
            }else{
                System.out.println("not found");
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}        