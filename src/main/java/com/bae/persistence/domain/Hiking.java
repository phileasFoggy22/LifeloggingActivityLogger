package com.bae.persistence.domain;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Hiking extends Activity {

	@Column(length = 50)
	private String location;
	@Temporal(TemporalType.DATE)
	private LocalDate startDate;
	@Temporal(TemporalType.DATE)
	private LocalDate endDate;
	@Column(length = 5)
	private int lengthMiles;
	@Column(length = 200)
	private String officialRouteName;

	public Hiking(String lifelogDirectory, String description, String location, LocalDate localDate,
			LocalDate localDate2, int lengthMiles, String officialRouteName) {
		super(lifelogDirectory, description);
		this.location = location;
		this.startDate = localDate;
		this.endDate = localDate2;
		this.lengthMiles = lengthMiles;
		this.officialRouteName = officialRouteName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public int getLengthMiles() {
		return lengthMiles;
	}

	public void setLengthMiles(int lengthMiles) {
		this.lengthMiles = lengthMiles;
	}

	public String getOfficialRouteName() {
		return officialRouteName;
	}

	public void setOfficialRouteName(String officialRouteName) {
		this.officialRouteName = officialRouteName;
	}

}
