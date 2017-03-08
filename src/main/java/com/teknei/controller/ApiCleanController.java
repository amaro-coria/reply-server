/**
 * Teknei 2016
 */
package com.teknei.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teknei.dto.ResponseDTO;
import com.teknei.persistence.ReplyBD;
import com.teknei.util.UtilConstants;

/**
 * Rest controller for invoke clean processes in the database
 * @author Jorge Amaro
 * @version 1.0.0
 * @since 1.0.0
 *
 */
@RestController
@RequestMapping("/api")
public class ApiCleanController {

	/*
	 * Injected element
	 * */
	@Autowired
	private ReplyBD replyBD;
	private static final Logger log = LoggerFactory.getLogger(ApiCleanController.class);

	/**
	 * Calls the clean process manually
	 * @return the response formatted in DTO - JSON
	 */
	@RequestMapping("clean")
	public ResponseDTO callClean() {
		try {
			String responseMessage = callCleanProcess();
			return new ResponseDTO(UtilConstants.STATUS_OK, responseMessage);
		} catch (Exception e) {
			log.error("Error calling clean process: {}", e.getMessage());
			return new ResponseDTO(UtilConstants.STATUS_DATA_ACCESS_EXCEPTION,
					UtilConstants.MESSAGE_DATA_ACCESS_EXCEPTION);
		}
	}

	/**
	 * Automatic timer method executing clean process every hour
	 */
	@Scheduled(cron = "0 0 0/1 1/1 * ?")
	private void autoClean() {
		try {
			callCleanProcess();
		} catch (Exception e) {
		}
	}

	/**
	 * Business method that actually makes the clean process invoking
	 * @return the overall status
	 * @throws Exception
	 */
	private String callCleanProcess() throws Exception {
		try {
			replyBD.callSbopTranViaUpdate();
			String responseMessage = replyBD.callSPClean();
			return responseMessage;
		} catch (Exception e) {
			log.error("Error calling clean process: {}", e.getMessage());
			throw new Exception(e.getMessage());
		}
	}
}
