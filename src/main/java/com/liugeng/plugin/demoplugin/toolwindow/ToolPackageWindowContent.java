package com.liugeng.plugin.demoplugin.toolwindow;

import com.intellij.openapi.wm.ToolWindow;

import javax.swing.*;

public class ToolPackageWindowContent {

    private JPanel panelContent;
    private JLabel demoLabel;
    private JButton demoButton;

    public ToolPackageWindowContent(ToolWindow toolWindow) {
        demoButton.addActionListener(e -> {
            demoLabel.setText("hahaha");
        });
    }

    public JPanel getPanelContent() {
        return panelContent;
    }
}
