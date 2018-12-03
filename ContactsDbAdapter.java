package edu.ncsu.csc.csc216.acronym_annihilator.db;

import edu.ncsu.csc.csc216.acronym_annihilator.model.contacts.Contact;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Database adapter class that stores the contacts
 * @author SarahHeckman
 */
public class ContactsDbAdapter {
	/** Helper class for connecting to the database */
	private DatabaseHelper mDbHelper;
	/** Instance of the SQLite database */
	private SQLiteDatabase mDb;
	/** Context calling the database */
	private final Context mCtx;

	/** Name of the database */
	private static final String DB_NAME = "data";
	/** Name of the table that stores contacts */
	private static final String DB_CONTACTS_NAME = "contacts";
	/** Version of the db. Used to show upgrades */
	private static final int DB_VERSION = 2;

	/**
	 * Constant Strings for each column name in the db tables
	 */
	public static final String KEY_ID = "_id";
	public static final String KEY_LAST_NAME = "last_name";
	public static final String KEY_FIRST_NAME = "first_name";
	public static final String KEY_EMAIL_ADDRESS = "email_address";
	public static final String KEY_ORGANIZATION_NAME = "organization_name";
	public static final String KEY_LABEL = "label";
	public static final String KEY_LABEL_POSITION = "label_position";

	/** String to create the tour stop table */
	private static final String DB_CONTACTS_CREATE = "CREATE TABLE "
			+ DB_CONTACTS_NAME + " (" + 
			KEY_ID + " integer primary key autoincrement, " + 
			KEY_LAST_NAME + " text not null, " + 
			KEY_FIRST_NAME + " text not null, " + 
			KEY_EMAIL_ADDRESS + " text not null, " + 
			KEY_ORGANIZATION_NAME + " text, " + 
			KEY_LABEL + " text not null, " +
			KEY_LABEL_POSITION + " int)";

	/** String to drop the tour stop table */
	private static final String DROP_CONTACTS_TABLE = "DROP TABLE "
			+ DB_CONTACTS_NAME;

	/**
	 * Constructor -takes the context to allow the database to be opened/created
	 * 
	 * @param ctx
	 *            the Context within which to work
	 */
	public ContactsDbAdapter(Context ctx) {
		this.mCtx = ctx;
	}

	/**
	 * Opens the database for use by the application
	 * 
	 * @return the ContactsDbAdapter opened
	 * @throws SQLException
	 */
	public ContactsDbAdapter open() throws SQLException {
		mDbHelper = new DatabaseHelper(mCtx);
		mDb = mDbHelper.getWritableDatabase();
		createTables();
		return this;
	}

	/**
	 * Closes the database
	 */
	public void close() {
		mDbHelper.close();
	}

	/**
	 * Creates the database table for testing purposes. When testing, the
	 * onCreate method in DatabaseHelper is only called the first time the
	 * application is launched. If the tables are dropped, then they must be
	 * explicitly recreated.
	 */
	public void createTables() {
		try {
			mDb.execSQL(DB_CONTACTS_CREATE);
//			fillTable();
		} catch (SQLException e) {
			// IGNORE! If we get an exception here, the tables exist
		}

	}

	/**
	 * Drops all tables from the database. For testing purposes only!
	 */
	public void dropTables() {
		mDb.execSQL(DROP_CONTACTS_TABLE);
	}

	/**
	 * Inner class that helps create and upgrade the database
	 * 
	 * @author SarahHeckman
	 */
	private static class DatabaseHelper extends SQLiteOpenHelper {

		/**
		 * Creates a DatabaseHelper object
		 * 
		 * @param context
		 */
		DatabaseHelper(Context context) {
			super(context, DB_NAME, null, DB_VERSION);
		}

		@Override
		public void onCreate(SQLiteDatabase db) {
			db.execSQL(DB_CONTACTS_CREATE);
		}

