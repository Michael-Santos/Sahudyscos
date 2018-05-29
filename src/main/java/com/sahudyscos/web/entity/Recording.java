package com.sahudyscos.web.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity // This tells Hibernate to make a table out of this class
@Table(name = "gravacao")
@IdClass(RecordingId.class)
public class Recording {
    @Id
    private Long albumId;
    @Id
    private Long artistId;

    public Long getAlbumId() {
        return albumId;
    }

    public void setAlbumId(Long albumId) {
        this.albumId = albumId;
    }

    public Long getArtistId() {
        return artistId;
    }

    public void setArtistId(Long artistId) {
        this.artistId = artistId;
    }
}

@Embeddable
class RecordingId implements Serializable {
    private static final long serialVersionUID = 1L;
	@Column(name = "cod_album")
    Long albumId;
    @Column(name = "cod_banda")
    Long artistId;
}