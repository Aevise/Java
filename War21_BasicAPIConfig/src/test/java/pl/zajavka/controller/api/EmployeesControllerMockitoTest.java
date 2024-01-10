package pl.zajavka.controller.api;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import pl.zajavka.api.dto.EmployeeDTO;
import pl.zajavka.api.mapper.EmployeeMapper;
import pl.zajavka.controller.util.DtoFixtures;
import pl.zajavka.controller.util.EntityFixtures;
import pl.zajavka.springrest.controller.api.EmployeesController;
import pl.zajavka.springrest.infrastructure.database.entity.EmployeeEntity;
import pl.zajavka.springrest.infrastructure.database.repository.EmployeeRepository;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class EmployeesControllerMockitoTest {

    @Mock
    private EmployeeRepository employeeRepository;

    @Mock
    private EmployeeMapper employeeMapper;

    @InjectMocks
    private EmployeesController employeesController;

    @Test
    void thatRetrievingEmployeeWorksCorrectly(){
        //given
        Integer employeeId = 10;
        EmployeeEntity employeeEntity = EntityFixtures.someEmployee1();
        when(employeeRepository.findById(employeeId)).thenReturn(Optional.of(employeeEntity));
        when(employeeMapper.map(employeeEntity)).thenReturn(DtoFixtures.someEmployee1());

        //when
        EmployeeDTO result = employeesController.employeeDetails(employeeId);

        //then
        assertThat(result).isEqualTo(DtoFixtures.someEmployee1());
    }

    void thatSavingEmployeeWorksCorrectly(){
        //given
        when(employeeRepository.save(ArgumentMatchers.any(EmployeeEntity.class)))
                .thenReturn(EntityFixtures.someEmployee1().withEmployeeId(123));

        //when
        ResponseEntity<?> result = employeesController.addEmployee(DtoFixtures.someEmployee1());

        //then
        assertThat(result.getStatusCode()).isEqualTo(HttpStatus.CREATED);
    }
}
