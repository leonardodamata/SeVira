package br.com.especializacao.sevira;



import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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
	
	

		finalizar.setOnClickListener(new View.OnClickListener() {	

			Intent main_valor = new Intent(ValorActivity.this,ListaFeitaActivity.class);	        	
			@Override
			public void onClick(View v) {

				if( valor.getText().toString().length() == 0 ){
					valor.setError( "O valor dos itens é obrigatorio!" );
				}
				else
				{
					String valor2 = valor.getText().toString();    		
					main_valor.putExtra("valor2", valor2); 	


					setResult(1,main_valor);
					finish();
				}
			}
		});
	
		
		
	}
	
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.valor, menu);
		return true;
	}
	
//	 public void onBackPressed() {  
//		   // Não funcionar o botão back;
//		      return;
//		}

}
