package com.whiskypedia.dto;

import lombok.Data;

@Data
public class ReviewDTO {
    private Long reviewID;
    private String userEmail;
    private String review;
    private String whiskyID;

    // No-args constructor
    public ReviewDTO() {}

    // All-args constructor
    public ReviewDTO(Long reviewID, String userEmail, String review, String whiskyID) {
        this.reviewID = reviewID;
        this.userEmail = userEmail;
        this.review = review;
        this.whiskyID = whiskyID;
    }

    // Getters and Setters
    public Long getReviewID() {
        return reviewID;
    }

    public void setReviewID(Long reviewID) {
        this.reviewID = reviewID;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public String getWhiskyID() {
        return whiskyID;
    }

    public void setWhiskyID(String whiskyID) {
        this.whiskyID = whiskyID;
    }
}