package org.sid;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.persistence.EntityManager;
import javax.persistence.ManyToOne;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.sid.dao.*;
import org.sid.entities.Administrateur;
import org.sid.entities.Commercial;
import org.sid.entities.DetailsApprovisionnement;
import org.sid.entities.Employe;
import org.sid.entities.Fournisseur;
import org.sid.entities.Produit;
import org.sid.entities.RessourceHumaine;
import org.sid.entities.CommandeApprovisionnement;
import org.sid.entities.CommandeVente;
@SpringBootApplication
public class ErpApplication implements CommandLineRunner {
	
    @Autowired
    private AdministrateurRepository administrateurRepository ;
    @Autowired
    private CommercialRepository commercialRepository ;
    @Autowired
    private RhRepository rhRepository ;
    @Autowired
    private EmployeRepository employeRepository;
    @Autowired
    private CommandeApprovisionnementRepository caRepository;
    @Autowired
    private FournisseurRepository fournisseurRepository;
    @Autowired
    private DetailsApprovisionnementRepository da;
    @Autowired
    private ProduitRepository p;
    @Autowired
    private CommandeApprovisionnementRepository ca;
    @Autowired
    private ProduitRepository produitRepository;
	public static void main(String[] args) {
		SpringApplication.run(ErpApplication.class, args);
	}
	@Override
	public void run(String... arg0) throws Exception {
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		// Décommenter le bloc au-dessous, exécuter l'application une seule fois, vérifier la bdd si les profils sont crées, recommenter le bloc
	
		Administrateur admin = new Administrateur("bentalha", "hicham", df.parse("19/01/1990"), "admin", "admin", "hicham@gmail", "photo.jpg",5557.33,"");
		administrateurRepository.save(admin);
		Commercial commercial = new Commercial("el alkaoui", "youssef", df.parse("20/11/1989"), "commercial", "commercial", "youssef@gmail", "photo.jpg",5557.33,"");
		commercialRepository.save(commercial);
		RessourceHumaine rh = new RessourceHumaine("taguine", "adil", df.parse("15/06/1990"), "rh", "rh", "adil@gmail", "photo.jpg",5557.33,"");
		rhRepository.save(rh);
	
	//Post post = new Post("First post");
		/* 	Post post = new Post();
	     post = postRepository.findOne((long) 76);
		post.addComment( new PostComment("aaaaa"));
		post.addComment(new PostComment("bbbbb"));
		post.addComment(new PostComment("bccccccc"));
		postRepository.save(post); ;*/
/*
	  Commercial com = new Commercial();
	     com = commercialRepository.findOne((long) 140);
	     Fournisseur fournisseur = new Fournisseur();
	     fournisseur = fournisseurRepository.findOne(1);
		CommandeApprovisionnement cap = new CommandeApprovisionnement(df.parse("19/01/2000"), "en cours", "non paye", com, fournisseur);
		caRepository.save(cap); 
		*/
	/*	CommandeApprovisionnement cmapp = new CommandeApprovisionnement();
		cmapp = caRepository.findOne((long) 142);
		Produit produit = new Produit();
		produit = produitRepository.findOne(1);
		DetailsApprovisionnement dt = new DetailsApprovisionnement(10, 22, produit, cmapp);
        da.save(dt);

		*/
	/*	da.findAll().forEach(c->{
	  	System.out.println("id " + c.getIdDetails() + " prix " + c.getPrixAchat() + " qnt " + c.getQuantite() + "idprd " + c.getProduit().getIdProduit() );
	    });	
	*/	
	// RessourceHumaine rh = new RessourceHumaine("zaydi", "karim", df.parse("12/03/1980"), "rh", "1234", "karim", "avatar", 123.34, "");
	 		
	}
}
