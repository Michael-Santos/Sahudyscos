package com.sahudyscos.web.entity;

import java.net.URL;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // This tells Hibernate to make a table out of this class
public class Album {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long cod_album;

    private String nome, pais, descricao, genero1, genero2;
    private Float avaliacao;
    private URL capa;
    private Date data_publicacao;

	public Long getCodAlbum() {
		return cod_album;
	}

	public void setCodAlbum(Long cod_album) {
		this.cod_album = cod_album;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
    }

    public String getPais() {
		return pais;
    }
    
    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getDescricao() {
		return descricao;
    }
    
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getGenero1() {
		return genero1;
    }
    
    public void setGenero1(String genre) {
        this.genero1 = genre;
    }

    public String getGenero2() {
		return genero2;
    }
    
    public void setGenero2(String genero2) {
        this.genero2 = genero2;
    }

    public Float getAvaliacao() {
		return avaliacao;
    }
    
    public void setAvaliacao(Float avaliacao) {
        this.avaliacao = avaliacao;
    }
    
    public URL getCapa() {
		return capa;
    }
    
    public void setCapa(URL capa) {
        this.capa = capa;
    }

    public Date getPublicacao() {
		return data_publicacao;
    }
    
    public void setPublicacao(Date data_publicacao) {
        this.data_publicacao = data_publicacao;
    }
}