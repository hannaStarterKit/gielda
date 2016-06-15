/**
 * 
 */
package pl.spring.demo.dao;

import java.util.List;

import pl.spring.demo.entity.BrokerEntity;
import pl.spring.demo.playerModel.PlayerOffer;
import pl.spring.demo.playerModel.PlayerStock;

/**
 * @author HSIENKIE
 *
 */
public interface BrokerDao extends Dao<BrokerEntity, Long> {

	int getOrderQuantityLower(Long brokerId);

	int getCommissionOfSaleLower(Long brokerId);

	int getOrderQuantityUpper(Long brokerId);

	int getCommissionOfSaleUpper(Long brokerId);

	int getCommissionOfBuyingLower(Long brokerId);

	int getCommissionOfBuyingUpper(Long brokerId);

	Long getAccountId(Long brokerId);

}
