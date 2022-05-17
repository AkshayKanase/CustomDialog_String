package com.example.customdialogstring;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.security.PrivateKey;
import java.util.Locale;

public class DialogActivity extends Dialog {
    private TextView txtDialog;
    private RadioGroup stringRadioGroup;
    private CheckBox checkReverse;
    private String txtMsg;
    private Button btnFinish;
    private  char reverseArray[];
    private boolean isChecked;
    private String reversedMsg="";


    public interface stringDialog{
        void finishSuccess();

    }
    private stringDialog stringDialog;
    public void setStringDialog(stringDialog stringDialog){
        this.stringDialog=stringDialog;
    }



    public DialogActivity(@NonNull Context context) {
        super(context);
        setContentView(R.layout.dialog_layout);
        initViews();
        initlistener();

    }

    private void initViews(){
        txtDialog=findViewById(R.id.txtDialog);
        stringRadioGroup=findViewById(R.id.stringRadioGroup);
        checkReverse=findViewById(R.id.checkReverse);
        btnFinish=findViewById(R.id.btnDialogFinish);

    }

    private void initlistener(){
        btnFinish.setOnClickListener(new btnFinishClickListener());
        checkReverse.setOnCheckedChangeListener(new checkReverseClick());
        stringRadioGroup.setOnCheckedChangeListener(new radioClickListener());
    }



    private class btnFinishClickListener implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            stringDialog.finishSuccess();
            dismiss();
        }
    }

    private class checkReverseClick implements CompoundButton.OnCheckedChangeListener{

        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
           isChecked= checkReverse.isChecked();
           if(isChecked){
               txtMsg=txtDialog.getText().toString();
               reverseArray=txtMsg.toCharArray();
               for(int i=reverseArray.length-1;i>=0;i--){
                  reversedMsg= reversedMsg+reverseArray[i];
               }
               txtDialog.setText(reversedMsg);
           }

        }
    }

    private class radioClickListener implements RadioGroup.OnCheckedChangeListener{

        @Override
        public void onCheckedChanged(RadioGroup radioGroup, int i) {
            switch (i){

                case R.id.radioBtnUppercase:
                    txtMsg=txtDialog.getText().toString().toUpperCase();
                    txtDialog.setText(txtMsg);
                    break;
                case R.id.radioBtnLowercase:
                    txtMsg=txtDialog.getText().toString().toLowerCase();
                    txtDialog.setText(txtMsg);
                    break;
                case R.id.radioBtnInCap:
                    txtMsg=txtDialog.getText().toString();
                    txtMsg=txtMsg.substring(0,1).toUpperCase()+txtMsg.substring(1).toLowerCase();
                    txtDialog.setText(txtMsg);
                    break;


            }
        }
    }




}
