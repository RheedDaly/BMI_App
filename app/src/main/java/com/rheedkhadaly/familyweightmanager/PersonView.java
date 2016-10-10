package com.rheedkhadaly.familyweightmanager;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class PersonView extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.person_view);

        TextView htv = (TextView) findViewById(R.id.view_sql_person);

        MyDatabase data = new MyDatabase(this);
        data.open();
        String person_data = data.getPersonData();
        data.close();

        htv.setText(person_data);
    }
}
