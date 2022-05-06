import java.util.Scanner;
import java.io.*;
import java.util.*;
import java.util.ArrayList;

public class Admin extends User implements Adminmeth{
	static Scanner input = new Scanner (System.in);
	
	
	public Admin () {
	
	}
	
	public void new_course() {
		System.out.println("Creating a course...");
		
		System.out.println("Course name: ");
		String course_name = input.next();
		input.nextLine();
		System.out.println("Course ID: ");
		String course_id = input.next();
		
		System.out.println("Maximum number of Students: ");
		int max_stu = input.nextInt();
		
		int curr_stu = 0;
		
		
		System.out.println("Instructor name: ");
		String instructor = input.next();
		
		System.out.println("Course section number: ");
		int sec_num = input.nextInt();
		
		System.out.println("Course location: ");
		String loc = input.next();
		
		Course c = new Course (course_name, course_id,max_stu,curr_stu, instructor, sec_num, loc);
		Data.course_list.add(c);
		
		System.out.println("Course has been created!");
		
	}
	
	public void del_course(String course_name, int sec_num) {
		for (int i = 0; i < Data.course_list.size(); i++) {
			if (Data.course_list.get(i).getCourse_name().equalsIgnoreCase(course_name) && Data.course_list.get(i).getSec_num() == sec_num) {
				Data.course_list.remove(i);
				System.out.println("Course has been removed!");
				return;
			}
				
		}	
		
		System.out.println("No course with this ID!");
		
	}
	public void edit_course (String course_id, int sec) {
		int option = 0;
		for (int i = 0; i < Data.course_list.size(); i++) {
			if (Data.course_list.get(i).getCourse_id().equalsIgnoreCase(course_id) && Data.course_list.get(i).getSec_num() == sec) {			
				System.out.println("\n1. Maximum number of Students in a course\n2. Current number of registered students\n3. List of names of students registered\n4. Course Instructor\n5. Course section number\n6. Location\n7. Exit ");
				option = input.nextInt();
				if (option == 1) {
					System.out.println("Set a new maximum number for students: ");
					int max_num = input.nextInt();
					Data.course_list.get(i).setMax_stu(max_num);
					System.out.println("Sucessfully completed!");
				}
				else if (option == 2) {
					System.out.print("Set a new number for current number of students: ");
					int cur_num = input.nextInt();
					Data.course_list.get(i).setCurr_stu(cur_num);
					System.out.println("Sucessfully completed!");
				}
				else if (option == 3) {
					System.out.print("Enter student name to edit: ");
					String name = input.next();
					ArrayList<String> student_names = Data.course_list.get(i).getEnrolled_stu();
					for (int b = 0; b < student_names.size(); b++ ) {
						if (student_names.get(b).equalsIgnoreCase(name)) {
							student_names.set(b, name);
							Data.course_list.get(i).setEnrolled_stu(student_names);
							System.out.println("Sucessfully completed!");
						}
						else {
							System.out.println("Sorry name does not exist!");
						}
							
					}
				}
				else if (option == 4) {
					System.out.print("Enter a new name for course instructor: ");
					String instruc_name = input.next();
					Data.course_list.get(i).setInstructor(instruc_name);
					System.out.println("Sucessfully completed!");
				}
				else if (option == 5) {
					System.out.println("Enter new section number: ");
					int section = input.nextInt();
					Data.course_list.get(i).setSec_num(section);
					System.out.println("Sucessfully completed!");	
				}
				else if (option == 6) {
					System.out.println("Enter new location: ");
					String loc = input.next();
					Data.course_list.get(i).setLoc(loc);
					System.out.println("Sucessfully completed!");
					
					
				}
				else if (option == 7) {
					System.out.println("Exiting...");
					break;
				}
						
			}
			else {
				System.out.println("Sorry a course with that id and section number does not exist!");
			}					
		}
						
	}
	
