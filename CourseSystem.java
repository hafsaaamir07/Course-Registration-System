import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;

public class CourseSystem implements Serializable { 
	public static void main (String[] args) throws IOException, ClassNotFoundException{
		
		Data.deserilize();
		
		Scanner input = new Scanner (System.in);
		int option = 0;
		String admin_user = "Admin";
		String admin_pass = "Admin001";
		String user="";
		String pass="";
		String stu_user="";
		String stu_pass="";
		Admin a = null;
		Student s = null;
		String ans="";
		
		
  System.out.println("Welcome!");
	System.out.println(" If you are admin pls type 'admin' and for student pls type 'stu'");
	ans = input.next();
	if (ans.equalsIgnoreCase("admin")) {
	
		while (true) {
			if (!user.equalsIgnoreCase(admin_user)&& !pass.equalsIgnoreCase(admin_pass)) {
				System.out.println("Enter username: ");
				user = input.next();
				System.out.println("Enter password: ");
				pass = input.next();
				
				System.out.println();
					
			}
			else {
				break;
			}
		}
		if (user.equalsIgnoreCase(admin_user)&&pass.equalsIgnoreCase(admin_pass)) {
			System.out.println("Welcome You are logged in as admin!");
			do {
				System.out.println("\n1. Course Mangement\n2. Reports\n3. Exit");
				System.out.println("Please pick an option!");
				option = input.nextInt();
					if (option == 1) {
						do {
							System.out.println("Please pick an option: ");
							System.out.println("1. Create new course");
							System.out.println("2. Delete a course");
							System.out.println("3. Edit a course");
							System.out.println("4. Display information for a given course");
							System.out.println("5. Register a student");
							System.out.println("6. Exit");
							option = input.nextInt();
							if (option == 1) {
								a.new_course();
							}
							if (option == 2) {
								System.out.print("Enter course name: ");
								String cn = input.next();
								
								System.out.print("Enter course section number: ");
								int sec = input.nextInt();
								a.del_course(cn, sec);	
							}
							if (option == 3) {
								System.out.print("Enter course ID: ");
								String id = input.next();
								
								System.out.print("Enter course section number: ");
								int sec = input.nextInt();
								a.edit_course(id, sec);
								
							}
							if (option == 4) {
								System.out.print("Enter id: ");
								String id  = input.next();
								
								System.out.print("Enter section number: ");
								int sec = input.nextInt();
								a.display(id, sec);
								
							}
							if(option == 5) {
								a.register_stu();
								
							}
						
						}while(option != 6);
						Data.serialize();
						break;
							
						
					}
					if (option == 2) {
						System.out.println("Welcome to Reports!");
						do {
							System.out.println("Please pick an option: ");
							System.out.println("1. View all courses");
							System.out.println("2. View all courses that are FULL");
							System.out.println("3. Write to a file the list of course that are FULL");
							System.out.println("4. View the names of the students that are registered in a specific course");
							System.out.println("5. View the list of courses that a given student is registered in");
							System.out.println("6. Exit");
							option = input.nextInt();
							if (option == 1) {
								System.out.println("Viewing all courses: ");
								a.view_all();
							}
							if (option == 2) {
								a.view_full();
							}
							if (option == 3) {
								a.file_full();
							}
							if (option == 4) {
								a.registered_students();
							}
							if (option == 5) {
								a.List_stu_courses();			
							}
								
							
						}while (option != 6);
					}			
		
		}while (option != 3);
			
		Data.serialize();
		
	}
	}
	else if (ans.equalsIgnoreCase("stu")) {
System.out.println("user: ");
stu_user = input.next();

System.out.println("pass: ");
stu_pass = input.next();

		for (Student stu: Data.student_list) {
			if (stu.getUsername().equalsIgnoreCase(stu_user) && stu.getPass().equalsIgnoreCase(stu_pass)){
				System.out.println("usernmae: ");
				//stu_user = input.next();
				System.out.println("pass: ");
				//stu_pass = input.next();
				System.out.println("Welcome Student!");
				
				do {
				System.out.println("1. View all courses");
				System.out.println("2. View all courses that are not full");
				System.out.println("3. Register in a course");
				System.out.println("4. Withdraw from a course");
				System.out.println("5. View all courses that the current student is registered in");
				System.out.println("6. Exit");
				option = input.nextInt();
				
				if (option == 1) {
					stu.view_course();
				}
				if (option == 2) {
					stu.course_not_full();
				}
				if (option == 3) {
					stu.register_course();
				}
				if (option == 4) {
					stu.withdraw_course();
				}
				if (option == 5) {
					stu.view_enrolled();
				}
				
			}while (option != 6);
				break;
		}
	}
}
	}
	}
