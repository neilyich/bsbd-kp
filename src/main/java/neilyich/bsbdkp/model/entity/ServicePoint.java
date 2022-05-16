package neilyich.bsbdkp.model.entity;


import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "service_points")
public class ServicePoint {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "city")
    private String city;
    @Column(name = "address")
    private String address;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "servicePoint")
    private List<Employee> attachedEmployees;
}
