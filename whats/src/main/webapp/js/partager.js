$(document).ready(
	$('#partager').click(function(event){
		var post = $('#post').val();
	
		if(message !== ""){
			$.ajax({
				//url:'http://localhost:8080/index.html,
				type: "POST",
				datatype: 'APPLICATION_JSON',
				success: function(json){
					$('#share').append("<div class=\"row\"><br><div class=\"col-md-2 col-sm-3 text-center\"><a class=\"story-title\" href=\"#\"><img alt=\"\" src=\"http://api.randomuser.me/portraits/thumb/women/56.jpg\" style=\"width:100px;height:100px\" class=\"img-circle\"></a></div><div class=\"col-md-10 col-sm-9\"><h3>"+message+"</h3><div class=\"row\"><div class=\"col-xs-9\"><small style=\"font-family:courier,'new courier';\" class=\"text-muted\">2 hours ago  • <a href=\"#\" class=\"text-muted\">Read More</a></small></h4></div><div class=\"col-xs-3\"></div></div><br><br></div></div><hr>");
				},
				error: function(msg){
					console.log("Error !:"+msg);
				}
			})
		}
	})
);
	
	