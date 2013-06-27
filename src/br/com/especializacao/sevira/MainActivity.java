package br.com.especializacao.sevira;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.view.Menu;
import android.widget.Toast;

public class MainActivity extends Activity {

	private Runnable mMyRunnable ;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Handler myHandler = new Handler();
		myHandler.postDelayed(mMyRunnable, 3000);
		Toast.makeText(getApplicationContext(), "Teste de 3 segundos", Toast.LENGTH_LONG).show(); 

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
