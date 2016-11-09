function changeLang()
{
	lang = $("#changeLang").val();
	
	if (lang == "en-us")
	{
		controller = new LanguageControllerEN();
		$.datepicker.setDefaults( $.datepicker.regional[""] );
	}
	else
	{
		controller = new LanguageControllerZH();
		$.datepicker.setDefaults( $.datepicker.regional["zh-TW"] );
	}
	
	// 自动切换所有的label
	var arrayOfLabel;        
	if (document.all || document.getElementById)
	{            
		arrayOfLabel = document.getElementsByTagName("label");        
	}
	
	for(var i=0;i<arrayOfLabel.length;i++)    
	{   
		var labelId = arrayOfLabel[i].id;
		if(labelId!="" && labelId.indexOf("Tree") == -1)
		{
			arrayOfLabel[i].innerHTML=controller.language.titles[labelId];
		}
	}
	
	// 自动切换所有span
	var arrayOfSpan;        
	if (document.all || document.getElementById)
	{            
		arrayOfSpan = document.getElementsByTagName("span");        
	}
	
	for(var i=0;i<arrayOfSpan.length;i++)    
	{   
		var spanId = arrayOfSpan[i].id;
		if(spanId!="" && spanId.indexOf("Tree") == -1)
		{
			document.getElementById(spanId).innerHTML=controller.language.titles[spanId];
		}
	}
	
	// 自动切换所有li
	var arrayOfli;        
	if (document.all || document.getElementById)
	{            
		arrayOfli = document.getElementsByTagName("li");        
	}
	
	for(var i=0;i<arrayOfli.length;i++)    
	{   
		var liId = arrayOfli[i].id;
		if(liId!="" && liId.indexOf("Tree") == -1)
		{
			document.getElementById(liId).innerHTML=controller.language.titles[liId];
		}
	}
	
	// 自动切换所有button
	var arrayOfButton;        
	if (document.all || document.getElementById)
	{            
		arrayOfButton = document.getElementsByTagName("input");        
	}
	
	for(var i=0;i<arrayOfButton.length;i++)    
	{   
		var buttonId = arrayOfButton[i].id;
		if(buttonId!="" && buttonId.indexOf("Btn") > 0)
		{
			document.getElementById(buttonId).value=controller.language.buttons[buttonId];
		}
		if(buttonId!="" && buttonId.indexOf("getPortGroupsBtn") >= 0)
		{
			document.getElementById(buttonId).value=controller.language.buttons["getPortGroupsBtn"];
		}
		if(buttonId!="" && buttonId.indexOf("getDatastoreUrnBtn") >= 0)
		{
			document.getElementById(buttonId).value=controller.language.buttons["getDatastoreUrnBtn"];
		}
	}
	
	
	
	// zTree加载时自动生成ID，这边得特殊处理
	if (exist('FMTree_1_span')) $("#FMTree_1_span").html(controller.language.titles["FMTree_1_span"]);
	if (exist('FMTree_2_span')) $("#FMTree_2_span").html(controller.language.titles["FMTree_2_span"]);
	if (exist('FMTree_3_span')) $("#FMTree_3_span").html(controller.language.titles["FMTree_3_span"]);$("#FMTree_3_span").attr("title", controller.language.titles["FMTree_3_span_tag"]);
	if (exist('FMTree_4_span')) $("#FMTree_4_span").html(controller.language.titles["FMTree_4_span"]);
	if (exist('FMTree_5_span')) $("#FMTree_5_span").html(controller.language.titles["FMTree_5_span"]);$("#FMTree_5_span").attr("title", controller.language.titles["FMTree_5_span_tag"]);
	if (exist('FMTree_6_span')) $("#FMTree_6_span").html(controller.language.titles["FMTree_6_span"]);
	if (exist('FMTree_7_span')) $("#FMTree_7_span").html(controller.language.titles["FMTree_7_span"]);$("#FMTree_7_span").attr("title", controller.language.titles["FMTree_7_span_tag"]);
	
	if (exist('CreateVMBtnLabel')) $("#CreateVMBtnLabel").val(controller.language.titles["CreateVMBtnLabel"]);
	if (exist('CreateVMBtnLabel')) $("#CreateVMBtnLabel").attr("title",controller.language.titles["CreateVMBtnLabel"]);
	
	$("option[value=vmLocation_Cluster]").html(controller.language.titles["vmLocationClusterOption"]);
	$("option[value=vmLocation_Host]").html(controller.language.titles["vmLocationHostOption"]);
	
	$("option[name=TalkMode0]").html(controller.language.titles["TalkMode0"]);
	$("option[name=TalkMode1]").html(controller.language.titles["TalkMode1"]);
	$("option[name=TalkMode2]").html(controller.language.titles["TalkMode2"]);
	
	$("option[name=statusOption1]").html(controller.language.titles["statusOption1"]);
	$("option[name=statusOption2]").html(controller.language.titles["statusOption2"]);
	$("option[name=statusOption3]").html(controller.language.titles["statusOption3"]);
	$("option[name=statusOption4]").html(controller.language.titles["statusOption4"]);
	
	$("option[name=supportVideoOption0]").html(controller.language.titles["supportVideoOption0"]);
	$("option[name=supportVideoOption1]").html(controller.language.titles["supportVideoOption1"]);
	
	$("option[name=roleOption1]").html(controller.language.titles["roleOption1"]);
	$("option[name=roleOption2]").html(controller.language.titles["roleOption2"]);
	
	$("#mediaTypeSpan1").html(controller.language.titles["mediaTypeSpan1"]);
	$("#mediaTypeSpan2").html(controller.language.titles["mediaTypeSpan2"]);
	$("#mediaTypeSpan3").html(controller.language.titles["mediaTypeSpan3"]);
	
	
	
	// 状态显示特殊处理，因只有调用接口后才会展示，这边需要作判断是否显示
	statusChange();
	
	// 页面参数校验错误信息在切换语言时清空
	clearTip();
}

