package br.com.especializacao.sevira;



import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ValorActivity extends Activity {
	String listaDeProdutos;
	long listaDeQuantidades;
	String listaDeUnidadesDeMedidas;
	private int posicao;	
	EditText valor;
	int index;
	static int  REQUEST_CODE ;
	String listaValor;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_valor);

		//pegar referencia do valor  preço do produto
		valor = (EditText) findViewById(R.id.editValor); 
		Button finalizar = (Button) findViewById(R.id.buttonFinalizar);
		
				
		Intent mainAux = getIntent();
	
		listaDeProdutos = mainAux.getStringExtra("listaDeProdutos2");
		listaDeQuantidades = mainAux.getLongExtra("listaDeQuantidades2",0);
		listaDeUnidadesDeMedidas = mainAux.getStringExtra("listaDeUnidadesDeMedidas2");
		posicao =  mainAux.getIntExtra("posicao",0);
	    listaValor =  mainAux.getStringExtra("listaValor");
	    
		index = mainAux.getIntExtra("index",0);
	
		
	
			
	    finalizar.setOnClickListener(new View.OnClickListener() {	
	        	
				@Override
				public void onClick(View v) {
			
					String valor2 = valor.getText().toString();     
					String posicao2 = String.valueOf(posicao);  
		     	REQUEST_CODE =	posicao;			
	
		    	
	             Intent i = new Intent(v.getContext(), ListaFeitaActivity.class);
	                Bundle params = new Bundle();
	         
	                params.putString("valor2", valor2);
	                params.putString("posicao2", posicao2);
	                i.putExtras(params);
	               startActivity(i); 
	              //  setResult(1,i);
	              //  finish();
		     	
				/*	 Intent main_valor = new Intent(v.getContext(),ListaFeitaActivity.class);

						String valor2 = valor.getText().toString(); 
							
					
						main_valor.putExtra("posicao",posicao);
						main_valor.putExtra("valor2",valor.getText().toString()); 			
						main_valor.putExtra("index", Integer.toString(index));
					
					
						Toast.makeText(getApplicationContext(),"cade posição 2!"+ posicao, Toast.LENGTH_SHORT).show();
            			 Toast.makeText(getApplicationContext(),"cade o valor 3!"+listaValor+"/"+ valor2, Toast.LENGTH_SHORT).show();
							setResult(1,main_valor);
							//startActivity(main_valor);
							finish();*/

					
					
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
