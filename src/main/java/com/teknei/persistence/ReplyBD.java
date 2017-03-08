/**
 * Teknei 2016
 */
package com.teknei.persistence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

/**
 * @author Jorge Amaro
 * 
 *         <pre>
 *  DB Utility functions for reply data from functions stored locally
 *         </pre>
 * 
 * @version 1.0.0
 * @since 1.0.0
 *
 */
@Component
public class ReplyBD {

	/*
	 * Injected value
	 */
	@Autowired
	private JdbcTemplate jdbcTemplate;

	private static final Logger log = LoggerFactory.getLogger(ReplyBD.class);

	/**
	 * Function calling count(*) from common table. Should return at least 1
	 * result. The table {@code cctm_cata} must exist on the database
	 * 
	 * 
	 * @return the number of records
	 */
	public Integer callDBUnitTest() {
		String sql = "select count(*) from sitm.cctm_cata;";
		Object o = jdbcTemplate.queryForObject(sql, Object.class);
		try {
			Integer i = Integer.parseInt(o.toString());
			return i;
		} catch (NumberFormatException ne) {
			return null;
		}
	}
	
	/**
	 * Updates specific pass-table for null non-handled values
	 */
	public void callSbopTranViaUpdate(){
		String sql = "update sitm.sbop_tran_via set id_tarj = null where id_tarj is not null;";
		jdbcTemplate.queryForObject(sql, Object.class);
	}
	
	/**
	 * Calls the store procedure for clean the pass-tables
	 * @return the overall status of the process
	 */
	public String callSPClean(){
		String sql = "select sitm.sbop_clea_tran(1);";
		Object o = jdbcTemplate.queryForObject(sql, Object.class);
		return o.toString();
	}

}
