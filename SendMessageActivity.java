package edu.ncsu.csc.csc216.acronym_annihilator.activities.contacts;

import edu.ncsu.csc.csc216.acronym_annihilator.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Activity class for sending email and removing all acronyms contained within. This class was designed by studying the other 
 * activity classes written by Dr. Heckman.
 * @author Pierce
 * @version 1.0
 */
public class SendMessageActivity extends Activity {
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.message_send); //Grabs the data from the XML file
		
		setUpAnnihilateButton(); //Sets up the Annihilate Button
		setUpCancelButton(); //Sets up the Cancel Button
		setUpSendButton(); //Sets up the Send Button
	}
	
	/**
	 * Sets up the Annihilate Button
	 */
	private void setUpAnnihilateButton(){
		Button annihilateButton = (Button) findViewById(R.id.AnnihilateButton);
		annihilateButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				displayToast("Annihilating Acronyms...");
			}
			
		});
	}
	
	/**
	 * Sets up the Cancel Button
	 */
	private void setUpCancelButton(){
		Button cancelButton = (Button) findViewById(R.id.CancelButton);
		cancelButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				displayToast("Canceling...");
			}
			
		});
	}
	
	/**
	 * Sets up the Send Button
	 */
	private void setUpSendButton(){
		Button sendButton = (Button) findViewById(R.id.SendButton);
		sendButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				displayToast("Sending...");
			}
			
		});
	}
	
	/**
	 * Displays the message by method of Toast
	 * @param message The message to be displayed
	 */
	public void displayToast(String message) {
		Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
	}
	
}
