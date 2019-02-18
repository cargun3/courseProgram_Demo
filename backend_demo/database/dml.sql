INSERT INTO `TB_PROFESSOR` (`PROFESSOR_IDX`, `PROFESSOR_NAME`) VALUES
	(1, '��ǿ�'),
	(2, '������'),
	(3, '�����'),
	(4, 'Ȳ����');
	
INSERT INTO `TB_COURSE` (`COURSE_IDX`, `PROFESSOR_IDX`, `COURSE_NAME`, `COURSE_SCORE`) VALUES
	(1, 1, '����1', 3),
	(2, 2, '����1', 3),
	(3, 3, 'ü��', 2),
	(4, 4, '�帮��1', 3);
	
INSERT INTO `TB_COURSE_TIME` (`COURSE_TIME_IDX`, `COURSE_IDX`, `COURSE_TIME_INFO`) VALUES
	(1, 1, '��1-3'),
	(2, 1, 'ȭ1-3'),
	(3, 2, '��4-6'),
	(4, 2, '��1-3'),
	(5, 4, 'ȭ4-5, ��4'),
	(6, 4, '��2-3, ��6'),
	(7, 3, '��5-6'),
	(8, 3, '��5-6');
	
INSERT INTO `TB_COURSE_TIME_TABLE` (`COURSE_TIME_IDX`, `TIME_TABLE_DAY`, `TIME_TABLE_START`, `TIME_TABLE_END`) VALUES
	(1, 1, 1, 3),
	(2, 2, 1, 3),
	(3, 1, 4, 6),
	(4, 1, 1, 3),
	(5, 2, 4, 5),
	(5, 4, 4, 4),
	(6, 3, 2, 3),
	(6, 2, 3, 6),
	(7, 4, 5, 6),
	(8, 3, 5, 6);