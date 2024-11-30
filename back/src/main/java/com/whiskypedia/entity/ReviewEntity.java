package com.whiskypedia.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Review")
public class ReviewEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id")
    private Long reviewID;

    @ManyToOne
    @JoinColumn(name = "user_email", nullable = false)
    private UserEntity user;

    @NotNull
    @Size(max = 500)
    @Column(name = "review", nullable = false)
    private String review;

    @ManyToOne
    @JoinColumn(name = "whisky_id", nullable = false)
    private WhiskyEntity whisky;

    public String getReviewer() {
        return user.getUserName(); // Ensure this returns the user's name
    }
}