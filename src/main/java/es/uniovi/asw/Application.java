package es.uniovi.asw;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableAutoConfiguration
@SpringBootApplication
public class Application {

	

	public static void main(String[] args) {

		SpringApplication app = new SpringApplication(Application.class);
		app.setBannerMode(Banner.Mode.OFF);
		app.run(args);
		
		
//		WreportR report1 = new WreportR(new WreportP());
//		Insert r1 = new InsertPhysicalR(new RVotes(), "src/test/resources/votacionesFisicas.xlsx");
//		r1.addVoto(new InsertVotesP(report1));

	}

}