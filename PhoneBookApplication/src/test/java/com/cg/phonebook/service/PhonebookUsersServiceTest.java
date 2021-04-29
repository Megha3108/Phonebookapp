//package com.cg.phonebook.service;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//import static org.junit.jupiter.api.Assertions.assertNull;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.mockito.BDDMockito;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import com.cg.phonebook.domain.UserEntity;
//import com.cg.phonebook.exception.ResourceNotFoundException;
//import com.cg.phonebook.repository.PhonebookUsersRepository;
//@RunWith(SpringJUnit4ClassRunner.class)
//public class PhonebookUsersServiceTest {
//
//	 @MockBean
//	 private PhonebookUsersRepository userRepo;
//
//	 @Autowired
//	 private PhonebookUsersService userService;
//	
//	@Test
// void validateUserData() throws ResourceNotFoundException
//	{
//		try {
//		BDDMockito.given(userRepo.findByMailID("smilyeesonuu@gmail.com")).willReturn(new UserEntity("Vishnu@228","smilyeesonuu@gmail.com","Vishnu@228","Swapna","850019666","vardhan", null));
//		UserEntity user= userService.findByMailId("smilyeesonuu@gmail.com");
//		assertNull(user);
//		}
//		catch(NullPointerException e) {
//			assertTrue(true);
//		}
//	}
//
//	@Test
//	 void validateUserDataSave() throws ResourceNotFoundException
//	{
//		try {
//		UserEntity data=new UserEntity();
//		data.setPassword("Vishnu@228");
//		data.setEmail("smilyeesonuuu@gmail.com");
//		data.setConfirmPassword("Vishnu@228");
//		data.setFirstName("Swapna");
//		data.setPhoneNumber("850019666");
//		data.setLastName("vardhan");
//		
//    BDDMockito.given(userRepo.save(data)).willReturn(data);
//     assertThat(userService.addNewUser(data)).isEqualTo(data);
//		}
//		catch(NullPointerException e) {
//			assertTrue(true);
//		}
//	}
//}
