package ru.ekozoch.resumesender;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class BossActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_boss);
		
		TextView txtInfo  = (TextView)findViewById(R.id.textView1);
		TextView phoneNumber  = (TextView)findViewById(R.id.phonecallView);
	    String fio, birthdate, gender, position, phone, salary, mail;
	    
	    fio = getIntent().getExtras().getString("fio");
	    birthdate = getIntent().getExtras().getString("birthdate");
	    gender = getIntent().getExtras().getString("gender");
	    position = getIntent().getExtras().getString("position");
	    phone = getIntent().getExtras().getString("phone");
	    salary = getIntent().getExtras().getString("salary");
	    mail = getIntent().getExtras().getString("mail");
	    
	    txtInfo.setText("���: " + fio + "\n" + "���� ��������: " + birthdate + "\n" + "���: " + gender + "\n" +
	    			"���������: " + position + "\n" + "�����: " + salary + "\n" + "Email: " + mail);
	    phoneNumber.setText("�������: " + phone );
	}
	
	public final static String REPLY = "ru.ekozoch.cvsender.REPLY";
	
	public void onClick(View v) {
		TextView Warning  = (TextView)findViewById(R.id.warningView2);
		Intent answerIntent = new Intent();
		boolean full= true;
		EditText reply = (EditText) findViewById(R.id.editText1);
		String answer = reply.getText().toString();
		answerIntent.putExtra(REPLY, answer );
		if( answer.length() == 0 ) full = false;
		if(full==true){
			setResult(RESULT_OK, answerIntent);
			finish();
		}
		else{
			Warning.setText("����������, ��������� ���� ��� ������!");
		}
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.boss, menu);
		return true;
	}

}
