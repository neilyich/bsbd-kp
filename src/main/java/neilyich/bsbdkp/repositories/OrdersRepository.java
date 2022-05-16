package neilyich.bsbdkp.repositories;

import neilyich.bsbdkp.model.entity.Order;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrdersRepository extends CrudRepository<Order, Long> {
    List<Order> findAllByCustomerIdOrderByIdDesc(Integer customerId);
}
