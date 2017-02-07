package khoa.training.task.tracking.model;

import io.katharsis.resource.annotations.JsonApiId;
import io.katharsis.resource.annotations.JsonApiResource;

import javax.persistence.*;

/**
 * Created by trandangkhoa on 2/7/2017.
 */
@JsonApiResource(type = "employees")
@Entity
@Table(name = "employee")
public class Employee {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EmployeeType getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(EmployeeType employeeType) {
        this.employeeType = employeeType;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (!name.equals(employee.name)) return false;
        if (employeeType != null ? !employeeType.equals(employee.employeeType) : employee.employeeType != null)
            return false;
        return employeeId != null ? employeeId.equals(employee.employeeId) : employee.employeeId == null;
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + (employeeType != null ? employeeType.hashCode() : 0);
        result = 31 * result + (employeeId != null ? employeeId.hashCode() : 0);
        return result;
    }

    @Column(name = "name",nullable = false,length = 20)
    private String name;

    @ManyToOne
    @JoinColumn(name = "employee_type_id")
    private EmployeeType employeeType;

    @JsonApiId
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "employee_id")
    private Integer employeeId;

}
