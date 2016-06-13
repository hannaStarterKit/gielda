package pl.spring.demo.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;


/**
 * The persistent class for the broker database table.
 * 
 */
@Entity
@Table(name = "BROKER")
@NamedQuery(name="Broker.findAll", query="SELECT b FROM Broker b")
public class Broker implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	@Column(nullable = false, name="account_id")
	private Long accountId;

	@Column(nullable = false, name="buying_commission_lower")
	private int buyingCommissionLower;

	@Column(nullable = false, name="buying_commission_upper")
	private int buyingCommissionUpper;

	@Column(nullable = false, name="order_quantity_lower")
	private int orderQuantityLower;

	@Column(nullable = false, name="order_quantity_upper")
	private int orderQuantityUpper;

	@Column(nullable = false, name="sale_commission_lower")
	private int saleCommissionLower;

	@Column(nullable = false, name="sale_commission_upper")
	private int saleCommissionUpper;	

	@OneToMany(mappedBy = "broker", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)	
	private Set<Offer> offers = new HashSet<>();
	
	public Broker(Long id, Long accountId, int buyingCommissionLower, int buyingCommissionUpper, int orderQuantityLower,
			int orderQuantityUpper, int saleCommissionLower, int saleCommissionUpper) {
		this.id = id;
		this.accountId = accountId;
		this.buyingCommissionLower = buyingCommissionLower;
		this.buyingCommissionUpper = buyingCommissionUpper;
		this.orderQuantityLower = orderQuantityLower;
		this.orderQuantityUpper = orderQuantityUpper;
		this.saleCommissionLower = saleCommissionLower;
		this.saleCommissionUpper = saleCommissionUpper;
	}

	protected Broker() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getAccountId() {
		return this.accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public int getBuyingCommissionLower() {
		return this.buyingCommissionLower;
	}

	public void setBuyingCommissionLower(int buyingCommissionLower) {
		this.buyingCommissionLower = buyingCommissionLower;
	}

	public int getBuyingCommissionUpper() {
		return this.buyingCommissionUpper;
	}

	public void setBuyingCommissionUpper(int buyingCommissionUpper) {
		this.buyingCommissionUpper = buyingCommissionUpper;
	}

	public int getOrderQuantityLower() {
		return this.orderQuantityLower;
	}

	public void setOrderQuantityLower(int orderQuantityLower) {
		this.orderQuantityLower = orderQuantityLower;
	}

	public int getOrderQuantityUpper() {
		return this.orderQuantityUpper;
	}

	public void setOrderQuantityUpper(int orderQuantityUpper) {
		this.orderQuantityUpper = orderQuantityUpper;
	}

	public int getSaleCommissionLower() {
		return this.saleCommissionLower;
	}

	public void setSaleCommissionLower(int saleCommissionLower) {
		this.saleCommissionLower = saleCommissionLower;
	}

	public int getSaleCommissionUpper() {
		return this.saleCommissionUpper;
	}

	public void setSaleCommissionUpper(int saleCommissionUpper) {
		this.saleCommissionUpper = saleCommissionUpper;
	}
//
//	public List<Offer> getOffers() {
//		return this.offers;
//	}
//
//	public void setOffers(List<Offer> offers) {
//		this.offers = offers;
//	}
//
//	public Offer addOffer(Offer offer) {
//		getOffers().add(offer);
//		offer.setBroker(this);
//
//		return offer;
//	}
//
//	public Offer removeOffer(Offer offer) {
//		getOffers().remove(offer);
//		offer.setBroker(null);
//
//		return offer;
//	}

}