function hasOption(select)
{
	if ($(select).children().length == 0)
	{
		clearTip();
		$("#queryDVSwitchEx_uriErrTip").html(controller.language.titles["queryDVSwitchEx_uriFirstSiteTip"]);
	}
}

function queryDataStoresCall()
{
	// 娓呯┖淇℃伅
	$("#queryDataStores_resultCode").val("");
	$("#queryDataStores").html("");
	$("#queryDataStoresReqEx_nameErrTip").html("");
	$("#queryDataStoresReqEx_limitErrTip").html("");
	$("#queryDataStoresReqEx_offsetErrTip").html("");
	$("#querySiteReqEx_uriErrTip").html("");
	$("#DataStoresInfo").html("");
	$("#queryDataStores_status").html("");
	
	var siteUri = $("#querySiteReqEx_uri").val();
	var limit = $("#queryDataStoresReqEx_limit").val();
	var offset = $("#queryDataStoresReqEx_offset").val();
	var name = $("#queryDataStoresReqEx_name").val();
	
	if (!checkDataStores())
	{
		return false;
	}
	
	$.ajax({
		url : "queryDataStoresServlet",
		type : "post",
		dataType : "json",
		data : "siteUri=" + siteUri + "&name=" + name + "&limit=" + limit +"&offset=" + offset + "&method=queryDataStores",
		async : true,
		success : function(data)
		{
			$("#waittingDiv").css({"display":"none"});
			$("#waittingImgDiv").css({"display":"none"});
			
			if ("00000000" != data.errorCode)
			{
				$("#queryDataStores_resultCode").val(data.errorCode);
				$("#queryDataStores_status").html(controller.language.titles["operationFailed"]);
			}
			else
			{
				$("#queryDataStores_resultCode").val(data.errorCode);
				$("#DataStoresInfo").val(showDataStores(data.result));
				var $status = $("#queryDataStores_status");
				$status.html(controller.language.titles["operationSuccess"]);
				$status.css({"color" : "blue"});
			}
		},
		error : function(data)
		{
			$("#waittingDiv").css({"display":"none"});
			$("#waittingImgDiv").css({"display":"none"});
			
			var res = data.responseText;
			$("#VPCInfo").val("ajaxError");
			$("#queryDataStores_status").html(controller.language.titles["operationFailed"]);
			$("#queryDataStores_status").css({"color" : "red"});
		},
		beforeSend : function()
		{
			$("#queryDataStores_resultCode").val("");
			$("#VPCInfo").val("");
			$("#queryDataStores_status").html("");
			
			$("#waittingDiv").css({"display":"block"});
			$("#waittingImgDiv").css({"display":"block"});
		}
	});
}

