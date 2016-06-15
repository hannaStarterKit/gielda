/**
 * 
 */
package pl.spring.demo.service.impl;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.spring.demo.dao.DateDao;
import pl.spring.demo.service.DateService;

/**
 * @author HSIENKIE
 *
 */
@Service
public class DateServiceImpl implements DateService {
	
	@Autowired
	private DateDao dateDao; 

	@Override
	public LocalDate getCurrentDate() {
		return dateDao.getCurrentDate();
	}

}
