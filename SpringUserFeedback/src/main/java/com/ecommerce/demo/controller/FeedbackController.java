package com.ecommerce.demo.controller;

import com.ecommerce.demo.entity.Feedback;
import com.ecommerce.demo.repository.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;

@RestController
public class FeedbackController {

    private final FeedbackRepository feedbackRepository;

    @Autowired
    public FeedbackController(FeedbackRepository feedbackRepository) {
        this.feedbackRepository = feedbackRepository;
    }

    @PostMapping(path = "/feedback", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ResponseEntity<String> submitFeedback(@ModelAttribute Feedback feedback) {
        if (feedback.getName() == null || feedback.getName().isEmpty()) {
            return ResponseEntity.badRequest().body("Name is required");
        }

        feedbackRepository.save(feedback);

        return ResponseEntity.ok("Feedback submitted successfully");
    }
    
}
