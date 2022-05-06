import java.util.Scanner;
import java.util.*;
import java.util.ArrayList;
import java.io.Serializable;


public class Student extends User implements Studentmeth, Serializable{
	private String stu_id;
	
	private ArrayList<Course> stu_course;
	static Scanner input = new Scanner (System.in);
	
	public Student ( String first, String last, String stu_id, String username, String pass) {
		super(first,last, username, pass);	
		this.stu_id = stu_id;
		stu_course = new ArrayList<Course>();
	}
	
	public String getStu_id() {
		return this.stu_id;
	}
	
	public void setStu_id(String stu_id) {
		this.stu_id = stu_id;
	}
	
	
	public void view_course() {//DONE
		System.out.println("View courses: ");
		for (int i = 0; i< Data.course_list.size(); i++) {
			System.out.println("Name: "+Data.course_list.get(i).getCourse_name()+" Section #: "+Data.course_list.get(i).getSec_num() );
		}
	}
	
	public void course_not_full() {//DONE
		System.out.println("Displaying courses that are not full: ");
		for (int i = 0; i<Data.course_list.size(); i++) {
			if ( Data.course_list.get(i).getMax_stu() > Data.course_list.get(i).getCurr_stu()) {
				System.out.println(Data.course_list.get(i).getCourse_name()+ " Section: "+Data.course_list.get(i).getSec_num());
			}
		}
	}
	
	public void register_course() {
		System.out.println("To register...");
		
		System.out.print("Enter course name: ");
		String cname = input.next();
		
		System.out.print("Enter section number: ");
		int section = input.nextInt();
		
		System.out.print("Enter full name: ");
		String fname = input.nextLine();
		
		
		for (int i = 0; i < Data.course_list.size(); i++) {
			if (Data.course_list.get(i).getCourse_name().equalsIgnoreCase(cname) && Data.course_list.get(i).getSec_num() == section )
				if (Data.course_list.get(i).getMax_stu() == Data.course_list.get(i).getCurr_stu()) {
					System.out.println("Sorry class is full!");
			}
			else {
				if (Data.course_list.get(i).getCourse_name().equalsIgnoreCase(cname) && Data.course_list.get(i).getSec_num() == section) {
					//adding name to the arry list of names for that course
					Data.course_list.get(i).getEnrolled_stu().add(fname);
					
					//adding 1 to number of curr_stu 
					int cur_num = Data.course_list.get(i).getCurr_stu();
					Data.course_list.get(i).setCurr_stu(cur_num+=1);
					Course temp = Data.course_list.get(i);
					stu_course.add(temp);
					
					
					
				}		
			}
		}
	}
	
	public void withdraw_course() {
		System.out.print("Enter Name: ");
		String en = input.nextLine();
				
		System.out.print("Enter course name: ");
		String course = input.next();
		
		System.out.print("Enter course section number: ");
		int sec = input.nextInt();
		
		//removing name from arry list of stu names
		for (int i = 0; i < Data.course_list.size(); i++) {
			if (Data.course_list.get(i).getCourse_name().equalsIgnoreCase(course) && Data.course_list.get(i).getSec_num() == sec) {
				//Course temp = Data.course_list.get(i);
				Data.course_list.get(i).enrolled_stu.remove(en);
				
			//removing 1 from cur_stu
				Data.course_list.get(i).setCurr_stu(Data.course_list.get(i).getCurr_stu() - 1);
				for(int j = 0; j < stu_course.size(); j++) {
					if(Data.course_list.get(i).getCourse_name().equalsIgnoreCase(stu_course.get(j).getCourse_name()) && Data.course_list.get(i).getSec_num() == stu_course.get(j).getSec_num()) {
						stu_course.remove(j);
						return;
					}
				}
				
		    }
		//
		
		}
		
		
	}
	public void view_enrolled() {
		for (Course s: stu_course) {
			System.out.println("Course name: "+s.getCourse_name());
			System.out.println("Course ID: "+s.getCourse_id());
			System.out.println("Course Instructor: "+s.getInstructor());
			System.out.println("Course Section: "+s.getSec_num());
			System.out.println("Course Location: "+s.getLoc());
			
		}		
		
	}

	@Override
	public void exit() {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
