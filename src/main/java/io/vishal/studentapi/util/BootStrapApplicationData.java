package io.vishal.studentapi.util;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import io.vishal.studentapi.model.Role;
import io.vishal.studentapi.model.Student;
import io.vishal.studentapi.model.User;
import io.vishal.studentapi.repository.RoleRepository;
import io.vishal.studentapi.repository.StudentRepository;
import io.vishal.studentapi.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class BootStrapApplicationData implements ApplicationListener<ApplicationReadyEvent> {

	private final PasswordEncoder passwordEncoder;
	
	//private final StudentRepository	studentRepository;
	
	private final RoleRepository roleRepository;
	
	private final UserRepository userRepository;
	
	@Override
	public void onApplicationEvent(ApplicationReadyEvent event) {
		
		/*
		for(int i=0; i<10; i++) {
			Student student = new Student();
			student.setFirstName("FirstName-" + i);
			student.setLastName("LastName-" + i);
			student.setCourse("Course-" + i);
			student.setCountry("Country-" + i);
			studentRepository.save(student);
		}
		*/
		
		Role userRole=new Role();
		userRole.setRoleName("ROLE_USER");
		
		Role adminRole=new Role();
		adminRole.setRoleName("ROLE_ADMIN");

		User user=new User();
		user.setUserName("user");
		user.setPassword(this.passwordEncoder.encode("user"));
		
		User admin=new User();
		admin.setUserName("admin");
		admin.setPassword(this.passwordEncoder.encode("admin"));
				
		admin.addRole(adminRole);
		admin.addRole(userRole);
		
		user.addRole(userRole);
		
		userRepository.save(user);
		userRepository.save(admin);
		
		roleRepository.save(userRole);
		roleRepository.save(adminRole);
	}

}
