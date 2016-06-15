/**
 * 
 */
package pl.spring.demo.service;

import java.util.List;

import pl.spring.demo.entity.BrokerEntity;
import pl.spring.demo.entity.OfferEntity;
import pl.spring.demo.playerModel.PlayerOffer;
import pl.spring.demo.playerModel.PlayerStock;

/**
 * @author HSIENKIE
 *
 */
public interface BrokerService {
	
	List<OfferEntity> offer(List<PlayerOffer> playerOffers, Long playerId, Long brokerId);

	List<PlayerStock> getMyStocks(Long playerId, Long brokerId);
	
	Long getAccountid(Long brokerId);
	
	BrokerEntity saveBroker(BrokerEntity broker);

	void deleteBroker(BrokerEntity broker);
}
