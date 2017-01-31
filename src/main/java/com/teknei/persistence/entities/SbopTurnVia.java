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
 * The persistent class for the sbop_turn_via database table.
 * 
 */
@Entity
@Table(name="sbop_turn_via", schema="sitm")
@NamedQuery(name="SbopTurnVia.findAll", query="SELECT s FROM SbopTurnVia s")
@Data
public class SbopTurnVia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SBOP_TURN_VIA_ID_GENERATOR", sequenceName="sitm.sbop_turn_via_id_seq")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SBOP_TURN_VIA_ID_GENERATOR")
	private Long id;

	@Column(name="fch_crea")
	private Timestamp fchCrea;

	@Column(name="fch_fin_turn")
	private Timestamp fchFinTurn;

	@Column(name="fch_ini_turn")
	private Timestamp fchIniTurn;

	@Column(name="fch_modi")
	private Timestamp fchModi;

	@Column(name="id_con_sis")
	private Integer idConSis;

	@Column(name="id_edo_ses")
	private Integer idEdoSes;

	@Column(name="id_equi")
	private Integer idEqui;

	@Column(name="id_esta")
	private Integer idEsta;

	@Column(name="id_tarj")
	private Integer idTarj;

	@Column(name="id_tipo")
	private Integer idTipo;

	@Column(name="id_turn")
	private Long idTurn;

	@Column(name="mont_canc")
	private Integer montCanc;

	@Column(name="mont_turn")
	private BigDecimal montTurn;

	@Column(name="tarj_exis")
	private Integer tarjExis;

	@Column(name="tarj_vend")
	private Integer tarjVend;

	@Column(name="uid_tarj")
	private String uidTarj;

	@Column(name="usr_crea")
	private String usrCrea;

	@Column(name="usr_modi")
	private String usrModi;


}