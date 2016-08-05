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
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Long id;
    @Column(name = "MONTANT")
    private Double montant;
    @Column(name = "TAUX")
    private Double taux;
    @Column(name = "DUREE")
    private Integer duree;
    @Column(name = "SALAIRE")
    private Double salaire;
    @Column(name = "CHARGE_CREDIT")
    private Double chargeCredit;
    @Column(name = "ACCORDE")
    private Boolean accorde;
    @JoinColumn(name = "REF_CLIENT", referencedColumnName = "ID")
    @ManyToOne
    private Clients refClient;

    public Credits() {
    }

    public Credits(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getMontant() {
        return montant;
    }

    public void setMontant(Double montant) {
        this.montant = montant;
    }

    public Double getTaux() {
        return taux;
    }

    public void setTaux(Double taux) {
        this.taux = taux;
    }

    public Integer getDuree() {
        return duree;
    }

    public void setDuree(Integer duree) {
        this.duree = duree;
    }

    public Double getSalaire() {
        return salaire;
    }

    public void setSalaire(Double salaire) {
        this.salaire = salaire;
    }

    public Double getChargeCredit() {
        return chargeCredit;
    }

    public void setChargeCredit(Double chargeCredit) {
        this.chargeCredit = chargeCredit;
    }

    public boolean isAccorde() {
        return accorde;
    }

    public void setAccorde(boolean accorde) {
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
        return refClient.getId() + " - " + String.format("%.2f", montant) + "€, " + String.format("%.2f", taux) + "%, " + duree + " mois";
    }
    
}
