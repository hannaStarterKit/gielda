package pl.spring.demo.service;

import java.util.List;

import pl.spring.demo.entity.StockEntity;
import pl.spring.demo.money.Money;

public interface StockExchangeService {

	StockEntity saveStock(StockEntity stock);

	List<StockEntity> findStockByNameAndTime(String name, long numberOfDaysBefore);

	StockEntity findOne(long id);

	void stockValidator(StockEntity stock);
	
	Money getCurrentPrice(String stockName);

}
