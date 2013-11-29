//自定义去除首尾空格
function trim_yxy(str) {
	if(str!=null&&str!='undefind'){
		return str.replace(/(^\s*)|(\s*$)/g, "");
		}
} 
//ztree 树初始化配置
var setting = {
			async: {
				enable: true,
				url: getUrl,
				dataFilter: ajaxDataFilter
			},
			check: {
				enable: false
			},
			data: {
				simpleData: {
					enable: true
				}
			},
			view: {
				expandSpeed: "",
				fontCss: getFontCss,
				selectedMulti: false
			},
			callback: {
				beforeExpand: beforeExpand,
				onAsyncSuccess: onAsyncSuccess,
				onAsyncError: onAsyncError,
				onClick: zTreeOnClick,
				beforeDrop: beforeDrop
			},
			edit: {
				enable: edit_state_y,
				showRemoveBtn: false,
				showRenameBtn: false,
				drag: {
					autoExpandTrigger: true,
					prev: true,
					next: true,
					inner:true
				}
			}
		};
		var zNodes;
 		// perTime：自动执行ajax的时间间隔；perCount：每次ajax加载的节点数量；
		var log, className = "dark", perCount = 100, perTime = 100;   //用于计算时间
		
		/*
			ajax提交的url与参数
		*/
		function getUrl(treeId, treeNode) {
		 	var curCount = (treeNode.children) ? treeNode.children.length : 0;  //若节点存在子节点，则当前数量为子节点数，否则为0；
		 	var getCount = (curCount + perCount) > treeNode.count ? (treeNode.count - curCount) : perCount;//若当前节点数加上每次可加载的数大于子节点总数，则加载剩下的节点，否则加载可加载的数量。
			var param = "pid="+treeNode.id+"&count="+getCount;
 			return url_cur+"/api/auth/auth_outputtree.action?"+ param;
		}
		/*
			节点被点击后，且节点被展开之前执行。
		*/
		function beforeExpand(treeId, treeNode) {
			if (!treeNode.isAjaxing) {				 
				ajaxGetNodes(treeNode, "refresh");
				return true;
			} else {
				alert("zTree 正在下载数据中，请稍后展开节点。。。");
				return false;
			}
 
		}
		/*
			异步成功后执行
		*/
		function onAsyncSuccess(event, treeId, treeNode, msg) {
			if (!msg || msg.length == 0) {
				return;
			}
			var zTree = $.fn.zTree.getZTreeObj("treeDemo"),
			totalCount = treeNode.count;
			if (treeNode.children.length < totalCount) { //当加载的节点数小于总节点数时，定时分批加载。
				setTimeout(function() {ajaxGetNodes(treeNode);}, perTime);  
			} else {//否则，更新所有节点。
				treeNode.icon = "";
				zTree.updateNode(treeNode);              //更新树节点
				zTree.selectNode(treeNode.children[0]);  //确定选中项。 
			}
		 
		}
		/*
			异步失败后执行
		*/
		function onAsyncError(event, treeId, treeNode, XMLHttpRequest, textStatus, errorThrown) {
			var zTree = $.fn.zTree.getZTreeObj("treeDemo");
			alert("异步获取数据出现异常。");
			treeNode.icon = "";
			zTree.updateNode(treeNode);
		}
		/*
			异步获取所有节点
		*/
		function ajaxGetNodes(treeNode, reloadType) {
			var zTree = $.fn.zTree.getZTreeObj("treeDemo");
			if (reloadType == "refresh") {
				treeNode.icon = "../../css/zTreeStyle/img/loading.gif";
				zTree.updateNode(treeNode);
			}
			zTree.reAsyncChildNodes(treeNode, reloadType, true); 
		}
 
		/*
			执行zTree封装的异步加载后，对返回数据的过滤函数。
		*/
		function ajaxDataFilter(treeId, parentNode, childNodes) {	
		if(childNodes)	 {
				return childNodes ;  //获取返回值
			}
			else{
				alert("子节点数据格式不正确。");		 
			}
		    return childNodes;
		};
 
	
	//权限移动
		function beforeDrop(treeId, treeNodes, targetNode, moveType) {
			treeNode = treeNodes[0];
			var selectId = treeNode.id;
			if(targetNode != null){
				targetId = targetNode.id;
			}else{
				//targetId = '';
				alert("请选择目标节点！")
				return false;
			}
			var param = "select_node_id="+selectId+"&target_node_id="+targetId;
			var url = url_cur+"/api/auth/auth_ajaxmove.action?"+param;	
			
			if (confirm("确认移动数据？")) {					
			    $.post(url, { Action: "post"}, 
					function (data){
						var obj = eval( data);
						var msg = obj[0].info;
						if(msg !=null && msg != 'undefined' && msg == 'true' ){
							alert("移动成功！");
						}else if(msg !=null && msg != 'undefined' && msg == 'false_3'){
							alert("移动失败！请确认大类型权限不能移动至小类型权限下！");
						}
						else{
							alert("移动失败！")
						}
					}
				);
			}
			
		}
 
	 
		/*
			ztree点击事件
		*/
	 	function zTreeOnClick(event, treeId, treeNode) {	  
			$("#select_node_id").attr("value",treeNode.id )
			$("#select_node_name").attr("value",treeNode.name )
			$("#type_contrl").show();
		};
		
		/*
		  查询节点
		*/  
		var lastValue = "", nodeList = [], fontCss = {};
		 	
			function blurKey(e) {
			if (key.get(0).value === "") {
				key.addClass("empty");
			}
		}
		 	function searchNode(e) {
			var zTree = $.fn.zTree.getZTreeObj("treeDemo");
			var value = $.trim(key.get(0).value);
			var keyType = "name";
			
			if (key.hasClass("empty")) {
				value = "";
			}
			//if (lastValue === value) return;

			updateNodes(false);
			lastValue = value;
			if (value === "") return;
			var result = "";
		    nodeList = zTree.getNodesByParamFuzzy(keyType, value);
			updateNodes(true);

		}
		function updateNodes(highlight) {
			var zTree = $.fn.zTree.getZTreeObj("treeDemo");
			for( var i=0, l=nodeList.length; i<l; i++) {
				nodeList[i].highlight = highlight;
				zTree.updateNode(nodeList[i]);
			}
		}
		function getFontCss(treeId, treeNode) {
			return (!!treeNode.highlight) ? {color:"#A60000", "font-weight":"bold"} : {color:"#333", "font-weight":"normal"};
		}
		
		/*展示编辑热点样式*/
		var newCount = 1;
		 
		var key;
