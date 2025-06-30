package soft_eng_demo.sbparent;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CoursesServiceImpl implements CoursesService {
	@Autowired
	private CoursesDAO CoursesRep;
	
	@Autowired
	public CoursesServiceImpl(CoursesDAO theCoursesRep) {
		CoursesRep = theCoursesRep;
	}
	
	public CoursesServiceImpl() {
		
	}
	
	@Override
	@Transactional
	public List<Courses> findAll() {
		return CoursesRep.findAll();
	}
	
	@Transactional
	public Courses findById(int theId) {
		Courses result = CoursesRep.findById(theId);
				
		if (result != null ) {
			return result;
		}
		else {
			// we didn't find the student
			throw new RuntimeException("Did not find student id - " + theId);
		}
	}
	
	@Override
	@Transactional
	public void save(Courses theCourses) {
		CoursesRep.save(theCourses);
	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		CoursesRep.deleteById(theId);
		
	}


}