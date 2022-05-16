package neilyich.bsbdkp.model.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "transports")
public class Transport {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "registration_number")
    private String registrationNumber;
}
