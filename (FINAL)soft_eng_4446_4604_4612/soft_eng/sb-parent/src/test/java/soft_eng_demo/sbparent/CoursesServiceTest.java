package soft_eng_demo.sbparent;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestPropertySource;
import org.junit.jupiter.api.DisplayName;

@DisplayName("JUnit&Mockito tests for Courses Service class")
@SpringBootTest
@TestPropertySource(
		  locations = "classpath:application.properties")
@AutoConfigureMockMvc
class CoursesServiceTest {
	
	@Autowired 
	CoursesService coursesService;

	
	@MockBean
	CoursesDAO mockcourse;	
	
/*	@BeforeEach
    public void setup() {
		mockMvc = MockMvcBuilders
          .webAppContextSetup(context)
          .build();
    }
*/	
	@Test
	void test_addingCourses() {
        Courses courses = new Courses();
        courses.setName("ApeirostikosTesting");
        coursesService.save(courses);
        Assertions.assertNotNull(courses);
        Assertions.assertNotNull(courses.getName());
        assertEquals("ApeirostikosTesting", courses.getName());
	} 
	
	@Test
	void testFindByIdReturnsCourse() {
			Mockito.when(mockcourse.findById(20)).thenReturn(new Courses(20,5,"Test Course", "testing", "ProfessorTest"));
			Courses storedCourse = mockcourse.findById(20);
			Assertions.assertNotNull(storedCourse);
			Assertions.assertEquals("Test Course", storedCourse.getName());
	}
        
        
}
