package com.cg.apps.surveyapp.survey.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.apps.surveyapp.exceptions.SurveyNotFoundException;
import com.cg.apps.surveyapp.exceptions.SurveyorNotFoundException;
import com.cg.apps.surveyapp.survey.entities.Survey;
@Repository("surveyRepo")
public interface ISurveyRepository extends JpaRepository<Survey, Long> {

//	Survey add(Survey survey);
//
//	Survey findById(Long surveyId) throws SurveyNotFoundException;
//
//	Survey update(Survey survey) throws SurveyorNotFoundException;
//
//	Survey removeById(Long surveyId) throws SurveyorNotFoundException;
//
//	int countFeedbacksInSurvey(Survey survey);

}
