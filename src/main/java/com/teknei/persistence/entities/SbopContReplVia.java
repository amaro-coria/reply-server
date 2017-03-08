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
 * The persistent class for the sbop_cont_repl_via database table.
 * 
 */
@Entity
@Table(name = "sbop_cont_repl_via", schema = "sitm")
@NamedQuery(name = "SbopContReplVia.findAll", query = "SELECT s FROM SbopContReplVia s")
@Data
public class SbopContReplVia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "SBOP_CONT_REPL_VIA_ID_GENERATOR", sequenceName = "sitm.sbop_cont_repl_via_id_cont_repl_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SBOP_CONT_REPL_VIA_ID_GENERATOR")
	private Long id;

	@Column(name = "fch_crea")
	private Timestamp fchCrea;

	@Column(name = "fch_modi")
	private Timestamp fchModi;

	@Column(name = "fch_oper")
	private Timestamp fchOper;

	@Column(name = "id_cont_repl")
	private Integer idContRepl;

	@Column(name = "id_equi")
	private Integer idEqui;

	@Column(name = "id_esta")
	private Integer idEsta;

	@Column(name = "id_tipo")
	private Integer idTipo;

	@Column(name = "id_tipo_repl")
	private Integer idTipoRepl;

	@Column(name = "id_vehi")
	private Integer idVehi;

	@Column(name = "reg_disp_tot")
	private Integer regDispTot;

	@Column(name = "reg_envi_tot")
	private Integer regEnviTot;

	@Column(name = "reg_pend_envi")
	private Integer regPendEnvi;

	@Column(name = "usr_crea")
	private String usrCrea;

	@Column(name = "usr_modi")
	private String usrModi;


}