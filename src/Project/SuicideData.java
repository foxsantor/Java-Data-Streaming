package Project;

public class SuicideData {

    private String country;
    private String year;
    private String gender;
    private String ageRange;
    private String suicideNumbers;
    private String population;


    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAgeRange() {
        return ageRange;
    }

    public void setAgeRange(String ageRange) {
        this.ageRange = ageRange;
    }

    public String getSuicideNumbers() {

        return suicideNumbers; }

    public void setSuicideNumbers(String suicideNumbers) {
        this.suicideNumbers = suicideNumbers;
    }

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }

    @Override
    public String toString() {
        return "SuicideData{" +
                "country='" + country + '\'' +
                ", year='" + year + '\'' +
                ", gender='" + gender + '\'' +
                ", AgeRange='" + ageRange + '\'' +
                ", suicideNumbers=" + suicideNumbers +
                ", population=" + population +
                '}';
    }

}
