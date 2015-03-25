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
				/*$('.panel-body').append("<button id=\"partager"+i+"\" class=\"btn btn-primary\" onClick=\"partagerRecette("+json.Recettes[i].txtRecette+")\">Partager</button>*/

               			$('.panel-body').append('<hr>');	
				
			} 
		 },
		 error:function(msg){
                            console.log( "Error !: " + msg   );
                 }
		})}
		return false;})
);


function partagerRecette(titre) {
	document.location = 'index.html';
	//$('#partagerRecette').append("<div class=\"row\"><br><div class=\"col-md-2 col-sm-3 text-center\"><a class=\"story-title\" href=\"#\"><img alt=\"\" src=\"http://api.randomuser.me/portraits/thumb/women/56.jpg\" style=\"width:100px;height:100px\" class=\"img-circle\"></a></div><div class=\"col-md-10 col-sm-9\"><h3>"+readCookie('login')+" vous propose cette recette : "+titre+"</h3> <div class=\"row\"><div class=\"col-xs-9\"><small style=\"font-family:courier,'new courier';\" class=\"text-muted\">Il y a quelques secondes • <small class=\"text-muted\">"+readCookie('login')+"</small></small></h4></div><div class=\"col-xs-3\"></div></div><br><br></div></div><hr>");
}

