/*将json对象转化成正常的日期格式：年-月-日*/
function getDateFromJson(value) {
	var date;
	if (value.time) {
		date = new Date(value.time);
	} else {
		date = new Date(value);
	}
	DateFormat.Init("Y-m-d", date);
	return DateFormat.Get();
}
/* 将json对象转化成正常的日期格式：年-月-日 时：分：秒 */
function getDateTimeFromJson(value) {
	var date;
	if (value.time) {
		date = new Date(value.time);
	} else {
		date = new Date(value);
	}
	DateFormat.Init("Y-m-d H:i:s", date);
	return DateFormat.Get();
}

/* 表单提交 */
function saveFormData(objId, onSubmitFun, url, successFun) {
	var onSubmit;
	var success;
	if (onSubmitFun) {
		onSubmit = onSubmitFun;
	} else {
		onSubmit = function() {
			return $(this).form('validate');
		};
	}
	if (successFun) {
		success = successFun;
	} else {
		success = function(data) {
			if (data) {
				$.messager.alert('提示信息', '操作成功！');
				$('#win_'+objId).window('close'); // close the dialog
				if($('#tt_'+objId)){
					$('#tt_'+objId).datagrid('reload'); // reload the user data
				}
			} else {
				$.messager.alert('提示信息', '操作失败！');
			}
		};
	}
	$('#fm_'+objId).form('submit', {
		url : url,
		onSubmit : onSubmit,
		success : success
	});
}