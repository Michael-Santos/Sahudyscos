package com.sahudyscos.web.entity;

import java.sql.Date;
import java.util.List;
import java.util.UUID;

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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import org.hibernate.annotations.Formula;

@Entity // This tells Hibernate to make a table out of this class
@Table(name = "banda")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Artist {
    @Id
    //@GeneratedValue(strategy=GenerationType.AUTO)
    @GeneratedValue(generator = "banda_sequence", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "banda_sequence", sequenceName = "banda_sequence",allocationSize=1)
    @Column(name = "cod_banda")
    private Long id;

    @Column(name = "mbid")
    private UUID mbid;

    //@NaturalId
    @Column(name = "nome")
    private String name; 
    @Column(name = "descricao")
    private String description;
    @Column(name = "genero1")
    private String genre;
    @Column(name = "genero2")
    private String altGenre;

    @Column(name = "data_fundacao")
    private Date activityStart;

    @ManyToMany(mappedBy = "artists", fetch=FetchType.LAZY)
    @JsonIgnore
    private List<Album> albums;

    @ManyToMany(cascade = { 
        CascadeType.PERSIST, 
        CascadeType.MERGE
    },
    fetch=FetchType.LAZY)
    @JoinTable(name = "contrato",
        joinColumns = @JoinColumn(name = "cod_banda"),
        inverseJoinColumns = @JoinColumn(name = "cod_gravadora")
    )
    @JsonIgnore
    private List<Label> labelsContracted;

    public UUID getMbid() {
		return mbid;
	}

	public void setMbid(UUID mbid) {
		this.mbid = mbid;
    }

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

    public Date getActivityStart() {
        return activityStart;
    }

    public void setActivityStart(Date activityStart) {
        this.activityStart = activityStart;
    }

    public List<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(List<Album> albums) {
        this.albums = albums;
    }
}