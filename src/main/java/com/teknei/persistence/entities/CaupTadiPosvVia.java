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
 * The persistent class for the caup_tadi_posv_via database table.
 * 
 */
@Entity
@Table(name="caup_tadi_posv_via", schema = "sitm")
@NamedQuery(name="CaupTadiPosvVia.findAll", query="SELECT c FROM CaupTadiPosvVia c")
@Data
public class CaupTadiPosvVia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CAUP_TADI_POSV_VIA_ID_GENERATOR", sequenceName="sitm.caup_tadi_posv_via_id_seq")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CAUP_TADI_POSV_VIA_ID_GENERATOR")
	private Long id;

	@Column(name="fch_crea")
	private Timestamp fchCrea;

	@Column(name="fch_modi")
	private Timestamp fchModi;

	@Column(name="id_dist_posv")
	private Integer idDistPosv;

	@Column(name="id_equi")
	private Integer idEqui;

	@Column(name="id_esta")
	private Integer idEsta;

	@Column(name="id_esta_tadi")
	private Integer idEstaTadi;

	@Column(name="id_tadi_posv")
	private Integer idTadiPosv;

	@Column(name="id_tipo")
	private Integer idTipo;

	@Column(name="sald_tarj")
	private BigDecimal saldTarj;

	private String tcre;

	@Column(name="uid_tarj")
	private String uidTarj;

	@Column(name="usr_crea")
	private String usrCrea;

	@Column(name="usr_modi")
	private String usrModi;


}