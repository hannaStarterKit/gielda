/**
 * 
 */
package pl.spring.demo.dao;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

import pl.spring.demo.entity.StockEntity;

/**
 * @author HSIENKIE
 *
 */
public interface StockDao extends Dao<StockEntity, Long> {

	List<StockEntity> findStocksByNameAndDate(String name, Date startdate, Date currentDate);

	BigDecimal getCurrentPrice(String stockName, Date currentDate);

}
