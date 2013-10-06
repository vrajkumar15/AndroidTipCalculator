package com.apps.tipcalculator;

import java.text.DecimalFormat;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

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
	
	public void select10PercTip(View v){
		calcTip(10);			
	}
	
	public void select15PercTip(View v){
		calcTip(15);
	}
	
	public void select20PercTip(View v){
		calcTip(20);
	}
	
	private void calcTip(int i) {
		EditText NewItem = (EditText) findViewById(R.id.itfItem);
		Double billAmount = Double.parseDouble(NewItem.getText().toString());
		Double tipAmount = ((billAmount * i) /100 );
		Double totAmount = billAmount + tipAmount;
		tipAmount = roundTwoDecimals(tipAmount);
		totAmount = roundTwoDecimals(totAmount);
		EditText OutItem = (EditText) findViewById(R.id.otfItem);
		OutItem.setText("$" + tipAmount.toString());
		EditText TotItem = (EditText) findViewById(R.id.ttfItem);
		TotItem.setText("$" + totAmount.toString());	
	}



	public double roundTwoDecimals(double d) {
        DecimalFormat twoDForm = new DecimalFormat("#.##");
    return Double.valueOf(twoDForm.format(d));
}
	
}
