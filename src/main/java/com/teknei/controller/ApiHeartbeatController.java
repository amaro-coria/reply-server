/**
 * Teknei 2016
 */
package com.teknei.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.teknei.dto.ResponseDTO;
import com.teknei.util.UtilConstants;

/**
 * Rest controller for testing the communication
 * @author Jorge Amaro
 * @version 1.0.0
 * @since 1.0.0
 *
 */
@RestController
@RequestMapping("/api/test")
public class ApiHeartbeatController {

	/**
	 * Echoes the message sent by client
	 * 
	 * @param message
	 *            - The origin message
	 * @return the status
	 */
	@RequestMapping(value = "echo/{message}", method = RequestMethod.GET)
	public ResponseEntity<ResponseDTO> echo(@PathVariable("message") String message) {
		ResponseDTO dto = new ResponseDTO(UtilConstants.STATUS_OK, message);
		return new ResponseEntity<ResponseDTO>(dto, HttpStatus.OK);
	}
}
