package soft_eng_demo.sbparent;

import java.util.List;

public interface CoursesService {

	public List<Courses> findAll();
	
	public static Courses findById(int id) {
		return null;
	}
	
	public void save(Courses theCourses);
	
	public void deleteById(int id);
	
}
