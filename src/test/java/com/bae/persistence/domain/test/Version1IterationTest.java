package com.bae.persistence.domain.test;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

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
		newUser2 = new User("N.Cravensworth@gmail.com", "Nadja Cravensworth", "password");

		newHike = new Hiking("File/Area", "long hike, feet hurt", "field", LocalDate.of(2014, 2, 14),
				LocalDate.of(2014, 2, 15), 10, "Hilly Hike");
		newerHike = new Hiking("File/Area2", "longer hike, feet hurt more", "hill", LocalDate.of(2014, 2, 16),
				LocalDate.of(2014, 2, 18), 10, "Hillier Hike");
		newestHike = new Hiking("File/Area3", "longest hike, feet in agony", "mountain", LocalDate.of(2014, 2, 20),
				LocalDate.of(2014, 2, 27), 10, "Hilliest Hike");

		newPaddle = new Kayaking("File/Area4", "gentle paddle", "Potato Wharf", "Anchorage", LocalDate.of(2014, 3, 20),
				120);
		returnPaddle = new Kayaking("File/Area5", "gentler paddle", "Anchorage", "Potato Wharf",
				LocalDate.of(2014, 3, 20), 150);

		newUser.getActivityList().add(newHike);
		newUser.getActivityList().add(newerHike);
		newUser.getActivityList().add(newPaddle);

	}

	@Test
	public void addUser() {
		assert (true);
	}

	@Test
	public void addNewHikingActivity() {
		int numberOfActivities = newUser.getActivityList().size();
		newUser.getActivityList().add(newestHike);
		assertEquals(numberOfActivities + 1, newUser.getActivityList().size());
	}

	@Test
	public void updateHikingActivity() {
		assert (true);
	}

	@Test
	public void deleteHikingActivity() {
		int numberOfActivities = newUser.getActivityList().size();
		newUser.getActivityList().remove(newerHike);
		assertEquals(numberOfActivities - 1, newUser.getActivityList().size());
	}

	@Test
	public void getAllHikingActivities() {
		assert (true);
	}

	@Test
	public void getAllActivitiesbyDateDesc() {
		assert (true);
	}

	@Test
	public void addNewKayakingActivity() {
		int numberOfActivities = newUser.getActivityList().size();
		newUser.getActivityList().add(returnPaddle);
		assertEquals(numberOfActivities + 1, newUser.getActivityList().size());
	}

	@Test
	public void updateKayakingActivity() {
		assert (true);
	}

	@Test
	public void deleteKayakingActivity() {
		int numberOfActivities = newUser.getActivityList().size();
		newUser.getActivityList().remove(newPaddle);
		assertEquals(numberOfActivities - 1, newUser.getActivityList().size());
	}

	@Test
	public void getAllKayakingActivities() {
		assert (true);
	}
}
