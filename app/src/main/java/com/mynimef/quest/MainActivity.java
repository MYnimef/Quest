package com.mynimef.quest;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.mynimef.quest.situations.Beginning;

public class MainActivity extends AppCompatActivity {
    IQuest quest = new Beginning(); // история (сюжет)
    String[] str;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        updateStatus();
    }

    private void go(int i) {
        quest = quest.addSituation().ways.get(str[i]);
        updateStatus();

        //if (story.isEnd())
        //Toast.makeText(this, "Игра закончена!", Toast.LENGTH_LONG).show();
    }

    private void updateStatus() {
        ((TextView) findViewById(R.id.title)).
                setText(quest.addSituation().title);
        ((TextView) findViewById(R.id.desc)).
                setText(quest.addSituation().story);
        ((LinearLayout) findViewById(R.id.layout)).removeAllViews();

        str = quest.addSituation().ways.keySet().toArray(new String[quest.addSituation().ways.size()]);

        for (int i = 0; i < quest.addSituation().ways.size(); i++) {
            Button b = new Button(this);
            b.setText(str[i]);
            final int buttonId = i;
            b.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    go(buttonId);
                }
            });
            ((LinearLayout) findViewById(R.id.layout)).addView(b);
        }
    }
}