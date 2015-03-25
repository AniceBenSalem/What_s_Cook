var texte = "";
$(document).ready(
		$('#BoutonDeRecherche').click(function(event){
		
		if( $('#ChampDeRecherche').val() != ""  && texte !== $('#ChampDeRecherche').val() ){
		texte = $('#ChampDeRecherche').val();
	  	$.ajax({
	    	url:'http://localhost:8080/v1/cook/getRecettes/'+$('#ChampDeRecherche').val()+'',
		type: "GET",
		datatype:'APPLICATION_JSON',
		success: function(json){
			$('.panel-body > h2').remove();
			$('.panel-body > h3').remove();
			$('.panel-body > hr').remove();
			
			for (var i= 0; i< json.Recettes.length; i++){
				$('.panel-body').append('<h2>'+json.Recettes[i].TitreRecette+'</h2>'+'<h3>'+json.Recettes[i].TxtRecette+'</h3>');
				if(readCookie("login") !== null)
					$('.panel-body').append("<center><button id=\"partager"+i+"\" class=\"btn btn-primary\" onclick=\"partagerRecette('"+json.Recettes[i].TitreRecette+"')\">Partager</button>          <button id=\"favoris"+i+"\" class=\"btn btn-danger\" onclick=\"ajouterFavoris('"+json.Recettes[i].TitreRecette+"','"+json.Recettes[i].TxtRecette+"')\">Favoris</button></center>");
               	$('.panel-body').append('<hr>');	
				
			} 
		 },
		 error:function(msg){
                            console.log( "Error !: " + msg   );
                 }
		})}
		return false;})
);


function ajouterFavoris(titre,recette) {
	var login = readCookie("login");
	$.ajax({
	    url:"http://localhost:8080/v1/cook/ajouterFavoris/"+login+"/"+titre+"/"+recette,
		type: "GET",
		datatype:'APPLICATION_JSON',
		success: function(json) {
		},
	});
}


function partagerRecette(titre) {
	var login = readCookie("login");
	var message = "Je vous propose cette recette : "+titre;
	$.ajax({
	    url:"http://localhost:8080/v1/post/ajouterPost/"+login+"/"+message,
		type: "GET",
		datatype:'APPLICATION_JSON',
		success: function(json) {
		},
	});
}