/**
 * 
 */
package pl.spring.demo.dao.impl;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

import pl.spring.demo.dao.StockDao;
import pl.spring.demo.entity.StockEntity;

/**
 * @author HSIENKIE
 *
 */
public class StockDaoImpl extends AbstractDao<StockEntity, Long> implements StockDao {

	// TODO: dodac dni wstecz i musze wiedziec ktora jest dzisiaj data
	@Override
	public List<StockEntity> findStocksByNameAndDate(String name, Date startDate, Date currentDate) {
		return entityManager
				.createQuery(
						"from StockEntity stock where upper(stock.name) like concat('%', upper(:name), '%') and stock.date <= currentDate and stockdate >= startDate",
						StockEntity.class)
				.setParameter("name", name).setParameter("currentDate", currentDate)
				.setParameter("startDate", startDate).getResultList();
	}

	@Override
	public BigDecimal getCurrentPrice(String stockName, Date currentDate) {
		return entityManager
				.createQuery(
						"from StockEntity stock where upper(stock.name) = upper(:name) and stock.date = currentDate",
						StockEntity.class)
				.setParameter("name", stockName).setParameter("currentDate", currentDate).getSingleResult().getPrice();
	}

}