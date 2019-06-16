package com.bae.persistence.domain;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Kayaking extends Activity {

	@Column(length = 50)
	private String journeyStart;
	@Column(length = 50)
	private String journeyEnd;
	@Column(length = 50)
	private LocalDate dateCompleted;
	@Column(length = 3)
	private int durationMins;

	public Kayaking(String lifelogDirectory, String description, String journeyStart, String journeyEnd,
			LocalDate localDate, int durationMins) {
		super(lifelogDirectory, description);
		this.journeyStart = journeyStart;
		this.journeyEnd = journeyEnd;
		this.dateCompleted = localDate;
		this.durationMins = durationMins;
	}

	public Kayaking() {

	}

	public String getJourneyStart() {
		return journeyStart;
	}

	public void setJourneyStart(String journeyStart) {
		this.journeyStart = journeyStart;
	}

	public String getJourneyEnd() {
		return journeyEnd;
	}

	public void setJourneyEnd(String journeyEnd) {
		this.journeyEnd = journeyEnd;
	}

	public LocalDate getDateCompleted() {
		return dateCompleted;
	}

	public void setDateCompleted(LocalDate dateCompleted) {
		this.dateCompleted = dateCompleted;
	}

	public int getDurationMins() {
		return durationMins;
	}

	public void setDurationMins(int durationMins) {
		this.durationMins = durationMins;
	}

	@Override
	public String toString() {
		return "Kayaking [journeyStart=" + journeyStart + ", journeyEnd=" + journeyEnd + ", dateCompleted="
				+ dateCompleted + ", durationMins=" + durationMins + "]";
	}

}
