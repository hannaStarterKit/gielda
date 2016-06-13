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

	private String offerType;

	private String stockName;

	private int stockQuantity;

	public PlayerOffer(String offerType, String stockName, int stockQuantity) {
		this.offerType = offerType;
		this.stockName = stockName;
		this.stockQuantity = stockQuantity;
	}

	public String getOfferType() {
		return offerType;
	}

	public void setOfferType(String offerType) {
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
