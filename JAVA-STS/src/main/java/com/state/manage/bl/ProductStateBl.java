package com.state.manage.bl;

import com.state.manage.enumeration.ProductStatusEnum;
import com.state.manage.model.Product;

/**
 * @author Dulaj Sam
 *
 *The interface consists of the following methods
 *which used in respective classes to proceed.
 */
public interface ProductStateBl {
	/**
	 * @param prd Product model for initiation
	 * @param status set of status as enum from ProductStatusEnum
	 * @throws Exception to cash error occurs when relevant status not found
	 * 
	 * Calls the next state method in the specific class 
	 */
	void nextState(Product prd, ProductStatusEnum status) throws Exception;
	
	/**
	 * @param prd Product model for initiation
	 * @param status set of status as enum from ProductStatusEnum
	 * @throws Exception to cash error occurs when relevant status not found
	 * 
	 * Calls the previous state method in the specific class
	 */
    void preState(Product prd, ProductStatusEnum status) throws Exception;

    /**
     * Calls the current state method in the specific class
     */
    void printStatus();

}
