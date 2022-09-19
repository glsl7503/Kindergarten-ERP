package com.kindergarten.hi.lessons.model.dto;

public class ReportTableDTO {
	private int rtIdx;		
	private int rrIdx;		
	private int period;
	private String title;		
	private String specalNote;		
	private LesEmployeeDTO lesEmployeeDTO;
	
	public ReportTableDTO() {}

	public ReportTableDTO(int rtIdx, int rrIdx, int period, String title, String specalNote,
			LesEmployeeDTO lesEmployeeDTO) {
		super();
		this.rtIdx = rtIdx;
		this.rrIdx = rrIdx;
		this.period = period;
		this.title = title;
		this.specalNote = specalNote;
		this.lesEmployeeDTO = lesEmployeeDTO;
	}

	public int getRtIdx() {
		return rtIdx;
	}

	public void setRtIdx(int rtIdx) {
		this.rtIdx = rtIdx;
	}

	public int getRrIdx() {
		return rrIdx;
	}

	public void setRrIdx(int rrIdx) {
		this.rrIdx = rrIdx;
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

	public String getSpecalNote() {
		return specalNote;
	}

	public void setSpecalNote(String specalNote) {
		this.specalNote = specalNote;
	}

	public LesEmployeeDTO getLesEmployeeDTO() {
		return lesEmployeeDTO;
	}

	public void setLesEmployeeDTO(LesEmployeeDTO lesEmployeeDTO) {
		this.lesEmployeeDTO = lesEmployeeDTO;
	}

	@Override
	public String toString() {
		return "ReportTableDTO [rtIdx=" + rtIdx + ", rrIdx=" + rrIdx + ", period=" + period + ", title=" + title
				+ ", specalNote=" + specalNote + ", lesEmployeeDTO=" + lesEmployeeDTO + "]";
	}

}