$(document).ready(function(){
		 //jquery start
			 
	  			 
			//初始化树		
		     var url = url_cur+"/api/auth/auth_outputtree.action";						
		    $.post(url, { Action: "post", pid: sele_pid }, 
							function (data){
							  zNodes = eval(data);
							 if(zNodes!=undefined && zNodes.length>0){
							  $.fn.zTree.init($("#treeDemo"), setting, zNodes);   //初始化树
							 }
							 }
							 );
			
		 /*
		 	添加子权限
		 */
		 $("input[name='goaddchild']").click(function(){		
		 if($("#select_node_id").val().length>0)	{							  
				$("form[name='form1']").attr("action",url_cur+"/api/auth/auth_insert.action");			
				$("form[name='form1']").submit(); 
				}
				else{alert("请选择权限节点");}
		 	 });	
		 	
	 	/*
		 	修改权限信息
		 */
		 $("input[name='gomodify']").click(function(){		
		 if($("#select_node_id").val().length>0)	{							  
				$("form[name='form1']").attr("action",url_cur+"/api/auth/auth_modify.action");			
				$("form[name='form1']").submit(); 
				}
				else{alert("请选择权限节点");}
		 	 });	
		/*
		  查看权限信息
		 */
		 $("input[name='goview']").click(function(){		
		 if($("#select_node_id").val().length>0)	{							  
				$("form[name='form1']").attr("action",url_cur+"/api/auth/auth_view.action");			
				$("form[name='form1']").submit(); 
				}
				else{alert("请选择权限节点");}
		 	 });		
		 	
		 /*
		 	删除权限信息
		 */
		 $("input[name='godel']").click(function(){		
		 if($("#select_node_id").val().length>0){	
			 if(confirm('确认删除？')){	
			 	$("form[name='form1']").attr("action",url_cur+"/api/auth/auth_delete.action");
				$("form[name='form1']").submit(); };
			
				}
				else{alert("请选择权限节点");}
		 	 });
		/*
		 	添加一级权限
		*/
		$("input[name='goaddtoptype']").click(function(){	
				$("form[name='form1']").attr("action",url_cur+"/api/type/goaddchild");
				$("#select_node_id").attr("value","${!empty (pid)? pid:0}");
				$("form[name='form1']").submit(); 
			 
		});
		/*
		 	查看全部权限
		*/
		$("input[name='goview_all']").click(function(){	
				$("form[name='form1']").attr("action",url_cur+"/api/auth/auth_list.action");
				$("form[name='form1']").submit(); 
			 
		});
		
		/*
			绑定查询函数
		*/
		 	key = $("#search_type_name");
			key.bind("propertychange", searchNode)
			.bind("input", searchNode);		
			
		/*
			控制一级权限样式
		*/				 
 
		   //jquery end						   
 });