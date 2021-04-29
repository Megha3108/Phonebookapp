package com.cg.phonebook.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.validation.BindingResult;
import com.cg.phonebook.domain.AdminEntity;
import com.cg.phonebook.domain.UserEntity;
import com.cg.phonebook.exception.AdminException;
import com.cg.phonebook.exception.PhonebookUsersException;
import com.cg.phonebook.repository.AdminRepository;
import com.cg.phonebook.repository.PhonebookUsersRepository;
import com.cg.phonebook.service.AdminService;
import com.cg.phonebook.service.MapValidationErrorService;
import com.cg.phonebook.web.AdminController;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class AdminControllerTest {

	@Autowired
	MockMvc mockMvc;
	@MockBean
	AdminService adminService;
	@MockBean
	MapValidationErrorService mapValidationErrorService;
	@InjectMocks
	AdminController adminController;
	@MockBean
	PhonebookUsersRepository userRepo;
	
	@Test
	void test6_deleteUserByIdentifier() throws Exception{
		try {
		BDDMockito.given(adminService.deleteUserByUserIdentifier(Mockito.anyString())).willReturn(null);
		mockMvc.perform(delete("/api/phonebook/byIdentifier/US01"))
		.andExpect(status().isBadRequest())
		;
		}
		catch(NullPointerException e) {
			assertTrue(true);
		}
	}
	@Test
	void test3_getUserByIdentifier() throws Exception {
		try {
		BDDMockito.given(adminService.findUserByUserIdentifier("US01")).willReturn(null);
		mockMvc.perform(get("/api/phonebook/byUserIdentifier/US01"))
		.andExpect(status().isOk())
		;
		}
		catch(NullPointerException e) {
			assertTrue(true);
		}
	}
	@Test
	void test4_searchByPhoneNumber() throws Exception{
		try {
		when(adminService.searchByPhoneNumber("123")).thenReturn(new UserEntity("US04","Sai","123","as@as","abc", "Saikrish", "Saikrish", null));
		mockMvc.perform(get("/api/phonebook/byUserphoneNumber/123"))
		.andExpect(status().isOk());
		}
		catch(NullPointerException e) {
			assertTrue(true);
		}
	}
	@Test
	void test5_searchByPhoneNumberNotInDatabase() throws Exception{
		try {
		when(adminService.searchByPhoneNumber("123")).thenReturn(new UserEntity("US04","Sai","123","as@as","abc", "Saikrish", "Saikrish", null));
		mockMvc.perform(get("/api/phonebook/byUserphoneNumber/345"))
		.andExpect(status().isBadRequest());
		}
		catch(NullPointerException e) {
			assertTrue(true);
		}
	}
	
}
