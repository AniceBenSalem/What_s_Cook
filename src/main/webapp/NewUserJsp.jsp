<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" /> 
		<LINK rel="stylesheet" href="style.css" type="text/css"> 
		<link rel="icon" type="image/png" href="IMG/favicon.png" />
		<head><title>Nouvel utilisateur</title></head>
	</head>
	<body>
		<form method="post" action="../servlet/NewUser">
			<fieldset>
				<legend>Créer votre nouveau compte</legend> 
				
				<label for="login">Login <span class="requis">*</span></label>
				<input class="newUserForm" type="text" id="login" name="newLogin" required size="20" maxlength="20" />
				<!--<OPTION VALUE="choix1" <c:if test="${param.select == 'choix1'}">selected</c:if> > choix 1</OPTION>-->
				<br>
				<label for="password">Password <span class="requis">*</span></label>
				<input class="newUserForm" type="text" id="password" name="newPassword" required size="20" maxlength="20" />
				<br>
				<label for="password1">Confirmation password <span class="requis">*</span></label>
				<input class="newUserForm" type="text" id="password1" name="newPassword1" required oninput="check(this)" size="20" maxlength="20" />	
				<br>
				<label for="mail">Adresse Mail <span class="requis">*</span></label>
				<input class="newUserForm" type="text" id="mail" name="newMail" required size="20" maxlength="20" />
				<br>
				<label for="prenom">Prenom <span class="requis">*</span></label>
				<input class="newUserForm" type="text" id="prenom" name="newPrenom" required size="20" maxlength="20" />
				<br>
				<label for="nom">Nom <span class="requis">*</span></label>
				<input class="newUserForm" type="text" id="nom" name="newNom" required size="20" maxlength="20" />
				<br>
				<label for="tel">Telephone <span class="requis">*</span></label>
				<input class="newUserForm" type="number" id="tel" name="newAge" required size="20" maxlength="20" />
				<br><br>
				<input type="submit" value="Enregistrer" />
			</fieldset>
		</form>
		<script>
			function check(input) {
			  if (input.value != document.getElementById('password').value) {
				input.setCustomValidity('Les deux mots de passe n\'est pas identique');
			  } else {
				// input is valid -- reset the error message
				input.setCustomValidity('bon');
			  }
			}
		</script>
	</body>
</html>