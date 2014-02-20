package kay.fragment.helpers;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.lucky.fragmentexample.R;

public class ExampleDialogFragment extends DialogFragment {

	private TextView dialogtext;

	public static ExampleDialogFragment newInstance() {
		ExampleDialogFragment frag = new ExampleDialogFragment();
		return frag;
	}

	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
				getActivity());

		View view = getActivity().getLayoutInflater().inflate(R.layout.dialofg,
				null);

		dialogtext = (TextView) view.findViewById(R.id.dialogtext);

		alertDialogBuilder.setView(view);
		alertDialogBuilder.setTitle(getString(R.string.dialogtitle));
		alertDialogBuilder.setPositiveButton(getString(R.string.ok),
				new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						Toast.makeText(getActivity(), getString(R.string.ok),
								Toast.LENGTH_SHORT).show();
						dialog.dismiss();
					}
				});
		alertDialogBuilder.setNegativeButton(getString(R.string.cancel),
				new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						Toast.makeText(getActivity(),
								getString(R.string.cancel), Toast.LENGTH_SHORT)
								.show();
						dialog.cancel();
					}
				});

		return alertDialogBuilder.create();
	}

}
