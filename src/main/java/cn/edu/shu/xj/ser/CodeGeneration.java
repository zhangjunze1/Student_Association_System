package cn.edu.shu.xj.ser;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

public class CodeGeneration {
    public static void main(String[] args) {

        //创建generator对象
        AutoGenerator autoGenerator = new AutoGenerator();

        //数据源
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setDbType(DbType.MYSQL);
        dataSourceConfig.setDriverName("com.mysql.cj.jdbc.Driver");
        dataSourceConfig.setUsername("root");
        dataSourceConfig.setPassword("Zhangjunze.221");
        dataSourceConfig.setUrl("jdbc:mysql://121.196.160.71:3306/system");
        autoGenerator.setDataSource(dataSourceConfig);

        //全局配置
        GlobalConfig globalConfig = new GlobalConfig();
        globalConfig.setOutputDir(System.getProperty("user.dir")+"/src/main/java");
        globalConfig.setAuthor("Zhangjz");
        globalConfig.setFileOverride(false);
        globalConfig.setOpen(false);
        globalConfig.setSwagger2(true);
        globalConfig.setServiceName("%sService");
        //设置主键生成策略
        //globalConfig.setIdType(IdType.AUTO);

        //设置date类型 只使用java.util.date 代替
        globalConfig.setDateType(DateType.ONLY_DATE);
        autoGenerator.setGlobalConfig(globalConfig);

        //包信息
        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setParent("cn.edu.shu.xj.ser");
        packageConfig.setEntity("entity");
        packageConfig.setMapper("mapper");
        packageConfig.setService("service");
        packageConfig.setServiceImpl("service.impl");
        packageConfig.setController("controller");
        autoGenerator.setPackageInfo(packageConfig);

        //策略配置
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig.setInclude("activity","ass","ass_activity","leader_activity","leader_ass","member_ass","notice","user","user_activity");
        strategyConfig.setNaming(NamingStrategy.underline_to_camel);
        strategyConfig.setColumnNaming(NamingStrategy.underline_to_camel);
        //忽略表中前缀
        //strategyConfig.setTablePrefix("tb_");
        strategyConfig.setEntityLombokModel(true);
        strategyConfig.setRestControllerStyle(true);
        autoGenerator.setStrategy(strategyConfig);
        //运行
        autoGenerator.execute();
    }
}