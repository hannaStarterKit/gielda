/**
 * 
 */
package pl.spring.demo.money;

import java.math.BigDecimal;

/**
 * @author HSIENKIE
 *
 */
public class Money {

	private BigDecimal value;
	private MonetaryUnit monetayUnit;
	
	public Money(BigDecimal value, MonetaryUnit monetaryUnit){
		this.setValue(value);
		this.monetayUnit = monetaryUnit;
	}


	public MonetaryUnit getMonetayUnit() {
		return monetayUnit;
	}

	public void setMonetayUnit(MonetaryUnit monetayUnit) {
		this.monetayUnit = monetayUnit;
	}


	public BigDecimal getValue() {
		return value;
	}


	public void setValue(BigDecimal value) {
		this.value = value;
	}
}
