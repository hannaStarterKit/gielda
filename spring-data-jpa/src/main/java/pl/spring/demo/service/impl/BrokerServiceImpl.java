/**
 * 
 */
package pl.spring.demo.service.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import pl.spring.demo.entity.Offer;
import pl.spring.demo.money.Money;
import pl.spring.demo.service.BrokerService;

import pl.spring.demo.service.StockExchangeService;

/**
 * @author HSIENKIE
 *
 */
public class BrokerServiceImpl implements BrokerService {

	@Autowired
	private StockExchangeService stockExchangeService;

//	@Autowired
//	private BrokerDao brokerDao;
//
//	@Override
//	public List<Offer> offer(List<OfferPlayer> playerOffers, long playerId, long brokerId) {
//		return brokerDao.offer(List < OfferPlayer > playerOffers, playerId, brokerId);
//	}
//
//	@Override
//	public List<StockPlayer> getMyStocks(long playerId, long brokerId) {
//		return brokerDao.getStocksByPlayerAndBrokerId(playerId, brokerId);
//	}
//
//	@Override
//	public long getAccountid(long brokerId) {
//		return brokerDao.getAccountId(brokerId);
//	}
//
//	private Money getCurrentprice(String name) {
//		return stockExchangeService.getCurrentPrice(name);
//	}
//
//	private int calculateQuantityOfOrder(int quantity, long brokerId) {
//		return (int) quantity
//				* randInt(brokerDao.getOrderQuantityLower(brokerId), brokerDao.getOrderQuantityUpper(brokerId)) / 100;
//	}
//
//	private BigDecimal calculateCommissionOfSale(BigDecimal price, long brokerId) {
//		BigDecimal newPrice = price
//				* randInt(brokerDao.getCommissionOfSalesLower(brokerId), brokerDao.getCommissionOfSalesUpper(brokerId))
//				/ 100;
//		return newPrice.setScale(2, RoundingMode.CEILING);
//	}

}
