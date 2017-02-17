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
 * The persistent class for the sfmo_hist_rece_nave_via database table.
 * 
 */
@Entity
@Table(name="sfmo_hist_rece_nave_via", schema = "sitm")
@NamedQuery(name="SfmoHistReceNaveVia.findAll", query="SELECT s FROM SfmoHistReceNaveVia s")
@Data
public class SfmoHistReceNaveVia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SFMO_HIST_RECE_NAVE_VIA_ID_GENERATOR", sequenceName="sitm.sfmo_hist_rece_nave_via_id_seq")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SFMO_HIST_RECE_NAVE_VIA_ID_GENERATOR")
	private Long id;

	@Column(name="dist_reco_rece_nave")
	private Double distRecoReceNave;

	@Column(name="fch_crea")
	private Timestamp fchCrea;

	@Column(name="fch_modi")
	private Timestamp fchModi;

	@Column(name="fch_rece_nave")
	private Timestamp fchReceNave;

	@Column(name="hora_gps_rece_nave")
	private Timestamp horaGpsReceNave;

	@Column(name="hora_sist_rece_nave")
	private Timestamp horaSistReceNave;

	@Column(name="id_con_sis")
	private Integer idConSis;

	@Column(name="id_esta")
	private Integer idEsta;

	@Column(name="id_reco_nave")
	private Integer idRecoNave;

	@Column(name="id_tipo")
	private Integer idTipo;

	@Column(name="id_vehi")
	private Integer idVehi;

	@Column(name="lati_rece_nave")
	private Double latiReceNave;

	@Column(name="long_rece_nave")
	private Double longReceNave;

	@Column(name="mode_rece_nave")
	private String modeReceNave;

	@Column(name="num_seri_reco_nave")
	private String numSeriRecoNave;

	@Column(name="time_reco_rece_nave")
	private Double timeRecoReceNave;

	@Column(name="usr_crea")
	private String usrCrea;

	@Column(name="usr_modi")
	private String usrModi;

	@Column(name="velo_rece_nave")
	private Double veloReceNave;


}