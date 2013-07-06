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
	String listaDeProdutos;
	long listaDeQuantidades;
	String listaDeUnidadesDeMedidas;	
	EditText valor;
	int index2;
	static int  REQUEST_CODE ;
	String listaValor;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_valor);

		//pegar referencia do valor  preço do produto
		valor = (EditText) findViewById(R.id.editValor); 
		Button finalizar = (Button) findViewById(R.id.buttonFinalizar);
				
//		Intent mainAux = getIntent();
//	
//		listaDeProdutos = mainAux.getStringExtra("listaDeProdutos2");
//		listaDeQuantidades = mainAux.getLongExtra("listaDeQuantidades2",0);
//		listaDeUnidadesDeMedidas = mainAux.getStringExtra("listaDeUnidadesDeMedidas2");
//		posicao =  mainAux.getIntExtra("posicao",0);
//	    listaValor =  mainAux.getStringExtra("listaValor");
//	    
//		index = mainAux.getIntExtra("index",0);
		
	
			
	    finalizar.setOnClickListener(new View.OnClickListener() {	

	     		Intent main_valor = new Intent(ValorActivity.this,ListaFeitaActivity.class);	        	
				@Override
				public void onClick(View v) {
			
				String valor2 = valor.getText().toString();    
				//main_valor.putExtra("index", index2);
				main_valor.putExtra("valor2", valor2); 			
				//Toast.makeText(getApplicationContext(),String.valueOf(index2), Toast.LENGTH_LONG).show();		
				setResult(1,main_valor);
				finish();
				}
			});
		
		
//		confirmar.setOnClickListener(new View.OnClickListener() {
//			Intent main2 = new Intent(QuantidadeActivity.this,ListaActivity.class);
//			@Override
//			public void onClick(View v) {
//				// TODO Auto-generated method stub
//				main2.putExtra("quantidade", valor.getText().toString());
//				main2.putExtra("index", Integer.toString(index));
//				setResult(1,main2);
//				finish();
//			}	
		
		
		
		
	}
	
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.valor, menu);
		return true;
	}
	
	 public void onBackPressed() {  
		   // Não funcionar o botão back;
		      return;
		}

}
