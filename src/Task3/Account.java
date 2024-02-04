package Task3;
//Abstract Super Interface Account
public interface Account {
boolean validate=false;
//Storing a List of IFSC Code and Account Number in a Bank database Server
static String []ifsc= {"123SBI","357ICICI","680HDFC","3467LVB","673847MCB","55687AXIS"};
static String []acc_no= {"12345","3568","7654","7865","5432","5689"};
//Parameterized Abstract methods for Different Functions
//withdraw() is used for Amount Withdrawal
public  void withdraw(double amount);
//deposit() is used for Amount Deposit
public  void deposit(double amount);
//transaction() is used for Money Transaction among Different Accounts
public  void transaction(double amount,String ifsc,String acc_no);

}
