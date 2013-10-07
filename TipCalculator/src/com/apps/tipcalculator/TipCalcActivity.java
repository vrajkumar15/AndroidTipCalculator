package com.apps.tipcalculator;

import java.text.DecimalFormat;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class TipCalcActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tip_calc);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tip_calc, menu);
		return true;
	}
	
	public void onClick(View v){
		int perc = Integer.parseInt((String)v.getTag());
		calcTip(perc);
	}

	private void calcTip(int i) {
		EditText NewItem = (EditText) findViewById(R.id.itfItem);
		if(NewItem.getText().toString().length() != 0)
		{
			Double billAmount = Double.parseDouble(NewItem.getText().toString());
			Double tipAmount = ((billAmount * i) /100 );
			Double totAmount = billAmount + tipAmount;
			tipAmount = roundTwoDecimals(tipAmount);
			totAmount = roundTwoDecimals(totAmount);
			TextView OutItem = (TextView) findViewById(R.id.tipItem);
			OutItem.setText("$" + tipAmount.toString());
			TextView TotItem = (TextView) findViewById(R.id.totItem);
			TotItem.setText("$" + totAmount.toString());	
		}
		else{
			TextView OutItem = (TextView) findViewById(R.id.tipItem);
			OutItem.setText("");
			TextView TotItem = (TextView) findViewById(R.id.totItem);
			TotItem.setText("");
		}
	}



	public double roundTwoDecimals(double d) {
        DecimalFormat twoDForm = new DecimalFormat("#.##");
    return Double.valueOf(twoDForm.format(d));
}
	
}
