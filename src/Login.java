import java.sql.ResultSet;
import java.util.Scanner;

public class Login extends JDBCConnection {
    private static int userChoice = 0;
    static void userOptions(){
        userChoice = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("1. Login");
        System.out.println("2. Signup");
        System.out.println("3. Exit");
        System.out.print("Please Enter your choice: ");
        userChoice = sc.nextInt();
        switch (userChoice){
            case 1:
                checkLoginData();
                break;
            case 2:
                Signup sp = new Signup();
                sp.takeUserDetails();
                break;
        }
    }
    static void checkLoginData(){
        String name,password;
        int resultCount = 0,id=0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Your Name: ");
        name = sc.nextLine();
        System.out.println("Enter your Password: ");
        password = sc.nextLine();
        try {
            ResultSet resultSet = getConnection().executeQuery("select * from customers " +
                    "where cname = '" + name + "' and password = '" + password + "'");
            while (resultSet.next()) {
                resultCount++;
                if(resultCount == 1){
                    id = resultSet.getInt("cid");
                }
            }
            if(resultCount == 1){
                System.out.println("Login Successful");
                BankFunctions bf = new BankFunctions(id);
            }else{
                System.out.println("Name and Password doesn't matched");
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
    public static void main(String[] args) {
        userOptions();
    }
}
