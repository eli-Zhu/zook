/*
 * LY.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
var domainPage;
$(document).ready(function() {
	// vue begin.
	domainPage = new Vue({
		el : '#domainPage',
		data : {
			parms: {},
			infos : {}
		},
		ready : function() {
			// 页面初始化载入首页数据.
			this.loadGridData();
		},
		methods : {
			queryData : function(event, pageInfo) {
				if (pageInfo) {
					$.extend(this.parms, pageInfo);
				} else {
					this.parms.page = undefined;
					this.parms.size = undefined;
				}
				this.loadGridData(this.parms);
			},
			create : function() {
				$("#formModal").modal({
					show : true,
					remote : __ctx + "/domain.htm?m=create",
					backdrop : 'static'
				});
			},
			reset : function() {
				this.parms = {};
			},
			edit : function(id) {

				$("#formModal").modal({
					show : true,
					remote : __ctx + "/domain.htm?m=edit&id=" + id,
					backdrop : 'static'
				});
			},
			del : function(id) {
				var me = this;
				alertify.confirm("是否确认删除?", function(e) {
					if (e) {
						$.ajax({
							type : "GET",
							url : __ctx + "/domain/delete/" + id,
							datatype : "json",
							beforeSend : function() {
							},
							success : function(data) {
								if (data && data.result) {
									domainPage.queryData();
									toastr.success(data.message, data.errorCode, {timeOut: 3000, positionClass: "toast-top-center"});
								} else {
									toastr.error(data.message, data.errorCode, {timeOut: 3000, positionClass: "toast-top-right"});
								}
							},
							// 调用执行后调用的函数
							complete : function(XMLHttpRequest, textStatus) {
							},
							// 调用出错执行的函数
							error : function() {
							}
						});
					}
				});
			},
			
			loadGridData : function(pars) {
				$.ajax({
					url : __ctx + "/domain.json?m=query",
					data : pars,
					success : function(data) {
						domainPage.infos = data;
					}
				});
			}
		}
	});

	$("#applicationModal").on("hidden.bs.modal", function() {
		$(this).removeData("bs.modal");
	});
});