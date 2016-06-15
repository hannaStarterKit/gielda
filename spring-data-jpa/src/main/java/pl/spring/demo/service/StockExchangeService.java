package pl.spring.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.spring.demo.entity.StockEntity;
import pl.spring.demo.money.Money;

@Service
@Transactional(readOnly = true)
public interface StockExchangeService {

	StockEntity saveStock(StockEntity stock);

	List<StockEntity> findStockByNameAndTime(String name, int numberOfDaysBefore);

	StockEntity findOne(Long id);
	
	Money getCurrentPrice(String stockName);

}
