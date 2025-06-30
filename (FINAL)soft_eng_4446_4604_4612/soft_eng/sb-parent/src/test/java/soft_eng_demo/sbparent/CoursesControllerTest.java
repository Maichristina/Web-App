package soft_eng_demo.sbparent;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.context.WebApplicationContext;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@DisplayName("JUnit&Mockito tests Courses Controller class")
@SpringBootTest
@TestPropertySource(
  locations = "classpath:application.properties")
@AutoConfigureMockMvc
public class CoursesControllerTest {
	
	@Autowired
    private WebApplicationContext context;
	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	CoursesController coursesController;

	@BeforeEach
    public void setup() {
		mockMvc = MockMvcBuilders
          .webAppContextSetup(context)
          .build();
    }
	
	@Test
	void testCoursesControllerIsNotNull() {
		Assertions.assertNotNull(coursesController);
	}
	
	@Test
	void testMockMvcIsNotNull() {
		Assertions.assertNotNull(mockMvc);
	}
	
	
	@WithMockUser(value = "user1")
	@Test 
	void testListCoursesReturnsPage() throws Exception {
		
		mockMvc.perform(get("/courses/list")).
		andExpect(status().isOk()).
		andExpect(view().name("courses"));		
	}
	
	@WithMockUser(value = "user1")
	@Test 
	void testSaveCourseReturnsPage() throws Exception {
	    Courses testCourse = new Courses(20,5,"Test Course2", "testing", "ProfessorTest2");
	    	    
	    MultiValueMap<String, String> multiValueMap = new LinkedMultiValueMap<>();
	    multiValueMap.add("id", Integer.toString(testCourse.getId()));
	    multiValueMap.add("semester", Integer.toString(testCourse.getSemester()));
	    multiValueMap.add("name", testCourse.getName());
	    multiValueMap.add("syllabus",testCourse.getSyllabus());
	    multiValueMap.add("professor",testCourse.getProfessor());
	    
		mockMvc.perform(
				post("/courses/save")
			    .params(multiValueMap))
				.andExpect(status().isFound())
				.andExpect(view().name("redirect:/courses/list"));
						
	}
	
}
