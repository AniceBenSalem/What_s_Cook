$(document).ready(function() {
	  	var login = readCookie("login");	
	  	$.ajax({
	    	url:"http://localhost:8080/v1/cook/getFavoris/"+login,
			type: "GET",
			datatype:'APPLICATION_JSON',
			success: function(json){
				for (var i=0; i< json.Favoris.length; i++) {
					$('.panel-body').append('<h2>'+json.Favoris[i].titre+'</h2>'+'<h3>'+json.Favoris[i].recette+'</h3><hr>');
				}
			},
			error:function(msg){
            	console.log( "Error !: " + msg   );
            }
            })
});