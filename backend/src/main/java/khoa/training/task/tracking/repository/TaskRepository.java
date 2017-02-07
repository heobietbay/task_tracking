package khoa.training.task.tracking.repository;

import khoa.training.task.tracking.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by trandangkhoa on 2/7/2017.
 */
public interface TaskRepository extends JpaRepository<Task,Integer> {
}
