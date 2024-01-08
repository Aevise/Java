package pl.zajavka.springrest.infrastructure.configuration;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import pl.zajavka.springrest.infrastructure.database.entity.EmployeeEntity;
import pl.zajavka.springrest.infrastructure.database.repository.EmployeeRepository;
import pl.zajavka.springrest.infrastructure.database.repository.PetRepository;

import java.math.BigDecimal;

@Slf4j
@Component
@AllArgsConstructor
public class BootstrapApplicationComponent implements ApplicationListener<ContextRefreshedEvent> {

    private EmployeeRepository employeeRepository;
    private PetRepository petRepository;

    @Override
    @Transactional
    public void onApplicationEvent(final @NonNull ContextRefreshedEvent event) {
//        if (!employeeRepository.findAll().isEmpty()) {
//            return;
//        }
        petRepository.deleteAll();
        employeeRepository.deleteAll();

        employeeRepository.save(EmployeeEntity.builder()
                .name("Stefan")
                .surname("Zajavka")
                .salary(new BigDecimal("52322.00"))
                .phone("579384")
                .email("hehe@gmail.com")
                .build());
        employeeRepository.save(EmployeeEntity.builder()
                .name("Agnieszka")
                .surname("Spring")
                .salary(new BigDecimal("62341.00"))
                .phone("34624423")
                .email("Nothehe@gmail.com")
                .build());
        employeeRepository.save(EmployeeEntity.builder()
                .name("Tomasz")
                .surname("Hibernate")
                .salary(new BigDecimal("53231.00"))
                .phone("346568 3214")
                .email("xDD@hehe.pl")
                .build());
    }
}