package com.example.TodoList;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.TodoList.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

     Button buttonAdd;
     Button buttonClear;
     Button buttonRem;
     EditText name;
     TextView tarefas;

     ArrayList<String> array = new ArrayList<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonAdd = (Button)findViewById(R.id.buttonAdd);
        buttonClear = (Button) findViewById(R.id.buttonClear);
        buttonRem = (Button)findViewById(R.id.ButtonRem);
        name = (EditText) findViewById(R.id.name);
        tarefas = (TextView) findViewById(R.id.tarefas);
        tarefas.setMovementMethod(new ScrollingMovementMethod());

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String varName = name.getText().toString();
                array.add(varName);

                String a = "";

                for(int i = 0; i < array.size(); i++) {
                    a = array.get(i) +"\n" + a;
                }

                tarefas.setText( "Tarefas:\n\n"+ a +"\núltima tarefa concluída:\n" +"\nQuantidade:\n"+ array.size()+ "");
            }});
        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                tarefas.setText("");
                array = new ArrayList();
            }
        });

        buttonRem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String last = array.remove(array.size()-1);

                if(array.size() > 0){
                    tarefas.setText(  "Tarefas:\n\n"+String.join("\n", array)+ "\n\núltima tarefa concluída:\n"+ last +"\n\nQuantidade:\n"+ array.size());

                }else{
                    tarefas.setText("");
                }
            }
        });
    }
}
