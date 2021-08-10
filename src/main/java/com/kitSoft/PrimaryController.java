package com.kitSoft;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.kitSoft.Strings.StringManager;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.InputMethodEvent;

public class PrimaryController {

    @FXML
    public TextArea mainTextArea;

    @FXML
    public Label linesCounter;

    private int currentLine = 0;

    private int maximumRows = 0;
    private int maximumColumns = 0;

    @FXML
    private void initialize(){
        mainTextArea.caretPositionProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                currentLine = StringManager.getSymbolLine(mainTextArea.getText(), t1.intValue());
                int countOfLines = StringManager.getLinesCount(mainTextArea.getText());
                linesCounter.setText(StringManager.generateStringFrom1ToN(countOfLines));
                System.out.println(mainTextArea.getScrollTop());

            }
        });

        mainTextArea.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                maximumRows = StringManager.getLinesCount(t1);
                maximumColumns = StringManager.getMaximumColumnsCount(t1);
            }
        });
    }
}
