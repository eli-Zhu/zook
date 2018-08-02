$(document).ready(function() {
	$("#dialog-submit").click(function() {
		var url = $("#action").val();
		var data = $("#modalForm").serializeArray();
		$.ajax({
			type : "POST",
			// 提交的网址
			url :  __ctx +"/"+ url,
			// 提交的数据
			data : data,
			// 返回数据的格式
			datatype : "json",
			// 在请求之前调用的函数
			beforeSend : function() {
			},
			// 成功返回之后调用的函数
			success : function(data) {
                 if (data && data.result) {
                     $('#formModal').modal('hide');
                     resourcePage.queryData();
                     toastr.success(data.message, data.errorCode, {timeOut: 3000, positionClass: "toast-top-center"});
                 } else {
                     toastr.error(data.message, data.errorCode, {timeOut: 3000, positionClass: "toast-top-right"});
                 }
             },
             error : function(err) {
                 toastr.error(err, '', {timeOut: 3000, positionClass: "toast-top-right"});
             }
		});
	});
});