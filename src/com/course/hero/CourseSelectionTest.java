package com.course.hero;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class CourseSelectionTest {

	@org.junit.Test
	public void getTokenFromString_validString_returnSize() {
		String courseString = "CS111 FALL1979";
		CourseSelection course = new CourseSelection();
		assertEquals(4, course.getTokenFromString(courseString, CourseHeroConstant.REG_EX).size());
		assertEquals(4, course.getTokenFromString("CS-1111 FALL1979", CourseHeroConstant.REG_EX).size());
		assertEquals(4, course.getTokenFromString("CS-1111 FALL1979", CourseHeroConstant.REG_EX).size());
		assertEquals(4, course.getTokenFromString("CS:1111 FALL1979", CourseHeroConstant.REG_EX).size());
		assertEquals(4, course.getTokenFromString("CS 1111 FALL1979", CourseHeroConstant.REG_EX).size());

		assertEquals(4, course.getTokenFromString("CS-1111 FALL 1979", CourseHeroConstant.REG_EX).size());
		assertEquals(4, course.getTokenFromString("CS-1111 F 1979", CourseHeroConstant.REG_EX).size());
		assertEquals(4, course.getTokenFromString("CS:1111 FALL79", CourseHeroConstant.REG_EX).size());
		assertEquals(4, course.getTokenFromString("CS 1111 F79", CourseHeroConstant.REG_EX).size());

		assertEquals(4, course.getTokenFromString("CS-1111 1979 FALL", CourseHeroConstant.REG_EX).size());
		assertEquals(4, course.getTokenFromString("CS-1111 1979 F", CourseHeroConstant.REG_EX).size());
		assertEquals(4, course.getTokenFromString("CS:1111 79FALL", CourseHeroConstant.REG_EX).size());
		assertEquals(4, course.getTokenFromString("CS 1111 79F", CourseHeroConstant.REG_EX).size());

	}

	@org.junit.Test
	public void getTokenFromString_InvalidString_returnZero() {
		CourseSelection course = new CourseSelection();
		assertEquals(0, course.getTokenFromString("CS FALL1979", CourseHeroConstant.REG_EX).size());
		assertEquals(0, course.getTokenFromString("CS111 979", CourseHeroConstant.REG_EX).size());
		assertEquals(0, course.getTokenFromString("1111 FALL1979", CourseHeroConstant.REG_EX).size());
		assertEquals(0, course.getTokenFromString("3CS:1111 FALL1979", CourseHeroConstant.REG_EX).size());
		assertEquals(0, course.getTokenFromString("CS 1111 1234FALL1979", CourseHeroConstant.REG_EX).size());

	}

	@org.junit.Test
	public void parseStudentDetail_validRecor_ReturnNotNull() {
		CourseSelection course = new CourseSelection();
		Student student = new Student();
		student.setCourseNumber(111);
		student.setDepartmentName("CS");
		student.setSemester("Fall");
		student.setYear(1979);
		Student mappedStudent = course.parseStudentDetail("CS111 FALL 1979", CourseHeroConstant.REG_EX, 4);
		assertEquals(student.getCourseNumber(), mappedStudent.getCourseNumber());
		assertEquals(student.getDepartmentName(), mappedStudent.getDepartmentName());
		assertEquals(student.getSemester(), mappedStudent.getSemester());
		assertEquals(student.getYear(), mappedStudent.getYear());
		System.out.println(mappedStudent);

	}

	@org.junit.Test
	public void parseStudentDetail_validInvalidDate_ReturnNull() {
		CourseSelection course = new CourseSelection();
		Student mappedStudent = course.parseStudentDetail("CS111 FALL 979", CourseHeroConstant.REG_EX, 4);
		assertNull(mappedStudent);

	}

	@org.junit.Test
	public void parseStudentDetail_validDateWith2Digits_ReturnDate() {
		CourseSelection course = new CourseSelection();
		Student mappedStudent = course.parseStudentDetail("CS111 FALL 79", CourseHeroConstant.REG_EX, 4);
		assertEquals(1979, mappedStudent.getYear());

	}

	@org.junit.Test
	public void parseStudentDetail_validDateWith4Digits_ReturnDate() {
		CourseSelection course = new CourseSelection();
		Student mappedStudent = course.parseStudentDetail("CS111 FALL 1979", CourseHeroConstant.REG_EX, 4);
		assertEquals(1979, mappedStudent.getYear());

	}

	@org.junit.Test
	public void parseStudentDetail_validDeptWithDelimiter_ReturnDept() {
		CourseSelection course = new CourseSelection();
		assertEquals("CS",
				course.parseStudentDetail("CS111 FALL 1979", CourseHeroConstant.REG_EX, 4).getDepartmentName());
		assertEquals("CS",
				course.parseStudentDetail("CS:111 FALL 1979", CourseHeroConstant.REG_EX, 4).getDepartmentName());
		assertEquals("CS",
				course.parseStudentDetail("CS-111 FALL 1979", CourseHeroConstant.REG_EX, 4).getDepartmentName());
		assertEquals("CS",
				course.parseStudentDetail("CS 111 FALL 1979", CourseHeroConstant.REG_EX, 4).getDepartmentName());

	}

	@org.junit.Test
	public void parseStudentDetail1_validDateWith2DigitsOrder1_ReturnDate() {
		CourseSelection course = new CourseSelection();
		assertEquals(2015, course.parseStudentDetail("CS111 FALL 15", CourseHeroConstant.REG_EX, 4).getYear());
		assertEquals(2015, course.parseStudentDetail("CS111 FALL15", CourseHeroConstant.REG_EX, 4).getYear());
		assertEquals(2015, course.parseStudentDetail("CS111 FALL2015", CourseHeroConstant.REG_EX, 4).getYear());

	}

	@org.junit.Test
	public void parseStudentDetail1_validDateWith2DigitsOrder2_ReturnDate() {
		CourseSelection course = new CourseSelection();
		assertEquals(2015, course.parseStudentDetail("CS111 15FALL", CourseHeroConstant.REG_EX, 4).getYear());
		assertEquals(2015, course.parseStudentDetail("CS111 15 FALL", CourseHeroConstant.REG_EX, 4).getYear());
		assertEquals(2015, course.parseStudentDetail("CS111 2015FALL", CourseHeroConstant.REG_EX, 4).getYear());

	}

	@org.junit.Test
	public void parseStudentDetail_validSemesterWith1CharcaterOrder1_ReturnDate() {
		CourseSelection course = new CourseSelection();
		assertEquals("Fall", course.parseStudentDetail("CS111 F 15", CourseHeroConstant.REG_EX, 4).getSemester());
		assertEquals("Fall", course.parseStudentDetail("CS111 F15", CourseHeroConstant.REG_EX, 4).getSemester());
		assertEquals("Fall", course.parseStudentDetail("CS111 F2015", CourseHeroConstant.REG_EX, 4).getSemester());

	}

	@org.junit.Test
	public void parseStudentDetail_validSemesterWith1CharcaterOrder2_ReturnDate() {
		CourseSelection course = new CourseSelection();
		assertEquals("Fall", course.parseStudentDetail("CS111 15F", CourseHeroConstant.REG_EX, 4).getSemester());
		assertEquals("Fall", course.parseStudentDetail("CS111 15 F", CourseHeroConstant.REG_EX, 4).getSemester());
		assertEquals("Fall", course.parseStudentDetail("CS111 2015F", CourseHeroConstant.REG_EX, 4).getSemester());

	}

	@org.junit.Test
	public void parseStudentDetail_NullInputString_ReturnNull() {
		CourseSelection course = new CourseSelection();
		assertNull(course.parseStudentDetail(null, CourseHeroConstant.REG_EX, 4));

	}

	@org.junit.Test
	public void isValidInput_listWithExpectedTokens_returnsTrue() {
		CourseSelection course = new CourseSelection();
		assertTrue(course.isValidInput(course.getTokenFromString("CS-1111 1979 FALL", CourseHeroConstant.REG_EX), 4));
	}

	@org.junit.Test
	public void isValidInput_listWithUnExpectedTokens_returnsTrue() {
		CourseSelection course = new CourseSelection();
		assertFalse(course.isValidInput(course.getTokenFromString("CS-1111 FALL", CourseHeroConstant.REG_EX), 4));
	}

}
