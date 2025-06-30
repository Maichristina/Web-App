package soft_eng_demo.sbparent;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	private StudentDAO StudentRep;
	
	@Autowired
	public StudentServiceImpl(StudentDAO theStudentRep) {
		StudentRep = theStudentRep;
	}
	
	public StudentServiceImpl() {
	
	}
	
	@Override
	@Transactional
	public List<Student> findAll() {
		return StudentRep.findAll();
	}
	
	@Override
	@Transactional
	public Student findById(int theId) {
		Student result = StudentRep.findById(theId);
				
		if (result != null ) {
			return result;
		}
		else {
		
			throw new RuntimeException("Did not find student id - " + theId);
		}
	}
	
	@Override
	@Transactional
	public void save(Student theStudent) {
		StudentRep.save(theStudent);
	}

	/*@Override
	@Transactional
	public void deleteByAm(int am) {
		StudentRep.deleteByAm(am);
		
	}*/

	public void calculateByFg(int id) {
		
		
	}

	@Override
	public void deleteById(int id) {
		StudentRep.deleteById(id);
		
	}

	@Override
	public void deleteByAm(int am) {
		// TODO Auto-generated method stub
		
	}

}