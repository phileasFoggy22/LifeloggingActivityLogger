package com.bae.persistence.domain;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Hiking extends Activity {

	@Column(length = 50, nullable = true)
	private String location;
	@Column(nullable = true)
	private LocalDate startDate;
	@Column(nullable = true)
	private LocalDate endDate;
	@Column(length = 5, nullable = true)
	private int lengthMiles;
	@Column(length = 200, nullable = true)
	private String officialRouteName;

	public Hiking(String lifelogDirectory, String description, String location, LocalDate startDate, LocalDate endDate,
			int lengthMiles, String officialRouteName) {
		super(lifelogDirectory, description);
		this.location = location;
		this.startDate = startDate;
		this.endDate = endDate;
		this.lengthMiles = lengthMiles;
		this.officialRouteName = officialRouteName;
	}

	public Hiking() {

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

	public void setEndDate(LocalDate date) {
		this.endDate = date;
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

	@Override
	public String toString() {
		return "Hiking [location=" + location + ", startDate=" + startDate + ", endDate=" + endDate + ", lengthMiles="
				+ lengthMiles + ", officialRouteName=" + officialRouteName + "]";
	}

}
