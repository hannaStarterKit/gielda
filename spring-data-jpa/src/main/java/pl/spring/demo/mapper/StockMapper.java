/**
 * 
 */
package pl.spring.demo.mapper;

import java.util.List;
import java.util.stream.Collectors;

import pl.spring.demo.entity.OfferEntity;
import pl.spring.demo.playerModel.PlayerStock;

/**
 * @author HSIENKIE
 *
 */
public class StockMapper {

	public static List<PlayerStock> mapToPlayer(List<OfferEntity> offers) {
		return offers.stream().map(StockMapper::map).collect(Collectors.toList());
	}
	
	public static PlayerStock map (OfferEntity offer){
        if (offer != null) {
            return new PlayerStock(offer.getStockName(), offer.getStockPrice(), offer.getStockQuantity());
        }
        return null;
	}
}
