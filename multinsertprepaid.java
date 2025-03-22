import java.sql.*;
import java.util.Scanner;
public class multinsertprepaid {
    private static final String url="jdbc:mysql://localhost:3306/JDBC";
    private static final String username="root";
    private static final String password="************";
    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        try{
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            Scanner sc = new Scanner(System.in);
            String query = "insert into students(name, age, marks) values(?, ?, ?)";
            PreparedStatement preparedstatement = connection.prepareStatement(query);
            while(true){
                System.out.println("ENTER NAME: ");
                String name = sc.nextLine();
                // sc.next();
                System.out.println("ENTER AGE: ");
                int age = sc.nextInt();
                System.out.println("ENTER MARKS: ");
                Double marks = sc.nextDouble();
                System.out.println("insert more (Y/N)");
                sc.nextLine();
                String input = sc.nextLine();
                statement.addBatch(query);
                preparedstatement.setString(1, name);
                preparedstatement.setInt(2, age);
                preparedstatement.setDouble(3, marks);
                preparedstatement.addBatch();
                if(input.toUpperCase().equals("N")){
                    break;
                }
            }
            sc.close();
            int[] arr = preparedstatement.executeBatch();
            for(int i = 0; i<=arr.length-1; i++){
                if(arr[i]==0){
                    System.out.println("not executed data detail : "+ i);
                }else{
                    System.out.println("execute data detail number : "+i);
                }
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}        
