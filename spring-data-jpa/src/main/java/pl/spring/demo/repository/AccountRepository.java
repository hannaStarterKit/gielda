package pl.spring.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.spring.demo.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {

}
