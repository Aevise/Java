package pl.zajavka.controller.integration.configuration;

import org.junit.jupiter.api.AfterEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;
import pl.zajavka.SpringRestExampleApplication;
import pl.zajavka.springrest.infrastructure.database.repository.EmployeeRepository;
import pl.zajavka.springrest.infrastructure.database.repository.PetRepository;

@ActiveProfiles("test")
@Import(PersistenceContainterTestConfiguration.class)
@SpringBootTest(
        classes = {SpringRestExampleApplication.class},
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
public abstract class AbstractIntegrationTest {

    @Autowired
    private PetRepository petRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @AfterEach
    public void after(){
        //przydatne przy czysszceniu danych po kazdym tescie i budowie wsystkiego na nbowo
        petRepository.deleteAll();
        employeeRepository.deleteAll();
    }
}
