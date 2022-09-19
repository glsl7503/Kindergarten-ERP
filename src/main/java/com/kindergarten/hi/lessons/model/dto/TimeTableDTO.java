package com.kindergarten.hi.lessons.model.dto;

public class TimeTableDTO {
	private int timetableIdx;			//시간표인덱스
	private int rpIdx;					//수업계획서인덱스
	private int period;					//교시
	private String title;				//제목
	private String specialNote;			//특이사항
	
	private LessonsPlanDTO lessonsPlanDTO;  //table 수업계획
	private ClassKindDTO classKindDTO;
	private LesEmployeeDTO lesEmployeeDTO;
	
	public TimeTableDTO() {}


	public TimeTableDTO(int timetableIdx, int rpIdx, int period, String title, String specialNote,
			LessonsPlanDTO lessonsPlanDTO, ClassKindDTO classKindDTO, LesEmployeeDTO lesEmployeeDTO) {
		super();
		this.timetableIdx = timetableIdx;
		this.rpIdx = rpIdx;
		this.period = period;
		this.title = title;
		this.specialNote = specialNote;
		this.lessonsPlanDTO = lessonsPlanDTO;
		this.classKindDTO = classKindDTO;
		this.lesEmployeeDTO = lesEmployeeDTO;
	}


	public int getTimetableIdx() {
		return timetableIdx;
	}


	public void setTimetableIdx(int timetableIdx) {
		this.timetableIdx = timetableIdx;
	}


	public int getRpIdx() {
		return rpIdx;
	}


	public void setRpIdx(int rpIdx) {
		this.rpIdx = rpIdx;
	}


	public int getPeriod() {
		return period;
	}


	public void setPeriod(int period) {
		this.period = period;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getSpecialNote() {
		return specialNote;
	}


	public void setSpecialNote(String specialNote) {
		this.specialNote = specialNote;
	}


	public LessonsPlanDTO getLessonsPlanDTO() {
		return lessonsPlanDTO;
	}


	public void setLessonsPlanDTO(LessonsPlanDTO lessonsPlanDTO) {
		this.lessonsPlanDTO = lessonsPlanDTO;
	}


	public ClassKindDTO getClassKindDTO() {
		return classKindDTO;
	}


	public void setClassKindDTO(ClassKindDTO classKindDTO) {
		this.classKindDTO = classKindDTO;
	}


	public LesEmployeeDTO getLesEmployeeDTO() {
		return lesEmployeeDTO;
	}


	public void setLesEmployeeDTO(LesEmployeeDTO lesEmployeeDTO) {
		this.lesEmployeeDTO = lesEmployeeDTO;
	}


	@Override
	public String toString() {
		return "TimeTableDTO [timetableIdx=" + timetableIdx + ", rpIdx=" + rpIdx + ", period=" + period + ", title="
				+ title + ", specialNote=" + specialNote + ", lessonsPlanDTO=" + lessonsPlanDTO + ", classKindDTO="
				+ classKindDTO + ", lesEmployeeDTO=" + lesEmployeeDTO + "]";
	}

}
