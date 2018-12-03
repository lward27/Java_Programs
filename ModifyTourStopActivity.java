package edu.ncsu.csc.csc216.wolftours.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import edu.ncsu.csc.csc216.wolftours.R;
import edu.ncsu.csc.csc216.wolftours.db.WolfToursDbAdapter; //import edu.ncsu.csc.csc216.wolftours.tour_stop.NameAlreadyExistsException;
import edu.ncsu.csc.csc216.wolftours.tour_stop.TourStop;
import edu.ncsu.csc.csc216.wolftours.tour_stop.TourStopListManager;

/**
 * Collects user input required for a TourStop object and potentially updates it
 * in the list.
 * 
 * @author SarahHeckman
 * @author LydiaPeedin
 * @author LucasWard
 * @author RobertAtkinson
 * @author PierceEllis
 * @author WilliamFisher
 */
public class ModifyTourStopActivity extends Activity {

	private TourStopListManager manager;
	/** Text field for the tour stop name */
	private EditText editTourStopName;
	/** Text field for the tour stop image path */
	private EditText editTourStopImagePath;
	/** Text field for the tour stop description */
	private EditText editTourStopDescription;
	/** Text field for the tour stop building address */
	private EditText editTourStopBuildingAddress;
	/** Text field for the tour stop building number */
	private EditText editTourStopBuildingNumber;
	/** Text field for the tour stop position number */
	private EditText editTourStopPositionNumber;
	/** ID of tour stop being modified */
	private Long id;
	/** TourStop object being edited */
	private TourStop stop;

	/**
	 * Creates the ModifyTourStopActivity
	 */
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tour_stop_add);
		// //////////////////////////////////////////////////
		manager = TourStopListManager.getInstance(this);
		manager.createTourStopList();
		manager.createIterator();
		// /////////////////////////////////////////////////////
		// Get the unique id of the TourStop the use selected
		id = savedInstanceState != null ? savedInstanceState
				.getLong(WolfToursDbAdapter.KEY_ID) : null;
		if (id == null) {
			Bundle extras = getIntent().getExtras();
			id = extras != null ? extras.getLong(WolfToursDbAdapter.KEY_ID)
					: null;
		}

		// Access to each of the EditText fields of the UI
		editTourStopName = (EditText) findViewById(R.id.TourStopAddNameEdit);
		editTourStopImagePath = (EditText) findViewById(R.id.TourStopAddSetPicURIEdit);
		editTourStopDescription = (EditText) findViewById(R.id.TourStopAddSetDescriptionEdit);
		editTourStopBuildingAddress = (EditText) findViewById(R.id.TourStopAddSetAddressEdit);
		editTourStopBuildingNumber = (EditText) findViewById(R.id.TourStopAddSetBldgEdit);
		editTourStopPositionNumber = (EditText) findViewById(R.id.TourStopAddSetPositionEdit);

		populateFields();

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
			public void onClick(View view) {
				// Ensure that the TourStop was created in
				// populateFields()
				stop = manager.getTourStopById(id);

				try {
					// Get the user's modifications from the EditText
					// objects.
					// You can get the text by using
					// EditText.getText().toString();
					String name = editTourStopName.getText().toString();
					String buildingNumber = editTourStopBuildingNumber
							.getText().toString();
					String buildingAddress = editTourStopBuildingAddress
							.getText().toString();
					String description = editTourStopDescription.getText()
							.toString();
					String imagePath = editTourStopImagePath.getText()
							.toString();

					boolean canAdd = true; // Flag variable to keep track if
					// valid input was given.

					// This will catch when the user has entered nothing into
					// the position field
					int position = -1;
					if (!editTourStopPositionNumber.getText().toString() // checks
							// to
							// see
							// if
							// something
							// was
							// entered
							// for
							// the
							// position
							.equals("")) {
						position = Integer.parseInt(editTourStopPositionNumber // if
								// so
								// parse
								// it!
								.getText().toString());
					}
					// You will handle the case where it's not an int in the
					// catch block.

					// How about this when to test if the user has entered no
					// name for a TourStop
					if (editTourStopName.getText().toString().equals("")) {
						displayToast("Tour Stop must have a name.");
						canAdd = false;
					}


					// Sets up the stop
					String oldName = stop.getName();
					TourStop stopTemp = new TourStop();

					stopTemp.setName(name);
					stop.setBuildingNumber(buildingNumber);
					stop.setBuildingAddress(buildingAddress);
					stop.setDescription(description);
					stop.setImagePath(imagePath);
					
					if (manager.contains(stopTemp)) {
						if (name.equals(oldName)) {
							//stop.setName(name);
							stop.setBuildingNumber(buildingNumber);
							stop.setBuildingAddress(buildingAddress);
							stop.setDescription(description);
							canAdd = true;
						} else {
							canAdd = false; // Flag the fail variable
							displayToast("Tour Stop unable to be created. Name already exist in database");
						}
					}

					// Checks to see if the flag variable was flagged
					if (canAdd == true) {
						stop.setName(name);
						displayToast("Tour Stop Saved"); // Save message
						TourStopListManager.getInstance(
								ModifyTourStopActivity.this).updateTourStop(
								stop, position); // Update the stop
						sendToTourStopList(); // Back to the list!
					}

				} catch (NumberFormatException e) {
					// If the TourStopPosition is not an int, an alert is posted
					// and the TourStop is not created.
					displayToast("Tour Stop Position must be an Integer");
				}
			}
		});
	}

	/**
	 * Creates the listener for the cancel button
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
	 * Creates the listener for the delete button
	 */
	private void setUpDeleteButton() {
		Button deleteButton = (Button) findViewById(R.id.TourStopAddDeleteButton);
		deleteButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				if (!manager.removeTourStop(stop)) {
					displayToast("Tour Stop could not be deleted");
					sendToTourStopList();
				} else {
					displayToast("Deleting Tour Stop");
					sendToTourStopList();
				}
			}

		});
	}

	/**
	 * Populates the UI field in the activity with the appropriate TourStop
	 * information
	 */
	private void populateFields() {
		if (id != null) {

			stop = manager.getTourStopById(id);
			editTourStopName.setText(stop.getName());
			editTourStopBuildingAddress.setText(stop.getBuildingAddress());
			editTourStopBuildingNumber.setText(stop.getBuildingNumber());
			editTourStopDescription.setText(stop.getDescription());
			editTourStopImagePath.setText(stop.getImagePath());
			editTourStopPositionNumber.setText(""
					+ manager.getTourStopPosition(stop));

		}
	}

	/**
	 * Creates the Intent that will send the user back to the TourStopList menu
	 */
	private void sendToTourStopList() {
		Intent intent = new Intent(ModifyTourStopActivity.this,
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
			Intent intent = new Intent(ModifyTourStopActivity.this,
					ShowTourStopListActivity.class);
			startActivity(intent);
		}
		return super.onKeyDown(keyCode, event);
	}

}