function showDataStores(dataStores)
{
	var str = "Find " + dataStores.list.length + " DataStores(s).\n";
	for(var i = 0; i < dataStores.list.length; i++)
	{
		var dataStore = dataStores.list[i];
	    str += "DataStore " + (i+1) + " ----------------\n";
	    str += "name:" + dataStore.name + "\n";
	    str += "uri:" + dataStore.uri + "\n";
	    str += "urn:" + dataStore.urn + "\n";
	    str += "status:" + dataStore.status + "\n";
	    str += "\n";
	}
	return str;
}

//创建VM
function createVMCall()
{
	// 清空信息
	$("#createVM_resultCode").val("");
	$("#VMInfo").html("");
	$("#createVM_status").html("");
	
	if(!checkInputParams())
	{
		return false;
	}
	
	parent.tb_remove();
	
	intialCreateVMReq();
	
	var reqJson = JSON.stringify(createVMReq);
	
	var siteUri = $("#querySiteReqEx_uri").val();
	
	//因为在IE8测试中$.ajax获取不到返回值，这里就用js写ajax请求
	//ajax请求对象
	var httpRequest;
	// 除 IE 外其浏览器 
	if(window.XMLHttpRequest) { 
	    httpRequest = new XMLHttpRequest(); 
	}
	// IE 
	else if(window.ActiveXObject) { 
	    try { 
	        httpRequest = new ActiveXObject("Msxml2.XMLHTTP"); 
	    }  
	    catch(e) { 
	        try { 
	            httpRequest = new ActiveXObject("Microsoft.XMLHTTP"); 
	        } 
	        catch (e) { 
	            alert("ie httpRequest initial failed");
	            return ;
	        } 
	    } 
	}
	httpRequest.onreadystatechange = function() { 
	    if(httpRequest.readyState === 4) {
			
	    	$("#waittingDiv").css({"display":"none"});
			$("#waittingImgDiv").css({"display":"none"});
	        
			var data = JSON.parse(httpRequest.responseText);
			if(httpRequest.status === 200) {
				if ("00000000" != data.errorCode)
				{
					$("#createVM_resultCode").val(data.errorCode);
					$("#createVM_status").html(controller.language.titles["operationFailed"]);
				}
				else
				{
					$("#createVM_resultCode").val(data.errorCode);
					$("#VMInfo").val(showVMList(data.result));
					var $status = $("#createVM_status");
					$status.html(controller.language.titles["operationSuccess"]);
					$status.css({"color" : "blue"});
				}
	        }
	        else{//status not 200, ajax error
	        	var res = data.responseText;
				$("#VMInfo").val("ajax Error");
				$("#createVM_status").html(controller.language.titles["operationFailed"]);
	        }
	    }
	    else {
	    	//alert("readyState: " + httpRequest.readyState);
	    }
	}; 
	httpRequest.open("POST", "createVMServlet", true); 
	httpRequest.setRequestHeader("Content-type", "application/x-www-form-urlencoded; charset=UTF-8");
	
	//before send
	$("#createVM_resultCode").val("");
	$("#VMInfo").val("");
	$("#createVM_status").html("");
	
	$("#waittingDiv").css({"display":"block"});
	$("#waittingImgDiv").css({"display":"block"});
	
	httpRequest.send("siteUri=" + siteUri + "&reqJson=" + reqJson + "&method=createVM");

}

function queryClusterAndHost()
{
	var siteUri = null;
	if ($("#querySiteReqEx_uri").children().length > 1)
	{
		siteUri = $("#querySiteReqEx_uri").children()[1].value;
	}
	
	$.ajax({
		url : "queryClusterAndHostServlet",
		type : "post",
		dataType : "text",
		data : "siteUri=" + siteUri + "&method=queryClusterAndHost",
		async : false,
		success : function(data)
		{
			if (data != null)
			{
				var str = "<select id = 'createVM_clusterAndHost' style = 'width:234px;' onchange='clearChangeStyle(this)'><option></option>";
			
				if ("vmLocation_Cluster" == $("#vmLocationSelect option:selected").val())
				{
					var dataClus = $.parseJSON(data.split("||")[1]);
					for (var i = 0 ; i < dataClus.result.length; i++)
					{
						var clus = dataClus.result[i];
						str += "<option value='"+clus.urn+"'>"+clus.urn+"</option>";
					}
				}
				else
				{
					var dataHost = $.parseJSON(data.split("||")[0]);
					for (var i = 0; i < dataHost.result.list.length; i++)
					{
						var host = dataHost.result.list[i];
						str += "<option value='"+host.urn+"'>"+host.urn+"</option>";
					}
					
				}
			
				str += "</select>";
				
				$("#createVM_clusterAndHost_select").html(str);
			}
			else 
			{
				clearTip();
				$("#getOrgReqEx_tenantIDErrTip").html(controller.language.titles["batchCreateVM_tenantIDTip"]);
			}
			
			
		},
		error : function(data){}
	});
}

