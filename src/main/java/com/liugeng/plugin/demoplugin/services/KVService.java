package com.liugeng.plugin.demoplugin.services;

import com.intellij.ide.util.PropertiesComponent;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.Messages;

/**
 * 通过PropertiesComponent对K/V数据进行持久化
 */
public class KVService {

    private final Project project;
    private final PropertiesComponent propertiesComponent;

    public KVService(Project project) {
        this.project = project;
        this.propertiesComponent = PropertiesComponent.getInstance(project);
    }

    public void persistString(String key, String value) {
        if (value == null) {
            Messages.showInfoMessage("You didn't input any value.", "Input Empty Value");
            return;
        }
        propertiesComponent.setValue(key, value);
    }

    public String getString(String key) {
        return propertiesComponent.getValue(key);
    }
}
