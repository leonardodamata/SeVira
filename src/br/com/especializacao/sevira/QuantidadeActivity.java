package br.com.especializacao.sevira;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class QuantidadeActivity extends Activity {
	
	String listaDeProdutos;
	long listaDeQuantidades;
	String listaDeUnidadesDeMedidas;
 

	private EditText valor;
	int index;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_quantidade);
		
		TextView medida = (TextView) findViewById(R.id.textMedida);
		TextView produto = (TextView) findViewById(R.id.textItem);
		valor = (EditText) findViewById(R.id.editQuantidade); 

		Button confirmar = (Button) findViewById(R.id.buttonConfirmar);
		
		Intent mainAux = getIntent();
		
		listaDeProdutos = mainAux.getStringExtra("listaDeProdutos");
		listaDeQuantidades = mainAux.getLongExtra("listaDeQuantidades",0);
		listaDeUnidadesDeMedidas = mainAux.getStringExtra("listaDeUnidadesDeMedidas");
		
		index  = mainAux.getIntExtra("index",0);
		
		medida.setText(listaDeUnidadesDeMedidas);
		produto.setText(listaDeProdutos);
		
		
		confirmar.setOnClickListener(new View.OnClickListener() {
			Intent main2 = new Intent(QuantidadeActivity.this,ListaActivity.class);
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				if( valor.getText().toString().length() == 0 ){
					valor.setError( "A quantidade de itens é obrigatorio!" );
				}
				else
				{
					main2.putExtra("quantidade", valor.getText().toString());
					main2.putExtra("index", Integer.toString(index));
					setResult(1,main2);
					finish();
				}
			}
		});
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.quantidade, menu);
		return true;
	}
	
//	 public void onBackPressed() {  
//		   // Não funcionar o botão back;
//		      return;
//		}
}