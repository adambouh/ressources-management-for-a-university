package gestionRessource.backend.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import gestionRessource.backend.dto.RessourceDTO;
import gestionRessource.backend.model.EtatDemande;
import gestionRessource.backend.model.Imprimante;
import gestionRessource.backend.model.Ordinateur;
import gestionRessource.backend.model.Ressource;
import gestionRessource.backend.model.User;
import gestionRessource.backend.service.RessourceService;
import gestionRessource.backend.service.UserService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/ressource")
public class RessourceControler {

	@Autowired
	private RessourceService ressourceService;

	@Autowired
	private UserService userService;

	@GetMapping("/getAllRessources")
	public List<Ressource> getAllRessources() {
		return ressourceService.getAllResources();
	}

	@DeleteMapping("/deleteRessource")
	public ResponseEntity<String> deleteRessource(@RequestParam Long id) {
		ressourceService.deleteRessource(id);
		return new ResponseEntity<String>("La ressource est supprimée avec succées", HttpStatus.CREATED);
	}

	@PutMapping("/updateRessource")
	public Ressource updateRessource(@RequestParam Long id, @RequestBody RessourceDTO ressourceDto) {
		Ressource oldRessource = ressourceService.getRessourceById(id);
		if (ressourceDto.getTypeRessource().equals("Ordinateur") && oldRessource instanceof Ordinateur) {
			oldRessource.setCodeInventaire(ressourceDto.getCodeInventaire());
			oldRessource.setEtatDemande(ressourceDto.getEtatDemande());
			((Ordinateur) oldRessource).setCpu(ressourceDto.getCpu());
			((Ordinateur) oldRessource).setRam(ressourceDto.getRam());
			((Ordinateur) oldRessource).setDisqueDur(ressourceDto.getDisqueDur());
			((Ordinateur) oldRessource).setEcran(ressourceDto.getEcran());
			return ressourceService.updateRessource(oldRessource);

		} else if (ressourceDto.getTypeRessource().equals("Imprimante") && oldRessource instanceof Imprimante) {
			oldRessource.setCodeInventaire(ressourceDto.getCodeInventaire());
			oldRessource.setEtatDemande(ressourceDto.getEtatDemande());
			((Imprimante) oldRessource).setResolution(ressourceDto.getResolution());
			((Imprimante) oldRessource).setVitesseImpression(ressourceDto.getVitesseImpression());
			return ressourceService.updateRessource(oldRessource);
		}
		System.out.println("les données modifiées ne sont pas compatible");
		return null;

	}

	@GetMapping("/getRessourcesById")
	public ResponseEntity<Ressource> getRessourceById(@RequestParam Long id) {
		return new ResponseEntity<Ressource>(ressourceService.getRessourceById(id), HttpStatus.CREATED);
	}

	@PostMapping("/addRessource")
	public Ressource addRessource(@RequestBody RessourceDTO ressourceDto) {
		User user = userService.getUserById(ressourceDto.getUserId());
		if (ressourceDto.getTypeRessource().equals("Ordinateur")) {
			Ordinateur ordi = new Ordinateur();
			ordi.setCodeInventaire(ressourceDto.getCodeInventaire());
			ordi.setEtatDemande(EtatDemande.En_Cours_De_Traitement);
			ordi.setCpu(ressourceDto.getCpu());
			ordi.setDisqueDur(ressourceDto.getDisqueDur());
			ordi.setEcran(ressourceDto.getEcran());
			ordi.setRam(ressourceDto.getRam());
			ordi.setUser(user);
			return ressourceService.saveRessource(ordi);

		} else if (ressourceDto.getTypeRessource().equals("Imprimante")) {
			Imprimante impr = new Imprimante();
			impr.setCodeInventaire(ressourceDto.getCodeInventaire());
			impr.setEtatDemande(EtatDemande.En_Cours_De_Traitement);
			impr.setResolution(ressourceDto.getResolution());
			impr.setUser(user);
			return ressourceService.saveRessource(impr);
		}
		System.out.println("y'a eu un probleme lors de l'ajout de la ressource");
		return null;
	}

	@GetMapping("/getRessourcesByUserId")
	public List<Ressource> getRessourcesByUserId(@RequestParam Long id) {
		List<Ressource> ressources = ressourceService.getRessourceByUserId(id);
		return ressources;

	}
}