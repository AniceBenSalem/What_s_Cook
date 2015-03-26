$(document).ready(
	$('#changePassword').click(function(event){
		var oldPassword = $('#oldPassword').val();
		var newPassword = $('#newPassword').val();
		var newPasswordConf = $('#newPasswordConf').val();
		var login = readCookie("login");
		
		if(oldPassword == "" || newPassword=="" || newPasswordConf==""){
			alert("Champs manquants !");
		}else if(newPassword != newPasswordConf){
			alert("Les mots de passe sont differents !");
		}else{
			$.ajax({
				type : 'GET',
				url : "http://localhost:8080/v1/modifierProfil/changePassword/"+login+"/"+oldPassword+"/"+newPassword,	
				datatype : "json",
				data: JSON.stringify({
					"login" : login,
					"oldPassword" : oldPassword,
					"newPassword" : newPassword,
				}),
					
				success : function(json){
					if(json.cp == true){
						alert("Votre mot de passe a ete modifie avec succes !");
					}else{
						alert("Desole le changement de votre mot de passe a echoue !");
					}
				}				
			});
		}
	}),
	
	/*$('#consulterPost').click(function(event){
		var login = readCookie("login");
		$.ajax({
			type : 'GET',
			url : "http://localhost:8080/v1/cook/getFavoris/"+login,,
			datatype : "json",
			data : JSON.stringify({
				"login" : login,
			}),
		
			success : function(json){
				for (var i=0; i< json.Favoris.length; i++) {
					$('#liste').append('<h2>'+json.Favoris[i].titre+'</h2>'+'<h3>'+json.Favoris[i].recette+'</h3><hr>');
				}
			}
		});
	}),
	
	$('#consulterRecettes').click(function(event){
		var login = readCookie("login");
		$.ajax({
			type : 'GET',
			url : "http://localhost:8080/v1/modifierProfil/consulterRecettes/"+login,
			datatype : "json",
			data : JSON.stringify({
				"login" : login,
			}),
		
			success : function(json){
				if(json.cr == true){
					$('#liste').append(
				}
			}
		});
	}),*/
	
	$('#supprimerCompte').click(function(event){
		var login = readCookie("login");
		$.ajax({
			type : 'DELETE',
			url : "http://localhost:8080/v1/modifierProfil/supprimerCompte/"+login,
			datatype : "json",
			data : JSON.stringify({
				"login" : login,
			}),
			
			success : function(json){
				if(json.sc == true){
					alert("Votre compte a ete supprime :( nous esperons vous revoir bientot");
					deconnexion();
				}else{
					alert("Desole la suppression a echoue !");
				}
			}				
		});
	}),
	
	$('#changeImage').click(function(event){
		/*alert($('#source').val());*/
		$('#imageProfil').val(''+$('#source').val());
		/*$('#source').val("");*/
	
	})
);