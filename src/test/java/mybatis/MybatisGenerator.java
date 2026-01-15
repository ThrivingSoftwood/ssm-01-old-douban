package mybatis;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

public class MybatisGenerator {
    @Test
    public void generate() throws Exception {
        List<String> warnings = new ArrayList<String>();
        boolean overwrite = true;

        // 1. 定义资源路径（注意：不要加 "classpath:" 前缀，也不要加开头的 "/"）
        String resourcePath = "configuration/mybatis/mybatis-generator.xml";

        // 2. 通过 ClassLoader 获取资源的 URL
        // 这里使用当前线程的类加载器，是最稳健的方式
        URL resource = Thread.currentThread().getContextClassLoader().getResource(resourcePath);

        // 3. 防御性编程：检查是否真的找到了
        if (resource == null) {
            throw new IllegalArgumentException("❌ 配置文件未找到，请检查路径: " + resourcePath);
        }

        // 4. 将 URL 转换为 File 对象
        // 使用 toURI() 是为了处理路径中可能包含的空格或特殊字符
        File configFile = new File(resource.toURI());
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(configFile);
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        myBatisGenerator.generate(null);
    }
}
