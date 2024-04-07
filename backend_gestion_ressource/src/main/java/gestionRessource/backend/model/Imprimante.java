package gestionRessource.backend.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class Imprimante extends Ressource {

	@Column(name = "resolution")
	private int resolution;

	@Column(name = "vitesseImpression")
	private int vitesseImpression;

	public Imprimante() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Imprimante(Long id, String codeInventaire, EtatDemande etatDemande, User user, AppelDoffre appelDoffre,
			List<Detail> details) {
		super(id, codeInventaire, etatDemande, user, appelDoffre, details);
		// TODO Auto-generated constructor stub
	}

	public Imprimante(int resolution, int vitesseImpression) {
		super();
		this.resolution = resolution;
		this.vitesseImpression = vitesseImpression;
	}

	public int getResolution() {
		return resolution;
	}

	public void setResolution(int resolution) {
		this.resolution = resolution;
	}

	public int getVitesseImpression() {
		return vitesseImpression;
	}

	public void setVitesseImpression(int vitesseImpression) {
		this.vitesseImpression = vitesseImpression;
	}

}
