package com.gestion.marchant.controllers;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import com.gestion.marchant.entities.categorie;
import com.gestion.marchant.entities.produit;
import com.gestion.marchant.metier.IAdmin;



@Controller
@RequestMapping(value="/admin")
@SessionAttributes("soufianeEdit")
public class adminController implements HandlerExceptionResolver{
	@Autowired
	private HttpServletRequest req;
	@Autowired
	private IAdmin metier;
	@RequestMapping(value="/indexProd")
	public String indexProd(Model model){
		model.addAttribute("produit", new produit());
		model.addAttribute("produits",metier.listProduit());
		model.addAttribute("categories",metier.listCategorie());
		return "produit";
	}

	@RequestMapping(value="/indexCat")
	public String indexCat(Model model){
		model.addAttribute("categorie", new categorie());
		model.addAttribute("categories",metier.listCategorie());
		return "categorie";
	}
	@RequestMapping(value="/saveProd")
	public String saveProd(@Valid produit p,BindingResult binding,Model model
			,@RequestParam("file") MultipartFile file) throws  IOException{
		if(binding.hasErrors()){
			model.addAttribute("categories", metier.listCategorie());
			model.addAttribute("produits", metier.listProduit());
			return "produit";
		}
		String path="/home/moussaid/Workspace/comBoutique/src/test/resources/imagesFiles/";
		
			p.setPhoto(file.getOriginalFilename());
			Long idProd=null;
			if(p.getIdProduit()!=null){
				if(model.asMap().get("soufianeEdit")!=null){
					if(file.isEmpty()){
					produit p1=(produit) model.asMap().get("soufianeEdit");
					p.setPhoto(p1.getPhoto());
					}
				}
				metier.modifierProduit(p);
				idProd=p.getIdProduit();
			}else{
				idProd=metier.ajouterProduit(p, p.getCatego().getIdCategorie());
			}
			if(!file.isEmpty()){
				File f1=new File(path+"PROD_"+idProd+"="+file.getOriginalFilename());
				file.transferTo(f1);
			}
			
		model.addAttribute("categories", metier.listCategorie());
		model.addAttribute("produit", new produit());
		model.addAttribute("produits",metier.listProduit());
		return "produit";
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
	@RequestMapping(value="/suppProd")
	public String suppProd(Long idProd,Model model){
		metier.supprimerProduit(idProd);
		model.addAttribute("categories", metier.listCategorie());
		model.addAttribute("produit", new produit());
		model.addAttribute("produits", metier.listProduit());
		return "produit";
	}
	@RequestMapping(value="/editProd")
	public String editProd(Long idProd,Model model){
		produit p=metier.getProduit(idProd);
		model.addAttribute("soufianeEdit", p);
		model.addAttribute("categories", metier.listCategorie());
		model.addAttribute("produit", p);
		model.addAttribute("produits", metier.listProduit());
		return "produit";
	}
	@RequestMapping(value="/logout")
	public String logout(HttpServletRequest req){
		produit p = (produit) req.getSession().getAttribute("soufianeEdit");
		System.out.println(p.getDescription()+" "+p.getIdProduit());
		return "login";
	}
	@RequestMapping(value="/toCat")
	public String toCat(Model model){
		model.addAttribute("categorie", new categorie());
		model.addAttribute("categories",metier.listCategorie());
		return "categorie";
	}//here the controller goes to adminCat so in order to return or manipulate categorie it needs all categorie controller's methods

	@RequestMapping(value="/goToProduit")
	public String gotoProduit(Model model){
		model.addAttribute("categories", metier.listCategorie());
		model.addAttribute("produit", new produit());
		model.addAttribute("produits", metier.listProduit());
		return "produit";
}	

	@RequestMapping(value="/saveCat")
	public String saveCat(@Valid categorie c,BindingResult binding,Model model) throws IOException{
		 if(binding.hasErrors()){
			model.addAttribute("categories", metier.listCategorie());
			return "categorie";
		}
	
		
		
			if(c.getIdCategorie()!=null){
				
				metier.modifierCategorie(c);;
				
			}else{
				metier.ajouterCategorie(c);
			}
			
		
		model.addAttribute("categorie", new categorie());
		model.addAttribute("categories",metier.listCategorie());
		
		
		return "categorie";
	}

	@RequestMapping(value="/suppCat")
	public String suppCats(Long idCat,Model model){
		metier.supprimerCategorie(idCat);
		model.addAttribute("categorie", new categorie());
		model.addAttribute("categories", metier.listCategorie());
		return "categorie";
	}
	@RequestMapping(value="/editCat")
	public String editCats(Long idCat,Model model){
		categorie c=metier.getCategorie(idCat);
//		model.addAttribute("soufianeEdit",c);
		model.addAttribute("categorie", c);
		model.addAttribute("categories", metier.listCategorie());
		return "categorie";
	}
	@RequestMapping(value="/prodDeCat")
	public String goIn(Long idCat,Model model){
		model.addAttribute("categories", metier.listCategorie());
		model.addAttribute("produit", new produit());
		model.addAttribute("produits", metier.produitParCategorie(idCat));
		return "produit";
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
		return "produit";
	}
	@RequestMapping(value="/users")
	public String listUser(Model model){
		model.addAttribute("users", metier.listUtilisateur());
		return "userList";
	}
	@RequestMapping(value="/suppUser")
	public String suppuser(Long idU,Model model){
		metier.supprimerUtilisateur(idU);
		model.addAttribute("users", metier.listUtilisateur());
		return "userList";
	}
	@RequestMapping(value="/searchUser")
	public String searchUser(String mc,Model model){
		if(mc==""){
			model.addAttribute("users",metier.listUtilisateur());
		}else{
			model.addAttribute("users",metier.utilisateurParMotCle(mc));
		}
		model.addAttribute("mc", mc);
		return "userList";
	}
	@Override
	public ModelAndView resolveException(HttpServletRequest req,
			HttpServletResponse resp, Object obj, Exception exception) {
		// TODO Auto-generated method stub
		ModelAndView m=new ModelAndView();
		m.addObject("exception",exception.getMessage());
		m.setViewName("produit");
		return m;
	}

}
