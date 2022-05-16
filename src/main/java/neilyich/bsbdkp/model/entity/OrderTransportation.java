package neilyich.bsbdkp.model.entity;

import lombok.Data;
import neilyich.bsbdkp.model.TransportationType;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "order_transportations")
public class OrderTransportation {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "transportation_type")
    @Enumerated(EnumType.STRING)
    private TransportationType transportationType;
    @Column(name = "start_date")
    private LocalDateTime startDate;
    @Column(name = "end_date")
    private LocalDateTime endDate;

    @ManyToOne
    @JoinColumn(name = "assigned_employee_id")
    private Employee driverEmployee;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "transport_id")
    private Transport transport;
}
