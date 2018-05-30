package com.sahudyscos.web.entity.key;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class RecordingId implements Serializable {
    private static final long serialVersionUID = 1L;
	Long artistId;
    Long albumId;

    public RecordingId() { }

    public RecordingId(Long artistId, Long albumId) {
        this.artistId = artistId;
        this.albumId = albumId;
    }
}