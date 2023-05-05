package com.bugtracking;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.Test;

import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.bugtracking.dao.AdminDao;
import com.bugtracking.entity.AdminEntity;
import com.bugtracking.service.AdminServiceImpl;

@SpringBootTest
public class AdminTestCase {

//	@MockBean
//	AdminDao adminrepo;
//
//	@Autowired
//	AdminServiceImpl adminService;
//
//	@Test
//	public void testAddAdmin() {
//		AdminEntity admin = new AdminEntity();// mock object
//		admin.setMail("abcd@gmail.com");
//		admin.setName("ABCD");
//		admin.setContact("983948394");
//		admin.setPassword("QWERTY");
//
//		Mockito.doReturn(admin).when(adminrepo).save(admin);
//
//		String result = adminService.createAdmin(admin);
//		assertEquals("Admin Created Successfully", result);
//	}
//
//	@Test
//	public void testviewAdmin() {
//		String email = "abcd@gmail.com";
//		AdminEntity admin1 = new AdminEntity("abcd@gmail.com", "ABCD", "983948394", "QWERTY");
//		Optional<AdminEntity> admin = Optional.of(new AdminEntity());// mock object
//
//		Mockito.doReturn(admin).when(adminrepo).getById(email);
//		admin = adminService.getByAdminId(email);
//
//		assertEquals(admin1, admin);
//	}
}
