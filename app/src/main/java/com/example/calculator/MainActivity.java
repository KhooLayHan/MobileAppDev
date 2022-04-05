package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;
import org.mariuszgromada.math.mxparser.*;

import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText display;
    private String strToAdd;
    private String tb;
    private int i;
    private String regex;
    private String replacement;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = findViewById(R.id.input);
        display.setShowSoftInputOnFocus(false);

        display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (getString(R.string.display).equals(display.getText().toString())) {
                    display.setText("");
                }
            }

        });

    }

    private void updateText(String strToAdd){
        String oldStr = display.getText() .toString();
        int cursorPos = display.getSelectionStart();
        String leftStr = oldStr.substring(0, cursorPos);
        String rightStr = oldStr.substring(cursorPos);
        if(getString(R.string.display).equals(display.getText().toString())){
            display.setText(strToAdd);
            display.setSelection(cursorPos + 1);
        }
        else{
            display.setText(String.format("%s%s%s" , leftStr , strToAdd , rightStr));
            display.setSelection(cursorPos + 1);
        }
    }

    public void zeroBTN(View view){
        updateText(strToAdd = "0");
    }

    public void oneBTN(View view){
        updateText(strToAdd = "1");
   }

    public void twoBTN(View view){
        updateText(strToAdd = "2");
    }

    public void threeBTN(View view){
        updateText(strToAdd = "3");
    }

    public void fourBTN(View view){
        updateText(strToAdd = "4");
    }

    public void fiveBTN(View view){
        updateText(strToAdd = "5");
    }

    public void sixBTN(View view){
        updateText(strToAdd = "6");
    }

    public void sevenBTN(View view){
      updateText(strToAdd = "7");
    }

    public void eightBTN(View view){ updateText(strToAdd = "8"); }

    public void nineBTN(View view){
        updateText(strToAdd = "9");
    }

    public void clearBTN(View view){
        display.setText("");
    }

    public void bracketBTN(View view){
        int cursorPos = display.getSelectionStart();
        int openBracket = 0;
        int closedBracket = 0;
        int textLen = display.getText().length();

        for (i=0; i<cursorPos; i++){
            if (display.getText().toString().substring(i, i+1).equals("(")){
                openBracket +=1;
            }
            if (display.getText().toString().substring(i, i+1).equals(")")){
                closedBracket +=1;
            }
        }
        if (openBracket == closedBracket || display.getText().toString().substring(textLen -1, textLen).equals("(")){
            updateText (strToAdd = "(");
        }
        else if (closedBracket < openBracket || display.getText().toString().substring(textLen -1, textLen).equals("(")){
            updateText (strToAdd = ")");
        }
        display.setSelection(cursorPos+1);
    }

    public void powerBTN(View view){
        updateText(strToAdd = "^");
    }

    public void plusBTN(View view){
        updateText(strToAdd = "+");
    }

    public void minusBTN(View view){
        updateText(strToAdd = "-");
    }

    public void multiplyBTN(View view){
        updateText(strToAdd = "×");
    }

    public void divideBTN(View view){
        updateText(strToAdd = "÷");
    }

    public void eraseBTN(View view){
        int cursorPos = display.getSelectionStart();
        int textLen = display.getText().length();

        if (cursorPos != 0 && textLen != 0){
            SpannableStringBuilder selection = (SpannableStringBuilder) display.getText();
            selection.replace(cursorPos -1, cursorPos, tb = "");
            display.setText(selection);
            display.setSelection(cursorPos -1);
        }
    }

    public void plusMinusBTN(View view){
        updateText(strToAdd = "-");
    }

    public void decimalBtn(View view){
        updateText(strToAdd = ".");
    }

    public void equalsBtn(View view){
        String userExp = display.getText().toString();
        userExp = userExp.replaceAll(regex = "÷" , replacement = "/" );
        userExp = userExp.replaceAll(regex = "×" , replacement = "*" );

        Expression exp = new Expression(userExp);

        String result = String.valueOf(exp.calculate());

        display.setText(result);
        display.setSelection(result.length());
    }

}