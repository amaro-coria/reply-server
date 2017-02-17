/**
 * Teknei 2016
 */
package com.teknei.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.teknei.dto.ResponseDTO;
import com.teknei.persistence.dao.CaupDistPosvViaDAO;
import com.teknei.persistence.dao.CaupTadiPosvViaDAO;
import com.teknei.persistence.dao.CaupTranViaDAO;
import com.teknei.persistence.dao.SbopAcceSaliViaDAO;
import com.teknei.persistence.dao.SbopAsgnTurnViaDAO;
import com.teknei.persistence.dao.SbopContAcceViaDAO;
import com.teknei.persistence.dao.SbopRecaDiviViaDAO;
import com.teknei.persistence.dao.SbopRecaViaDAO;
import com.teknei.persistence.dao.SbopTranDiviViaDAO;
import com.teknei.persistence.dao.SbopTurnViaDAO;
import com.teknei.persistence.dao.SfmoHistReceNaveViaDAO;
import com.teknei.persistence.dao.SfopEquiAlarViaDAO;
import com.teknei.persistence.dao.SfopMsgCondViaDAO;
import com.teknei.persistence.dao.SfruAsgnViaDAO;
import com.teknei.persistence.dao.SfvhDataDiaViaDAO;
import com.teknei.persistence.entities.CaupDistPosvVia;
import com.teknei.persistence.entities.CaupTadiPosvVia;
import com.teknei.persistence.entities.CaupTranVia;
import com.teknei.persistence.entities.SbopAcceSaliVia;
import com.teknei.persistence.entities.SbopAsgnTurnVia;
import com.teknei.persistence.entities.SbopContAcceVia;
import com.teknei.persistence.entities.SbopRecaDiviVia;
import com.teknei.persistence.entities.SbopRecaVia;
import com.teknei.persistence.entities.SbopTranDiviVia;
import com.teknei.persistence.entities.SbopTranVia;
import com.teknei.persistence.entities.SbopTurnVia;
import com.teknei.persistence.entities.SfmoHistReceNaveVia;
import com.teknei.persistence.entities.SfopEquiAlarVia;
import com.teknei.persistence.entities.SfopMsgCondVia;
import com.teknei.persistence.entities.SfruAsgnVia;
import com.teknei.persistence.entities.SfvhDataDiaVia;
import com.teknei.util.UtilConstants;

/**
 * Rest Controller for saving the BD records based on POST request's
 * 
 * @author Jorge Amaro
 * @version 1.0.0
 * @since 1.0.0
 *
 */
@RestController
@RequestMapping("/api")
public class ApiViaSaveController {
	
	private static final Logger log = LoggerFactory.getLogger(ApiViaSaveController.class);

	/*
	 * Injected values
	 */
	@Autowired
	private SbopTurnViaDAO daoTurn;
	@Autowired
	private SbopAcceSaliViaDAO daoAcceSali;
	@Autowired
	private SbopTranDiviViaDAO daoTranDivi;
	@Autowired
	private SbopTranDiviViaDAO daoTran;
	@Autowired
	private SbopContAcceViaDAO daoContAcce;
	@Autowired
	private SbopAsgnTurnViaDAO daoAsgnTurn;
	@Autowired
	private SbopRecaViaDAO daoReca;
	@Autowired
	private SbopRecaDiviViaDAO daoRecaDivi;
	@Autowired
	private SfruAsgnViaDAO daoSfru;
	@Autowired
	private CaupTranViaDAO daoCaupTran;
	@Autowired
	private CaupDistPosvViaDAO daoDist;
	@Autowired
	private CaupTadiPosvViaDAO daoTadi;
	@Autowired
	private SfmoHistReceNaveViaDAO daoSfmo;
	@Autowired
	private SfopEquiAlarViaDAO daoEquiAlar;
	@Autowired
	private SfvhDataDiaViaDAO daoDataDia;
	@Autowired
	private SfopMsgCondViaDAO daoMsgCond;

