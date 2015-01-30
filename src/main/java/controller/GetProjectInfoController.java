package controller;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.IssueDao;
import dao.ProjectDao;
import model.Issue;
import model.Project;

import com.google.gson.Gson;


/**
 * Servlet implementation class GetProjectInfoController
 */
@WebServlet("/GetProjectInfoController")
public class GetProjectInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetProjectInfoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String projectId = request.getParameter("projectId");
		int projectId = 1;
		ProjectDao projectDao = new ProjectDao();
		Project project = projectDao.getProjectInfo(projectId);
		
		IssueDao issueDao = new IssueDao();
		ArrayList<Issue> issueList = issueDao.getIssue(projectId);
		
		if(project == null)
			return;
		
		Gson gson = new Gson();
		String jsonProjectData = gson.toJson(project);
		String jsonIssueData = gson.toJson(issueList);
		response.setContentType("application/json;charset=UTF-8"); 
		PrintWriter out = response.getWriter();
		out.print("[" + jsonProjectData + ", " + jsonIssueData + "]");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
