package edu.ncsu.csc.csc216.wolftours.activity;

import edu.ncsu.csc.csc216.wolftours.R;
import edu.ncsu.csc.csc216.wolftours.tour_stop.TourStop;
import edu.ncsu.csc.csc216.wolftours.tour_stop.TourStopListManager;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Collects user input required for a TourStop object and potentially adds it to
 * the list.
 * 
 * @author SarahHeckman
 * @author LydiaPeedin
 * @author LucasWard
 * @author RobertAtkinson
 * @author PierceEllis
 * @author WilliamFisher
 */
public class AddTourStopActivity extends Activity {

	/**
	 * Creates the AddTourStopActivity
	 */
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tour_stop_add);

		setUpSaveButton();
		setUpCancelButton();
		setUpDeleteButton();
	}

	/**
	 * Creates the listener for the save button
	 */
	private void setUpSaveButton() {
		Button saveButton = (Button) findViewById(R.id.TourStopAddSaveButton);
		saveButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				TourStop tourStop = new TourStop();

				try {
					// Access to each of the EditText fields of the UI
					EditText editTourStopName = (EditText) findViewById(R.id.TourStopAddNameEdit);
					EditText editTourStopImagePath = (EditText) findViewById(R.id.TourStopAddSetPicURIEdit);
					EditText editTourStopDescription = (EditText) findViewById(R.id.TourStopAddSetDescriptionEdit);
					EditText editTourStopBuildingAddress = (EditText) findViewById(R.id.TourStopAddSetAddressEdit);
					EditText editTourStopBuildingNumber = (EditText) findViewById(R.id.TourStopAddSetBldgEdit);
					EditText editTourStopPositionNumber = (EditText) findViewById(R.id.TourStopAddSetPositionEdit);

					
					//Grabs all the information from the input fields
					String name = editTourStopName.getText().toString();
					String buildingNumber = editTourStopBuildingNumber
							.getText().toString();
					String buildingAddress = editTourStopBuildingAddress
							.getText().toString();
					String description = editTourStopDescription.getText()
							.toString();
					String imagePath = editTourStopImagePath.getText()
							.toString();
					// You can get the text by using
					// EditText.getText().toString();

					boolean canAdd = true; // Flag variable to keep track if
					// valid input was given.

					
					// This will catch when the user has entered nothing into
					// the position field
					int position = -1;
					if (!editTourStopPositionNumber.getText().toString() //checks to see if something was entered for the position
							.equals("")) {
						position = Integer.parseInt(editTourStopPositionNumber //if so parse it!
								.getText().toString());
					}
					// You will handle the case where it's not an int in the
					// catch block.

					// How about this when to test if the user has entered no
					// name for a TourStop
					if (editTourStopName.getText().toString().equals("")) {
						// throw new NameInListException
						// (displayToast("Tour Stop must have a name"));
						displayToast("Tour Stop must have a name.");
						canAdd = false;
					}


					//Assign all the info to the Tour Stop
					tourStop.setName(name);
					tourStop.setBuildingNumber(buildingNumber);
					tourStop.setBuildingAddress(buildingAddress);
					tourStop.setDescription(description);

					tourStop.setImagePath(imagePath);

					//Set up the manager
					TourStopListManager manager;
					manager = TourStopListManager
							.getInstance(AddTourStopActivity.this);
					manager.createTourStopList();
					manager.createIterator();

					//Check to make sure the stop (name) doesn't already exist in the list
					if (manager.contains(tourStop)) {
						canAdd = false; //Flag the fail variable
						displayToast("Tour Stop unable to be created. Name already exist in database");
					}

					//Checks to see if everything is valid
					if (canAdd == true) {
						TourStopListManager.getInstance(AddTourStopActivity.this).addTourStop(tourStop, position);  //Add it
						displayToast("Tour Stop Saved"); //Say it
						sendToTourStopList(); //Send it
					}
					// sure you handle all cases for error using the correct

					// error messages.
					// See the code in the catch for an example of how to
					// display a message to the user.

				} catch (NumberFormatException e) {
					// If the TourStopPosition is not an int, an alert is posted
					// and the TourStop is not created.
					displayToast("Tour Stop Position must be an Integer");
				} 
			}

		});
	}

	/**
	 * Creates the listener for the Cancel button
	 */
	private void setUpCancelButton() {
		Button cancelButton = (Button) findViewById(R.id.TourStopAddCancelButton);
		cancelButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				displayToast("Canceling");
				sendToTourStopList();
			}

		});
	}

	/**
	 * Disables the Delete button
	 */
	private void setUpDeleteButton() {
		Button deleteButton = (Button) findViewById(R.id.TourStopAddDeleteButton);
		deleteButton.setEnabled(false);
	}

	/**
	 * Creates the Intent that will send the user back to the TourStopList menu
	 */
	private void sendToTourStopList() {
		Intent intent = new Intent(AddTourStopActivity.this,
				ShowTourStopListActivity.class);
		startActivity(intent);
	}

	/**
	 * Displays a Toast with the given message
	 */
	private void displayToast(String message) {
		Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			Intent intent = new Intent(AddTourStopActivity.this,
					ShowTourStopListActivity.class);
			startActivity(intent);
		}
		return super.onKeyDown(keyCode, event);
	}

}
