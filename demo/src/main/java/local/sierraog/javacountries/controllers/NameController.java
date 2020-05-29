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
@RequestMapping("/names")
public class NameController {
    @GetMapping(value = "/all",
            produces = {"application/json"})
    public ResponseEntity<?> getCountriesByName()
    {
        JavacountriesApplication.ourCountryList.countryList.sort((c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName()));
        return new ResponseEntity<>(JavacountriesApplication.ourCountryList.countryList, HttpStatus.OK);
    }

    @GetMapping(value = "/start/{letter}",
            produces = {"application/json"})
    public ResponseEntity<?> getCountriesStart(@PathVariable char letter)
    {
        ArrayList<Country> returnCountries = ourCountryList.filterCountries(c -> c.getName().toUpperCase().startsWith(String.valueOf(letter).toUpperCase()));
        returnCountries.sort((c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName()));
        return new ResponseEntity<>(returnCountries, HttpStatus.OK);
    }

    @GetMapping(value = "/size/{num}",
            produces = {"application/json"})
    public ResponseEntity<?> getCountriesStart(@PathVariable int num)
    {
        ArrayList<Country> returnCountries = ourCountryList.filterCountries(c -> c.getName().length() >= num);
        returnCountries.sort((c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName()));
        return new ResponseEntity<>(returnCountries, HttpStatus.OK);
    }
}
