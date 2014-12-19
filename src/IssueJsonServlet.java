

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import entity.Issue;

/**
 * Servlet implementation class IssueJsonServlet
 */
@WebServlet("/IssueJsonServlet")
public class IssueJsonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IssueJsonServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pId = "1";
		IssueDao issueDao = new IssueDao();
		ArrayList<Issue> issueList = issueDao.getIssue(pId);
		
		if(issueList == null)
			return;
		
		Gson gson = new Gson();
		String jsonData = gson.toJson(issueList);
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
