package model;

import java.util.Date;


public class Project {
	long projectId;
	String name;
	String description;
	Date startDate;
	Date finishDate;
	String validate;
	
	public Project(long projectId, String name, String description,
			Date startDate, Date finishDate, String validate) {
		this.projectId = projectId;
		this.name = name;
		this.description = description;
		this.startDate = startDate;
		this.finishDate = finishDate;
		this.validate = validate;
	}


	public long getProjectId() {
		return projectId;
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