	public void display ( String id, int sec_num) {
		System.out.print("Please enter course ID for the course info: ");
		String cid = input.next();
		for (int i = 0; i < Data.course_list.size(); i++) {
			if (Data.course_list.get(i).getCourse_id().equalsIgnoreCase(cid)) {
				Data.course_list.get(i).PrintInfo();
			}
		}
		
		
	}
	
	public void register_stu () { //DONE
		//fisrt last id user pass
		System.out.print("Enter first name: ");
		String first = input.next();
		
		System.out.print("Enter last name: ");
		String last = input.next();
		
		System.out.print("Enter ID number: ");
		String id = input.next();
		
		System.out.print("Enter username: ");
		String user = input.next();
		
		System.out.print("Enter password: ");
		String pass = input.next();
		
		Student register = new Student (first, last, id, user, pass);
		
		Data.student_list.add(register);
			
		
	}
	
	// reports
	public void view_all() {//NEED TO FINISH
		for (int i =0; i < Data.course_list.size(); i++) {
			System.out.println("Name: "+Data.course_list.get(i).getCourse_name());
			System.out.println("Students enrolled in this course: "+ Data.course_list.get(i).getEnrolled_stu());
			System.out.println("Enrolled students ID: "+Data.student_list.get(i).getStu_id());  
			System.out.println("Number of students registered: "+Data.course_list.get(i).getCurr_stu());
			System.out.println("Maximu number of students that can register: "+ Data.course_list.get(i).getMax_stu());
		}
		
		
	}
	public void view_full() {
		System.out.println("Following courses are full: ");
		for (int i = 0; i < Data.course_list.size(); i++) {
			if (Data.course_list.get(i).getMax_stu() == Data.course_list.get(i).getCurr_stu()) {
				System.out.println ("Name: "+Data.course_list.get(i).getCourse_name()+" Section: "+Data.course_list.get(i).getSec_num());
			}
		}
		
	}
	
	public void file_full() throws IOException{
		String file = "FullCourses.txt";
		try {
			FileWriter fwrite = new FileWriter(file);
			BufferedWriter bwriter = new BufferedWriter(fwrite);
			for (int i = 0; i<Data.course_list.size(); i++) {
				if (Data.course_list.get(i).getCurr_stu() == Data.course_list.get(i).getMax_stu()) {
					bwriter.write("Name: "+Data.course_list.get(i).getCourse_name()+" Section number: "+Data.course_list.get(i).getSec_num());
					bwriter.newLine();
				}
			}
			System.out.println("All full courses have been written to a file");
			bwriter.close();
			
		}
		catch (IOException b) {
			System.out.println("File can not be written!");
			b.printStackTrace();
		}
		
	}
	public void registered_students() {
		System.out.print("Enter Course name: ");
		String id = input.next();
		
		System.out.print("Enter course section num: ");
		int sec = input.nextInt();
		
		for (int i = 0; i < Data.course_list.size(); i++) {
			if (Data.course_list.get(i).getCourse_id().equalsIgnoreCase(id)) {
				if (Data.course_list.get(i).getSec_num() == sec) {
					for (int b = 0; b < Data.course_list.get(i).getEnrolled_stu().size(); b++) {
						System.out.println("List of students in this course: "+ Data.course_list.get(i).getEnrolled_stu().get(b));
					}
				}
				else {
					System.out.println("Sorry that course name and section does not exist!");
				}
			}
		}
		
	}
	
	public void List_stu_courses() {
		System.out.print("Enter first name: ");
		String first = input.next ();
		
		System.out.print("Enter last name: ");
		String last = input.next();
		
		for (Student sn: Data.student_list) {
			if (sn.getFirst().equalsIgnoreCase(first) && sn.getLast().equalsIgnoreCase(last) ){
				sn.view_enrolled();
			}
				
			}
	}
	public void sorting() {
		Collections.sort(Data.course_list, Collections.reverseOrder());
		System.out.println("The course has successfully been sorted by the number of current students.");
	}
			
	
	

	
	
}