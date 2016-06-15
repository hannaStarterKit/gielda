/**
 * 
 */
package pl.spring.demo.dao;

import java.util.List;

import pl.spring.demo.entity.OfferEntity;

/**
 * @author HSIENKIE
 *
 */
public interface OfferDao extends Dao<OfferEntity, Long> {

	List<OfferEntity> getStocksByPlayerAndBrokerId(Long playerId, Long brokerId);
}
