package com.sahudyscos.web.entity.key;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class ReleaseId implements Serializable {
    private static final long serialVersionUID = 1L;
	Long id;
    Long albumId;

    public ReleaseId() { }

    public ReleaseId(Long id, Long albumId) {
        this.id = id;
        this.albumId = albumId;
    }
}