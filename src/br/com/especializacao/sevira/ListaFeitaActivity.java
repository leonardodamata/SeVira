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
import android.widget.Toast;


public class ListaFeitaActivity extends Activity implements OnItemClickListener {
	String[] listaDeProdutos2;
	long[] listaDeQuantidades2;
	String[] listaDeUnidadesDeMedidas2;
	double[] listaDeValorIndividual2;
	long total = 0;
	long valor = 0;
	TextView totalPeso;
	TextView totalValor;
	boolean[] status;   
    String valorT;
    int index;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_lista_feita);
		
	 
		totalPeso = (TextView) findViewById(R.id.textPeso);
		totalValor = (TextView) findViewById(R.id.textValor);
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
	    String[] listaFinal = new String[listaDeQuantidades2.length];
		for(int i = 0;i < listaDeProdutos.length;i++)
		{
			if(listaDeQuantidades[i] != 0)
			{
				
				listaDeProdutos2[j] = listaDeProdutos[i];
				listaDeQuantidades2[j] = listaDeQuantidades[i];;
				listaDeUnidadesDeMedidas2[j] = listaDeUnidadesDeMedidas[i];
			 	listaFinal[j] = listaDeProdutos2[j] +" "+listaDeQuantidades2[j] +" "+ listaDeUnidadesDeMedidas2[j]+"s x R$: 0,00"+" = R$ 0,00" ;
				status[j] = false;
			 
			
				j++;
				

			}
			
		}	;
 
		    
	    ListView lViewChekBox = (ListView) findViewById(R.id.listItem);
	    lViewChekBox.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_multiple_choice,  listaFinal) ); 
     //  lViewChekBox.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_multiple_choice,  listaDeProdutos2) );
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
	
		//// Chamar a activity tela de compras
	
		Intent produtosValor = new Intent(ListaFeitaActivity.this,ValorActivity.class);
		produtosValor.putExtra("listaDeProdutos2",listaDeProdutos2);
		produtosValor.putExtra("listaDeQuantidades2",listaDeQuantidades2);
		produtosValor.putExtra("listaDeUnidadesDeMedidas2",listaDeUnidadesDeMedidas2);
    	startActivity(produtosValor);
    	
    	// mandar aguardar o retorno de ma activy
    	Intent mainValorAux = getIntent();
       
        valorT = mainValorAux.getStringExtra("valor");
		index = mainValorAux.getIntExtra("index",0);
	
		if(status[position] == false)
		{
			total = total + listaDeQuantidades2[position];
			//valor =valor+ Long.parseLong(valorT) ;
			valor =valor+3 ;
			status[position] = true;
		}
		else
		{
			total = total - listaDeQuantidades2[position];
			//valor =valor - Long.parseLong(valorT);
			valor =valor - 1;
			status[position] = false;
		}
		totalPeso.setText("Total: " + String.valueOf(total));
		totalValor.setText("Valor Total: " + String.valueOf(valor));
		
		Toast.makeText(getApplicationContext(),valorT+"/"+ totalPeso.getText().toString(), Toast.LENGTH_SHORT).show();
   }
	
}
