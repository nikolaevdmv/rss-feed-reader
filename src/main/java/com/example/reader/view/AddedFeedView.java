package com.example.reader.view;

import com.example.reader.entity.FeedEntity;
import com.example.reader.service.FeedManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.function.Consumer;

public class AddedFeedView {

    private final JList<FeedEntity> feedList;
    private final Component component;

    private final List<FeedEntity> existedFeed;

    public AddedFeedView(FeedManager feedManager) {
        this.existedFeed = feedManager.getExistedFeed();

        this.feedList = new JList<>(existedFeed.toArray(FeedEntity[]::new));
        this.component = new JScrollPane(feedList);
        component.setMinimumSize(new Dimension(250, 0));


        DefaultListCellRenderer defaultListCellRenderer = new DefaultListCellRenderer();
        this.feedList.setCellRenderer((list, value, index, isSelected, cellHasFocus) -> {
            defaultListCellRenderer.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            defaultListCellRenderer.setText(value.name());
            return defaultListCellRenderer;
        });
    }

    public Component getComponent() {
        return component;
    }

    // https://stackoverflow.com/questions/4344682/double-click-event-on-jlist-element
    public void executeOnDoubleClick(Consumer<FeedEntity> consumer) {
        feedList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JList list = (JList) e.getSource();
                if (e.getClickCount() == 2) {

                    // Double-click detected
                    int index = list.locationToIndex(e.getPoint());
                    FeedEntity selectedValue = (FeedEntity) list.getSelectedValue();

                    consumer.accept(selectedValue);
                }
            }
        });
    }

}
