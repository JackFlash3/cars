package com.example.prodigalson7.cars.DataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class DataBaseConnector 
{// DAL - Data Access Layer
	// database name
	private static final String DATABASE_NAME = "Show_me_places";

	///////////////////CARS TABLE////////////////////////
	private static final String CARS_TABLE = "cars";
	private static final String CAR_ID = "_id";
	private static final String MODEL = "model";
	private static final String ENGINE = "engine";
	private static final String INFOTAINMENT="infotainment";
	private static final String INTERIOR_DESIGN="design";
	private static final String LOCATION = "location";

	///////////////////USERS TABLE////////////////////////
	private static final String USERS_TABLE = "users";
	private static final String USER_ID = "_id";
	private static final String NAME = "name";
	private static final String GENDER = "gender";
	private static final String AGE="age";

	///////////////////DEMANDS DEMANDS////////////////////////
	private static final String DEMANDS_TABLE = "demands";
	private static final String DEMAND_ID = "_id";
	private static final String CAR_IDF = "car_id";
	private static final String USER_IDF = "user_id";
	private static final String PICK_UP="pick_up";
	private static final String DROP_OFF="drop_off";
	private static final String EARLIEST_PICKUP = "earliest_pickup";
	private static final String LATEST_DROPOFF = "latest_dropoff";

	private MyDataBase databaseOpenHelper = null; // database helper
	private SQLiteDatabase database = null; // database object

	// public constructor for DatabaseConnector
	public DataBaseConnector(Context context)
	{
		databaseOpenHelper = new MyDataBase(context, DATABASE_NAME, null, 1);
	}

	// open the database connection
	public void open() throws SQLException
	{
		// create or open a database for reading/writing
		database = databaseOpenHelper.getWritableDatabase();
	}

	// close the database connection
	public void close() 
	{
		if (database != null)
			database.close(); // close the database connection
	}

	//===========================CARS TABLE queries=========================//
	// inserts a new car
	public void insertCar(int car_id, String model, String engine, String info, String design, String location)
	{
		ContentValues newDestination = new ContentValues();
		newDestination.put(CAR_ID, car_id);
		newDestination.put(MODEL, model);
		newDestination.put(ENGINE, engine);
		newDestination.put(INFOTAINMENT, info);
		newDestination.put(INTERIOR_DESIGN, design);
		newDestination.put(LOCATION, location);


		open();
		// null to inform android that there is no col id to be null
		database.insert(CARS_TABLE, null, newDestination);
		close();
	}

	// Delete a destination specified by the given String name
	public void deleteCar(int car_id)
	{
		open(); // open the database
		database.delete(CARS_TABLE,
				CAR_ID +"=" + car_id,//where
				null);//where argument for where placeholder's
		close();
	}

	// update an old car in the database
	public void updateCar(int car_id, String model, String engine, String info, String design, String location)
	{
		ContentValues editDestination = new ContentValues();
		editDestination.put(CAR_ID, car_id);
		editDestination.put(MODEL, model);
		editDestination.put(ENGINE, engine);
		editDestination.put(INFOTAINMENT, info);
		editDestination.put(INTERIOR_DESIGN, design);
		editDestination.put(LOCATION, location);

		open(); // open the database
		database.update(CARS_TABLE,
				editDestination,
				CAR_ID +"=" + car_id,// is the where condition
				null);// null is the where parameters replaced by ?
		close(); // close the database
	}

	//get a car
	public Cursor getCar(int car_id)
	{

		return database.query(CARS_TABLE,
				null,//all colmuns
				CAR_ID +"=" + car_id, //where
				null,//the argument for where placeholder's
				null,//group by
				null,//having
				null);//ordered by
	}
	//cars table size
	public int get_cars_table_size()
	{
		open(); // open the database
		Cursor c = database.rawQuery("SELECT COUNT(*) AS Size FROM "+ CARS_TABLE , null);
		c.moveToFirst();
		return c.getInt(c.getColumnIndex("Size"));
		// close the database
	}

	//===========================USERS TABLE queries=========================//
	// inserts a new car
	public void insertUser(int user_id, String name, String gender, double age)
	{
		ContentValues newDestination = new ContentValues();
		newDestination.put(USER_ID, user_id);
		newDestination.put(NAME, name);
		newDestination.put(GENDER, gender);
		newDestination.put(AGE, age);


		open();
		// null to inform android that there is no col id to be null
		database.insert(USERS_TABLE, null, newDestination);
		close();
	}

	// Delete a destination specified by the given String name
	public void deleteUser(int user_id)
	{
		open(); // open the database
		database.delete(USERS_TABLE,
				CAR_ID +"=" + user_id,//where
				null);//where argument for where placeholder's
		close();
	}

	// update an old car in the database
	public void updateUser(int user_id, String name, String gender, double age)
	{
		ContentValues editDestination = new ContentValues();
		editDestination.put(USER_ID, user_id);
		editDestination.put(NAME, name);
		editDestination.put(GENDER, gender);
		editDestination.put(AGE, age);

		open(); // open the database
		database.update(USERS_TABLE,
				editDestination,
				CAR_ID +"=" + user_id,// is the where condition
				null);// null is the where parameters replaced by ?
		close(); // close the database
	}

	//get a car
	public Cursor getUser(int user_id)
	{

		return database.query(USERS_TABLE,
				null,//all colmuns
				USER_ID +"=" + user_id, //where
				null,//the argument for where placeholder's
				null,//group by
				null,//having
				null);//ordered by
	}


	//users table size
	public int get_users_table_size()
	{
		open(); // open the database
		Cursor c = database.rawQuery("SELECT COUNT(*) AS Size FROM "+ USERS_TABLE , null);
		c.moveToFirst();
		return c.getInt(c.getColumnIndex("Size"));
		// close the database
	}
/////////////////////////////////////////////END User Quesries//////////////////////////////////////////////

////////////////////////////////////////////Demands quesries/////////////////////////////////////////////////
// inserts a new car
public void insertUser(int demand_id, int car_idf, int user_idf, String pick_up, String drop_off,
					   					String earliest_pickup, String latest_dropoff)
{
	ContentValues newDestination = new ContentValues();

	newDestination.put(DEMAND_ID, demand_id);
	newDestination.put(CAR_IDF, car_idf);
	newDestination.put(USER_IDF, user_idf);
	newDestination.put(PICK_UP, pick_up);
	newDestination.put(DROP_OFF, drop_off);
	newDestination.put(EARLIEST_PICKUP, earliest_pickup);
	newDestination.put(LATEST_DROPOFF, latest_dropoff);

	open();
	// null to inform android that there is no col id to be null
	database.insert(USERS_TABLE, null, newDestination);
	close();
}

	// Delete a destination specified by the given String name
	public void deleteDemand(int demand_id)
	{
		open(); // open the database
		database.delete(USERS_TABLE,
				CAR_ID +"=" + demand_id,//where
				null);//where argument for where placeholder's
		close();
	}

	// update an old car in the database
	public void updateDemand(int demand_id, int car_idf, int user_idf, String pick_up, String drop_off,
							 String earliest_pickup, String latest_dropoff)
	{
		ContentValues editDestination = new ContentValues();
		editDestination.put(DEMAND_ID, demand_id);
		editDestination.put(CAR_IDF, car_idf);
		editDestination.put(USER_IDF, user_idf);
		editDestination.put(PICK_UP, pick_up);
		editDestination.put(DROP_OFF, drop_off);
		editDestination.put(EARLIEST_PICKUP, earliest_pickup);
		editDestination.put(LATEST_DROPOFF, latest_dropoff);

		open(); // open the database
		database.update(USERS_TABLE,
				editDestination,
				CAR_ID +"=" + demand_id,// is the where condition
				null);// null is the where parameters replaced by ?
		close(); // close the database
	}


	//get a demand
	public Cursor getDemand(int demand_id)
	{

		return database.query(CARS_TABLE,
				null,//all colmuns
				CAR_ID +"=" + demand_id, //where
				null,//the argument for where placeholder's
				null,//group by
				null,//having
				null);//ordered by
	}
	//cars table size
	public int get_demands_table_size()
	{
		open(); // open the database
		Cursor c = database.rawQuery("SELECT COUNT(*) AS Size FROM "+ DEMANDS_TABLE , null);
		c.moveToFirst();
		return c.getInt(c.getColumnIndex("Size"));
		// close the database
	}

////////////////////////////////////////////End Demands quesries/////////////////////////////////////////////////







}
