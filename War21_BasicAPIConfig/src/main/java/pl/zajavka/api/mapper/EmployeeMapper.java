package pl.zajavka.api.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import pl.zajavka.api.dto.EmployeeDTO;
import pl.zajavka.springrest.infrastructure.database.entity.EmployeeEntity;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EmployeeMapper {
    EmployeeDTO map(EmployeeEntity employeeEntity);
}
