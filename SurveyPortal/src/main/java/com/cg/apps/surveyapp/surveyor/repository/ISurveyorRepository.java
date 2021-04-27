package com.cg.apps.surveyapp.surveyor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.apps.surveyapp.surveyor.entities.Surveyor;

@Repository("surveyorRepo")
public interface ISurveyorRepository extends JpaRepository<Surveyor, Long> {

}
