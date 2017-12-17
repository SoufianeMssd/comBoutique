package com.gestion.marchant;

import static org.junit.Assert.*;

import java.util.List;




import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import com.gestion.marchant.entities.categorie;
import com.gestion.marchant.entities.produit;
import com.gestion.marchant.metier.IAdmin;


public class testJPA {
	ClassPathXmlApplicationContext app=new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
	@Test
	public void test() {
		try {
			
			IAdmin metier =(IAdmin) app.getBean("metier");
			List<categorie> cat=metier.listCategorie();
			metier.ajouterCategorie(new categorie("soufianeCat","moussaidCat"));
			metier.ajouterCategorie(new categorie("secondCat","descCat"));
			List<categorie> cat1=metier.listCategorie();
			assertTrue(cat.size()+2==cat1.size());
		} catch (Exception e) {
			// TODO: handle exception
			assertTrue(e.getMessage(),false);
		}
	}
//	@Test
//	public void test1() {
//		try {
//			
//			IAdmin metier =(IAdmin) app.getBean("metier");
//			List<produit> prod=metier.listProduit();
//			 metier.ajouterProduit(new produit("PR01","produit1", 100, "img1.jpg",60, null), 1L);
//			metier.ajouterProduit(new produit("HP-4007","hp4007", 100, "img1.jpg",60, null),1L);
//			List<produit> prod1=metier.listProduit();
//			assertTrue(prod.size()+2==prod1.size());
//		} catch (Exception e) {
//			// TODO: handle exception
//			assertTrue(e.getMessage(),false);
//		}
//	}


}
