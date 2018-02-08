package com.course.hero;

/*
 * Student info class to store information about specific students
 * 
 * 
 */
public class Student {

	private String departmentName;
	private int courseNumber;
	private String semester;
	private int year;

	public Student() {

	}

	public Student(String departmentName, int courseNumber, String semester, int year) {
		super();
		this.departmentName = departmentName;
		this.courseNumber = courseNumber;
		this.semester = semester;
		this.year = year;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public int getCourseNumber() {
		return courseNumber;
	}

	public void setCourseNumber(int courseNumber) {
		this.courseNumber = courseNumber;
	}

	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return "Student [departmentName=" + departmentName + ", courseNumber=" + courseNumber + ", semester=" + semester
				+ ", year=" + year + "]";
	}

}
