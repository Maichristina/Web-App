package soft_eng_demo.sbparent;

import java.util.List;
public interface StudentService {

	public List<Student> findAll();
	
	public Student findById(int id);
	
	public void save(Student theStudent);
	

	void deleteByAm(int am);

	public void calculateByFg(int id);

	public void deleteById(int id);


	
}