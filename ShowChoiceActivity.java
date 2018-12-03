package edu.ncsu.csc.csc216.wolftours.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import edu.ncsu.csc.csc216.wolftours.R;
import edu.ncsu.csc.csc216.wolftours.tour_stop.Iterator;
import edu.ncsu.csc.csc216.wolftours.tour_stop.TourStopListManager;

/**
 * Implements the functionality of the Show Choice portion of the UI. This is
 * the first Activity that is loaded when WolfTours is run. The Activity
 * provides buttons for users to select which path of operation they want to
 * take: TourMaker or TourTaker.
 * 
 * Additionally, the ShowChoiceActivity sets up the TourStopListManager by
 * passing it's Context for database queries. This class also queries the
 * database for the saved TourStop list and sets up the iterator to point to the
 * first TourStop in the list.
 * 
 * @author SarahHeckman
 * @author LydiaPeedin
 * @author LucasWard
 * @author RobertAtkinson
 * @author PierceEllis
 * @author WilliamFisher
 */
public class ShowChoiceActivity extends Activity {

	/** Instance of the TourStopListManager */
	private TourStopListManager manager;

	/**
	 * Creates the ShowChoiceActivity
	 */
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.choice);

		manager = TourStopListManager.getInstance(this);		
		manager.createTourStopList();
		manager.createIterator();

		setUpCreateTourButton();
		setUpTakeTourButton();
	}

	/**
	 * Creates the listener for the Create Tour button
	 */
	private void setUpCreateTourButton() {
		Button btnCreateTour = (Button) findViewById(R.id.ChoiceTourCreateButton);
		btnCreateTour.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent i = new Intent(ShowChoiceActivity.this,
						ShowTourStopListActivity.class);
				startActivity(i);
			}
		});
	}

	/**
	 * Creates the listener for the Take Tour button
	 */
	private void setUpTakeTourButton() {
		Button btnTakeTour = (Button) findViewById(R.id.ChoiceTourTakeButton);
		// Disable the "Take a Tour" button if the list is empty
		if (manager.isListEmpty()) {
			btnTakeTour.setEnabled(false);
		} else {
			btnTakeTour.setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View arg0) {
					Intent i = new Intent(ShowChoiceActivity.this,
							TourTakerActivity.class);
					i.putExtra(Iterator.TOUR_STOP_LIST_ITERATOR, true);
					startActivity(i);
				}
			});
		}
	}

}
