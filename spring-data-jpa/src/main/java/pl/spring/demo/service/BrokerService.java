/**
 * 
 */
package pl.spring.demo.service;

import java.util.List;

import pl.spring.demo.entity.Offer;
import pl.spring.demo.player.PlayerOffer;

/**
 * @author HSIENKIE
 *
 */
public interface BrokerService {
	
	List<Offer> offer(List<PlayerOffer> playerOffers, long playerId, long brokerId);

	List<PlayerStock> getMyStocks(long playerId, long brokerId);
	
	long getAccountid(long brokerId);
}
