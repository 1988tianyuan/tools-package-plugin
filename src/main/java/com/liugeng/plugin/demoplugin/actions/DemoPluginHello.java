package com.liugeng.plugin.demoplugin.actions;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.actionSystem.DataConstants;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.Messages;
import com.intellij.psi.PsiFile;

public class DemoPluginHello extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent event) {
        // 获取工程上下文
        Project project = event.getProject();
        // 获取当前操作的类文件
        PsiFile psiFile = event.getData(CommonDataKeys.PSI_FILE);
        // 获取当前的类路径
        String classPath = "";
        if (psiFile != null) {
            classPath = psiFile.getVirtualFile().getPath();
        }
        String title = "hello world";
        Messages.showMessageDialog(project, classPath, title, Messages.getInformationIcon());
    }
}
