package khoa.training.task.tracking.controller;

import io.katharsis.queryParams.params.FilterParams;
import io.katharsis.queryParams.params.TypedParams;
import io.katharsis.repository.annotations.JsonApiResourceRepository;
import khoa.training.task.tracking.model.TaskType;
import khoa.training.task.tracking.repository.TaskTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * Created by trandangkhoa on 2/7/2017.
 */
@JsonApiResourceRepository(TaskType.class)
@Controller
public class TaskTypeController extends BaseController<TaskType>{

    @Override
    protected List<TaskType> filterInternal(TypedParams<FilterParams> filterParamsTypedParams) {
        FilterParams taskTypeFilterParams = filterParamsTypedParams.getParams().get(typeName());
        String paramName = (String) taskTypeFilterParams.getParams().get("name").toArray()[0];
        return taskTypeRepository.findByName("%" +  paramName + "%" );
    }


    @Override
    protected String typeName() {
        return "taskType";
    }

    @Override
    protected JpaRepository getJpaRepository() {
        return taskTypeRepository;
    }

    @Autowired
    private TaskTypeRepository taskTypeRepository;
}
