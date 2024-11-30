package com.whiskypedia.dto;

import lombok.Data;
import java.util.List;

@Data
public class WhiskyDTO {
    private String whiskyID;
    private String whiskyName;
    private String whiskyOrigin;
    private String whiskyDistiller;
    private String whiskyType;
    private String whiskyFlavour;
    private String whiskyDescription;
    private String whiskyImage;
    private List<ReviewDTO> reviews;

    // No-args constructor
    public WhiskyDTO() {}

    // All-args constructor
    public WhiskyDTO(String whiskyID, String whiskyName, String whiskyOrigin, String whiskyDistiller, String whiskyType, String whiskyFlavour, String whiskyDescription, String whiskyImage, List<ReviewDTO> reviews) {
        this.whiskyID = whiskyID;
        this.whiskyName = whiskyName;
        this.whiskyOrigin = whiskyOrigin;
        this.whiskyDistiller = whiskyDistiller;
        this.whiskyType = whiskyType;
        this.whiskyFlavour = whiskyFlavour;
        this.whiskyDescription = whiskyDescription;
        this.whiskyImage = whiskyImage;
        this.reviews = reviews;
    }

    // Getters and Setters
    public String getWhiskyID() {
        return whiskyID;
    }

    public void setWhiskyID(String whiskyID) {
        this.whiskyID = whiskyID;
    }

    public String getWhiskyName() {
        return whiskyName;
    }

    public void setWhiskyName(String whiskyName) {
        this.whiskyName = whiskyName;
    }

    public String getWhiskyOrigin() {
        return whiskyOrigin;
    }

    public void setWhiskyOrigin(String whiskyOrigin) {
        this.whiskyOrigin = whiskyOrigin;
    }

    public String getWhiskyDistiller() {
        return whiskyDistiller;
    }

    public void setWhiskyDistiller(String whiskyDistiller) {
        this.whiskyDistiller = whiskyDistiller;
    }

    public String getWhiskyType() {
        return whiskyType;
    }

    public void setWhiskyType(String whiskyType) {
        this.whiskyType = whiskyType;
    }

    public String getWhiskyFlavour() {
        return whiskyFlavour;
    }

    public void setWhiskyFlavour(String whiskyFlavour) {
        this.whiskyFlavour = whiskyFlavour;
    }

    // public String getWhiskyDescription() {
    //     return whiskyDescription;
    // }

    // public void setWhiskyDescription(String whiskyDescription) {
    //     this.whiskyDescription = whiskyDescription;
    // }

    // public String getWhiskyImage() {
    //     return whiskyImage;
    // }

    // public void setWhiskyImage(String whiskyImage) {
    //     this.whiskyImage = whiskyImage;
    // }

    // public List<ReviewDTO> getReviews() {
    //     return reviews;
    // }

    // public void setReviews(List<ReviewDTO> reviews) {
    //     this.reviews = reviews;
    // }
}