package mulyo;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SimpleToDoList {
	public static ArrayList<String> tasks=new ArrayList();
	public static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		//Scanner scanner = new Scanner(System.in);
		List<String> tasks1;
		boolean running=true;
		while(running==true) {
			   System.out.println("\n..........TO DO LIST.............\n");
			   System.out.println("1. Add task");
			   System.out.println("2. Delete task");
			   System.out.println("3. View all tasks");
			   System.out.println("4. Quit");
			   System.out.println("\nEnter choice: ");
			   int choice = scanner.nextInt();
			   scanner.nextLine();
			   
			   switch(choice) {
			     case 1:
				   addTask();
				   break;
			     case 2:
				   deleteTask();
				   break;
			     case 3:
				   displayTasks();
				   break;
			     case 4:
				   running = false;
				   break;
			     default:
				  System.out.println("Invalid choice");
				  break;
				  
			  }
		  }
		scanner.close();
	}
	

   private static void addTask() {
	   System.out.println("\nEnter task: ");
	   String task = scanner.nextLine();
	   tasks.add(task);
	   System.out.println("Task added succesfully");
	   //scanner3.close();
	   
   }
   
   private static void deleteTask() {
	   System.out.println("\nEnter task number to delete");
	   int taskNum = scanner.nextInt();
	   scanner.nextLine();
	   if(taskNum>0 && taskNum<=tasks.size()) {
		   tasks.remove(taskNum-1);
		   System.out.println("Task deleted succesfuly");
	   }
	   else {
		   System.out.println("Invalid task number");
	   }
   }
   
   private static void displayTasks() {
	   if(tasks.isEmpty()) {
		   System.out.println("No tasks to display");
	   }
	   else {
		   for(int i =0;i<tasks.size();i++) {
			   System.out.println((i+1) + "." + tasks.get(i));
			   
			   
			   //GO HATTERS
			   // PROGRAM BY: Cornelius Mulyokela
		   }
	   }
   }
}

