package com.gestion.marchant.metier;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.gestion.marchant.dao.eboutiqueDao;
import com.gestion.marchant.entities.categorie;
import com.gestion.marchant.entities.produit;
import com.gestion.marchant.entities.role;
import com.gestion.marchant.entities.utilisateur;
@Transactional
public class eboutiqueMetierImpl implements IAdmin{
	private eboutiqueDao dao;
	public void setDao(eboutiqueDao dao) {
		this.dao = dao;
	}

	@Override
	public void supprimerProduit(Long idP) {
		// TODO Auto-generated method stub
		dao.supprimerProduit(idP);
	}

	@Override
	public void modifierProduit(produit p) {
		// TODO Auto-generated method stub
		dao.modifierProduit(p);
	}

	@Override
	public Long ajouterProduit(produit p, Long idCat) {
		// TODO Auto-generated method stub
		return dao.ajouterProduit(p, idCat);
	}

	@Override
	public List<categorie> listCategorie() {
		// TODO Auto-generated method stub
		return dao.listCategorie();
	}

	@Override
	public categorie getCategorie(Long idCat) {
		// TODO Auto-generated method stub
		return dao.getCategorie(idCat);
	}

	@Override
	public List<produit> listProduit() {
		// TODO Auto-generated method stub
		return dao.listProduit();
	}

	@Override
	public List<produit> produitParMotCle(String mc) {
		// TODO Auto-generated method stub
		return dao.produitParMotCle(mc);
	}

	@Override
	public List<produit> produitParCategorie(Long idCat) {
		// TODO Auto-generated method stub
		return dao.produitParCategorie(idCat);
	}

	@Override
	public List<produit> produitSelectionné() {
		// TODO Auto-generated method stub
		return dao.produitSelectionné();
	}

	@Override
	public produit getProduit(Long idP) {
		// TODO Auto-generated method stub
		return dao.getProduit(idP);
	}



	@Override
	public void supprimerCategorie(Long idCat) {
		// TODO Auto-generated method stub
		dao.supprimerCategorie(idCat);
	}

	@Override
	public void modifierCategorie(categorie c) {
		// TODO Auto-generated method stub
		dao.modifierCategorie(c);
	}

	@Override
	public Long ajouterCategorie(categorie c) {
		// TODO Auto-generated method stub
		return dao.ajouterCategorie(c);
	}

	@Override
	public void ajouterUtilisateur(utilisateur u) {
		// TODO Auto-generated method stub
		dao.ajouterUtilisateur(u);
	}

	@Override
	public void attribuerRole(role r, Long utilisateurId) {
		// TODO Auto-generated method stub
		dao.attribuerRole(r, utilisateurId);
	}

	@Override
	public List<utilisateur> listUtilisateur() {
		// TODO Auto-generated method stub
		return dao.listUtilisateur();
	}

	@Override
	public void supprimerUtilisateur(Long idU) {
		// TODO Auto-generated method stub
		dao.supprimerUtilisateur(idU);
	}

	@Override
	public utilisateur getUtilisateur(Long idP) {
		// TODO Auto-generated method stub
		return dao.getUtilisateur(idP);
	}

	@Override
	public List<utilisateur> utilisateurParMotCle(String mc) {
		// TODO Auto-generated method stub
		return dao.utilisateurParMotCle(mc);
	}


}
