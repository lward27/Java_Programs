package edu.ncsu.csc.csc216.acronym_annihilator.activities.contacts;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import edu.ncsu.csc.csc216.acronym_annihilator.R;
import edu.ncsu.csc.csc216.acronym_annihilator.db.ContactsDbAdapter;
import edu.ncsu.csc.csc216.acronym_annihilator.model.contacts.Contact;

/**
 * Activity class for editing/deleting a contact in the contact
 * list.
 * @author SarahHeckman
 */
public class EditContactActivity extends Activity {
	
	/** Text field for the first name */
	private EditText firstName;
	/** Text field for the last name */
	private EditText lastName;
	/** Text field for the email */
	private EditText email;
	/** Text field for the organization */
	private EditText organization;
	/** Spinner that contains all labels */
	private Spinner label;
	/** Reference to database */
	private ContactsDbAdapter mDbHelper;
	/** Id of contact being edited */
	private Long id;
	/** Contact being edited */
	private Contact c;
	
	/**
	 * Creates the EditContactActivity
	 */
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.contacts_add);
		
		id = savedInstanceState != null ? savedInstanceState.getLong(ContactsDbAdapter.KEY_ID) : null;
		if (id == null) {
			Bundle extras = getIntent().getExtras();
			id = extras != null ? extras.getLong(ContactsDbAdapter.KEY_ID) : null;
		}
		
		firstName = (EditText) findViewById(R.id.AddContactFirstNameEditText);
		lastName = (EditText) findViewById(R.id.AddContactLastNameEditText);
		email = (EditText) findViewById(R.id.AddContactEmailEditText);
		organization = (EditText) findViewById(R.id.AddContactOrganizationEditText);
		
		//Populating a Spinner Info: http://developer.android.com/intl/de/guide/tutorials/views/hello-spinner.html
		label = (Spinner) findViewById(R.id.AddContactLabelSpinner);
		ArrayAdapter<?> adapter = ArrayAdapter.createFromResource(this, R.array.labels, android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		label.setAdapter(adapter);
		
		mDbHelper = new ContactsDbAdapter(this);
		mDbHelper.open();
		
		populateFields();
		
		//Sets up Save Button
		Button saveButton = (Button) findViewById(R.id.AddContactSaveButton);
		saveButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Contact c = new Contact();
				
				c.setFirstName(firstName.getText().toString());
				c.setLastName(lastName.getText().toString());
				c.setEmail(email.getText().toString());
				c.setOrganization(organization.getText().toString());
				c.setLabel(label.getSelectedItem().toString());
				c.setLabelPosition(label.getSelectedItemPosition());
				
				if (c.isValidContact()) {
					if (mDbHelper.editContact(c, id)) {
						displayToast("Contact added");
						Intent intent = new Intent(
								EditContactActivity.this,
								ContactsListActivity.class);
						mDbHelper.close();
						startActivity(intent);						
					} else {
						displayToast("Contact could not be saved");
					}
				} else {
					displayToast("Missing required fields");
				}
				
			} 
		});
		
		//Cancel button
		Button cancelButton = (Button) findViewById(R.id.AddContactCancelButton);
		cancelButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				displayToast("Canceling");
				Intent intent = new Intent(
						EditContactActivity.this,
						ContactsListActivity.class);
				mDbHelper.close();
				startActivity(intent);
			}
		});
		
		//Delete button
		Button deleteButton = (Button) findViewById(R.id.AddContactDeleteButton);
		deleteButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if (mDbHelper.deleteContact(id)) {
					displayToast("Deleting");
					Intent intent = new Intent(
							EditContactActivity.this,
							ContactsListActivity.class);
					mDbHelper.close();
					startActivity(intent);
				} else {
					displayToast("Contact count not be deleted");
				}
			}
		});
	}
	
	/**
	 * Populates the UI fields in the activity with the appropriate 
	 * Contact information
	 */
	private void populateFields() {
		if (id != null) {
			c = mDbHelper.getContactById(id);
			
			//Set the fields
			firstName.setText(c.getFirstName());
			lastName.setText(c.getLastName());
			email.setText(c.getEmail());
			organization.setText(c.getOrganization());
			label.setSelection(c.getLabelPosition());
		}
	}
	
	/**
	 * Display a Toast with the given method
	 */
	public void displayToast(String message) {
		Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
	}
	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if(keyCode == KeyEvent.KEYCODE_BACK) {
			Intent intent = new Intent(
					EditContactActivity.this,
					ContactsListActivity.class);
			mDbHelper.close();
			startActivity(intent);
		}
		return super.onKeyDown(keyCode, event);
	}
}
