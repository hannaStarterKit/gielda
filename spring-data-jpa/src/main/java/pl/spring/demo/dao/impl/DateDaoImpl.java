/**
 * 
 */
package pl.spring.demo.dao.impl;

import java.time.LocalDate;

import pl.spring.demo.dao.DateDao;

/**
 * @author HSIENKIE
 *
 */
public class DateDaoImpl implements DateDao {

	/*
	 * (non-Javadoc)
	 * 
	 * @see pl.spring.demo.dao.DateDao#getCurrentDate()
	 */
	@Override
	public LocalDate getCurrentDate() {
		// TODO Auto-generated method stub
		return LocalDate.of(2000, 1, 1);
	}

}
