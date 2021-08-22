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
public class AvailableStateBlImpl implements ProductStateBl{
	/**
	 * Regards to the provided status directs to relevant classes.
	 */
	public void nextState(Product prd, ProductStatusEnum status) throws Exception {
		switch (status) {
			case PROCEED_PAYMENT:
				prd.setState(new ReservedStateBlImpl());
				break;
			case DELETE:
				prd.setState(new DeleteStateBlImpl());
				break;
			case EXCEED:
				prd.setState(new ExpiredStateBlImpl());
				break;
			default:
				throw new Exception("The '"+status+"' status passed couldn't find in AvailableStateBlImpl class");
		}		
	}	
	
	/**
	 * Regards to the provided status directs to relevant classes.
	 */
	public void preState(Product prd, ProductStatusEnum status) throws Exception {
		switch (status) {
			case FAIL_PAYMENT:
				prd.setState(new ReservedStateBlImpl());
				break;
			case SUCCESS:
				prd.setState(new DraftStateBlImpl());
				break;
			default:
				throw new Exception("The '"+status+"' status passed couldn't find in AvailableStateBlImpl class");
		}		
	}

	/**
	 * Notify the current state of the product.
	 */
	public void printStatus() {
		System.out.println("The Product is Available!");		
	}
	
}