function queryOsVersions()
{
	var siteUri = null;
	if ($("#querySiteReqEx_uri").children().length > 1)
	{
		siteUri = $("#querySiteReqEx_uri").children()[1].value;
	}
	
	$.ajax({
		url : "queryOsVersionsServlet",
		type : "post",
		dataType : "json",
		data : "siteUri=" + siteUri + "&method=queryOsVersions",
		async : false,
		success : function(data)
		{
			if (data != null)
			{
				var str = "<select id = 'createVM_OsVersions' onchange='clearChangeStyle(this)' style = 'width:234px;'><option></option>";
			
				if ("Windows" == $("#osOptionSelect option:selected").val())
				{
					for (var i = 0 ; i < data.result.windows.length; i++)
					{
						var os = data.result.windows[i];
						str += "<option value='"+os.id+"'>"+os.versionDes+"</option>";
					}
				}
				else if ("Linux" == $("#osOptionSelect option:selected").val())
				{
					for (var i = 0 ; i < data.result.linux.length; i++)
					{
						var os = data.result.linux[i];
						str += "<option value='"+os.id+"'>"+os.versionDes+"</option>";
					}
				}
				else
				{
					for (var i = 0 ; i < data.result.other.length; i++)
					{
						var os = data.result.other[i];
						str += "<option value='"+os.id+"'>"+os.versionDes+"</option>";
					}
				}	
			
				str += "</select>";
				
				$("#createVM_OsVersions_select").html(str);
			}
			else 
			{
				clearTip();
				$("#getVMTempReqEx_vmTemplIDErrTip").html(controller.language.titles["batchCreateVM_vmTemplIDTip"]);
			}
		},
		error : function(data){}
	});
}

function getDatastoreUrn()
{
	$.ajax({
		url : "getDatastoreUrnServlet",
		type : "post",
		dataType : "json",
		data : "method=getDatastoreUrn",
		async : false,
		success : function(data)
		{
			if (data != null && "00000000" == data.errorCode)
			{
				var str = "<select id = 'createVM_getDatastoreUrn' style = 'width:228px;'><option></option>";
			
				for (var i = 0; i < data.result.list.length; i++)
				{
					var datastoreUrn = data.result.list[i];
					
					str +="<option value='"+datastoreUrn.urn+"'>"+datastoreUrn.urn+"</option>";
				}
			
				str += "</select>";
				
				$("#createVM_datastoreUrn_select").html(str);
			}
			else 
			{
				clearTip();
				$("#createVMReq_vmParameters_dataStoreErrTip").html(controller.language.titles["createVMReq_dataStoreErrTip"]);
			}
		},
		error : function(data){}
	});
}

function getPortGroups()
{
	$.ajax({
		url : "getPortGroupsServlet",
		type : "post",
		dataType : "json",
		data : "method=getPortGroups",
		async : false,
		success : function(data)
		{
			if (data != null&&"00000000" == data.errorCode)
			{
				var str = "<select id = 'createVM_PortGroups' style = 'width:228px;'><option></option>";
			
				for (var i = 0; i < data.result.list.length; i++)
				{
					var portGroup = data.result.list[i];
					
					str +="<option  value='"+portGroup.urn+"'>"+portGroup.urn+"</option>";
				}
			
				str += "</select>";
				
				$("#createVM_portGroups_select").html(str);
			}
			else 
			{
				clearTip();
				$("#createVMReq_vmParameters_portGroupErrTip").html(controller.language.titles["createVMReq_portGroupErrTip"]);
			}
		},
		error : function(data){}
	});
}


