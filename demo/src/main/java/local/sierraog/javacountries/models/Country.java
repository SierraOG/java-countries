package local.sierraog.javacountries.models;

import java.util.concurrent.atomic.AtomicLong;

public class Country {

    private static final AtomicLong counter = new AtomicLong();
    private long id;
    private String name;
    private int population;
    private int landmass;
    private int medianage;

    public Country(String name, int population, int landmass, int age) {
        this.id = counter.incrementAndGet();
        this.name = name;
        this.population = population;
        this.landmass = landmass;
        this.medianage = age;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public int getLandmass() {
        return landmass;
    }

    public void setLandmass(int landmass) {
        this.landmass = landmass;
    }

    public int getMedianage() {
        return medianage;
    }

    public void setMedianage(int medianage) {
        this.medianage = medianage;
    }

    @Override
    public String toString() {
        return "Country{" + "id=" + id + ", name=" + name + ", population=" + population + ", landMass=" + landmass + ", medianAge=" + medianage + '}';
    }
}
