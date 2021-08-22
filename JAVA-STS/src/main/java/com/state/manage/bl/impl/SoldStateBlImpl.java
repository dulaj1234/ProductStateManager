package com.state.manage.bl.impl;

import com.state.manage.bl.ProductStateBl;
import com.state.manage.enumeration.ProductStatusEnum;
import com.state.manage.model.Product;
/** 
 * @author Dulaj Sam
 * 
 * Calls the methods in the class and with regards to
 * the passed state 
 */
public class SoldStateBlImpl implements ProductStateBl {

	/**
	 * Regards to the provided status directs to relevant classes.
	 */
	public void nextState(Product prd, ProductStatusEnum status) throws Exception {
		switch (status) {
			case SUCCESS:
				System.out.println("Product Sold!");
				break;
			case DISPUTE:
				prd.setState(new ReturnedStateBlImpl());
				break;
			default:
				throw new Exception("The '"+status+"' status passed couldn't find in SoldStateBlImpl class");			
		}
	}

	/**
	 * Regards to the provided status directs to relevant classes.
	 */
	public void preState(Product prd, ProductStatusEnum status) throws Exception {
		switch(status) {
			case SUCCESS:
				prd.setState(new ReservedStateBlImpl());
				break;
			default:
				throw new Exception("The '"+status+"' status passed couldn't find in SoldStateBlImpl class");	
		}
	}

	/**
	 * Notify the current state of the product.
	 */
	public void printStatus() {
		System.out.println("Product to be sold!");
	}

}
