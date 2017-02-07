package khoa.training.task.tracking.repository;

import khoa.training.task.tracking.model.Task;
import khoa.training.task.tracking.model.TaskType;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by trandangkhoa on 2/7/2017.
 */
public interface TaskTypeRepository extends JpaRepository<TaskType,Integer> {
}
