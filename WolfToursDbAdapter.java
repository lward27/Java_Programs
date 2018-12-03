package edu.ncsu.csc.csc216.wolftours.db;

import edu.ncsu.csc.csc216.wolftours.tour_stop.LinkedList;
import edu.ncsu.csc.csc216.wolftours.tour_stop.List;
import edu.ncsu.csc.csc216.wolftours.tour_stop.TourStop;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Adapter class for connecting to the database. Clients of the database will
 * use methods of this class to add, modify, delete, and select TourStops from
 * the database.
 * 
 * @author SarahHeckman
 * @author LydiaPeedin 
 * @author LucasWard
 * @author RobertAtkinson
 * @author PierceEllis
 * @author WilliamFisher
 */
public class WolfToursDbAdapter {

	/** Helper class for connecting to the database */
	private DatabaseHelper mDbHelper;
	/** Instance of the SQLite database */
	private SQLiteDatabase mDb;
	/** Context calling the database */
	private final Context mCtx;

	/** Name of the database */
	private static final String DB_NAME = "data";
	/** Name of the table that stores context names and ids */
	private static final String DB_TOUR_STOP_NAME = "node";
	/** Version of the db. Used to show upgrades */
	private static final int DB_VERSION = 2;

	/** ID column name */
	public static final String KEY_ID = "_id";
	/** Node name - usually building or tour location name */
	public static final String KEY_NAME = "name";
	/** Campus Building Number */
	public static final String KEY_BUILDING_NUMBER = "building_number";
	/** Campus Building Address */
	public static final String KEY_BUILDING_ADDRESS = "building_address";
	/** Description of node */
	public static final String KEY_DESCRIPTION = "description";
	/** Path to tour stop image */
	public static final String KEY_IMAGE_PATH = "image_path";
	/** Next node in tour */
	public static final String KEY_NEXT = "next";
	/** Previous node in the tour */
	public static final String KEY_PREV = "previous";
	
	/** Constant for bad values */
	public static final int ERROR_VALUE = -1;

	/** String to create the tour stop table */
	private static final String DB_TOUR_STOP_CREATE = "CREATE TABLE "
			+ DB_TOUR_STOP_NAME + " (" + KEY_ID
			+ " integer primary key autoincrement, " + KEY_NAME
			+ " text not null unique, " + KEY_BUILDING_NUMBER + " text, "
			+ KEY_BUILDING_ADDRESS + " text, " + KEY_IMAGE_PATH + " text, "
			+ KEY_DESCRIPTION + " text, " + KEY_NEXT + " long, " + KEY_PREV
			+ " long)";

	/** String to drop the tour stop table */
	private static final String DROP_TOUR_STOP_TABLE = "DROP TABLE "
			+ DB_TOUR_STOP_NAME;

	/**
	 * Constructor -takes the context to allow the database to be opened/created
	 * 
	 * @param ctx the Context within which to work
	 */
	public WolfToursDbAdapter(Context ctx) {
		this.mCtx = ctx;
	}

