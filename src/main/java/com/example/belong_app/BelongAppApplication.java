package com.example.belong_app;

import com.example.belong_app.dao.PhoneNumberRepository;
import com.example.belong_app.dao.UserRepository;
import com.example.belong_app.model.PhoneNumber;
import com.example.belong_app.model.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/***
 * This is the main class of the application
 */
@SpringBootApplication
public class BelongAppApplication  extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(BelongAppApplication.class);
	}

	/***
	 * Main method
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		SpringApplication.run(BelongAppApplication.class, args);
	}

	/***
	 * This method is used to add initial data to the db. 3 users and 5 phone number entities will be created.
	 * @param userRepo
	 * @param phoneNumberRepo
	 * @return
	 */
	@Bean
	CommandLineRunner init (UserRepository userRepo, PhoneNumberRepository phoneNumberRepo){
		return args -> {

			DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

			User a = new User("User a","a","Male","address1","email1@gmail.com", formatter.parse("06/12/1991"));
			userRepo.save(a);

			PhoneNumber savedPhoneA1 =phoneNumberRepo.save(new PhoneNumber("5469584", "active", formatter.parse(formatter.format(new Date())), a.getId()));
			PhoneNumber savedPhoneA2 =phoneNumberRepo.save(new PhoneNumber("23784589", "inactive", formatter.parse(formatter.format(new Date())), a.getId()));


			ArrayList<PhoneNumber> list= new ArrayList<>();
			list.add(savedPhoneA1);
			list.add(savedPhoneA2);
			a.setPhoneNumbers(list);

			userRepo.save(a);

			User b = userRepo.save(new User("User b","b","Male","address2","email2@gmail.com", formatter.parse("06/12/1991")));

			PhoneNumber savedPhoneB1 =phoneNumberRepo.save(new PhoneNumber("5489043", "active", formatter.parse(formatter.format(new Date())), b.getId()));
			PhoneNumber savedPhoneB2 =phoneNumberRepo.save(new PhoneNumber("97675674", "inactive", formatter.parse(formatter.format(new Date())), b.getId()));

			ArrayList<PhoneNumber> list2= new ArrayList<>();
			list2.add(savedPhoneB1);
			list2.add(savedPhoneB2);
			b.setPhoneNumbers(list2);

			userRepo.save(b);

			userRepo.save(new User("User c","c","Female","address3","email3@gmail.com", formatter.parse("06/12/1991")));

			phoneNumberRepo.save(new PhoneNumber("23345456", "inactive", null, null));
		};
	}

}