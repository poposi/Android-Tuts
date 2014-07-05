package poposi.newtypefoundation.listviewdemo;

import poposi.newtypefoundation.simpletoastmessage.R;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListView;

public class MainActivity extends Activity {

	// Declaring array to store a set of Android version
	private String[] versions = new String[] { "Froyo", "Gingerbread",
			"Honeycomb 3.2", "Ice Cream Sandwich 4.0.3",
			"Ice Cream Sandwich 4.0.4", "Jelly Bean 4.1.x", "Jelly Bean 4.2.x",
			"Jelly Bean 4.3.x", "KitKat" };

	// Declaring an ArrayAdapter to store an array
	private ArrayAdapter<String> adapter;

	// Declaring ListView to display records
	private ListView listview;

	// Declaring check/uncheck all checkbox
	private CheckBox chkAll;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_main);

		// ArrayAdapter is used to store an array of arbitrary objects
		// The checkbox for the each item is specified by the layout
		// android.R.layout.simple_list_item_multiple_choice

		adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_multiple_choice, versions);
		listview = (ListView) findViewById(R.id.listview);

		// ArrayAdapter indirectly implements ListAdapter interface
		listview.setAdapter(adapter);

		// setting the ItemClickEvent listener for the listview
		listview.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View view,
					int position, long id) {
				// TODO Auto-generated method stub

				CheckBox chk = (CheckBox) findViewById(R.id.chkAll);
				int checkedItemCount = getCheckedItemCount();

				if (listview.getCount() == checkedItemCount)
					chk.setChecked(true);
				else
					chk.setChecked(false);
			}

		});

		// Getting reference to checkbox available in the main.xml layout
		chkAll = (CheckBox) findViewById(R.id.chkAll);
		// Setting a click listener for the checkbox
		chkAll.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				CheckBox chk = (CheckBox) v;
				int itemCount = listview.getCount();
				for (int i = 0; i < itemCount; i++) {
					listview.setItemChecked(i, chk.isChecked());
				}
			}

		});
	}

	/**
	 * Returns the number of checked items
	 */
	private int getCheckedItemCount() {
		int cnt = 0;
		SparseBooleanArray positions = listview.getCheckedItemPositions();
		int itemCount = listview.getCount();

		for (int i = 0; i < itemCount; i++) {
			if (positions.get(i))
				cnt++;
		}
		return cnt;
	}
}
