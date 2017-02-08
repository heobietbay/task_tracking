package khoa.training.task.tracking.controller;

import io.katharsis.queryParams.params.FilterParams;
import io.katharsis.queryParams.params.TypedParams;
import io.katharsis.repository.annotations.JsonApiResourceRepository;
import khoa.training.task.tracking.model.EmployeeType;
import khoa.training.task.tracking.repository.EmployeeTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * Created by trandangkhoa on 2/7/2017.
 */
@JsonApiResourceRepository(EmployeeType.class)
@Controller
public class EmployeeTypeController extends BaseController<EmployeeType>{

    protected List<EmployeeType> filterInternal(TypedParams<FilterParams> filterParamsTypedParams)
    {
        FilterParams taskTypeFilterParams = filterParamsTypedParams.getParams().get(typeName());
        String paramName = (String) taskTypeFilterParams.getParams().get("name").toArray()[0];
        return employeeTypeRepository.findByName("%" +  paramName + "%" );
    }


    @Override
    protected String typeName() {
        return "employeeType";
    }

    @Override
    protected JpaRepository getJpaRepository() {
        return employeeTypeRepository;
    }

    @Autowired
    private EmployeeTypeRepository employeeTypeRepository;
}
