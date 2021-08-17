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
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextArea;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Region;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class PrimaryController {

  //  @FXML
  //  public TextArea mainTextArea;

    @FXML
    public Label linesCounter;

    @FXML
    public AnchorPane root;

    @FXML
    public AnchorPane mainTextAreaAnchor;

    @FXML
    public ScrollPane scrollPane;

    public CustomFlowInputArea mainTextArea;

    private int currentLine = 0;

    private int maximumRows = 0;
    private int maximumColumns = 0;

    private Font newMainTextAreaFont;


    private void setViewPreferences(){
        try {
            PrimarySettingsConfigurator.readConfigFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(PrimarySettingsConfigurator.editorTextSize);
        newMainTextAreaFont = new Font(mainTextArea.getFont().getName(),PrimarySettingsConfigurator.editorTextSize);
        mainTextArea.setFont(newMainTextAreaFont);
        linesCounter.setFont(newMainTextAreaFont);
    }

    private void onScrollEvent(int fontHeight){
      //  linesCounter.setTranslateY(-mainTextArea.getScrollTop() - fontHeight);
    }

    @FXML
    private void initialize(){
        mainTextArea = new CustomFlowInputArea();
        mainTextArea.getStyleClass().add("mainTextArea");
        AnchorPane.setBottomAnchor(mainTextArea,0.0);
        AnchorPane.setTopAnchor(mainTextArea,0.0);
        AnchorPane.setLeftAnchor(mainTextArea,0.0);
        AnchorPane.setRightAnchor(mainTextArea,0.0);
        scrollPane.setFocusTraversable(true);
        scrollPane.setOnKeyTyped(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                mainTextArea.handle(keyEvent);
            }
        });

        mainTextArea.setMinWidth(Region.USE_PREF_SIZE);
        mainTextAreaAnchor.getChildren().add(mainTextArea);

        setViewPreferences();

        mainTextAreaAnchor.setPrefHeight(400);


        int fontHeight = (int)newMainTextAreaFont.getSize() + (int)linesCounter.getLineSpacing() + 5;
 /*       mainTextArea.caretPositionProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                onCaretPositionChanged();
                onScrollEvent(fontHeight);
            }
        });

        onScrollEvent(fontHeight);
        mainTextArea.scrollTopProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                onScrollEvent(fontHeight);
                onCaretPositionChanged();
            }
        });

        mainTextArea.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                onScrollEvent(fontHeight);
                onCaretPositionChanged();
            }
        });*/
    }
/*
    private void onCaretPositionChanged() {
        int countOfLines = StringManager.getLinesCount(mainTextArea.getText());
        linesCounter.setText(StringManager.generateStringFrom1ToN(countOfLines));
    }*/
}
