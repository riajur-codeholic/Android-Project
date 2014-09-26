package com.coderchef.mywallet;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Credentials;
import android.os.Bundle;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.coderchef.mywallet.R;

public class UserActivity extends Activity {

    TextView userName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        Intent getVal = getIntent();
        String dump ="    "+getVal.getStringExtra("Credentials").toString();
        setTitle(Html.fromHtml("<font color=\"white\">" + dump + "</font>"));
        getActionBar().setIcon(R.drawable.icon_home);
        getActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#D43E37")));
        populateListView();
    }

    private void populateListView() {
        String []home_items = {"Loan Manager" ,"Bill Tracker" , "Gift Manager" , "Cost Manager" , " Schedule Manager" , "Notepad" , "Quit"};
        Integer [] imageId ={R.drawable.icon_loan,R.drawable.icon_bill,R.drawable.icon_gift,R.drawable.icon_cost,R.drawable.icon_order,R.drawable.icon_notepad,R.drawable.icon_logout};
        int arrow_indi = R.drawable.arrow_indicator;
        CustomList adapter = new CustomList(UserActivity.this,home_items,imageId,arrow_indi);
        ListView listView = (ListView)findViewById(R.id.homeListItem);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,int position, long id) {
                Intent intent = null;
                if(position==0){
                    intent = new Intent(UserActivity.this,LoanListView.class);
                    startActivity(intent);
                }
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.user, menu);
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
}
