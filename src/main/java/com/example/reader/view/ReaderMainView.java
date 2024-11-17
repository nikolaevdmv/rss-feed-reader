package com.example.reader.view;

import com.example.reader.service.FeedManager;

import javax.swing.*;
import javax.swing.plaf.basic.BasicSplitPaneUI;
import java.awt.*;

public class ReaderMainView {

    private final Component view;

    public ReaderMainView() {
        FeedManager feedManager = new FeedManager();

        AddedFeedView addedFeedPanel = new AddedFeedView(feedManager);
        PostListView postListPanel = new PostListView();
        PostDetailView postDetailPanel = new PostDetailView();

        JSplitPane splitPane2 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, postListPanel.getView(), postDetailPanel.getView());
        // https://forums.oracle.com/ords/apexds/post/hiding-a-jsplitpane-divider-1992
        ((BasicSplitPaneUI) splitPane2.getUI()).getDivider().setVisible(false);

        this.view = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, addedFeedPanel.getComponent(), splitPane2);

        addedFeedPanel.executeOnDoubleClick(feed -> postListPanel.setPosts(feed.posts()));

        postListPanel.executeOnDoubleClick(selectedValue -> {
            postDetailPanel.setPost(selectedValue);

            if (!postDetailPanel.isVisible()) {
                postDetailPanel.setVisible(true);
                ((BasicSplitPaneUI) splitPane2.getUI()).getDivider().setVisible(true);
                splitPane2.setDividerLocation(0.5);
            }
        });

    }

    public Component getView() {
        return this.view;
    }

}
