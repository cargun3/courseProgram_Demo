package com.example.demo.util;

public class EnumUtil {
	
	/**
	 * ���� �˻� EnumType
	 * @return
	 */
	public enum CousreSearchType {
		professorName
		,courseName;
		public String getName() {
			switch(this) {
				case professorName:
					return "������";
				case courseName:
					return "�����";
				default:
					return "������";
			}
		}
	}
	
}
