<%@ page contentType="text/html; charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/common/tags.jsp"%>
<aos:html>
<aos:head title="专员管理">
	<aos:include lib="ext" />
	<aos:base href="funds/" />
</aos:head>
<aos:body>
</aos:body>
<aos:onready>
	<aos:viewport layout="border">
		<aos:gridpanel id="_g_user" region="center" onrender="_g_user_query"
			url="hr/queryHrList.jhtml" onitemdblclick="_w_user_u_show">
			<aos:docked forceBoder="0 0 1 0">
				<aos:dockeditem xtype="tbseparator" />
				<aos:dockeditem text="新增" tooltip="新增专员" onclick="_w_user_show"
					icon="add.png" />
				<aos:dockeditem text="修改" tooltip="修改专员" onclick="_w_user_u_show"
					icon="edit.png" />
				<aos:dockeditem text="删除" tooltip="删除专员" onclick="_g_user_del"
					icon="del.png" />
				<aos:dockeditem xtype="tbseparator" />
				<aos:dockeditem text="导入" tooltip="导入专员信息" onclick="importExcel()"
					icon="edit.png" />
				<aos:dockeditem xtype="tbseparator" />
				<aos:dockeditem text="导出" tooltip="导出专员信息成Excel"
					onclick="_g_user_export" icon="icon9.png" />
				<aos:dockeditem xtype="tbseparator" />
				<aos:combobox editable="false"   id="patient_query_type" name="patient_query_type"
					dicField="custom_hrm_query" value="0" width="90" />
				<aos:triggerfield emptyText="请输入关键字" name="hotkey" id="_hotkey"
					onenterkey="_g_user_query" trigger1Cls="x-form-search-trigger"
					onTrigger1Click="_g_user_query" width="180" />
				<aos:dockeditem xtype="tbfill" />
			</aos:docked>

			<aos:selmodel type="checkbox" mode="multi" />
			<aos:column type="rowno" />
			<aos:column header="流水号" dataIndex="id" hidden="true" />
			<aos:column header="姓名" dataIndex="name" width="130" celltip="true" />
			<aos:column header="性别" dataIndex="sex" width="130" celltip="true" />
			<aos:column header="身份证复印件" dataIndex="idcardCopy" width="130"
				celltip="true" />
			<aos:column header="公司名片" dataIndex="companyProfile" width="130"
				celltip="true" />
			<aos:column header="联系电话" dataIndex="phone" width="130"
				celltip="true" />
			<aos:column header="邮箱" dataIndex="email" width="130" celltip="true" />
			<aos:column header="是否在册" dataIndex="isRegister" width="130"
				celltip="true" />
			<aos:column header="备注" dataIndex="remark" width="130" celltip="true" />
			<aos:column header="" width="1" flex="1" />
		</aos:gridpanel>
	</aos:viewport>

	<aos:window id="_w_user" title="新增专员" maxHeight="-10" width="720"
		autoScroll="true">
		<aos:formpanel id="_f_user" width="700" layout="column">
			<aos:fieldset title="" labelWidth="150" labelAlign="right"
				center="true" collapsible="false">
				<aos:textfield name="name" fieldLabel="姓名" maxLength="100"
					columnWidth="0.5" />
				<aos:combobox fieldLabel="性别" name="sex" dicField="custom_sex"
					emptyText="男" value="0" columnWidth="0.49" />

				<aos:combobox name="idcardCopy" fieldLabel="身份证复印件"
					dicField="custom_h_state" emptyText="" editable="true"
					forceSelection="false" columnWidth="0.5" />
				<aos:combobox name="companyProfile" fieldLabel="公司名片"
					dicField="custom_h_state" emptyText="" editable="true"
					forceSelection="false" columnWidth="0.49" />

				<aos:textfield id="phone" name="phone" fieldLabel="联系电话" maxLength="100"
					columnWidth="0.5" />
				<aos:textfield name="email" fieldLabel="邮箱" maxLength="100"
					columnWidth="0.49" />

				<aos:combobox name="isRegister" fieldLabel="是否在册"
					dicField="custom_is_hospital" emptyText="是" value="0"
					columnWidth="0.5" />
				<aos:textfield name="remark" fieldLabel="备注" maxLength="100"
					columnWidth="0.49" />

			</aos:fieldset>
		</aos:formpanel>
		<aos:docked dock="bottom" ui="footer">
			<aos:dockeditem xtype="tbfill" />
			<aos:dockeditem onclick="_f_user_save" text="保存" icon="ok.png" />
			<aos:dockeditem onclick="#_w_user.hide();" text="关闭" icon="close.png" />
		</aos:docked>
	</aos:window>

	<aos:window id="_w_user_u" title="修改专员" onshow="_w_user_u_onshow"
		width="720" maxHeight="-10" autoScroll="true">
		<aos:formpanel id="_f_user_u" width="700" layout="column"
			labelWidth="70">
			<aos:hiddenfield fieldLabel="xxxxx" name="id" />
			<aos:fieldset title="" labelWidth="120" labelAlign="right"
				center="true" collapsible="false">
				<aos:textfield name="name" fieldLabel="姓名" maxLength="100"
					columnWidth="0.5" />
				<aos:combobox fieldLabel="性别" name="sex" dicField="custom_sex"
					emptyText="男" value="0" columnWidth="0.49" />

				<aos:combobox name="idcardCopy" fieldLabel="身份证复印件"
					dicField="custom_h_state" emptyText="" editable="true"
					forceSelection="false" columnWidth="0.5" />
				<aos:combobox name="companyProfile" fieldLabel="公司名片"
					dicField="custom_h_state" emptyText="" editable="true"
					forceSelection="false" columnWidth="0.49" />

				<aos:textfield id="phoneModify"  name="phone" fieldLabel="联系电话" maxLength="100"
					columnWidth="0.5" />
				<aos:textfield name="email" fieldLabel="邮箱" maxLength="100"
					columnWidth="0.49" />

				<aos:combobox name="isRegister" fieldLabel="是否在册"
					dicField="custom_is_hospital" emptyText="是" value="0"
					columnWidth="0.5" />
				<aos:textfield name="remark" fieldLabel="备注" maxLength="100"
					columnWidth="0.49" />
			</aos:fieldset>
		</aos:formpanel>
		<aos:docked dock="bottom" ui="footer">
			<aos:dockeditem xtype="tbfill" />
			<aos:dockeditem onclick="_f_user_u_save" text="保存" icon="ok.png" />
			<aos:dockeditem onclick="#_w_user_u.hide();" text="关闭"
				icon="close.png" />
		</aos:docked>
	</aos:window>

	<aos:window id="_w_file_upload" title="文件上传" width="560" height="100">
		<aos:formpanel id="_f_import" width="550" layout="column"
			labelWidth="70">
			<aos:filefield id="myFileField" name="myFile1" fieldLabel="导入文件"
				buttonText="请选择" allowBlank="false" columnWidth="0.99"
				emptyText="请选择符合规范的Excel文件..." />
		</aos:formpanel>
		<aos:docked dock="bottom" ui="footer">
			<aos:dockeditem xtype="tbfill" />
			<aos:dockeditem onclick="importExcelFile" text="导入" icon="ok.png" />
			<aos:dockeditem onclick="#_w_file_upload.hide();" text="关闭"
				icon="close.png" />
		</aos:docked>
	</aos:window>

	<script type="text/javascript">
	
			var importSumType = 0;
		    function importExcel(){
		    	_w_file_upload.show();
		    }
		    
		    
		    var batchNO = 0;
            //执行导入Excel
            function importExcelFile(){
                _w_file_upload.hide();
                var filePath = myFileField.getValue();
                var len = filePath.length;
                //XLS(2003)、XLSX(2007)
                var pos = filePath.lastIndexOf(".");
                if(pos!=-1){
                    var tmp = filePath.substring(pos+1);
                    if(tmp.toUpperCase() == 'XLS' || tmp.toUpperCase() == 'XLSX' ){
                        var form = _f_import.getForm();
                        if (!form.isValid()) {
                            return;
                        }
                        AOS.wait();
                        form.submit({
                            timeout: 15*60*1000,
                            params: {
                                model:"medicalRecords"
                            },
                            url: 'hr/importExcel.jhtml',
                            success: function (form, action) {
                                AOS.hide();
                                AOS.tip("导入成功");
                                _g_user_query();
                               
                            },
                            failure:function(form, action){
                            	 AOS.hide();
                            	 AOS.tip("导入成功");
                                 _g_user_query();
                            }
                        });
                    }else{
                        alert("请选择xls或xlsx后缀名类型的文件");
                    }
                }else{
                    alert("请选择xls或xlsx后缀名类型的文件");
                }
            }

            //查询用户列表
            function _g_user_query() {
                var params = {
               		hotkey: _hotkey.getValue(),
               		patientQueryType: patient_query_type.getValue()
                };
                _g_user_store.getProxy().extraParams = params;
                _g_user_store.loadPage(1);
                
            }

            //弹出新增用户窗口
            function _w_user_show() {
                AOS.reset(_f_user);
                _w_user.show();
            }

            function isPhoneNo(phone){  
            	var reg = /^1\d{10}$/; //定义正则表达式
            	 if(""==phone || reg.test(phone)) {  
                    return  true;  
                }  else{
                	 AOS.tip("电话号码需为11位数字");  
                     return  false;  
                }
             } 
            
            //新增用户保存
            function _f_user_save() {
            	var phoneStr = Ext.getCmp("phone").getValue();
            	if(isPhoneNo(phoneStr)){
	                AOS.ajax({
	                    forms: _f_user,
	                    url: 'hr/saveHr.jhtml',
	                    ok: function (data) {
	                        if (data.appcode === -1) {
	                            AOS.err(data.appmsg);
	                        } else {
	                            _w_user.hide();
	                            _g_user_store.reload();
	                            AOS.tip(data.appmsg);
	                        }
	                    }
	                });
            	}
            }

            //弹出修改用户窗口
            function _w_user_u_show() {
                AOS.reset(_f_user_u);
    			if(AOS.selectone(_g_user)){
    				_w_user_u.show();
    	     	}
            }

            //监听弹出修改用户窗口事件
            function _w_user_u_onshow() {
                var record = AOS.selectone(_g_user);
                AOS.ajax({
                    params: {id: record.data.id},
                    url: 'hr/getHr.jhtml',
                    ok: function (data) {
                        _f_user_u.form.setValues(data);
                    }
                });
            }

            //修改用户保存
            function _f_user_u_save() {
            	var phoneStr = Ext.getCmp("phoneModify").getValue();
            	if(isPhoneNo(phoneStr)){
	            	var record = AOS.selectone(_g_user);
	                AOS.ajax({
	                    forms: _f_user_u,
	                    url: 'hr/updateHr.jhtml',
	                    ok: function (data) {
	                        if (data.appcode === -1) {
	                            AOS.err(data.appmsg);
	                            return;
	                        }
	                        _w_user_u.hide();
	                        _g_user_store.reload();
	                        AOS.tip(data.appmsg);
	                    }
	                });
            	}
            }

            //删除用户
            function _g_user_del() {
                var selection = AOS.selection(_g_user, 'id');
                if (AOS.empty(selection)) {
                    AOS.tip('删除前请先选中数据。');
                    return;
                }
                var msg = AOS.merge('确认要删除选中的[{0}]个用户数据吗？', AOS.rows(_g_user));
                AOS.confirm(msg, function (btn) {
                    if (btn === 'cancel') {
                        AOS.tip('删除操作被取消。');
                        return;
                    }
                    AOS.ajax({
                        url: 'hr/deleteHr.jhtml',
                        params: {
                            aos_rows_: selection
                        },
                        ok: function (data) {
                            AOS.tip(data.appmsg);
                            _g_user_store.reload();
                        }
                    });
                });
            }
            

			//导出
			function _g_user_export(){
				AOS.mask('正在导出, 请稍候...');
				AOS.ajax({
					params : {
						hotkey: _hotkey.getValue(),
	               		patientQueryType: patient_query_type.getValue()
					},
					url : 'hr/exportExcel.jhtml',
					wait : false,
					ok : function(data) {
						AOS.unmask();
						AOS.file('${cxt}/'+data.appmsg);
					}
				});
			}

        </script>
</aos:onready>
</aos:html>