package local.sierraog.javacountries.controllers;

import local.sierraog.javacountries.JavacountriesApplication;
import local.sierraog.javacountries.models.Country;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

import static local.sierraog.javacountries.JavacountriesApplication.ourCountryList;

@RestController
@RequestMapping("/population")
public class PopulationController {
    @GetMapping(value = "/size/{population}",
            produces = {"application/json"})
    public ResponseEntity<?> getCountriesByPopulationSize(@PathVariable long population)
    {
        ArrayList<Country> returnCountries = ourCountryList.filterCountries(c -> c.getPopulation() >= population);
        return new ResponseEntity<>(returnCountries, HttpStatus.OK);
    }

    @GetMapping(value = "/min",
            produces = {"application/json"})
    public ResponseEntity<?> getCountryByMin()
    {
        ourCountryList.countryList.sort((c1, c2) -> c1.getPopulation() - c2.getPopulation());
        return new ResponseEntity<>(ourCountryList.countryList.get(0), HttpStatus.OK);
    }

    @GetMapping(value = "/max",
            produces = {"application/json"})
    public ResponseEntity<?> getCountryByMax()
    {
        ourCountryList.countryList.sort((c1, c2) -> c2.getPopulation() - c1.getPopulation());
        return new ResponseEntity<>(ourCountryList.countryList.get(0), HttpStatus.OK);
    }

    @GetMapping(value = "/median",
            produces = {"application/json"})
    public ResponseEntity<?> getMedianCountry()
    {
        int median = ourCountryList.countryList.size() / 2;
        median = median > 0 && median % 2 == 0 ? median - 1 : median;
        ourCountryList.countryList.sort((c1, c2) -> c2.getPopulation() - c1.getPopulation());
        return new ResponseEntity<>(ourCountryList.countryList.get(median), HttpStatus.OK);
    }
}
