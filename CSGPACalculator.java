package acornapplication;

import java.text.DecimalFormat;
import java.util.Scanner;

public class CSGPACalculator {

	public static void main(String[] args) {
		// Total points / total credits
		// points for a class = grade value * credits
		// A = 4, B= 3, C= 2, D= 1, F= 0
		Scanner scanner = new Scanner(System.in);
		
		int totalPoints = 0;
		int totalCredits =0;
		
		boolean moreClasses= false;
		
		do {
			int credits = 0;
			boolean validCredits = true;
			do {
				validCredits = true;
				
				System.out.println("Enter number of credits: ");
				String creditsString = scanner.nextLine();
				
				try {
					credits = Integer.parseInt(creditsString);
				}
				catch(NumberFormatException nfe) {
					System.out.println("please enter a valid interger");
					validCredits = false;
				}
			}
			while(!validCredits);
			
			
			
			boolean validGrade = true;
			
			Integer gradeValue = 0;
			String grade = "";
			do {
				validGrade = true;
				
				System.out.println("Enter grade:");
				grade = scanner.nextLine();
				
				if(grade.equalsIgnoreCase("A")) {
					gradeValue = 4;
				}else if (grade.equalsIgnoreCase("B")) {
					gradeValue = 3;
				}else if(grade.equalsIgnoreCase("C")) {
					gradeValue = 2;
				}else if(grade.equalsIgnoreCase("D")) {
					gradeValue = 1;
				}else if(grade.equalsIgnoreCase("F")) {
					gradeValue = 0;
				}else {
					System.out.println("you didn't enter a valid grade: (");
					validGrade = false;
				}
			}
			while(!validGrade);
			
			Integer points = gradeValue * credits;
			
			totalPoints += points;
			totalCredits += credits;
					
			System.out.println("would you like to enter another class?(Y/NO)");
			String moreClassesString = scanner.nextLine();
			
			moreClasses = moreClassesString.equalsIgnoreCase("Y");
			
		}
        while(moreClasses);
		
         DecimalFormat df = new DecimalFormat("0.00");
		
		Double gpa = Double.valueOf(totalPoints)/Double.valueOf(totalCredits);
		
		System.out.println("credits:" + totalCredits);
		System.out.println("points:" + totalPoints);
		System.out.println("GPA:" +df.format(gpa));
		
		scanner.close();
		
		// GO HATTERS
		// Program By : Cornelius Mulyokela
		
	}

}
