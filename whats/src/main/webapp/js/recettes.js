$(document).ready(
		$('#BoutonDeRecherche').click(function(event){
		if( $('#ChampDeRecherche').val() != ""){
	  	$.ajax({
	    	url:'http://localhost:8080/v1/cook/getRecettes/'+$('#ChampDeRecherche').val()+'',
		/*url:'http://localhost:8080/v1/cook/getRecettes/rhubarbe',*/
		type: "GET",
		datatype:'APPLICATION_JSON',
		success: function(json){
			console.log("c est bon !!");
			$('.panel-body > h2').hide();
			$('.panel-body > h3').hide();
			$('.panel-body > hr').hide();
			for (var i= 0; i< json.Recettes.length; i++){
				$('.panel-body').append('<h2>'+json.Recettes[i].TitreRecette+'</h2>'+'<h3>'+json.Recettes[i].TxtRecette+'</h3>');
               			$('.panel-body').append('<hr>');	
			} 
		 },
		 error:function(msg){
                            console.log( "Error !: " + msg   );
                  }
		})}return false;}));
