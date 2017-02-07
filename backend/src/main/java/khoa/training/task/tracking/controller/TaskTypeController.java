package khoa.training.task.tracking.controller;

import io.katharsis.queryParams.QueryParams;
import io.katharsis.repository.annotations.JsonApiFindAll;
import io.katharsis.repository.annotations.JsonApiFindOne;
import io.katharsis.repository.annotations.JsonApiResourceRepository;
import io.katharsis.repository.annotations.JsonApiSave;
import khoa.training.task.tracking.model.TaskType;
import khoa.training.task.tracking.repository.TaskTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * Created by trandangkhoa on 2/7/2017.
 */
@JsonApiResourceRepository(TaskType.class)
@Controller
public class TaskTypeController {

    @JsonApiSave
    public <S extends TaskType> S insert(S entity) {
        return taskTypeRepository.save(entity);
    }

    @JsonApiFindOne
    public TaskType findOne(Integer taskId, QueryParams requestParams) {
        if (taskId == null) {
            return null;
        }
        TaskType taskType = taskTypeRepository.findOne(taskId);
        return taskType;
    }

    @JsonApiFindAll
    public List<TaskType> findAll()
    {
        return taskTypeRepository.findAll();
    }

    @Autowired
    private TaskTypeRepository taskTypeRepository;
}
