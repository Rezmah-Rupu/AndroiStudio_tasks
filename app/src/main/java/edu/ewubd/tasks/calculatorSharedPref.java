package edu.ewubd.tasks;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class calculatorSharedPref extends AppCompatActivity{
    TextView display;
    TextView one,two,three,four,five,six,seven,eight,nine,zero,dot, equal;
    TextView delete, prev, next, memory;
    TextView multiply,divide,sum,minus;
    String data;

    SharedPreferences sp;
    int temp=0, n=0, c=0, index=0, pos=0;
    List<String> list1 = new ArrayList<String>();
    List<String> list2 = new ArrayList<String>();
    List<String> list3_re = new ArrayList<String>();

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences sp = this.getSharedPreferences("SavePreviousData", MODE_PRIVATE);

        setContentView(R.layout.calculator);


        display = findViewById(R.id.display);
        one = findViewById(R.id.btn1);
        two = findViewById(R.id.btn2);
        three = findViewById(R.id.btn3);
        four = findViewById(R.id.btn4);
        five = findViewById(R.id.btn5);
        six = findViewById(R.id.btn6);
        seven = findViewById(R.id.btn7);
        eight = findViewById(R.id.btn8);
        nine = findViewById(R.id.btn9);
        zero = findViewById(R.id.btn0);
        dot = findViewById(R.id.btndot);
        equal = findViewById(R.id.btneq);
        multiply = findViewById(R.id.btnmul);
        divide = findViewById(R.id.btndiv);
        sum = findViewById(R.id.btnadd);
        minus = findViewById(R.id.btnmin);
        delete = findViewById(R.id.delete);
        prev = findViewById(R.id.previous);
        next = findViewById(R.id.next);
        memory = findViewById(R.id.memory);

        delete.setOnClickListener(View -> click_delete());
        zero.setOnClickListener(View -> click_zero());
        one.setOnClickListener(View -> click_one());
        two.setOnClickListener(View -> click_two());
        three.setOnClickListener(View -> click_three());
        four.setOnClickListener(View -> click_four());
        five.setOnClickListener(View -> click_five());
        six.setOnClickListener(View -> click_six());
        seven.setOnClickListener(View -> click_seven());
        eight.setOnClickListener(View -> click_eight());
        nine.setOnClickListener(View -> click_nine());
        dot.setOnClickListener(View -> click_dot());
        prev.setOnClickListener(View -> click_prev());
        memory.setOnClickListener(View -> click_memory());
        next.setOnClickListener(View -> click_next());
        equal.setOnClickListener(View -> click_equal());
        sum.setOnClickListener(View -> click_plus());

    }

    public void click_delete(){

        display.setText("");

    }

    public void click_one(){
        data = display.getText().toString();
        display.setText(data + "1");
    }

    public void click_plus(){

    }
    public void click_prev(){
        SharedPreferences sp = this.getSharedPreferences("SavePreviousData", MODE_PRIVATE);
        String s1 = sp.getString("LIST", "");
        String test = s1.replaceAll("[\\[\\](){}]", "");
        String[] s2 = test.split(",");
        list3_re = Arrays.asList(s2);
        // Collections.reverse(list3_re);

        String read_data = display.getText().toString();
        pos = list3_re.indexOf(read_data);
        System.out.println(pos);


        if(s1 == ""){
            System.out.println("No history");
            display.setText("No data stored");

        }
        else {

            for (int i = pos - 1; i < list3_re.size(); i--) {
                System.out.println(list3_re.get(i));
                temp = i + 1;
                System.out.println(temp);
                display.setText(list3_re.get(i));
                break;
            }}
    }

    public void click_next(){
        SharedPreferences sp = this.getSharedPreferences("SavePreviousData", MODE_PRIVATE);
        String s1 = sp.getString("LIST", "");
        if(s1 == ""){
            System.out.println("No history");
            display.setText("No data stored");

        }else {
            String test = s1.replaceAll("[\\[\\](){}]", "");
            String[] s2 = test.split(",");
            list2 = Arrays.asList(s2);

            System.out.println("List size " + list2.size());
            if (temp == 0) {

                for (int i = 0; i < list2.size(); i++) {
                    System.out.println(list2.get(i));
                    temp = i + 1;
                    System.out.println(temp);
                    display.setText(list2.get(i));
                    index = i;
                    break;
                }
            } else if (temp > 0) {

                for (int i = temp; i <= list2.size(); i++) {
                    System.out.println(list2.get(i));
                    temp = i + 1;
                    System.out.println(temp);
                    display.setText(list2.get(i));
                    index = i;
                    break;
                }
            }
        }
    }

    public void click_memory(){

        SharedPreferences sp = this.getSharedPreferences("SavePreviousData", MODE_PRIVATE);
        String s1 = sp.getString("LIST", "");
        String test = s1.replaceAll("[\\[\\](){}]", "");
        String[] s2 = test.split(",");
        list2 = Arrays.asList(s2);
        Collections.reverse(list2);



        if(s1 == ""){
            System.out.println("No history");
            display.setText("No data stored");

        }else {

            if (temp ==0){
                for (int i = 0; i < list2.size(); i++) {
                    System.out.println(list2.get(i));
                    display.setText(list2.get(i));
                    temp = i + 1;
                    pos =list2.indexOf(i);
                    break;
                }
            }else if (temp>0){
                String read =  display.getText().toString().trim();
                pos =list2.indexOf(read);
                System.out.println(pos);

            }

        }
    }

    public void click_equal(){
        SharedPreferences sp = this.getSharedPreferences("SavePreviousData", MODE_PRIVATE);
        SharedPreferences.Editor e = sp.edit();
        String text = display.getText().toString();
        System.out.println(text);
        list1.add(text);
        System.out.println(list1.toString());
        e.putString("LIST", String.valueOf(list1));
        e.apply();

    }

    public void click_two(){
        data = display.getText().toString();
        display.setText(data + "2");

    }
    public void click_three(){
        data = display.getText().toString();
        display.setText(data + "3");

    }  public void click_four(){
        data = display.getText().toString();
        display.setText(data + "4");

    }

    public void click_five(){
        data = display.getText().toString();
        display.setText(data + "5");

    }

    public void click_six(){
        data = display.getText().toString();
        display.setText(data + "6");

    }
    public void click_seven(){
        data = display.getText().toString();
        display.setText(data + "7");

    }
    public void click_eight(){
        data = display.getText().toString();
        display.setText(data + "8");

    }
    public void click_nine(){
        data = display.getText().toString();
        display.setText(data + "9");

    }
    public void click_zero(){
        data = display.getText().toString();
        display.setText(data + "0");

    }
    public void click_dot(){
        data = display.getText().toString();
        display.setText(data + ".");

    }
}

