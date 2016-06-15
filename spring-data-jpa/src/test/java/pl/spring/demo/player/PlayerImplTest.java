/**
 * 
 */
package pl.spring.demo.player;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pl.spring.demo.player.impl.PlayerImpl;
import pl.spring.demo.service.BrokerService;

/**
 * @author HSIENKIE
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "CommonServiceTest-context.xml")
public class PlayerImplTest {
	
	@Autowired
	private BrokerService brokerService;

	@Test
	public void testShouldRunPlayer(){
		// given
		final Long playerId = 1L;
		final Long accountId = 2L;
		final Long brokerId = 5L;
		PlayerImpl player = new PlayerImpl(playerId, accountId);
		// when
		player.play();
		// then
		assertNotNull(brokerService.getMyStocks(playerId, brokerId));
	}
		
		
}
