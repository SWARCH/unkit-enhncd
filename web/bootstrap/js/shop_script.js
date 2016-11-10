

window.updateObject = function(object){
	//console.log(object);
	var object_id = $(object).closest('tr').find('.goods_id').val();
	var amount = $(object).closest('tr').find('.amount').val();
	alert("ID : "+object_id+" Amount :"+amount);
}

window.deleteObject = function(object){
	var object_id = $(object).closest('tr').find('.goods_id').val();
	alert("ID : "+object_id);
}