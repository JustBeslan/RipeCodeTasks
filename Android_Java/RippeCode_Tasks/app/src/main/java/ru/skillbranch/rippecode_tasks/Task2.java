package ru.skillbranch.rippecode_tasks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class Task2 extends AppCompatActivity {

    public void restart(View view) {
        EditText editTextN = findViewById(R.id.n);
        editTextN.setEnabled(true);
        editTextN.setCursorVisible(true);
        editTextN.setText("");

        TextView textViewAnswer = findViewById(R.id.answer);
        textViewAnswer.setText("");

        Button getAnswerButton = findViewById(R.id.startButton);
        getAnswerButton.setEnabled(true);

        Button refreshButtom = findViewById(R.id.refresh);
        refreshButtom.setVisibility(View.INVISIBLE);
    }

    static class Point{
        private Integer x, y, R2;
        public Point(Integer x, Integer y){
            this.x = x;
            this.y = y;
            this.R2 = this.x*this.x + this.y*this.y;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task2);
    }

    public void back(View view) {
        Intent back = new Intent(this, MainActivity.class);
        startActivity(back);
    }

    public void getAnswer(View view) {
        EditText editTextN = findViewById(R.id.n);
        TextView textViewAnswer = findViewById(R.id.answer);
        Button getAnswerButton = findViewById(R.id.startButton);
        Button refreshButtom = findViewById(R.id.refresh);

        if (editTextN.getText().length() == 0)
            Toast.makeText(
                    this,
                    "Поле не заполнено",
                    Toast.LENGTH_SHORT).show();
        else if (Integer.parseInt(editTextN.getText().toString()) == 0)
            Toast.makeText(
                    this,
                    "Длина массива не может быть равна 0",
                    Toast.LENGTH_SHORT).show();
        else {
            int n = Integer.parseInt(editTextN.getText().toString());
            editTextN.setEnabled(false);
            editTextN.setCursorVisible(false);
            editTextN.setText(String.format("n = %s", n));
            getAnswerButton.setEnabled(false);

            List<Point> points = new ArrayList<>();
            List<Integer> R2 = new ArrayList<>();
            Random random = new Random();
            for (int i = 0; i< n; i++) points.add(new Point(
                    random.nextInt(101) - 50,
                    random.nextInt(101) - 50));
            for (Point p: points) R2.add(p.R2);
            Set<Integer> setR2 = new HashSet<>(R2);

            textViewAnswer.setText(String.format("array R2 :\n%s\n\nanswer = %s",R2,setR2.size()));
            refreshButtom.setVisibility(View.VISIBLE);
        }
    }
}