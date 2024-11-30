package com.whiskypedia.service;

import com.whiskypedia.dto.ReviewDTO;
import com.whiskypedia.dto.WhiskyDTO;
import com.whiskypedia.entity.ReviewEntity;
import com.whiskypedia.entity.WhiskyEntity;
import com.whiskypedia.repository.WhiskyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class WhiskyService {

    @Autowired
    private WhiskyRepository whiskyRepository;

    public List<WhiskyDTO> getAllWhiskies() {
        return whiskyRepository.findAll().stream()
                .map(this::convertToWhiskyDTO)
                .collect(Collectors.toList());
    }

    public WhiskyDTO getWhiskyById(String id) {
        Optional<WhiskyEntity> whiskyEntity = whiskyRepository.findById(id);
        return whiskyEntity.map(this::convertToWhiskyDTO).orElse(null);
    }

    private WhiskyDTO convertToWhiskyDTO(WhiskyEntity entity) {
        WhiskyDTO dto = new WhiskyDTO();
        dto.setWhiskyID(entity.getWhiskyID());
        dto.setWhiskyName(entity.getWhiskyName());
        dto.setWhiskyOrigin(entity.getWhiskyOrigin());
        dto.setWhiskyDistiller(entity.getWhiskyDistiller());
        dto.setWhiskyType(entity.getWhiskyType());
        dto.setWhiskyFlavour(entity.getWhiskyFlavour());
        // dto.setReviews(entity.getReviews().stream().map(this::convertToReviewDTO).collect(Collectors.toList()));
        return dto;
    }

    private ReviewDTO convertToReviewDTO(ReviewEntity entity) {
        ReviewDTO dto = new ReviewDTO();
        dto.setReviewID(entity.getReviewID());
        dto.setUserEmail(entity.getUser().getUserEmail());
        dto.setReview(entity.getReview());
        dto.setWhiskyID(entity.getWhisky().getWhiskyID());
        return dto;
    }
}