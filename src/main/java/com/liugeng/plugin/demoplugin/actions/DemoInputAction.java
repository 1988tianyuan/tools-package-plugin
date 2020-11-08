package com.liugeng.plugin.demoplugin.actions;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.Messages;
import com.intellij.psi.PsiFile;
import com.liugeng.plugin.demoplugin.services.KVService;

public class DemoInputAction extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent event) {
        Project project = event.getProject();
        assert project != null;
        KVService kvService = project.getService(KVService.class, true);
        String lastTimeValue = kvService.getString("userValue");
        String inputValue = Messages.showInputDialog(event.getProject(),
                "The value last time stored:" + lastTimeValue + ", please input new value.",
                "Save String Value",
                Messages.getInformationIcon());
        System.out.println("The value that user input:" + inputValue);
        kvService.persistString("userValue", inputValue);
    }
}
