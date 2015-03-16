function inscription(){
	var nom = $('#nom').val();
	var prenom = $('#prenom').val();
	var mail = $('#mail').val();
	var pseudo = $('#pseudo').val()
	var password = $('#password').val();
	var password2 = $('#password2').val();
	

	if(nom === "" || prenom === "" ||mail === "" || pseudo ==="" || password === "" || password2 === ""){
		alert("Champs manquants");
	}else{
		/*var cpt=0;
		for(var i=0;i<mail.length;i++){		mail.length ne marche pas :( 
			if(mail.charAt(i)==='@' && cpt===0){
				cpt++;
			} else if(mail.charAt(i)==="." && cpt===1){
				cpt++;
			}
		}*/
		if (password!== password2){
			alert("Les mots de passe sont differents");
		/*}else if(cpt!=2){			liee a length.mail -> double :(
			alert("Adresse mail non valide");*/
		}else{
			$.ajax({
				type : 'POST',
				//url : ,/* a remplir avec la classe pour inserer dans la bdd *	/			
				datatype : "json",
				data: JSON.stringify({
					"nom" : $('#nom').val(),
					"prenom" : $('#prenom').val(),
					"mail" : $('#mail').val(),
					"pseudo" : $('#pseudo').val(),
					"password" : $('#password').val(),
				}),
	
				success : function(data, textStatus, jqXHR){
					alert("Vous etes inscrit sur What s cooking !!");
					window.location.hrf = "index.html";
				},

				error: function( xhr, status, errorThrown ) {
					alert( "Desole l'inscription a echoue!" );
					console.log( "Cause: " + errorThrown );
					console.log( "Status: " + status );
					console.dir( xhr );
				}	
			});
		}
	}
}

function connexion(){
	var login = $('#login').val()
	var password = $('#password').val();

	if(login==="" || password === ""){
		alert("Champs manquants");
	}else{
		$.ajax({
			type : 'GET',
			//url : ,
			datatype : "json",
			data: JSON.stringify({
				"login" : $('#login').val(),
				"password" : $('#password').val(),
			}),
			success : function(data, textStatus, jqXHR){
				alert("Connexion reussie !!");
				window.location.hrf = "index.html";  // a changer
			},

			error: function( xhr, status, errorThrown ) {
				alert( "Desole la connexion a echoue!" );
				console.log( "Cause: " + errorThrown );
				console.log( "Status: " + status );
				console.dir( xhr );
			}
		});
	}
}

function deconnexion(){
	window.location.href = "index.html";
}



