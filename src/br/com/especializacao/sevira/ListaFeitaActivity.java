package br.com.especializacao.sevira;



import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;


public class ListaFeitaActivity extends Activity implements OnItemClickListener {
	String[] listaDeProdutos2;
	long[] listaDeQuantidades2;
	String[] listaDeUnidadesDeMedidas2;
	long total = 0;
	TextView totalPeso;
	boolean[] status;
	
	 
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_lista_feita);
		
		totalPeso = (TextView) findViewById(R.id.textItem);
		Button finalizar = (Button) findViewById(R.id.buttonFinalizar);		
		
		Intent mainAux = getIntent();
		
		String[] listaDeProdutos = mainAux.getStringArrayExtra("listaDeProdutos");
		long[] listaDeQuantidades = mainAux.getLongArrayExtra("listaDeQuantidades");
		String[] listaDeUnidadesDeMedidas = mainAux.getStringArrayExtra("listaDeUnidadesDeMedidas");
		int j = 0;
		for(int i = 0;i < listaDeProdutos.length;i++)
		{
			if(listaDeQuantidades[i] != 0)
			{
				j++;
			}
		}
		listaDeProdutos2 = new String[j];
		listaDeQuantidades2 = new long[j];
		listaDeUnidadesDeMedidas2 = new String[j];
		status = new boolean[j];
		j = 0;
		for(int i = 0;i < listaDeProdutos.length;i++)
		{
			if(listaDeQuantidades[i] != 0)
			{
				listaDeProdutos2[j] = listaDeProdutos[i];
				listaDeQuantidades2[j] = listaDeQuantidades[i];
				listaDeUnidadesDeMedidas2[j] = listaDeUnidadesDeMedidas[i];
				status[j] = false;
				j++;
			}
		}		
		
	
	
		ListView lViewChekBox = (ListView) findViewById(R.id.listItem);
		//descrição do item
		
	lViewChekBox.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_multiple_choice, listaDeProdutos2));
		
		
       
		lViewChekBox.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
		lViewChekBox.setOnItemClickListener(this);
		
		finalizar.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.lista, menu);
		return true;
	}

	@Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		
		 // Chamar a tela de compras
   	 
    	Intent i = new Intent(ListaFeitaActivity.this, ValorActivity.class);
 	    startActivityForResult(i, 1);	
		
	/*	if(status[position] == false)
		{
			total = total + listaDeQuantidades2[position];
			status[position] = true;
		}
		else
		{
			total = total - listaDeQuantidades2[position];
			status[position] = false;
		}
		totalPeso.setText("Total: " + String.valueOf(total));
		
		Toast.makeText(getApplicationContext(), totalPeso.getText().toString(), Toast.LENGTH_SHORT).show();*/
   }
	
}
