package com.mynimef.quest.situations;

import com.mynimef.quest.Death;
import com.mynimef.quest.IQuest;
import com.mynimef.quest.Result;

public class GymFail implements IQuest {
    @Override
    public Result addSituation() {
        return new Death(
                "",
                "",
                null);
    }
}
