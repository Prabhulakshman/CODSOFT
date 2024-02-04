package Task3;
//Import Statement used to get HashMap
import java.util.HashMap;
//Acount_Holder Interface contains ATM Number and Secret Pin 
//Data Security is Achieved with the help of Abstraction using Abstract Interface as a Super Interface where all the Abstract methods were Implemented with a help of User as a Concrete Class.
//Abstract Super Interface
interface Account_Holder {
	//getatm_details() accepts two parameters such as atm_no and pin
	//atm_no contains usually 16 characters that's why we are storing it in Long Data Type and pin consist of 4 characters so,we are using Integer Data Type
	void getatm_details(long atm_no,int pin);
	//check() accepts two arguments such as atm_no and pin which is used to check whether the Data is Already present in the Database
	public  boolean check(long atm_no,int pin);
	
}
//Concrete Sub Class or Implementation Class
class User implements Account_Holder{
	//We are Initializing atm_no and pin with Default Value as Private Non-Static Variables
	//Private Keyword is used to Ensure the Security of these Variables which cannot be Accessed outside the Scope of Class
	 private long atm_no=0l;
	 private int pin=0;
	 public boolean inspect(long atm_no,int pin)
	 {
		 if(Long.toString(atm_no).length()==16 && Integer.toString(pin).length()==5)
		 {
			 return true;
		 }
		 return false;
	 }
	//HashMap is a Type of Collections used to store Key and Value Pair Respectively
	 //Generic were used to Accept only Long Data Type and Integer Data Type for Key and Value arguments
	 HashMap<Long,Integer> acc_list=new HashMap<Long,Integer>();
	//@Override is a Standard Annotation in Java which is not a Mandatory one but using it is a Good Practice
	@Override
	public void getatm_details(long atm_no,int pin)
	{
		this.atm_no=atm_no;
		this.pin=pin;
		boolean result=inspect(atm_no,pin);
		if(result)
		{
		//List_Name.put(key,value) into a HashMap
		acc_list.put(atm_no,pin);
		}
		else
		{
			System.out.println("ATM Number must contain 16 Characters and Pin Number should contain 5 Characters.Re Enter Valid ATM Number and Pin Number");
		}
		
	}
	@Override
	//check() returns a Boolean Value 
	public  boolean check(long atm_no,int pin)
	{
		boolean validate=false;
		if(acc_list.containsKey(atm_no) && acc_list.containsValue(pin))
		{
			validate=true;
		}
		return validate;
	}

	
	
}

