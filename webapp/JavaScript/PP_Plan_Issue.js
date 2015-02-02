$(function(){
	console.log("aaa");
	$(".AddIssue").click(function(){
		console.log("bbb");
		$('<li><div class="Issue"><span>Issue</span></div></li>').insertAfter($(".Issue").last());
	});
});