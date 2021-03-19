package com.mynimef.quest;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Character manager; // персонаж
    Story story; // история (сюжет)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // создаем нового персонажа и историю
        manager = new Character("Вася");
        story = new Story();
        // в первый раз выводим на форму весь необходимый текст и элементы
        // управления
        updateStatus();
    }

    // метод для перехода на нужную ветку развития
    private void go(int i) {
        story.go(i + 1);
        updateStatus();
        // если история закончилась, выводим на экран поздравление
        if (story.isEnd())
            Toast.makeText(this, "Игра закончена!", Toast.LENGTH_LONG).show();
    }

    // в этом методе размещаем всю информацию, специфичную для текущей
    // ситуации на форме приложения, а также размещаем кнопки, которые
    // позволят пользователю выбрать дальнейший ход событий
    private void updateStatus() {
        // не забываем обновить репутацию в соответствии с новым
        // состоянием дел
        manager.M += story.current_situation.dM;
        manager.S += story.current_situation.dS;
        manager.B += story.current_situation.dB;
        // выводим статус на форму
        ((TextView) findViewById(R.id.status)).
                setText("Dungeon master: " + manager.M  +
                        ", Fucking slave: " + manager.S  +
                        ", College boy: " + manager.B);
        // аналогично для заголовка и описания ситуации
        ((TextView) findViewById(R.id.title)).
                setText(story.current_situation.subject);
        ((TextView) findViewById(R.id.desc)).
                setText(story.current_situation.text);
        ((LinearLayout) findViewById(R.id.layout)).removeAllViews();
        // размещаем кнопку для каждого варианта, который пользователь
        // может выбрать
        for (int i = 0; i < story.current_situation.direction.length; i++) {
            Button b = new Button(this);
            b.setText(story.current_situation.variantsStr[i]);
            final int buttonId = i;
            // Внимание! в анонимных классах
            // можно использовать только те переменные метода,
            // которые объявлены как final.
            // Создаем объект анонимного класса и устанавливаем его
            // обработчиком нажатия на кнопку
            b.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    go(buttonId);
                    // поскольку анонимный класс имеет полный
                    // доступ к методам и переменным родительского,
                    // то просто вызываем нужный нам метод.
                }
            });
            // добавляем готовую кнопку на разметку
            ((LinearLayout) findViewById(R.id.layout)).addView(b);
        }
    }
}