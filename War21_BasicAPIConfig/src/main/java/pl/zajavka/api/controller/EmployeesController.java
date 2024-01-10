package pl.zajavka.api.controller;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.zajavka.api.dao.PetDAO;
import pl.zajavka.api.dto.EmployeeDTO;
import pl.zajavka.api.dto.EmployeesDTO;
import pl.zajavka.api.mapper.EmployeeMapper;
import pl.zajavka.springrest.infrastructure.database.entity.EmployeeEntity;
import pl.zajavka.springrest.infrastructure.database.entity.PetEntity;
import pl.zajavka.springrest.infrastructure.database.repository.EmployeeRepository;
import pl.zajavka.springrest.infrastructure.database.repository.PetRepository;
import pl.zajavka.springrest.infrastructure.petstore.Pet;

import java.math.BigDecimal;

@RestController
@AllArgsConstructor
@RequestMapping(EmployeesController.EMPLOYEES)
public class EmployeesController {

    public static final String EMPLOYEES = "/employees";
    public static final String EMPLOYEE_ID = "/{employeeId}";
    public static final String EMPLOYEE_ID_RESULT = "/%s";
    public static final String EMPLOYEE_UPDATE_SALARY = "/{employeeId}/salary";
    public static final String EMPLOYEE_UPDATE_PET = "/{employeeId}/pet/{petId}";

    private EmployeeRepository employeeRepository;
    private EmployeeMapper employeeMapper;
    private PetDAO petDAO;
    private PetRepository petRepository;

    @GetMapping()
    public EmployeesDTO employeesList() {
        return EmployeesDTO.of(employeeRepository.findAll().stream()
                .map(employeeMapper::map)
                .toList());
    }

    @GetMapping(
            value = EMPLOYEE_ID,
            produces = {
                    MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE
            })
    public EmployeeDTO employeeDetailsAsJSON(@PathVariable Integer employeeId) {
        return employeeRepository.findById(employeeId)
                .map(a -> employeeMapper.map(a))
                .orElseThrow(() -> new EntityNotFoundException(
                        "EmployeeEntity not found, employeeId: [%s]".formatted(employeeId)
                ));
    }


    @PostMapping
    @Transactional
    //@RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<EmployeeDTO> addEmployee(
            @Valid @RequestBody EmployeeDTO employeeDTO
    ) {
        //metoda tworzaca i zapisujaca do bazy obiekt pracownika
        EmployeeEntity employeeEntity = EmployeeEntity.builder()
                .name(employeeDTO.getName())
                .surname(employeeDTO.getSurname())
                .salary(employeeDTO.getSalary())
                .phone(employeeDTO.getPhone())
                .email(employeeDTO.getEmail())
                .build();
        EmployeeEntity created = employeeRepository.save(employeeEntity);


        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", EMPLOYEES + EMPLOYEE_ID_RESULT.formatted(created.getEmployeeId()));
        return new ResponseEntity<>(
                headers,
                HttpStatus.CREATED

        );
//        return ResponseEntity
//                .created(URI.create(EMPLOYEES + EMPLOYEE_ID_RESULT.formatted(created.getEmployeeId())))
//                .build();
    }

    @PutMapping(EMPLOYEE_ID)
    @Transactional
    public ResponseEntity<?> updateEmployee(
            @PathVariable Integer employeeId,
            @Valid @RequestBody EmployeeDTO employeeDTO
    ) {
        EmployeeEntity existingEmployee = employeeRepository.findById(employeeId).orElseThrow(() -> new EntityNotFoundException(
                "EmployeeEnitty not found, employeeId: [%s]".formatted(employeeId)
        ));
        existingEmployee.setName(employeeDTO.getName());
        existingEmployee.setSurname(employeeDTO.getSurname());
        existingEmployee.setSalary(employeeDTO.getSalary());
        existingEmployee.setPhone(employeeDTO.getPhone());
        existingEmployee.setEmail(employeeDTO.getEmail());
        employeeRepository.save(existingEmployee);

        return ResponseEntity.ok().build();
    }

    @DeleteMapping(EMPLOYEE_ID)
    public ResponseEntity<?> deleteEmployee(
            @PathVariable Integer employeeId
    ) {
        EmployeeEntity existingEmployee = employeeRepository.findById(employeeId).orElseThrow(() -> new EntityNotFoundException(
                "EmployeeEnitty not found, employeeId: [%s]".formatted(employeeId)
        ));
        employeeRepository.deleteById(existingEmployee.getEmployeeId());
        return ResponseEntity.noContent().build();
    }

    @PatchMapping(EMPLOYEE_UPDATE_SALARY)
    public ResponseEntity<?> UpdateEmployeeSalary(
            @PathVariable Integer employeeId,
            @RequestParam(required = true) BigDecimal newSalary
    ) {
        EmployeeEntity existingEmployee = employeeRepository.findById(employeeId).orElseThrow(() -> new EntityNotFoundException(
                "EmployeeEnitty not found, employeeId: [%s]".formatted(employeeId)
        ));
        existingEmployee.setSalary(newSalary);
        employeeRepository.save(existingEmployee);

        return ResponseEntity.ok().build();
    }

    @PatchMapping(EMPLOYEE_UPDATE_PET)
    @Transactional
    public ResponseEntity<?> updateEmployeeWithPet(
            @PathVariable Integer employeeId,
            @PathVariable Integer petId
    ) {
        EmployeeEntity existingEmployee = employeeRepository.findById(employeeId).orElseThrow(() -> new EntityNotFoundException(
                "EmployeeEnitty not found, employeeId: [%s]".formatted(employeeId)
        ));
        Pet petFromStore = petDAO.getPet(Long.valueOf(petId)).orElseThrow(() -> new RuntimeException(
                        "Pet with id: [%s] could not be retrieved".formatted(petId)
                )
        );

        PetEntity newPet = PetEntity.builder()
                .petStorePetId(petFromStore.getId())
                .name(petFromStore.getName())
                .category(petFromStore.getCategory())
                .employee(existingEmployee)
                .build();
        petRepository.save(newPet);
        return ResponseEntity.ok().build();

    }


    @GetMapping(value = "test-header")
    public ResponseEntity<?> testHeader(
            @RequestHeader(value = HttpHeaders.ACCEPT) MediaType accept,
            @RequestHeader(value = "httpStatus", required = true) int httpStatus
    ) {
        return ResponseEntity
                .status(httpStatus)
                .body("Accepted: " + accept);

    }


//
//    @PatchMapping("/{employeeId}")
//    public ResponseEntity<?> partiallyUpdateEmployee(
//            @PathVariable Integer employeeId
//    ) {
//
//    }
//
//    private EmployeeDTO apply(EmployeeEntity a) {
//        return employeeMapper.map(a);
//    }
}
