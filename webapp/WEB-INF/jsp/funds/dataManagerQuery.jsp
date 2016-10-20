<%@ page contentType="text/html; charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/common/tags.jsp"%>
<aos:html>
<aos:head title="数据管理">
	<aos:include lib="ext" />
	<aos:base href="funds/" />
</aos:head>
<aos:body>
</aos:body>
<aos:onready>
	<aos:viewport layout="border">
		<aos:gridpanel id="_g_user" region="center" onrender="_g_user_query" url="patient/queryPatientList.jhtml">
			<aos:docked forceBoder="0 0 1 0">
				<aos:dockeditem xtype="tbseparator" />
				<aos:combobox editable="false"  id="patient_query_type" name="patient_query_type" dicField="custom_patient_query" value="0"  width="90"/>
				<aos:triggerfield emptyText="请输入关键字" name="hotkey" id="_hotkey" onenterkey="_g_user_query"
					trigger1Cls="x-form-search-trigger" onTrigger1Click="_g_user_query" width="180" />
				<aos:dockeditem xtype="tbfill" />
			</aos:docked>
			
			<aos:selmodel type="checkbox" mode="multi" />
			<aos:column type="rowno" />
			<aos:column header="流水号" dataIndex="id" hidden="true" maxWidth="1000"/>
			<aos:column header="是否通过" dataIndex="catalog_id_" hidden="true" maxWidth="1000"/>
			<aos:column header="档案编号" dataIndex="archives" minWidth="70" celltip="true" maxWidth="1000" />
			<aos:column header="是否通过" dataIndex="state" minWidth="70" celltip="true" maxWidth="1000"/>
			<aos:column header="姓名" dataIndex="name" minWidth="70" celltip="true" maxWidth="1000"/>
			<aos:column header="性别" dataIndex="sex" minWidth="70" celltip="true" maxWidth="1000"/>
			<aos:column header="省份" dataIndex="province" minWidth="70" celltip="true" maxWidth="1000"/>
			<aos:column header="申请类型" dataIndex="applyType" minWidth="70" celltip="true" maxWidth="1000"/>
			<aos:column header="住址" dataIndex="address" minWidth="70" celltip="true" maxWidth="1000"/>
			<aos:column header="联系电话" dataIndex="phone" minWidth="70" celltip="true" maxWidth="1000"/>
			<aos:column header="身份号证" dataIndex="idcardnumber" minWidth="70" celltip="true" maxWidth="1000"/>
			<aos:column header="患者类型" dataIndex="patientType" minWidth="70" celltip="true" maxWidth="1000"/>
			<aos:column header="诊断材料" dataIndex="diagnosticMaterial" minWidth="70" celltip="true" maxWidth="1000"/>
			<aos:column header="身份证明" dataIndex="proofIdentity" minWidth="70" celltip="true" maxWidth="1000"/>
			<aos:column header="收入证明" dataIndex="proofIncome" minWidth="70" celltip="true" maxWidth="1000"/>
			<aos:column header="购药发票" dataIndex="purchaseInvoice" minWidth="70" celltip="true" maxWidth="1000"/>
			<aos:column header="医学评估表" dataIndex="medicalEvaluationForm" minWidth="80" celltip="true" maxWidth="1000"/>
			<aos:column header="患者知情同意函" dataIndex="informedConsentOfPatients" minWidth="120" celltip="true" maxWidth="1000"/>
			<aos:column header="患者经济状况填报表" dataIndex="patienteConomicStatus" minWidth="120" celltip="true" maxWidth="1000"/>
			<aos:column header="冷链药品知情同意书" dataIndex="coldChainDrugInformedConsent" minWidth="120" celltip="true" maxWidth="1000"/>
			<aos:column header="项目专员" dataIndex="hr" minWidth="70" celltip="true" maxWidth="1000"/>
			<aos:column header="朗沐医院" dataIndex="langMuHospital" minWidth="70" celltip="true" maxWidth="1000"/>
			<aos:column header="朗沐医生" dataIndex="langMuDoctor" minWidth="70" celltip="true" maxWidth="1000"/>
			<aos:column header="预计增药注射时间" dataIndex="estimatedTimeToIncreaseDrugInjection" minWidth="120" celltip="true" maxWidth="1000"/>
			<aos:column header="备注" dataIndex="remarks" minWidth="70" celltip="true" maxWidth="1000"/>
			<aos:column header="诊断医院是否为朗沐医院"  dataIndex="isLangMuHospital" minWidth="130" celltip="true" maxWidth="1000"/>
			<aos:column header="通过日期"  dataIndex="passdate" minWidth="120" celltip="true"  maxWidth="1000"/>
			<aos:column header="受助药品领取单" dataIndex="recipientsReceiveSingleDrug" minWidth="120" celltip="true" maxWidth="1000"/>
			<aos:column header="捐助结束声明" dataIndex="endOfStatement" minWidth="120" celltip="true" maxWidth="1000"/>
			<aos:column header="年份" dataIndex="year" minWidth="70" celltip="true" maxWidth="1000"/>
			<aos:column header=""   minWidth="1" flex="1" maxWidth="1000"/>
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