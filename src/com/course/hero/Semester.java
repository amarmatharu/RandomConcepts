package com.course.hero;

import java.util.HashMap;
import java.util.Map;

public enum Semester {

	FALL("Fall", "F"), WINTER("Winter", "W"), SPRING("Spring", "S"), SUMMER("Summer", "SU");

	/**
	 * The semester's name.
	 */
	private String name;

	/**
	 * The semester's abbreviation.
	 */
	private String abbreviation;

	public static final Map<String, String> SEM_BY_ABBR = new HashMap<String, String>();

	/* static initializer */
	static {
		for (Semester semester : values()) {
			SEM_BY_ABBR.put(semester.getAbbreviation(), semester.getName());
		}
	}

	Semester(String name, String abbreviation) {
		this.name = name;
		this.abbreviation = abbreviation;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAbbreviation() {
		return abbreviation;
	}

	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}

}
