<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" /> 
		<LINK rel="stylesheet" href="style.css" type="text/css"> 
		<LINK rel="stylesheet" href="css/bootstrap.css" type="text/css"> 
		<link rel="shortcut icon" type="image/x-icon" href="image/favicon.ico" />
		<head><title>Gestion de l'ile</title></head>
	</head>
	<body>
	
	  <% String login = (String) request.getAttribute("login");
         out.println(login);
      %>
	
	
	
	<div class="container">
	
		<h1> <%req.getAttribute("proprietaire")%> </h1>
		<table class="table table-bordered" style="background-color:#FFF">
		<tr>
			<th>Entrepots</th>
			<th>G�n�rateurs</th>
			<th>D�fenses</th>
			<th>Caserne</th>
		</tr>
		<tr>
			<td><img src="image/shell-icon.png" style="width:25px;height:25px"></img><%req.getAttribute("entrepotcoquillage") %>/
			<%req.getAttribute("entrepotcoquillagemax") %><br>
			</td>
			<td><img src="image/shell-icon.png" style="width:25px;height:25px"></img>prod coquillage</td>
			<td><img src="image/coconutcanon.png" style="width:25px;height:25px"></img> nb cococanons<br><br>
				<img src="image/tiki.jpeg" style="width:25px;height:25px"></img> nb tiki
			</td>
			<td><img src="image/surfeur-icon.png" style="width:25px;height:25px"></img> nb cromagnons surfeurs<br><br>
				<img src="image/icon-requin.png" style="width:25px;height:25px"></img> nb requins
			</td>
		</tr>
		<tr>
			<td><img src="image/icon-horloge.png" style="width:25px;height:25px"></img> temps upgrade</td>
			<td><img src="image/icon-horloge.png" style="width:25px;height:25px"></img> temps upgrade</td>
			<td><img src="image/icon-horloge.png" style="width:25px;height:25px"></img> temps upgrade</td>
			<td><img src="image/icon-horloge.png" style="width:25px;height:25px"></img> temps upgrade</td>
		</tr>
		</table>
		<table class="table table-bordered" style="background-color:#FFF">
		</table>
		</div>
	</body>
</html>