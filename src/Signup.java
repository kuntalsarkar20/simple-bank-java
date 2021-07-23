import java.util.Scanner;

public class Signup extends JDBCConnection {
    private String name,password;
    void takeUserDetails(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Please Enter Your Name: ");
        name = sc.nextLine();
        System.out.println("Please Enter your Preferred Password: ");
        password = sc.nextLine();
        System.out.println("Your entered details are following: \n Name: " + name +
                "\n Password: " + password);
        if(name != null && !name.isEmpty() && password != null && !password.isEmpty()){
            try {
                getConnection().executeUpdate("Insert into customers(cname,password) " +
                        "values('"+ name + "','" + password +"')");
                System.out.println("Account Created Successfully. Please login " +
                        "to continue.");
                Login.userOptions();
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }else{
            System.out.println("Name or Password field can't be Null");
        }
    }
    void showUserOptions(){

    }
}
