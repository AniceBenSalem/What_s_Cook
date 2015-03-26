$(document).ready(function() {
	  	$.ajax({
	    	url:'http://localhost:8080/v1/cook/RecetteDuJour',
			type: "GET",
			datatype:'APPLICATION_JSON',
			success: function(json){
				/*var titre = replaceAll("'", " ",json.TitreRecette);
				var recette = replaceAll("'"," ",json.TxtRecette);*/
				$('.panel-body').append('<h2>'+json.TitreRecette+'</h2>'+'<h3>'+json.TxtRecette+'</h3>');
				/*$('.panel-body').append("<center><button id='partager' class='btn btn-primary'  onclick='partagerRecette(\""+titre+"\")'>Partager</button>  <button id='favoris' class='btn btn-danger' onclick ='ajouterFavoris("+titre+","+recette+")'	 >Favoris</button></center>");
			*/
			}
		});
})
			
/*	function ajouterFavoris(titre,recette){
		console.log(titre);
		console.log(recette);
		var login = readCookie("login");
		if(titre != "" && recette != ""){
			$.ajax({
	    		url:"http://localhost:8080/v1/cook/ajouterFavoris/"+login+"/"+titre+"/"+recette,
				type: "GET",
				datatype:'APPLICATION_JSON',
				success: function(json) {
					console.log("coucou");
				}
			});
		}
	}


function partagerRecette(titre) {
	var login = readCookie("login");
	var message = "Je vous propose cette recette : "+titre;
	$.ajax({
	    url:"http://localhost:8080/v1/post/ajouterPost/"+login+"/"+message,
		type: "GET",
		datatype:'APPLICATION_JSON',
		success: function(json) {
			console.log("coucou");
		}
	});
}

function replaceAll(find, replace, str) {
  return str.replace(new RegExp(find, 'g'), replace);
}
*/