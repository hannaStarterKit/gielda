package pl.spring.demo.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;


/**
 * The persistent class for the account database table.
 * 
 */
@Entity
@Table(name = "ACCOUNT")
@NamedQuery(name="AccountEntity.findAll", query="SELECT a FROM AccountEntity a")
public class AccountEntity implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	@Column(nullable = false, name="balance")
	private BigDecimal balance;

	@Column(nullable = false, name="monetary_unit")
	private String monetaryUnit;
	
	@OneToMany(mappedBy = "account", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
	private Set<BrokerEntity> brokers = new HashSet<>();

	protected AccountEntity() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getBalance() {
		return this.balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public String getMonetaryUnit() {
		return this.monetaryUnit;
	}

	public void setMonetaryUnit(String monetaryUnit) {
		this.monetaryUnit = monetaryUnit;
	}

}