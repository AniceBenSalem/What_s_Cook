$(document).ready(function() {
		$('#platdujour').click(function(event){
	  	$.ajax({
	    	url:'http://localhost:8080/v1/cook/RecetteDuJour',
		type: "GET",
		datatype:'APPLICATION_JSON',
		success: function(json){
			$('.panel-body').append('<h2>'+json.TitreRecette+'</h2>'+'<h3>'+json.TxtRecette+'</h3>');
		}})
		return false;})});
