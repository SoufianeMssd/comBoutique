package com.gestion.marchant.dao;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.hibernate.classic.Session;

import com.gestion.marchant.entities.categorie;
import com.gestion.marchant.entities.client;
import com.gestion.marchant.entities.produit;
import com.gestion.marchant.entities.role;
import com.gestion.marchant.entities.utilisateur;

public class daoImpl implements eboutiqueDao{
	
	//this is entitymanager vs session or entitymanagerfactory vs sessionfactory
	
	//this is using JPA with hibernate implementation 
	//which can allow you to switch to another implementation as toplink whenever you want 
	@PersistenceContext 	 //The persistence context is just a synchronizer 
	private EntityManager em;//object that tracks the state of a limited set of Java objects 
							 //and makes sure that changes on those objects are eventually
							 //persisted back into the database
	

	
	//if you wanna work with only hibernate specification
//	private Session session = em.unwrap(Session.class);
	
	@Override
	public Long ajouterCategorie(categorie c) {
		// TODO Auto-generated method stub
		em.persist(c);
		return c.getIdCategorie();
	}

	@Override
	public List<categorie> listCategorie() {
		// TODO Auto-generated method stub
		Query req=em.createQuery("select c from categorie c");
		return req.getResultList();
	}

	@Override
	public categorie getCategorie(Long idCat) {
		// TODO Auto-generated method stub
		return em.find(categorie.class, idCat);
	}

	@Override
	public void supprimerCategorie(Long idCat) {
		// TODO Auto-generated method stub
		categorie c=em.find(categorie.class, idCat);
		em.remove(c);
	}

	@Override
	public void modifierCategorie(categorie c) {
		// TODO Auto-generated method stub
		em.merge(c);
	}

	@Override
	public Long ajouterProduit(produit p, Long idCat) {
		// TODO Auto-generated method stub
		categorie c=getCategorie(idCat);
		p.setCatego(c);
		em.persist(p);
		return p.getIdProduit();
	}

	@Override
	public List<produit> listProduit() {
		// TODO Auto-generated method stub
		Query req=em.createQuery("select p from produit p");
		return req.getResultList();
	}

	@Override
	public List<produit> produitParMotCle(String mc) {
		// TODO Auto-generated method stub
		Query req=em.createQuery("select p from produit p where p.designation=:x or p.description=:x ");
		req.setParameter("x",mc);
		return req.getResultList();
	}

	@Override
	public List<produit> produitParCategorie(Long idCat) {
		// TODO Auto-generated method stub
		Query req=em.createQuery("select p from produit p where p.catego.idCategorie=:x");
		req.setParameter("x", idCat);
		return req.getResultList();
	}

	@Override
	public List<produit> produitSelectionné() {
		// TODO Auto-generated method stub
		Query req=em.createQuery("select p from produit p where p.selected=true");
		return req.getResultList();
	}

	@Override
	public produit getProduit(Long idP) {
		
		return em.find(produit.class, idP);
	}

	@Override
	public void supprimerProduit(Long idP) {
		// TODO Auto-generated method stub
		produit p=getProduit(idP);
		em.remove(p);
		
	}

	@Override
	public void modifierProduit(produit p) {
		// TODO Auto-generated method stub
		em.merge(p);
	}

	@Override
	public void ajouterUtilisateur(utilisateur u) {
		// TODO Auto-generated method stub
		em.persist(u);
	}

	@Override
	public void attribuerRole(role r, Long utilisateurId) {
		// TODO Auto-generated method stub
		utilisateur u=em.find(utilisateur.class,utilisateurId);
		u.getRoles().add(r);
		em.persist(r);
	}
	



	@Override
	public List<utilisateur> listUtilisateur() {
		// TODO Auto-generated method stub
		Query req=em.createQuery("select u from utilisateur u where u.phoneNumber!=0");
		return req.getResultList();
	}

	@Override
	public void supprimerUtilisateur(Long idU) {
		// TODO Auto-generated method stub
		utilisateur p=getUtilisateur(idU);
		em.remove(p);
	}

	@Override
	public utilisateur getUtilisateur(Long idP) {
		// TODO Auto-generated method stub
		return em.find(utilisateur.class, idP);
	}

	@Override
	public List<utilisateur> utilisateurParMotCle(String mc) {
		// TODO Auto-generated method stub
		Query req=em.createQuery("select u from utilisateur u where u.userName=:x and u.phoneNumber!=0");
		req.setParameter("x",mc);
		return req.getResultList();
	}
	

}
