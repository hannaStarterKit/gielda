/**
 * 
 */
package pl.spring.demo.service;

import java.util.List;

import pl.spring.demo.entity.OfferEntity;
import pl.spring.demo.playerModel.PlayerStock;

/**
 * @author HSIENKIE
 *
 */

public interface OfferService {

	OfferEntity save(OfferEntity offer);

	List<PlayerStock> getStocksByPlayerAndBrokerId(Long playerId, Long brokerId);
}
