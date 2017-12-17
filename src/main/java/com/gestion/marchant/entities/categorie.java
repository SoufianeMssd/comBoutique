package com.gestion.marchant.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;
@Entity
public class categorie implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idCategorie;
	@NotEmpty
	@Size(min=4,max=30)
	private String nomCategorie;
	@Size(min=4)
	private String description;

	@OneToMany(mappedBy="catego")
	private Collection<produit> produits;
	public categorie() {
		super();
		// TODO Auto-generated constructor stub
	}
	public categorie(String nomCategorie, String description) {
		super();
		
		this.nomCategorie = nomCategorie;
		this.description = description;
	
		
	}
	public Collection<produit> getProduits() {
		return produits;
	}
	public void setProduits(Collection<produit> produits) {
		this.produits = produits;
	}
	
	
	public Long getIdCategorie() {
		return idCategorie;
	}
	public void setIdCategorie(Long idCategorie) {
		this.idCategorie = idCategorie;
	}
	public String getNomCategorie() {
		return nomCategorie;
	}
	public void setNomCategorie(String nomCategorie) {
		this.nomCategorie = nomCategorie;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}