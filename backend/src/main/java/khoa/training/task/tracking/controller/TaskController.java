package khoa.training.task.tracking.controller;

import io.katharsis.queryParams.QueryParams;
import io.katharsis.repository.annotations.JsonApiFindAll;
import io.katharsis.repository.annotations.JsonApiFindOne;
import io.katharsis.repository.annotations.JsonApiResourceRepository;
import io.katharsis.repository.annotations.JsonApiSave;
import khoa.training.task.tracking.model.Task;
import khoa.training.task.tracking.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * Created by trandangkhoa on 2/7/2017.
 */
@JsonApiResourceRepository(Task.class)
@Controller
public class TaskController {

    @JsonApiSave
    public <S extends Task> S insert(S entity) {
        return taskRepository.save(entity);
    }

    @JsonApiFindOne
    public Task findOne(Integer taskId, QueryParams requestParams) {
        if (taskId == null) {
            return null;
        }
        return null;
    }

    @JsonApiFindAll
    public List<Task> findAll()
    {
        return taskRepository.findAll();
    }

    @Autowired
    private TaskRepository taskRepository;
}
