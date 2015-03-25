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


function partagerRecette(recette) {
	document.location = 'index.html';
}
