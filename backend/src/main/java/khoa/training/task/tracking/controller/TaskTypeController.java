package khoa.training.task.tracking.controller;

import io.katharsis.queryParams.QueryParams;
import io.katharsis.queryParams.params.FilterParams;
import io.katharsis.queryParams.params.TypedParams;
import io.katharsis.repository.annotations.*;
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
    public TaskType findOne(Integer taskTypeId, QueryParams requestParams) {
        if (taskTypeId == null) {
            return null;
        }
        TaskType taskType = taskTypeRepository.findOne(taskTypeId);
        return taskType;
    }

    /**
     * Retrieve all task type, or task type that satisfies the query filter condition.
     * @param queryParams in a form of
     *    http://host:port/api/tasktypes?filter[ResourceType][FieldName]=value
     *
     * Ex http://localhost:9999/api/tasktypes?filter[taskType][name]=de
     * @return a list.
     */
    @JsonApiFindAll
    public List<TaskType> findAll(QueryParams queryParams)
    {
        if(queryParams == null)
            return taskTypeRepository.findAll();

        return searchInternal(queryParams.getFilters());
    }

    private List<TaskType> searchInternal(TypedParams<FilterParams> filterParamsTypedParams)
    {
        for ( String resourceType :  filterParamsTypedParams.getParams().keySet()  ) {

            if(!"taskType".equals(resourceType))
                continue;

            FilterParams taskTypeFilterParams = filterParamsTypedParams.getParams().get(resourceType);
            String paramName = (String) taskTypeFilterParams.getParams().get("name").toArray()[0];
            return taskTypeRepository.findByName("%" +  paramName + "%" );
        }
        return taskTypeRepository.findAll();
    }
    @Autowired
    private TaskTypeRepository taskTypeRepository;
}
