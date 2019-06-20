package com.bae.persistence.domain;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Kayaking extends Activity {

	@Column(length = 50, nullable = true)
	private String journeyStart;
	@Column(length = 50, nullable = true)
	private String journeyEnd;
	@Column(length = 50, nullable = true)
	private Date dateCompleted;
	@Column(length = 3, nullable = true)
	private int durationMins;
	@Column(length = 4, nullable = true)
	private int lengthKilometers;

	public Kayaking(String lifelogDirectory, String description, String journeyStart, String journeyEnd,
			String dateCompleted, int durationMins, int lengthKilometers) {
		super(lifelogDirectory, description);
		this.journeyStart = journeyStart;
		this.journeyEnd = journeyEnd;
		if(dateCompleted.length()==10) {
			SimpleDateFormat formatter1=new SimpleDateFormat("dd/MM/yyyy");  	
			try {
				this.dateCompleted = formatter1.parse(dateCompleted);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		else if(dateCompleted.length()==24)
		{
			SimpleDateFormat formatter1=new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");  	
			try {
				this.dateCompleted = formatter1.parse(dateCompleted);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		else if(dateCompleted.length()==28)
		{
			SimpleDateFormat formatter1=new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy");  	
			try {
				this.dateCompleted = formatter1.parse(dateCompleted);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		this.durationMins = durationMins;
		this.lengthKilometers = lengthKilometers;
	}

	public int getLengthKilometers() {
		return lengthKilometers;
	}

	public void setLengthKilometers(int lengthKilometers) {
		this.lengthKilometers = lengthKilometers;
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

	public String getDateCompleted() {
		return dateCompleted.toString();
	}

	public void setDateCompleted(String dateCompleted) {
		if(dateCompleted.length()==10) {
			SimpleDateFormat formatter1=new SimpleDateFormat("dd/MM/yyyy");  	
			try {
				this.dateCompleted = formatter1.parse(dateCompleted);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		else if(dateCompleted.length()==24)
		{
			System.out.println("here: "+dateCompleted);
			SimpleDateFormat formatter1=new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");  	
			try {
				this.dateCompleted = formatter1.parse(dateCompleted);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		else if(dateCompleted.length()==28)
		{
			SimpleDateFormat formatter1=new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy");  	
			try {
				this.dateCompleted = formatter1.parse(dateCompleted);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
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
