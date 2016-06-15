/**
 * 
 */
package pl.spring.demo.dao.impl;

import java.util.List;

import pl.spring.demo.dao.BrokerDao;
import pl.spring.demo.player.PlayerStock;
import pl.spring.demo.entity.BrokerEntity;

/**
 * @author HSIENKIE
 *
 */
public class BrokerDaoImpl extends AbstractDao<BrokerEntity, Long> implements BrokerDao {

	@Override
	public int getOrderQuantityLower(Long brokerId) {
		return this.findOne(brokerId).getSaleCommissionLower();
	}

	@Override
	public int getCommissionOfSaleLower(Long brokerId) {
		return this.findOne(brokerId).getSaleCommissionLower();
	}

	@Override
	public int getOrderQuantityUpper(Long brokerId) {
		return this.findOne(brokerId).getOrderQuantityUpper();
	}

	@Override
	public int getCommissionOfSaleUpper(Long brokerId) {
		return this.findOne(brokerId).getSaleCommissionUpper();
	}

	@Override
	public int getCommissionOfBuyingLower(Long brokerId) {
		return this.findOne(brokerId).getBuyingCommissionLower();
	}

	@Override
	public int getCommissionOfBuyingUpper(Long brokerId) {
		return this.findOne(brokerId).getBuyingCommissionUpper();
	}

	@Override
	public Long getAccountId(Long brokerId) {
		return this.findOne(brokerId).getAccount().getId();
	}

	@Override
	public List<PlayerStock> getStocksByPlayerAndBrokerId(Long playerId, Long brokerId) {
		// TODO Auto-generated method stub
		return null;
	}

}
