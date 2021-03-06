package com.sahudyscos.web.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sahudyscos.web.entity.key.ReleaseId;

@Entity // This tells Hibernate to make a table out of this class
@Table(name = "versao")
@IdClass(ReleaseId.class)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Release implements Serializable {
    private static final long serialVersionUID = 1L;

	@Id
    @Column(name = "cod_barras")
    private Long id;

    @Id
    @Column(name = "cod_album")
    private Long albumId;

    @Column(name = "mbid")
    private UUID mbid;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "cod_album", insertable = false, updatable = false)
    private Album album;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="cod_gravadora")
    private Label label;
    
    @Column(name = "formato")
    private String format;
    @Column(name = "tipo_versao")
    private String type;

    @Column(name = "qtd_vendida")
    private Float amountSold;
    @Column(name = "qtd_disponivel")
    private Float amountAvailable;
    @Column(name = "preco")
    private Float price;

    @Column(name = "promocao")
    private Boolean onSaleStatus;

    @Column(name = "data_lancamento")
    private Date releaseDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UUID getMbid() {
		return mbid;
	}

	public void setMbid(UUID mbid) {
		this.mbid = mbid;
    }

    public Long getAlbumId() {
        return albumId;
    }

    public void setAlbumId(Long albumId) {
        this.albumId = albumId;
    }

    public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
    }

    public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
    }

    public Float getAmountSold() {
        return amountSold;
    }

    public void setAmountSold(Float amountSold) {
        this.amountSold = amountSold;
    }

    public Float getAmountAvailable() {
        return amountAvailable;
    }

    public void setAmountAvailable(Float amountAvailable) {
        this.amountAvailable = amountAvailable;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Boolean getOnSaleStatus() {
        return onSaleStatus;
    }

    public void setOnSaleStatus(Boolean onSaleStatus) {
        this.onSaleStatus = onSaleStatus;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public Label getLabel() {
        return label;
    }

    public void setLabel(Label label) {
        this.label = label;
    }
    
}