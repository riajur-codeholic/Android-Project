package com.coderchef.mywallet;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.coderchef.mywallet.R;
import com.coderchef.sqlite.MySQLiteHelper;
import com.coderchef.userinfo.LoanHolderInfo;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class LoanManager extends Activity implements View.OnClickListener {

    EditText name,phone,amount,address,start,end;
    Button submitBtn;
    RadioButton give,take,selectedRadioButton;
    RadioGroup serviceSelect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loan_manager);

        name = (EditText) findViewById(R.id.loanHolderName);
        phone = (EditText) findViewById(R.id.loanHolderPhoneNumber);
        amount = (EditText) findViewById(R.id.loanHolderAmount);
        address = (EditText) findViewById(R.id.loanHolderAddress);
        start = (EditText) findViewById(R.id.startDate);
        end = (EditText) findViewById(R.id.endDate);
        submitBtn = (Button) findViewById(R.id.loanHolderButtonSubmit);
        give = (RadioButton) findViewById(R.id.radioButtonGive);
        take = (RadioButton) findViewById(R.id.radioButtonTake);
        serviceSelect =(RadioGroup) findViewById(R.id.radioSelect);
        submitBtn.setOnClickListener(this);

        Calendar c = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        String formattedDate = df.format(c.getTime());
        Toast.makeText(getApplicationContext(),formattedDate, Toast.LENGTH_LONG).show();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.loan_manager, menu);
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
        if(view.getId()==R.id.submitBtn){
            MySQLiteHelper dbHelper = new MySQLiteHelper(this);
            String clientName,clientPhone,clientAmount,clientAddress,dateStart,dateEnd,clientStatus;
            int selectedID;
            long check;
            clientName = name.getText().toString();
            clientPhone = phone.getText().toString();
            clientAmount = amount.getText().toString();
            clientAddress = address.getText().toString();
            dateStart = start.getText().toString();
            dateEnd = end.getText().toString();
            selectedID = serviceSelect.getCheckedRadioButtonId();
            selectedRadioButton = (RadioButton) findViewById(selectedID);
            clientStatus = selectedRadioButton.getText().toString();
            check = dbHelper.insertLoanEntry(new LoanHolderInfo(clientName,clientPhone,clientAmount,clientAddress,dateStart,dateEnd,clientStatus));
            if(check>0){
                Toast.makeText(getApplicationContext(),"Successfully Inserted to Your List",Toast.LENGTH_LONG).show();
            }
            else{
                Toast.makeText(getApplicationContext(),"Crap :(",Toast.LENGTH_LONG).show();
            }
        }
    }
}
