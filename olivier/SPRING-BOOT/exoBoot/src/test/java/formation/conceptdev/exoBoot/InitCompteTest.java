package formation.conceptdev.exoBoot;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

import formation.conceptdev.exoBoot.services.CompteService;
import jakarta.transaction.Transactional;

@SpringBootTest
class InitCompteTest {

	@Autowired
	CompteService compteSrv;

	@Test
	@Transactional
	@Commit
	@Disabled
	void test() {
		compteSrv.updatePassword("admin@admin", "admin");
		compteSrv.updatePassword("user@user", "user");
	}

}
