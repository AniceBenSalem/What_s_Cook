$(document).ready(function() {
	
	  	$.ajax({
	    	url:'http://localhost:8080/v1/cook/monFrigo',
			type: "GET",
			datatype:'APPLICATION_JSON',
			success: function(json){
				for (var i=0; i< json.Ingredients.length; i++) {
					$('.panel-body').append('<h2>'+json.Ingredients[i].Libelle+'</h2>');
					$('.panel-body').append("<input type=\"button\" value=\"+\" id=\"plus\" onClick=\"increment(1,"+i+")\"><input type=\"text\" id=\"qty"+i+"\">");
					$('.panel-body').append("<input type=\"button\" value=\"-\" id=\"moins\" onClick=\"increment(-1,"+i+")\">");
				}
			}
		})
});
		
var valeur=0;

function increment(increment,i) {
	valeur += increment;
	document.getElementById('qty'+i).value = valeur;
}