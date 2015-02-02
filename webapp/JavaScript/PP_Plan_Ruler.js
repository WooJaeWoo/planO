var canvas = document.getElementById("DateRuler");
var ctx = canvas.getContext("2d");

var daySize = 30;
for (var i = 0; i < canvas.width; i += daySize)
{
	var y = 0;
	if (i / (daySize * 7) == parseInt(i / (daySize * 7)))
	{
		y = 10;
		ctx.strokeStyle = "#000000";
		ctx.lineWidth = 3;
	}
	else
	{
		y = 20;
		ctx.strokeStyle = "#555555";
		ctx.lineWidth = 0.3;
	}
	ctx.beginPath();
	ctx.moveTo(i + 0.5, y);
	ctx.lineTo(i + 0.5, 40);
	ctx.stroke();
}

