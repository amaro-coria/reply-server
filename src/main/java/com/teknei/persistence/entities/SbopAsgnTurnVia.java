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
 * The persistent class for the sbop_asgn_turn_via database table.
 * 
 */
@Entity
@Table(name="sbop_asgn_turn_via", schema = "sitm")
@NamedQuery(name="SbopAsgnTurnVia.findAll", query="SELECT s FROM SbopAsgnTurnVia s")
@Data
public class SbopAsgnTurnVia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SBOP_ASGN_TURN_VIA_ID_GENERATOR", sequenceName="sitm.sbop_asgn_turn_via_id_seq")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SBOP_ASGN_TURN_VIA_ID_GENERATOR")
	private Long id;

	@Column(name="fch_crea")
	private Timestamp fchCrea;

	@Column(name="fch_modi")
	private Timestamp fchModi;

	@Column(name="id_asgn_turn")
	private Integer idAsgnTurn;

	@Column(name="id_con_sis")
	private Integer idConSis;

	@Column(name="id_equi")
	private Integer idEqui;

	@Column(name="id_esta")
	private Integer idEsta;

	@Column(name="id_lin_est")
	private Integer idLinEst;

	@Column(name="id_suc")
	private Integer idSuc;

	@Column(name="id_tipo")
	private Integer idTipo;

	@Column(name="id_turn")
	private Long idTurn;

	@Column(name="id_vehi")
	private Integer idVehi;

	@Column(name="no_econ")
	private String noEcon;

	@Column(name="usr_crea")
	private String usrCrea;

	@Column(name="usr_modi")
	private String usrModi;


}