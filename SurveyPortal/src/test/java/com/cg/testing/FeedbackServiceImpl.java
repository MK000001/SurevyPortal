package com.cg.testing;

import static org.junit.Assert.assertEquals;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.cg.apps.surveyapp.feedback.service.IFeedbackServiceImpl;
import com.cg.apps.surveyapp.surveyor.entities.Surveyor;
import com.cg.apps.surveyapp.surveyor.service.ISurveyorService;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@Import(IFeedbackServiceImpl.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class FeedbackServiceImpl {


}
