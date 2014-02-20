package kay.fragment.fragments;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import kay.fragment.helpers.ExampleDialogFragment;
import kay.fragment.helpers.Network;
import kay.fragments.MainActivity;

import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.lucky.fragmentexample.R;

public class Gridview extends Fragment {
	Button json, check;
	View view;
	Boolean active = false;
	// Array of strings storing country names

	public String[] names = new String[] { "Mark", "Darla",
			"Watten", "car loan", "Klim", "Charlie", "Carlz",
			"Finland", };
	// Array of integers points to images stored in /res/drawable-ldpi/
	int[] flags = new int[] { R.drawable.catdog, R.drawable.asko,
			R.drawable.cat, R.drawable.chennai,
			R.drawable.cockpit, R.drawable.dubai,
			R.drawable.finland, R.drawable.heli,

	};

	// Keys used in Hashmap
	String[] from = { "flag", "gridtxt" };

	// Ids of views in listview_layout
	int[] to = { R.id.flag, R.id.gridtxt };
	SimpleAdapter adapter;
	GridView gridView;
	List<HashMap<String, String>> aList;
	StatusLine status;

	@Override
	public View onCreateView(LayoutInflater inflater,
			final ViewGroup container, Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.gridview, container, false);

		json = (Button) view.findViewById(R.id.json);

		// Each row in the list stores country name, currency and flag

		mapping();
		Network net = new Network();

		if (net.isOnline(getActivity()) != false) {

			try {

				HttpGet request = new HttpGet(
						"https://api.echo.nasa.gov/echo-rest/");

				HttpClient client = new DefaultHttpClient();

				// execute the request
				HttpResponse response = client.execute(request);

				 status = response.getStatusLine();
				

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {
			Toast.makeText(getActivity(),
					"Please,Connect to Internet", Toast.LENGTH_LONG)
					.show();
		}

		json.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				if (status.getStatusCode() == 200) {
					showDialog();

				} else {
					Toast.makeText(getActivity(),
							"Failed to fetch json", Toast.LENGTH_LONG)
							.show();
				}

			}
		});
		return view;

	}

	private void mapping() {
		aList = new ArrayList<HashMap<String, String>>();
		for (int i = 0; i < 8; i++) {
			HashMap<String, String> hm = new HashMap<String, String>();
			if (active) {

				hm.put("gridtxt", names[i].toUpperCase());

			} else {
				hm.put("gridtxt", names[i]);
			}
			hm.put("flag", Integer.toString(flags[i]));
			aList.add(hm);
			// Instantiating an adapter to store each items
			// R.layout.listview_layout defines the layout of each item

			adapter = new SimpleAdapter(getActivity(), aList,
					R.layout.gridviewdetails, from, to);

			// Getting a reference to gridview of Main
			gridView = (GridView) view.findViewById(R.id.gridView);

			// Setting an adapter containing images to the gridview
			gridView.setAdapter(adapter);

		}

	}

	public void change() {
		if (active) {
			active = false;
		} else {
			active = true;
		}
		FragmentManager manager = getActivity().getSupportFragmentManager();
		Activity activity = getActivity();
		mapping();

	}

	private void showDialog() {
		DialogFragment newFragment = ExampleDialogFragment.newInstance();
		newFragment.show(getFragmentManager(), "dialog");
	}

}