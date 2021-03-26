package com.mynimef.quest;

import java.util.Map;

public class Result {
    String title, story;
    Map<String, IQuest> ways;

    public Result(String title, String story, Map<String, IQuest> ways) {
        this.title = title;
        this.story = story;
        this.ways = ways;
    }
}