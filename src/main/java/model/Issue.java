package model;

import java.util.Date;

public class Issue {
	long issueId;
	long projectId;
	int seq;
	String name;
	String description;
	Date startDate;
	Date finishDate;
	String validate;
	
	public Issue(long issueId, long projectId, int seq, String name,
			String description, Date startDate, Date finishDate, String validate) {
		super();
		this.issueId = issueId;
		this.projectId = projectId;
		this.seq = seq;
		this.name = name;
		this.description = description;
		this.startDate = startDate;
		this.finishDate = finishDate;
		this.validate = validate;
	}

	public long getIssueId() {
		return issueId;
	}

	public long getProjectId() {
		return projectId;
	}

	public int getSeq() {
		return seq;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public Date getStartDate() {
		return startDate;
	}

	public Date getFinishDate() {
		return finishDate;
	}

	public String getValidate() {
		return validate;
	}


}
