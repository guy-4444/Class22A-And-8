package com.guy.class22a_and_8;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.guy.class22a_and_8.Validator.*;

import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;

public class Activity_Form extends AppCompatActivity {

    private TextInputLayout form_EDT_salary;
    private TextInputLayout form_EDT_base;
    private TextInputLayout form_EDT_comPart;
    private MaterialButton form_BTN_submit;

    Validator v1;
    Validator v2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        form_EDT_salary = findViewById(R.id.form_EDT_salary);
        form_EDT_base = findViewById(R.id.form_EDT_base);
        form_EDT_comPart = findViewById(R.id.form_EDT_comPart);
        form_BTN_submit = findViewById(R.id.form_BTN_submit);

        form_BTN_submit.setOnClickListener(view -> submit());

        v1 = Validator.Builder
                .make(form_EDT_salary)
                .addWatcher(new Watcher_Number("Not Number"))
                .addWatcher(new Watcher_Positive("Not positive"))
                .addWatcher(new Watcher_LessThan("Bigger than 100", 100))
                .build();

        boolean isGood = v1.validateIt();


        v2 = Validator.Builder
                .make(form_EDT_base)
                .addWatcher(new Watcher_MaximumOfLetter("Wrong Input", '1', 3))
                .addWatcher(new Watcher_Email("Nor Email"))
                .build();
        
//        Validator.addValidator(form_EDT_salary, new Watcher[]{
//                new Watcher(Validator.INTEGER, null, "Not int"),
//                new Watcher(Validator.LESS_THAN, 50.5, "Bigger than 100"),
//                new Watcher(Validator.POSITIVE, 50, "Not positive")
//        });
        //Validator.foo(form_EDT_base);
        //Validator.goo(form_EDT_comPart);


    }

    private void submit() {
        Log.d("pttt", "V1= " + v1.validateIt() + " - " + v1.getError());
        Log.d("pttt", "V2= " + v2.validateIt() + " - " + v2.getError());
    }
}