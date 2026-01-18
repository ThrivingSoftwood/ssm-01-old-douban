package mybatis;

import java.util.List;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.java.TopLevelClass;

/**
 * 自研 Lombok 插件 0 依赖，0 漏洞，兼容 MBG 1.3.x ~ 1.4.x
 */
public class LombokPlugin extends PluginAdapter {

    @Override
    public boolean validate(List<String> warnings) {
        return true;
    }

    /**
     * 在实体类生成时注入注解
     */
    @Override
    public boolean modelBaseRecordClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        addLombokAnnotations(topLevelClass);
        return true;
    }

    /**
     * 处理主键类 (如果你的表有复合主键)
     */
    @Override
    public boolean modelPrimaryKeyClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        addLombokAnnotations(topLevelClass);
        return true;
    }

    /**
     * 处理包含大字段(BLOB)的类
     */
    @Override
    public boolean modelRecordWithBLOBsClassGenerated(TopLevelClass topLevelClass,
        IntrospectedTable introspectedTable) {
        addLombokAnnotations(topLevelClass);
        return true;
    }

    // 核心逻辑：添加注解和导包
    private void addLombokAnnotations(TopLevelClass topLevelClass) {
        // 添加 import
        topLevelClass.addImportedType("lombok.Data");
        // topLevelClass.addImportedType("lombok.Builder");
        topLevelClass.addImportedType("lombok.NoArgsConstructor");
        // topLevelClass.addImportedType("lombok.AllArgsConstructor");

        // 添加注解
        topLevelClass.addAnnotation("@Data");
        // topLevelClass.addAnnotation("@Builder");
        topLevelClass.addAnnotation("@NoArgsConstructor");
        // topLevelClass.addAnnotation("@AllArgsConstructor");
    }

    // 👇 拦截 Getter 生成
    @Override
    public boolean modelGetterMethodGenerated(Method method, TopLevelClass topLevelClass,
        IntrospectedColumn introspectedColumn, IntrospectedTable introspectedTable, ModelClassType modelClassType) {
        return false;
    }

    // 👇 拦截 Setter 生成
    @Override
    public boolean modelSetterMethodGenerated(Method method, TopLevelClass topLevelClass,
        IntrospectedColumn introspectedColumn, IntrospectedTable introspectedTable, ModelClassType modelClassType) {
        return false;
    }
}