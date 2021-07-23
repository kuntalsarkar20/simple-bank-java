public class BankFunctions extends JDBCConnection {
    private int cid = 0;
    BankFunctions(int id){
        cid = id;
        System.out.println("1. Balance Check");
        System.out.println("2. Transaction History");
        System.out.println("3. Withdrawal Fund");
    }
}
