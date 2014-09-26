package com.coderchef.mywallet;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.coderchef.mywallet.R;
import com.coderchef.sqlite.MySQLiteHelper;

public class TestActivity extends Activity implements View.OnClickListener{

    Button signInButton,signUpButton,helpButton;
    EditText userField,passField;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        signInButton =(Button) findViewById(R.id.loginButton);
        signUpButton = (Button) findViewById(R.id.signUpButton);
        helpButton = (Button) findViewById(R.id.helpButton);
        userField = (EditText) findViewById(R.id.userNameField);
        passField = (EditText) findViewById(R.id.passwordField);
        signInButton.setOnClickListener(this);
        signUpButton.setOnClickListener(this);
        helpButton.setOnClickListener(this);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.test, menu);
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
    public void onClick(View v) {
        Intent intent = null;
        if(v.getId()==R.id.signUpButton){
            intent = new Intent(this,SignupActivity.class);
            startActivity(intent);
        }
        else if(v.getId()==R.id.helpButton){

        }
        else if(v.getId()==R.id.loginButton){
            MySQLiteHelper dbHelper = new MySQLiteHelper(this);
            String userDetails, userPasswords;
            userDetails = userField.getText().toString();
            userPasswords = passField.getText().toString();
            boolean flag=dbHelper.doLogin(userDetails,userPasswords);
            if(flag){
                Intent forwardUser = new Intent(this,UserActivity.class);
                forwardUser.putExtra("Credentials",userDetails);
                startActivity(forwardUser);
                // Toast.makeText(getApplicationContext(), "Successfully Logged In !!!",Toast.LENGTH_LONG).show();
            }
            else{
                Toast.makeText(getApplicationContext(), "Tappor Dite Iccha Kortese Grrrrrrrrrrrr :@", Toast.LENGTH_LONG).show();
            }
        }
    }
}
