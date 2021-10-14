package cn.ws.spring;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.ArrayList;
import java.util.List;

public class Generator
{

	public static void main(String[] args) {

		List<TableFill> tableFillList = new ArrayList<>();
		tableFillList.add(new TableFill("ASDD_SS", FieldFill.INSERT_UPDATE));
		AutoGenerator mpg = new AutoGenerator();
		// 全局配置
		String projectPath = System.getProperty("user.dir");
		GlobalConfig globalConfig = new GlobalConfig()
				.setOutputDir(projectPath + "/src/main/java")//输出目录
				.setFileOverride(true)// 是否覆盖文件
				.setActiveRecord(true)// 开启 activeRecord 模式
				.setEnableCache(false)// XML 二级缓存
				.setBaseResultMap(true)// XML ResultMap
				.setBaseColumnList(true)// XML columList
				//.setSwagger2(true) //实体属性 Swagger2 注解
				.setAuthor("wangshun");
		mpg.setGlobalConfig(globalConfig);
		// 包配置
		PackageConfig packageConfig = new PackageConfig()
				.setParent("com.server")// 自定义包路径
				.setModuleName("ip")//自定义模块名
				.setXml("mapper.ip")//自定义模块名
				.setMapper("mapper.ip")//自定义模块名
				.setController("controller");// 这里是控制器包名，默认 web
		mpg.setPackageInfo(packageConfig);
		// 数据源配置
		DataSourceConfig dataSourceConfig = new DataSourceConfig()
				.setDbType(DbType.MYSQL)
				.setDriverName("com.mysql.jdbc.Driver")
				.setUsername("root")
				.setPassword("root")
				.setUrl("jdbc:mysql://192.168.1.71:3306/ip_behavior?useUnicode=true&useSSL=false&characterEncoding=utf8")
				// 自定义数据库表字段类型转换【可选】
				.setTypeConvert(new MySqlTypeConvert() {
					@Override
					public DbColumnType processTypeConvert(GlobalConfig globalConfig, String fieldType) {
						if (fieldType.toLowerCase().contains("tinyint")) {
							return DbColumnType.BOOLEAN;
						}
						if (fieldType.toLowerCase().contains("timestamp")) {
							return DbColumnType.DATE;
						}
						return (DbColumnType) super.processTypeConvert(globalConfig, fieldType);
					}
				});
		mpg.setDataSource(dataSourceConfig);



		// 策略配置
		StrategyConfig strategyConfig = new StrategyConfig()
				// 全局大写命名
				.setCapitalMode(true)
				//全局下划线命名
				// .setDbColumnUnderline(true)
				// 此处可以修改为您的表前缀
				.setTablePrefix(new String[]{"smtk_", ""})
				// 表名生成策略
				.setNaming(NamingStrategy.underline_to_camel)
				.setColumnNaming(NamingStrategy.no_change)
				// 需要生成的表
				// .setInclude(new String[] { "user" })
				// 排除生成的表
				// .setExclude(new String[]{"test"})
				// 自定义实体父类
				// .setSuperEntityClass("com.baomidou.demo.TestEntity")
				// 自定义实体，公共字段
				//.setSuperEntityColumns(new String[]{"test_id"})
				// 自定义 mapper 父类
				// .setSuperMapperClass("com.baomidou.demo.TestMapper")
				// 自定义 service 父类
				// .setSuperServiceClass("com.baomidou.demo.TestService")
				// 自定义 service 实现类父类
				// .setSuperServiceImplClass("com.baomidou.demo.TestServiceImpl")
				// 自定义 controller 父类
				// .setSuperControllerClass("com.baomidou.demo.TestController")
				// 【实体】是否生成字段常量（默认 false）
				// public static final String ID = "test_id";
				// .setEntityColumnConstant(true)
				// 【实体】是否为构建者模型（默认 false）
				// public User setName(String name) {this.name = name; return this;}
				.setEntityBuilderModel(true)
				// 【实体】是否为lombok模型（默认 false）<a href="https://projectlombok.org/">document</a>
				.setEntityLombokModel(true)
				// Boolean类型字段是否移除is前缀处理
				.setEntityBooleanColumnRemoveIsPrefix(false)
				.setRestControllerStyle(true)
				.setControllerMappingHyphenStyle(true)
				.setTableFillList(tableFillList);
		mpg.setStrategy(strategyConfig);

		mpg.execute();

	}
}