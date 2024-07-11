package formation.conceptdev.formationSpringboot;

import static org.junit.jupiter.api.Assertions.*;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;

import formation.conceptdev.formationSpringboot.entities.Matiere;
import formation.conceptdev.formationSpringboot.services.MatiereService;
import jakarta.transaction.Transactional;

@SpringBootTest
@ActiveProfiles("dev")
@Transactional
@Rollback
class DataSourceTest {

	@Autowired
	DataSource dataSource;

	@Autowired
	MatiereService matiereSrv;

	@Test
	void test() {
		assertNotNull(dataSource);
	}

	@Test
	void matiereTest() {
		Matiere matiere = new Matiere("test", 123);
		matiere = matiereSrv.insert(matiere);
		assertNotNull(matiere.getId());
		assertNotNull(matiereSrv.getById(matiere.getId()));
	}

}