	/**
	 * Saves the input (list) into local database
	 * 
	 * @param list
	 *            the entities as list
	 * @return {@code ResponseDTO}
	 */
	@RequestMapping(value = "turn/save", method = RequestMethod.POST, consumes = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseDTO> saveTurn(@RequestBody List<SbopTurnVia> list) {
		return save(ApiSaveOptions.SBOP_TURN, list);
	}

	/**
	 * Saves the input (list) into local database
	 * 
	 * @param list
	 *            the entities as list
	 * @return {@code ResponseDTO}
	 */
	@RequestMapping(value = "acce/save", method = RequestMethod.POST, consumes = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseDTO> saveAcce(@RequestBody List<SbopAcceSaliVia> list) {
		return save(ApiSaveOptions.SBOP_ACCE_SALI, list);
	}

	/**
	 * Saves the input (list) into local database
	 * 
	 * @param list
	 *            the entities as list
	 * @return {@code ResponseDTO}
	 */
	@RequestMapping(value = "tran/save", method = RequestMethod.POST, consumes = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseDTO> saveTran(@RequestBody List<SbopTranVia> list) {
		return save(ApiSaveOptions.SBOP_TRAN, list);
	}

	/**
	 * Saves the input (list) into local database
	 * 
	 * @param list
	 *            the entities as list
	 * @return {@code ResponseDTO}
	 */
	@RequestMapping(value = "tranDivi/save", method = RequestMethod.POST, consumes = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseDTO> saveTranDivi(@RequestBody List<SbopTranDiviVia> list) {
		return save(ApiSaveOptions.SBOP_TRAN_DIVI, list);
	}

	/**
	 * Saves the input (list) into local database
	 * 
	 * @param list
	 *            the entities as list
	 * @return {@code ResponseDTO}
	 */
	@RequestMapping(value = "cont/save", method = RequestMethod.POST, consumes = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseDTO> saveContAcce(@RequestBody List<SbopContAcceVia> list) {
		return save(ApiSaveOptions.SBOP_CONT_ACCE, list);
	}

	/**
	 * Saves the input (list) into local database
	 * 
	 * @param list
	 *            the entities as list
	 * @return {@code ResponseDTO}
	 */
	@RequestMapping(value = "asgn/save", method = RequestMethod.POST, consumes = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseDTO> saveAsgn(@RequestBody List<SbopAsgnTurnVia> list) {
		return save(ApiSaveOptions.SBOP_ASGN_TURN, list);
	}

	/**
	 * Saves the input (list) into local database
	 * 
	 * @param list
	 *            the entities as list
	 * @return {@code ResponseDTO}
	 */
	@RequestMapping(value = "reca/save", method = RequestMethod.POST, consumes = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseDTO> saveReca(@RequestBody List<SbopRecaVia> list) {
		return save(ApiSaveOptions.SBOP_RECA, list);
	}

	/**
	 * Saves the input (list) into local database
	 * 
	 * @param list
	 *            the entities as list
	 * @return {@code ResponseDTO}
	 */
	@RequestMapping(value = "recaDivi/save", method = RequestMethod.POST, consumes = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseDTO> saveRecaDivi(@RequestBody List<SbopRecaDiviVia> list) {
		return save(ApiSaveOptions.SBOP_RECA_DIVI, list);
	}

	/**
	 * Saves the input (list) into local database
	 * 
	 * @param list
	 *            the entities as list
	 * @return {@code ResponseDTO}
	 */
	@RequestMapping(value = "sfru/save", method = RequestMethod.POST, consumes = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseDTO> saveSfru(@RequestBody List<SfruAsgnVia> list) {
		return save(ApiSaveOptions.SFRU_ASGN, list);
	}

	/**
	 * Saves the input (list) into local database
	 * 
	 * @param list
	 *            the entities as list
	 * @return {@code ResponseDTO}
	 */
	@RequestMapping(value = "cau/save", method = RequestMethod.POST, consumes = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseDTO> saveCauTran(@RequestBody List<CaupTranVia> list) {
		return save(ApiSaveOptions.CAUP_TRAN, list);
	}

	/**
	 * Saves the input (list) into local database
	 * 
	 * @param list
	 *            the entities as list
	 * @return {@code ResponseDTO}
	 */
	@RequestMapping(value = "dist/save", method = RequestMethod.POST, consumes = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseDTO> saveCaupDist(@RequestBody List<CaupDistPosvVia> list) {
		return save(ApiSaveOptions.CAUP_DIST_POSV, list);
	}

	/**
	 * Saves the input (list) into local database
	 * 
	 * @param list
	 *            the entities as list
	 * @return {@code ResponseDTO}
	 */
	@RequestMapping(value = "tadi/save", method = RequestMethod.POST, consumes = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseDTO> saveCaupTadi(@RequestBody List<CaupTadiPosvVia> list) {
		return save(ApiSaveOptions.CAUP_TADI_POSV, list);
	}

	/**
	 * Saves the input (list) into local database
	 * 
	 * @param list
	 *            the entities as list
	 * @return {@code ResponseDTO}
	 */
	@RequestMapping(value = "sfmo/save", method = RequestMethod.POST, consumes = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseDTO> saveSfmo(@RequestBody List<SfmoHistReceNaveVia> list) {
		return save(ApiSaveOptions.SFMO_HIST, list);
	}

	/**
	 * Saves the input (list) into local database
	 * 
	 * @param list
	 *            the entities as list
	 * @return {@code ResponseDTO}
	 */
	@RequestMapping(value = "sfvh/save", method = RequestMethod.POST, consumes = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseDTO> saveSfvh(@RequestBody List<SfvhDataDiaVia> list) {
		return save(ApiSaveOptions.SFVH_DATA_DIA, list);
	}

	/**
	 * Saves the input (list) into local database
	 * 
	 * @param list
	 *            the entities as list
	 * @return {@code ResponseDTO}
	 */
	@RequestMapping(value = "sfopAlar/save", method = RequestMethod.POST, consumes = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseDTO> saveSfopAlar(@RequestBody List<SfopEquiAlarVia> list) {
		return save(ApiSaveOptions.SFOP_EQUI_ALAR, list);
	}

	/**
	 * Saves the input (list) into local database
	 * 
	 * @param list
	 *            the entities as list
	 * @return {@code ResponseDTO}
	 */
	@RequestMapping(value = "sfopMsg/save", method = RequestMethod.POST, consumes = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseDTO> saveSfopMsg(@RequestBody List<SfopMsgCondVia> list) {
		return save(ApiSaveOptions.SFOP_MSG_COND, list);
	}

	/**
	 * Method for save different kind of list's
	 * 
	 * @param option
	 *            - Based on local Enum
	 * @param list
	 *            - The list of entities to save
	 * @return The ResponseDTO wrapped in a ResponseEntity
	 */
	private ResponseEntity<ResponseDTO> save(ApiSaveOptions option, List list) {
		ResponseDTO dr = null;
		try {
			switch (option) {
			case SBOP_TURN:
				daoTurn.save(list);
				break;
			case SBOP_ACCE_SALI:
				daoAcceSali.save(list);
				break;
			case SBOP_TRAN:
				daoTran.save(list);
				break;
			case SBOP_TRAN_DIVI:
				daoTranDivi.save(list);
				break;
			case SBOP_CONT_ACCE:
				daoContAcce.save(list);
				break;
			case SBOP_ASGN_TURN:
				daoAsgnTurn.save(list);
				break;
			case SBOP_RECA:
				daoReca.save(list);
				break;
			case SBOP_RECA_DIVI:
				daoRecaDivi.save(list);
				break;
			case SFRU_ASGN:
				daoSfru.save(list);
				break;
			case CAUP_TRAN:
				daoCaupTran.save(list);
				break;
			case CAUP_DIST_POSV:
				daoDist.save(list);
				break;
			case CAUP_TADI_POSV:
				daoTadi.save(list);
				break;
			case SFMO_HIST:
				daoSfmo.save(list);
				break;
			case SFVH_DATA_DIA:
				daoDataDia.save(list);
				break;
			case SFOP_EQUI_ALAR:
				daoEquiAlar.save(list);
				break;
			case SFOP_MSG_COND:
				daoMsgCond.save(list);
				break;
			default:
				dr = new ResponseDTO(UtilConstants.STATUS_NOE, UtilConstants.MESSAGE_NOE);
				return new ResponseEntity<ResponseDTO>(dr, HttpStatus.BAD_REQUEST);
			}
			dr = new ResponseDTO(UtilConstants.STATUS_OK, UtilConstants.MESSAGE_OK);
			return new ResponseEntity<>(dr, HttpStatus.OK);
		} catch (DataAccessException e) {
			log.error("Error Data Access Exception: {}", e.getMessage());
			dr = new ResponseDTO(UtilConstants.STATUS_DATA_ACCESS_EXCEPTION,
					UtilConstants.MESSAGE_DATA_ACCESS_EXCEPTION);
			return new ResponseEntity<>(dr, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	private enum ApiSaveOptions {
		SBOP_TURN, SBOP_ACCE_SALI, SBOP_TRAN, SBOP_TRAN_DIVI, SBOP_CONT_ACCE, SBOP_ASGN_TURN, SBOP_RECA, SBOP_RECA_DIVI, SFRU_ASGN, CAUP_TRAN, CAUP_DIST_POSV, CAUP_TADI_POSV, SFMO_HIST, SFVH_DATA_DIA, SFOP_MSG_COND, SFOP_EQUI_ALAR
	}

}
