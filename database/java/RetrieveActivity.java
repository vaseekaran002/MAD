package com.example.database;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RetrieveActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrieve);

        final EditText empid = (EditText) findViewById(R.id.emp_id);
        final TextView nameTextView = (TextView) findViewById(R.id.names);
        final TextView genderTextView = (TextView) findViewById(R.id.genders);
        final TextView dptTextView = (TextView) findViewById(R.id.dpts);
        final TextView salaryTextView = (TextView) findViewById(R.id.salarays);
        final Button retrieveButton = (Button) findViewById(R.id.retrieveBtn);
        final DatabaseHelper databaseHelper= new DatabaseHelper(this);

       retrieveButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               String emptxt = empid.getText().toString();

               if(TextUtils.isEmpty(emptxt)){
                   Toast empidToast = Toast.makeText(RetrieveActivity.this,"Employee id is empty",Toast.LENGTH_SHORT);
                   empidToast.show();
               }

               String results[] = databaseHelper.retrieveRecord(emptxt);
               if(results == null){
                   Toast missingRecord = Toast.makeText(RetrieveActivity.this,"record missing",Toast.LENGTH_SHORT);
                   missingRecord.show();
               }

               nameTextView.setText(results[0]);
               genderTextView.setText(results[1]);
               dptTextView.setText(results[2]);
               salaryTextView.setText(results[3]);
           }
       });


    }
}
