package com.exam.examportal;

import com.exam.examportal.model.Role;
import com.exam.examportal.model.User;
import com.exam.examportal.model.UserRole;
import com.exam.examportal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class ExamPortalApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ExamPortalApplication.class, args);
	}

	@Autowired
	UserService userService ;

	@Override
	public void run(String... args) throws Exception {

		User user = new User() ;
		user.setFirstName("Vaibhav");
		user.setLastName("Gujarkar");
		user.setLastName("Vaibhav");
		user.setEmail("gujarkar@gmail.com");
		user.setPassword("abcd");

		Role role = new Role() ;
		role.setRoleName("ADMIN");
		role.setRoleId(11L);

		UserRole userRole = new UserRole() ;
		userRole.setRole(role);
		userRole.setUser(user);

		Set<UserRole> userRoleSet = new HashSet<>() ;
		userRoleSet.add(userRole) ;

//		user.setUserRoles(userRoleSet);

		User createdUser = this.userService.createUser(user , userRoleSet) ;

		System.out.println(createdUser.getUsername());
	}
}
