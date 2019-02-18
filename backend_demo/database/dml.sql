INSERT INTO `TB_PROFESSOR` (`PROFESSOR_IDX`, `PROFESSOR_NAME`) VALUES
	(1, '김건우'),
	(2, '박지성'),
	(3, '손흥민'),
	(4, '황의조');
	
INSERT INTO `TB_COURSE` (`COURSE_IDX`, `PROFESSOR_IDX`, `COURSE_NAME`, `COURSE_SCORE`) VALUES
	(1, 1, '수학1', 3),
	(2, 2, '전술1', 3),
	(3, 3, '체육', 2),
	(4, 4, '드리블1', 3);
	
INSERT INTO `TB_COURSE_TIME` (`COURSE_TIME_IDX`, `COURSE_IDX`, `COURSE_TIME_INFO`) VALUES
	(1, 1, '월1-3'),
	(2, 1, '화1-3'),
	(3, 2, '월4-6'),
	(4, 2, '월1-3'),
	(5, 4, '화4-5, 목4'),
	(6, 4, '수2-3, 금6'),
	(7, 3, '목5-6'),
	(8, 3, '수5-6');
	
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