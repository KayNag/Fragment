package kay.fragments;

import java.util.Arrays;

import com.lucky.fragmentexample.R;

import kay.fragment.fragments.Gridview;
import kay.fragment.fragments.Lister;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends FragmentActivity {
	Gridview f2;
	Button check;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		DisplayMetrics metrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(metrics);
		int widthPixels = metrics.widthPixels;
		int heightPixels = metrics.heightPixels;
		float scaleFactor = metrics.density;
		float widthDp = widthPixels / scaleFactor;
		float heightDp = heightPixels / scaleFactor;
		float smallestWidth = Math.min(widthDp, heightDp);

		if (smallestWidth > 720) {
			// Device is a 10" tablet
		} else if (smallestWidth > 600) {
			// Device is a 7" tablet
		}
		float widthDpi = metrics.xdpi;
		float heightDpi = metrics.ydpi;
		float widthInches = widthPixels / widthDpi;
		float heightInches = heightPixels / heightDpi;

		double diagonalInches = Math.sqrt((widthInches * widthInches)
				+ (heightInches * heightInches));
		setContentView(R.layout.activitymain);

		f2 = new Gridview();

		Lister f1 = new Lister();

		FragmentTransaction transaction = getSupportFragmentManager()
				.beginTransaction();
		transaction.add(R.id.fragment_first, f1);
		transaction.add(R.id.fragment_second, f2);
		transaction.commit();

	}

	public void onSelectFragment(View view) {

		if (view == findViewById(R.id.button1)) {
			f2.change();

		} else if (view == findViewById(R.id.button2)) {

			f2.change();

		} else if (view == findViewById(R.id.Button01)) {

			f2.change();

		} else if (view == findViewById(R.id.Button02)) {

			f2.change();

		} else if (view == findViewById(R.id.Button03)) {

			f2.change();

		} else if (view == findViewById(R.id.Button04)) {
			f2.change();

		} else if (view == findViewById(R.id.Button05)) {
			f2.change();

		}

	}
}
