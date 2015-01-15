<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" /> 
		<LINK rel="stylesheet" href="style.css" type="text/css"> 
		<link rel="shortcut icon" type="image/x-icon" href="image/favicon.ico" />
		<head><title>Nouvel utilisateur</title></head>
	</head>
	<body>
		<form method="post" action="../servlet/NewUser">
			<div class=formulaire>
				<fieldset class=fieldset style="width:40%">
					<legend class=legend>Créer votre nouveau compte</legend>
					<label for="login">Login <span class="requis">*</span></label>
					&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
					<input class="newUserForm" type="text" id="login" name="newLogin" required size="20" maxlength="20" />
					<br>
					<label for="password">Password <span class="requis">*</span></label>
					&nbsp&nbsp&nbsp&nbsp
					<input class="newUserForm" type="text" id="password" name="newPassword" required size="20" maxlength="20" />
					<br>
					<label for="password1">Confirmation 
					&nbsp&nbsp&nbsp
					<input class="newUserForm" type="text" id="password1" name="newPassword1" required oninput="check(this)" size="20" maxlength="20"/>
					<br>mot de passe <span class="requis">*</span></label>
					<br>
					<label for="mail">Adresse Mail <span class="requis">*</span></label>
					<input class="newUserForm" type="text" id="mail" name="newMail" required size="20" maxlength="20" />
					<br><br>
					<input type="submit" value="Enregistrer" />
				</fieldset>
			</div>
		</form>
		<script>
			function check(input) {
			  if (input.value != document.getElementById('password').value) {
				input.setCustomValidity('Les deux mots de passe ne sont pas identique');
			  } else {
				// input is valid -- reset the error message
				input.setCustomValidity('bon');
			  }
			}
		</script>
	</body>
</html>