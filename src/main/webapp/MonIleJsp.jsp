<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
	
	  <%
	  	 String login = (String) session.getAttribute("proprietaire");
	  	 if(login != null)
         	out.println(login);
	     else{
	     	login = (String) session.getAttribute("identificateur");
	     	out.println(login);
      	 }
      %>
	
	
	
	<div class="container">
	
		<h1> <%out.println(login);%> </h1>
		<table class="table table-bordered" style="background-color:#FFF">
		<tr>
			<th>Entrepots</th>
			<th>Generateurs</th>
			<th>Defenses</th>
			<th>Caserne</th>
		</tr>
		<tr>
			<td><img src="image/shell-icon.png" style="width:25px;height:25px"></img><%request.getAttribute("entrepotcoquillage");
			Integer coquillage = (Integer) session.getAttribute("coquillage");
			out.println(coquillage);
				Integer capacite = (Integer) session.getAttribute("capacite");
			out.println(" / " + capacite);
			
			
			%>
			<%request.getAttribute("entrepotcoquillagemax"); %><br>
			</td>
			<td><img src="image/shell-icon.png" style="width:25px;height:25px"></img>prod coquillage
				<%Integer prod = (Integer) session.getAttribute("production"); out.println(prod);%>
			</td>
			
		
			
			
			<td><img src="image/coconutcanon.png" style="width:25px;height:25px"></img> nb cococanons<br><br>
				<img src="image/tiki.jpeg" style="width:25px;height:25px"></img> nb tiki
			</td>
			<td><img src="image/surfeur-icon.png" style="width:25px;height:25px"></img> nb cromagnons surfeurs<br><br>
				<img src="image/icon-requestuin.png" style="width:25px;height:25px"></img> nb requins
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