function clickEvent(flavor)
{
	$.ajax({
		url : "getVMFlavorServlet",
		type : "post",
		dataType : "json",
		data : "method=getVMFlavor",
		async : false,
		success : function(data)
		{
			if (data != null)
			{
				for (var i = 0; i < data.vmFlavors.length; i++)
				{
					var vmFlavor = data.vmFlavors[i];
					
					if (flavor.value == vmFlavor.flavorId)
					{
						$("#batchCreateVMReq_vmParameters_CPUSet_cpuNum").val(vmFlavor.cpuCount);
						$("#batchCreateVMReq_vmParameters_MemorySet_memoryNum").val(vmFlavor.memSize);
					}
				}
				
			}
		},
		error : function(data){}
	});
}

function querySiteUri()
{
	$.ajax({
		url : "querySiteUriServlet",
		type : "post",
		dataType : "json",
		data : "method=querySiteUri",
		async : false,
		success : function(data)
		{
			if (data != null)
			{
				var str = "<select id = 'querySiteReqEx_uri' onchange='queryDVSwitchUri();' onblur='clearBlurStyle(this)' style = 'width:234px;'><option></option>";
				
				for (var i = 0 ; i < data.result.length; i++)
				{
					var site = data.result[i];
					str += "<option value='"+site.uri+"'>"+site.uri+"</option>";
				}
			
				str += "</select>";
				
				$("#querySiteReqEx_uri_select").html(str);
			}
			else 
			{
				clearTip();
				$("#querySiteReqEx_uriErrTip").html(controller.language.titles["batchCreateVM_tenantIDTip"]);
			}
			
			
		},
		error : function(data){}
	});
}

function queryDVSwitchUri()
{
	var siteUri = $("#querySiteReqEx_uri").val();
	
	if ("undefined" != siteUri && "" != siteUri)
	{
		$.ajax({
			url : "queryDVSwitchUriServlet",
			type : "post",
			dataType : "json",
			data : "siteUri="+siteUri+"&method=queryDVSwitchUri",
			async : false,
			success : function(data)
			{
				if (data != null && "00000000" == data.errorCode)
				{
					var str = "<select id = 'queryDVSwitchEx_uri' onchange='clearTip();' style = 'width:234px;'><option></option>";
					
					for (var i = 0 ; i < data.result.length; i++)
					{
						var dVSwitch = data.result[i];
						str += "<option value='"+dVSwitch.uri+"'>"+dVSwitch.uri+"</option>";
					}
				
					str += "</select>";
					
					$("#queryDVSwitchEx_uri_select").html(str);
				}
				else 
				{
					clearTip();
					$("#queryDVSwitchEx_uriErrTip").html(controller.language.titles["queryDVSwitchEx_uriNullTip"]);
				}
				
				
			},
			error : function(data){}
		});
	}
	clearTip();
}

function initCreateVm()
{
	$("#batchCreateVM_vmParameters_cpuNum_tipDiv").hide();
	$("#batchCreateVM_vmParameters_memoryNum_tipDiv").hide();
	$("#batchCreateVMReq_vmParameters_CPUSet_cpuNum").attr("readonly", true);
	$("#batchCreateVMReq_vmParameters_MemorySet_memoryNum").attr("readonly", true);

	if (exist('createVMReq_vmParameters_CPUSet_cpuNumErrTip')) $("#createVMReq_vmParameters_CPUSet_cpuNumErrTip").html("");
	if (exist('createVMReq_vmParameters_CPUSet_ReservationErrTip')) $("#createVMReq_vmParameters_CPUSet_ReservationErrTip").html("");
	if (exist('createVMReq_vmParameters_CPUSet_WeightErrTip')) $("#createVMReq_vmParameters_CPUSet_WeightErrTip").html("");
	if (exist('createVMReq_vmParameters_CPUSet_LimitErrTip')) $("#createVMReq_vmParameters_CPUSet_LimitErrTip").html("");
	if (exist('createVMReq_vmParameters_MemorySet_memoryNumErrTip')) $("#createVMReq_vmParameters_MemorySet_memoryNumErrTip").html("");
	if (exist('createVMReq_vmParameters_MemorySet_reservationErrTip')) $("#createVMReq_vmParameters_MemorySet_reservationErrTip").html("");
	if (exist('createVMReq_vmParameters_MemorySet_weightErrTip')) $("#createVMReq_vmParameters_MemorySet_weightErrTip").html("");
	if (exist('createVMReq_vmParameters_MemorySet_limitErrTip')) $("#createVMReq_vmParameters_MemorySet_limitErrTip").html("");
	if (exist('createVMReq_vmParameters_userDisksErrTip')) $("#createVMReq_vmParameters_userDisksErrTip").html("");
	if (exist('createVMReq_vmParameters_nicsErrTip')) $("#createVMReq_vmParameters_nicsErrTip").html("");
	if (exist('createVMReq_clusterAndHostTip')) $("#createVMReq_clusterAndHostTip").html("");
	if (exist('createVMReq_OsVersionsTip')) $("#createVMReq_OsVersionsTip").html("");
	if (exist('createVMReq_VM_diskNotNullErrTip')) $("#createVMReq_VM_diskNotNullErrTip").html("");
	if (exist('createVMReq_VM_sequenceNumNotNullErrTip')) $("#createVMReq_VM_sequenceNumNotNullErrTip").html("");
	if (exist('createVMReq_vmParameters_dataStoreErrTip')) $("#createVMReq_vmParameters_dataStoreErrTip").html("");
	if (exist('createVMReq_vmParameters_portGroupErrTip')) $("#createVMReq_vmParameters_portGroupErrTip").html("");
	queryClusterAndHost();
	queryOsVersions();
}

