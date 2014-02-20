package kay.fragment.fragments;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.lucky.fragmentexample.R;

public class Lister extends Fragment {
	Button sort;
	SimpleAdapter adapter;
	ListView listView;
	List<HashMap<String, String>> aList;
	String[] from = { "flag", "txt", "cur" };
	int[] to = { R.id.flag, R.id.txt, R.id.cur };
	View view;
	public boolean isClickedFirstTime = true;
	// Array of strings storing country names
	String[] names = new String[] { "John Doewater", "Lisa Doe Water",
			"Family savings", "House loan",

	};

	// Array.sort(names);

	// Array of integers points to images stored in /res/drawable/
	int[] flags = new int[] { R.drawable.list, R.drawable.list,
			R.drawable.list2, R.drawable.list3,

	};

	// Array of strings to store currencies
	String[] currency = new String[] { "FI4000600", "FI5000600", "FI4100600",
			"FI4800600"

	};

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.listview, container, false);
		sort = (Button) view.findViewById(R.id.sort);

		array();
		adapter();

		sort.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				if (isClickedFirstTime == true) {
					Collections.sort(aList, new Sort("txt"));
					adapter();
					isClickedFirstTime = false;
				} else {

					array();
					adapter();

					isClickedFirstTime = true;
				}

			}
		});

		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1,
					int position, long id) {
				Toast.makeText(getActivity(),
						"Click ListItem Number " + position, Toast.LENGTH_SHORT)
						.show();

			}
		});

		return view;

	}

	private void array() {
		// Each row in the list stores country name, currency and flag
		aList = new ArrayList<HashMap<String, String>>();

		for (int i = 0; i < names.length; i++) {
			HashMap<String, String> hm = new HashMap<String, String>();
			hm.put("txt", "Name : " + names[i]);
			hm.put("cur", "Ref : " + currency[i]);
			hm.put("flag", Integer.toString(flags[i]));
			aList.add(hm);
		}

	}

	private void adapter() {

		adapter = new SimpleAdapter(getActivity().getBaseContext(), aList,
				R.layout.listviewdetails, from, to);
		listView = (ListView) view.findViewById(R.id.list);
		listView.setAdapter(adapter);

	}

}
