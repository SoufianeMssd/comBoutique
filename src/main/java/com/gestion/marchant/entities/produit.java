package com.gestion.marchant.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
@Entity
public class produit implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idProduit;
	@NotEmpty
	@Size(min=3,max=20)
	private String designation;
	@Size(min=3)
	private String description;
	@Min(1)
	private double prix;
	private String photo;
	@ManyToOne
	@JoinColumn(name="idCategorie")
	private categorie catego;
	@Min(1)
	private int quantite;
	@ManyToOne
	@JoinColumn(name="idUtilisateur")
	private utilisateur user;
	private String username;
	

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public produit(String designation, String description, double prix,
			 String photo, int quantite,utilisateur user) {
		super();
		this.designation = designation;
		this.description = description;
		this.prix = prix;

		this.photo = photo;
		this.quantite = quantite;
		this.user=user;
	}

	public utilisateur getUser() {
		return user;
	}

	public void setUser(utilisateur user) {
		this.user = user;
	}

	public produit() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getIdProduit() {
		return idProduit;
	}

	public void setIdProduit(Long idProduit) {
		this.idProduit = idProduit;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public categorie getCatego() {
		return catego;
	}

	public void setCatego(categorie catego) {
		this.catego = catego;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

}
