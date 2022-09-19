package com.kindergarten.hi.lessons.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.kindergarten.hi.lessons.model.dto.ClassKindDTO;
import com.kindergarten.hi.lessons.model.dto.LesEmployeeDTO;
import com.kindergarten.hi.lessons.model.dto.LessonsPlanDTO;
import com.kindergarten.hi.lessons.model.dto.LessonsReportDTO;
import com.kindergarten.hi.lessons.model.dto.TimeTableDTO;

@Mapper
public interface LessonsDAO {

	List<LessonsPlanDTO> planSelectList(Map<String, Object> hm);

	int planSelectTotalCount(Map<String, Object> hm);

	List<LesEmployeeDTO> PlanRegCategoryEmp();

	List<ClassKindDTO> PlanRegCategoryCk();

	int planReg(LessonsPlanDTO lessonsPlanDTO);

	LessonsPlanDTO planDetail(String param);

	int planDelete(String param);

	int planSubmit(String param);

	int planSubmitManagement(String param);

	void planDeleteManagement(String param);

	int planMod(LessonsPlanDTO lessonsPlanDTO);

	List<LessonsPlanDTO> timeTablecalendarSelect();

	List<TimeTableDTO> timeTableSelect(String param);

	int planSelectTotalCountPy(Map<String, Object> hm);

	List<LessonsPlanDTO> planSelectListPy(Map<String, Object> hm);

	int updatePlanPy(@Param("no")int no, @Param("yN")String yN);

	int timeTableDelete(String timeIdx);

	int timeTableModify(Map<String, String> hm);

	int timeTableSubmit(Map<String, Object> hm);

	int reportInsert(Map<String, Object> hm);

	List<TimeTableDTO> timeTableSelectList(Map<String, Object> hm);

	int reportTableInsert(TimeTableDTO timeTableDTO);

	int reportSelectTotalCount(Map<String, Object> hm);

	List<LessonsReportDTO> reportSelectList(Map<String, Object> hm);

	LessonsReportDTO reportDetail(String param);

	int reportMod(LessonsReportDTO lessonsReportDTO);

	int reportSubmit(String param);

}
