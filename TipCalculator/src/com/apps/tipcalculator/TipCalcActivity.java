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
	
	//Button onClick Method
	public void onClick(View v){
		//Get the tag passed on the tip percentage clicked
		int perc = Integer.parseInt((String)v.getTag());
		calcTip(perc);
	}

	//Function to calculate the tip and total amount
	private void calcTip(int i) {
		EditText NewItem = (EditText) findViewById(R.id.itfItem);
		//Check to see if bill amount entered is not empty
		if(NewItem.getText().toString().length() != 0)
		{
			Double billAmount = Double.parseDouble(NewItem.getText().toString());
			Double tipAmount = ((billAmount * i) /100 );
			Double totAmount = billAmount + tipAmount;
			tipAmount = roundTwoDecimals(tipAmount);
			totAmount = roundTwoDecimals(totAmount);
			//Set tip amount
			TextView OutItem = (TextView) findViewById(R.id.tipItem);
			OutItem.setText("$" + tipAmount.toString());
			//Set Total Bill amount
			TextView TotItem = (TextView) findViewById(R.id.totItem);
			TotItem.setText("$" + totAmount.toString());	
		}
		else{
			//Reset the values if bill amount is empty
			TextView OutItem = (TextView) findViewById(R.id.tipItem);
			OutItem.setText("");
			TextView TotItem = (TextView) findViewById(R.id.totItem);
			TotItem.setText("");
		}
	}


    //To have two decimals for float values
	public double roundTwoDecimals(double d) {
        DecimalFormat twoDForm = new DecimalFormat("#.##");
    return Double.valueOf(twoDForm.format(d));
}
	
}
