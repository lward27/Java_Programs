package edu.ncsu.csc.csc216.wolftours.activity;

import edu.ncsu.csc.csc216.wolftours.R;
import edu.ncsu.csc.csc216.wolftours.db.WolfToursDbAdapter;
import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

/**
 * Lists all of the TourStops in the database
 * 
 * @author SarahHeckman
 * @author LydiaPeedin
 * @author LucasWard
 * @author RobertAtkinson
 * @author PierceEllis
 * @author WilliamFisher
 */
public class ShowTourStopListActivity extends ListActivity {

	/**
	 * Reference to the database
	 */
	private WolfToursDbAdapter mDbHelper;

	/**
	 * Creates the ShowTourStopListActivity
	 */
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tour_stop_list);

		mDbHelper = new WolfToursDbAdapter(this);
		mDbHelper.open();

		fillData();

		setUpAddButton();

	}

	/**
	 * Sets up the Add button
	 */
	private void setUpAddButton() {
		ImageButton addButton = (ImageButton) findViewById(R.id.AddNewImageButton);
		addButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent i = new Intent(ShowTourStopListActivity.this,
						AddTourStopActivity.class);
				mDbHelper.close();
				startActivity(i);
			}

		});

		TextView addText = (TextView) findViewById(R.id.AddNewText);
		addText.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent i = new Intent(ShowTourStopListActivity.this,
						AddTourStopActivity.class);
				mDbHelper.close();
				startActivity(i);
			}

		});
	}

	/**
	 * Fills the list with TourStop names from the database. Additionally, the
	 * TourStop's unique id is associated with the name so that the TourStop
	 * data can be pulled from the database to populate the fields on the
	 * ModifyTourStopActivity
	 */
	private void fillData() {
		Cursor namesList = mDbHelper.getAllTourStopNames();
		startManagingCursor(namesList);

		String[] from = new String[] { WolfToursDbAdapter.KEY_NAME,
				WolfToursDbAdapter.KEY_ID };
		int[] to = new int[] { R.id.TourStopName };
		SimpleCursorAdapter notes = new SimpleCursorAdapter(this,
				R.layout.tour_stop_row, namesList, from, to);
		setListAdapter(notes);
	}

	/**
	 * This method is called whenever a list item is selected by the user. The
	 * user is then taken to the ModifyTourStopActivity
	 */
	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
		Intent i = new Intent(this, ModifyTourStopActivity.class);
		i.putExtra(WolfToursDbAdapter.KEY_ID, id);
		mDbHelper.close();
		startActivity(i);
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			Intent intent = new Intent(ShowTourStopListActivity.this,
					ShowChoiceActivity.class);
			startActivity(intent);
		}
		return super.onKeyDown(keyCode, event);
	}
}
