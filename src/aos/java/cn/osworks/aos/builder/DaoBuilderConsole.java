package cn.osworks.aos.builder;

import java.sql.Connection;
import java.sql.SQLException;

import cn.osworks.aos.builder.asset.DriverManagerOpt;
import cn.osworks.aos.builder.metainfo.DBMetaInfoUtils;
import cn.osworks.aos.core.dao.asset.DBType;
import cn.osworks.aos.core.typewrap.Dto;
import cn.osworks.aos.core.typewrap.Dtos;

/**
 * 数据访问层代码生成器
 * 
 * <p>
 * 提示：已经支持可视化生成。请访问：开发工具箱->WebIDE集成开发。
 * 
 * @author OSWorks-XC
 * @throws SQLException 
 */
public class DaoBuilderConsole {

	public static void main(String[] args) throws SQLException {
		//===================
		DriverManagerOpt driverOpt = new DriverManagerOpt();
		//当前版本支持mysql、oracle、sqlserver2005+、H2
		driverOpt.setDataBaseType(DBType.MYSQL); 
		driverOpt.setIp("localhost");
		driverOpt.setPort("3306");
		//数据库名或数据库实例名
		//driverOpt.setCatalog("./webapp/WEB-INF/db/aos");
		driverOpt.setCatalog("funds");
		driverOpt.setUserName("root");
		driverOpt.setPassword("123");
		//===================
		Dto dto = Dtos.newDto();
		//改为自己存放Dao相关文件的磁盘文件路径
		//dto.put("outPath", "F:\\01.系统开发平台\\01.程序\\src\\aos\\java\\cn\\osworks\\aos\\system\\dao");
		dto.put("outPath", "E:/privateWork/01.PROJECT/src/project/java/com/zhqq/funds/dao");
		//改为自己Dao相关文件的包路径
		dto.put("package", "com.zhqq.funds.dao");
		dto.put("author", "zhqq");
		//指定多张表请用逗号分隔；
		//!!表名区分大小写的喔
		dto.put("tables", "t_drugRelease;t_patient");
		//===================
		Connection connection = DBMetaInfoUtils.newConnection(driverOpt);
		DaoBuilder.build(connection, dto);
		connection.close();
	}

}
