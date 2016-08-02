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
@Table(name = "COMPTES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Comptes.findAll", query = "SELECT c FROM Comptes c"),
    @NamedQuery(name = "Comptes.findById", query = "SELECT c FROM Comptes c WHERE c.id = :id"),
    @NamedQuery(name = "Comptes.findBySolde", query = "SELECT c FROM Comptes c WHERE c.solde = :solde")})
public class Comptes implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "SOLDE")
    private BigInteger solde;
    @JoinColumn(name = "REF_CLIENT", referencedColumnName = "ID")
    @ManyToOne
    private Clients refClient;

    public Comptes() {
    }

    public Comptes(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigInteger getSolde() {
        return solde;
    }

    public void setSolde(BigInteger solde) {
        this.solde = solde;
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
        if (!(object instanceof Comptes)) {
            return false;
        }
        Comptes other = (Comptes) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return id + " : " + solde + "€";
    }
    
}
