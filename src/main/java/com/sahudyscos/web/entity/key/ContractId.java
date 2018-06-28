package com.sahudyscos.web.entity.key;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class ContractId implements Serializable {
    private static final long serialVersionUID = 1L;
	Long artistId;
    Long labelId;

    public ContractId() { }

    public ContractId(Long artistId, Long labelId) {
        this.artistId = artistId;
        this.labelId = labelId;
    }
}