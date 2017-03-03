package com.teknei.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.teknei.dto.ResponseDTO;
import com.teknei.persistence.dao.disp.CaupTranDispDAO;
import com.teknei.persistence.dao.disp.CrudRepositoryDisp;
import com.teknei.persistence.dao.disp.SbopAcceSaliDispDAO;
import com.teknei.persistence.dao.disp.SbopAsgnTurnDispDAO;
import com.teknei.persistence.dao.disp.SbopContAcceDispDAO;
import com.teknei.persistence.dao.disp.SbopRecaDispDAO;
import com.teknei.persistence.dao.disp.SbopRecaDiviDispDAO;
import com.teknei.persistence.dao.disp.SbopTranDiviDispDAO;
import com.teknei.persistence.dao.disp.SbopTurnDispDAO;
import com.teknei.persistence.dao.disp.SfmoHistReceNaveDispDAO;
import com.teknei.persistence.dao.disp.SfopEquiAlarDispDAO;
import com.teknei.persistence.dao.disp.SfopMsgCondDispDAO;
import com.teknei.persistence.dao.disp.SfruAsgnDispDAO;
import com.teknei.persistence.dao.disp.SfvhDataDiaDispDAO;
import com.teknei.util.ReplyOptions;
import com.teknei.util.UtilConstants;

@RestController
@RequestMapping("/api")
public class ApiViaCountController {

	/*
	 * Injected values
	 */
	@Autowired
	private SbopTurnDispDAO daoTurn;
	@Autowired
	private SbopAcceSaliDispDAO daoAcceSali;
	@Autowired
	private SbopTranDiviDispDAO daoTranDivi;
	@Autowired
	private SbopTranDiviDispDAO daoTran;
	@Autowired
	private SbopContAcceDispDAO daoContAcce;
	@Autowired
	private SbopAsgnTurnDispDAO daoAsgnTurn;
	@Autowired
	private SbopRecaDispDAO daoReca;
	@Autowired
	private SbopRecaDiviDispDAO daoRecaDivi;
	@Autowired
	private SfruAsgnDispDAO daoSfru;
	@Autowired
	private CaupTranDispDAO daoCaupTran;
	@Autowired
	private SfmoHistReceNaveDispDAO daoSfmo;
	@Autowired
	private SfopEquiAlarDispDAO daoEquiAlar;
	@Autowired
	private SfvhDataDiaDispDAO daoDataDia;
	@Autowired
	private SfopMsgCondDispDAO daoMsgCond;
	@SuppressWarnings("rawtypes")
	private Map<Integer, CrudRepositoryDisp> map;

	@PostConstruct
	private void postContruct() {
		map = new HashMap<>();
		map.put(1, daoTurn);
		map.put(2, daoAsgnTurn);
		map.put(3, daoAcceSali);
		map.put(4, daoContAcce);
		map.put(5, daoTran);
		map.put(6, daoTranDivi);
		map.put(7, daoReca);
		map.put(8, daoRecaDivi);
		//map.put(9, daoSfru);
		map.put(10, daoCaupTran);
		//map.put(13, daoDataDia);
		//map.put(14, daoMsgCond);
		//map.put(15, daoEquiAlar);
		//map.put(16, daoSfmo);
	}

	@SuppressWarnings("rawtypes")
	@RequestMapping(value = { "count/{idEqui}", "count/{idEqui}/{startDate}", "count/{idEqui}/{startDate}/{endDate}",
			"count/{idEqui}/{startDate}/{endDate}/{apiOption}" }, method = RequestMethod.GET)
	public ResponseEntity<List<ResponseDTO>> countDay(@PathVariable Integer idEqui,
			@PathVariable Optional<String> startDate, @PathVariable Optional<String> endDate,
			@PathVariable Optional<Integer> apiOption) {
		DateTime dtStart = null;
		DateTime dtEnd = null;
		List<ResponseDTO> listResponse = new ArrayList<>();
		if (startDate.isPresent() && endDate.isPresent()) {
			dtStart = new DateTime(startDate.get());
			dtEnd = new DateTime(endDate.get());
			if (dtStart.isAfter(dtEnd)) {
				ResponseDTO errorResponse = new ResponseDTO(UtilConstants.STATUS_API_USAGE_BAD_REQUEST_EXCEPTION,
						UtilConstants.MESSAGE_API_USAGE_BAD_REQUEST_EXCEPTION);
				listResponse.add(errorResponse);
				return new ResponseEntity<List<ResponseDTO>>(listResponse, HttpStatus.BAD_REQUEST);
			}
		} else if (startDate.isPresent()) {
			dtStart = new DateTime(startDate.get());
			dtEnd = new DateTime(startDate.get());
		} else {
			dtStart = new DateTime();
			dtEnd = new DateTime();
		}
		dtStart = dtStart.withTimeAtStartOfDay();
		dtEnd = dtEnd.withTimeAtStartOfDay();
		dtEnd = dtEnd.plusDays(1);
		dtEnd = dtEnd.minusMillis(1);
		if (apiOption.isPresent()) {
			ReplyOptions opt = ReplyOptions.getReplyOptionFromNumber(apiOption.get());
			CrudRepositoryDisp daoLocal = map.get(opt.getOrder());
			listResponse.add(new ResponseDTO(
					String.valueOf(daoLocal.countByPkIdEquiAndFchCreaBetween(idEqui, dtStart.toDate(), dtEnd.toDate())),
					opt.name()));
			return new ResponseEntity<List<ResponseDTO>>(listResponse, HttpStatus.OK);
		} else {
			for (ReplyOptions option : ReplyOptions.values()) {
				CrudRepositoryDisp daoLocal = map.get(option.getOrder());
				if (daoLocal != null) {
					listResponse.add(new ResponseDTO(String.valueOf(
							daoLocal.countByPkIdEquiAndFchCreaBetween(idEqui, dtStart.toDate(), dtEnd.toDate())),
							option.name()));
				}
			}
		}
		return new ResponseEntity<List<ResponseDTO>>(listResponse, HttpStatus.OK);
	}

}
