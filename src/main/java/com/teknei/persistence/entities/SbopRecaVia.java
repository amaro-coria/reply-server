/**
 * Teknei 2016
 */
package com.teknei.persistence.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * The persistent class for the sbop_reca_via database table.
 */
@Entity
@Table(name = "sbop_reca_via", schema = "sitm")
@NamedQuery(name = "SbopRecaVia.findAll", query = "SELECT s FROM SbopRecaVia s")
@Data
public class SbopRecaVia implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "SBOP_RECA_VIA_ID_GENERATOR", sequenceName = "sitm.sbop_reca_via_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SBOP_RECA_VIA_ID_GENERATOR")
    private Long id;

    @Column(name = "fch_crea")
    private Timestamp fchCrea;

    @Column(name = "fch_modi")
    private Timestamp fchModi;

    @Column(name = "fch_reca")
    private Timestamp fchReca;

    @Column(name = "id_con_sis")
    private Integer idConSis;

    @Column(name = "id_equi")
    private Integer idEqui;

    @Column(name = "id_esta")
    private Integer idEsta;

    @Column(name = "id_reca")
    private Integer idReca;

    @Column(name = "id_tarj")
    private Integer idTarj;

    @Column(name = "id_tipo")
    private Integer idTipo;

    @Column(name = "tot_bill")
    private BigDecimal totBill;

    @Column(name = "tot_mone")
    private BigDecimal totMone;

    @Column(name = "uid_tarj")
    private String uidTarj;

    @Column(name = "usr_crea")
    private String usrCrea;

    @Column(name = "usr_modi")
    private String usrModi;

    @Column(name = "id_traz")
    private Integer idTraz;


}