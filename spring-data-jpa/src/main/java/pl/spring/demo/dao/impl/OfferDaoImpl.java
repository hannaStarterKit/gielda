/**
 * 
 */
package pl.spring.demo.dao.impl;

import java.util.List;

import pl.spring.demo.dao.OfferDao;
import pl.spring.demo.entity.OfferEntity;
import pl.spring.demo.entity.StockEntity;

/**
 * @author HSIENKIE
 *
 */
public class OfferDaoImpl extends AbstractDao<OfferEntity, Long> implements OfferDao {

	@Override
	public List<OfferEntity> getStocksByPlayerAndBrokerId(Long playerId, Long brokerId) {
		return entityManager
				.createQuery(
						"from OfferEntity offer where offer.playerId = :playerId and offer.broker.id = :brokerId and offer.finished = true",
						OfferEntity.class)
				.setParameter("playerId", playerId).setParameter("brokerId", brokerId).getResultList();
	}

}
