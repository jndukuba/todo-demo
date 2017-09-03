package com.codepath.honeydue.storage;

import com.raizlabs.android.dbflow.annotation.Database;

/**
 * Created by jndukuba on 9/3/17.
 */
@Database(name = HoneyDueDatabase.NAME, version = HoneyDueDatabase.VERSION)
public class HoneyDueDatabase {

    public static final String NAME = "HoneyDueDb";
    public static final int VERSION = 1;

}
