package com.coderchef.mywallet;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.coderchef.sqlite.MySQLiteHelper;
import com.coderchef.userinfo.UserInfo;
import android.widget.EditText;
import android.widget.Toast;

import com.coderchef.mywallet.R;

public class SigninActivity extends Activity implements View.OnClickListener{


    EditText userField,passwordField;
    Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        userField = (EditText)findViewById(R.id.userNam);
        passwordField = (EditText) findViewById(R.id.userPass);
        login =(Button)findViewById(R.id.loginBtn);
        login.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.signin, menu);
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
        String userDetails, userPasswords;
        userDetails = userField.getText().toString();
        userPasswords = passwordField.getText().toString();
        boolean flag=dbHelper.doLogin(userDetails,userPasswords);
        if(flag){
            Intent forwardUser = new Intent(this,UserActivity.class);
            forwardUser.putExtra("Credentials",userDetails);
            startActivity(forwardUser);
           // Toast.makeText(getApplicationContext(), "Successfully Logged In !!!",Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(getApplicationContext(), "Tappor Dite Iccha Kortese Grrrrrrrrrrrr :@",Toast.LENGTH_LONG).show();
        }
    }
}
