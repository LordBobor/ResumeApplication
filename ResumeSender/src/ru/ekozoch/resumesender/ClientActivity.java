package ru.ekozoch.resumesender;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class ClientActivity extends Activity {
	
	EditText fio, birthdate, position, phone, salary, mail;
	Spinner gender;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.activity_client);
        fio = (EditText) findViewById(R.id.fioText);
        birthdate= (EditText) findViewById(R.id.bdText);
        position= (EditText) findViewById(R.id.positionText);
        phone= (EditText) findViewById(R.id.phoneText);
        salary= (EditText) findViewById(R.id.salaryText);
        mail= (EditText) findViewById(R.id.mailText);      
        gender = (Spinner) findViewById(R.id.gender_spinner);
        
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
    		 R.array.gender_array, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        gender.setAdapter(adapter);
    }

    static final private int SEND_CV = 0;
    
    public void Send_mes(View v) {
    	Intent bossIntent = new Intent(ClientActivity.this,	BossActivity.class);
    	boolean full = true;
    	TextView Warning  = (TextView)findViewById(R.id.warningView1);
    	
    	if(fio.getText().toString().length() == 0) full = false;
    	bossIntent.putExtra("fio", fio.getText().toString());
    	if(birthdate.getText().toString().length() == 0) full = false;
    	bossIntent.putExtra("birthdate", birthdate.getText().toString());
    	bossIntent.putExtra("gender", gender.getSelectedItem().toString());
    	if(position.getText().toString().length() == 0) full = false;
        bossIntent.putExtra("position", position.getText().toString());
        if(phone.getText().toString().length() == 0) full = false;
        bossIntent.putExtra("phone", phone.getText().toString());
        
        if(salary.getText().toString().length() == 0){
        	bossIntent.putExtra("salary", "Готов работать за еду");
        }
        else{
        	bossIntent.putExtra("salary", salary.getText().toString());
        }
        
        if(mail.getText().toString().length() <= 1) full = false;
    	bossIntent.putExtra("mail", mail.getText().toString()); 
    	if(full==true){
    		Warning.setText("");
    		//startActivity(bossIntent);
    		startActivityForResult(bossIntent, SEND_CV);	
		}
		else{
			Warning.setText("Пожалуйста, заполните все поля!");
		}
    }
    
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    	// TODO Auto-generated method stub
    	super.onActivityResult(requestCode, resultCode, data);

    	TextView tvInfo = (TextView) findViewById(R.id.warningView1);
    	if (requestCode == SEND_CV) {
    		if (resultCode == RESULT_OK) {
    			String reply = data.getStringExtra(BossActivity.REPLY);
    			
    			Intent replyIntent = new Intent(ClientActivity.this, ReplyActivity.class);
    	    	replyIntent.putExtra("reply", reply);
    	    	startActivity(replyIntent);
    			//tvInfo.setText(reply);
    		}else {
    			tvInfo.setText(""); 
    		}
    	}
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.client, menu);
        return true;
    }
    
}
