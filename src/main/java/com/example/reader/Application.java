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

        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame();

//            ReaderMainView mainView = new ReaderMainView(addedFeedView, postListView, new MainViewRightSplitView(postListView, postDetailView));
            ReaderMainView mainView = new ReaderMainView();
            frame.add(mainView.getView());

            frame.setSize(new Dimension(1000, 800));
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame.setLocationRelativeTo(null);

            frame.setVisible(true);

        });


    }

}