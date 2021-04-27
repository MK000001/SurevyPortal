package com.cg.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.apps.surveyapp.dto.FeedbackDetails;
import com.cg.apps.surveyapp.dto.ParticipantDetails;
import com.cg.apps.surveyapp.feedback.entities.Feedback;
import com.cg.apps.surveyapp.participant.entities.Participant;

@Component
public class ParticipantUtil {

	@Autowired
	private FeedbackUtil feedUtil;

	public ParticipantDetails toDetails(Participant participant) {
		List<Feedback> feedbacks = participant.getFeedbacks();
		List<FeedbackDetails> feedDetails = new ArrayList<>();
		if (feedbacks != null) {
			for (Feedback feedback : feedbacks) {
				feedDetails.add(new FeedbackDetails(feedUtil.toDetails(feedback)));
			}
		}
		return new ParticipantDetails(participant.getId(), participant.getUsername(), participant.getFirstName(),
				participant.getLastName(), feedDetails);
	}

	public List<ParticipantDetails> toDetails(List<Participant> participants) {
		List<ParticipantDetails> participantsDetails = new ArrayList<>();
		for (Participant participant : participants) {
			participantsDetails.add(toDetails(participant));
		}
		return participantsDetails;
	}

}
