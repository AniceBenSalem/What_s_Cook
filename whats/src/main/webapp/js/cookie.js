function createCookie(sName, sValue, time) {
	var today = new Date(), expires = new Date();
	expires.setTime(today.getTime() + (time*30*60*1000));
	document.cookie = sName + "=" + encodeURIComponent(sValue) + ";expires=" + expires.toGMTString();
}

function readCookie(name) {
	var nameEQ = name + "=";
	var ca = document.cookie.split(';');
	for(var i=0;i < ca.length;i++) {
		var c = ca[i];
		while (c.charAt(0)==' ') c = c.substring(1,c.length);
		if (c.indexOf(nameEQ) == 0) return c.substring(nameEQ.length,c.length);
	}
	return null;
}

function deconnexion(){
	createCookie("login",null,-1);
	window.location.href = "index.html";
}

var nom = readCookie("login");
	if(nom !== null) {
		$('#lol').append('<ul class="nav navbar-nav"><li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown">'+nom+'<span class="caret"></span></a><ul class="dropdown-menu" role="menu"><li><a href="evenement.html">Evenements</a></li><li><a href="monFrigo.html" id="monFrigo">Mon Frigo</a><li><a onClick="deconnexion()">Se deconnecter</a></li></ul></li></ul>');
	} else {
		$('#lol').append('<li><a href="inscription.html">S\'inscrire</a></li><li><a href="connexion.html">Se connecter</a></li>');
		$('#post').hide();
		$('#partager').hide();
	}