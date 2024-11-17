package com.example.reader.entity;

import java.util.List;

public record FeedEntity(
        String name,
        List<Post> posts) {

    public static FeedEntity fromView(DisplayableFeed view) {
        return new FeedEntity(view.name(), view.posts());
    }
}
