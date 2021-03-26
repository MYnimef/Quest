package com.mynimef.quest.situations;

import com.mynimef.quest.Continue;
import com.mynimef.quest.IQuest;
import com.mynimef.quest.Result;

import java.util.HashMap;

public class GymFight implements IQuest {
    @Override
    public Result addSituation() {
        HashMap<String, IQuest> ways = new HashMap<>();
        ways.put("Fuck you", new com.mynimef.quest.situations.GymFight());
        ways.put("You know, my dad taught me how to not rip the skin using someone else mouth",
                new com.mynimef.quest.situations.GymFail());

        return new Continue("GYM",
                "Вы входите в gym ив соответсвии с принятыми здесь обычиями\n" +
                        "вы проходите в раздевалку.\n" +
                        "В раздевалке вы видите сидящего в углу smart ass.\n" +
                        "Он говорит Вам, что вами выбрана неправильная дверь,\n" +
                        "что leather club вумя блоками ниже. Ваш ответ:",
                ways);
    }
}
