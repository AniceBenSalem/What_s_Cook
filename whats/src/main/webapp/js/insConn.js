function inscription(){
	var mail = $('#mail').val();
	var login = $('#login').val()
	var password = $('#password').val();
	var password2 = $('#password2').val();
	

	if(mail === "" || login ==="" || password === "" || password2 === ""){
		alert("Champs manquants");
	}else{
		var cpt=0;
		for(var i=0;i<mail.length;i++){	
			if(mail.charAt(i)==='@' && cpt===0){
				cpt++;
			} else if(mail.charAt(i)==="." && cpt===1){
				cpt++;
			}
		}
		if (password!== password2){
			alert("Les mots de passe sont differents");
		}else if(cpt!=2){	
			alert("Adresse mail non valide");
		}else{
			$.ajax({
				type : 'POST',
				url : "http://localhost:8080/v1/inscription/"+mail+"/"+login+"/"+password,	
				datatype : "json",
				data: JSON.stringify({
					"mail" : mail,
					"login" : login,
					"password" : password,
					"password2" : password2
				}),
	
				success : function(json){
					if(json.bouletbill == "true")
						alert("Vous etes inscrit sur What s cooking !!");
				},

				error: function( xhr, status, errorThrown ) {
					alert( "Desole l'inscription a echoue!" );
				}	
			});
		}
	}
}

function connexion() {
	var login = $('#login').val()
	var password = $('#password').val();
	if(login==="" || password === ""){
		alert("Champs manquants");
	}else{
		$.ajax({
			type : 'GET',
			contentType : 'application/json',
			url : "http://localhost:8080/v1/connexion/"+$('#login').val()+"/"+$('#password').val(),
			datatype:'APPLICATION_JSON',
			success: function(json){
				if(json.boulet1 == "true")
					alert("Connexion reussie !!");
			},

			error : function(jqXHR, textStatus, errorThrown) {
				console.log(jqXHR);
				console.log(textStatus);
				console.log(errorThrown);
				alert( "Desole la connexion a echoue!" );
			}
		});
	}
}

function deconnexion(){
	window.location.href = "index.html";
}



