package kr.co.subject.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import kr.co.subject.dto.User;

public class MemoryUserRepositoryTest {
	
//	MemoryUserRepository repository = new MemoryUserRepository();
//	
//	@AfterEach
//	public void afterEach() {
//		repository.clearStore();
//	}
	
//	@Test
//	public void save() {
//		User user = new User();
//		user.setID("Test_save");
//		
//		repository.save(user);
//		
//		User result = repository.findByName(user.getID(), null).get();
//		assertThat(user).isEqualTo(result);
//	}
//	
//	@Test
//	public void findByName() {
//		User user1 = new User();
//		user1.setID("Test111_findByName");
//		repository.save(user1);
//		
//		User user2 = new User();
//		user2.setID("Test222_findByName");
//		repository.save(user2);
//		
//		User result = repository.findByName("Test222", null).get();
//		
//		assertThat(result).isEqualTo(user1);
//	}
//	
//	@Test
//	public void findAll() {
//		User user1 = new User();
//		user1.setID("Test111_findAll");
//		repository.save(user1);
//		
//		User user2 = new User();
//		user2.setID("Test2_findAll");
//		repository.save(user2);
//		
//		List<User> result = repository.findAll();
//		
//		assertThat(result.size()).isEqualTo(2);
//	}
}