	/**
	 * Opens the database for use by the application
	 * 
	 * @return the WolfToursDbAdapter opened
	 * @throws SQLException
	 */
	public WolfToursDbAdapter open() throws SQLException {
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
			mDb.execSQL(DB_TOUR_STOP_CREATE);
		} catch (SQLException e) {
			// IGNORE! If we get an exception here, the tables exist
		}
	}

	/**
	 * Drops all tables from the database. For testing purposes only!
	 */
	public void dropTables() {
		mDb.execSQL(DROP_TOUR_STOP_TABLE);
	}

	/**
	 * Returns the id of the TourStop added to the database. The id is used to
	 * track TourStops and to keep track of prev and next TourStops in the
	 * database
	 * 
	 * @param tourStop
	 *            a TourStop to store in the database
	 * @return the id of the created TourStop
	 */
	public long addTourStop(TourStop tourStop) {
		try {
			ContentValues values = new ContentValues();
			values.put(KEY_NAME, tourStop.getName());
			values.put(KEY_BUILDING_NUMBER, tourStop.getBuildingNumber());
			values.put(KEY_BUILDING_ADDRESS, tourStop.getBuildingAddress());
			values.put(KEY_DESCRIPTION, tourStop.getDescription());
			values.put(KEY_IMAGE_PATH, tourStop.getImagePath());
			values.put(KEY_NEXT, ERROR_VALUE);
			values.put(KEY_PREV, ERROR_VALUE);

			long id = mDb.insert(DB_TOUR_STOP_NAME, null, values);
			return id;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ERROR_VALUE;
	}

	/**
	 * Returns true if the TourStop could be deleted
	 * 
	 * @return true if the TourStop is successfully deleted
	 */
	public boolean deleteTourStop(long id) {
		return mDb.delete(DB_TOUR_STOP_NAME, KEY_ID + "=" + id, null) > 0;
	}

	/**
	 * Returns true if a TourStop could be updated
	 * 
	 * @param tourStop
	 *            the TourStop to update
	 * @return true if the TourStop is successfully updated
	 */
	public boolean updateTourStop(TourStop tourStop, long prev, long next) {
		ContentValues values = new ContentValues();
		values.put(KEY_NAME, tourStop.getName());
		values.put(KEY_BUILDING_NUMBER, tourStop.getBuildingNumber());
		values.put(KEY_BUILDING_ADDRESS, tourStop.getBuildingAddress());
		values.put(KEY_DESCRIPTION, tourStop.getDescription());
		values.put(KEY_IMAGE_PATH, tourStop.getImagePath());
		values.put(KEY_NEXT, next);
		values.put(KEY_PREV, prev);

		try {
			return mDb.update(DB_TOUR_STOP_NAME, values, KEY_ID + "="
					+ tourStop.get_id(), null) > 0;
		} catch (SQLiteConstraintException e) {
			return false;
		}
	}

	/**
	 * Returns true if the next and prev nodes of a TourStop are updated
	 * 
	 * @param id
	 *            of TourStop to update
	 * @param prev
	 *            new prev node of TourStop
	 * @param next
	 *            new next node of TourStop
	 * @return if the next and prev nodes are successfully updated
	 */
	public boolean updateTourStopListNode(long id, long prev, long next) {
		ContentValues values = new ContentValues();
		values.put(KEY_NEXT, next);
		values.put(KEY_PREV, prev);

		return mDb.update(DB_TOUR_STOP_NAME, values, KEY_ID + "=" + id, null) > 0;
	}

	/**
	 * Returns a TourStopList for Wolf Tours
	 * 
	 * @return a TourStopList containing all TourStops in the database
	 */
	public List getTourStopList() {
		Cursor c = null;

		List list = new LinkedList();
		try {
			long id = -1;
			// Need to get first Den in list - can tell b/c prev is -1
			c = mDb.query(DB_TOUR_STOP_NAME, new String[] { KEY_ID, KEY_NAME,
					KEY_BUILDING_NUMBER, KEY_BUILDING_ADDRESS, KEY_DESCRIPTION,
					KEY_IMAGE_PATH, KEY_NEXT, KEY_PREV }, KEY_PREV + "=" + id,
					null, null, null, null);

			// There should be only one
			c.moveToFirst();
			if (c.getCount() > 0) {
				TourStop tourStop = new TourStop();
				tourStop.set_id(c.getLong(0));
				tourStop.setName(c.getString(1));
				tourStop.setBuildingNumber(c.getString(2));
				tourStop.setBuildingAddress(c.getString(3));
				tourStop.setDescription(c.getString(4));
				tourStop.setImagePath(c.getString(5));
				id = c.getLong(6); // get next id
				list.add(tourStop);
			}
			c.close();

			while (id != ERROR_VALUE) {
				c = mDb.query(DB_TOUR_STOP_NAME, new String[] { KEY_ID,
						KEY_NAME, KEY_BUILDING_NUMBER, KEY_BUILDING_ADDRESS,
						KEY_DESCRIPTION, KEY_IMAGE_PATH, KEY_NEXT, KEY_PREV },
						KEY_ID + "=" + id, null, null, null, null);

				// There should be only one
				c.moveToFirst();
				if (c.getCount() > 0) {
					TourStop tourStop = new TourStop();
					tourStop.set_id(c.getLong(0));
					tourStop.setName(c.getString(1));
					tourStop.setBuildingNumber(c.getString(2));
					tourStop.setBuildingAddress(c.getString(3));
					tourStop.setDescription(c.getString(4));
					tourStop.setImagePath(c.getString(5));
					id = c.getLong(6); // get next id
					list.add(tourStop);
				}
				c.close();
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (c != null) {
				c.close();
			}
		}
		return list;
	}

	/**
	 * Returns the id of the tour stop that is the previous node in the list
	 * from the current tour stop id
	 * 
	 * @param id
	 *            the id of the current tour stop
	 * @return the id of the previous node in the list
	 */
	public long getPrevIdById(long id) {
		Cursor c = null;
		long i = ERROR_VALUE;
		try {
			c = mDb.query(DB_TOUR_STOP_NAME, new String[] { KEY_PREV }, KEY_ID
					+ "=" + id, null, null, null, null);
			// There should be only one
			c.moveToFirst();
			if (c.getCount() > 0) {
				i = c.getLong(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (c != null) {
				c.close();
			}
		}
		return i;
	}

	/**
	 * Returns the id of the tour stop that is the next node in the list from
	 * the current tour stop id
	 * 
	 * @param id
	 *            the id of the current tour stop
	 * @return the id of the next node in the list
	 */
	public long getNextIdById(long id) {
		Cursor c = null;
		long i = ERROR_VALUE;
		try {
			c = mDb.query(DB_TOUR_STOP_NAME, new String[] { KEY_NEXT }, KEY_ID
					+ "=" + id, null, null, null, null);
			// There should be only one
			c.moveToFirst();
			if (c.getCount() > 0) {
				i = c.getLong(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (c != null) {
				c.close();
			}
		}
		return i;
	}

	/**
	 * Returns a TourStop from it's ID
	 * 
	 * @param _id
	 *            the id for a TourStop
	 * @return the TourStop object associated with the id or null if there is no
	 *         tour stop
	 */
	public TourStop getTourStopById(long id) {
		Cursor c = null;
		TourStop tourStop = null;
		try {
			c = mDb
					.query(DB_TOUR_STOP_NAME, new String[] { KEY_ID, KEY_NAME,
							KEY_BUILDING_NUMBER, KEY_BUILDING_ADDRESS,
							KEY_DESCRIPTION, KEY_IMAGE_PATH }, KEY_ID + "="
							+ id, null, null, null, null);
			// There should be only one
			c.moveToFirst();
			if (c.getCount() > 0) {
				tourStop = new TourStop();
				tourStop.set_id(c.getLong(0));
				tourStop.setName(c.getString(1));
				tourStop.setBuildingNumber(c.getString(2));
				tourStop.setBuildingAddress(c.getString(3));
				tourStop.setDescription(c.getString(4));
				tourStop.setImagePath(c.getString(5));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (c != null) {
				c.close();
			}
		}
		return tourStop;
	}

	/**
	 * Returns a Cursor listing all of the tour stop names stored in the
	 * database. The Cursor MUST be closed by the calling method
	 * 
	 * @return a Cursor listing all TourStop names
	 * @return
	 */
	public Cursor getAllTourStopNames() {
		return mDb.query(DB_TOUR_STOP_NAME, new String[] { KEY_ID, KEY_NAME },
				null, null, null, null, KEY_NAME + " ASC");
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
			db.execSQL(DB_TOUR_STOP_CREATE);
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int arg1, int arg2) {
			// Don't need b/c DB schema should be stable
		}

	}

}
