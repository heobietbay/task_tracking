package khoa.training.task.tracking.model;

import io.katharsis.resource.annotations.JsonApiId;
import io.katharsis.resource.annotations.JsonApiResource;

import javax.persistence.*;

/**
 * Created by trandangkhoa on 2/7/2017.
 */

@Entity
@Table(name = "task")
@JsonApiResource(type = "tasks")
public class Task {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer id) {
        this.taskId = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TaskType getTaskType() {
        return taskType;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Task task = (Task) o;

        if (!name.equals(task.name)) return false;
        if (description != null ? !description.equals(task.description) : task.description != null) return false;
        if (!taskId.equals(task.taskId)) return false;
        return taskType != null ? taskType.equals(task.taskType) : task.taskType == null;
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + taskId.hashCode();
        result = 31 * result + (taskType != null ? taskType.hashCode() : 0);
        return result;
    }

    public void setTaskType(TaskType taskType) {
        this.taskType = taskType;

    }

    @Column(name = "name",nullable = false,length = 50)
    private String name;

    @Column(name = "description",nullable = false,length = 1000)
    private String description;

    @JsonApiId
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "task_id")
    private Integer taskId;

    @ManyToOne
    @JoinColumn(name = "task_type_id")
    private TaskType taskType;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;
}
