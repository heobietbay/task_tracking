package khoa.training.task.tracking.model;

import io.katharsis.resource.annotations.JsonApiId;
import io.katharsis.resource.annotations.JsonApiResource;

import javax.persistence.*;

/**
 * Created by trandangkhoa on 2/7/2017.
 */

@JsonApiResource(type = "tasktypes")
@Entity
@Table(name = "task_type")
public class TaskType {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTaskTypeId() {
        return taskTypeId;
    }

    public void setTaskTypeId(Integer id) {
        this.taskTypeId = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TaskType taskType = (TaskType) o;

        if (!name.equals(taskType.name)) return false;
        return taskTypeId.equals(taskType.taskTypeId);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + taskTypeId.hashCode();
        return result;
    }

    @Column(name = "name",nullable = false,length = 20)
    private String name;

    @JsonApiId
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "task_type_id")
    private Integer taskTypeId;
}
