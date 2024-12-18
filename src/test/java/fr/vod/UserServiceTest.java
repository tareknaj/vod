package fr.vod;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.HashSet;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import fr.vod.model.User;
import fr.vod.model.Video;
import fr.vod.repository.UserRepository;
import fr.vod.service.UserService;

public class UserServiceTest {
	
	@Mock //cree une copie qui est fictive(false) juste pour tester
	private UserRepository userRepository; //Mocking the repository
	
	@InjectMocks
	private UserService userService; //the service being tested
	
	private User mockUser;
	
	@BeforeEach
	public void SetUp() {
		MockitoAnnotations.openMocks(this);
		Video mockvideo = new Video();
		
		HashSet<Video> videos = new HashSet<Video>();
		videos.add(mockvideo);
		mockUser = new User();
		 //Initializes mocks
		mockUser.setId(1);
		mockUser.setEmail("Donia@yahoo.com");
		mockUser.setPassword("123456");
		mockUser.setFirstName("MARTIN");
		mockUser.setLastName("Donia");
		mockUser.setGender('F');
		mockUser.setPhone("0786984523");
		mockUser.setVideoLikes(videos);
	}
	
	@Test
	public void TestGetUserById() {
		//Arrange: Mock the behavior of userRepository
		when(userRepository.findByEmailAndPassword("Donia@yahoo.com","123456")).thenReturn(mockUser);
		
		//Act: call the method under test
		User result = userService.get("Donia@yahoo.com","123456");
		
		assertNotNull(result);//the result should be not be null
		
		assertEquals("MARTIN", result.getFirstName());
		assertEquals("Donia", result.getLastName());
		assertEquals("Donia@yahoo.com", result.getEmail());
		assertEquals("123456" , result.getPassword());
		assertEquals("0786984523", result.getPhone());
		Boolean isFemale = ('F' == result.getGender());
		assertEquals(isFemale, true);
	}	

}
