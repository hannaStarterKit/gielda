/**
 * 
 */
package pl.spring.demo.service;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.LinkedList;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pl.spring.demo.dao.AccountDao;
import pl.spring.demo.entity.AccountEntity;
import pl.spring.demo.entity.BrokerEntity;
import pl.spring.demo.entity.OfferEntity;
import pl.spring.demo.player.OfferType;
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

	@Autowired
	private AccountDao accountDao;

	@Test
	public void testShouldSaveOffer() {
		// given
		final OfferType offerType = OfferType.SALE;
		final String stockName = "Intel";
		final int stockQuantity = 10;
		PlayerOffer playerOffer = new PlayerOffer(offerType, stockName, stockQuantity);
		List<PlayerOffer> playerOffers = new LinkedList<>();
		playerOffers.add(playerOffer);
		final Long playerId = 1L;
		final Long brokerId = 1L;
		// when
		List<OfferEntity> offers = brokerService.offer(playerOffers, playerId, brokerId);
		// then
		assertNotNull(offers);
		assertEquals(offers.get(0).getStockName(), stockName);
	}

	@Test
	@Ignore
	public void testShouldSaveBroker() {
		// given
		int buyingCommissionLower = 98;
		int buyingCommissionUpper = 100;
		int orderQuantityLower = 80;
		int orderQuantityUpper = 100;
		int saleCommissionLower = 100;
		int saleCommissionUpper = 102;
		AccountEntity account = accountDao.findOne(1L);
		BrokerEntity broker = new BrokerEntity(null, account, buyingCommissionLower, buyingCommissionUpper,
				orderQuantityLower, orderQuantityUpper, saleCommissionLower, saleCommissionUpper);
		// when
		BrokerEntity brokerSaved = brokerService.saveBroker(broker);
		// then
		assertNotNull(brokerSaved.getId());
	}

}
