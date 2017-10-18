package com.example.kapillamba4.calculator;

import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

import java.lang.*;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView t1;
    char bracket = ')';
    boolean isDecimalPlaced = false;
    Button mClickButton0, mClickButton1, mClickButton2, mClickButton3, mClickButton4, mClickButton5, mClickButton6, mClickButton7, mClickButton8, mClickButton9;

    Button mClickButtonMinus, mClickButtonPlus, mClickButtonMultiply, mClickButtonDivide, mClickButtonClear, mClickButtonDel, mClickButtonBrackets, mClickButtonEquals, mClickButtonDecimal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        t1 = (TextView) findViewById(R.id.textArea);
        Button mClickButton0 = (Button) findViewById(R.id.zero);
        mClickButton0.setOnClickListener(this);
        Button mClickButton1 = (Button)findViewById(R.id.one);
        mClickButton1.setOnClickListener(this);
        Button mClickButton2 = (Button)findViewById(R.id.two);
        mClickButton2.setOnClickListener(this);
        Button mClickButton3 = (Button)findViewById(R.id.three);
        mClickButton3.setOnClickListener(this);
        Button mClickButton4 = (Button)findViewById(R.id.four);
        mClickButton4.setOnClickListener(this);
        Button mClickButton5 = (Button)findViewById(R.id.five);
        mClickButton5.setOnClickListener(this);
        Button mClickButton6 = (Button)findViewById(R.id.six);
        mClickButton6.setOnClickListener(this);
        Button mClickButton7 = (Button)findViewById(R.id.seven);
        mClickButton7.setOnClickListener(this);
        Button mClickButton8 = (Button)findViewById(R.id.eight);
        mClickButton8.setOnClickListener(this);
        Button mClickButton9 = (Button)findViewById(R.id.nine);
        mClickButton9.setOnClickListener(this);

        Button mClickButtonMinus = (Button)findViewById(R.id.subtract);
        mClickButtonMinus.setOnClickListener(this);
        Button mClickButtonPlus = (Button)findViewById(R.id.plus);
        mClickButtonPlus.setOnClickListener(this);
        Button mClickButtonMultiply = (Button)findViewById(R.id.multiply);
        mClickButtonMultiply.setOnClickListener(this);
        Button mClickButtonDivide = (Button)findViewById(R.id.divide);
        mClickButtonDivide.setOnClickListener(this);

        Button mClickButtonClear = (Button)findViewById(R.id.clear);
        mClickButtonClear.setOnClickListener(this);
        Button mClickButtonDel = (Button)findViewById(R.id.delete);
        mClickButtonDel.setOnClickListener(this);
        Button mClickButtonBrackets = (Button)findViewById(R.id.brackets);
        mClickButtonBrackets.setOnClickListener(this);
        Button mClickButtonEquals = (Button)findViewById(R.id.equals);
        mClickButtonEquals.setOnClickListener(this);
        Button mClickButtonDecimal = (Button)findViewById(R.id.decimal);
        mClickButtonDecimal.setOnClickListener(this);
    }


    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.zero: {
                t1.setText(t1.getText() + "0");
                break;
            }

            case R.id.one: {
                t1.setText(t1.getText() + "1");
                break;
            }

            case R.id.two: {
                t1.setText(t1.getText() + "2");
                break;
            }

            case R.id.three: {
                t1.setText(t1.getText() + "3");
                break;
            }

            case R.id.four: {
                t1.setText(t1.getText() + "4");
                break;
            }

            case R.id.five: {
                t1.setText(t1.getText() + "5");
                break;
            }

            case R.id.six: {
                t1.setText(t1.getText() + "6");
                break;
            }

            case R.id.seven: {
                t1.setText(t1.getText() + "7");
                break;
            }

            case R.id.eight: {
                t1.setText(t1.getText() + "8");
                break;
            }

            case R.id.nine: {
                t1.setText(t1.getText() + "9");
                break;
            }

            case R.id.subtract: {
                t1.setText(t1.getText() + "-");
                break;
            }

            case R.id.plus: {
                t1.setText(t1.getText() + "+");
                break;
            }

            case R.id.multiply: {
                t1.setText(t1.getText() + "*");
                break;
            }

            case R.id.divide: {
                t1.setText(t1.getText() + "/");
                break;
            }

            case R.id.clear: {
                t1.setText("");
                isDecimalPlaced = false;
                bracket = '(';
                break;
            }

            case R.id.delete: {
                if (t1.getText().toString().length() == 0) {
                    break;
                } else {
                    char lastChar = t1.getText().toString().charAt(t1.getText().length() - 1);
                    if (lastChar == '.') {
                        isDecimalPlaced = false;
                    } else if (lastChar == '(') {
                        bracket = ')';
                    } else if (lastChar == ')') {
                        bracket = '(';
                    }

                    t1.setText(t1.getText().toString().substring(0, t1.getText().toString().length() - 1));
                }

                break;
            }

            case R.id.brackets: {
                if (bracket == '(') {
                    t1.setText(t1.getText() + ")");
                    bracket = ')';
                } else {
                    t1.setText(t1.getText() + "(");
                    bracket = '(';
                }
                break;
            }

            case R.id.decimal: {
                if (t1.getText().toString().length() == 0) {
                    break;
                } else {
                    char lastChar = t1.getText().toString().charAt(t1.getText().length() - 1);
                    if (lastChar == '(' || lastChar == ')' || lastChar == '*' || lastChar == '/' || lastChar == '+' || lastChar == '-') {
                        break;
                    }
                }

                if (!isDecimalPlaced) {
                    t1.setText(t1.getText() + ".");
                    isDecimalPlaced = true;
                }
                break;
            }

            case R.id.equals: {
                Expression e = new ExpressionBuilder(t1.getText().toString())
                        .build();
                double result = e.evaluate();
                t1.setText(String.valueOf(result));
                break;
            }
        }
    }


}
