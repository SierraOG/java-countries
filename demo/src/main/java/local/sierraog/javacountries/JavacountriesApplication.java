package local.sierraog.javacountries;

import local.sierraog.javacountries.models.CountryList;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JavacountriesApplication {

	public static CountryList ourCountryList;
	public static void main(String[] args)
	{
		ourCountryList = new CountryList();
		SpringApplication.run(JavacountriesApplication.class, args);
	}

}
