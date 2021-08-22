package com.state.manage.enumeration;
/**
 * @author Dulaj Sam
 * Defines the conditions to different states.
 */
public enum ProductStatusEnum {	 
	SUCCESS, 	//listing successful, payment successful
	DELETE, 	// delete, listing deleted
	RE_DEL, 	// delete for returned products
	EXCEED, 	// exceed duration
	PROCEED_PAYMENT, // proceed payment
	FAIL_PAYMENT, 	 // fail payment
	DISPUTE, 	// dispute accept
	RE_PUBLISH, // re-publish item
	RE_LIST 	// renew listing
}