		@Override
		public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
			// Don't need b/c DB schema should be stable
		}

	}

	/**
	 * Returns a Cursor into the database for all contacts
	 * 
	 * @return a Cursor for all contacts in the database
	 */
	public Cursor getContacts() {
		return mDb.query(DB_CONTACTS_NAME, new String[] { KEY_ID,
				KEY_FIRST_NAME, KEY_LAST_NAME, KEY_LABEL, KEY_LABEL_POSITION}, null, null, null, null,
				KEY_LAST_NAME + ", " + KEY_FIRST_NAME + " ASC");
	}

	/**
	 * Adds a Contact to the database
	 * 
	 * @param c
	 *            Contact to add to the db
	 * @return the id of the Contact in the db
	 */
	public long addContact(Contact c) {
		ContentValues values = new ContentValues();
		values.put(KEY_LAST_NAME, c.getLastName());
		values.put(KEY_FIRST_NAME, c.getFirstName());
		values.put(KEY_EMAIL_ADDRESS, c.getEmail());
		values.put(KEY_ORGANIZATION_NAME, c.getOrganization());
		values.put(KEY_LABEL, c.getLabel());
		values.put(KEY_LABEL_POSITION, c.getLabelPosition());

		long id = -3;
		try {
			id = mDb.insert(DB_CONTACTS_NAME, null, values);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return id;
	}

	/**
	 * Deletes the contact with the given id from the
	 * database
	 * @param id of Contact to delete
	 * @return true if Contact deleted
	 */
	public boolean deleteContact(long id) {
		return mDb.delete(DB_CONTACTS_NAME, KEY_ID + "=" + id, null) > 0;
	}

	/**
	 * Returns true if the contact is edited
	 * @param c Contact to edit
	 * @param id id of contact to edit
	 * @return true if the contact is edited
	 */
	public boolean editContact(Contact c, long id) {
		ContentValues values = new ContentValues();
		values.put(KEY_LAST_NAME, c.getLastName());
		values.put(KEY_FIRST_NAME, c.getFirstName());
		values.put(KEY_EMAIL_ADDRESS, c.getEmail());
		values.put(KEY_ORGANIZATION_NAME, c.getOrganization());
		values.put(KEY_LABEL, c.getLabel());
		values.put(KEY_LABEL_POSITION, c.getLabelPosition());

		return mDb.update(DB_CONTACTS_NAME, values, KEY_ID + "=" + id, null) > 0;
	}

	/**
	 * Returns the contact with the given id, or 
	 * null if the contact does not exist in the database
	 * @param id of Contact to get from the database
	 * @return the Contact object
	 */
	public Contact getContactById(Long id) {
		Cursor cursor = null;
		Contact c = null;
		try {
			cursor = mDb.query(DB_CONTACTS_NAME, new String[] { KEY_ID,
					KEY_LAST_NAME, KEY_FIRST_NAME, KEY_EMAIL_ADDRESS,
					KEY_ORGANIZATION_NAME, KEY_LABEL, KEY_LABEL_POSITION }, 
					KEY_ID + "=" + id,
					null, null, null, null);
			cursor.moveToFirst();
			if (cursor.getCount() > 0) {
				c = new Contact();
				c.setLastName(cursor.getString(1));
				c.setFirstName(cursor.getString(2));
				c.setEmail(cursor.getString(3));
				c.setOrganization(cursor.getString(4));
				c.setLabel(cursor.getString(5));
				c.setLabelPosition(cursor.getInt(6));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (cursor != null) {
				cursor.close();
			}
		}
		return c;
	}

	/**
	 * Returns an array of Contacts that are displayed 
	 * in the ContactsListActivity
	 * @return array of all Contacts in the database
	 */
	public Contact[] getContactsArray() {
		Cursor cursor = null;
		Contact [] contacts = null;
		try {
			cursor = mDb.query(DB_CONTACTS_NAME, new String[] { KEY_ID,
					KEY_LAST_NAME, KEY_FIRST_NAME, KEY_EMAIL_ADDRESS,
					KEY_ORGANIZATION_NAME, KEY_LABEL, KEY_LABEL_POSITION}, 
					null, null, null, null,
					KEY_LAST_NAME + ", " + KEY_FIRST_NAME + " ASC");
			cursor.moveToFirst();
			if (cursor.getCount() > 0) {
				contacts = new Contact[cursor.getCount()];
				int i = 0;
				do {
					Contact c = new Contact();
					c.setLastName(cursor.getString(1));
					c.setFirstName(cursor.getString(2));
					c.setEmail(cursor.getString(3));
					c.setOrganization(cursor.getString(4));
					c.setLabel(cursor.getString(5));
					c.setLabelPosition(cursor.getInt(6));
					contacts[i++] = c;
				} while (cursor.moveToNext());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (cursor != null) {
				cursor.close();
			}
		}
		// 
		return contacts;
	}
}
