package cz.upce.fei.nnpia.cviceni;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class CviceniApplication {

	public static void main(String[] args) {
		SpringApplication.run(CviceniApplication.class, args);
	}
}
