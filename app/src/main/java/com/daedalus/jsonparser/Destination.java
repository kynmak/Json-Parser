package com.daedalus.jsonparser;

/**
 * Created by Daedalus on 1/15/19.
 */

public class Destination {
    //contains information for a trip/event
    private String name;
    private String city;
    private String state;
    private String endDate;
    private String imageUrl;
    private String startDate;
    private String url;

    public Destination(String startDate, String endDate, String name, String url, String city, String state, String imageURL){
        this.name = name;
        this.city = city;
        this.state = state;
        this.endDate = endDate;
        this.imageUrl = imageURL;
        this.startDate = startDate;
        this.url = url;
    }
    //getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
