/**
 * 
 */
package pl.spring.demo.service;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.LinkedList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pl.spring.demo.entity.Broker;
import pl.spring.demo.entity.Offer;
import pl.spring.demo.player.PlayerOffer;


/**
 * @author HSIENKIE
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "CommonServiceTest-context.xml")
public class BrokerServiceTest {
	
	@Autowired
	private BrokerService brokerService;
	

	@Test
	public void testShouldSaveOffer(){
		// given
		final String offerType = "SALE";
		final String stockName = "Intel";
		final int stockQuantity = 10;
		PlayerOffer playerOffer = new PlayerOffer(offerType, stockName, stockQuantity);
		List<PlayerOffer> playerOffers = new LinkedList<>();
		playerOffers.add(playerOffer);
		final Long playerId = 1L;
		final Long brokerId = 1L;
		// when
		List<Offer> offers = brokerService.offer(playerOffers, playerId, brokerId);
		// then
		assertNotNull(offers);
		assertEquals(offers.get(0).getStockName(), stockName);
	}
	

}
