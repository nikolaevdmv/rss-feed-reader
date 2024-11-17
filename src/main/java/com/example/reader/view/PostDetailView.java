package com.example.reader.view;

import com.example.reader.entity.Post;
import com.example.reader.util.XCustomLayout;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class PostDetailView {

    private final JTextPane titleLable;
    private final JTextPane descriptionText;
    private final JTextPane linkLabel;

    private final JPanel view;

    public PostDetailView() {
        this.view = new JPanel();
        {
            this.titleLable = new JTextPane();


            this.descriptionText = new JTextPane();
            this.linkLabel = new JTextPane();

            linkLabel.setForeground(Color.BLUE.darker());
            linkLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            linkLabel.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    try {
                        Desktop.getDesktop().browse(new URI(linkLabel.getText()));
                    } catch (IOException | URISyntaxException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            });


            titleLable.setBorder(new LineBorder(Color.CYAN));
            view.setLayout(new XCustomLayout(titleLable, linkLabel, descriptionText));
            view.add(titleLable);
            view.add(linkLabel);
            view.add(descriptionText);
            view.setVisible(false);
            view.setBackground(Color.WHITE);
        }
    }

    public Component getView() {
        return this.view;
    }

    public void setPost(Post post) {
        titleLable.setText(post.title());
        descriptionText.setText(post.description());
        linkLabel.setText(post.link());

    }


    public boolean isVisible() {
        return view.isVisible();
    }

    public void setVisible(boolean value) {
        view.setVisible(value);
    }
}
