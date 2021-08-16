package com.kitSoft;

import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class FontHelper {
    public static double computeTextHeight(Font font) {
        Text helper = new Text();
        helper.setFont(font);
        helper.setText("t");
        // Note that the wrapping width needs to be set to zero before
        // getting the text's real preferred width.
        helper.setWrappingWidth(0);
        helper.setLineSpacing(0);
        double textHeight = helper.getLayoutBounds().getHeight();
        return textHeight;
    }
}
