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
public class ExpiredStateBlImpl implements ProductStateBl {

	/**
	 * Regards to the provided status directs to relevant classes.
	 */
	public void nextState(Product prd, ProductStatusEnum status) throws Exception {
		switch (status) {
			case SUCCESS:
				System.out.println("Product Expired!");
				break;
			case RE_LIST:
				prd.setState(new AvailableStateBlImpl());
				break;
		default:
			throw new Exception("The '"+status+"' status passed couldn't find in ExpiredStateBlImpl class");			
		}
	}

	/**
	 * Regards to the provided status directs to relevant classes.
	 */
	public void preState(Product prd, ProductStatusEnum status) throws Exception {
		switch (status) {
			case EXCEED:
				prd.setState(new AvailableStateBlImpl());
				break;			
			default:
				throw new Exception("The '"+status+"' status passed couldn't find in ExpiredStateBlImpl class");			
		}		
	}

	/**
	 * Notify the current state of the product.
	 */
	public void printStatus() {
		System.out.println("Product get expired from the list!");
	}

}
