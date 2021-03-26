package com.mynimef.quest.situations;

import com.mynimef.quest.Continue;
import com.mynimef.quest.IQuest;
import com.mynimef.quest.Result;

import java.util.HashMap;

public class GymEnter implements IQuest {
    @Override
    public Result addSituation() {
        HashMap<String, IQuest> ways = new HashMap<>();
        ways.put("Fuck you", new GymFight());
        ways.put("You know, my dad taught me how to not rip the skin using someone else mouth",
                new GymFail());

        return new Continue("GYM",
                "Вы входите в gym и в соответсвии с принятыми здесь обычиями\n" +
                        "вы проходите в раздевалку.\n" +
                        "В раздевалке вы видите сидящего в углу smart ass.\n" +
                        "Он говорит Вам, что вами выбрана неправильная дверь,\n" +
                        "что leather club вумя блоками ниже. Ваш ответ:",
                ways);
    }
}
