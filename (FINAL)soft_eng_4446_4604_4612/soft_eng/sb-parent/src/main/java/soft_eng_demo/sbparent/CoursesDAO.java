package soft_eng_demo.sbparent;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CoursesDAO extends JpaRepository<Courses, Integer> {
	
	public Courses findById(int theId);
		
}