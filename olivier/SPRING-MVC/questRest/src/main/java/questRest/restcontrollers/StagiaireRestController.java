package questRest.restcontrollers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import quest.model.Stagiaire;
import quest.service.StagiaireService;
import questRest.dto.request.StagiaireRequest;
import questRest.dto.response.StagiaireResponse;

@RestController
@RequestMapping("/api/stagiaire")
public class StagiaireRestController {

	@Autowired
	private StagiaireService stagiaireSrv;

	@GetMapping("")
	public List<StagiaireResponse> getAll() {
//		List<Stagiaire> listStagiaireDeLaBase = stagiaireSrv.getAll();
//
//		List<StagiaireResponse> listARenvoyerAvecMesStagiaireResponse = new ArrayList<>();
//
//		for (Stagiaire stagiaireEntity : listStagiaireDeLaBase) {
//			StagiaireResponse stagiaireResponse = new StagiaireResponse(stagiaireEntity);
//			
//			listARenvoyerAvecMesStagiaireResponse.add(stagiaireResponse);
//		}
//		return listARenvoyerAvecMesStagiaireResponse;

		return stagiaireSrv.getAll().stream().map(entity -> new StagiaireResponse(entity)).collect(Collectors.toList());
	}

	@PostMapping("")
	public StagiaireResponse create(@RequestBody StagiaireRequest stagiaireRequest) {
		Stagiaire entity = new Stagiaire();
		BeanUtils.copyProperties(stagiaireRequest, entity);
		return new StagiaireResponse(stagiaireSrv.insert(entity));
	}
}
