package com.bae.persistence.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import com.bae.persistence.domain.Activity;
import com.bae.persistence.domain.Hiking;
import com.bae.persistence.domain.Kayaking;
import com.bae.persistence.domain.User;
import com.bae.util.JSONUtil;

@Transactional(SUPPORTS)
@Default
public class ActivityDBRepository implements ActivityRepository {
	@PersistenceContext(unitName = "primary")
	private EntityManager manager;
	private User userDetails;

	@Inject
	private JSONUtil util;

	// create

	@Override
	@Transactional(REQUIRED)
	public String createActivity(String userEmail, String activityLog) {
		userDetails = manager.find(User.class, userEmail);
		Activity anActivity = util.getObjectForJSON(activityLog, Activity.class);
		userDetails.getActivityList().add(anActivity);
		return "{\"message\": \"activity successfully added\"}";
	}

	// read
	@Override
	public String getAnActivity(String userEmail, int id) {
		userDetails = manager.find(User.class, userEmail);
		return util.getJSONForObject(userDetails.getActivityList().get(id));
	}

	@Override
	public String getAllActivities(String userEmail) {
		userDetails = manager.find(User.class, userEmail);

		return util.getJSONForObject(userDetails.getActivityList());
	}

	@Override
	public String getAllActivitiesByCategory(String userEmail, String category) {
		userDetails = manager.find(User.class, userEmail);

		if (category.equalsIgnoreCase("hiking")) {
			List<Activity> hikingList = userDetails.getActivityList().stream().filter(hike -> hike instanceof Hiking)
					.collect(Collectors.toList());
			Comparator<Activity> compareByStartDate = (Activity o1, Activity o2) -> ((Hiking) o1).getStartDate()
					.compareTo(((Hiking) o2).getStartDate());
			Collections.sort(hikingList, compareByStartDate.reversed());
			return util.getJSONForObject(hikingList);
		} else if (category.equalsIgnoreCase("kayaking")) {
			List<Activity> kayakingList = userDetails.getActivityList().stream()
					.filter(kayak -> kayak instanceof Kayaking).collect(Collectors.toList());
			Comparator<Activity> compareByDate = (Activity o1, Activity o2) -> ((Kayaking) o1).getDateCompleted()
					.compareTo(((Kayaking) o2).getDateCompleted());
			Collections.sort(kayakingList, compareByDate.reversed());
			return util.getJSONForObject(kayakingList);
		} else {
			return "{\"message\": \"You have not completed any activities\"}";
		}

	}

	// update
	@Override
	@Transactional(REQUIRED)

	public String updateActivity(String userEmail, String activityLog, int id) {
		userDetails = manager.find(User.class, userEmail);

		if (userDetails.getActivityList().get(id) instanceof Hiking) {
			Hiking updatedActivity = util.getObjectForJSON(activityLog, Hiking.class);
			userDetails.getActivityList().get(id).setDescription(updatedActivity.getDescription());
			userDetails.getActivityList().get(id).setLifelogDirectory(updatedActivity.getLifelogDirectory());

			((Hiking) userDetails.getActivityList().get(id)).setEndDate(((Hiking) updatedActivity).getEndDate());
			((Hiking) userDetails.getActivityList().get(id))
					.setLengthMiles(((Hiking) updatedActivity).getLengthMiles());
			((Hiking) userDetails.getActivityList().get(id)).setLocation(((Hiking) updatedActivity).getLocation());
			((Hiking) userDetails.getActivityList().get(id))
					.setOfficialRouteName(((Hiking) updatedActivity).getOfficialRouteName());
			((Hiking) userDetails.getActivityList().get(id)).setStartDate(((Hiking) updatedActivity).getStartDate());
		} else if (userDetails.getActivityList().get(id) instanceof Kayaking) {
			Kayaking updatedActivity = util.getObjectForJSON(activityLog, Kayaking.class);
			userDetails.getActivityList().get(id).setDescription(updatedActivity.getDescription());
			userDetails.getActivityList().get(id).setLifelogDirectory(updatedActivity.getLifelogDirectory());
			((Kayaking) userDetails.getActivityList().get(id))
					.setDateCompleted(((Kayaking) updatedActivity).getDateCompleted());
			((Kayaking) userDetails.getActivityList().get(id))
					.setDurationMins(((Kayaking) updatedActivity).getDurationMins());
			((Kayaking) userDetails.getActivityList().get(id))
					.setJourneyEnd(((Kayaking) updatedActivity).getJourneyEnd());
			((Kayaking) userDetails.getActivityList().get(id))
					.setJourneyStart(((Kayaking) updatedActivity).getJourneyStart());
		}
		// return "{\"message\": \"Activity successfully updated\"}";
		return activityLog;

	}

	// delete
	@Override
	@Transactional(REQUIRED)

	public String deleteActivity(String userEmail, int id) {
		userDetails = manager.find(User.class, userEmail);
		userDetails.getActivityList().remove(id);
		return "{\"message\": \"activity successfully removed\"}";

	}
}
