<%@ page contentType="text/html; charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/common/tags.jsp"%>
<aos:html>
<aos:head title="数据管理">
	<aos:include lib="ext" />
	<aos:base href="funds/patient" />
</aos:head>
<aos:body>
</aos:body>
<aos:onready>
	<aos:viewport layout="border">
		<aos:gridpanel id="_g_user" region="center" onrender="_g_user_query" url="queryPatientList.jhtml"
			onitemdblclick="_w_user_u_show">
			<aos:docked forceBoder="0 0 1 0">
				<aos:dockeditem xtype="tbseparator" />
				<aos:dockeditem text="新增" tooltip="新增患者" onclick="_w_user_show" icon="add.png" />
				<aos:dockeditem text="修改" tooltip="修改患者" onclick="_w_user_u_show" icon="edit.png" />
				<aos:dockeditem text="删除" tooltip="删除患者" onclick="_g_user_del" icon="del.png" />
				<aos:dockeditem xtype="tbseparator" />
				<aos:dockeditem text="导出" tooltip="导出患者信息成Excel" onclick="_g_user_export" icon="icon9.png" />
				<aos:dockeditem xtype="tbseparator" />
				<aos:combobox id="patient_query_type" name="patient_query_type" dicField="custom_patient_query" value="0"  width="90"/>
				<aos:triggerfield emptyText="请输入关键字" name="hotkey" id="_hotkey" onenterkey="_g_user_query"
					trigger1Cls="x-form-search-trigger" onTrigger1Click="_g_user_query" width="180" />
				<aos:dockeditem xtype="tbfill" />
			</aos:docked>
			
			<aos:selmodel type="checkbox" mode="multi" />
			<aos:column type="rowno" />
			<aos:column header="流水号" dataIndex="id" hidden="true" />
			<aos:column header="是否通过" dataIndex="catalog_id_" hidden="true" />
			<aos:column header="档案编号" dataIndex="archives" width="70" celltip="true" />
			<aos:column header="是否通过" dataIndex="state" width="70" celltip="true" />
			<aos:column header="姓名" dataIndex="name" width="70" celltip="true" />
			<aos:column header="性别" dataIndex="sex" width="70" celltip="true" />
			<aos:column header="住址" dataIndex="address" width="70" celltip="true" />
			<aos:column header="联系电话" dataIndex="phone" width="70" celltip="true" />
			<aos:column header="身份号证" dataIndex="idcardnumber" width="70" celltip="true" />
			<aos:column header="诊断材料" dataIndex="diagnosticMaterial" width="70" celltip="true" />
			<aos:column header="身份证明" dataIndex="proofIdentity" width="70" celltip="true" />
			<aos:column header="收入证明" dataIndex="proofIncome" width="70" celltip="true" />
			<aos:column header="购药发票" dataIndex="purchaseInvoice" width="70" celltip="true" />
			<aos:column header="医学评估表" dataIndex="medicalEvaluationForm" width="80" celltip="true" />
			<aos:column header="患者知情同意函" dataIndex="informedConsentOfPatients" width="120" celltip="true" />
			<aos:column header="患者经济状况填报表" dataIndex="patienteConomicStatus" width="120" celltip="true" />
			<aos:column header="冷链药品知情同意书" dataIndex="coldChainDrugInformedConsent" width="120" celltip="true" />
			<aos:column header="项目专员" dataIndex="hr" width="70" celltip="true" />
			<aos:column header="朗沐医院" dataIndex="langMuHospital" width="70" celltip="true" />
			<aos:column header="朗沐医生" dataIndex="langMuDoctor" width="70" celltip="true" />
			<aos:column header="预计增药注射时间" dataIndex="estimatedTimeToIncreaseDrugInjection" width="120" celltip="true" />
			<aos:column header="备注" dataIndex="remarks" width="70" celltip="true" />
			<aos:column header="受助药品领取单" dataIndex="recipientsReceiveSingleDrug" width="120" celltip="true" />
			<aos:column header="捐助结束声明" dataIndex="endOfStatement" width="120" celltip="true" />
			<aos:column header=""   width="1" flex="1"/>
		</aos:gridpanel>
	</aos:viewport>

	<aos:window id="_w_user" title="新增患者" maxHeight="-10" width="720" autoScroll="true">
		<aos:formpanel id="_f_user" width="700" layout="column">
			<aos:fieldset title="" labelWidth="120" labelAlign="right" center="true" collapsible="false">
				<aos:textfield name="archives" fieldLabel="档案号"  maxLength="100" columnWidth="0.5" />
				<aos:combobox fieldLabel="是否通过" name="state"  dicField="custom_patient_state" emptyText="未通过" value="0" columnWidth="0.49" />
					
				<aos:textfield name="name" fieldLabel="姓名"  maxLength="100" columnWidth="0.5" />
				<aos:combobox fieldLabel="性别" name="sex" dicField="custom_sex" emptyText="男" value="0" columnWidth="0.49" />
					
				<aos:textfield name="idcardnumber" fieldLabel="身份证号"   maxLength="20" columnWidth="0.5" />
				<aos:textfield name="phone" fieldLabel="联系电话"  columnWidth="0.49" />
				
				<aos:textfield name="address" fieldLabel="住址" maxLength="100" columnWidth="0.5" />
				<aos:combobox name="diagnosticMaterial" fieldLabel="诊断材料" dicField="custom_h_state" emptyText="" editable="true" forceSelection="false" columnWidth="0.49" />
				
				<aos:combobox name="proofIdentity" fieldLabel="身份证明"  dicField="custom_h_state" emptyText="" editable="true" forceSelection="false"  columnWidth="0.5" />
				<aos:combobox name="proofIncome" fieldLabel="收入证明"  dicField="custom_h_state" emptyText="" editable="true" forceSelection="false"  columnWidth="0.49" />
				
				<aos:combobox name="purchaseInvoice" fieldLabel="购药发票"  dicField="custom_h_state" emptyText="" editable="true" forceSelection="false"  columnWidth="0.5" />
				<aos:combobox name="medicalEvaluationForm" fieldLabel="医学评估表"  dicField="custom_h_state" emptyText="" editable="true" forceSelection="false"  columnWidth="0.49" />
				
				<aos:combobox name="informedConsentOfPatients" fieldLabel="患者知情同意函"  dicField="custom_h_state" emptyText="" editable="true" forceSelection="false"  columnWidth="0.5" />
				<aos:combobox name="patienteConomicStatus" fieldLabel="患者经济状况填报表"  dicField="custom_h_state" emptyText="" editable="true" forceSelection="false"  columnWidth="0.49" />
				
				<aos:combobox name="coldChainDrugInformedConsent" fieldLabel="冷链药品知情同意书"  dicField="custom_h_state" emptyText="" editable="true" forceSelection="false"  columnWidth="0.5" />
				<aos:textfield name="hr" fieldLabel="项目专员" maxLength="100" columnWidth="0.49" />
				
				<aos:textfield name="langMuHospital" fieldLabel="朗沐医院" maxLength="100" columnWidth="0.5" />
				<aos:textfield name="langMuDoctor" fieldLabel="朗沐医生" maxLength="100" columnWidth="0.49" />
				
				<aos:combobox name="estimatedTimeToIncreaseDrugInjection" fieldLabel="预计增药注射时间"  dicField="custom_h_state" emptyText="" editable="true" forceSelection="false"  columnWidth="0.5" />
				<aos:textfield name="remarks" fieldLabel="备注" maxLength="100" columnWidth="0.49" />
				
				<aos:combobox name="recipientsReceiveSingleDrug" fieldLabel="受助药品领取单"  dicField="custom_h_state" emptyText="" editable="true" forceSelection="false"  columnWidth="0.5" />
				<aos:combobox name="endOfStatement" fieldLabel="捐助结束声明"  dicField="custom_h_state" emptyText="" editable="true" forceSelection="false"  columnWidth="0.49" />
				
			</aos:fieldset>
		</aos:formpanel>
		<aos:docked dock="bottom" ui="footer">
			<aos:dockeditem xtype="tbfill" />
			<aos:dockeditem onclick="_f_user_save" text="保存" icon="ok.png" />
			<aos:dockeditem onclick="#_w_user.hide();" text="关闭" icon="close.png" />
		</aos:docked>
	</aos:window>

	<aos:window id="_w_user_u" title="修改用户" onshow="_w_user_u_onshow" width="720" maxHeight="-10" autoScroll="true">
		<aos:formpanel id="_f_user_u" width="700" layout="column" labelWidth="70">
			<aos:hiddenfield fieldLabel="xxxxx" name="id" />
			<aos:fieldset title="" labelWidth="120" labelAlign="right" center="true" collapsible="false">
				<aos:textfield name="archives" fieldLabel="档案号"  maxLength="100" columnWidth="0.5" />
				<aos:combobox fieldLabel="是否通过" name="state"  dicField="custom_patient_state" emptyText="未通过" value="0" columnWidth="0.49" />
					
				<aos:textfield name="name" fieldLabel="姓名"  maxLength="100" columnWidth="0.5" />
				<aos:combobox fieldLabel="性别" name="sex" dicField="custom_sex" emptyText="男" value="0" columnWidth="0.49" />
					
				<aos:textfield name="idcardnumber" fieldLabel="身份证号"   maxLength="20" columnWidth="0.5" />
				<aos:textfield name="phone" fieldLabel="联系电话"  columnWidth="0.49" />
				
				<aos:textfield name="address" fieldLabel="住址" maxLength="100" columnWidth="0.5" />
				<aos:combobox name="diagnosticMaterial" fieldLabel="诊断材料" dicField="custom_h_state" emptyText="" editable="true" forceSelection="false" columnWidth="0.49" />
				
				<aos:combobox name="proofIdentity" fieldLabel="身份证明"  dicField="custom_h_state" emptyText="" editable="true" forceSelection="false"  columnWidth="0.5" />
				<aos:combobox name="proofIncome" fieldLabel="收入证明"  dicField="custom_h_state" emptyText="" editable="true" forceSelection="false"  columnWidth="0.49" />
				
				<aos:combobox name="purchaseInvoice" fieldLabel="购药发票"  dicField="custom_h_state" emptyText="" editable="true" forceSelection="false"  columnWidth="0.5" />
				<aos:combobox name="medicalEvaluationForm" fieldLabel="医学评估表"  dicField="custom_h_state" emptyText="" editable="true" forceSelection="false"  columnWidth="0.49" />
				
				<aos:combobox name="informedConsentOfPatients" fieldLabel="患者知情同意函"  dicField="custom_h_state" emptyText="" editable="true" forceSelection="false"  columnWidth="0.5" />
				<aos:combobox name="patienteConomicStatus" fieldLabel="患者经济状况填报表"  dicField="custom_h_state" emptyText="" editable="true" forceSelection="false"  columnWidth="0.49" />
				
				<aos:combobox name="coldChainDrugInformedConsent" fieldLabel="冷链药品知情同意书"  dicField="custom_h_state" emptyText="" editable="true" forceSelection="false"  columnWidth="0.5" />
				<aos:textfield name="hr" fieldLabel="项目专员" maxLength="100" columnWidth="0.49" />
				
				<aos:textfield name="langMuHospital" fieldLabel="朗沐医院" maxLength="100" columnWidth="0.5" />
				<aos:textfield name="langMuDoctor" fieldLabel="朗沐医生" maxLength="100" columnWidth="0.49" />
				
				<aos:combobox name="estimatedTimeToIncreaseDrugInjection" fieldLabel="预计增药注射时间"  dicField="custom_h_state" emptyText="" editable="true" forceSelection="false"  columnWidth="0.5" />
				<aos:textfield name="remarks" fieldLabel="备注" maxLength="100" columnWidth="0.49" />
				
				<aos:combobox name="recipientsReceiveSingleDrug" fieldLabel="受助药品领取单"  dicField="custom_h_state" emptyText="" editable="true" forceSelection="false"  columnWidth="0.5" />
				<aos:combobox name="endOfStatement" fieldLabel="捐助结束声明"  dicField="custom_h_state" emptyText="" editable="true" forceSelection="false"  columnWidth="0.49" />
				
			</aos:fieldset>
		</aos:formpanel>
		<aos:docked dock="bottom" ui="footer">
			<aos:dockeditem xtype="tbfill" />
			<aos:dockeditem onclick="_f_user_u_save" text="保存" icon="ok.png" />
			<aos:dockeditem onclick="#_w_user_u.hide();" text="关闭" icon="close.png" />
		</aos:docked>
	</aos:window>

	<script type="text/javascript">

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

            //新增用户保存
            function _f_user_save() {
                AOS.ajax({
                    forms: _f_user,
                    url: 'savePatien.jhtml',
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
                    url: 'getPatient.jhtml',
                    ok: function (data) {
                        _f_user_u.form.setValues(data);
                    }
                });
            }

            //修改用户保存
            function _f_user_u_save() {
            	var record = AOS.selectone(_g_user);
                AOS.ajax({
                    forms: _f_user_u,
                    url: 'updatePatient.jhtml',
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
                        url: 'deletePatient.jhtml',
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
					url : 'exportExcel.jhtml',
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