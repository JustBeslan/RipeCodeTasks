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
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Task1 extends AppCompatActivity {

    private int n = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task1);
    }

    public void start(View view) {
        Button button = findViewById(R.id.startButton);
        EditText editTextN = findViewById(R.id.n);
        EditText editTextM = findViewById(R.id.m);
        TextView textViewAnswer = findViewById(R.id.answer);
        Button refreshButtom = findViewById(R.id.refresh);
        int m;

        if (button.getText().equals("Принять")) {
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
            else  {
                n = Integer.parseInt(editTextN.getText().toString());
                editTextM.setVisibility(View.VISIBLE);
                button.setText("Получить ответ");

                editTextN.setEnabled(false);
                editTextN.setCursorVisible(false);
                editTextN.setText(String.format("n = %s", n));
            }
        } else if (button.getText().equals("Получить ответ")) {
            if (editTextM.getText().length() == 0)
                Toast.makeText(
                        this,
                        "Поле не заполнено",
                        Toast.LENGTH_SHORT).show();
            else if (Integer.parseInt(editTextM.getText().toString()) == 0)
                Toast.makeText(
                        this,
                        "Длина подмассива не может быть равна 0",
                        Toast.LENGTH_SHORT).show();
            else {
                m = Integer.parseInt(editTextM.getText().toString());
                if (m > n)
                    Toast.makeText(
                            this,
                            "Длина подмассива больше длины массива",
                            Toast.LENGTH_SHORT).show();
                else {
                    editTextM.setEnabled(false);
                    editTextM.setCursorVisible(false);
                    editTextM.setText(String.format("m = %s", m));
                    button.setEnabled(false);

                    List<Integer> a = new ArrayList<>();
                    Random random = new Random();
                    int sum = 0;
                    for (int i = 0; i< n; i++) a.add(random.nextInt(101) - 50);
                    Collections.sort(a, Collections.<Integer>reverseOrder());
                    for (int i = 0; i< m; i++) sum += a.get(i);

                    textViewAnswer.setText(String.format("array : \n%s\n\nanswer = %s", a, sum));

                    refreshButtom.setVisibility(View.VISIBLE);
                }
            }
        }
    }

    public void restart(View view) {
        n = 0;

        EditText editTextN = findViewById(R.id.n);
        editTextN.setEnabled(true);
        editTextN.setCursorVisible(true);
        editTextN.setText("");

        EditText editTextM = findViewById(R.id.m);
        editTextM.setEnabled(true);
        editTextM.setCursorVisible(true);
        editTextM.setVisibility(View.INVISIBLE);
        editTextM.setText("");

        Button button = findViewById(R.id.startButton);
        button.setText("Принять");
        button.setEnabled(true);

        TextView textViewAnswer = findViewById(R.id.answer);
        textViewAnswer.setText("");

        Button refreshButtom = findViewById(R.id.refresh);
        refreshButtom.setVisibility(View.INVISIBLE);
    }

    public void back(View view) {
        Intent back = new Intent(this, MainActivity.class);
        startActivity(back);
    }
}