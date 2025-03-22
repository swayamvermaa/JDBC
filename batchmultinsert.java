import java.sql.*;
import java.util.Scanner;
public class batchmultinsert {
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
            // query 8 : multiple insert using batch statement
            Scanner sc = new Scanner(System.in);
            while(true){
                System.out.println("ENTER NAME: ");
                String name = sc.nextLine();
                System.out.println("ENTER AGE: ");
                int age = sc.nextInt();
                System.out.println("ENTER MARKS: ");
                Double marks = sc.nextDouble();
                System.out.println("insert more (Y/N)");
                sc.nextLine();
                String input = sc.nextLine();
                String query = String.format("insert into students(name, age, marks) values('%s', %o, %f)", name, age, marks);
                statement.addBatch(query);
                if(input.toUpperCase().equals("N")){
                    break;
                }
            }
            sc.close();
            int[] arr = statement.executeBatch();
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