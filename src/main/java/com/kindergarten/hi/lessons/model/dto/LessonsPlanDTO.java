package com.kindergarten.hi.lessons.model.dto;

import java.sql.Date;
import java.util.List;

public class LessonsPlanDTO {
	private int lpIdx;				//수업계획서인덱스
	private int classIdx;			//반인덱스
	private int mainTeacher;		//담당교사
	private int age;				//나이
	private Date resDate;			//수업일시
	private int ttlNum;				//총원
	private String rsGoals;			//수업목표
	private String rsContents;		//수업내용
	private String effect;			//기대효과
	private int regMem;				//작성자
	private Date regDate;			//작성일
	private Date modDate;			//수정일
	private char status;			//삭제여부
	private char submit;			//제출여부
	private char report;			//제출여부
	
	private ClassKindDTO classKindDTO; //table 반
	private LesEmployeeDTO lesEmployeeDTO;   //table 직원
	private LessonsManagementHisDTO lessonsManagementHisDTO; //table 결재이력
	
	public LessonsPlanDTO() {}

	public LessonsPlanDTO(int lpIdx, int classIdx, int mainTeacher, int age, Date resDate, int ttlNum, String rsGoals,
			String rsContents, String effect, int regMem, Date regDate, Date modDate, char status, char submit,
			char report, ClassKindDTO classKindDTO, LesEmployeeDTO lesEmployeeDTO,
			LessonsManagementHisDTO lessonsManagementHisDTO) {
		super();
		this.lpIdx = lpIdx;
		this.classIdx = classIdx;
		this.mainTeacher = mainTeacher;
		this.age = age;
		this.resDate = resDate;
		this.ttlNum = ttlNum;
		this.rsGoals = rsGoals;
		this.rsContents = rsContents;
		this.effect = effect;
		this.regMem = regMem;
		this.regDate = regDate;
		this.modDate = modDate;
		this.status = status;
		this.submit = submit;
		this.report = report;
		this.classKindDTO = classKindDTO;
		this.lesEmployeeDTO = lesEmployeeDTO;
		this.lessonsManagementHisDTO = lessonsManagementHisDTO;
	}

	public int getLpIdx() {
		return lpIdx;
	}

	public void setLpIdx(int lpIdx) {
		this.lpIdx = lpIdx;
	}

	public int getClassIdx() {
		return classIdx;
	}

	public void setClassIdx(int classIdx) {
		this.classIdx = classIdx;
	}

	public int getMainTeacher() {
		return mainTeacher;
	}

	public void setMainTeacher(int mainTeacher) {
		this.mainTeacher = mainTeacher;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Date getResDate() {
		return resDate;
	}

	public void setResDate(Date resDate) {
		this.resDate = resDate;
	}

	public int getTtlNum() {
		return ttlNum;
	}

	public void setTtlNum(int ttlNum) {
		this.ttlNum = ttlNum;
	}

	public String getRsGoals() {
		return rsGoals;
	}

	public void setRsGoals(String rsGoals) {
		this.rsGoals = rsGoals;
	}

	public String getRsContents() {
		return rsContents;
	}

	public void setRsContents(String rsContents) {
		this.rsContents = rsContents;
	}

	public String getEffect() {
		return effect;
	}

	public void setEffect(String effect) {
		this.effect = effect;
	}

	public int getRegMem() {
		return regMem;
	}

	public void setRegMem(int regMem) {
		this.regMem = regMem;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public Date getModDate() {
		return modDate;
	}

	public void setModDate(Date modDate) {
		this.modDate = modDate;
	}

	public char getStatus() {
		return status;
	}

	public void setStatus(char status) {
		this.status = status;
	}

	public char getSubmit() {
		return submit;
	}

	public void setSubmit(char submit) {
		this.submit = submit;
	}

	public char getReport() {
		return report;
	}

	public void setReport(char report) {
		this.report = report;
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

	public LessonsManagementHisDTO getLessonsManagementHisDTO() {
		return lessonsManagementHisDTO;
	}

	public void setLessonsManagementHisDTO(LessonsManagementHisDTO lessonsManagementHisDTO) {
		this.lessonsManagementHisDTO = lessonsManagementHisDTO;
	}

	@Override
	public String toString() {
		return "LessonsPlanDTO [lpIdx=" + lpIdx + ", classIdx=" + classIdx + ", mainTeacher=" + mainTeacher + ", age="
				+ age + ", resDate=" + resDate + ", ttlNum=" + ttlNum + ", rsGoals=" + rsGoals + ", rsContents="
				+ rsContents + ", effect=" + effect + ", regMem=" + regMem + ", regDate=" + regDate + ", modDate="
				+ modDate + ", status=" + status + ", submit=" + submit + ", report=" + report + ", classKindDTO="
				+ classKindDTO + ", lesEmployeeDTO=" + lesEmployeeDTO + ", lessonsManagementHisDTO="
				+ lessonsManagementHisDTO + "]";
	}

}
