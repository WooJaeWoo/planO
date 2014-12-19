window.addEventListener('load', GetProject, false);

var sTemplate =
"<li>"
+	"<a>
+   "<div class='ProjectCard'>"
+		"<span><%=name%></span>"
+   "</div>"
+	"</a>"
+"</li>"

function MakeProjectCard(template, projectList)
{
	var result = [];
	projectList.forEach(function(v,i,o) {
		var tempstr = template;
		tempstr =
		template.replace("<%=name%>", v.projectName);	
		result.push(tempstr);
	});
	result = result.join("");
	return result;
}

function GetProject()
{
	var url = "http://localhost:8000/GetProjectServlet";
	var request = new XMLHttpRequest();
	request.open("GET", url, true);
	request.send("1");
	request.onreadystatechange = function()
	{
		if (request.readyState === 4 && request.status === 200)
		{
			var projectData = request.responseText;
			projectData = JSON.parse(projectData);
			var projectList = document.querySelector('.ProjecList ul');
			projectList.innerHTML += MakeProjectCard(sTemplate, projectList);
		}
	};
}