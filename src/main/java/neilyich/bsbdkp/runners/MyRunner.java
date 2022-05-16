package neilyich.bsbdkp.runners;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import neilyich.bsbdkp.repositories.OrdersRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Component
@RequiredArgsConstructor
public class MyRunner implements CommandLineRunner {
    private final OrdersRepository ordersRepository;

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        var orders = ordersRepository.findAllByCustomerIdOrderByIdDesc(1);
        //var order = ordersRepository.findById(1L).orElseThrow();
        //log.info("order: {}", order.getCost());
    }
}
