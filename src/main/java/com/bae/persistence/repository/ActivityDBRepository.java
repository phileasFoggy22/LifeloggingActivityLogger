package com.bae.persistence.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.Arrays;
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

		String[] hikingString = { "activityType\":\"Hiking\"" };
		String[] kayakingString = { "activityType\":\"Kayaking\"" };

		if (Arrays.stream(hikingString).parallel().anyMatch(activityLog::contains)) {
			Hiking anActivity = util.getObjectForJSON(activityLog, Hiking.class);
			userDetails.getActivityList().add(anActivity);
			return "{\"message\": \"Hiking activity successfully added\"}";
		} else if (Arrays.stream(kayakingString).parallel().anyMatch(activityLog::contains)) {
			Kayaking anActivity = util.getObjectForJSON(activityLog, Kayaking.class);
			userDetails.getActivityList().add(anActivity);
			return "{\"message\": \"Kayaking activity successfully added\"}";
		} else {
			return "{\"message\": \"Activity type not found\"}";
		}
	}

	// read
	@Override
	public String getAnActivity(String userEmail, int id) {
		userDetails = manager.find(User.class, userEmail);
		for (int i = 0; i < userDetails.getActivityList().size(); i++) {
			if (userDetails.getActivityList().get(i).getId() == id) {
				return util.getJSONForObject(userDetails.getActivityList().get(i));
			}
		}
		return "{\"message\": \"Activity not found\"}";

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
			// Was by start date before null values caused errors
			List<Hiking> hikingList = userDetails.getActivityList().stream().filter(hike -> hike instanceof Hiking)
					.map(a -> (Hiking) a).collect(Collectors.toList());
			Comparator<Hiking> compareByRecentID = (Hiking o1, Hiking o2) -> o1.getId().compareTo(o2.getId());
			Collections.sort(hikingList, compareByRecentID.reversed());
			return util.getJSONForObject(hikingList);

		} else if (category.equalsIgnoreCase("kayaking")) {
			// Was by start date before null values caused errors
			List<Activity> kayakingList = userDetails.getActivityList().stream()
					.filter(kayak -> kayak instanceof Kayaking).collect(Collectors.toList());
			Comparator<Activity> compareByID = (Activity o1, Activity o2) -> ((Kayaking) o1).getId()
					.compareTo(((Kayaking) o2).getId());
			Collections.sort(kayakingList, compareByID.reversed());
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
		for (int i = 0; i < userDetails.getActivityList().size(); i++) {
			if (userDetails.getActivityList().get(i).getId() == id) {
				String res = userDetails.getActivityList().get(i).getClass().toString();
				if (userDetails.getActivityList().get(i) instanceof Hiking) {
					Hiking updatedActivity = util.getObjectForJSON(activityLog, Hiking.class);

					userDetails.getActivityList().get(i).setDescription(updatedActivity.getDescription());
					userDetails.getActivityList().get(i).setLifelogDirectory(updatedActivity.getLifelogDirectory());
					if (updatedActivity.getEndDate() != null) {
						((Hiking) userDetails.getActivityList().get(i)).setEndDate(updatedActivity.getEndDate());
					}
					((Hiking) userDetails.getActivityList().get(i)).setLengthMiles(updatedActivity.getLengthMiles());

					((Hiking) userDetails.getActivityList().get(i)).setLocation(updatedActivity.getLocation());
					((Hiking) userDetails.getActivityList().get(i))
							.setOfficialRouteName(updatedActivity.getOfficialRouteName());

					if (updatedActivity.getStartDate() != null) {
						((Hiking) userDetails.getActivityList().get(i)).setStartDate(updatedActivity.getStartDate());
					}
					return "{\"ActivityUpdated\": \"Hiking\"}";

				} else if (userDetails.getActivityList().get(i) instanceof Kayaking) {
					Kayaking updatedActivity = util.getObjectForJSON(activityLog, Kayaking.class);
					userDetails.getActivityList().get(i).setDescription(updatedActivity.getDescription());
					userDetails.getActivityList().get(i).setLifelogDirectory(updatedActivity.getLifelogDirectory());
					((Kayaking) userDetails.getActivityList().get(i))
							.setDateCompleted(((Kayaking) updatedActivity).getDateCompleted());
					((Kayaking) userDetails.getActivityList().get(i))
							.setDurationMins(((Kayaking) updatedActivity).getDurationMins());
					((Kayaking) userDetails.getActivityList().get(i))
							.setJourneyEnd(((Kayaking) updatedActivity).getJourneyEnd());
					((Kayaking) userDetails.getActivityList().get(i))
							.setJourneyStart(((Kayaking) updatedActivity).getJourneyStart());
					((Kayaking) userDetails.getActivityList().get(i))
							.setLengthKilometers(((Kayaking) updatedActivity).getLengthKilometers());
					return "{\"ActivityUpdated\": \"Kayaking\"}";
				}
				return "{\"ActivityUpdated\":\"" + res + "\"}";
			}
		}
		return "{\"message\": \"Activity successfully updated\"}";
	}

	// delete
	@Override
	@Transactional(REQUIRED)
	public String deleteActivity(String userEmail, int id) {
		userDetails = manager.find(User.class, userEmail);
		for (int i = 0; i < userDetails.getActivityList().size(); i++) {
			if (userDetails.getActivityList().get(i).getId() == id) {
				if (userDetails.getActivityList().get(i) instanceof Hiking) {
					userDetails.getActivityList().remove(i);
					return "{\"ActivityRemoved\": \"Hiking\"}";
				}
				if (userDetails.getActivityList().get(i) instanceof Kayaking) {
					userDetails.getActivityList().remove(i);
					return "{\"ActivityRemoved\": \"Kayaking\"}";
				}
			}
		}
		return "{\"message\": \"activity successfully removed\"}";
	}

	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

	public void setUtil(JSONUtil util) {
		this.util = util;
	}
}
