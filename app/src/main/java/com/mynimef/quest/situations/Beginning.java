package com.mynimef.quest.situations;

import com.mynimef.quest.Continue;
import com.mynimef.quest.IQuest;
import com.mynimef.quest.ISituation;

import java.util.HashMap;

public class Beginning implements IQuest {
    @Override
    public ISituation addSituation() {
        HashMap<String, IQuest> ways = new HashMap<>();
        //ways.put("Двигаться к свету", new GenerateSituation4());
        //ways.put("Остаться в пещере и осмотреться", new GenerateSituation5());

        Continue st = new Continue();
        st.getSituation(
                "",
                "",
                ways);
        return st;
    }
}