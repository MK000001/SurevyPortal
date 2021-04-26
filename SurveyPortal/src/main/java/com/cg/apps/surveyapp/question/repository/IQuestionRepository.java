package com.cg.apps.surveyapp.question.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.apps.surveyapp.exceptions.QuestionNotFoundException;
import com.cg.apps.surveyapp.question.entities.Question;

@Repository("questionRepo")
public interface IQuestionRepository extends JpaRepository<Question, Long> {

//	Optional<Question> findById(Long questionId);
//
//	Question add(Question question);
//
//	void removeById(Long questionId);
//
//	Question update(Question question) throws QuestionNotFoundException;

}
