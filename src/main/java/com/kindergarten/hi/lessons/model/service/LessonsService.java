package com.kindergarten.hi.lessons.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kindergarten.hi.common.paging.SelectCriteria;
import com.kindergarten.hi.employee.model.dto.EmployeeDTO;
import com.kindergarten.hi.lessons.model.dao.LessonsDAO;
import com.kindergarten.hi.lessons.model.dto.ClassKindDTO;
import com.kindergarten.hi.lessons.model.dto.LesEmployeeDTO;
import com.kindergarten.hi.lessons.model.dto.LessonsPlanDTO;
import com.kindergarten.hi.lessons.model.dto.LessonsReportDTO;
import com.kindergarten.hi.lessons.model.dto.ReportTableDTO;
import com.kindergarten.hi.lessons.model.dto.TimeTableDTO;

@Service
public class LessonsService {

	private final LessonsDAO lessonsDAO;
	
	public LessonsService(LessonsDAO lessonsDAO) {
		this.lessonsDAO = lessonsDAO;
	}

	public List<LessonsPlanDTO> planSelectList(Map<String, Object> hm) {
		List<LessonsPlanDTO> list = lessonsDAO.planSelectList(hm);
		
		return list;
	}

	public int planSelectTotalCount(Map<String, Object> hm) {
		
		int result = lessonsDAO.planSelectTotalCount(hm);
		
		return result;
	}

	public List<LesEmployeeDTO> PlanRegCategoryEmp() {
		List<LesEmployeeDTO> list = lessonsDAO.PlanRegCategoryEmp();
		return list;
	}

	public List<ClassKindDTO> PlanRegCategoryCk() {
		List<ClassKindDTO> list = lessonsDAO.PlanRegCategoryCk();
		return list;
	}
	
	@Transactional
	public int planReg(LessonsPlanDTO lessonsPlanDTO) {
		
		int result = lessonsDAO.planReg(lessonsPlanDTO);
		
		return result;
	}

	public LessonsPlanDTO planDetail(String param) {
		LessonsPlanDTO data = lessonsDAO.planDetail(param);
		return data;
	}
	
	@Transactional
	public int planDelete(String param) {
		lessonsDAO.planDeleteManagement(param);
		int result = lessonsDAO.planDelete(param);
		return result;
	}
	
	@Transactional
	public int planSubmit(String param) {
		int result = lessonsDAO.planSubmit(param);
		int result1 = 0;
		if(result > 0) {
			result1 = lessonsDAO.planSubmitManagement(param);
		}
		
		return result1;
	}
	
	@Transactional
	public int planMod(LessonsPlanDTO lessonsPlanDTO) {
		int result = lessonsDAO.planMod(lessonsPlanDTO);
		return result;
	}

	public List<LessonsPlanDTO> timeTablecalendarSelect() {
		List<LessonsPlanDTO> list = lessonsDAO.timeTablecalendarSelect();
		return list;
	}

	public List<TimeTableDTO> timeTableSelect(String param) {
		List<TimeTableDTO> data = lessonsDAO.timeTableSelect(param);
		return data;
	}

	public int planSelectTotalCountPy(Map<String, Object> hm) {
		
		int result = lessonsDAO.planSelectTotalCountPy(hm);
		
		return result;
	}

	public List<LessonsPlanDTO> planSelectListPy(Map<String, Object> hm) {
		
		List<LessonsPlanDTO> list = lessonsDAO.planSelectListPy(hm);
		
		return list;
	}
	
	@Transactional
	public void updatePlanPy(int no, String yN) {

		int result = lessonsDAO.updatePlanPy(no,yN);
		
	}
	
	@Transactional
	public int timeTableDelete(String timeIdx) {
		int result = lessonsDAO.timeTableDelete(timeIdx);
		return result;
	}
	
	@Transactional
	public int timeTableModify(Map<String, String> hm) {
		int result = lessonsDAO.timeTableModify(hm);
		return result;
	}
	
	@Transactional
	public int timeTableSubmit(Map<String, Object> hm) {
		int result1 = lessonsDAO.timeTableSubmit(hm);
		System.out.println("result1 > " + result1);
		List<TimeTableDTO> time = lessonsDAO.timeTableSelectList(hm);
		System.out.println("time > " + time);
		int cnt = 0;
		
		if(result1 > 0) {
			
			int result2 = lessonsDAO.reportInsert(hm);
			System.out.println("result2 > " + result2);
			if(result2 > 0) {
				
				for(int i = 0; i < time.size(); i++) {
					int result3 = lessonsDAO.reportTableInsert(time.get(i));
					System.out.println("result3 > " + result3);
					if(result3 > 0) {
						cnt++;
					}
					
				}
			}
			
		}
		System.out.println("cnt > " + cnt);
		return cnt;
	}

	public int reportSelectTotalCount(Map<String, Object> hm) {
		
		int result = lessonsDAO.reportSelectTotalCount(hm);
		
		return result;
	}

	public List<LessonsReportDTO> reportSelectList(Map<String, Object> hm) {
		
		List<LessonsReportDTO> list = lessonsDAO.reportSelectList(hm);
		
		return list;
	}

	public LessonsReportDTO reportDetail(String param) {
		LessonsReportDTO data = lessonsDAO.reportDetail(param);
		return data;
	}

	@Transactional
	public int reportMod(LessonsReportDTO lessonsReportDTO) {
		int result = lessonsDAO.reportMod(lessonsReportDTO);
		return result;
	}

	@Transactional
	public int reportSubmit(String param) {
		int result = lessonsDAO.reportSubmit(param);
		return result;
	}

	public List<ReportTableDTO> reportTimeSelect(String param) {
		List<ReportTableDTO> time = lessonsDAO.reportTimeSelect(param);
		return time;
	}
	

	
}
