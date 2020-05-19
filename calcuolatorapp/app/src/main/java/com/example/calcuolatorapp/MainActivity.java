package com.example.calcuolatorapp;

import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.text.Layout;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.TextClock;
import android.widget.TextView;
import java.util.StringTokenizer;
import java.util.ArrayList;
//All of this code was tested on a Google Pixel 1 with api 19
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView result;
    int transfer;
    String answer;
    String equation;
    Button button0;
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    MediaPlayer beep;
    MediaPlayer compute;
    Button button6;
    Button button7;
    Button button8;
    Button buttonclear;
    Button buttondiv;
    Button button9;
    Button buttonp;
    Button buttonm;
    Button buttonmult;
    Button buttond;
    Button buttoneq;
    Button buttontoggle;
    Button buttonpercent;
    Button buttontheme;
    Layout theme;
    int size;
    Boolean joker;
    ArrayList<String> signs;
    ArrayList<String> numbers;
    ArrayList<Double> number;
    double answeer;
    int count;
    String test;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        equation = "";
        size = 50;
        joker = true;
       // theme = findViewById(R.id.tablelayout);
        result = findViewById(R.id.resultandwhattype);
        button0 = findViewById(R.id.button0);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);
        buttonpercent = findViewById(R.id.buttonper);
        buttondiv = findViewById(R.id.buttondivide);
        buttonclear = findViewById(R.id.buttonclear);
        button9 = findViewById(R.id.button9);
        buttonp = findViewById(R.id.buttonplus);
        buttonm = findViewById(R.id.buttonminus);
        buttontoggle = findViewById(R.id.button10);
        buttonmult = findViewById(R.id.buttonmultiply);
        buttond = findViewById(R.id.buttondivide);
        buttoneq = findViewById(R.id.buttonequal);
        buttontheme = findViewById(R.id.buttontheme);
        numbers = new ArrayList<>();
        number = new ArrayList<>();
        signs = new ArrayList<>();
        count = 0;
        test = "";
        answeer = 0.0;
        beep = MediaPlayer.create(this, R.raw.boop);
        compute = MediaPlayer.create(this, R.raw.compmuter);
    }

    public void onClick(View view){
        switch(view.getId()){
            case R.id.button1:
                //result.setTextSize(result.getTextSize()+6);
                //if(equation.length()>10){
                  //  result.setTextSize(size);
                    //size -= 10;
                //}
                beep.start();
                equation += "1";
                result.setText(equation);
            break;
            case R.id.button5:
                beep.start();
                equation += "5";
                result.setText(equation);
                break;
            case R.id.button2:
                beep.start();
                equation += "2";
                result.setText(equation);
                break;
            case R.id.button3:
                beep.start();
                equation += "3";
                result.setText(equation);
                break;
            case R.id.button4:
                beep.start();
                equation += "4";
                result.setText(equation);
                break;
            case R.id.button6:
                beep.start();
                equation += "6";
                result.setText(equation);
                break;
            case R.id.button7:
                beep.start();
                equation += "7";
                result.setText(equation);
                break;
            case R.id.button8:
                beep.start();
                equation += "8";
                result.setText(equation);
                break;
            case R.id.button9:
                beep.start();
                equation += "9";
                result.setText(equation);
                break;
            case R.id.button0:
                beep.start();
                equation += "0";
                result.setText(equation);
                break;
            case R.id.buttonper:
                beep.start();
                equation += "*0.01";
                result.setText(equation);
                break;
            case R.id.buttonplus:
                beep.start();
                equation += "+";
                result.setText(equation);
                break;
            case R.id.buttonminus:
                beep.start();
                equation += "-";
                result.setText(equation);
                break;
            case R.id.buttonmultiply:
                beep.start();
                equation += "*";
                result.setText(equation);
                break;
            case R.id.buttondivide:
                beep.start();
                equation += "/";
                result.setText(equation);
                break;
            case R.id.buttonclear:
                beep.start();
                equation = "";
                result.setText(equation);
                answer = "";
                transfer = 0;
                break;
            case R.id.buttonequal:
                    try {
                        compute.start();
                        ArrayList<Double> number = new ArrayList<Double>();
                        boolean breakk = false;
                        ArrayList<String> signs = new ArrayList<String>();
                        String ho = equation;
                        int count = 0;
                        double resulte = 0.0;
                        double convert = 0.0;
                        StringTokenizer tokenizer = new StringTokenizer(ho, "*+-/", true);
                        while (tokenizer.hasMoreTokens()) {
                            String currentToken = tokenizer.nextToken();
                            if (count % 2 == 0) {
                                convert = Double.parseDouble(currentToken);
                                number.add(convert);
                            } else {
                                signs.add(currentToken);
                            }
                            count++;
                        }
                        if (signs.size() <= 0) {
                            result.setText(number.get(0) + "");
                            break;
                        }
                        System.out.println(number);
                        System.out.println(signs);
                        resulte = number.get(0);
                        System.out.println(result);
                        count = 1;
                        double finale = 0.0;
                        int whatsign = 0;
                        while (signs.size() > 0) {
                            if(breakk == false) {
                                if (signs.get(whatsign).equals("+")) {
                                    resulte = resulte + number.get(count);
                                    count++;
                                    System.out.println(signs.get(whatsign));
                                    signs.remove(whatsign);
                                } else if (signs.get(whatsign).equals("-")) {
                                    resulte = resulte - number.get(count);
                                    count++;
                                    System.out.println(signs.get(whatsign));
                                    signs.remove(whatsign);
                                } else if (signs.get(whatsign).equals("*")) {
                                    resulte = resulte * number.get(count);
                                    count++;
                                    System.out.println(signs.get(whatsign));
                                    signs.remove(whatsign);
                                } else if (signs.get(whatsign).equals("/")) {
                                    resulte = resulte / number.get(count);
                                    if (number.get(count) == (0)) {
                                        result.setText("ERROR");
                                        equation = "";
                                        breakk = true;
                                        break;
                                    }
                                    count++;
                                    System.out.println(signs.get(whatsign));
                                    signs.remove(whatsign);
                                }
                                System.out.println(resulte);
                                finale = resulte;
                            }
                        }
                        if(breakk==false) {
                            System.out.println(result);
                            finale = Math.round(finale * 100.0) / 100.0;
                            if (Double.isInfinite(finale))
                                result.setText("ERROR");
                            result.setText(finale + "");
                            equation = "";
                            equation += finale + "";
                            break;
                        }
                    } catch (Exception e) {
                        result.setText("ERROR");
                        equation = "";
                    }


                }
        }
    public void onClickGoEqualOO(View view) {
        try {
            compute.start();
            ArrayList<String> number = new ArrayList<String>();
            ArrayList<String> signs = new ArrayList<String>();
            int count = 0;
            double resulte = 0.0;
            StringTokenizer tokenizer = new StringTokenizer(equation, "+-", true);
            while (tokenizer.hasMoreTokens()) {
                String currentToken = tokenizer.nextToken();
                if (count % 2 == 0) {
                    number.add(currentToken);
                } else {
                    signs.add(currentToken);
                }
                count++;
            }
            System.out.println(number);
            System.out.println(signs);
            boolean breaker = false;
            ArrayList<Double> bnum = new ArrayList<Double>();
            for (String e : number) {
                ArrayList<String> z = new ArrayList<String>();
                StringTokenizer tokenizer2 = new StringTokenizer(e, "*/", true);
                while (tokenizer2.hasMoreTokens()) {
                    String currentToken = tokenizer2.nextToken();
                    System.out.println(currentToken);
                    z.add(currentToken);
                }
                double first = Double.parseDouble(z.get(0));
                for (int x = 0; x < z.size() - 1; x++) {
                    if(breaker == true)
                        break;
                        if (z.size() == 1) {
                            bnum.add(first);
                            break;
                        } else if (z.get(x).equals("/")) {
                            if (Double.parseDouble(z.get(x + 1)) == 0) {
                                breaker = true;
                                result.setText("ERROR");
                                equation = "";
                                break;
                            }
                            first = first / Double.parseDouble(z.get(x + 1));
                        } else if ((z.get(x).equals("*"))) {
                            first = first * Double.parseDouble(z.get(x + 1));
                        }
                    }

                bnum.add(first);
            }
                System.out.println(bnum);
                double finale = 0.0;
                int whatsign = 0;
                resulte = bnum.get(0);
                count = 1;
                for (String u : signs) {
                    System.out.println(count);
                    if (u.equals("+")) {
                        resulte = resulte + bnum.get(count);
                        count++;
                        System.out.println(bnum.get(whatsign));
                        System.out.println(count);
                    } else if (u.equals("-")) {
                        resulte = resulte - bnum.get(count);
                        count++;
                        System.out.println(signs.get(whatsign));
                        System.out.println(count);
                    }
                    System.out.println(resulte);
                }
                resulte = Math.round(resulte * 100.0) / 100.0;
                if(breaker == false)
                result.setText(Double.toString(resulte));
                equation = Double.toString(resulte);
                System.out.println(finale);
                if(breaker == true) {
                    equation = "";
                }
            breaker = false;
        }catch(Exception e){
            result.setText("ERROR");
            equation = "";
        }

    }
    public void onClickTheme(View view)
    {
      if(joker == true){
          //view = this.getWindow().getDecorView();
          view = findViewById(R.id.tablelayout);
          view.setBackgroundColor(Color.BLACK);
          result.setTextColor(Color.YELLOW);
          buttontheme.setBackgroundColor(Color.YELLOW);
          button1.setBackgroundColor(Color.YELLOW);
          button2.setBackgroundColor(Color.YELLOW);
          button3.setBackgroundColor(Color.YELLOW);
          button4.setBackgroundColor(Color.YELLOW);
          button5.setBackgroundColor(Color.YELLOW);
          button6.setBackgroundColor(Color.YELLOW);
          button7.setBackgroundColor(Color.YELLOW);
          buttondiv.setBackgroundColor(Color.YELLOW);
          buttonclear.setBackgroundColor(Color.YELLOW);
          button8.setBackgroundColor(Color.YELLOW);
          button9.setBackgroundColor(Color.YELLOW);
          button0.setBackgroundColor(Color.YELLOW);
          buttonmult.setBackgroundColor(Color.YELLOW);
          buttoneq.setBackgroundColor(Color.YELLOW);
          buttontoggle.setBackgroundColor(Color.YELLOW);
          buttonpercent.setBackgroundColor(Color.YELLOW);
          buttonm.setBackgroundColor(Color.YELLOW);
          buttonp.setBackgroundColor(Color.YELLOW);
          buttontheme.setText("JOKER THEME");
          joker = false;
      }else{
          //view = this.getWindow().getDecorView();
          view = findViewById(R.id.tablelayout);
          view.setBackgroundColor(Color.rgb(153, 51, 255));
          result.setTextColor(Color.BLACK);
          buttontheme.setBackgroundColor(Color.GREEN);
          button1.setBackgroundColor(Color.GREEN);
          button2.setBackgroundColor(Color.GREEN);
          button3.setBackgroundColor(Color.GREEN);
          button4.setBackgroundColor(Color.GREEN);
          button5.setBackgroundColor(Color.GREEN);
          buttondiv.setBackgroundColor(Color.GREEN);
          buttonclear.setBackgroundColor(Color.GREEN);
          button6.setBackgroundColor(Color.GREEN);
          button7.setBackgroundColor(Color.GREEN);
          button8.setBackgroundColor(Color.GREEN);
          button9.setBackgroundColor(Color.GREEN);
          button0.setBackgroundColor(Color.GREEN);
          buttonmult.setBackgroundColor(Color.GREEN);
          buttonpercent.setBackgroundColor(Color.GREEN);
          buttoneq.setBackgroundColor(Color.GREEN);
          buttontoggle.setBackgroundColor(Color.GREEN);
          buttonm.setBackgroundColor(Color.GREEN);
          buttonp.setBackgroundColor(Color.GREEN);
          buttontheme.setText("BATMAN THEME");
          joker = true;
      }
    }
}