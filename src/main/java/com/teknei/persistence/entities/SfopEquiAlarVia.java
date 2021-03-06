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
 * The persistent class for the sfop_equi_alar_via database table.
 * 
 */
@Entity
@Table(name = "sfop_equi_alar_via", schema = "sitm")
@NamedQuery(name = "SfopEquiAlarVia.findAll", query = "SELECT s FROM SfopEquiAlarVia s")
@Data
public class SfopEquiAlarVia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "SFOP_EQUI_ALAR_VIA_ID_GENERATOR", sequenceName = "sitm.sfop_equi_alar_via_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SFOP_EQUI_ALAR_VIA_ID_GENERATOR")
	private Long id;

	@Column(name = "desc_opeq_alar")
	private String descOpeqAlar;

	@Column(name = "esta_anti")
	private Integer estaAnti;

	@Column(name = "esta_equi")
	private String estaEqui;

	@Column(name = "fch_crea")
	private Timestamp fchCrea;

	@Column(name = "fch_fin")
	private Timestamp fchFin;

	@Column(name = "fch_inic")
	private Timestamp fchInic;

	@Column(name = "fch_modi")
	private Timestamp fchModi;

	@Column(name = "id_alar")
	private Integer idAlar;

	@Column(name = "id_est")
	private Integer idEst;

	@Column(name = "id_esta")
	private Integer idEsta;

	@Column(name = "id_opeq_alar")
	private Integer idOpeqAlar;

	@Column(name = "id_tipo")
	private Integer idTipo;

	@Column(name = "id_vehi")
	private Integer idVehi;

	@Column(name = "lati_alar")
	private double latiAlar;

	@Column(name = "lont_alar")
	private double lontAlar;

	@Column(name = "stat_alar")
	private Integer statAlar;

	@Column(name = "tram_gps")
	private double tramGps;

	@Column(name = "usr_crea")
	private String usrCrea;

	@Column(name = "usr_modi")
	private String usrModi;

}