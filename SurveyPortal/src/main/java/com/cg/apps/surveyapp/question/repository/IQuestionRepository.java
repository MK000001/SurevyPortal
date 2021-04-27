package com.cg.apps.surveyapp.question.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.apps.surveyapp.question.entities.Question;

@Repository("questionRepo")
public interface IQuestionRepository extends JpaRepository<Question, Long> {

}
