package payroll;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(EmployeeRepository employeeRepository, OrderRepository orderRepository) {

        return args -> {
            employeeRepository.save(new Employee("Bilbo", "Baggins", "burglar"));
            employeeRepository.save(new Employee("Frodo", "Aggins", "thief"));
            employeeRepository.save(new Employee("Noah", "Nemri", "Alternants"));
            employeeRepository.save(new Employee("Nathan", "Nemri", "Etudiant"));
            employeeRepository.save(new Employee("Nael", "Nemri", "Ecolier"));


            employeeRepository.findAll().forEach(employee -> log.info("Preloaded " + employee));


            orderRepository.findAll().forEach(order -> {
                log.info("Preloaded " + order);
            });

        };
    }
}