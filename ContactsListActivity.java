package edu.ncsu.csc.csc216.acronym_annihilator.activities.contacts;

import edu.ncsu.csc.csc216.acronym_annihilator.R;
import edu.ncsu.csc.csc216.acronym_annihilator.db.ContactsDbAdapter;
import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

/**
 * Activity class listing all contacts.
 * @author SarahHeckman
 */
public class ContactsListActivity extends ListActivity {

	/**
	 * Reference to the database
	 */
	private ContactsDbAdapter mDbHelper;
	
	/**
	 * Array of items offering choice of task when a user
	 * selects a list item
	 */
	private final CharSequence[] items = {"Send Message", "Edit Contact"};

	/**
	 * Stores the selected id so that it can be passed to
	 * an inner class
	 */
	private long id;
	
	/**
	 * Creates the ContactsListActivity
	 */
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.contacts_list);
		
		mDbHelper = new ContactsDbAdapter(this);
		mDbHelper.open();
		
		fillData();
		
		setUpAddButton();
		setUpSendButton();
	}
	
	/**
	 * Sets up the Add button
	 */
	private void setUpAddButton() {
		ImageButton addButton = (ImageButton) findViewById(R.id.ContactsAddImageButton);
		addButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent i = new Intent(ContactsListActivity.this, AddContactActivity.class);
				mDbHelper.close();
				startActivity(i);
			}
			
		});
		
		TextView addTextView = (TextView) findViewById(R.id.ContactsAddTextView);
		addTextView.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent i = new Intent(ContactsListActivity.this, AddContactActivity.class);
				mDbHelper.close();
				startActivity(i);
			}
		});
	}
	
	/**
	 * Sets up the Send Message button
	 */
	private void setUpSendButton() {
		ImageButton sendButton = (ImageButton) findViewById(R.id.ContactsSendMessageImageButton);
		sendButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				//TODO: Create an intent to start your messenger activity
				Intent i = new Intent(ContactsListActivity.this, SendMessageActivity.class);
				mDbHelper.close();
				startActivity(i);
			}
			
		});
		
		TextView sendTextView = (TextView) findViewById(R.id.ContactsSendMessageTextView);
		sendTextView.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent i = new Intent(ContactsListActivity.this, SendMessageActivity.class);
				//TODO: Create an intent to start your messenger activity
				mDbHelper.close();
				startActivity(i);
			}
		});
	}
	
	/**
	 * Fills the list with TourStop names from the database.  Additionally,
	 * the TourStop's unique id is associated with the name so that the 
	 * TourStop data can be pulled from the database to populate the fields
	 * on the ModifyTourStopActivity
	 */
	private void fillData() {
		Cursor namesList = mDbHelper.getContacts();
		startManagingCursor(namesList);
		
		String [] from = new String[] {ContactsDbAdapter.KEY_FIRST_NAME, ContactsDbAdapter.KEY_LAST_NAME, ContactsDbAdapter.KEY_ID};
		int [] to = new int[] {R.id.ContactFirstName, R.id.ContactLastName};
		SimpleCursorAdapter notes = new SimpleCursorAdapter(this, R.layout.contacts_row, namesList, from, to);
		setListAdapter(notes);
	}
	
	/**
	 * This method is called whenever a list item is selected by the user.  The
	 * user is then taken to the ModifyTourStopActivity
	 */
	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
		this.id = id;
		
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle("Select Task:");
		builder.setItems(items, new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int item) {
				Intent i = null;
				if (item == 0) {
					i = new Intent(ContactsListActivity.this, SendMessageActivity.class);
				} else {
					i = new Intent(ContactsListActivity.this, EditContactActivity.class);
				}
				i.putExtra(ContactsDbAdapter.KEY_ID, ContactsListActivity.this.id);
				mDbHelper.close();
				startActivity(i);
			}
		});
		builder.show();
	}

}
