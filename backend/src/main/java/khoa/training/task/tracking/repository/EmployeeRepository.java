package khoa.training.task.tracking.repository;

import khoa.training.task.tracking.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by trandangkhoa on 2/7/2017.
 */
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

}
