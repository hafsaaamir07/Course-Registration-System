import java.io.IOException;
public interface Adminmeth {
	public void new_course();
	public void del_course(String course_name, int sec_num);
	public void edit_course (String course_id, int sec);
	public void display ( String id, int sec_num);
	public void register_stu ();
	//reports
	public void view_all();
	public void view_full();
	public void file_full() throws IOException;
	public void registered_students();
	public void List_stu_courses();
	public void sorting();
	

}
