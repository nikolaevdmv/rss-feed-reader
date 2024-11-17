package com.example.reader.view;

import com.example.reader.entity.Post;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.function.Consumer;

public class PostListView {

    private JList<Post> postList;
    private JScrollPane jScrollPane1;

    public PostListView() {
        this.postList = new JList<>();
        this.jScrollPane1 = new JScrollPane(postList);

        jScrollPane1.setMinimumSize(new Dimension(550, 0));

        DefaultListCellRenderer defaultListCellRenderer = new DefaultListCellRenderer();
        postList.setCellRenderer((list, value, index, isSelected, cellHasFocus) -> {
            defaultListCellRenderer.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            defaultListCellRenderer.setText(value.title());
            return defaultListCellRenderer;
        });
    }

    public void setPosts(java.util.List<Post> posts) {
        postList.setListData(posts.toArray(Post[]::new));
    }

    public JComponent getView() {
        return jScrollPane1;
    }

    public void executeOnDoubleClick(Consumer<Post> consumer) {
        postList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JList list = (JList) e.getSource();
                if (e.getClickCount() == 2) {

                    // Double-click detected
                    int index = list.locationToIndex(e.getPoint());
                    Post selectedValue = (Post) list.getSelectedValue();

                    if (selectedValue != null)
                        consumer.accept(selectedValue);

                }
            }
        });
    }
}
