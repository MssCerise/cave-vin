package fr.eni.cavevin.bo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "bouteilles")
public class Bouteille {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Size(min=5, max=50)
	private String nom;
	
	@NotNull(message = "La région est obligatoire")
	@ManyToOne
	private Region region;
	

	@NotNull(message = "La couleur est obligatoire")
	@ManyToOne
	private Couleur couleur;
	private boolean petillant;
	private String millesime;
	
	@Min(0)
	private int quantite;

	public Bouteille() {
		region = new Region();
		couleur = new Couleur();
	}

	public Bouteille(String nom, Region region, Couleur couleur, boolean petillant, String millesime, int quantite) {
		this.nom = nom;
		this.region = region;
		this.couleur = couleur;
		this.petillant = petillant;
		this.millesime = millesime;
		this.quantite = quantite;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

	public Couleur getCouleur() {
		return couleur;
	}

	public void setCouleur(Couleur couleur) {
		this.couleur = couleur;
	}

	public boolean isPetillant() {
		return petillant;
	}

	public void setPetillant(boolean petillant) {
		this.petillant = petillant;
	}

	public String getMillesime() {
		return millesime;
	}

	public void setMillesime(String millesime) {
		this.millesime = millesime;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Bouteille [id=");
		builder.append(id);
		builder.append(", nom=");
		builder.append(nom);
		builder.append(", region=");
		builder.append(region);
		builder.append(", couleur=");
		builder.append(couleur);
		builder.append(", petillant=");
		builder.append(petillant);
		builder.append(", millesime=");
		builder.append(millesime);
		builder.append(", quantite=");
		builder.append(quantite);
		builder.append("]");
		return builder.toString();
	}

}
