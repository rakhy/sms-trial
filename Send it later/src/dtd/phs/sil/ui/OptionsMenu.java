package dtd.phs.sil.ui;

import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import dtd.phs.sil.R;
import dtd.phs.sil.utils.Helpers;

public class OptionsMenu {

	private Activity activity;

	public OptionsMenu(Activity activity) {
		this.activity = activity;
	}

	public void createOptionsMenu(Menu menu) {
		MenuInflater inflater = activity.getMenuInflater();
		inflater.inflate(R.menu.main_menu, menu);
	}

	public boolean onItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.menu_preferences:
			Intent i = new Intent(activity, SIL_Preferences.class);
			Helpers.enterActivity(activity, i);
			return true;
		case R.id.menu_share:
			Helpers.share(activity, R.string.Share_subject, R.string.Share_content);
			return true;
/*		case R.id.menu_exit:
			Helpers.launchHomeScreen(activity);
			return true;*/
		default: return false;
		}
	}

}
