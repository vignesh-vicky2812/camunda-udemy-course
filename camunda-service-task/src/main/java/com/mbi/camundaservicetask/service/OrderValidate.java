package com.mbi.camundaservicetask.service;

import java.util.logging.Logger;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import com.mbi.camundaservicetask.LoggerDelegate;

public class OrderValidate implements JavaDelegate {

	private final Logger LOGGER = Logger.getLogger(OrderValidate.class.getName());

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		LOGGER.info("Order validate: execute has been called");

		String orderName = (String) execution.getVariable("orderName");
		boolean isValidated = false;
		
		if(orderName.length()>0) {
			LOGGER.info("Valid order");
			isValidated=true;
		}
		else {
			LOGGER.info("Invalid order");
			isValidated=false;
		}
		execution.setVariable("isValidated", isValidated);
	}

}
