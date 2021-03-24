package loginregister;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Date;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

//import loginregister.exception.UserExistsException;
import loginregister.model.User;
import loginregister.repository.UserRepository;
import loginregister.service.UserService;

@SpringBootTest
class SpringSecurityApplicationTests {

	@Autowired
	private UserService service;
	@MockBean
	private UserRepository Userrepository;
	
	Date dob = new Date();
	Date added = new Date();
	
	@Test
	void contextLoads() {
		
	}
	
	@Test
	public void Testgetregistrationbyemail() {
		String id ="test1";
		when(Userrepository.findById(id)).thenReturn(Optional.of(new User("test1", "Test User", "test@abc.com", "male", "1234567890", dob, added, "password","ROLE_ADMIN")));
		assertEquals(true,service.getUserById(id).getUserId().equals("test1"));
	}
	
	@Test
    public void TestisEmptygetregistrationbyemail() {
		String id ="test1";
        when(Userrepository.findById(id)).thenReturn(Optional.of(new User("test1", "Test User", "test@abc.com", "male", "1234567890", dob, added, "password","ROLE_ADMIN")));
        assertEquals(false,service.getUserById(id).equals(null));
    }
	
	
	@Test
    public void testMockCreation(){
        assertNotNull(Userrepository);
        
    }

}