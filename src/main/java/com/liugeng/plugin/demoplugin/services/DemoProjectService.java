package com.liugeng.plugin.demoplugin.services;

import com.intellij.openapi.project.Project;

public class DemoProjectService {

    private final Project project;

    /* ProjectService可以在构造方法中将Project实例传进来 */
    public DemoProjectService(Project project) {
        this.project = project;
    }

    public void test() {
        System.out.println("这是一个" + project.getName() + "项目中的DemoProjectService");
    }
}
