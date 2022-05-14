package net.javaguides.springbootbackend;

import net.javaguides.springbootbackend.model.Employee;
import net.javaguides.springbootbackend.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
public class SpringbootBackendApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootBackendApplication.class, args);
	}

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public void run(String... args) throws Exception {
       /* Employee employee = new Employee();
	   employee.setFirstname("Jun");
	   employee.setLastname("Wu");
	   employee.setEmailid("junwutx@hotmail.com");
	   employeeRepository.save(employee);

		Employee employee1 = new Employee();
		employee1.setFirstname("Dan");
		employee1.setLastname("Ye");
		employee1.setEmailid("yedantx@hotmail.com");
		employeeRepository.save(employee1); */
	}
}
