package com.example.android.expandingcells;

import android.os.Bundle;
import android.preference.PreferenceManager;
import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class GetUserOpt extends Activity {

	  private Spinner sunSignSpinner;
	  private String sunSign;
	  private EditText etNickName;
	  private String nickName;
	  
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_get_user_opt);
		
		//Toast.makeText(this, "get user input", Toast.LENGTH_LONG).show();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.get_user_opt, menu);
		return true;
	}
	
	public void onDone(View v){
	    sunSignSpinner = (Spinner) findViewById(R.id.spinner1);
	    etNickName = (EditText) findViewById(R.id.etNickName);
	    nickName = etNickName.getText().toString();
 	    sunSign = String.valueOf(sunSignSpinner.getSelectedItem());
		   Toast.makeText(this, "OnClickListener : " + sunSign + " " + nickName,
		                Toast.LENGTH_SHORT).show();
		   
	         SharedPreferences settings = getSharedPreferences("prefs", 0);
	         SharedPreferences.Editor editor = settings.edit();
	         editor.putBoolean("firstRun", false);
	         editor.putString("sunsign", sunSign);
	         editor.putString("nickname", nickName);
	         editor.commit();
		   this.finish();
	}

}
