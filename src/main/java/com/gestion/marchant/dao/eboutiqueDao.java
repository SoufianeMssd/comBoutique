package com.gestion.marchant.dao;

import java.util.List;

import com.gestion.marchant.entities.categorie;
import com.gestion.marchant.entities.client;
import com.gestion.marchant.entities.produit;
import com.gestion.marchant.entities.role;
import com.gestion.marchant.entities.utilisateur;

public interface eboutiqueDao {
	public Long ajouterCategorie(categorie c);
	public List<categorie> listCategorie();
	public categorie getCategorie(Long idCat);
	public void supprimerCategorie(Long idCat);
	public void modifierCategorie(categorie c);
	public Long ajouterProduit(produit p, Long idCat);
	public List<produit> listProduit();
	public List<produit> produitParMotCle(String mc);
	public List<produit> produitParCategorie(Long idCat);
	public List<produit> produitSelectionné();
	public produit getProduit(Long idP);
	public void supprimerProduit(Long idP);
	public void modifierProduit(produit p);
	public void ajouterUtilisateur(utilisateur u);
	public void attribuerRole(role r,Long utilisateurId);
	public List<utilisateur> listUtilisateur();
	public void supprimerUtilisateur(Long idU);
	public utilisateur getUtilisateur(Long idP);
	public List<utilisateur> utilisateurParMotCle(String mc);

	
}
