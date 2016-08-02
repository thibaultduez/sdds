/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author thibault
 */
@Entity
@Table(name = "CREDITS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Credits.findAll", query = "SELECT c FROM Credits c"),
    @NamedQuery(name = "Credits.findById", query = "SELECT c FROM Credits c WHERE c.id = :id"),
    @NamedQuery(name = "Credits.findByMontant", query = "SELECT c FROM Credits c WHERE c.montant = :montant"),
    @NamedQuery(name = "Credits.findByTaux", query = "SELECT c FROM Credits c WHERE c.taux = :taux"),
    @NamedQuery(name = "Credits.findByDuree", query = "SELECT c FROM Credits c WHERE c.duree = :duree"),
    @NamedQuery(name = "Credits.findBySalaire", query = "SELECT c FROM Credits c WHERE c.salaire = :salaire"),
    @NamedQuery(name = "Credits.findByChargeCredit", query = "SELECT c FROM Credits c WHERE c.chargeCredit = :chargeCredit"),
    @NamedQuery(name = "Credits.findByAccorde", query = "SELECT c FROM Credits c WHERE c.accorde = :accorde")})
public class Credits implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "MONTANT")
    private BigInteger montant;
    @Column(name = "TAUX")
    private BigInteger taux;
    @Column(name = "DUREE")
    private BigInteger duree;
    @Column(name = "SALAIRE")
    private BigInteger salaire;
    @Column(name = "CHARGE_CREDIT")
    private BigInteger chargeCredit;
    @Column(name = "ACCORDE")
    private BigInteger accorde;
    @JoinColumn(name = "REF_CLIENT", referencedColumnName = "ID")
    @ManyToOne
    private Clients refClient;

    public Credits() {
    }

    public Credits(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigInteger getMontant() {
        return montant;
    }

    public void setMontant(BigInteger montant) {
        this.montant = montant;
    }

    public BigInteger getTaux() {
        return taux;
    }

    public void setTaux(BigInteger taux) {
        this.taux = taux;
    }

    public BigInteger getDuree() {
        return duree;
    }

    public void setDuree(BigInteger duree) {
        this.duree = duree;
    }

    public BigInteger getSalaire() {
        return salaire;
    }

    public void setSalaire(BigInteger salaire) {
        this.salaire = salaire;
    }

    public BigInteger getChargeCredit() {
        return chargeCredit;
    }

    public void setChargeCredit(BigInteger chargeCredit) {
        this.chargeCredit = chargeCredit;
    }

    public BigInteger getAccorde() {
        return accorde;
    }

    public void setAccorde(BigInteger accorde) {
        this.accorde = accorde;
    }

    public Clients getRefClient() {
        return refClient;
    }

    public void setRefClient(Clients refClient) {
        this.refClient = refClient;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Credits)) {
            return false;
        }
        Credits other = (Credits) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Credits[ id=" + id + " ]";
    }
    
}
