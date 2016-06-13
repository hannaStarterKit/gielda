/**
 * 
 */
package pl.spring.demo.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import javax.validation.constraints.NotNull;

import javax.persistence.*;

/**
 * @author HSIENKIE
 *
 */
@Entity
@Table(name = "STOCK")
public class StockEntity implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotNull(message="Stock name cannot be null")
	@Column(nullable = false, length = 30, name = "name")
	private String name;
	
	@NotNull(message="Price cannot be null")
	@Column(nullable = false, precision = 10, scale = 2)
	private BigDecimal price;
	
	@NotNull(message="Date cannot be null")
	@Column(nullable = false, name = "date")
	private Date date;



	// for hibernate
	protected StockEntity() {
	}

	public StockEntity(Long id, String name, Date date, BigDecimal price) {
		this.id = id;
		this.name = name;
		this.date = date;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
