package com.bae.persistence.domain.test;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.Test;

import com.bae.persistence.domain.Activity;
import com.bae.persistence.domain.Hiking;
import com.bae.persistence.domain.Kayaking;
import com.bae.persistence.domain.User;

public class Version1IterationTest {

	private User newUser;
	private User newUser2;
	private Activity newHike;
	private Activity newerHike;
	private Activity newestHike;
	private Activity newPaddle;
	private Activity returnPaddle;

	@Before
	public void start() {
		newUser = new User("L.Cravensworth@gmail.com", "Laszlo Cravensworth", "password");

		newHike = new Hiking("File/Area", "long hike, feet hurt", "field", LocalDate.of(2014, 2, 14),
				LocalDate.of(2014, 2, 15), 10, "Hilly Hike");
		newerHike = new Hiking("File/Area2", "longer hike, feet hurt more", "hill", LocalDate.of(2014, 2, 16),
				LocalDate.of(2014, 2, 18), 10, "Hillier Hike");
		newestHike = new Hiking("File/Area3", "longest hike, feet in agony", "mountain", LocalDate.of(2014, 2, 20),
				LocalDate.of(2014, 2, 27), 10, "Hilliest Hike");

		newPaddle = new Kayaking("File/Area4", "gentle paddle", "Potato Wharf", "Anchorage", LocalDate.of(2014, 3, 20),
				120, 50);
		returnPaddle = new Kayaking("File/Area5", "gentler paddle", "Anchorage", "Potato Wharf",
				LocalDate.of(2014, 3, 20), 150, 50);

		newUser.getActivityList().add(newHike);
		newUser.getActivityList().add(newerHike);
		newUser.getActivityList().add(newPaddle);

	}

	// Create

	@Test
	public void createUser() {
		newUser2 = new User("N.Cravensworth@gmail.com", "Nadja Cravensworth", "password");

		assertEquals("N.Cravensworth@gmail.com", newUser2.getUserEmail());
	}

	@Test
	public void addNewHikingActivity() {
		int numberOfActivities = newUser.getActivityList().size();
		newUser.getActivityList().add(newestHike);
		assertEquals(numberOfActivities + 1, newUser.getActivityList().size());
	}

	@Test
	public void addNewKayakingActivity() {
		int numberOfActivities = newUser.getActivityList().size();
		newUser.getActivityList().add(returnPaddle);
		assertEquals(numberOfActivities + 1, newUser.getActivityList().size());
	}

	// Read
	@Test
	public void getAllHikingActivities() {

		assertEquals(2, newUser.getActivityList().stream().filter(hike -> hike instanceof Hiking).count());
	}

	@Test
	public void getAllHikingActivitiesByDateDesc() {
		List<Activity> hikingList = newUser.getActivityList().stream().filter(hike -> hike instanceof Hiking)
				.collect(Collectors.toList());
		Comparator<Activity> compareByStartDate = (Activity o1, Activity o2) -> ((Hiking) o1).getStartDate()
				.compareTo(((Hiking) o2).getStartDate());
		Collections.sort(hikingList, compareByStartDate.reversed());
		assertEquals("2014-02-16", ((Hiking) hikingList.get(0)).getStartDate().toString());

	}

	@Test
	public void getAllKayakingActivitiebyDateDesc() {
		List<Activity> kayakingList = newUser.getActivityList().stream().filter(kayak -> kayak instanceof Kayaking)
				.collect(Collectors.toList());
		Comparator<Activity> compareByDate = (Activity o1, Activity o2) -> ((Kayaking) o1).getDateCompleted()
				.compareTo(((Kayaking) o2).getDateCompleted());
		Collections.sort(kayakingList, compareByDate.reversed());
		assertEquals("2014-03-20", ((Kayaking) kayakingList.get(0)).getDateCompleted().toString());
	}

	@Test
	public void getAllKayakingActivities() {

		assertEquals(1, newUser.getActivityList().stream().filter(kayak -> kayak instanceof Kayaking).count());
	}

	// Update
	@Test
	public void updateHikingActivity() {
		// update activity 1 for user 1
		assertEquals(
				"Hiking [location=field, startDate=2014-02-14, endDate=2014-02-15, lengthMiles=10, officialRouteName=Hilly Hike]",
				newUser.getActivityList().get(0).toString());
		newUser.getActivityList().get(0).setDescription(newestHike.getDescription());
		newUser.getActivityList().get(0).setLifelogDirectory(newestHike.getLifelogDirectory());
		((Hiking) newUser.getActivityList().get(0)).setLocation(((Hiking) newestHike).getLocation());
		((Hiking) newUser.getActivityList().get(0)).setStartDate(((Hiking) newestHike).getStartDate());
		((Hiking) newUser.getActivityList().get(0)).setLengthMiles(((Hiking) newestHike).getLengthMiles());
		((Hiking) newUser.getActivityList().get(0)).setOfficialRouteName(((Hiking) newestHike).getOfficialRouteName());
		((Hiking) newUser.getActivityList().get(0)).setEndDate(((Hiking) newestHike).getEndDate());
		assertEquals(
				"Hiking [location=mountain, startDate=2014-02-20, endDate=2014-02-27, lengthMiles=10, officialRouteName=Hilliest Hike]",
				newUser.getActivityList().get(0).toString());
	}

	@Test
	public void updateKayakingActivity() {
		assertEquals(
				"Kayaking [journeyStart=Potato Wharf, journeyEnd=Anchorage, dateCompleted=2014-03-20, durationMins=120]",
				newUser.getActivityList().get(2).toString());
		newUser.getActivityList().get(2).setDescription(returnPaddle.getDescription());
		newUser.getActivityList().get(2).setLifelogDirectory(returnPaddle.getLifelogDirectory());
		((Kayaking) newUser.getActivityList().get(2)).setJourneyStart(((Kayaking) returnPaddle).getJourneyStart());
		((Kayaking) newUser.getActivityList().get(2)).setJourneyEnd(((Kayaking) returnPaddle).getJourneyEnd());
		((Kayaking) newUser.getActivityList().get(2)).setDateCompleted(((Kayaking) returnPaddle).getDateCompleted());
		((Kayaking) newUser.getActivityList().get(2)).setDurationMins(((Kayaking) returnPaddle).getDurationMins());
		assertEquals(
				"Kayaking [journeyStart=Anchorage, journeyEnd=Potato Wharf, dateCompleted=2014-03-20, durationMins=150]",
				newUser.getActivityList().get(2).toString());
	}

	// Delete
	@Test
	public void deleteHikingActivity() {
		int numberOfActivities = newUser.getActivityList().size();
		newUser.getActivityList().remove(newerHike);
		assertEquals(numberOfActivities - 1, newUser.getActivityList().size());
	}

	@Test
	public void deleteKayakingActivity() {
		int numberOfActivities = newUser.getActivityList().size();
		newUser.getActivityList().remove(newPaddle);
		assertEquals(numberOfActivities - 1, newUser.getActivityList().size());
	}
}
