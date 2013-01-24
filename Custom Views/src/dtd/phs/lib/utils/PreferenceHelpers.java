package dtd.phs.lib.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class PreferenceHelpers {

	public static void setPreference(Context context,String prefName, String data) {
		Logger.logInfo("Pref: " + prefName + " is set to: " + (data == null ? "NULL":data) );

		SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(context);
		SharedPreferences.Editor editor = settings.edit();
		editor.putString(prefName, data);
		editor.commit();
	}

	public static String getPreference(Context context,String prefName) {
		SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(context);
		String prefData = settings.getString(prefName, null); 
		return prefData;        
	}


	private static final String FALSE_VALUE = "false";
	private static final String TRUE_VALUE = "true";
	
	private static final String PREF_FIRST_TIME = "pref_first_time";
	private static final String PREF_LAST_CLEAN_UP_SD = "pref_last_clean_up";

	public static boolean firstTimeRunning(Context context) {
		String firstTime = getPreference(context, PREF_FIRST_TIME );
		if ( firstTime == null ) {
			return true;
		} else return false;

	}

	public static void disableFirstTimeRunning(Context context) {
		setPreference(context, PREF_FIRST_TIME, "false");
	}
	
	public static long getLastCleanupTime(Context context) {
		String lastTime = getPreference(context, PREF_LAST_CLEAN_UP_SD);
		if (lastTime == null) {
			long current = System.currentTimeMillis();
			setLastCleanupTime(context,current);
			return current;
		} else {
			return Long.parseLong(lastTime);
		}

	}

	public static void setLastCleanupTime(Context context, long time) {
		setPreference(context, PREF_LAST_CLEAN_UP_SD, String.valueOf(time));
	}

}