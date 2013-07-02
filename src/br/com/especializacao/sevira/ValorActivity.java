package br.com.especializacao.sevira;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ValorActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_valor);

		//pegar referencia do valor  preço do produto
	    final EditText valor = (EditText) findViewById(R.id.editValor); 	
		

		
	    Button finalizar = (Button) findViewById(R.id.buttonFinalizar);		 
	        finalizar.setOnClickListener(new View.OnClickListener() {	
	        	Intent main_valor = new Intent(ValorActivity.this,ListaFeitaActivity.class);
				@Override
				public void onClick(View v) {
				
				
					Toast.makeText(getApplicationContext(), valor.getText().toString(), Toast.LENGTH_SHORT).show();
					
			/*		// TODO Auto-generated method stub
					main2.putExtra("quantidade", valor.getText().toString());
					main2.putExtra("index", Integer.toString(index));
					setResult(1,main2);
					finish();/*/
				}
			});
		
		
		
		
		
		
		
	}
	
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.valor, menu);
		return true;
	}

}
