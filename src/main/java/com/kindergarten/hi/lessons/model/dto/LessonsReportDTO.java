package com.kindergarten.hi.lessons.model.dto;

import java.sql.Date;
import java.util.List;

public class LessonsReportDTO {
	private int rrIdx;				//수업보고서인덱스
	private int classIdx;			//반인덱스
	private int age;				//대상연령
	private Date resDate;			//수업일시
	private int ttlNum;				//총원
	private int attendance;			//출석
	private int absent;				//결석
	private String rsGoals;			//수업목표
	private String rsContents;		//수업내용
	private String rsRusult;		//수업결과
	private Date regDate;			//작성일
	private Date modDate;			//수정일
	private char status;			//상태여부
	private int mainTeachar;		//담당교사
	private int regMem;				//작성자
	
	private ClassKindDTO classKindDTO; //table 반
	private LesEmployeeDTO lesEmployeeDTO;   //table 직원
	private List<ReportTableDTO> reportTableDTO;
	
	public LessonsReportDTO() {}

	public LessonsReportDTO(int rrIdx, int classIdx, int age, Date resDate, int ttlNum, int attendance, int absent,
			String rsGoals, String rsContents, String rsRusult, Date regDate, Date modDate, char status,
			int mainTeachar, int regMem, ClassKindDTO classKindDTO, LesEmployeeDTO lesEmployeeDTO,
			List<ReportTableDTO> reportTableDTO) {
		super();
		this.rrIdx = rrIdx;
		this.classIdx = classIdx;
		this.age = age;
		this.resDate = resDate;
		this.ttlNum = ttlNum;
		this.attendance = attendance;
		this.absent = absent;
		this.rsGoals = rsGoals;
		this.rsContents = rsContents;
		this.rsRusult = rsRusult;
		this.regDate = regDate;
		this.modDate = modDate;
		this.status = status;
		this.mainTeachar = mainTeachar;
		this.regMem = regMem;
		this.classKindDTO = classKindDTO;
		this.lesEmployeeDTO = lesEmployeeDTO;
		this.reportTableDTO = reportTableDTO;
	}

	public int getRrIdx() {
		return rrIdx;
	}

	public void setRrIdx(int rrIdx) {
		this.rrIdx = rrIdx;
	}

	public int getClassIdx() {
		return classIdx;
	}

	public void setClassIdx(int classIdx) {
		this.classIdx = classIdx;
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

	public int getAttendance() {
		return attendance;
	}

	public void setAttendance(int attendance) {
		this.attendance = attendance;
	}

	public int getAbsent() {
		return absent;
	}

	public void setAbsent(int absent) {
		this.absent = absent;
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

	public String getRsRusult() {
		return rsRusult;
	}

	public void setRsRusult(String rsRusult) {
		this.rsRusult = rsRusult;
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

	public int getMainTeachar() {
		return mainTeachar;
	}

	public void setMainTeachar(int mainTeachar) {
		this.mainTeachar = mainTeachar;
	}

	public int getRegMem() {
		return regMem;
	}

	public void setRegMem(int regMem) {
		this.regMem = regMem;
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

	public List<ReportTableDTO> getReportTableDTO() {
		return reportTableDTO;
	}

	public void setReportTableDTO(List<ReportTableDTO> reportTableDTO) {
		this.reportTableDTO = reportTableDTO;
	}

	@Override
	public String toString() {
		return "LessonsReportDTO [rrIdx=" + rrIdx + ", classIdx=" + classIdx + ", age=" + age + ", resDate=" + resDate
				+ ", ttlNum=" + ttlNum + ", attendance=" + attendance + ", absent=" + absent + ", rsGoals=" + rsGoals
				+ ", rsContents=" + rsContents + ", rsRusult=" + rsRusult + ", regDate=" + regDate + ", modDate="
				+ modDate + ", status=" + status + ", mainTeachar=" + mainTeachar + ", regMem=" + regMem
				+ ", classKindDTO=" + classKindDTO + ", lesEmployeeDTO=" + lesEmployeeDTO + ", reportTableDTO="
				+ reportTableDTO + "]";
	}

}
