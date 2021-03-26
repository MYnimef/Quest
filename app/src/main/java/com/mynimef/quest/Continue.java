package com.mynimef.quest;

import java.util.Map;

public class Continue extends Result {
    public Continue(String title, String story, Map<String, IQuest> ways) {
        super(title, story, ways);
    }
}