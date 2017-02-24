/**
 * Teknei 2016
 */
package com.teknei.persistence.entities;

import java.io.Serializable;
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
 * The persistent class for the sbop_cont_acce_via database table.
 * 
 */
@Entity
@Table(name = "sbop_cont_acce_via", schema = "sitm")
@NamedQuery(name = "SbopContAcceVia.findAll", query = "SELECT s FROM SbopContAcceVia s")
@Data
public class SbopContAcceVia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "SBOP_CONT_ACCE_VIA_ID_GENERATOR", sequenceName = "sitm.sbop_cont_acce_via_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SBOP_CONT_ACCE_VIA_ID_GENERATOR")
	private Long id;

	@Column(name = "fch_cont_acce")
	private Timestamp fchContAcce;

	@Column(name = "fch_crea")
	private Timestamp fchCrea;

	@Column(name = "fch_modi")
	private Timestamp fchModi;

	@Column(name = "id_con_sis")
	private Integer idConSis;

	@Column(name = "id_cont_acce")
	private Integer idContAcce;

	@Column(name = "id_equi")
	private Integer idEqui;

	@Column(name = "id_esta")
	private Integer idEsta;

	@Column(name = "id_posi_cont")
	private Integer idPosiCont;

	@Column(name = "id_tipo")
	private Integer idTipo;

	@Column(name = "id_tipo_fluj")
	private Integer idTipoFluj;

	@Column(name = "id_tipo_pasa")
	private Integer idTipoPasa;

	@Column(name = "id_turn")
	private Long idTurn;

	@Column(name = "usr_crea")
	private String usrCrea;

	@Column(name = "usr_modi")
	private String usrModi;

}