package model;

public class Author {
    private int id;
    private String name;
    private int yearOfBirth;
    private int yearOfDeath;
    private int numberOfBook;
    private String country;
    private String wikiURL;
    private String avatarURL;

    public Author() {
    }

    public Author(String name, int yearOfBirth, int numberOfBook, String country) {
        this.name = name;
        this.yearOfBirth = yearOfBirth;
        this.numberOfBook = numberOfBook;
        this.country = country;
    }

    public Author(int id, String name, int yearOfBirth, int yearOfDeath, int numberOfBook, String country, String wikiURL, String avatarURL) {
        this.id = id;
        this.name = name;
        this.yearOfBirth = yearOfBirth;
        this.yearOfDeath = yearOfDeath;
        this.numberOfBook = numberOfBook;
        this.country = country;
        this.wikiURL = wikiURL;
        this.avatarURL = avatarURL;
    }

    public Author(String name, int yearOfBirth, int yearOfDeath, int numberOfBook, String country, String wikiURL, String avatarURL) {
        this.name = name;
        this.yearOfBirth = yearOfBirth;
        this.yearOfDeath = yearOfDeath;
        this.numberOfBook = numberOfBook;
        this.country = country;
        this.wikiURL = wikiURL;
        this.avatarURL = avatarURL;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public int getYearOfDeath() {
        return yearOfDeath;
    }

    public void setYearOfDeath(int yearOfDeath) {
        this.yearOfDeath = yearOfDeath;
    }

    public int getNumberOfBook() {
        return numberOfBook;
    }

    public void setNumberOfBook(int numberOfBook) {
        this.numberOfBook = numberOfBook;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getWikiURL() {
        return wikiURL;
    }

    public void setWikiURL(String wikiURL) {
        this.wikiURL = wikiURL;
    }

    public String getAvatarURL() {
        return avatarURL;
    }

    public void setAvatarURL(String avatarURL) {
        this.avatarURL = avatarURL;
    }
}
