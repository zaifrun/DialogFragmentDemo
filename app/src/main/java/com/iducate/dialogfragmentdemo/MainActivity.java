package com.iducate.dialogfragmentdemo;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {

	static MyDialogFragment dialog;
	static Context context;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.context = this;
		setContentView(R.layout.activity_main);
	}

	//This is the event handler for the show button
	//This is specified in the xml file that this should
	//be the event handler
	public void showDialog(View v) {
		//showing our dialog.

		dialog = new MyDialog();
		//Here we show the dialog
		//The tag "MyFragement" is not important for us.
		dialog.show(getFragmentManager(), "MyFragment");
	}

	public static class MyDialog extends MyDialogFragment {

		@Override
		protected void positiveClick() {
			//Here we override the methods and can now
			//do something
			Toast toast = Toast.makeText(context,
					"positive button clicked", Toast.LENGTH_LONG);
			toast.show();
		}

		@Override
		protected void negativeClick() {
			//Here we override the method and can now do something
			Toast toast = Toast.makeText(context,
					"negative button clicked", Toast.LENGTH_SHORT);
			toast.show();
		}
	}

}
