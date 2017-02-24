/**
 * Teknei 2016
 */
package com.teknei.persistence.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

/**
 * The persistent class for the caup_dist_posv_via database table.
 * 
 */
@Entity
@Table(name = "caup_dist_posv_via", schema = "sitm")
@NamedQuery(name = "CaupDistPosvVia.findAll", query = "SELECT c FROM CaupDistPosvVia c")
@Data
public class CaupDistPosvVia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "CAUP_DIST_POSV_VIA_ID_GENERATOR", sequenceName = "sitm.caup_dist_posv_via_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CAUP_DIST_POSV_VIA_ID_GENERATOR")
	private Long id;

	@Column(name = "cant_tarj_devo")
	private Integer cantTarjDevo;

	@Column(name = "cant_tarj_entr")
	private Integer cantTarjEntr;

	@Column(name = "fch_crea")
	private Timestamp fchCrea;

	@Column(name = "fch_devo")
	private Timestamp fchDevo;

	@Column(name = "fch_entr")
	private Timestamp fchEntr;

	@Column(name = "fch_modi")
	private Timestamp fchModi;

	@Column(name = "id_dist_posv")
	private Integer idDistPosv;

	@Column(name = "id_emp_supe_devo")
	private Integer idEmpSupeDevo;

	@Column(name = "id_emp_supe_entr")
	private Integer idEmpSupeEntr;

	@Column(name = "id_emp_vend")
	private Integer idEmpVend;

	@Column(name = "id_equi")
	private Integer idEqui;

	@Column(name = "id_esta")
	private Integer idEsta;

	@Column(name = "id_tipo")
	private Integer idTipo;

	@Column(name = "mont_tarj_devo")
	private BigDecimal montTarjDevo;

	@Column(name = "mont_tarj_entr")
	private BigDecimal montTarjEntr;

	@Column(name = "sald_efec")
	private BigDecimal saldEfec;

	@Column(name = "usr_crea")
	private String usrCrea;

	@Column(name = "usr_modi")
	private String usrModi;

	@Column(name = "usua_supe_devo")
	private String usuaSupeDevo;

	@Column(name = "usua_supe_entr")
	private String usuaSupeEntr;

}