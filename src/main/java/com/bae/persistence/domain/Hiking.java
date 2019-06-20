package com.bae.persistence.domain;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Hiking extends Activity {

	@Column(length = 50, nullable = true)
	private String location;
	@Column(nullable = true)
	private java.sql.Date startDate;
	@Column(nullable = true)
	private java.sql.Date endDate;
	@Column(length = 5, nullable = true)
	private int lengthMiles;
	@Column(length = 200, nullable = true)
	private String officialRouteName;

	public Hiking(String lifelogDirectory, String description, String location, Date localDate, Date localDate2,
			int lengthMiles, String officialRouteName) {
		super(lifelogDirectory, description);
		this.location = location;
		this.startDate = localDate;
		this.endDate = localDate2;
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

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
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

	@Override
	public String toString() {
		return "Hiking [location=" + location + ", startDate=" + startDate + ", endDate=" + endDate + ", lengthMiles="
				+ lengthMiles + ", officialRouteName=" + officialRouteName + "]";
	}

}
