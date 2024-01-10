package pl.zajavka.controller.api;

import lombok.RequiredArgsConstructor;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import pl.zajavka.api.dao.PetDAO;
import pl.zajavka.api.dto.EmployeeDTO;
import pl.zajavka.api.mapper.EmployeeMapper;
import pl.zajavka.controller.util.DtoFixtures;
import pl.zajavka.controller.util.EntityFixtures;
import pl.zajavka.springrest.controller.api.EmployeesController;
import pl.zajavka.springrest.infrastructure.database.entity.EmployeeEntity;
import pl.zajavka.springrest.infrastructure.database.repository.EmployeeRepository;
import pl.zajavka.springrest.infrastructure.database.repository.PetRepository;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.stream.Stream;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;


@WebMvcTest(controllers = EmployeesController.class)
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class EmployeesControllerWebMVCTest {

    private final MockMvc mockMvc;

    @MockBean
    private EmployeeRepository employeeRepository;
    @MockBean
    private EmployeeMapper employeeMapper;
    @MockBean
    private PetDAO petDAO;
    @MockBean
    private PetRepository petRepository;

    @Test
    public void thatEmployeeCanBeRetrieved() throws Exception {
        //given
        int employeeId = 123;
        EmployeeEntity employeeEntity = EntityFixtures.someEmployee1().withEmployeeId(employeeId);
        EmployeeDTO employeeDTO = DtoFixtures.someEmployee1().withEmployeeId(employeeId);

        Mockito.when(employeeRepository.findById(employeeId)).thenReturn(Optional.of(employeeEntity));
        Mockito.when(employeeMapper.map(ArgumentMatchers.any(EmployeeEntity.class))).thenReturn(employeeDTO);

        //when, then
        String endpoint = EmployeesController.EMPLOYEES + EmployeesController.EMPLOYEE_ID;
        mockMvc.perform(MockMvcRequestBuilders.get(endpoint, employeeId))
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.employeeId", Matchers.is(employeeDTO.getEmployeeId())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name", Matchers.is(employeeDTO.getName())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.surname", Matchers.is(employeeDTO.getSurname())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.salary", Matchers.is(employeeDTO.getSalary()), BigDecimal.class))
                .andExpect(MockMvcResultMatchers.jsonPath("$.phone", Matchers.is(employeeDTO.getPhone())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.email", Matchers.is(employeeDTO.getEmail())));
    }

    @Test
    void thatEmailValidationWorksCorrectly() throws Exception {
        //given
        final var request = """
                {
                "email":"badEmail
                }
                """;

        //when, then
        mockMvc.perform(
                        post(EmployeesController.EMPLOYEES)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(request))
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.errorId", Matchers.notNullValue()));
    }

    @ParameterizedTest
    @MethodSource
    void thatPhoneValidatonWorksCorrectly(Boolean correctPhone, String phone) throws Exception {
        //given
        final var request = """
                {
                    "phone": "%s"
                }
                """;
        Mockito.when(employeeRepository.save(ArgumentMatchers.any(EmployeeEntity.class)))
                .thenReturn(EntityFixtures.someEmployee1().withEmployeeId(123));

        //when, then
        if (correctPhone) {
            String expectedRedirect = EmployeesController.EMPLOYEES
                    + EmployeesController.EMPLOYEE_ID_RESULT.formatted(123);
            mockMvc.perform(MockMvcRequestBuilders.post(EmployeesController.EMPLOYEES)
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(request))
                    .andExpect(MockMvcResultMatchers.status().isCreated())
                    .andExpect(MockMvcResultMatchers.redirectedUrl(expectedRedirect));
        } else {
            mockMvc.perform(post(EmployeesController.EMPLOYEES)
                            .contentType(MediaType.APPLICATION_JSON)
                            .contentType(request))
                    .andExpect(MockMvcResultMatchers.status().isBadRequest())
                    .andExpect(MockMvcResultMatchers.jsonPath("$.errorId", Matchers.notNullValue()));
        }
    }

    public static Stream<Arguments> thatPhoneValidationWorksCorrectly(){
        return Stream.of(
                Arguments.of(false, "")
        );
    }

}
