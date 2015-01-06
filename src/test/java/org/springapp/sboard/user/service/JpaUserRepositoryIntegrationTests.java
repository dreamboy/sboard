package org.springapp.sboard.user.service;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springapp.sboard.SboardApplication;
import org.springapp.sboard.user.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SboardApplication.class)
public class JpaUserRepositoryIntegrationTests {
	
	@Autowired
	UserRepository repository;
	
	@Test
	public void findAllUser() {
		List<User> users = this.repository.findAll();
		
		assertEquals(5, users.size());
	}

}
