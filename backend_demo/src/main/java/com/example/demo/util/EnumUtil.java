package com.example.demo.util;

public class EnumUtil {
	
	/**
	 * 과목 검색 EnumType
	 * @return
	 */
	public enum CousreSearchType {
		professorName
		,courseName;
		public String getName() {
			switch(this) {
				case professorName:
					return "교수명";
				case courseName:
					return "과목명";
				default:
					return "교수명";
			}
		}
	}
	
}
