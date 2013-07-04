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
	String posicao;	
	EditText valor;
	int index;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_valor);

		//pegar referencia do valor  preço do produto
		//TextView medida = (TextView) findViewById(R.id.textMedida);
		//TextView produto = (TextView) findViewById(R.id.textItem);
		valor = (EditText) findViewById(R.id.editValor); 
		Button finalizar = (Button) findViewById(R.id.buttonFinalizar);
		
		Intent mainAux = getIntent();
		
		listaDeProdutos = mainAux.getStringExtra("listaDeProdutos2");
		listaDeQuantidades = mainAux.getLongExtra("listaDeQuantidades2",0);
		listaDeUnidadesDeMedidas = mainAux.getStringExtra("listaDeUnidadesDeMedidas2");
		posicao =  mainAux.getStringExtra("posicao");
		index = mainAux.getIntExtra("index",0);
		
			 
	    finalizar.setOnClickListener(new View.OnClickListener() {	
	        	
				@Override
				public void onClick(View v) {
			
					// TODO Auto-generated method stub
				Intent main_valor = new Intent(ValorActivity.this,ListaFeitaActivity.class);
					
				String mensagem = valor.getText().toString(); 
					
					main_valor.putExtra("valor", mensagem);
					main_valor.putExtra("index", Integer.toString(index));
					Toast.makeText(getApplicationContext(), "1/"+mensagem, Toast.LENGTH_LONG).show();
					setResult(RESULT_OK,main_valor);
					// startActivity(main_valor);
					finish();
					
					
					
					
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
