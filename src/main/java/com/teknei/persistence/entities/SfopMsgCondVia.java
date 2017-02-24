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
 * The persistent class for the sfop_msg_cond_via database table.
 * 
 */
@Entity
@Table(name = "sfop_msg_cond_via", schema = "sitm")
@NamedQuery(name = "SfopMsgCondVia.findAll", query = "SELECT s FROM SfopMsgCondVia s")
@Data
public class SfopMsgCondVia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "SFOP_MSG_COND_VIA_ID_GENERATOR", sequenceName = "sitm.sfop_msg_cond_via_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SFOP_MSG_COND_VIA_ID_GENERATOR")
	private Long id;

	@Column(name = "fch_crea")
	private Timestamp fchCrea;

	@Column(name = "fch_modi")
	private Timestamp fchModi;

	@Column(name = "fch_regi")
	private Timestamp fchRegi;

	@Column(name = "id_esta")
	private Integer idEsta;

	@Column(name = "id_msg_cond")
	private Integer idMsgCond;

	@Column(name = "id_tipo")
	private Integer idTipo;

	@Column(name = "id_vehi")
	private Integer idVehi;

	private String msg;

	@Column(name = "usr_crea")
	private String usrCrea;

	@Column(name = "usr_modi")
	private String usrModi;

}