package pl.spring.demo.repository;


import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pl.spring.demo.entity.Account;

import pl.spring.demo.entity.Broker;
import pl.spring.demo.repository.AccountRepository;
import pl.spring.demo.repository.BrokerRepository;

import static org.junit.Assert.*;

import java.math.BigDecimal;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "CommonRepositoryTest-context.xml")
public class BrokerRepositoryTest {

//	@Autowired
//	private BrokerDao brokerDao;
	
	@Autowired
	private BrokerRepository brokerRepository;
	
	@Autowired
	private AccountRepository accountRepository;
//
//	@Autowired
//	private OfferDao offerDao;
//	
//	@Autowired
//	private AccountDao accountDao;

//	@Test
//	@Ignore
//	public void testShouldSaveOffer() {
//		// given
//		final Long playerId = 1L;
//		final Long brokerId = 1L;
//		final boolean finished = false;
//		final String offerType = "SALE";
//		final BigDecimal stockPrice = BigDecimal.valueOf(10.00);
//		final int stockQuantity = 10;
//		BrokerEntity broker = brokerDao.findOne(brokerId);
////		Offer offer = new Offer(finished, offerType, playerId, stockPrice, stockQuantity, broker);
////		// when
////		Offer offerSaved = offerDao.save(offer);
////		// then
////		assertNotNull(offerSaved);
////		Offer offerFinded = offerDao.findOne(offerSaved.getId());
////		assertNotNull(offerFinded);
//		AccountEntity account = accountDao.findOne(1L);
//		BrokerEntity broker2 = new BrokerEntity(null, account, 98, 100, 100, 102, 100, 800);
//		// when
//		BrokerEntity brokerSaved = brokerDao.save(broker2);
//		// then
//		assertNotNull(brokerSaved);
//		BrokerEntity brokerFinded = brokerDao.findOne(brokerSaved.getId());
//		assertNotNull(brokerFinded);
//	}
//	@Test
//	@Ignore
//	public void testSave(){
//		AccountEntity account = accountDao.findOne(1L);
//		BrokerEntity broker = new BrokerEntity(null, account, 98, 100, 100, 102, 100, 700);
//		BrokerEntity brokerSaved = brokerDao.save(broker);
//		BrokerEntity brokerFinded = brokerDao.findOne(brokerSaved.getId());
//		assertNotNull(brokerFinded);
//	}
	
	@Test
	public void testSave2(){
		Account account = accountRepository.findOne(1L);
		Broker broker = new Broker(null, 700, 98, 100, 100, 102, 100, account);;
		Broker brokerSaved = brokerRepository.saveAndFlush(broker);
		Broker brokerFinded = brokerRepository.findOne(brokerSaved.getId());
		assertNotNull(brokerFinded);
	}

}
