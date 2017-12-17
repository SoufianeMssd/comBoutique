package com.gestion.marchant.metier;

import java.util.List;

import com.gestion.marchant.entities.*;

public interface IAdmin{
	public void supprimerProduit(Long idP);
	public void modifierProduit(produit p);
	public Long ajouterProduit(produit p, Long idCat);
	public void supprimerCategorie(Long idCat);
	public void modifierCategorie(categorie c);
	public Long ajouterCategorie(categorie c);
	public void ajouterUtilisateur(utilisateur u);
	public void attribuerRole(role r,Long utilisateurId);
	public List<utilisateur> listUtilisateur();
	public void supprimerUtilisateur(Long idU);
	public utilisateur getUtilisateur(Long idP);
	public List<utilisateur> utilisateurParMotCle(String mc);
	public List<categorie> listCategorie();
	public categorie getCategorie(Long idCat);
	public List<produit> listProduit();
	public List<produit> produitParMotCle(String mc);
	public List<produit> produitParCategorie(Long idCat);
	public List<produit> produitSelectionné();
	public produit getProduit(Long idP);

}
