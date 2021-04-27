package com.cg.apps.surveyapp.survey.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.apps.surveyapp.survey.entities.Survey;

@Repository("surveyRepo")
public interface ISurveyRepository extends JpaRepository<Survey, Long> {

}
