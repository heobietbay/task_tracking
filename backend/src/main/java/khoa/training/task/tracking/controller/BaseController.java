package khoa.training.task.tracking.controller;

import io.katharsis.queryParams.QueryParams;
import io.katharsis.queryParams.params.FilterParams;
import io.katharsis.queryParams.params.TypedParams;
import io.katharsis.repository.annotations.JsonApiFindAll;
import io.katharsis.repository.annotations.JsonApiFindOne;
import io.katharsis.repository.annotations.JsonApiSave;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;
import java.util.List;

/**
 * Created by trandangkhoa on 2/8/2017.
 */
public abstract class BaseController<T> {


    @JsonApiSave
    public T insert(T entity) {
        return (T) getJpaRepository().save(entity);
    }

    @JsonApiFindOne
    public T findOne(Serializable id, QueryParams requestParams) {
        if (id == null) {
            return null;
        }
        T object = (T) getJpaRepository().findOne(id);
        return object;
    }

    /**
     * Retrieve all object of a specific type, or object that satisfies the query filter condition.
     * @param queryParams in a form of
     *    http://host:port/api/[type]?filter[ResourceType][FieldName]=value
     *
     * Ex http://localhost:9999/api/tasktypes?filter[taskType][name]=de
     * @return a list.
     */
    @JsonApiFindAll
    public List<T> findAll(QueryParams queryParams)
    {
        if(queryParams == null)
            return getJpaRepository().findAll();

        for ( String resourceType :  queryParams.getFilters().getParams().keySet()  ) {
            if(!typeName().equals(resourceType))
                continue;

            return filterInternal(queryParams.getFilters());
        }
        return getJpaRepository().findAll();
    }

    abstract protected String typeName();
    abstract protected List<T> filterInternal(TypedParams<FilterParams> filterParamsTypedParams);
    abstract protected JpaRepository getJpaRepository();
}
