<%@ page contentType="text/html; charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/common/tags.jsp"%>
<aos:html>
<aos:head title="${app_title}">
	<aos:base href="/" />
	<aos:include lib="ext" />
	<style>
.bodyclass {
	background-image:
		url('${cxt}/static/image/background/${login_back_img}');
	background-size: 100%;
	background-color: #1BA3F9;
	background-repeat: no-repeat;
}

.north_el {
	height: 80px;
	padding-top: 8px;
	background-image:
		url('${cxt}/static/image/background/login/${north_back_img_}');
}
</style>
</aos:head>
<aos:body class2="bodyclass">
	<div id="_north_el" class="x-hidden north_el">
		<table>
			<tr>
				<td align="left" width="360"><img id="_logo_l" src="${cxt}/static/image/logo/${left_logo_}"></td>
			</tr>
		</table>
	</div>
	<div id="_div_vercode" class="x-hidden " align="center">
		<aos:vercode id="_vercode" fontSize="28" characters="${vercode_characters}" length="${vercode_length}" />
	</div>
</aos:body>

<aos:onready elAuth="false">
	<aos:window id="_w_login" title="欢迎使用${app_name}" autoShow="false" closable="false" modal="false" draggable="false"
		onshow="_w_login_onshow" resizable="false" opacity="0" y="0" width="550" layout="anchor"
		header="${show_login_win_head}">
		<aos:panel contentEl="_north_el" anchor="100%">

		</aos:panel>
		<aos:tabpanel id="_id_tabs" activeTab="0" plain="false" tabBarHeight="30" height="250" anchor="100%">
			<aos:formpanel id="_f_query" layout="column" labelWidth="90"  title="患者查询" border="false" padding="${padding} 0 0 0"
				msgTarget="qtip" rowSpace="${rowSpace}">
				<aos:textfield fieldLabel="姓名" name="name_" maxLength="25" allowBlank="false" star="false" height="28"
					onenterkey="fn_query_enter" columnWidth="1" margin="0 60 0 0" />
				<aos:textfield fieldLabel="身份证" name="cdcard_" maxLength="20" allowBlank="false" star="false"
					onenterkey="fn_query_enter" height="28" columnWidth="1" margin="0 60 0 0" />
				<aos:combobox fieldLabel="申请类型" name="applyType_"  dicField="custom_apply_type" emptyText="正常申请" value="0" star="false"
					onenterkey="fn_query_enter" columnWidth="1" margin="0 60 0 0" />	
				<aos:docked dock="bottom" ui="footer">
					<aos:dockeditem xtype="tbfill" />
					<aos:dockeditem xtype="button" onclick="_fn_query" icon="user6.png" text="查 询" tooltip="查询信息" />
					<aos:dockeditem xtype="button" onclick="_fn_reset1" icon="icon140.png" text="重 置" tooltip="重置身份认证表单" />
				</aos:docked>
			</aos:formpanel>
			<aos:formpanel id="_f_login" layout="column" labelWidth="90" border="false" title="工作管理" padding="${padding} 0 0 0"
				msgTarget="qtip" rowSpace="${rowSpace}">
				<aos:textfield fieldLabel="帐 号" name="account_" maxLength="25" allowBlank="false" star="false" height="28"
					onenterkey="fn_account_enter" columnWidth="1" margin="0 60 0 0" />
				<aos:textfield fieldLabel="密  码" name="password_" maxLength="20" allowBlank="false" star="false"
					onenterkey="fn_password_enter" inputType="password" height="28" columnWidth="1" margin="0 60 0 0" />
				<c:if test="${vercode_show == '1' }">
					<aos:textfield fieldLabel="验证码" name="vercode" maxLength="${vercode_length}" allowBlank="false" star="false"
						height="28" columnWidth="0.7" onenterkey="_fn_login" margin="0 15 0 0" />
					<aos:fieldset labelWidth="65" columnWidth="0.3" height="30" collapsible="false" contentEl="_div_vercode"
						border="false" margin="0 60 0 0" />
				</c:if>
				<aos:docked dock="bottom" ui="footer">
					<aos:dockeditem xtype="tbfill" />
					<aos:dockeditem xtype="button" onclick="_fn_login" icon="user6.png" text="登 录" tooltip="登录系统" />
					<aos:dockeditem xtype="button" onclick="_fn_reset" icon="icon140.png" text="重 置" tooltip="重置账号认证表单" />
				</aos:docked>
			</aos:formpanel>
		</aos:tabpanel>
		
	</aos:window>
	
	<aos:window id="_w_p_query" title="患者查询" maxHeight="-10" width="720" autoScroll="true">
		<aos:formpanel id="_f_p_query" width="700" layout="column">
			<aos:fieldset title="基本信息" labelWidth="120" labelAlign="right" center="true" collapsible="false">
				<aos:textfield name="archives_" fieldLabel="档案号"  maxLength="100" columnWidth="0.5" readOnly="true"/>
				<aos:textfield fieldLabel="是否通过" name="state_"  readOnly="true" columnWidth="0.49" />
					
				<aos:textfield name="name_" fieldLabel="姓名"   readOnly="true" maxLength="100" columnWidth="0.5" />
				<aos:textfield fieldLabel="性别" name="sex_"  readOnly="true"  columnWidth="0.49" />
					
				<aos:textfield name="idcardnumber_" fieldLabel="身份证号"  readOnly="true"   maxLength="20" columnWidth="0.5" />
				<aos:textfield name="phone_" fieldLabel="联系电话"   readOnly="true" columnWidth="0.49" />
				
				<aos:textfield name="address_" fieldLabel="住址"  readOnly="true" maxLength="100" columnWidth="0.5" />
				<aos:textfield name="diagnosticMaterial_" fieldLabel="诊断材料"  readOnly="true" columnWidth="0.49" />
				
				<aos:textfield name="proofIdentity_" fieldLabel="身份证明"   readOnly="true"  columnWidth="0.5" />
				<aos:textfield name="proofIncome_" fieldLabel="收入证明"   readOnly="true"   columnWidth="0.49" />
				
				<aos:textfield name="purchaseInvoice_" fieldLabel="购药发票"   readOnly="true"  columnWidth="0.5" />
				<aos:textfield name="medicalEvaluationForm_" fieldLabel="医学评估表"   readOnly="true"   columnWidth="0.49" />
				
				<aos:textfield name="informedConsentOfPatients_" fieldLabel="患者知情同意函"   readOnly="true"  columnWidth="0.5" />
				<aos:textfield name="patienteConomicStatus_" fieldLabel="患者经济状况填报表"   readOnly="true"   columnWidth="0.49" />
				
				<aos:textfield name="coldChainDrugInformedConsent_" fieldLabel="冷链药品知情同意书"   readOnly="true"  columnWidth="0.5" />
				
			</aos:fieldset>
		</aos:formpanel>
		<aos:docked dock="bottom" ui="footer">
			<aos:dockeditem xtype="tbfill" />
			<aos:dockeditem onclick="#_w_p_query.hide();" text="关闭" icon="close.png" />
		</aos:docked>
	</aos:window>
	
	<script type="text/javascript">
	
		var states = Ext.create('Ext.data.Store', {
		    fields: ['sex_', 'name'],
		    data : [
		        {"sex_":"AL", "name":"Alabama"},
		        {"sex_":"AK", "name":"Alaska"},
		        {"sex_":"AZ", "name":"Arizona"}
		    ]
		});
	
		_w_login.show();
		
		//弹出新增用户窗口
        function _w_p_query_show() {
            AOS.reset(_f_p_query);
            //var record = AOS.selectone(_t_org);
            //if (!AOS.empty(record)) {
                //_f_user.down('[name=org_id_]').setValue(record.raw.id);
                //_f_user.down('[name=org_name_]').setValue(record.raw.text);
            //}
            _w_p_query.show();
        }

		//窗口显示监听事件
		function _w_login_onshow() {
			var cmp = AOS.get('_f_login.account_');
			cmp.focus();
		}

		//响应窗口变化事件
		Ext.EventManager.onWindowResize(function() {
			//_w_login.center();
			var left = (Ext.getBody().getViewSize().width - 550) / 2;
			var top = (Ext.getBody().getViewSize().height - 430) / 2;
			_w_login.setPosition(left, top, true)
		});

		//监听帐号输入框回车键
		function fn_account_enter(obj) {
			if (AOS.empty(obj.getValue())) {
				obj.validate();
			} else {
				AOS.field(_f_login, 'password_').focus();
			}
		}
		//监听密码输入框回车键
		function fn_query_enter(obj) {
			if (AOS.empty(obj.getValue())) {
				obj.validate();
			} else {
				_fn_query();
			}
		}
		

		//监听密码输入框回车键
		function fn_password_enter(obj) {
			if (AOS.empty(obj.getValue())) {
				obj.validate();
			} else {
				if('${vercode_show}' === '1'){
					AOS.field(_f_login, 'vercode').focus();
				}else{
					_fn_login();
				}
			}
		}

		//登录窗口动画
		Ext.create('Ext.fx.Animator', {
			target : _w_login,
			duration : 1000,
			easing : 'backOut',
			//easing : 'ease',
			delay : 0,
			keyframes : {
				0 : {
					opacity : 0,
					top : 0
				},
				100 : {
					opacity : 0.8,
					top : (Ext.getBody().getViewSize().height - 430) / 2
				}
			}
		});

		//验证码首次加载动画
		var _el_vercode = Ext.get('_vercode');
		var _vercode_task = new Ext.util.DelayedTask(function() {
			_el_vercode.switchOff();
			_el_vercode.fadeIn();
		});
		_vercode_task.delay(1000);

		//表单校验
		function _fn_check() {
			var flag = _f_login.isValid();
			//可以继续做其它检查，验证不通过则flag=false即可
			//
			return flag;
		}
		
		//表单校验
		function _fn_checkQuery() {
			var flag = _f_query.isValid();
			//可以继续做其它检查，验证不通过则flag=false即可
			//
			return flag;
		}
		
		//查询提交
		function _fn_query() {
			if (!_fn_checkQuery()) {
				return;
			}
			AOS.mask('正在进行查询,请稍候...');
			AOS.ajax({
				forms : _f_query,
				url : 'doQuery.jhtml',
				wait : false,
				ok : function(data) {
					AOS.unmask();
					if (data.appcode === 1) {
						AOS.reset(_f_p_query);
					 	AOS.field(_f_p_query, 'name_').setValue(data.name);
					 	AOS.field(_f_p_query, 'archives_').setValue(data.archives);
					 	AOS.field(_f_p_query, 'state_').setValue(data.state);
					 	AOS.field(_f_p_query, 'sex_').setValue(data.sex);
					 	AOS.field(_f_p_query, 'idcardnumber_').setValue(data.idcardnumber);
					 	AOS.field(_f_p_query, 'phone_').setValue(data.phone);
					 	AOS.field(_f_p_query, 'address_').setValue(data.address);
					 	AOS.field(_f_p_query, 'diagnosticMaterial_').setValue(data.diagnosticMaterial);
					 	AOS.field(_f_p_query, 'proofIdentity_').setValue(data.proofIdentity);
					 	AOS.field(_f_p_query, 'proofIncome_').setValue(data.proofIncome);
					 	AOS.field(_f_p_query, 'purchaseInvoice_').setValue(data.purchaseInvoice);
					 	AOS.field(_f_p_query, 'medicalEvaluationForm_').setValue(data.medicalEvaluationForm);
					 	AOS.field(_f_p_query, 'informedConsentOfPatients_').setValue(data.informedConsentOfPatients);
					 	AOS.field(_f_p_query, 'patienteConomicStatus_').setValue(data.patienteConomicStatus);
					 	AOS.field(_f_p_query, 'coldChainDrugInformedConsent_').setValue(data.coldChainDrugInformedConsent);
			            _w_p_query.show();
					} else {
						AOS.unmask();
						AOS.info(data.appmsg, function() {
							if (data.appcode === -1) {
								//姓名错误
								AOS.field(_f_query, 'name_').focus();
							} else if (data.appcode === -2) {
								//身份证错误
								AOS.field(_f_query, 'cdcard_').focus();
							}
						});
					}
				}
			});
		}

		//登录提交
		function _fn_login() {
			if (!_fn_check()) {
				return;
			}
			AOS.mask('正在进行身份认证,请稍候...');
			AOS.ajax({
				forms : _f_login,
				url : 'doLogin.jhtml',
				wait : false,
				ok : function(data) {
					if (data.appcode === 1) {
						window.location.href = 'index.jhtml';
					} else {
						AOS.unmask();
						AOS.info(data.appmsg, function() {
							if (data.appcode === -1) {
								//验证码错误
								AOS.field(_f_login, 'vercode').focus();
							} else if (data.appcode === -2) {
								//帐号错误
								AOS.field(_f_login, 'account_').focus();
							} else if (data.appcode === -3) {
								//密码错误
								AOS.field(_f_login, 'password_').reset();
								AOS.field(_f_login, 'password_').focus();
								AOS.field(_f_login, 'password_').validate();
							}
						});
					}
				}
			});
		}

		//登录窗口重置
		function _fn_reset() {
			_f_login.form.reset();
		}
		
		//查询重置
		function _fn_reset1() {
			_f_query.form.reset();
		}
	</script>
</aos:onready>
</aos:html>