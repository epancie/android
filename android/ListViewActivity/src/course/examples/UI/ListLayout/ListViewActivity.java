package course.examples.UI.ListLayout;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ListViewActivity extends ListActivity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		// this is the List Adapter which has a ArrayAdter as parameter, in this case this
		//taken from a Array in the string Resourses and the last is used to complete a text view in
		// the layout list_item.xml
		setListAdapter(new ArrayAdapter<String>(this, R.layout.list_item,
				getResources().getStringArray(R.array.colors)));

		ListView lv = getListView();
		//This allow activate a filter and display de keyboard to type the filter
		lv.setTextFilterEnabled(true);

		lv.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				
				Toast.makeText(getApplicationContext(),
						((TextView) view).getText(), Toast.LENGTH_SHORT).show();
			}
		});
	}
}