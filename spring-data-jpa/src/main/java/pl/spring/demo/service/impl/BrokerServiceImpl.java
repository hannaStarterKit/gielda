/**
 * 
 */
package pl.spring.demo.service.impl;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.spring.demo.dao.BrokerDao;
import pl.spring.demo.dao.OfferDao;
import pl.spring.demo.entity.BrokerEntity;
import pl.spring.demo.entity.OfferEntity;
import pl.spring.demo.money.Money;
import pl.spring.demo.playerModel.OfferType;
import pl.spring.demo.playerModel.PlayerOffer;
import pl.spring.demo.playerModel.PlayerStock;
import pl.spring.demo.service.BrokerService;
import pl.spring.demo.service.OfferService;
import pl.spring.demo.service.StockExchangeService;

/**
 * @author HSIENKIE
 *
 */
@Service
@Transactional(readOnly = true)
public class BrokerServiceImpl implements BrokerService {

	@Autowired
	private StockExchangeService stockExchangeService;

	@Autowired
	private BrokerDao brokerDao;

	@Autowired
	private OfferService offerService;

	@Override
	@Transactional(readOnly = false)
	public BrokerEntity saveBroker(BrokerEntity broker) {
		return brokerDao.save(broker);
	}

	@Override
	@Transactional(readOnly = false)
	public void deleteBroker(BrokerEntity broker) {
		brokerDao.delete(broker);
	}

	@Override
	public List<OfferEntity> offer(List<PlayerOffer> playerOffers, Long playerId, Long brokerId) {
		List<OfferEntity> offers = this.calculateOffers(playerOffers, brokerId, playerId);
		return offers;
	}

	@Override
	public List<PlayerStock> getMyStocks(Long playerId, Long brokerId) {
		return offerService.getStocksByPlayerAndBrokerId(playerId, brokerId);
	}

	@Override
	public Long getAccountid(Long brokerId) {
		return brokerDao.getAccountId(brokerId);
	}

	private Money getCurrentPrice(String name) {
		return stockExchangeService.getCurrentPrice(name);
	}

	private int calculateQuantityOfOrder(int quantity, Long brokerId) {
		int lower = brokerDao.getOrderQuantityLower(brokerId);
		int upper = brokerDao.getOrderQuantityUpper(brokerId);
		int quantityCalculated = quantity*(lower + (int) (Math.random() * ((upper - lower) + 1)))/100;
		return (int) quantityCalculated;
	}

	private BigDecimal calculateCommission(BigDecimal price, Long brokerId, OfferType offerType) {
		MathContext mc = new MathContext(2);
		int lower = 0;
		int upper = 0;
		BigDecimal commission;
		if (offerType == OfferType.BUYING) {
			lower = brokerDao.getCommissionOfBuyingLower(brokerId);
			upper = brokerDao.getCommissionOfBuyingUpper(brokerId);
		} else {
			lower = brokerDao.getCommissionOfSaleLower(brokerId);
			upper = brokerDao.getCommissionOfSaleUpper(brokerId);
		}
		commission = new BigDecimal((lower + (int) (Math.random() * ((upper - lower) + 1)))/100);
		return price.multiply(commission, mc);
	}

	private List<OfferEntity> calculateOffers(List<PlayerOffer> playerOffers, Long brokerId, Long playerId) {
		BigDecimal priceWithCommission = BigDecimal.valueOf(0);
		BigDecimal currentPrice = BigDecimal.valueOf(0);
		String stockName = "";
		int stockQuantity = 0;
		OfferType offerType;
		BrokerEntity broker = brokerDao.findOne(brokerId);
		List<OfferEntity> offers = new ArrayList<>();
		for (PlayerOffer playerOffer : playerOffers) {
			stockName = playerOffer.getStockName();
			stockQuantity = playerOffer.getStockQuantity();
			currentPrice = this.getCurrentPrice(stockName).getValue();
			offerType = playerOffer.getOfferType();
			priceWithCommission = this.calculateCommission(currentPrice, brokerId, offerType);
			stockQuantity = this.calculateQuantityOfOrder(stockQuantity, brokerId);
			boolean finished = false;
			OfferEntity offer = new OfferEntity(null, finished, offerType, playerId, priceWithCommission, stockQuantity,
					stockName, broker);
			OfferEntity offerSaved = offerService.save(offer);
			offers.add(offerSaved);
		}
		return offers;
	}

}
