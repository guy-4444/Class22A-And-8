package com.guy.class22a_and_8;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;

import com.guy.class22a_and_8.Validator.*;

import com.google.android.material.textfield.TextInputLayout;

public class Activity_Form extends AppCompatActivity {

    private TextInputLayout form_EDT_salary;
    private TextInputLayout form_EDT_base;
    private TextInputLayout form_EDT_comPart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        form_EDT_salary = findViewById(R.id.form_EDT_salary);
        form_EDT_base = findViewById(R.id.form_EDT_base);
        form_EDT_comPart = findViewById(R.id.form_EDT_comPart);

        Validator.addValidator(form_EDT_salary, new Watcher[]{
                new Watcher(Validator.INTEGER, null, "Not int"),
                new Watcher(Validator.LESS_THAN, 50.5, "Bigger than 100"),
                new Watcher(Validator.POSITIVE, 50, "Not positive")
        });
        //Validator.foo(form_EDT_base);
        //Validator.goo(form_EDT_comPart);
    }
}