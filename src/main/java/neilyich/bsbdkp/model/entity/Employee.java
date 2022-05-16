package neilyich.bsbdkp.model.entity;

import lombok.Data;
import neilyich.bsbdkp.model.EmployeeRole;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "second_name")
    private String secondName;
    @Column(name = "patronymic")
    private String patronymic;
    @Column(name = "employee_role")
    @Enumerated(EnumType.STRING)
    private EmployeeRole role;
    @Column(name = "has_driver_license")
    private Boolean hasDriverLicense;

    @ManyToOne
    @JoinColumn(name = "service_point_id")
    private ServicePoint servicePoint;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "assignedEmployee")
    private List<Order> assignedOrders;
}
