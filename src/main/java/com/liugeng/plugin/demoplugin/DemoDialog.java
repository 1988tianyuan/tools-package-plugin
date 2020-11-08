package com.liugeng.plugin.demoplugin;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.DialogWrapper;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class DemoDialog extends DialogWrapper {

    protected DemoDialog(@Nullable Project project) {
        super(project);
    }

    @Override
    protected @Nullable JComponent createCenterPanel() {
        return null;
    }
}
