package com.ecommerce.demo.repository;

import com.ecommerce.demo.entity.Feedback;
import org.springframework.data.repository.CrudRepository;

public interface FeedbackRepository extends CrudRepository<Feedback, Long> {
}
