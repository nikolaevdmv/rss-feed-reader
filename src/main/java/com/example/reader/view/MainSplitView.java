package com.example.reader.view;

import javax.swing.*;
import java.awt.*;

public class MainSplitView {

    private final Component view;

    private final AddedFeedView addedFeedView;

    public MainSplitView(AddedFeedView addedFeedView, RightSplitView rightSplitView) {
        this.addedFeedView = addedFeedView;
        this.view = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, this.addedFeedView.getView(), rightSplitView.getView());

        this.addedFeedView.executeOnDoubleClick(feed -> rightSplitView.setPosts(feed.posts()));
    }

    public Component getView() {
        return this.view;
    }
}
