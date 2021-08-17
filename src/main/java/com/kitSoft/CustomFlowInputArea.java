package com.kitSoft;

import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

public class CustomFlowInputArea extends TextFlow {

    private Font font;

    public CustomFlowInputArea() {
        super();
        font = new Font("Consolas",PrimarySettingsConfigurator.editorTextSize);
        setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {

            }
        });
    }


    public void handle(KeyEvent keyEvent){
        String c = keyEvent.getCharacter();
        if((int)c.charAt(0) != 13) {
            System.out.println();
            Label label = new Label(c);
            label.setStyle("-fx-text-fill: white");
            label.setFont(font);
            getChildren().add(label);
        }else{
            getChildren().add(new Text(System.lineSeparator()));
        }
    }

    public void setFont(Font font) {
        this.font = font;
    }

    public Font getFont() {
        return font;
    }
}
