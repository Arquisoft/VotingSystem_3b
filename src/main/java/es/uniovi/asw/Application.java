package es.uniovi.asw;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import es.uniovi.asw.physicalVotes.dBUpdate.InsertVotesP;
import es.uniovi.asw.physicalVotes.dBUpdate.WreportR;
import es.uniovi.asw.physicalVotes.physicalVotesConfig.Insert;
import es.uniovi.asw.physicalVotes.physicalVotesConfig.InsertPhysicalR;
import es.uniovi.asw.physicalVotes.physicalVotesConfig.RVotes;
import es.uniovi.asw.physicalVotes.reportWriter.WreportP;

@EnableAutoConfiguration
@SpringBootApplication
public class Application {
	
	@Autowired
	JdbcTemplate jdbcTemplate;

  public static void main(String[] args) {
    SpringApplication app = new SpringApplication(Application.class);
    app.setBannerMode(Banner.Mode.OFF);
    app.run(args);
    
    WreportR report1 = new WreportR(new WreportP());
	Insert r1 = new InsertPhysicalR(new RVotes(), "src/main/java/votacionesFisicas.xlsx");
	r1.addVoto(new InsertVotesP(report1) );
  }
  
  
}