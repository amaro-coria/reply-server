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
 * The persistent class for the sfvh_data_dia_via database table.
 * 
 */
@Entity
@Table(name="sfvh_data_dia_via")
@NamedQuery(name="SfvhDataDiaVia.findAll", query="SELECT s FROM SfvhDataDiaVia s")
@Data
public class SfvhDataDiaVia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SFVH_DATA_DIA_VIA_ID_GENERATOR", sequenceName="sitm.sfvh_data_dia_via_id_seq")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SFVH_DATA_DIA_VIA_ID_GENERATOR")
	private Long id;

	@Column(name="dia_reg")
	private Timestamp diaReg;

	@Column(name="fch_crea")
	private Timestamp fchCrea;

	@Column(name="fch_modi")
	private Timestamp fchModi;

	@Column(name="id_data_dia")
	private Integer idDataDia;

	@Column(name="id_esta")
	private Integer idEsta;

	@Column(name="id_tipo")
	private Integer idTipo;

	@Column(name="id_vehi")
	private Integer idVehi;

	@Column(name="km_reco")
	private BigDecimal kmReco;

	@Column(name="usr_crea")
	private String usrCrea;

	@Column(name="usr_modi")
	private String usrModi;

	@Column(name="vel_prom")
	private BigDecimal velProm;

}