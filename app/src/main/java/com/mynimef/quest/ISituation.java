package com.mynimef.quest;

import java.util.Map;

public interface ISituation {
    void getSituation(String title, String story, Map<String, IQuest> ways);
}