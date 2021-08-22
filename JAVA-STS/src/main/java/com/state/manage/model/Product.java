package com.state.manage.model;

import com.state.manage.bl.ProductStateBl;
import com.state.manage.enumeration.ProductStatusEnum;

/** 
 * @author Dulaj Sam
 *
 * Manages the product status respect to 
 * the current status of the product. 
 */
public class Product {
	private ProductStateBl state;

	public ProductStateBl getState() {
		return state;
	}

	public void setState(ProductStateBl state) {
		this.state = state;
	}

	public Product() {
	}
	
	/**
	 * Passes classes to the constructor from HashMap
	 * 
	 * @param key
	 */
	public Product(Object key) {
		this((ProductStateBl) key);
	}
	
	/**
	 * Pass different classes to the constructor
	 * 
	 * @param className
	 */
	public Product(ProductStateBl className) {
		state = className;
	}

	public void previousState(ProductStatusEnum status) throws Exception {
		state.preState(this, status);
	}

	public void nextState(ProductStatusEnum status) throws Exception {
		state.nextState(this, status);
	}

	public void printState() {
		state.printStatus();
	}


}
