package com.example.reader.util;

import javax.swing.*;
import java.awt.*;

// https://stackoverflow.com/questions/48786257/vertical-stacked-layout-in-java-swing
public class XCustomLayout implements LayoutManager {
    private final JTextPane titleLable;
    private final JTextPane linkLable;
    private final JTextPane descriptionPane;

    public XCustomLayout(JTextPane titleLable, JTextPane linkLable, JTextPane descriptionPane) {
        this.titleLable = titleLable;
        this.linkLable = linkLable;
        this.descriptionPane = descriptionPane;
    }

    @Override
    public void addLayoutComponent(String name, Component comp) {
    }

    @Override
    public void removeLayoutComponent(Component comp) {
    }

    @Override
    public Dimension preferredLayoutSize(Container parent) {
        int width = parent.getParent().getWidth();

        int height = 0;

        height += calculateComponentPreferredHeightForWidth(titleLable, width);
        height += calculateComponentPreferredHeightForWidth(linkLable, width);
        height += calculateComponentPreferredHeightForWidth(descriptionPane, width);

        return new Dimension(width, height);
    }

    private static int calculateComponentPreferredHeightForWidth(JComponent component, int width) {
        component.setSize(width, 0);
        return component.getPreferredSize().height;
    }

    @Override
    public Dimension minimumLayoutSize(Container parent) {
//        return preferredLayoutSize(parent);
        return new Dimension(100, 0);
    }

    @Override
    public void layoutContainer(Container parent) {
        int width = parent.getWidth();

        int layoutX = 0;
        int layoutY = 0;

        titleLable.setBounds(layoutX, layoutY, width, calculateComponentPreferredHeightForWidth(titleLable, width));
        layoutY = titleLable.getY() + titleLable.getHeight();

        linkLable.setBounds(layoutX, layoutY, width, calculateComponentPreferredHeightForWidth(linkLable, width));
        layoutY = linkLable.getY() + linkLable.getHeight();

        descriptionPane.setBounds(layoutX, layoutY, width, calculateComponentPreferredHeightForWidth(descriptionPane, width));
    }
}
