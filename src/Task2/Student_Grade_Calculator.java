package Task2;
import java.util.Scanner;
public class Student_Grade_Calculator {
	public static double total_marks()
	{
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter your Subject 1 marks obtained: ");
		double subject_1=scan.nextDouble();
		System.out.println("Enter your Subject 2 marks obtained: ");
		double subject_2=scan.nextDouble();
		System.out.println("Enter your Subject 3 marks obtained: ");
		double subject_3=scan.nextDouble();
		System.out.println("Enter your Subject 4 marks obtained: ");
		double subject_4=scan.nextDouble();
		System.out.println("Enter your Subject 5 marks obtained: ");
		double subject_5=scan.nextDouble();
		scan.close();
		double total=(subject_1+subject_2+subject_3+subject_4+subject_5);
		return total;
		}
	//Method to Calculate Average Marks obtained
	public static double average_marks(double total)
	{
		double average=((total/500)*100);
		return average;
	}
	//Method to Assign Grade based on the Average Marks obtained
	public static String grade(double total)
	{
		double average=average_marks( total);
		if(average>90)
		{
			return "O";
		}
		else if(average>80 && average<=90)
		{
			return "A+";
		}
		else if(average>70 && average<=80)
		{
			return "A";
		}
		else if(average>60 && average<=70)
		{
			return "B+";
		}
		else if(average>60 && average<=70)
		{
			return "B";
		}
		else if(average>50 && average<=60)
		{
			return "C";
		}
		else 
		{
			return "F";
		}
	}
	public static void display()
	{
		double total=total_marks();
		String grade=grade(total);
		double average=average_marks(total);
		System.out.println("Total Marks: "+total);
		System.out.println("Average Percentage: "+average+"%");
		System.out.println("Grade Obtained: "+grade);
	}
	
	public static void main(String[] args) {
		display();
	}

}
