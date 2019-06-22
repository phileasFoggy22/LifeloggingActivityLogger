package com.bae.persistence.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public abstract class Activity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	private Long id;
	@Column(length = 255)
	private String lifelogDirectory;

	@Column(length = 255)
	private String description;

	@Column(length = 50)
	private String activityType;

	public Activity(String lifelogDirectory, String description, String activityType) {
		super();
		this.lifelogDirectory = lifelogDirectory;
		this.activityType = activityType;
		this.description = description;
	}

	public Activity() {

	}

	public String getLifelogDirectory() {
		return lifelogDirectory;
	}

	public void setLifelogDirectory(String lifelogDirectory) {
		this.lifelogDirectory = lifelogDirectory;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
