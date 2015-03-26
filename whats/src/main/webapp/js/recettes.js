var texte = "";
var titre = "";
var recette = "";
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
			$('.panel-body > button').remove();
			
			for (var i= 0; i< json.Recettes.length; i++){
				$('.panel-body').append('<h2>'+json.Recettes[i].TitreRecette+'</h2>'+'<h3>'+json.Recettes[i].TxtRecette+'</h3>');
				if(readCookie("login") !== null){
					var prout = "ajouterFavoris(\""+json.Recettes[i].TxtRecette+"\")";
					console.log(prout);
					//$('.panel-body').append("<center><button id=\"partager"+i+"\" class=\"btn btn-primary\"  onclick=\"partagerRecette('"+titre.toString()+"')\">Partager</button>  <button id=\"favoris"+i+"\" class=\"btn btn-danger\" onclick=\"ajouterFavoris('"+titre.toString()+"','"+recette.toString()+"')\">Favoris</button></center>");
					$('.panel-body').append("<center><button id='partager"+i+"' class='btn btn-primary'  onclick='partagerRecette(\""+titre+"\")'>Partager</button>  <button id='favoris"+i+"' class='btn btn-danger' onclick ='ajouterFavoris("+json+")'	 >Favoris</button></center>");
					
					$('.panel-body').append('<hr>');
				}
				
			} 
		 },
		 error:function(msg){
                            console.log( "Error !: " + msg   );
                 }
		})}
		return false;})
);


function ajouterFavoris(json){
	var titre = json.Recettes[i].TitreRecette;
	var recette = json.Recettes[i].TxtRecette;
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