package khoa.training.task.tracking.controller;

import io.katharsis.queryParams.QueryParams;
import io.katharsis.queryParams.params.FilterParams;
import io.katharsis.queryParams.params.TypedParams;
import io.katharsis.repository.annotations.JsonApiFindAll;
import io.katharsis.repository.annotations.JsonApiFindOne;
import io.katharsis.repository.annotations.JsonApiResourceRepository;
import io.katharsis.repository.annotations.JsonApiSave;
import khoa.training.task.tracking.model.EmployeeType;
import khoa.training.task.tracking.repository.EmployeeTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * Created by trandangkhoa on 2/7/2017.
 */
@JsonApiResourceRepository(EmployeeType.class)
@Controller
public class EmployeeTypeController {

    @JsonApiSave
    public <S extends EmployeeType> S insert(S entity) {
        return employeeTypeRepository.save(entity);
    }

    @JsonApiFindOne
    public EmployeeType findOne(Integer employeeTypeId, QueryParams requestParams) {
        if (employeeTypeId == null) {
            return null;
        }
        EmployeeType taskType = employeeTypeRepository.findOne(employeeTypeId);
        return taskType;
    }

    /**
     * Retrieve all employee type, or one that satisfies the query filter condition.
     * @param queryParams in a form of
     *    http://host:port/api/employeetypes?filter[ResourceType][FieldName]=value
     *
     * Ex http://localhost:9999/api/employeetypes?filter[employeeType][name]=de
     * @return a list.
     */
    @JsonApiFindAll
    public List<EmployeeType> findAll(QueryParams queryParams)
    {
        if(queryParams == null)
            return employeeTypeRepository.findAll();

        return searchInternal(queryParams.getFilters());
    }

    private List<EmployeeType> searchInternal(TypedParams<FilterParams> filterParamsTypedParams)
    {
        for ( String resourceType :  filterParamsTypedParams.getParams().keySet()  ) {

            if(!"employeeType".equals(resourceType))
                continue;

            FilterParams taskTypeFilterParams = filterParamsTypedParams.getParams().get(resourceType);
            String paramName = (String) taskTypeFilterParams.getParams().get("name").toArray()[0];
            return employeeTypeRepository.findByName("%" +  paramName + "%" );
        }
        return employeeTypeRepository.findAll();
    }
    @Autowired
    private EmployeeTypeRepository employeeTypeRepository;
}
