package com.example.reader.view;

import javax.swing.*;
import java.awt.*;

public class ReaderMainView {

    private final MainSplitView mainSplitView;

    public ReaderMainView(MainSplitView mainSplitView) {

        this.mainSplitView = mainSplitView;
    }

    public Component getView() {
        return mainSplitView.getView();
    }

}
