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
 * The persistent class for the caup_tran_via database table.
 * 
 */
@Entity
@Table(name="caup_tran_via", schema = "sitm")
@NamedQuery(name="CaupTranVia.findAll", query="SELECT c FROM CaupTranVia c")
@Data
public class CaupTranVia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CAUP_TRAN_VIA_ID_GENERATOR", sequenceName="sitm.caup_tran_via_id_seq")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CAUP_TRAN_VIA_ID_GENERATOR")
	private Long id;

	@Column(name="des_moti_sust")
	private String desMotiSust;

	@Column(name="fch_crea")
	private Timestamp fchCrea;

	@Column(name="fch_modi")
	private Timestamp fchModi;

	@Column(name="fch_vig")
	private Timestamp fchVig;

	@Column(name="id_abon_sald")
	private Integer idAbonSald;

	@Column(name="id_caup_tran")
	private Integer idCaupTran;

	@Column(name="id_emp")
	private Integer idEmp;

	@Column(name="id_equi")
	private Integer idEqui;

	@Column(name="id_esta")
	private Integer idEsta;

	@Column(name="id_esta_ope")
	private Integer idEstaOpe;

	@Column(name="id_moti_sust")
	private Integer idMotiSust;

	@Column(name="id_ope_cau")
	private Integer idOpeCau;

	@Column(name="id_pers")
	private Integer idPers;

	@Column(name="id_tipo")
	private Integer idTipo;

	@Column(name="id_turn")
	private Integer idTurn;

	@Column(name="id_usua_pref")
	private Integer idUsuaPref;

	@Column(name="impo_tarj_ant")
	private BigDecimal impoTarjAnt;

	@Column(name="impo_tarj_nue")
	private BigDecimal impoTarjNue;

	private String tcre;

	@Column(name="uid_tarj_ant")
	private String uidTarjAnt;

	@Column(name="uid_tarj_nue")
	private String uidTarjNue;

	@Column(name="usr_crea")
	private String usrCrea;

	@Column(name="usr_modi")
	private String usrModi;


}