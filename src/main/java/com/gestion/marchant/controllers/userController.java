package com.gestion.marchant.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.validation.Valid;

import org.apache.commons.io.IOUtils;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.gestion.marchant.entities.categorie;
import com.gestion.marchant.entities.produit;
import com.gestion.marchant.entities.utilisateur;
import com.gestion.marchant.metier.IAdmin;


@Controller
@RequestMapping(value = "/userCP")
public class userController {
	@Autowired
	IAdmin metier;
	

	@RequestMapping(value = "/listCat")
	public String indexCat(Model model) {
		model.addAttribute("categories", metier.listCategorie());
		return "userCategorie";
	}

	@RequestMapping(value = "/listProd")
	public String indexProd(Model model) {
		model.addAttribute("produit", new produit());
		model.addAttribute("produits", metier.listProduit());
		model.addAttribute("categories", metier.listCategorie());
		return "userProduit";
	}

	@RequestMapping(value="/saveProd")
	public String saveProd(@Valid produit p,BindingResult binding,Model model,@RequestParam("file") MultipartFile file) throws  IOException{
		if(binding.hasErrors()){
			model.addAttribute("categories", metier.listCategorie());
			model.addAttribute("produits", metier.listProduit());
			return "userProduit";
		}
		String path="/home/moussaid/Workspace/comBoutique/src/test/resources/imagesFiles/";
		
			p.setPhoto(file.getOriginalFilename());
			Long idProd=null;
			
			
				idProd=metier.ajouterProduit(p, p.getCatego().getIdCategorie());
			
				File f1=new File(path+"PROD_"+idProd+"="+file.getOriginalFilename());
				file.transferTo(f1);
			
			
		model.addAttribute("categories", metier.listCategorie());
		model.addAttribute("produit", new produit());
		model.addAttribute("produits",metier.listProduit());
		return "userProduit";
	}
	@RequestMapping(value="photoProd",produces=MediaType.IMAGE_JPEG_VALUE)
	@ResponseBody
	public byte[] photoProd(Long idProd) throws IOException{
		produit p=metier.getProduit(idProd);
		String path="/home/moussaid/Workspace/comBoutique/src/test/resources/imagesFiles/";
		File f=new File(path+"PROD_"+idProd+"="+p.getPhoto());
		return IOUtils.toByteArray(new FileInputStream(f));
		
	}
	@RequestMapping(value="/seeProd")
	public String seeProd(Long idProd,Model model){
		model.addAttribute("p", metier.getProduit(idProd));
		return "produitInformation";
	}

	@RequestMapping(value = "/toCat")
	public String toCat(Model model) {
		model.addAttribute("categorie", new categorie());
		model.addAttribute("categories", metier.listCategorie());
		return "userCategorie";
	}
	

	@RequestMapping(value = "/goToProduit")
	public String gotoProduit(Model model) {
		model.addAttribute("categories", metier.listCategorie());
		model.addAttribute("produit", new produit());
		model.addAttribute("produits", metier.listProduit());
		return "userProduit";
	}

	@RequestMapping(value = "/prodDeCat")
	public String goIn(Long idCat, Model model) {
		model.addAttribute("categories", metier.listCategorie());
		model.addAttribute("produit", new produit());
		model.addAttribute("produits", metier.produitParCategorie(idCat));
		return "userProduit";
	}

	@RequestMapping(value = "/search")
	public String search( String mc, Model model) {
		model.addAttribute("categories", metier.listCategorie());
		model.addAttribute("produit", new produit());
		if (mc != "") {
			model.addAttribute("produits", metier.produitParMotCle(mc));
		} else {
			model.addAttribute("produits", metier.listProduit());
		}
		model.addAttribute("mc", mc);
		return "userProduit";
	}

}
