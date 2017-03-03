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
 * The persistent class for the sfru_asgn_via database table.
 * 
 */
@Entity
@Table(name = "sfru_asgn_via", schema = "sitm")
@NamedQuery(name = "SfruAsgnVia.findAll", query = "SELECT s FROM SfruAsgnVia s")
@Data
public class SfruAsgnVia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "SFRU_ASGN_VIA_ID_GENERATOR", sequenceName = "sitm.sfru_asgn_via_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SFRU_ASGN_VIA_ID_GENERATOR")
	private Integer id;

	@Column(name = "fch_crea")
	private Timestamp fchCrea;

	@Column(name = "fch_modi")
	private Timestamp fchModi;

	@Column(name = "id_asgn")
	private Integer idAsgn;

	@Column(name = "id_esta")
	private Integer idEsta;

	@Column(name = "id_lin")
	private Integer idLin;

	@Column(name = "id_ruta")
	private Integer idRuta;

	@Column(name = "id_tipo")
	private Integer idTipo;

	@Column(name = "id_tipo_usr")
	private Integer idTipoUsr;

	@Column(name = "id_vehi")
	private Integer idVehi;

	@Column(name = "usr_crea")
	private String usrCrea;

	@Column(name = "usr_modi")
	private String usrModi;

}