function publier() {
		var post = $('#post').val();
		var login = readCookie("login");	
	
		if(post !== ""){
			$.ajax({
	    		url:"http://localhost:8080/v1/post/ajouterPost/"+login+"/"+post,
				type: "GET",
				datatype:'APPLICATION_JSON',
				success: function(json) {
					$('#post').val("");
					document.location = 'index.html';
				},
				error: function(msg){
					console.log("Error !:"+msg);
				}
			});
		} else {
			alert("Veuillez entrer un message");
		}
}

function partager() {
	  	$.ajax({
	    	url:'http://localhost:8080/v1/post/getPost',
			type: "GET",
			datatype:'APPLICATION_JSON',
			success: function(json){
				for (var i=0; i< json.Post.length; i++) {
					$('#partagerRecette').prepend("<div class=\"row\"><br><div class=\"col-md-2 col-sm-3 text-center\"><a class=\"story-title\" href=\"#\"><img alt=\"\" src=\"images/profil.jpg\" style=\"width:100px;height:100px\" class=\"img-circle\"></a></div><div class=\"col-md-10 col-sm-9\"><h3>"+json.Post[i].message+"</h3><div class=\"row\"><div class=\"col-xs-9\"><small style=\"font-family:courier,'new courier';\" class=\"text-muted\">De "+json.Post[i].login+"</small></h4></div><div class=\"col-xs-3\"></div></div><br><br></div></div><hr>");
				}
			},
			error:function(msg){
            	console.log( "Error !: " + msg   );
            }
		});
}
	
	