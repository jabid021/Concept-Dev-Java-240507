package formation.conceptdev.formationSpringboot.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

@Service
public class HelloService implements CommandLineRunner {

	final static Logger LOGGER = LoggerFactory.getLogger(HelloService.class);

	@Override
	public void run(String... args) throws Exception {
		System.out.println("hello world");
		//trace=>debug=>info=>warn=>error
		//on definit un niveau , par defaut info
		LOGGER.trace("trace"); 
		LOGGER.debug("debug");
		LOGGER.info("info"); 
		LOGGER.warn("warn");
		LOGGER.error("error");

	}

}
