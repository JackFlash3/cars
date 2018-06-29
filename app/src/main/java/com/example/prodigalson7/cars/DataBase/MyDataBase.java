package com.example.prodigalson7.cars.DataBase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDataBase extends SQLiteOpenHelper
{
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

	private static final String CREATE_TABLE_CARS = "CREATE TABLE "+ CARS_TABLE
			+"("+ CAR_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
			+  MODEL+" TEXT, "+ ENGINE +" TEXT, "+ INFOTAINMENT +" TEXT, "+INTERIOR_DESIGN+" TEXT, "
			+ LOCATION +" DOUBLE );";

	private static final String CREATE_TABLE_USERS = "CREATE TABLE "+ USERS_TABLE
			+"("+ USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
			+  NAME+" TEXT, "+ GENDER +" TEXT, "+ AGE +" INTEGER );";

	private static final String CREATE_TABLE_DEMANDS = "CREATE TABLE "+ DEMANDS_TABLE
			+"("+ DEMAND_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
			+  CAR_IDF+" INTEGER, "+ USER_IDF +" INTEGER, "+ PICK_UP +" TEXT, "+DROP_OFF+" TEXT, "
			+ EARLIEST_PICKUP +" DATE, "+LATEST_DROPOFF +" DATE  );";



	public MyDataBase(Context context, String name, CursorFactory factory,
                      int version)
	{
		super(context, name, factory, version);
	}

	@Override
	public void onCreate(SQLiteDatabase db)
	{
		db.execSQL(CREATE_TABLE_CARS); 	// create CARS_TABLE
		db.execSQL(CREATE_TABLE_USERS); 	// create USERS_TABLE
		db.execSQL(CREATE_TABLE_DEMANDS); 	// create DEMANDS_TABLE
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
	{
	}

}
