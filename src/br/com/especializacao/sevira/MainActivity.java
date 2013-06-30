package br.com.especializacao.sevira;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Menu;


public class MainActivity extends Activity {


	final int tempoEspera = 3000; // em milisegundos
	public Object mCountDownTimer;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		// Aguardar 3 segundos
	
		
		 mCountDownTimer = new CountDownTimer(tempoEspera, 1000) {

		     public void onTick(long millisUntilFinished) {		    		
		     }

		     public void onFinish() {
		    	
		     // Chamar a tela de compras
		    	 
		    	Intent i = new Intent(MainActivity.this, ComprasActivity.class);
		 	    startActivityForResult(i, 1);	
		 	  
		     }
		  }	.start();
		
	

		
		
	

	}

	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
