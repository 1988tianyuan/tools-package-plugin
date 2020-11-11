package com.liugeng.plugin.demoplugin.actions;

import com.google.gson.*;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.ui.InputValidator;
import com.intellij.openapi.ui.Messages;
import org.jetbrains.annotations.NotNull;

public class JsonParserAction extends AnAction {

    private final Gson gson;

    public JsonParserAction() {
        gson = new GsonBuilder().setPrettyPrinting().create();
    }

    @Override
    public void actionPerformed(@NotNull AnActionEvent event) {
        String str = Messages.showMultilineInputDialog(event.getProject(), "Please input json string",
                "Parse Json", null, null,
                new InputValidator(){
                    @Override
                    public boolean checkInput(String inputString) {
                        return true;
                    }
                    @Override
                    public boolean canClose(String inputString) {
                        return true;
                    }
                });
        if (str != null) {
            try {
                JsonElement jsonElement = JsonParser.parseString(str);
                String parsedJson = gson.toJson(jsonElement);
                Messages.showMessageDialog(event.getProject(), parsedJson, "Parsed Json", null);
            } catch (JsonSyntaxException e) {
                e.printStackTrace();
                String errorMessage = e.getCause().getMessage();
                Messages.showWarningDialog(event.getProject(), "Invalid json string: " + str + "\n err: " +
                                errorMessage, "Invalid Json");
            }
        }
    }
}
