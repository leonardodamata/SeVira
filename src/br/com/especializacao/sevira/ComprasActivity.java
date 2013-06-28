package br.com.especializacao.sevira;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class ComprasActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_compras);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void nova(View componente){
		
		// Chamar a tela de lista de itens
   	 
  		Intent i = new Intent(ComprasActivity.this, ListaActivity.class);
	    startActivityForResult(i, 1);	
	}

}

