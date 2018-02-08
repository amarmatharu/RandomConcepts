package com.course.hero;

public interface CourseHeroConstant {
	
	//static final String REG_EX = "^([a-z]+)[ :-]?(\\d+)\\s([a-z]+|\\d+) ?((?<=[a-z] {0,1})\\d+|(?<=\\d {0,1})[a-z]+)$";
	static final String REG_EX = "^([a-z]+)[ :-]?(\\d+)\\s(F|Fall|W|Winter|S|Spring|Su|Summer |\\d{2}|\\d{4}) ?((?<=F|Fall|W|Winter|S|Spring|Su|Summer{0,1})[ ]?\\d{2}|\\d{4}|(?<=\\d {0,1})F|Fall|W|Winter|S|Spring|Su|Summer)$";

}
