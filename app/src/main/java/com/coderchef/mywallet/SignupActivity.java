package com.coderchef.mywallet;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.coderchef.mywallet.R;
import com.coderchef.sqlite.MySQLiteHelper;
import com.coderchef.userinfo.UserData;
import com.coderchef.userinfo.UserInfo;

public class SignupActivity extends Activity implements View.OnClickListener{

    EditText emailField,userFld,passField;
    Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        emailField = (EditText)findViewById(R.id.userEmail);
        userFld =(EditText) findViewById(R.id.userName);
        passField =(EditText) findViewById(R.id.userPassword);
        submit =(Button) findViewById(R.id.submitBtn);
        submit.setOnClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.signup, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {

        MySQLiteHelper dbHelper = new MySQLiteHelper(this);
        String userMail, userID, userPass;
        userMail = emailField.getText().toString();
        userID = userFld.getText().toString();
        userPass = passField.getText().toString();
        long temp=dbHelper.insertUser(new UserData(userMail,userID,userPass));
        Toast.makeText(getApplicationContext(),String.valueOf(temp),Toast.LENGTH_LONG).show();
    }
}
