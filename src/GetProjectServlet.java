

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import entity.Project;

/**
 * Servlet implementation class GetProjectServlet
 */
@WebServlet("/GetProjectServlet")
public class GetProjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public GetProjectServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uId = request.getParameter("userId");
		System.out.println("uId: " + uId);
//		String uId = "1";
		ProjectDao projectDao = new ProjectDao();
		ArrayList<Project> projectList = projectDao.getProject(uId);
		
		if(projectList == null)
			return;
		
		Gson gson = new Gson();
		String jsonData = gson.toJson(projectList);
		response.setContentType("application/json;charset=UTF-8"); 
		PrintWriter out = response.getWriter();
		out.print(jsonData);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
