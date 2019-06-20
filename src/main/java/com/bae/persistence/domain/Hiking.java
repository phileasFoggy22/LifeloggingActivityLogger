package com.bae.persistence.domain;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Hiking extends Activity {

	@Column(length = 50, nullable = true)
	private String location;
	@Column(nullable = true)
	private LocalDate  startDate;
	@Column(nullable = true)
	private LocalDate  endDate;
	@Column(length = 5, nullable = true)
	private int lengthMiles;
	@Column(length = 200, nullable = true)
	private String officialRouteName;

	public Hiking(String lifelogDirectory, String description, String location, LocalDate  startDate, LocalDate  endDate,
			int lengthMiles, String officialRouteName) {
		super(lifelogDirectory, description);
		this.location = location;
		this.startDate = startDate;
		this.endDate = endDate;
		/*
		 * if(endDate.length()==10) { SimpleDateFormat formatter1=new
		 * SimpleDateFormat("dd/MM/yyyy"); try { this.endDate = LocalDate.of } catch
		 * (ParseException e) { e.printStackTrace(); } } else if(endDate.length()==24) {
		 * SimpleDateFormat formatter1=new
		 * SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"); try { this.endDate =
		 * formatter1.parse(endDate); } catch (ParseException e) { e.printStackTrace();
		 * } } else if(endDate.length()==28) { SimpleDateFormat formatter1=new
		 * SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy"); try { this.endDate =
		 * formatter1.parse(endDate); } catch (ParseException e) { e.printStackTrace();
		 * } }
		 * 
		 * if(startDate.length()==10) { SimpleDateFormat formatter1=new
		 * SimpleDateFormat("dd/MM/yyyy"); try { this.startDate =
		 * formatter1.parse(startDate); } catch (ParseException e) {
		 * e.printStackTrace(); } } else if(startDate.length()==24) { SimpleDateFormat
		 * formatter1=new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"); try {
		 * this.startDate = formatter1.parse(startDate); } catch (ParseException e) {
		 * e.printStackTrace(); } } else if(startDate.length()==28) { SimpleDateFormat
		 * formatter1=new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy"); try {
		 * this.startDate = formatter1.parse(startDate); } catch (ParseException e) {
		 * e.printStackTrace(); } }
		 */

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

	public LocalDate  getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate  startDate) {
		this.startDate = startDate;
		/*
		 * if(startDate.length()==10) { SimpleDateFormat formatter1=new
		 * SimpleDateFormat("dd/MM/yyyy"); try { this.startDate =
		 * formatter1.parse(startDate); } catch (ParseException e) {
		 * e.printStackTrace(); } } else if(startDate.length()==24) { SimpleDateFormat
		 * formatter1=new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"); try {
		 * this.startDate = formatter1.parse(startDate); } catch (ParseException e) {
		 * e.printStackTrace(); } } else if(startDate.length()==28) { SimpleDateFormat
		 * formatter1=new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy"); try {
		 * this.startDate = formatter1.parse(startDate); } catch (ParseException e) {
		 * e.printStackTrace(); } }
		 */
	}

	public LocalDate  getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate date) {
		this.endDate = date;
	}
	/*
	 * public void setEndDate(String endDate) { if(endDate.length()==10) {
	 * SimpleDateFormat formatter1=new SimpleDateFormat("dd/MM/yyyy"); try {
	 * this.endDate = formatter1.parse(endDate); } catch (ParseException e) {
	 * e.printStackTrace(); } } else if(endDate.length()==24) { SimpleDateFormat
	 * formatter1=new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSz"); try {
	 * this.endDate = formatter1.parse(endDate); } catch (ParseException e) {
	 * e.printStackTrace(); } } else if(endDate.length()==28) { SimpleDateFormat
	 * formatter1=new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy"); try {
	 * this.endDate = formatter1.parse(endDate); } catch (ParseException e) {
	 * e.printStackTrace(); } } }
	 */

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