function statusChange()
{
	// Query VPC
	if (exist('queryPortGroups_resultCode'))
	{
		var val = $("queryPortGroups_resultCode").val(); 
		if(("" != val && undefined != val))
		{
			if (val == "00000000")
			{
				var $status = $("#queryPortGroups_status");
				$status.html(controller.language.titles["operationSuccess"]);
				$status.css({"color" : "blue"});
			}
			else
			{
				var $status = $("#queryPortGroups_status");
			    $status.html(controller.language.titles["operationFailed"]);
			    $status.css({"color" : "red"});
			}
		}
		else{
			$("#queryPortGroups_status").html("");
		}
	}
	else
	{
		$("#queryPortGroups_status").html("");
	}
	
	
	// Query CloudInfra
	if (exist('queryDataStores_resultCode'))
	{
		var val = $("queryDataStores_resultCode").val(); 
		if(("" != val && undefined != val))
		{
			if (val == "00000000")
			{
				var $status = $("#queryDataStores_status");
				$status.html(controller.language.titles["operationSuccess"]);
				$status.css({"color" : "blue"});
			}
			else
			{
				var $status = $("#queryDataStores_status");
				$status.html(controller.language.titles["operationFailed"]);
				$status.css({"color" : "red"});
			}
		}
		else{
			$("#queryDataStores_status").html("");
		}
	}
	else
	{
		$("#queryDataStores_status").html("");
	}
	
	// createVM
	if (exist('createVM_resultCode'))
	{
		var val = $("createVM_resultCode").val(); 
		if(("" != val && undefined != val))
		{
			if (val == "00000000")
			{
				var $status = $("#createVM_status");
				$status.html(controller.language.titles["operationSuccess"]);
				$status.css({"color" : "blue"});
			}
			else
			{
				var $status = $("#createVM_status");
				$status.html(controller.language.titles["operationFailed"]);
				$status.css({"color" : "red"});
			}
		}
		else{
			$("#createVM_status").html("");
		}
	}
	else
	{
		$("#createVM_status").html("");
	}
	
	
}

function clearTip()
{
	if (exist('queryDVSwitchEx_uriErrTip')) $("#queryDVSwitchEx_uriErrTip").html("");
	if (exist('querySiteReqEx_uriErrTip')) $("#querySiteReqEx_uriErrTip").html("");
	if (exist('queryDVSwitchEx_uriErrTip')) $("#queryDVSwitchEx_uriErrTip").html("");
	if (exist('queryPortGroupsReqEx_limitErrTip')) $("#queryPortGroupsReqEx_limitErrTip").html("");
	if (exist('queryPortGroupsReqEx_offsetErrTip')) $("#queryPortGroupsReqEx_offsetErrTip").html("");
	
	if (exist('queryDataStoresReqEx_nameErrTip')) $("#queryDataStoresReqEx_nameErrTip").html("");
	if (exist('queryDataStoresReqEx_limitErrTip')) $("#queryDataStoresReqEx_limitErrTip").html("");
	if (exist('queryDataStoresReqEx_offsetErrTip')) $("#queryDataStoresReqEx_offsetErrTip").html("");
	
}

function clearChangeStyle(style)
{
	$(style).css({"background-color":"#FFFFFF"});
	$(style).parent().parent().next().find("span").html("");
}

