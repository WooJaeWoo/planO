package entity;


public class Project {
	String projectId;
	String name;
	String description;
	String startDate;
	String finishDate;
	String validate;
	
	
	
	public Project(String projectId, String name, String description,
			String startDate, String finishDate, String validate) {
		this.projectId = projectId;
		this.name = name;
		this.description = description;
		this.startDate = startDate;
		this.finishDate = finishDate;
		this.validate = validate;
	}

	public String getProjectId() {
		return projectId;
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
