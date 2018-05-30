package com.sahudyscos.web.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.sahudyscos.web.entity.key.ContractId;

@Entity // This tells Hibernate to make a table out of this class
@Table(name = "contrato")
@IdClass(ContractId.class)
public class Contract {
    @Id
    @Column(name = "cod_banda")
    private Long artistId;
    @Id
    @Column(name = "cod_gravadora")
    private Long labelId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cod_banda", insertable =  false, updatable = false)
    private Artist artist;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cod_gravadora", insertable =  false, updatable = false)
    private Label label;

    public Long getArtistId() {
        return artistId;
    }

    public void setArtistId(Long artistId) {
        this.artistId = artistId;
    }

    public Long getLabelId() {
        return labelId;
    }

    public void setLabelId(Long labelId) {
        this.labelId = labelId;
    }

    public String getArtistName() {
        return artist.getName();
    }

    public String getLabelName() {
        return label.getName();
    }
}