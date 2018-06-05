package com.sahudyscos.web.entity;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.hibernate.annotations.NaturalId;

@Entity // This tells Hibernate to make a table out of this class
@Table(name = "gravadora")
public class Label {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "cod_gravadora")
    private Long id;

    @NaturalId
    @Column(name = "nome")
    private String name; 
    @Column(name = "email")
    private String email;
    @Column(name = "genero1")
    private String genre;
    @Column(name = "genero2")
    private String altGenre;
    @Column(name = "telefone1")
    private String phone;
    @Column(name = "telefone2")
    private String altPhone;

    @Column(name = "data_fundacao")
    private Date activityStart;

    @ManyToMany(mappedBy = "labelsContracted", fetch=FetchType.LAZY)
    @JsonIgnore
    private List<Artist> artistsContracted;

    @OneToMany(mappedBy = "label", fetch=FetchType.LAZY)
    @JsonIgnore
    private List<Release> releases;

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

    public String getEmail() {
		return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
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

    public String getPhone() {
		return phone;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAltPhone() {
		return altPhone;
    }
    
    public void setAltPhone(String altPhone) {
        this.altPhone = altPhone;
    }

    public List<Release> getReleases() {
        return releases;
    }

    public void setReleases(List<Release> releases) {
        this.releases = releases;
    }
}