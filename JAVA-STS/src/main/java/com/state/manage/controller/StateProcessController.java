package com.state.manage.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.state.manage.bl.ProductStateBl;
import com.state.manage.bl.impl.AvailableStateBlImpl;
import com.state.manage.bl.impl.DraftStateBlImpl;
import com.state.manage.enumeration.ProductStatusEnum;
import com.state.manage.model.Product;
/**
 * @author Dulaj Sam
 *
 * Controller consists of preparing the path for the process
 * with status conditions and classes.
 */
public class StateProcessController {
	
	Map<ProductStateBl, ArrayList<ProductStatusEnum>> processSet = new LinkedHashMap<ProductStateBl, ArrayList<ProductStatusEnum>>();
	ArrayList<ProductStatusEnum> runPros1;
	ArrayList<ProductStatusEnum> runPros2;
	ArrayList<ProductStatusEnum> runPros3;
	ArrayList<ProductStatusEnum> runPros4;
	
	/**
	 * Set status process for different paths relates to
	 * different Classes.
	 * 
	 * Regards to the scenario, it is necessary to set the
	 * paths accordingly and add values to the defined HashMap.
	 */
	public void processPathDefine() {
		/**
		 * This is the process of
		 * listing started -> DRAFT -> listing successful -> 
		 * AVAILABLE -> proceed payment -> RESERVED -> payment successful -> SOLD -> STOP/END.
		 */
		runPros1 = new ArrayList<ProductStatusEnum>();
		runPros1.add(ProductStatusEnum.SUCCESS);
		runPros1.add(ProductStatusEnum.PROCEED_PAYMENT);
		runPros1.add(ProductStatusEnum.SUCCESS);
		processSet.put(new DraftStateBlImpl(), runPros1);
		
		/**
		 * This is the process of
		 * listing started -> DRAFT -> listing successful -> 
		 * AVAILABLE -> delete -> DELETED -> STOP/END.
		 */
		runPros2 = new ArrayList<ProductStatusEnum>();
		runPros2.add(ProductStatusEnum.SUCCESS);
		runPros2.add(ProductStatusEnum.DELETE);
		processSet.put(new DraftStateBlImpl(), runPros2);
		
		/**
		 * This is the process of
		 * listing started -> DRAFT -> listing deleted -> DELETED DRAFT -> STOP/END.		
		 */
		runPros3 = new ArrayList<ProductStatusEnum>();
		runPros3.add(ProductStatusEnum.DELETE);
		processSet.put(new DraftStateBlImpl(), runPros3);
		
		/**
		 * This is the process of
		 * listing started -> DRAFT -> listing successful -> 
		 * AVAILABLE -> payment successful;
		 * The path followed to give an Error, since no SUCCESS parameter handled.
		 */
		runPros4 = new ArrayList<ProductStatusEnum>();
		runPros4.add(ProductStatusEnum.SUCCESS);
		runPros4.add(ProductStatusEnum.PROCEED_PAYMENT);
		runPros4.add(ProductStatusEnum.FAIL_PAYMENT);
		processSet.put(new AvailableStateBlImpl(), runPros4);
				
		
		/**
		 * runProcessPath()		 
		 */
		runProcessPath();
	}
	
	/**
	 * This method calls the processingStatePaths() method,
	 * and set the paths accordingly related to specific classes given.
	*/
	private void runProcessPath() {		
		processingStatePaths();
	}
	/**
	 * The method processingStatePaths(), loops the data in the HashMap and
	 * passes Enum values to relevant methods and calls them.
	 * 
	 * If set enum value doesn't match with the given class, it throws an
	 * exception with a custom message. 
	 */
	private void processingStatePaths() {
		try {			
			for(Map.Entry<ProductStateBl, ArrayList<ProductStatusEnum>> mapPairs : processSet.entrySet()) {				
				try {
					Product prdState = new Product(mapPairs.getKey());
					List<ProductStatusEnum> value = mapPairs.getValue();
					
					// Looping the passed status to run down the process path
					for (ProductStatusEnum productStatusEnum : value) {
						prdState.printState();
						prdState.nextState(productStatusEnum);
					}
					prdState.printState();
					System.out.println("");
				} catch (Exception e) {
					// Error will pops up when a respective Status doesn't match
					System.err.println("[ERR] : "+e.getMessage());					
				}
			}
		} catch (Exception e) {			
			System.err.println(e.getMessage());
		}
	}

}
