$(document).ready(
	$('#envoyer').click(function(event){
		var adresse = $('#adresse').val();
		var titre = $('#titre').val();
		var message = $('#message').val();
	
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
		}
		if(message==""){
			alert("Message vide");
		}
		if(titre=="" && confirm("Voulez vous envoyer sans objet ?")){
			$.ajax({
				type : 'GET',
				url : "http://localhost:8080/v1/poster/"+adresse+"/"+message,	
				datatype : "json",
				data: JSON.stringify({
					"adresse" : adresse,
					"titre" : titre,
					"message" : message,
				}),
					
				success : function(json){
					if(json.b == true) {
						alert("Message envoye");
						//document.location = "index.html";
					} else {
						alert("Message non envoye, desole");
					}
				}				
			})
		}else if(titre!=""){
			$.ajax({
				type : 'GET',
				url : "http://localhost:8080/v1/poster/"+adresse+"/"+titre+"/"+message,	
				datatype : "json",
				data: JSON.stringify({
					"adresse" : adresse,
					"titre" : titre,
					"message" : message,
				}),
					
				success : function(json){
					if(json.b == true) {
						alert("Message envoye");
						//document.location = "index.html";
					} else {
						alert("Message non envoye, desole");
					}
				}				
			})}
	})
);
	
		
	
	