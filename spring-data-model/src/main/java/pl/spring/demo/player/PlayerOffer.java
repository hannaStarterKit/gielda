/**
 * 
 */
package pl.spring.demo.player;

import javax.persistence.Column;

/**
 * @author HSIENKIE
 *
 */
public class PlayerOffer {

	private OfferType offerType;

	private String stockName;

	private int stockQuantity;

	public PlayerOffer(OfferType offerType, String stockName, int stockQuantity) {
		this.offerType = offerType;
		this.stockName = stockName;
		this.stockQuantity = stockQuantity;
	}

	public OfferType getOfferType() {
		return offerType;
	}

	public void setOfferType(OfferType offerType) {
		this.offerType = offerType;
	}

	public String getStockName() {
		return stockName;
	}

	public void setStockName(String stockName) {
		this.stockName = stockName;
	}

	public int getStockQuantity() {
		return stockQuantity;
	}

	public void setStockQuantity(int stockQuantity) {
		this.stockQuantity = stockQuantity;
	}

}
