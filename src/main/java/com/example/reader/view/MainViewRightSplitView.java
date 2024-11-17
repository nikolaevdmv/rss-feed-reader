package com.example.reader.view;

import javax.swing.*;
import javax.swing.plaf.basic.BasicSplitPaneUI;
import java.awt.*;

public class MainViewRightSplitView {

    private final JSplitPane view;

    public MainViewRightSplitView(PostListView postListView, PostDetailView postDetailView) {
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, postListView.getView(), postDetailView.getView());


        this.view = splitPane;
    }

    public Component getView() {
        return this.view;
    }

    public void setDividerLocation(double proportionalLocation) {
        this.view.setDividerLocation(proportionalLocation);
    }

    public void hideDivider() {
        // https://forums.oracle.com/ords/apexds/post/hiding-a-jsplitpane-divider-1992
        ((BasicSplitPaneUI) view.getUI()).getDivider().setVisible(false);
    }

    public void showDivider() {
        ((BasicSplitPaneUI) view.getUI()).getDivider().setVisible(true);
    }
}
