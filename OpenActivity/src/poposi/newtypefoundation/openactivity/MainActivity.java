package poposi.newtypefoundation.openactivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener {

	private Button btnNextActivity;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.activity_main);

		btnNextActivity = (Button) findViewById(R.id.btn);
		btnNextActivity.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Intent nextActivity = new Intent(MainActivity.this,
				AnotherActivity.class);
		startActivity(nextActivity);
	}

}
