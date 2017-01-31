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
 * The persistent class for the sbop_tran_divi_via database table.
 * 
 */
@Entity
@Table(name="sbop_tran_divi_via", schema = "sitm")
@NamedQuery(name="SbopTranDiviVia.findAll", query="SELECT s FROM SbopTranDiviVia s")
@Data
public class SbopTranDiviVia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SBOP_TRAN_DIVI_VIA_ID_GENERATOR", sequenceName="sitm.sbop_tran_divi_via_id_seq")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SBOP_TRAN_DIVI_VIA_ID_GENERATOR")
	private Long id;

	private Integer cant;

	@Column(name="fch_crea")
	private Timestamp fchCrea;

	@Column(name="fch_modi")
	private Timestamp fchModi;

	@Column(name="id_con_sis")
	private Integer idConSis;

	@Column(name="id_divi")
	private Integer idDivi;

	@Column(name="id_equi")
	private Integer idEqui;

	@Column(name="id_esta")
	private Integer idEsta;

	@Column(name="id_tipo")
	private Integer idTipo;

	@Column(name="id_tran")
	private Integer idTran;

	@Column(name="id_tran_divi")
	private Integer idTranDivi;

	@Column(name="id_turn")
	private Long idTurn;

	@Column(name="usr_crea")
	private String usrCrea;

	@Column(name="usr_modi")
	private String usrModi;

}