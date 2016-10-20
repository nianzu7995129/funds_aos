<%@ page contentType="text/html; charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/common/tags.jsp"%>
<aos:html>
<aos:head title="医药下发">
	<aos:include lib="ext" />
	<aos:base href="funds/md" />
</aos:head>
<aos:body>
</aos:body>
<aos:onready>
	<aos:viewport layout="border">
		<aos:gridpanel id="_g_user" region="center" onrender="_g_user_query" url="queryMDList.jhtml"
			>
			<aos:docked forceBoder="0 0 1 0">
				<aos:dockeditem xtype="tbseparator" />
				<aos:dockeditem text="新增" tooltip="新增医药下发" onclick="_w_user_show" icon="add.png" />
				<aos:dockeditem text="修改" tooltip="修改医药下发" onclick="_w_user_u_show" icon="edit.png" />
				<aos:dockeditem text="删除" tooltip="删除医药下发" onclick="_g_user_del" icon="del.png" />
				<aos:dockeditem xtype="tbseparator" />
				<aos:dockeditem text="导出" tooltip="导出医药下发信息成Excel" onclick="_g_user_export" icon="icon9.png" />
				<aos:dockeditem xtype="tbseparator" />
				<aos:combobox editable="false"   id="md_md_type" name="md_md_type" dicField="custom_md_query" value="0"  width="90"/>
				<aos:triggerfield emptyText="请输入关键字" name="hotkey" id="_hotkey" onenterkey="_g_user_query"
					trigger1Cls="x-form-search-trigger" onTrigger1Click="_g_user_query" width="180" />
				<aos:dockeditem xtype="tbseparator" />
				<aos:combobox id="md_date_type" name="md_date_type" dicField="custom_md_date" value="5"  width="135"/>
				<aos:dockeditem xtype="tbfill" />
			</aos:docked>
			
			<aos:selmodel type="checkbox" mode="multi" />
			<aos:column type="rowno" />
			<aos:column header="流水号" dataIndex="id" hidden="true" />
			<aos:column header="操作" dataIndex="state" width="100" celltip="true"  rendererFn="fn_button_render" />
			<aos:column header="患者编码" dataIndex="patientCode" width="100" celltip="true" />
			<aos:column header="患者名称" dataIndex="name" width="100" celltip="true" />
			<aos:column header="联系电话" dataIndex="phone" width="100" celltip="true" />
			<aos:column header="已领赠药次数/瓶数" dataIndex="takenDrugNumber" width="200" celltip="true" />
			<aos:column header="当前剂量" dataIndex="currentDose" width="100" celltip="true" />
			<aos:column header="预计下次发药时间" dataIndex="expectedNexttime" width="200" celltip="true" />
			<aos:column header="入组医院" dataIndex="hospitalGroup" width="200" celltip="true" />
			<aos:column header="正式入组日期" dataIndex="formalEntryTime" width="120" celltip="true" />
			<aos:column header="病种" dataIndex="disease" width="100" celltip="true" />
			<aos:column header=""   width="1" flex="1"/>
		</aos:gridpanel>
	</aos:viewport>

	<aos:window id="_w_user" title="新增医药查询" maxHeight="-10" width="500" autoScroll="true">
		<aos:formpanel id="_f_user" width="480" layout="column">
			<aos:hiddenfield fieldLabel="xxxxx" name="state"  value="0"/>
			<aos:fieldset title="" labelWidth="110" labelAlign="right" center="true" collapsible="false">
				<aos:textfield name="patientCode" fieldLabel="患者编码"  maxLength="100" columnWidth="0.5" />
				<aos:textfield name="name"  fieldLabel="患者名称"  columnWidth="0.49" />
					
				<aos:textfield name="phone" fieldLabel="联系电话"  maxLength="100" columnWidth="0.5" />
				<aos:combobox  name="sex"  fieldLabel="性别" dicField="custom_sex" emptyText="男" value="0" columnWidth="0.49" />
					
				<aos:textfield name="idcardnumber" fieldLabel="身份证号"   maxLength="20" columnWidth="0.5" />
				<aos:textfield name="takenDrugNumber" fieldLabel="已领药品次数.数量"  columnWidth="0.49" />
				
				<aos:textfield name="currentDose" fieldLabel="当前剂量" maxLength="100" columnWidth="0.5" />
				<aos:datefield name="expectedNexttime" fieldLabel="预计下次发放时间" format="Y-m-d 00:00:00" editable="false" columnWidth="0.49" />
				
				<aos:textfield name="hospitalGroup" fieldLabel="入组医院"  columnWidth="0.5" />
				<aos:datefield name="formalEntryTime" fieldLabel="正式入组时间" format="Y-m-d 00:00:00" editable="false" columnWidth="0.49" />
				<aos:textfield name="disease" fieldLabel="病种"   columnWidth="0.5" />
				
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
			<aos:hiddenfield fieldLabel="xxxxx" name="state" />
			<aos:fieldset title="" labelWidth="110" labelAlign="right" center="true" collapsible="false">
				<aos:textfield name="patientCode" fieldLabel="患者编码"  maxLength="100" columnWidth="0.5" />
				<aos:textfield name="name"  fieldLabel="患者名称"  columnWidth="0.49" />
					
				<aos:textfield name="phone" fieldLabel="联系电话"  maxLength="100" columnWidth="0.5" />
				<aos:combobox  name="sex"  fieldLabel="性别" dicField="custom_sex" emptyText="男" value="0" columnWidth="0.49" />
					
				<aos:textfield name="idcardnumber" fieldLabel="身份证号"   maxLength="20" columnWidth="0.5" />
				<aos:textfield name="takenDrugNumber" fieldLabel="已领药品次数.数量"  columnWidth="0.49" />
				
				<aos:textfield name="currentDose" fieldLabel="当前剂量" maxLength="100" columnWidth="0.5" />
				<aos:datefield name="expectedNexttime" fieldLabel="预计下次发放时间" format="Y-m-d 00:00:00" editable="false" columnWidth="0.49" />
				
				<aos:textfield name="hospitalGroup" fieldLabel="入组医院"  columnWidth="0.5" />
				<aos:datefield name="formalEntryTime" fieldLabel="正式入组时间" format="Y-m-d 00:00:00" editable="false" columnWidth="0.49" />
				<aos:textfield name="disease" fieldLabel="病种"   columnWidth="0.5" />
				
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
               		mdQueryType: md_md_type.getValue(),
               		mdDateType: md_date_type.getValue()
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
                    url: 'saveMD.jhtml',
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
                    url: 'getMD.jhtml',
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
                    url: 'updateMD.jhtml',
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
                var msg = AOS.merge('确认要删除选中的[{0}]个医药下发数据吗？', AOS.rows(_g_user));
                AOS.confirm(msg, function (btn) {
                    if (btn === 'cancel') {
                        AOS.tip('删除操作被取消。');
                        return;
                    }
                    AOS.ajax({
                        url: 'deleteMD.jhtml',
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
	               		mdQueryType: md_md_type.getValue(),
	               		mdDateType: md_date_type.getValue()
					},
					url : 'exportExcel.jhtml',
					wait : false,
					ok : function(data) {
						AOS.unmask();
						AOS.file('${cxt}/'+data.appmsg);
					}
				});
			}
          
			//按钮列转换
			function fn_button_render(value, metaData, record, rowIndex, colIndex,
					store) {
				return '<input id="state_' + record.data.id + '" type="button" value="' + value + '" class="cbtn" onclick="_w_org_show(' + record.data.id + ');" />';
			}
        </script>
</aos:onready>

<script type="text/javascript">
	//显示详情1窗口
	function _w_org_show(id){
		 var valueTip = document.getElementById("state_"+id).value;
         if(valueTip== "发药"){
        	 AOS.ajax({
    			 params : {
    				    id: id
    				},
                 url: 'updateMDState.jhtml',
                 ok: function (data) {
                     if (data.appcode === -1) {
                         AOS.err(data.appmsg);
                         return;
                     }
                     document.getElementById("state_"+id).value = "已发";
                     AOS.tip(data.appmsg);
                 }
             });
         }
		 
	}
</script>
</aos:html>