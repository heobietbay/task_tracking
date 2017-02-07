package khoa.training.task.tracking.model;

import io.katharsis.resource.annotations.JsonApiId;
import io.katharsis.resource.annotations.JsonApiResource;

import javax.persistence.*;

/**
 * Created by trandangkhoa on 2/7/2017.
 */
@JsonApiResource(type = "employeetypes")
@Entity
@Table(name = "employee_type")
public class EmployeeType {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getEmployeeTypeId() {
        return employeeTypeId;
    }

    public void setEmployeeTypeId(Integer employeeTypeId) {
        this.employeeTypeId = employeeTypeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EmployeeType that = (EmployeeType) o;

        if (!name.equals(that.name)) return false;
        return employeeTypeId != null ? employeeTypeId.equals(that.employeeTypeId) : that.employeeTypeId == null;
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + (employeeTypeId != null ? employeeTypeId.hashCode() : 0);
        return result;
    }

    @Column(name = "name",nullable = false,length = 20)
    private String name;

    @JsonApiId
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "employee_type_id")
    private Integer employeeTypeId;

}
