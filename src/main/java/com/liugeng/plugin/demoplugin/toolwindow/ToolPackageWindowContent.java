package com.liugeng.plugin.demoplugin.toolwindow;

import com.google.gson.*;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.EditorFactory;
import com.intellij.openapi.editor.EditorSettings;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.psi.PsiFile;

import javax.swing.*;
import java.awt.*;

public class ToolPackageWindowContent {

    private JPanel panelContent;
    private JButton parseButton;
    private JTextPane output;
    private JPanel inputContainer;
    private JPanel outputContainer;
    private JPanel input;
    private final Gson gson;
    private final Project project;

    public ToolPackageWindowContent(ToolWindow toolWindow, Project project) {
        gson = new GsonBuilder().setPrettyPrinting().create();
        this.project = project;
        Editor editor = createEditor();
        input.setAutoscrolls(true);
        input.add(editor.getComponent(), BorderLayout.CENTER);
        parseButton.addActionListener(e -> {
            String inputStr = editor.getDocument().getText();
            String outputStr = parseInputJsonStr(inputStr);
            output.setText(outputStr);
        });
    }

    private Editor createEditor() {
        PsiFile myFile = null;
        EditorFactory editorFactory = EditorFactory.getInstance();
        Document doc = editorFactory.createDocument("");
        Editor editor = editorFactory.createEditor(doc, project);
        EditorSettings editorSettings = editor.getSettings();
        editorSettings.setVirtualSpace(false);
        editorSettings.setLineMarkerAreaShown(false);
        editorSettings.setIndentGuidesShown(false);
        editorSettings.setFoldingOutlineShown(true);
        editorSettings.setAdditionalColumnsCount(3);
        editorSettings.setAdditionalLinesCount(6);
        editorSettings.setLineNumbersShown(true);
        editorSettings.setCaretRowShown(true);
        return editor;
    }

    private String parseInputJsonStr(String jsonStr) {
        String result;
        try {
            JsonElement jsonElement = JsonParser.parseString(jsonStr);
            result = gson.toJson(jsonElement);
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
            String errorMessage = e.getCause().getMessage();
            result = "Invalid json string: " + jsonStr + "\n err: " + errorMessage;
        }
        return result;
    }

    public JPanel getPanelContent() {
        return panelContent;
    }
}
