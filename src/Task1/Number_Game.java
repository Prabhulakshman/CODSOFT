package Task1;
import java.util.Random;
import java.util.Scanner;
public class Number_Game {
	public static void guess()
	{
		while(true)
		{
			//Generate a Random Number within a specified range such as 1 to 100
			Random rand=new Random();
			int min=1;
			int max=100;
			int rno=rand.nextInt(max-min+1);
			System.out.println(rno);
			int max_limit=5;
			System.out.println("welcome to Number Guessing Game.\nI guessed a random number between a range of 1 to 100.\nTry to guess the random number correctly and Remember! You have 5 limits to guess the random number.\nEnter your Guess for Generated Random Number: ");
			int count;
			for(count=1;count<=max_limit;count++)
			{
				
				if(count<= max_limit)
				{
					//Prompt the user to enter their guess for generated number
					Scanner scan=new Scanner(System.in);
					int uno=scan.nextInt();
					System.out.println("User Guessed Number is: "+uno);
					
					//Compare the user's guess with generated number
					if(uno==rno)
					{
						System.out.println("Your guessed number is Correct.Congratulations :)");
						System.out.println("Number of attempts taken you to won is "+count);
						break;
					}
					else if(uno>rno)
					{
						System.out.println("Your guessed number is Too High.Try again :( ");
					}
					else if(uno<rno)
					{
						System.out.println("Your guessed number is Too Low.Try again  :( ");
					}
				}
				System.out.println("Number of attempts taken is "+count);	
			}
			//System.out.println("Sorry! You had exceeded the maximum limit.Play again!");
			
		}
		
	}
	public static void main(String[] args) {
		guess();
		}
}
