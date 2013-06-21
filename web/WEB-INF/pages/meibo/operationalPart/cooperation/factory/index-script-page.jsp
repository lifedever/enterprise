<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script type="text/javascript">
	function addFactory(){
		$('#win_newFactory').window({
			href : '/meibo/operationalPart/cooperation/factory/newFactory.html'
		}).window('open');	
	}
	function editFactory(){
		var row = $('#tt_newFactory').datagrid('getSelected');
		if(row){
			$('#win_newFactory').window({
				href : '/meibo/operationalPart/cooperation/factory/newFactory.html?factoryId='+row.id
			}).window('open');
		}else{
			$.messager.alert('提示信息','请选择操作对象！');
		}
	}
	function delFactory(){
		var row = $('#tt_newFactory').datagrid('getSelected');
		if(row){
			$.messager.confirm('警告', '你确定要删除选择吗?', function(r) {
				if (r) {
				$.post('/meibo/operationalPart/cooperation/factory/delFactory.html?factoryId='+row.id,function(data){
					if(data){
							$.messager.alert('提示信息','操作成功！！');
							$('#tt_newFactory').datagrid('reload');
						}else{
							$.messager.alert('提示信息','操作失败！');
						}
					});
				}
			});
		}else{
			$.messager.alert('提示信息','请选择操作对象！');
		}
	}
	function factoryStarFormatter(value,row){
		var star = '';
		for(var i=0;i<value;i++){
			star+='★';
		}
		return star;
	}
	function selectOk(){
		var row = $('#tt_newFactory').datagrid('getSelected');
		if(row){
			$('#factoryNo').val(row.factoryNo);
			$('#cooperationAddress').val(row.address);
			$('#factoryName').val(row.factoryName);
			$('#factoryProp').val(row.factoryProp);
			$('#contactMan').val(row.contactMan);
			$('#factoryStar').val(row.factoryStar);
			$('#factorySite').val(row.factorySite);
			$('#mobile').val(row.mobile);
			$('#address').val(row.address);
			
			$('#win_listFactory').window('close');
		}else{
			$.messager.alert('提示信息','请选择操作对象！');
		}
	}
</script>
