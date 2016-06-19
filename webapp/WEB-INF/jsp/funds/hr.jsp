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
		<aos:gridpanel id="_g_user" region="center" onrender="_g_user_query" url="queryPatientListHR.jhtml" enableLocking="false">
			<aos:docked forceBoder="0 0 1 0">
				<aos:dockeditem xtype="tbseparator" />
				<aos:combobox id="patient_query_type" name="patient_query_type" dicField="custom_hr_query" value="0"  width="90"/>
				<aos:triggerfield emptyText="请输入关键字" name="hotkey" id="_hotkey" onenterkey="_g_user_query"
					trigger1Cls="x-form-search-trigger" onTrigger1Click="_g_user_query" width="180" />
				<aos:dockeditem xtype="tbfill" />
			</aos:docked>
			
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
			<aos:column header="通过日期"  dataIndex="passdate" width="120" celltip="true" />
			<aos:column header="150/82" dataIndex="other1" width="120" celltip="true" />
			<aos:column header="1243" dataIndex="other2" width="120" celltip="true" />
			<aos:column header="2016新申请" dataIndex="other3" width="120" celltip="true" />
			<aos:column header="2016复申请" dataIndex="other4" width="120" celltip="true" />
			<aos:column header="1519" dataIndex="other5" width="120" celltip="true" />
			<aos:column header=""   width="1" flex="1"/>
		</aos:gridpanel>
	</aos:viewport>
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

        </script>
</aos:onready>
</aos:html>