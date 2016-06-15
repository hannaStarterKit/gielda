package pl.spring.demo.service.impl;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.spring.demo.dao.StockDao;
import pl.spring.demo.entity.StockEntity;
import pl.spring.demo.money.MonetaryUnit;
import pl.spring.demo.money.Money;
import pl.spring.demo.service.DateService;
import pl.spring.demo.service.StockExchangeService;

@Service
@Transactional(readOnly = true)
public class StockExchangeServiceImpl implements StockExchangeService {

	@Autowired
	private StockDao stockDao;
	
	@Autowired
	private DateService dateService;

	@Override
	@Transactional(readOnly = false)
	public StockEntity saveStock(StockEntity stock) {
		this.stockValidator(stock);
		return stockDao.save(stock);
	}

	@Override
	public StockEntity findOne(Long id) {
		return stockDao.findOne(id);
	}


	@Override
	public List<StockEntity> findStockByNameAndTime(String name, int numberOfDaysBefore) {
		LocalDate currentDate = this.getCurrentDate();
		LocalDate startDate = currentDate.plusDays(numberOfDaysBefore);
		return stockDao.findStocksByNameAndDate(name, Date.valueOf(startDate), Date.valueOf(currentDate));
	}

	@Override
	public Money getCurrentPrice(String stockName) {
		LocalDate currentDate = this.getCurrentDate();
		BigDecimal value = stockDao.getCurrentPrice(stockName, Date.valueOf(currentDate));
		return new Money(value, MonetaryUnit.PLN);
	}
	
	//TODO
	private LocalDate getCurrentDate(){
		return dateService.getCurrentDate();
	}

	private void stockValidator(StockEntity stock) {
		ValidatorFactory vf = Validation.buildDefaultValidatorFactory();
		Set<ConstraintViolation<StockEntity>> violationSet = vf.getValidator().validate(stock);
		for (ConstraintViolation<StockEntity> cv : violationSet) {
			throw new IllegalArgumentException(cv.getMessage());
		}
	}
}
