package ru.ekozoch.resumesender;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;

public class ReplyActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_reply);
		
		TextView txtInfo = (TextView)findViewById(R.id.textView1);
	    
	    String text;
	    
	    text = getIntent().getExtras().getString("reply");
	    
	    txtInfo.setText(text);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.reply, menu);
		return true;
	}

}
