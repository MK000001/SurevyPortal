package com.cg.apps.surveyapp.surveyor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.apps.surveyapp.surveyor.entities.Surveyor;

@Repository("surveyorRepo")
public interface ISurveyorRepository extends JpaRepository<Surveyor, Long> {

//	Surveyor add(Surveyor surveyor);
//
//	Surveyor findById(Long id) throws SurveyorNotFoundException;
//
//	Surveyor update(Surveyor surveyor) throws SurveyorNotFoundException;

	// List<Survey> findAllSurveysBySurveyorAfterDateTime(Surveyor surveyor,
	// LocalDateTime dateTime);
}
