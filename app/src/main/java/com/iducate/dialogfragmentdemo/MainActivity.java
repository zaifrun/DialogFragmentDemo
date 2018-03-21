package com.iducate.dialogfragmentdemo;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

//we need to implement the interface OnPositiveClicked from my dialog
public class MainActivity extends Activity implements MyDialogFragment.OnPositiveListener {

    MyDialogFragment dialog;
    Context context;


    ArrayList<String> bag = new ArrayList<>();

	//This method is the one we need to implement from the
	//interface. It will be called when the user has clicked the
	//positive button (yes button):
	@Override
	public void onPositiveClicked() {
		//Do your update stuff here to the listview
		//and the bag etc
		//just to show how to get arguments from the bag.
		Toast toast = Toast.makeText(context,
				"positive button clicked", Toast.LENGTH_LONG);
		toast.show();
		bag.clear(); //here you can do stuff with the bag and
		             //adapter etc.
	}



	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		context = this;
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

	public static class  MyDialog extends MyDialogFragment {


		@Override
		protected void negativeClick() {
			//Here we override the method and can now do something
			Toast toast = Toast.makeText(getActivity(),
					"negative button clicked", Toast.LENGTH_SHORT);
			toast.show();
		}


	}

}
