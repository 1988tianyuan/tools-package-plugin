package com.liugeng.plugin.demoplugin.components;

import com.intellij.openapi.components.ProjectComponent;
import com.intellij.openapi.components.ServiceManager;
import com.intellij.openapi.project.Project;
import com.liugeng.plugin.demoplugin.services.DemoProjectService;
import org.jetbrains.annotations.NotNull;

public class DemoProjectComponent implements ProjectComponent {

    private final Project project;

    /* ProjectComponent可以在构造方法中将Project实例传进来 */
    public DemoProjectComponent(Project project) {
        this.project = project;
    }

    @Override
    public void projectOpened() {
        System.out.println("项目" + project.getName() + "打开啦！");

        // 获取某个ProjectService的实例
        DemoProjectService demoProjectService = ServiceManager.getService(project, DemoProjectService.class);
        demoProjectService.test(); 
    }

    @Override
    public void projectClosed() {
        System.out.println("项目" + project.getName() + "关闭啦！");
    }

    @Override
    public void initComponent() {
        System.out.println("组件初始化啦！");
    }

    @Override
    public void disposeComponent() {
        System.out.println("组件销毁啦！");
    }

    @Override
    public @NotNull String getComponentName() {
        return "DemoIdeaPlugin-DemoProjectComponent";
    }
}
