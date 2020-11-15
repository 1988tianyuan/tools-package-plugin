package com.liugeng.plugin.demoplugin.toolwindow;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowFactory;
import com.intellij.ui.content.Content;
import com.intellij.ui.content.ContentFactory;
import org.jetbrains.annotations.NotNull;

public class ToolPackagesWindowFactory implements ToolWindowFactory {

    @Override
    public void createToolWindowContent(@NotNull Project project, @NotNull ToolWindow toolWindow) {
        ToolPackageWindow toolPackageWindow = new ToolPackageWindow();
        ToolPackageWindowContent toolPackageWindowContent = new ToolPackageWindowContent(toolWindow, project);
        toolPackageWindow.setContent(toolPackageWindowContent.getPanelContent());
        ContentFactory contentFactory = ContentFactory.SERVICE.getInstance();
        Content content = contentFactory.createContent(toolPackageWindow, "",
                false);
        toolWindow.getContentManager().addContent(content);
    }
}
