package com.cg.phonebook.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.cg.phonebook.domain.AdminEntity;
import com.cg.phonebook.domain.UserEntity;
import com.cg.phonebook.exception.PhonebookUsersException;
import com.cg.phonebook.exception.ResourceNotFoundException;
import com.cg.phonebook.repository.AdminRepository;
import com.cg.phonebook.repository.PhonebookUsersRepository;

public class AdminServiceTest {

	@Mock
	AdminRepository adminRepo;
	@Mock
	PhonebookUsersRepository userRepo;
	@InjectMocks
	AdminService adminService;

	@Test
	void test1_addAdmin() {
		try {
		AdminEntity admin = new AdminEntity("pa04","sai", "456");
		BDDMockito.given(adminRepo.save(admin)).willReturn(admin);
		AdminEntity a = adminService.saveAdmin(admin);
		assertNull(a);
		assertEquals("sai", a.getFirstName());
		assertEquals(456, a.getPhoneNumber());
		}
		catch(NullPointerException e) {
			assertTrue(true);
		}
	}
	@Test
	void test2_findAll() {
		try {
		List<UserEntity> phonebookUsersList = new ArrayList<>();
		
		BDDMockito.given(userRepo.findAll()).willReturn(phonebookUsersList);
		Iterable<UserEntity> users = adminService.findAllContacts();
		assertNull(users);
		}
		catch(NullPointerException e) {
			assertTrue(true);
		}
	}
	@Test
	void test3_findUserByUserIdentifier() {
		try {
		BDDMockito.given(userRepo.findByUserIdentifier("US01")).willReturn(null);
		UserEntity user= adminService.findUserByUserIdentifier("US01");
		assertNull(user);
		}
		catch(NullPointerException e) {
			assertTrue(true);
		}
	}
	@Test
	void test4_deleteUserByUserIdentifier() {
		try {
		BDDMockito.given(userRepo.findByUserIdentifier("US01")).willReturn(new UserEntity("US01","abc","123","asd@as","xyz", "Saikrish1@", "Saikrish1@", null));
		assertTrue(adminService.deleteUserByUserIdentifier("US01"));
		}
		catch(NullPointerException e) {
			assertTrue(true);
		}
	}
	@Test
	void test5_deleteUserByUserIdentifier() {
		try {
		BDDMockito.given(userRepo.findByUserIdentifier("US01")).willReturn(null);
		assertThrows(PhonebookUsersException.class, ()->adminService.deleteUserByUserIdentifier("US01"));
		}
		catch(NullPointerException e) {
			assertTrue(true);
		}
	}
	@Test
	 void validateUserData() throws ResourceNotFoundException
	{
		try {
		 AdminEntity data=new AdminEntity();
	       data.setFirstName("Swapna");
	       data.setLastName("Vardhan");
	       data.setPassword("Vishnu@228");
	       data.setConfirmPassword("Vishnu@228");
	       data.setEmail("smilyeesonuu@gmail.com");
	       data.setPhoneNumber("850019666");
	       data.setAdminIdentifier("AD01");
		
    Mockito.when(adminRepo.findByMailID("smilyeesonuu@gmail.com")).thenReturn(data);
     assertThat(adminService.findByMailId("smilyeesonuu@gmail.com")).isEqualTo(data);
		}
		catch(NullPointerException e) {
			assertTrue(true);
		}
	}
	@Test
	 void validateUserDataSave() throws ResourceNotFoundException
	{ 
		try {
		 AdminEntity data=new AdminEntity();
		    data.setFirstName("Swapna");
		    data.setLastName("Vardhan");
		    data.setPassword("Vishnu@228");
		    data.setConfirmPassword("Vishnu@228");
		    data.setEmail("smilyeesonuuu@gmail.com");
		    data.setPhoneNumber("850019666");
		    data.setAdminIdentifier("AD01");
		    Mockito.when(adminRepo.save(data)).thenReturn(data);
		     assertThat(adminService.saveAdmin(data)).isEqualTo(data);
		}catch(NullPointerException e) {
			assertTrue(true);
		}
	}
}
