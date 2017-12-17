package com.gestion.marchant.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gestion.marchant.entities.categorie;
import com.gestion.marchant.entities.produit;
import com.gestion.marchant.metier.IAdmin;


@Controller
public class clientController {
	@Autowired
	IAdmin metier;
	@RequestMapping(value="/goIn")
	public String index(Model model){
		model.addAttribute("categories", metier.listCategorie());
		return "clientCategorie";
	}
	@RequestMapping(value="/seeProd")
	public String seeProd(Long idProd,Model model){
		model.addAttribute("p", metier.getProduit(idProd));
		return "produitInformation";
	}
	@RequestMapping(value="/prodDeCat")
	public String goIn(Long idCat,Model model){
		model.addAttribute("categories", metier.listCategorie());
		model.addAttribute("produit", new produit());
		model.addAttribute("produits", metier.produitParCategorie(idCat));
		return "clientProduit";
	}
	@RequestMapping(value="/goToProduit")
	public String gotoProduit(Model model){
		model.addAttribute("categories", metier.listCategorie());
		model.addAttribute("produit", new produit());
		model.addAttribute("produits", metier.listProduit());
		return "clientProduit";
		}
	@RequestMapping(value="photoProd",produces=MediaType.IMAGE_JPEG_VALUE)
	@ResponseBody
	public byte[] photoProd(Long idProd) throws IOException{
		produit p=metier.getProduit(idProd);
		String path="/home/moussaid/Workspace/comBoutique/src/test/resources/imagesFiles/";
		File f=new File(path+"PROD_"+idProd+"="+p.getPhoto());
		return IOUtils.toByteArray(new FileInputStream(f));
		
	}
	@RequestMapping(value="/toCat")
	public String toCat(Model model){
		model.addAttribute("categorie", new categorie());
		model.addAttribute("categories",metier.listCategorie());
		return "clientCategorie";
	}
	@RequestMapping(value="/search")
	public String search(String mc,Model model){
		model.addAttribute("categories", metier.listCategorie());
		model.addAttribute("produit", new produit());
		if(mc!=""){
			model.addAttribute("produits", metier.produitParMotCle(mc));
		}
		else{
			model.addAttribute("produits", metier.listProduit());
		}
		model.addAttribute("mc", mc);
		return "clientProduit";
	}
	@RequestMapping(value="/Log")
	public String toLogin(){
		return "login";
	}
}
