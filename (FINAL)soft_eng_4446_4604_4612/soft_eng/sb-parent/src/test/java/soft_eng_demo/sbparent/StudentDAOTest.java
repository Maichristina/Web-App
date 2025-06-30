package soft_eng_demo.sbparent;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@DisplayName("Checking that the CoursesDAO is not null")
@SpringBootTest
@TestPropertySource(
  locations = "classpath:application.properties")
public class StudentDAOTest {
	@Autowired 
	StudentDAO studentDAO;
	
	@Test
	void testCourseDAOIsNotNull() {
		Assertions.assertNotNull(studentDAO);
	}

}
