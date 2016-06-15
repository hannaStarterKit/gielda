package pl.spring.demo.repository;

import pl.spring.demo.entity.Broker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrokerRepository extends JpaRepository<Broker, Long> {


}
