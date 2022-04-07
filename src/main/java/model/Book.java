package model;

import java.util.ArrayList;
import java.util.List;

public class Book {
    private int id ;
    private long ISBNCode;
    private String name;
    private ArrayList<Category> categoryList;
    private ArrayList<Author> authorList;
    private int publishYear;
    private int reprint;
    private  String summary;
    private String publisher;
    private String publishLicense;
    private String avatarURL;
    private int viewCount;
    private boolean isRecommended;
    private boolean isBestSeller;
    private double price;
    private int soldQuantity;
    private int inStock;

    public Book() {
    }

    public Book(long ISBNCode, String name, ArrayList<Category> categoryList, ArrayList<Author> authorList, int publishYear, int reprint, String summary, String publisher, String publishLicense, String avatarURL, int viewCount, boolean isRecommended, boolean isBestSeller, double price, int soldQuantity, int inStock) {
        this.ISBNCode = ISBNCode;
        this.name = name;
        this.categoryList = categoryList;
        this.authorList = authorList;
        this.publishYear = publishYear;
        this.reprint = reprint;
        this.summary = summary;
        this.publisher = publisher;
        this.publishLicense = publishLicense;
        this.avatarURL = avatarURL;
        this.viewCount = viewCount;
        this.isRecommended = isRecommended;
        this.isBestSeller = isBestSeller;
        this.price = price;
        this.soldQuantity = soldQuantity;
        this.inStock = inStock;
    }

    public Book(int id, long ISBNCode, String name, ArrayList<Category> categoryList, ArrayList<Author> authorList, int publishYear, int reprint, String summary, String publisher, String publishLicense, String avatarURL, int viewCount, boolean isRecommended, boolean isBestSeller, double price, int soldQuantity, int inStock) {
        this.id = id;
        this.ISBNCode = ISBNCode;
        this.name = name;
        this.categoryList = categoryList;
        this.authorList = authorList;
        this.publishYear = publishYear;
        this.reprint = reprint;
        this.summary = summary;
        this.publisher = publisher;
        this.publishLicense = publishLicense;
        this.avatarURL = avatarURL;
        this.viewCount = viewCount;
        this.isRecommended = isRecommended;
        this.isBestSeller = isBestSeller;
        this.price = price;
        this.soldQuantity = soldQuantity;
        this.inStock = inStock;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getISBNCode() {
        return ISBNCode;
    }

    public void setISBNCode(long ISBNCode) {
        this.ISBNCode = ISBNCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(ArrayList<Category> categoryList) {
        this.categoryList = categoryList;
    }

    public ArrayList<Author> getAuthorList() {
        return authorList;
    }

    public void setAuthorList(ArrayList<Author> authorList) {
        this.authorList = authorList;
    }

    public int getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(int publishYear) {
        this.publishYear = publishYear;
    }

    public int getReprint() {
        return reprint;
    }

    public void setReprint(int reprint) {
        this.reprint = reprint;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getPublishLicense() {
        return publishLicense;
    }

    public void setPublishLicense(String publishLicense) {
        this.publishLicense = publishLicense;
    }

    public String getAvatarURL() {
        return avatarURL;
    }

    public void setAvatarURL(String avatarURL) {
        this.avatarURL = avatarURL;
    }

    public int getViewCount() {
        return viewCount;
    }

    public void setViewCount(int viewCount) {
        this.viewCount = viewCount;
    }

    public boolean isRecommended() {
        return isRecommended;
    }

    public void setRecommended(boolean recommended) {
        isRecommended = recommended;
    }

    public boolean isBestSeller() {
        return isBestSeller;
    }

    public void setBestSeller(boolean bestSeller) {
        isBestSeller = bestSeller;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getSoldQuantity() {
        return soldQuantity;
    }

    public void setSoldQuantity(int soldQuantity) {
        this.soldQuantity = soldQuantity;
    }

    public int getInStock() {
        return inStock;
    }

    public void setInStock(int inStock) {
        this.inStock = inStock;
    }
}
