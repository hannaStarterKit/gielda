/**
 * 
 */
package pl.spring.demo.player.impl;

import org.springframework.beans.factory.annotation.Autowired;

import pl.spring.demo.service.BrokerService;

/**
 * @author HSIENKIE
 *
 */
public class PlayerImpl {

	@Autowired
	private BrokerService brokerService;
	
	private Long id;
	
	public PlayerImpl(Long id){
		this.id = id;
	}

	public play(){
		
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void play() {
		// TODO Auto-generated method stub
		
	}
}
