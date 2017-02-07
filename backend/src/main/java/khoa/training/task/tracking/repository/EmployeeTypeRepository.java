package khoa.training.task.tracking.repository;

import khoa.training.task.tracking.model.EmployeeType;
import khoa.training.task.tracking.model.TaskType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by trandangkhoa on 2/7/2017.
 */
public interface EmployeeTypeRepository extends JpaRepository<EmployeeType,Integer> {
    @Query("select employeeType from EmployeeType as employeeType where UPPER(employeeType.name) like UPPER(:name)" )
    List<EmployeeType> findByName(@Param("name") String name);
}
