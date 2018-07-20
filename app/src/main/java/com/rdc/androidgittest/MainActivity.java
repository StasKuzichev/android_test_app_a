package com.rdc.androidgittest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    TextView text;
    EditText inputLink;//поле ввода
    Button btnOk;
    String href;//ссылка
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputLink = findViewById(R.id.inputText);
        btnOk = findViewById(R.id.buttonOk);
        text = findViewById(R.id.textView2);

        btnOk.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {

                href = inputLink.getText().toString();

                if (inputLink.getText().toString().isEmpty())//Проверка на пустоту
                {
                    Toast.makeText(MainActivity.this, R.string.error, Toast.LENGTH_SHORT).show();
                }
                if(href.trim().length() == 0)//Проверка, если пользователь ввел ТОЛЬКО пробелы
                {
                    Toast.makeText(MainActivity.this, R.string.error, Toast.LENGTH_SHORT).show();
                    inputLink.setText("");
                }

                else
                    if (!href.contains(" "))//если  ссылка не содержит пробелов то выбирается одно из двух:
                {
                    if (href.contains("https://"))//1.если ссылка введена с https:// то просто ее передаем
                    {
                        Intent sendIntent = new Intent();
                        sendIntent.setAction(Intent.ACTION_SEND);
                        sendIntent.putExtra(Intent.EXTRA_TEXT, href);
                        sendIntent.setType("text/plain");
                        startActivity(sendIntent);
                        inputLink.setText("");
                    }
                    else
                        if(!href.contains("https://")||!href.contains("http://"))//2.если ссылка введена без  https://
                        {
                            Toast.makeText(MainActivity.this, R.string.format, Toast.LENGTH_LONG).show();
                            inputLink.setText("");
                        /*Intent sendIntent2 = new Intent();
                        sendIntent2.setAction(Intent.ACTION_SEND);
                        sendIntent2.putExtra(Intent.EXTRA_TEXT, "https://" + href);//добавляем https:// и передаем
                        sendIntent2.setType("text/plain");
                        startActivity(sendIntent2);
                        inputLink.setText("");*/
                        }

                }

                else if(href.contains(" "))//если ссылка введена с пробелами
                    {
                        Toast.makeText(MainActivity.this, R.string.format, Toast.LENGTH_LONG).show();
                        inputLink.setText("");
                    }

            }



        });


    }
}

