package com.example.customdialogstring;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText edtMsg;
    private Button btnSubmit;
    private TextView dialogtxt;
    private String msg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        setBtnListener();
    }

    private void initViews(){
        edtMsg=findViewById(R.id.edtMsg);
        btnSubmit=findViewById(R.id.btnSubmit);

    }

    private void setBtnListener(){
        btnSubmit.setOnClickListener(new BtnSubmitClickListeners());
    }

    private class BtnSubmitClickListeners implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            DialogActivity dialogSubmit=new DialogActivity(MainActivity.this);
            dialogSubmit.setStringDialog(new StringDialogListener());
           dialogtxt= dialogSubmit.findViewById(R.id.txtDialog);
           msg=edtMsg.getText().toString();
           dialogtxt.setText(msg);
            dialogSubmit.show();

        }
    }
     class StringDialogListener implements DialogActivity.stringDialog {
        @Override
        public void finishSuccess() {
            String msg=dialogtxt.getText().toString();
            edtMsg.setText(msg);
        }
    }
}