window.addEventListener('load', GetProject, false);

var sTemplate =
"<li>"
+	"<a>"
+   "<div class='ProjectCard'>"
+		"<span><%=name%></span>"
+   "</div>"
+	"</a>"
+"</li>";

function MakeProjectCard(template, projectList)
{
	var result = [];
	projectList.forEach(function(v,i,o) {
		var tempstr = template;
		tempstr =
		template.replace("<%=name%>", v.name);	
		result.push(tempstr);
	});
	result = result.join("");
	return result;
}

function GetProject()
{
	var url = "http://localhost:8080/GetProjectServlet";
	var request = new XMLHttpRequest();
	request.open("GET", url+"?userId=1", true);
	request.send(null);
	request.onreadystatechange = function()
	{
		if (request.readyState === 4 && request.status === 200)
		{
			var projectData = request.responseText;
			projectData = JSON.parse(projectData);
			console.log(projectData);
			var projectList = document.querySelector('.ProjectList ul');
			projectList.innerHTML += MakeProjectCard(sTemplate, projectData);
		}
	};
}

load: function() {
	$.ajax({
		type: "get",
		url: "getProjectInfoController",
		success: function(data) {
			console.log(data);
		}
	})
}