package pl.spring.demo.playerModel;

import java.math.BigDecimal;

public class PlayerStock {

	private String stockName;
	
	private BigDecimal stockPrice;
	
	private int stockQuantity;
	
	public PlayerStock(String stockName, BigDecimal stockPrice, int stockQuantity) {
		setStockName(stockName);
		setStockPrice(stockPrice);
		setStockQuantity(stockQuantity);
	}

	public BigDecimal getStockPrice() {
		return stockPrice;
	}

	public void setStockPrice(BigDecimal stockPrice) {
		this.stockPrice = stockPrice;
	}

	public int getStockQuantity() {
		return stockQuantity;
	}

	public void setStockQuantity(int stockQuantity) {
		this.stockQuantity = stockQuantity;
	}

	public String getStockName() {
		return stockName;
	}

	public void setStockName(String stockName) {
		this.stockName = stockName;
	}

}
