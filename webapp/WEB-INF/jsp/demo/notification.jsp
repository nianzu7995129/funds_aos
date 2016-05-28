<%@ page contentType="text/html; charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/common/tags.jsp"%>
<aos:html>
<aos:head title="通知提示框">
	<aos:include lib="ext" />
	<aos:base href="demo" />
</aos:head>
<aos:body backGround="true">
</aos:body>
<aos:onready>
	<aos:viewport layout="hbox" margin="150">
		<aos:button text="滑动通知(标准)" onclick="fnnoti1" margin="10" />
		<aos:button text="滑动通知(标准)" onclick="fnnoti2" margin="10" />
		<aos:button text="滑动通知(标准)" onclick="fnnoti6" margin="10" />
		<aos:button text="滑动通知(美化)" onclick="fnnoti3" margin="10" />
		<aos:button text="滑动通知(美化)" onclick="fnnoti4" margin="10" />
		<aos:button text="系统提示(封装)" onclick="fnnoti5" margin="10" />
	</aos:viewport>

	<script type="text/javascript">
	    var msg1 = '基金救助平台';
		
	    function fnnoti1() {
			Ext.create(
							'widget.uxNotification',
							{
								position : 'br',
								title : '<span class="app-container-title-normal"><i class="fa fa-bell-o"></i> 通知</span>',
								closable : false,
								autoCloseDelay : 2000,
								slideInDuration : 200,
								useXAxis : false,
								width : 400,
								html : msg1
							}).show();
		}

		function fnnoti6() {
			Ext.create(
							'widget.uxNotification',
							{
								position : 'bl',
								title : '<span class="app-container-title-normal"><i class="fa fa-bell-o"></i> 通知</span>',
								closable : false,
								autoCloseDelay : 2000,
								slideInDuration : 200,
								useXAxis : true,
								width : 400,
								html : msg1
								}).show();
		}

		function fnnoti2() {
			Ext.create(
							'widget.uxNotification',
							{
								position : 'tl',
								title : '<span class="app-container-title-normal"><i class="fa fa-volume-up"></i> 通知</span>',
								closable : true,
								autoCloseDelay : 1000,
								slideInDuration : 1500,
								slideInAnimation : 'elasticIn',
								html : '细节决定成败，态度决定品质！'
							}).show();
		}

		function fnnoti3() {
			Ext.create(
							'widget.uxNotification',
							{
								position : 't',
								cls : 'ux-notification-light',
								closable : true,
								title : '<span class="app-container-title-normal"><i class="fa fa-bell-o"></i> 通知</span>',
								slideInDuration : 200,
								slideBackDuration : 1000,
								autoCloseDelay : 2000,
								slideInAnimation : 'ease',
								html : '细节决定成败，态度决定品质！'
							}).show();
		}

		function fnnoti4() {
			Ext.create(
							'widget.uxNotification',
							{
								position : 'tr',
								cls : 'ux-notification-light',
								closable : true,
								title : '<span class="app-container-title-normal"><i class="fa fa-bell-o"></i> 通知</span>',
								slideInDuration : 200,
								autoCloseDelay : 1000,
								width : 320,
								html : "It's AOS, enjoy it!"
							}).show();
		}

		function fnnoti5() {
			AOS.tip('AOS应用基础平台');
		}
		
		AOS.job(fnnoti1(),1000);
		AOS.job(fnnoti2(),3000);
		AOS.job(fnnoti3(),5000);
		AOS.job(fnnoti4(),7000);
		AOS.job(fnnoti5(),8000);
		AOS.job(fnnoti6(),9000);
		
	</script>
</aos:onready>
</aos:html>