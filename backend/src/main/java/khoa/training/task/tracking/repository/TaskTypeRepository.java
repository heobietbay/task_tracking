package khoa.training.task.tracking.repository;

import khoa.training.task.tracking.model.TaskType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by trandangkhoa on 2/7/2017.
 */
public interface TaskTypeRepository extends JpaRepository<TaskType,Integer> {
    @Query("select taskType from TaskType as taskType where UPPER(taskType.name) like UPPER(:name)" )
    List<TaskType> findByName(@Param("name") String name);
}
