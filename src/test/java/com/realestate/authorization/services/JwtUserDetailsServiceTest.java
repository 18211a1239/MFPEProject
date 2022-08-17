package com.realestate.authorization.services;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.realestate.authorization.controllers.JwtAuthenticationController;
import com.realestate.authorization.entities.User;
import com.realestate.authorization.repos.UserRepository;


@SpringBootTest
@AutoConfigureMockMvc
class MyUserDetailsServiceTest {

	@Autowired
	JwtUserDetailsService myUserDetailsService;

	@MockBean
	UserRepository userRepository;
	
    @Autowired
	private JwtAuthenticationController authController;
	
	static ObjectMapper mapper = new ObjectMapper();

	@Test
	void contextLoads() {

		assertNotNull(myUserDetailsService);

	}
	

	@Test
	void loadUserByUsernameTestSuccess() throws UsernameNotFoundException {
		
		User u = new User(1, "shivani", "123");
		Mockito.when(userRepository.findByUsername(u.getUsername())).thenReturn(u);
		assertEquals("shivani", myUserDetailsService.loadUserByUsername("shivani").getUsername());
	}

	
	@Test
	void loadUserByUsernameTestFail() {
		User u = new User(1, "shivani", "123");
		Mockito.when(userRepository.findByUsername(u.getUsername())).thenReturn(u);
		assertEquals("shivani", myUserDetailsService.loadUserByUsername("shivani").getUsername());
	}

	
	@Test
	void CheckIfUserAlreadyExistsTestSuccess() throws Exception{
		authController.saveUser(new User("shivani","1234"));
		String res=String.valueOf(myUserDetailsService.CheckIfUserAlreadyExists("shiv"));
		assertEquals("false",res);
		
		
	}
	
	@Test
	void saveTest() throws Exception {
		User u = new User(1, "qwerty", "123");
		String res=String.valueOf(myUserDetailsService.save(u));
		assertEquals("true", res);
		
	}
	
	
	
	
	
	
}
