package khoa.training.task.tracking.controller;

import io.katharsis.queryParams.QueryParams;
import io.katharsis.repository.annotations.JsonApiFindAll;
import io.katharsis.repository.annotations.JsonApiFindOne;
import io.katharsis.repository.annotations.JsonApiResourceRepository;
import io.katharsis.repository.annotations.JsonApiSave;
import khoa.training.task.tracking.model.Task;
import khoa.training.task.tracking.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * Created by trandangkhoa on 2/7/2017.
 */
@JsonApiResourceRepository(Task.class)
@Controller
public class TaskController {

    /**
     * Accept both POST and PATCH operation.
     *   <p>For POST, it will be an insert new.
     *     Url: http://host:port/api/tasks. Ex: http://localhost:9999/api/tasks
     *  </p>
     *   <p>For PATCH, it will be an update. This <strong>requires</strong> method annotated with <strong><i>@JsonApiFindOne</i></strong>
     *   <li>Url: http://host:port/api/tasks/{id}. Ex: http://localhost:9999/api/tasks/1</li>
     *     </p>
     * @param entity
     * @param <S>
     * @return
     */
    @JsonApiSave
    public <S extends Task> S insert(S entity) {
        return taskRepository.save(entity);
    }

    @JsonApiFindOne
    public Task findOne(Integer taskId, QueryParams requestParams) {
        if (taskId == null) {
            return null;
        }
        Task task = taskRepository.findOne(taskId);
        return task;
    }

    @JsonApiFindAll
    public List<Task> findAll(QueryParams requestParams)
    {
        Sort.Order sortOrder = new Sort.Order(Sort.Direction.ASC,"taskId");
        return taskRepository.findAll(new Sort(sortOrder));
    }

    @Autowired
    private TaskRepository taskRepository;
}
