package com.example.reader;

import com.example.reader.service.FeedManager;
import com.example.reader.view.*;

import javax.swing.*;
import java.awt.*;

public class Application {

    public static void main(String[] args) {

        FeedManager feedManager = new FeedManager();
        AddedFeedView addedFeedView = new AddedFeedView(feedManager);
        PostListView postListView = new PostListView();
        PostDetailView postDetailView = new PostDetailView();
        RightSplitView rightSplitView = new RightSplitView(postListView, postDetailView);
        MainSplitView mainSplitView = new MainSplitView(addedFeedView, rightSplitView);

        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame();

            ReaderMainView mainView = new ReaderMainView(mainSplitView);
            frame.add(mainView.getView());

            frame.setSize(new Dimension(1000, 800));
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame.setLocationRelativeTo(null);

            frame.setVisible(true);

        });


    }

}