package entity;

public class Issue {
	String issueId;
	String projectId;
	String seq;
	String name;
	String description;
	String startDate;
	String finishDate;
	String validate;
	
	
	
	public Issue(String issueId, String projectId, String seq, String name,
			String description, String startDate, String finishDate,
			String validate) {
		this.issueId = issueId;
		this.projectId = projectId;
		this.seq = seq;
		this.name = name;
		this.description = description;
		this.startDate = startDate;
		this.finishDate = finishDate;
		this.validate = validate;
	}

	public String getIssueId() {
		return issueId;
	}
	
	public String getProjectId() {
		return projectId;
	}
	
	public String getSeq() {
		return seq;
	}
	
	public String getName() {
		return name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public String getStartDate() {
		return startDate;
	}
	
	public String getFinishDate() {
		return finishDate;
	}
	
	public String getValidate() {
		return validate;
	}
}
