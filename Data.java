import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

	public class Data {
	public static ArrayList<Course> course_list = new ArrayList<Course>();
	public static ArrayList<Student>student_list = new ArrayList<Student>();
	
	public static void deserilize() throws IOException, ClassNotFoundException{
		try {
			FileInputStream file = new FileInputStream("university_course.ser");
			
			ObjectInputStream obj = new ObjectInputStream (file);
			
			Data.course_list = (ArrayList<Course>)obj.readObject();
			
			obj.close();
			file.close();
			
			file = new FileInputStream("stu.ser");
			
			obj = new ObjectInputStream(file);
			
			Data.student_list = (ArrayList<Student>)obj.readObject();
			
			obj.close();
			file.close();
			
		}
		catch(IOException s) {
			logmeth();
		
		}
	}
		public static void serialize() throws IOException{
			
			FileOutputStream  fi = new FileOutputStream("university_course.ser");
			
			ObjectOutputStream ob = new ObjectOutputStream(fi);
			
			ob.writeObject(Data.course_list);
			
			ob.close();
			fi.close();
			
			fi = new FileOutputStream("stu.ser");
			ob = new ObjectOutputStream(fi);
			
			ob.close();
			fi.close();
			
			System.out.println("Your data has been saved!");	
			
		}
		
	public static void logmeth() throws IOException{
		File c = new File ("MyUniversityCourses.csv");
		Scanner input = new Scanner (c);
		String [] info;
		
		int i = 0;
		input.nextLine();
		while (input.hasNextLine()) {
			String information = input.nextLine();
			info  = information.split(",");
			//String String int int String String int String
			//                        s      s          i                            i                      s           s      i                     s
			Course c1 = new Course(info[0], info[1], Integer.parseInt(info[2]), Integer.parseInt(info[3]), info[5],Integer.parseInt(info[6]),info[7]);
		}
		
	}
	
	
	
	
	
	
	
	
	

}
