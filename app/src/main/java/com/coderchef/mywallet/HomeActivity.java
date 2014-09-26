package com.coderchef.mywallet;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class HomeActivity extends Activity implements View.OnClickListener {

    Button signIn;
    Button sign_Up;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        signIn=(Button) findViewById(R.id.signInBtn);
        sign_Up=(Button) findViewById(R.id.signUpBtn);
        signIn.setOnClickListener(this);
        sign_Up.setOnClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
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
        Intent val=null;
        switch(view.getId()){
            case R.id.signInBtn :
                val= new Intent(this,SigninActivity.class);
                break;
            case R.id.signUpBtn :
                val= new Intent(this,SignupActivity.class);
                break;
        }
        startActivity(val);
    }
}
