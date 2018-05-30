package com.sahudyscos.web.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.sahudyscos.web.entity.key.RecordingId;

@Entity // This tells Hibernate to make a table out of this class
@Table(name = "gravacao")
@IdClass(RecordingId.class)
public class Recording {
    @Id
    @Column(name = "cod_banda")
    private Long artistId;

    @Id
    @Column(name = "cod_album")
    private Long albumId;

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