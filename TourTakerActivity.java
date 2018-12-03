package edu.ncsu.csc.csc216.wolftours.activity;

import edu.ncsu.csc.csc216.wolftours.R; 
import edu.ncsu.csc.csc216.wolftours.tour_stop.Iterator;
import edu.ncsu.csc.csc216.wolftours.tour_stop.TourStop;
import edu.ncsu.csc.csc216.wolftours.tour_stop.TourStopListManager;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Implements the TourTaker functionality. The TourTaker shows the name,
 * picture, address, and description information for a TourStop. Additionally,
 * there are Previous and Next buttons that a user can select to iterate through
 * the TourStops.
 * 
 * If you choose to implement the extra credit, that TourTakerActivity will need
 * to be modified to play the audio clips stored on your Android given a path to
 * the clip.
 * 
 * @author SarahHeckman
 * @author LydiaPeedin
 * @author LucasWard
 * @author RobertAtkinson
 * @author PierceEllis
 * @author WilliamFisher
 */
public class TourTakerActivity extends Activity {

	/** Current tour stop */
	private TourStop stop;
	/** TourStopListManager instance */
	private TourStopListManager manager;

	/**
	 * Creates the TourTaker Activity
	 */
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tour_taker);

		manager = TourStopListManager.getInstance(this);		

		/*
		 * A boolean is saved in the intent that notifies the Activity which way
		 * to iterate with the Iterator based on the Button press from the
		 * previous TourStop. If the user is coming from the ShowChoiceActivity
		 * the boolean is set to true, and the next TourStop is shown
		 */
		Bundle extra = getIntent().getExtras();
		if (extra.getBoolean(Iterator.TOUR_STOP_LIST_ITERATOR)) {
			stop = manager.getNext();
		} else {
			stop = manager.getPrev();
		}

		// Get all of the components that make up the TourTakeActivity UI
		// TourStop Name
		final TextView textTourStopName = (TextView) findViewById(R.id.TourTakerTourStopNameText);
		// TourStop image button. It's disable b/c we just want to show an image
		final ImageButton imageTourStop = (ImageButton) findViewById(R.id.TourTakerImageButton);
		imageTourStop.setClickable(false);
		// TourStop building address
		final TextView textTourStopBuildingAddress = (TextView) findViewById(R.id.TourTakerTextViewBuildingAddress);
		// TourStop description
		final TextView textTourStopDescription = (TextView) findViewById(R.id.TourTakerTextView);

		// Set the textTourStopName, textTourStopBuildingAddress, and
		// textTourStopDescription TextViews with info from the current tour
		// stop
		textTourStopName.setText(stop.getName());
		textTourStopBuildingAddress.setText(stop.getBuildingNumber());
		textTourStopDescription.setText(stop.getDescription());
		

		/*
		 * Creates a Bitmap image from the user specified path. The path starts
		 * from the root of the phone's file system. Since the file system is
		 * Linux, the root is /.
		 * 
		 * If you create an AVD with an SD Card and SD Card support, you can
		 * push pictures onto SD Card in the emulator via the DDMS view. Then
		 * you can specify the path /sdcard/picture_name.
		 * 
		 * If you take photos with your phone, you will need to look up the path
		 * to where the pictures are stored. Use the DDMS view to explore your
		 * phone's file system.
		 * 
		 * To explore the file system, select the emulator (or phone) that is
		 * running, and the select the File Explorer tab.
		 */
		Bitmap bm = BitmapFactory.decodeFile(stop.getImagePath());
		imageTourStop.setScaleType(ImageView.ScaleType.FIT_CENTER);
		imageTourStop.setImageBitmap(bm);

		setUpPreviousButton();
		setUpNextButton();
	}

	/**
	 * Creates the listener for the Previous button
	 */
	private void setUpPreviousButton() {
		// Implementation of the previous button. The Button should be disabled
		// if there is no previous TourStop (i.e. the TourStop is the first on
		// the list).
		Button btnPrevious = (Button) findViewById(R.id.TourTakerPrevButton);
		if (manager.getPrevId(stop) == -1L) {
			btnPrevious.setEnabled(false);
		}
		btnPrevious.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent i = new Intent(TourTakerActivity.this,
						TourTakerActivity.class);
				i.putExtra(Iterator.TOUR_STOP_LIST_ITERATOR, false);
				startActivity(i);
			}
		});
	}

	/**
	 * Creates the listener for the Next button
	 */
	private void setUpNextButton() {
		// Implementation of the next button. The Button should be disabled
		// if there is no next TourStop (i.e. the TourStop is the last on the
		// list).
		Button btnNext = (Button) findViewById(R.id.TourTakerNextButton);
		if (manager.getNextId(stop) == -1L) {
			btnNext.setEnabled(false);
		}
		btnNext.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent i = new Intent(TourTakerActivity.this,
						TourTakerActivity.class);
				i.putExtra(Iterator.TOUR_STOP_LIST_ITERATOR, true);
				startActivity(i);
			}
		});
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			Intent intent = new Intent(TourTakerActivity.this,
					ShowChoiceActivity.class);
			startActivity(intent);
		}
		return super.onKeyDown(keyCode, event);
	}

}
