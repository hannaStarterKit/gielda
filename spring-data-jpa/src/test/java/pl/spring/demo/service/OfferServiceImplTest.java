package pl.spring.demo.service;

/**
 * 
 */
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

import pl.spring.demo.dao.BrokerDao;
import pl.spring.demo.entity.BrokerEntity;
import pl.spring.demo.entity.OfferEntity;
import pl.spring.demo.playerModel.OfferType;

/**
 * @author HSIENKIE
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "CommonServiceTest-context.xml")
public class OfferServiceImplTest {

	@Autowired
	private OfferService offerService;
	@Autowired
	private BrokerDao brokerDao;

	@Test
	public void testShouldSaveOffer() {
		// given
		boolean finished = false;
		OfferType offerType = OfferType.SALE;
		Long playerId = 1L;
		BigDecimal stockPrice = new BigDecimal(10);
		int stockQuantity = 5;
		String stockName = "blabla";
		Long brokerId = 1L;
		BrokerEntity broker = brokerDao.findOne(brokerId);
		OfferEntity offer = new OfferEntity(null, finished, offerType, playerId, stockPrice, stockQuantity, stockName, broker);
		// when
		OfferEntity offerSaved = offerService.save(offer);
		// given
		assertNotNull(offerSaved.getId());
	}

}
