package pl.spring.demo.dao;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pl.spring.demo.entity.Broker;
import pl.spring.demo.entity.Offer;

import static org.junit.Assert.*;

import java.math.BigDecimal;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "CommonDaoTest-context.xml")
public class BrokerDaoImplTest {

	@Autowired
	private BrokerDao brokerDao;

	@Autowired
	private OfferDao offerDao;

	@Test
	public void testShouldSaveOffer() {
		// given
		final Long playerId = 1L;
		final Long brokerId = 1L;
		final boolean finished = false;
		final String offerType = "SALE";
		final BigDecimal stockPrice = BigDecimal.valueOf(10.00);
		final int stockQuantity = 10;
		Broker broker = brokerDao.findOne(brokerId);
		Offer offer = new Offer(finished, offerType, playerId, stockPrice, stockQuantity, broker);
		// when
		Offer offerSaved = offerDao.save(offer);
		// then
		assertNotNull(offerSaved);
		Offer offerFinded = offerDao.findOne(offerSaved.getId());
		assertNotNull(offerFinded);
//		Broker broker2 = new Broker(3L, 1L, 98, 100, 100, 102, 100, 80);
//		// when
//		Broker brokerSaved = brokerDao.save(broker2);
//		// then
//		assertNotNull(brokerSaved);
//		Broker brokerFinded = brokerDao.findOne(brokerSaved.getId());
//		assertNotNull(brokerFinded);
	}

}
