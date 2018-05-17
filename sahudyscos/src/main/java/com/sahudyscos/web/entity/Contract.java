package com.sahudyscos.web.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity // This tells Hibernate to make a table out of this class
@Table(name = "contrato")
@IdClass(ContractId.class)
public class Contract {
    @Id
    private Long artistId;
    @Id
    private Long labelId;

    public Long getArtistId() {
        return artistId;
    }

    public void setArtistId(Long artistId) {
        this.artistId = artistId;
    }

    public Long getLabelId() {
        return artistId;
    }

    public void setLabelId(Long labelId) {
        this.labelId = labelId;
    }
}

@Embeddable
class ContractId implements Serializable {
    private static final long serialVersionUID = 1L;
	@Column(name = "cod_banda")
    Long artistId;
    @Column(name = "cod_gravadora")
    Long labelId;
}