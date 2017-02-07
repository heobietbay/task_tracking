package khoa.training.task.tracking.model;

import io.katharsis.resource.annotations.JsonApiId;

import javax.persistence.*;

/**
 * Created by trandangkhoa on 2/7/2017.
 */
public class TaskHistory {

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TaskHistory that = (TaskHistory) o;

        return taskHistoryId != null ? taskHistoryId.equals(that.taskHistoryId) : that.taskHistoryId == null;
    }

    @Override
    public int hashCode() {
        return taskHistoryId != null ? taskHistoryId.hashCode() : 0;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getTaskHistoryId() {
        return taskHistoryId;
    }

    public void setTaskHistoryId(Integer taskHistoryId) {
        this.taskHistoryId = taskHistoryId;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    @Column(name = "description",nullable = false,length = 1000)
    private String description;

    @JsonApiId
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "task_history_id")
    private Integer taskHistoryId;

    @ManyToOne
    @JoinColumn(name = "task_id")
    private Task task;
}
