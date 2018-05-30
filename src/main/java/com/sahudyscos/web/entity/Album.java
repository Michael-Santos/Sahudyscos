package com.sahudyscos.web.entity;

import java.net.URL;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.hibernate.annotations.NaturalId;

@Entity // This tells Hibernate to make a table out of this class
@Table(name = "album")
public class Album {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "cod_album")
    private Long id;

    @ManyToMany(cascade = { 
        CascadeType.PERSIST, 
        CascadeType.MERGE
    },
    fetch=FetchType.LAZY)
    @JoinTable(name = "gravacao",
        joinColumns = @JoinColumn(name = "cod_album"),
        inverseJoinColumns = @JoinColumn(name = "cod_banda")
    )
    //@JsonIgnore
    private List<Artist> artists;

    @OneToMany(mappedBy = "album", fetch=FetchType.LAZY)
    @JsonIgnore
    private List<Release> releases;

    @NaturalId
    @Column(name = "nome")
    private String name; 
    @Column(name = "pais")
    private String country;
    @Column(name = "descricao")
    private String description;
    @Column(name = "genero1")
    private String genre;
    @Column(name = "genero2")
    private String altGenre;

    @Column(name = "avaliacao")
    private Float rating;

    @Column(name = "capa")
    private URL cover;

    @Column(name = "data_publicacao")
    private Date publication;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
    }

    public String getCountry() {
		return country;
    }
    
    public void setCountry(String country) {
        this.country = country;
    }

    public String getDescription() {
		return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }

    public String getGenre() {
		return genre;
    }
    
    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getAltGenre() {
		return altGenre;
    }
    
    public void setAltGenre(String altGenre) {
        this.altGenre = altGenre;
    }

    public Float getRating() {
		return rating;
    }
    
    public void setRating(Float rating) {
        this.rating = rating;
    }
    
    public URL getCover() {
		return cover;
    }
    
    public void setCover(URL cover) {
        this.cover = cover;
    }

    public Date getPublication() {
		return publication;
    }
    
    public void setPublication(Date publication) {
        this.publication = publication;
    }

    public List<Artist> getArtists() {
        return artists;
    }

    public void setArtists(List<Artist> artists) {
        this.artists = artists;
    }

    public List<Release> getReleases() {
        return releases;
    }

    public void setReleases(List<Release> releases) {
        this.releases = releases;
    }
}