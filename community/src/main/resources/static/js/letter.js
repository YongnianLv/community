$(function(){
	$("#sendBtn").click(send_letter);
	$(".close").click(delete_msg);
});


function send_letter() {
	$("#sendModal").modal("hide");
	//发送AJAX请求之前，将CSRF的令牌设置到消息的请求头中
	// var token = $("meta[name='_csrf']").attr("content");
	// var header = $("meta[name='_csrf_header']").attr("content");
	// $(document).ajaxSend(function (e,xhr,options){
	// 	//xhr发送异步请求的核心对象
	// 	xhr.setRequestHeader(header,token);
	//
	// });

	var toName = $("#recipient-name").val();
	var content = $("#message-text").val();
	$.post(
		CONTEXT_PATH + "/letter/send",
		{"toName":toName,"content":content},
		function(data) {
			data = $.parseJSON(data);
			if (data.code == 0) {
				$("#hintBody").text("发送成功");
			} else {
				$("#hintBody").text(data.msg);
			}

			$("#hintModal").modal("show");
			setTimeout(function () {
				$("#hintModal").modal("hide");
				location.reload();
			}, 2000);
		}
	);

}

function delete_msg() {
	// TODO 删除数据
	$(this).parents(".media").remove();
}