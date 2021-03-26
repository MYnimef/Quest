package com.mynimef.quest.situations;

import com.mynimef.quest.Continue;
import com.mynimef.quest.IQuest;
import com.mynimef.quest.Result;

import java.util.HashMap;

public class DeepDungeonEnter implements IQuest {
    @Override
    public Result addSituation() {
        HashMap<String, IQuest> ways = new HashMap<>();
        ways.put("Спуститься на два блока вниз", new DeepDungeonEnter());
        ways.put("Идти вперед, в gym", new GymEnter());

        return new Continue(
                "Welcum to the Dungeon",
                "Вы попали в dungeon и хотите отсюда выбраться\n" +
                        "Желательно орально здоровым\n" +
                        "Вы видите перед собой лестницу, ведущую на два блока вниз\n" +
                        "и проход, ведущий вперед с указателем gym. Куда вы пойдете?",
                ways);
    }
}
