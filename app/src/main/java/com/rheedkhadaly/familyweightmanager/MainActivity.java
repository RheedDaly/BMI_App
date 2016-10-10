package com.rheedkhadaly.familyweightmanager;

import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, RadioGroup.OnCheckedChangeListener {

    String gender;
    double person_body_mass_index;

    EditText person_name;
    EditText person_age;
    EditText person_weight;
    EditText person_height;

    RadioGroup genderRadioGroup;

    RadioButton female;
    RadioButton male;

    Button addButton;
    Button editButton;
    Button viewWeightButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        person_name = (EditText) findViewById(R.id.edit_text_name);
        person_age = (EditText) findViewById(R.id.edit_text_age);
        person_weight = (EditText) findViewById(R.id.edit_text_weight);
        person_height = (EditText) findViewById(R.id.edit_text_height);

        genderRadioGroup = (RadioGroup) findViewById(R.id.gender_radio_group);
        female = (RadioButton) findViewById(R.id.radio_female);
        male = (RadioButton) findViewById(R.id.radio_male);

        addButton = (Button) findViewById(R.id.button_add);
        editButton = (Button) findViewById(R.id.button_edit);
        viewWeightButton = (Button) findViewById(R.id.button_view_weight);

        addButton.setOnClickListener(this);
        editButton.setOnClickListener(this);
        viewWeightButton.setOnClickListener(this);
        genderRadioGroup.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.radio_female:
                gender = female.getText().toString();
                break;
            case R.id.radio_male:
                gender = male.getText().toString();
                break;
        }
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.button_add:

                boolean yes = true;

                try {
                    String name = person_name.getText().toString();
                    int age = Integer.parseInt(person_age.getText().toString());
                    Double weight = Double.parseDouble(person_weight.getText().toString());
                    Double height = Double.parseDouble(person_height.getText().toString());
                    person_body_mass_index = weight / Math.pow(height, 2);

                    Person person = new Person();

                    MyDatabase insert_person = new MyDatabase(this);

                    insert_person.open();

                    person.setPersonName(name);
                    person.setPersonGender(gender);
                    person.setPersonAge(age);
                    person.setPersonWeight(weight);
                    person.setPersonHeight(height);
                    person.setPersonBMI(person_body_mass_index);

                    insert_person.addPerson(person);
                    insert_person.close();

                } catch (Exception e) {
                    yes = false;
                } finally {
                    if (yes) {
                        Toast.makeText(this, person_name.getText().toString() + " Has been added!", Toast.LENGTH_SHORT).show();
                        person_name.setText("");
                        person_age.setText("");
                        person_weight.setText("");
                        person_height.setText("");
                        female.setChecked(true);
                    }
                }

                break;
            case R.id.button_edit:

                break;
            case R.id.button_view_weight:
                Intent a = new Intent("com.rheedkhadaly.familyweightmanager.PERSONVIEW");
                startActivity(a);
                break;
        }
    }
}