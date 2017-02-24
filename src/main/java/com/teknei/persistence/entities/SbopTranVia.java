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
 * The persistent class for the sbop_tran_via database table.
 * 
 */
@Entity
@Table(name = "sbop_tran_via", schema = "sitm")
@NamedQuery(name = "SbopTranVia.findAll", query = "SELECT s FROM SbopTranVia s")
@Data
public class SbopTranVia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "SBOP_TRAN_VIA_ID_GENERATOR", sequenceName = "sitm.sbop_tran_via_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SBOP_TRAN_VIA_ID_GENERATOR")
	private Long id;

	private String canc;

	@Column(name = "fch_crea")
	private Timestamp fchCrea;

	@Column(name = "fch_modi")
	private Timestamp fchModi;

	@Column(name = "fch_tran")
	private Timestamp fchTran;

	@Column(name = "id_con_sis")
	private Integer idConSis;

	@Column(name = "id_empr_tarj")
	private Integer idEmprTarj;

	@Column(name = "id_equi")
	private Integer idEqui;

	@Column(name = "id_esta")
	private Integer idEsta;

	@Column(name = "id_lbla")
	private Integer idLbla;

	@Column(name = "id_mot_canc")
	private Integer idMotCanc;

	@Column(name = "id_tarj")
	private Integer idTarj;

	@Column(name = "id_tipo")
	private Integer idTipo;

	@Column(name = "id_tran")
	private Integer idTran;

	@Column(name = "id_turn")
	private Long idTurn;

	@Column(name = "impo_tran")
	private BigDecimal impoTran;

	@Column(name = "impo_web")
	private BigDecimal impoWeb;

	@Column(name = "mont_chcr")
	private BigDecimal montChcr;

	@Column(name = "sald_ini")
	private BigDecimal saldIni;

	@Column(name = "sald_tarj")
	private BigDecimal saldTarj;

	private String tcre;

	@Column(name = "tipo_tran")
	private String tipoTran;

	@Column(name = "uid_tarj")
	private String uidTarj;

	@Column(name = "usr_crea")
	private String usrCrea;

	@Column(name = "usr_modi")
	private String usrModi;

}