function clearBlurStyle(style)
{
	$(style).css({"background-color":"#FFFFFF"});
	$(style).parent().next().find("span").html("");
	$(style).parent().parent().find("span").html("");
}

function clearBlur2Style(style)
{
	$(style).css({"background-color":"#FFFFFF"});
	$(style).parent().find("span").html("");
}

function appendInterface(functionName)
{
	if ("queryPortGroups" == functionName)
	{
		$(function() {
			$.ajax({
				type : "get",
				cache : false,
				url : "pages/interface/queryPortGroups.html",
				async : false,
				success : function(data) {
					$("#main1").html(data);
				}
			});
		});
	}
	
	if ("queryDataStores" == functionName)
	{
		$(function() {
			$.ajax({
				type : "get",
				cache : false,
				url : "pages/interface/queryDataStores.html",
				async : false,
				success : function(data) {
					$("#main1").html(data);
				}
			});
		});
	}
	
	if ("createVM" == functionName)
	{
		$(function() {
			$.ajax({
				type : "get",
				cache : false,
				url : "pages/interface/createVM.html",
				async : false,
				success : function(data) {
					$("#main1").html(data);
				}
			});
		});
	}

	
	setTab(1,0);
	
	changeLang();
}

function setTab(m,n)
{  
	 var tli=document.getElementById("menu"+m).getElementsByTagName("li");  
	 var mli=document.getElementById("main"+m).getElementsByTagName("ul");  
	 for(i=0;i<tli.length;i++)
	 {  
	 	tli[i].className=i==n?"hover":"";  
	  	mli[i].style.display=i==n?"block":"none";  
	 }
	 
	 querySiteUri();
}

function clean()
{
	// 当单击节点时，置空标签页
	$("#main1").html("<ul class='block'><li></li></ul><ul><li></li></ul><ul><li></li></ul>");
	setTab(1,0);
}

function exist(id)
{
    var s=document.getElementById(id);
    if(s)
    {
    	return true;
    }
    else
    {
    	return false;
    }
}

function isEmpty(value)
{
	if (null == value || "" == value)
	{
		return true;
	}
	else
	{
		return false;
	}
}

function isNumber(num)
{
	var reNum=/^\d*$/;
	return(reNum.test(num));
}

/**2014.4.8 新增*/
function textOnF(which)
{
	if (which.style.color === "gray")
	{
		which.value = '';
		which.style.color = 'black';
	}
}


function changeValue(id)
{
	var values = {
			texts : {
				"QueryNetworkReqEx_tenantId" : "21",
				"QueryNetworkReqEx_cloudInfrasId" : "40",
				"QueryNetworkReqEx_vpcId" : "4792750811720056850",
				"QueryNetworkReqEx_networkId" : "30000000022",
				"batchCreateVMReq_templID" : "4",
				"batchCreateVMReq_count" : 1,
				"batchCreateVMReq_vmParameters_CPUSet_reservation" : 0,
				"batchCreateVMReq_vmParameters_CPUSet_weight" : 1000,
				"batchCreateVMReq_vmParameters_CPUSet_limit" : 0,
				"batchCreateVMReq_vmParameters_MemorySet_reservation" : 0,
				"batchCreateVMReq_vmParameters_MemorySet_weight" : 1280,
				"queryOrgListReqEx_limit" : 50,
				"queryOrgListReqEx_start" : 0,
				"queryCloudInfraReqEx_tenantID" : "1",
				"queryCloudInfraReqEx_name" : "FM",
				"queryCloudInfraReqEx_limit" : 10,
				"queryCloudInfraReqEx_start" : 0,
				"queryVMTemplateReqEx_tenantID" : "21",
				"queryVMTemplateReqEx_cloudInfraID" : "40",
				"queryVMTemplateReqEx_limit" : 10,
				"queryVMTemplateReqEx_start" : 0,
				"queryVMFlavorReqEx_tenantID" : "21",
				"queryVMFlavorReqEx_cloudInfraID" : "40",
				"queryVMFlavorReqEx_limit" : 10,
				"queryVMFlavorReqEx_start" : 0,
				"queryVPCReqEx_tenantID" : "21",
				"queryVPCReqEx_cloudInfraID" : "40",
				"queryVPCReqEx_limit" : 10,
				"queryVPCReqEx_start" : 0
				}
			};
	
	var result = values.texts[id];
	return result;
}

