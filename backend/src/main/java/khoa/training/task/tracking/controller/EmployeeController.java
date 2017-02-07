package khoa.training.task.tracking.controller;

import io.katharsis.queryParams.QueryParams;
import io.katharsis.repository.annotations.JsonApiFindAll;
import io.katharsis.repository.annotations.JsonApiFindOne;
import io.katharsis.repository.annotations.JsonApiResourceRepository;
import io.katharsis.repository.annotations.JsonApiSave;
import khoa.training.task.tracking.model.Employee;
import khoa.training.task.tracking.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * Created by trandangkhoa on 2/7/2017.
 */
@JsonApiResourceRepository(Employee.class)
@Controller
public class EmployeeController {
    /**
     * Payload is like this
     * { "data": {
         "type": "employeetypes",
         "id": null,
         "attributes": {
         "name": "Developer"
             }
          }
         }
     * @param entity
     * @param <S>
     * @return
     */
    @JsonApiSave
    public <S extends Employee> S insert(S entity) {
        return employeeRepository.save(entity);
    }

    @JsonApiFindOne
    public Employee findOne(Integer employeeId, QueryParams requestParams) {
        if (employeeId == null) {
            return null;
        }
        Employee employee = employeeRepository.findOne(employeeId);
        return employee;
    }

    @JsonApiFindAll
    public List<Employee> findAll()
    {
        return employeeRepository.findAll();
    }

    @Autowired
    private EmployeeRepository employeeRepository;
}
