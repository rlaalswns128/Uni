package com.whiskypedia.service;

import com.whiskypedia.dto.ReviewDTO;
import com.whiskypedia.entity.ReviewEntity;
import com.whiskypedia.entity.UserEntity;
import com.whiskypedia.entity.WhiskyEntity;
import com.whiskypedia.repository.ReviewRepository;
import com.whiskypedia.repository.UserRepository;
import com.whiskypedia.repository.WhiskyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private WhiskyRepository whiskyRepository;

    public List<ReviewDTO> getAllReviews() {
        return reviewRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public ReviewDTO saveReview(ReviewDTO reviewDTO) {
        ReviewEntity reviewEntity = convertToEntity(reviewDTO);
        ReviewEntity savedReview = reviewRepository.save(reviewEntity);
        return convertToDTO(savedReview);
    }

    private ReviewDTO convertToDTO(ReviewEntity reviewEntity) {
        ReviewDTO reviewDTO = new ReviewDTO();
        reviewDTO.setReviewID(reviewEntity.getReviewID());
        reviewDTO.setUserEmail(reviewEntity.getUser().getUserEmail());
        reviewDTO.setReview(reviewEntity.getReview());
        reviewDTO.setWhiskyID(reviewEntity.getWhisky().getWhiskyID());
        return reviewDTO;
    }

    private ReviewEntity convertToEntity(ReviewDTO reviewDTO) {
        UserEntity user = userRepository.findById(reviewDTO.getUserEmail()).orElseThrow(() -> new RuntimeException("User not found"));
        WhiskyEntity whisky = whiskyRepository.findById(reviewDTO.getWhiskyID()).orElseThrow(() -> new RuntimeException("Whisky not found"));

        return new ReviewEntity(
                reviewDTO.getReviewID(),
                user,
                reviewDTO.getReview(),
                whisky
        );
    }
}