$(document).ready(
	$('#envoyer').click(function(event){
		var titre = $('#titre').val();
		var message = $('#message').val();
		var adresse = $('#adresse').val();
	
		var cpt=0;
		for(var i=0;i<adresse.length;i++){	
			if(adresse.charAt(i)==='@' && cpt===0){
				cpt++;
			} else if(adresse.charAt(i)==="." && cpt===1){
				cpt++;
			}
		}
		
		if(cpt!=2){
			alert("adresse mail non valide");
		}else if(message==""){
			alert("Message vide");
		}else if(titre==""){
			if(!(confirm("Voulez vous envoyer sans objet ?"))){
				alert("pas ok");
			}
		}
	})
)
	
		
	
	