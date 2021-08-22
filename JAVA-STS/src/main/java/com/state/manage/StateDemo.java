package com.state.manage;

import com.state.manage.controller.StateProcessController;

public class StateDemo {
	/**
	 * Creates an object from the controller StateProcessController and
	 * directs to the method processPathDefine()
	 */
	public static void main(String[] args) {		
		StateProcessController stProcessCtrl = new StateProcessController();
		stProcessCtrl.processPathDefine();		
	}
	
}
