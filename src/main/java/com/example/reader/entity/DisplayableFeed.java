package com.example.reader.entity;

import java.util.List;

public record DisplayableFeed(
        String name,
        List<Post> posts
) {

    public static DisplayableFeed fromEntity(FeedEntity entity) {
        return new DisplayableFeed(entity.name(), entity.posts());
    }

    @Override
    public String toString() {
        return name;
    }
}
