package com.example.reader.view;

import com.example.reader.entity.Post;

import javax.swing.*;
import javax.swing.plaf.basic.BasicSplitPaneUI;
import java.awt.*;

public class RightSplitView {

    private final JSplitPane view;

    private final PostListView postListView;

    public RightSplitView(PostListView postListView, PostDetailView postDetailView) {

        this.postListView = postListView;
        this.view = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, postListView.getView(), postDetailView.getView());

        postListView.executeOnDoubleClick(selectedValue -> {
            postDetailView.setPost(selectedValue);

            if (!postDetailView.isVisible()) {
                postDetailView.setVisible(true);
                showDivider();
                setDividerLocation(0.5);
            }
        });

        hideDivider();

    }

    public Component getView() {
        return this.view;
    }

    public void setDividerLocation(double proportionalLocation) {
        this.view.setDividerLocation(proportionalLocation);
    }

    public void setPosts(java.util.List<Post> posts) {
        this.postListView.setPosts(posts);
    }

    private void hideDivider() {
        // https://forums.oracle.com/ords/apexds/post/hiding-a-jsplitpane-divider-1992
        ((BasicSplitPaneUI) view.getUI()).getDivider().setVisible(false);
    }

    private void showDivider() {
        ((BasicSplitPaneUI) view.getUI()).getDivider().setVisible(true);
    }
}
