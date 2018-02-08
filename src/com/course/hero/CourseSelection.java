package com.course.hero;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
 * On our site, students can input the courses they are taking in any combination of a
Department+Course Number followed by Semester+Year. 

A department is always one or more alphabetic characters, 
and a course number is always one or more numeric characters.

Department and course number can be separated by an optional delimiter. 
Delimiters are "-", " ", or ":". 
There is no finite list of departments and course numbers. 
There is always a space after the Course Number and before Semester+Year. 
The semester is either an abbreviation or a word; 
Semester abbreviations are F (Fall), W (Winter), S (Spring), Su (Summer). 
A Year is either two digits or four digits. 
Semester could come before Year or Year could come before Semester. 

Below are some examples of formatting of Department+Course Number,

Semester+Year, as well as sample inputs.
Examples of Department+Course Number formats:
 CS111
 CS 111
 CS:111
 CS-111
Examples of Semester+Year formats:
 Fall 2016
 fall 16
 2016 Fall
 F2016

Examples inputs formats:
"CS111 2016 Fall"
"CS-111 Fall 2016"
"CS 111 F2016"
Part 1: Data Normalization
Write a solution that will identify the Department, Course Number, Semester and Year for a
given string, based on the requirements talked about above, and return an object with
properties. 
 For this part of the problem assume that your code already has received the input string from the user and you
are just processing it.
Any combination of the example inputs for Department + Course Number followed by Semester
+ Year given above should create an object with the following properties and values:
 Department: CS
 Course Number: 111
 Year: 2016
 Semester: Fall
 * 
 */
public class CourseSelection implements CourseHeroConstant {

	public Map<Integer, String> getTokenFromString(String courseString, String regEx) {

		Map<Integer, String> groupMap = new HashMap<Integer, String>();
		final Pattern pattern = Pattern.compile(regEx, Pattern.CASE_INSENSITIVE);
		final Matcher matcher = pattern.matcher(courseString);

		if (matcher.find()) {

			for (int i = 1; i <= matcher.groupCount(); i++) {
				groupMap.put(i, matcher.group(i));

			}

		}
		return groupMap;

	}

	/*
	 * The routine check for few basic validations. It first make sure that the
	 * list contains the valid number of tokens.
	 * 
	 */
	public boolean isValidInput(Map<Integer, String> groupMap, int expectedTokens) {

		if (groupMap.size() != expectedTokens) {
			return false;
		}

		return true;
	}

	public void buildStudentObject(Map<Integer, String> groupMap, Student student, int groupCount) {

		int counter = 1;
		while (counter <= groupCount) {
			student.setDepartmentName(groupMap.get(counter++).toUpperCase());
			student.setCourseNumber(Integer.valueOf(groupMap.get(counter++).trim()));

			// if the first character is a digit then this is an year
			if (Character.isDigit(groupMap.get(counter).charAt(0))) {
				student.setYear(getYearFromString(groupMap.get(counter++).trim()));
				student.setSemester(getSemesterFullName(groupMap.get(counter++)));
			} else {
				student.setSemester(getSemesterFullName(groupMap.get(counter++)));
				student.setYear(getYearFromString(groupMap.get(counter++).trim()));

			}

		}

	}

	/*
	 * utilty to look up the Enum class to find the full name of the Semester
	 * 
	 */
	public String getSemesterFullName(String semester) {
		if (semester.length() == 1) {
			return Semester.SEM_BY_ABBR.get(semester);
		}
		return Semester.valueOf(semester.toUpperCase()).getName();
	}

	// This utility allows 5 years in the future for a year with 2 digits
	public int getYearFromString(String yearInString) {
		int year = Integer.valueOf(yearInString);
		if (yearInString.length() == 2) {
			// Allow 5 years in the future for a 2 digit date
			if (year + 100 > new Date().getYear() + 5) {
				year = year + 1900;
			} else {
				year = year + 2000;
			}
		}
		return year;

	}

	/*
	 * Utility takes a course string as an argument, a regex pattern and the
	 * expected number of tokens. If the match is found it return a Student
	 * object or else return a null
	 * 
	 * 
	 */

	public Student parseStudentDetail(String courseInput, String regex, int expectedToken) {
		
		// if any of the input parameter is null then return a null
		if(null == courseInput || null == regex || 0 == expectedToken)
		{
			return null;
		}
		Student student = new Student();
		Map<Integer, String> groups = getTokenFromString(courseInput, regex);
		if (isValidInput(groups, expectedToken)) {
			buildStudentObject(groups, student, expectedToken);
		}
		// input String is not valid
		else {
			return null;
		}
		return student;

	}

}
