<%@ page contentType="text/html; charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/common/tags.jsp"%>
<aos:html>
<aos:head>
	<aos:include lib="ext" />
</aos:head>
<aos:body>
</aos:body>
<aos:onready>
	<aos:viewport>
		<aos:panel id="id_panels" region="center" bodyPadding="2" height="400" margin="20" split="true" title="vbox布局"
			width="600" collapsible="true">
			<aos:layout type="vbox" align="stretch" />
			<aos:panel title="上海" html="上海" flex="1" padding="2">
			</aos:panel>
			<aos:panel title="深圳" html="深圳" flex="2" padding="2">
			</aos:panel>
			<aos:panel title="苏州" html="苏州" flex="3" padding="2">
			</aos:panel>
			<aos:panel title="昆明" html="昆明" flex="1" padding="2">
			</aos:panel>
		</aos:panel>
	</aos:viewport>
</aos:onready>
</aos:html>