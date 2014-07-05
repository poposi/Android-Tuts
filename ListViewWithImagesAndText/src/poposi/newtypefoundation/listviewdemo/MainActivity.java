package poposi.newtypefoundation.listviewdemo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import poposi.newtypefoundation.simpletoastmessage.R;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

public class MainActivity extends Activity {

	private Context context;

	private String apps[] = new String[] { "Blogger", "Gmail",
			"Google Analytics", "Google Calendar", "Google Chrome",
			"Google Currents", "Google Drive", "Google Earth",
			"Google Finance", "Google Goggles", "Google Maps",
			"Google Play Books", "Google Play Movies", "Google Play Music",
			"Google Reader", "Google Search", "Google Translate",
			"Google Voice Search", "Google+", "YouTube", "Google Play" };

	private int icons[] = new int[] { R.drawable.ic_blogger,
			R.drawable.ic_mail, R.drawable.ic_google_analytics,
			R.drawable.ic_google_calendar, R.drawable.ic_google_chrome,
			R.drawable.ic_google_currents, R.drawable.ic_google_drive,
			R.drawable.ic_google_earth, R.drawable.ic_google_finance,
			R.drawable.ic_google_goggles, R.drawable.ic_google_maps,
			R.drawable.ic_google_play_books, R.drawable.ic_google_play_movies,
			R.drawable.ic_google_play_music, R.drawable.ic_google_reader,
			R.drawable.ic_google_search, R.drawable.ic_google_translate,
			R.drawable.ic_google_voice_search, R.drawable.ic_google_plus,
			R.drawable.ic_you_tube, R.drawable.ic_google_play };

	private String urls[] = new String[] { "https://www.blogger.com",
			"http://gmail.com", "http://www.google.com/analytics",
			"https://www.google.com/calendar",
			"https://www.google.com/intl/en/chrome",
			"http://www.google.com/producer/currents",
			"https://drive.google.com", "http://www.google.com/earth",
			"https://www.google.com/finance",
			"https://www.google.com/mobile/goggles", "https://maps.google.com",
			"https://play.google.com/intl/en-US_us/about/books",
			"https://play.google.com/intl/en_us/about/movies",
			"https://play.google.com/about/music",
			"http://www.google.com/reader", "https://www.google.com",
			"http://translate.google.com",
			"http://www.google.com/insidesearch/features/voicesearch",
			"https://plus.google.com", "http://www.youtube.com",
			"https://play.google.com/store" };

	private List<HashMap<String, String>> myList;
	private ListView listView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		context = this;

		// each row in the myList stores app name, url and its icon
		myList = new ArrayList<HashMap<String, String>>();

		for (int i = 0; i < apps.length; i++) {
			HashMap<String, String> hm = new HashMap<String, String>();
			hm.put("app", apps[i]);
			hm.put("url", "URL: " + urls[i]);
			hm.put("icon", Integer.toString(icons[i]));
			myList.add(hm);
		}

		// Keys used in Hashmap
		String[] from = { "icon", "app", "url" };

		// Ids of views in listview_layout
		int[] to = { R.id.icon, R.id.app, R.id.url };

		// Instantiating an adapter to store each items
		// R.layout.listview_item defines the layout of each item
		SimpleAdapter adapter = new SimpleAdapter(getBaseContext(), myList,
				R.layout.listview_item, from, to);

		// Getting a reference to listview of main.xml layout file
		listView = (ListView) findViewById(R.id.listview);

		// Setting the adapter to the listView
		listView.setAdapter(adapter);
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				// Adding Toast to show your selection
				Toast.makeText(context, "Your selected " + apps[position],
						Toast.LENGTH_LONG).show();
			}

		});
	}
}
