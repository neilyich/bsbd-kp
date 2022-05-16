package neilyich.bsbdkp.model.entity;

import lombok.Data;
import neilyich.bsbdkp.model.OrderStatus;
import neilyich.bsbdkp.model.OrderType;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "cost")
    private BigDecimal cost;
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private OrderStatus status;
    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private OrderType type;
    @Column(name = "completion_date")
    private LocalDateTime completionDate;

    @ManyToOne
    @JoinColumn(name = "assigned_employee_id")
    private Employee assignedEmployee;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
}
