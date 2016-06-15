package pl.spring.demo.entity;

import java.io.Serializable;
import javax.persistence.*;

import pl.spring.demo.player.OfferType;

import java.math.BigDecimal;

/**
 * The persistent class for the offer database table.
 * 
 */
@Entity
@Table(name = "OFFER")
@NamedQuery(name = "OfferEntity.findAll", query = "SELECT o FROM OfferEntity o")
public class OfferEntity implements Serializable {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false, name = "finished")
	private boolean finished;

	@Column(nullable = false, name = "offer_type")
	private OfferType offerType;
	
	@Column(nullable = false, name = "stock_name", length=30)
	private String stockName;

	@Column(nullable = false, name = "player_id")
	private Long playerId;

	@Column(nullable = false, name = "stock_price")
	private BigDecimal stockPrice;

	@Column(nullable = false, name = "stock_quantity")
	private int stockQuantity;

	@ManyToOne
	@JoinColumn(nullable = false, name = "broker_id")
	private BrokerEntity broker;

	protected OfferEntity() {
	}

	public OfferEntity(boolean finished, OfferType offerType, Long playerId, BigDecimal stockPrice, int stockQuantity, String stockName,
			BrokerEntity broker) {
		this.finished = finished;
		this.offerType = offerType;
		this.playerId = playerId;
		this.stockPrice = stockPrice;
		this.stockQuantity = stockQuantity;
		this.stockName = stockName;
		this.broker = broker;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean getFinished() {
		return this.finished;
	}

	public void setFinished(boolean finished) {
		this.finished = finished;
	}

	public OfferType getOfferType() {
		return this.offerType;
	}

	public void setOfferType(OfferType offerType) {
		this.offerType = offerType;
	}

	public Long getPlayerId() {
		return this.playerId;
	}

	public void setPlayerId(Long playerId) {
		this.playerId = playerId;
	}

	public BigDecimal getStockPrice() {
		return this.stockPrice;
	}

	public void setStockPrice(BigDecimal stockPrice) {
		this.stockPrice = stockPrice;
	}

	public int getStockQuantity() {
		return this.stockQuantity;
	}

	public void setStockQuantity(int stockQuantity) {
		this.stockQuantity = stockQuantity;
	}

	public BrokerEntity getBroker() {
		return this.broker;
	}

	public void setBroker(BrokerEntity broker) {
		this.broker = broker;
	}
	
	public String getStockName() {
		return stockName;
	}

	public void setStockName(String stockName) {
		this.stockName = stockName;
	}

}