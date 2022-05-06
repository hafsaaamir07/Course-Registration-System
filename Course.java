import java.io.Serializable;
import java.util.ArrayList;

public class Course implements Serializable{
	private String course_name;
	private String course_id;
	private int max_stu; //maximum num student register;
	private int curr_stu; // current num of student register 
	protected ArrayList<String> enrolled_stu;
	private String instructor;
	private int sec_num; //course section num
	private String loc;
	
	public Course (String course_name, String course_id, int max_stu, int curr_stu, String instructor, int sec_num, String loc) {
		this.course_name = course_name;
		this.course_id = course_id;
		this.max_stu = max_stu;
		this.curr_stu = curr_stu;
		this.enrolled_stu = new ArrayList<String>();
		this.instructor = instructor;
		this.sec_num = sec_num;
		this.loc = loc;
	}
	public Course (String course_name, String course_id,int curr_stu, String instructor, int sec_num, String loc) {
		this.course_name = course_name;
		this.course_id = course_id;
		this.instructor = instructor;
		this.sec_num = sec_num;
		this.loc = loc;
		
	}
	public String getCourse_name() {
		return course_name;
	}
	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}
	public String getCourse_id() {
		return course_id;
	}
	public void setCourse_id(String course_id) {
		this.course_id = course_id;
	}
	public int getMax_stu() {
		return max_stu;
	}
	public void setMax_stu(int max_stu) {
		this.max_stu = max_stu;
	}
	public int getCurr_stu() {
		return curr_stu;
	}
	public void setCurr_stu(int curr_stu) {
		this.curr_stu = curr_stu;
	}
	public ArrayList<String> getEnrolled_stu() {
		return enrolled_stu;
	}
	public void setEnrolled_stu(ArrayList<String> enrolled_stu) {
		this.enrolled_stu = enrolled_stu;
	}
	public String getInstructor() {
		return instructor;
	}
	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}
	public int getSec_num() {
		return sec_num;
	}
	public void setSec_num(int sec_num) {
		this.sec_num = sec_num;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	
	public void PrintInfo() {
		System.out.println("Name: "+this.course_name);
		System.out.println("ID: "+this.course_id);
		System.out.println("Max students: "+this.max_stu);
		System.out.println("Current students: "+this.curr_stu);
		System.out.println("Enrolled students: "+this.enrolled_stu);
		System.out.println("Instructor: "+this.instructor);
		System.out.println("Section num: "+this.sec_num);
		System.out.println("location: "+this.loc);
		
	}
	public int compareTo(Course c) {
		if (this.getCurr_stu()>c.getCurr_stu()) {
			return 1;
		}
		else if (this.getCurr_stu() < c.getCurr_stu()) {
			return -1;
		}
		else {
			return 0;
		}
	}

	
}
