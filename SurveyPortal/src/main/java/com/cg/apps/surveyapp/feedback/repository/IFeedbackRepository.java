package com.cg.apps.surveyapp.feedback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.apps.surveyapp.feedback.entities.Feedback;

@Repository("feedbackRepo")
public interface IFeedbackRepository extends JpaRepository<Feedback, Long> {

//   Feedback findById(Long feedbackId) throws FeedbackNotFoundException;
//
//   Feedback add(Feedback feedback);
//
//   Feedback update(Feedback feedback) throws FeedbackNotFoundException;;
//
//   void removeByFeedbackId(Long feedbackId) ;

}