function textOnB(which)
{
	if ('' === which.value || null === which.value)
	{	
		which.value = changeValue(which.id);
		which.style.color = 'gray';
	}
}

function textAllSelect(which)
{
	which.select();
}

function inputOnkeydown(which)
{
	if(which.style.color = 'gray')
	{
		which.style.color = 'black';
	}
}

function showTipDiv(e, div, id)
{
	if(!exist(id)) return ;
	var $div = $(div);
	var top = $div.offset().top + 16;
	var left = $div.offset().left + 16;
	if(exist("TB_window")) 
    {
		var $TB = $("#TB_window");
		top = top - $TB.offset().top - 5;
		left = left - $TB.offset().left - 5;
    }
	
	$("#"+id).css({"display":"block","position":"absolute","z-index":"201","top":top,"left":left});
}

function hideTipDiv(id)
{
	if(!exist(id)) return ;
	$("#"+id).css({"display":"none","z-index":"0"});
}

function showValue(value)
{
	if(undefined == value)
	{
		return "";
	}
	else
	{
		return value;
	}
}

function addVMNameInput(img)
{
	var $addImg = $(img);
	$addImg.parent().append("<div class=\"vmName\"><input type=\"text\" name=\"vmName\" class=\"vmNameInput\" /><div class=\"vmNameDel\" onclick=\"removeVMName(this);\" /></div>");
}

function removeVMName(img)
{
	var $removeImg = $(img);
	$removeImg.parent().remove();
}

//初始化请求参数
function intialCreateVMReq()
{
	createVMReq = new Object();
	createVMReq.osOptions = new Object();
	createVMReq.vmConfig = new Object();
	
	createVMReq.templateId = null;
	createVMReq.vpcId = null;
	createVMReq.namePrefix = null;
	createVMReq.count = 0;
	
	disk = new Object();
	
	createVmNetwork = new Object();
	createVMReq.vmConfig.cpu = new Object();
	createVMReq.vmConfig.memory = new Object();
	createVMReq.vmConfig.disks = new Array();
	createVMReq.vmConfig.nics = new Array();
	createVMReq.vmConfig.id = null;
	
	
	createVMReq.name = $("#createVMReq_name").val();
	
	createVMReq.location = $("#createVM_clusterAndHost").val();
	
	createVMReq.osOptions.osType = $("#osOptionSelect").val();
	
	createVMReq.osOptions.osVersion = $("#createVM_OsVersions").val();
	
	// cpu信息
	createVMReq.vmConfig.cpu.quantity = parseInt($("#createVMReq_vmParameters_CPUSet_cpuNum").val());
	
	createVMReq.vmConfig.cpu.reservation = parseInt($("#createVMReq_vmParameters_CPUSet_Reservation").val());
	
	createVMReq.vmConfig.cpu.weight = parseInt($("#createVMReq_vmParameters_CPUSet_Weight").val());

	createVMReq.vmConfig.cpu.limit = parseInt($("#createVMReq_vmParameters_CPUSet_Limit").val());

	// 内存信息
	createVMReq.vmConfig.memory.quantityMB = parseInt($("#createVMReq_vmParameters_MemorySet_memoryNum").val());
	
	createVMReq.vmConfig.memory.reservation = parseInt($("#createVMReq_vmParameters_MemorySet_reservation").val());
	
	createVMReq.vmConfig.memory.weight = parseInt($("#createVMReq_vmParameters_MemorySet_weight").val());
	
	createVMReq.vmConfig.memory.limit = parseInt($("#createVMReq_vmParameters_MemorySet_limit").val());
	
	// 磁盘
	disk = new Object();
	
	disk.sequenceNum  = parseInt($("#sequenceNum").val());
	
	disk.quantityGB = parseInt($("#userDiskBsSize").val());
	
	disk.volType = parseInt($("#volType").val());
	
	disk.datastoreUrn = $("#createVM_getDatastoreUrn").val();
	
	createVMReq.vmConfig.disks.push(disk);
	
	// 网卡
	nic = new Object();
	
	nic.portGroupUrn = $("#createVM_PortGroups").val();
	
	nic.name = $("#name").val();
	
	nic.sequenceNum = parseInt(1);
	
	nic.ip = $("#ip").val();
	
	createVMReq.vmConfig.nics.push(nic);
}


