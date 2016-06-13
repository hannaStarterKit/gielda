/**
 * 
 */
package pl.spring.demo.service;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pl.spring.demo.entity.Broker;
import pl.spring.demo.entity.Offer;

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
		final Long playerId = 1L;
		final Long brokerId = 1L;
		final boolean finished = false;
		final String offerType = "SALE";
		final String stockName = "Intel";
		final int stockQuantity = 10;
		OfferPlayer offerPlayer = new OfferPlayer(offerType, stockName, stockQuantity);
	}
	

}
