package com.example.database;

import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class InsertActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);

        final EditText empid = (EditText) findViewById(R.id.emp_id);
        final EditText name = (EditText) findViewById(R.id.name);
        final RadioButton maleRadioButton = (RadioButton) findViewById(R.id.male);
        final RadioButton femaleRadioButton = (RadioButton) findViewById(R.id.female);
        final RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        final Spinner department = (Spinner) findViewById(R.id.department);
        final EditText salary = (EditText) findViewById(R.id.salary);
        final Button submitButton = (Button) findViewById(R.id.submit);
        final DatabaseHelper databaseHelper= new DatabaseHelper(this);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String empidText = empid.getText().toString();
                String nameTxt = name.getText().toString();
                int selectedRadioId = radioGroup.getCheckedRadioButtonId();
                String dptTxt =(String) department.getSelectedItem();
                String salaryTxt = salary.getText().toString();

                if(TextUtils.isEmpty((empidText))){
                    Toast empidToast = Toast.makeText(InsertActivity.this,"Employee id is empty",Toast.LENGTH_SHORT);
                    empidToast.show();
                }
                else if(TextUtils.isEmpty(nameTxt)){
                    Toast nameToast = Toast.makeText(InsertActivity.this,"Name is empty",Toast.LENGTH_SHORT);
                    nameToast.show();
                }
                else if(selectedRadioId < 0){
                    Toast genderToast = Toast.makeText(InsertActivity.this,"Select gender",Toast.LENGTH_SHORT);
                    genderToast.show();
                }
                else if(TextUtils.isEmpty(dptTxt)){
                    Toast dptToast = Toast.makeText(InsertActivity.this,"Select department",Toast.LENGTH_SHORT);
                    dptToast.show();
                }
                else if(TextUtils.isEmpty(salaryTxt)){
                    Toast salaryToast = Toast.makeText(InsertActivity.this,"Select gender",Toast.LENGTH_SHORT);
                    salaryToast.show();
                }
                else{
                    RadioButton selectedGender = (RadioButton) findViewById(selectedRadioId);
                    String gender = selectedGender.getText().toString();

                    double sal =  Double.parseDouble(salaryTxt);
                    try{
                        databaseHelper.addRecord(empidText,nameTxt,gender,dptTxt,sal);
                        Toast insertSuccess = Toast.makeText(InsertActivity.this,"inserted",Toast.LENGTH_SHORT);
                        insertSuccess.show();
                    }catch (SQLiteException sq){
                        Toast insertFailed = Toast.makeText(InsertActivity.this,"insert failed",Toast.LENGTH_SHORT);
                        insertFailed.show();
                    }
                }
            }
        });

    }
}
