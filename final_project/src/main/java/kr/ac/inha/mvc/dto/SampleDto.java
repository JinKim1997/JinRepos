package kr.ac.inha.mvc.dto;

public class SampleDto {
	private String id;
	private String subject;
	private String grade;
	private String useYn;
	private String description;
	private String regUser;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getUseYn() {
		return useYn;
	}
	public void setUseYn(String useYn) {
		this.useYn = useYn;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getRegUser() {
		return regUser;
	}
	public void setRegUser(String regUser) {
		this.regUser = regUser;
	}
	@Override
	public String toString() {
		return "SampleDto [id=" + id + ", subject=" + subject + ", grade=" + grade + ", useYn=" + useYn
				+ ", description=" + description + ", regUser=" + regUser + "]";
	}
	
	
	
}
