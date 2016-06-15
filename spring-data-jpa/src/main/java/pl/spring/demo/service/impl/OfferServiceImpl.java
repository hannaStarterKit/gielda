/**
 * 
 */
package pl.spring.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.spring.demo.dao.OfferDao;
import pl.spring.demo.entity.OfferEntity;
import pl.spring.demo.service.OfferService;

/**
 * @author HSIENKIE
 *
 */
@Service
@Transactional(readOnly = true)
public class OfferServiceImpl implements OfferService {

	@Autowired
	private OfferDao offerDao;

	@Override
	@Transactional(readOnly = false)
	public OfferEntity save(OfferEntity offer) {
		return offerDao.save(offer);
	}
}
