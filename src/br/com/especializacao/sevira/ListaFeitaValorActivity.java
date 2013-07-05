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


public class ListaFeitaValorActivity extends Activity implements OnItemClickListener {
	private String[] listaDeProdutos2;
	private long[] listaDeQuantidades2;
	long[] listaDeValor2;
	private String[] listaDeUnidadesDeMedidas2;
	double[] listaDeValorIndividual2;
	private long total = 0;
	private long valor = 0;
	private TextView totalPeso;
	private TextView totalValor;
	private boolean[] status;   
	String valorT;
    int index;
    static int  REQUEST_CODE ;
    private String[] listaValor2;
    private int tamanho;

   
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_lista_feita_valor);
		
	 
		totalPeso = (TextView) findViewById(R.id.textPeso);
		totalValor = (TextView) findViewById(R.id.textValor);
		Button finalizar = (Button) findViewById(R.id.buttonFinalizar);		
		
		Intent mainAux = getIntent();
		
		String[] listaDeProdutos = mainAux.getStringArrayExtra("listaDeProdutos");
		long[] listaDeQuantidades = mainAux.getLongArrayExtra("listaDeQuantidades");
		String[] listaDeUnidadesDeMedidas = mainAux.getStringArrayExtra("listaDeUnidadesDeMedidas");
		long[] listaDeValor = mainAux.getLongArrayExtra("valor2");
		
		
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
		listaValor2 = new String[j];
		status = new boolean[j];
		j = 0;
	    String[] listaFinal = new String[listaDeQuantidades2.length];
	    
	    tamanho =  listaDeQuantidades2.length;
		for(int i = 0;i < listaDeProdutos.length;i++)
		{
			if(listaDeQuantidades[i] != 0)
			{
				
				listaDeProdutos2[j] = listaDeProdutos[i];
				listaDeQuantidades2[j] = listaDeQuantidades[i];
				listaValor2[j] = listaValor2[i];
				listaDeUnidadesDeMedidas2[j] = listaDeUnidadesDeMedidas[i];
			 	listaFinal[j] = listaDeProdutos2[j] +" "+listaDeQuantidades2[j] +" "+ listaDeUnidadesDeMedidas2[j]+"s x R$:" + listaValor2[j]+" = R$ 0,00" ;
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
	
	if(status[position] == false)
		{
	      REQUEST_CODE = position;
				Intent produtosValor = new Intent(view.getContext(),ValorActivity.class);
				produtosValor.putExtra("listaDeProdutos2",listaDeProdutos2);
				produtosValor.putExtra("listaDeQuantidades2",listaDeQuantidades2);
				produtosValor.putExtra("listaDeUnidadesDeMedidas2",listaDeUnidadesDeMedidas2);
				produtosValor.putExtra("listaValor",listaValor2);
				produtosValor.putExtra("tamanho", tamanho);
				produtosValor.putExtra("posicao",position);
           
			//valor =valor+ Long.parseLong(valorT) ;
			valor +=3 ;
			status[position] = true;
		   	
			 Toast.makeText(getApplicationContext(),"LostaValor!"+ position, Toast.LENGTH_LONG).show();
			 Toast.makeText(getApplicationContext(),"cade a posição 01!"+ position, Toast.LENGTH_LONG).show();
			// startActivity(produtosValor);
		 startActivityForResult(produtosValor, REQUEST_CODE);
		}
		else
		{
			 Toast.makeText(getApplicationContext(),"Desmancando o produto!", Toast.LENGTH_LONG).show();
			 valor -= 1;
				status[position] = false;
		}
 		
		totalPeso.setText("Total: " + String.valueOf(total));
		totalValor.setText("Total: " + String.valueOf(valor));
		

    	// mandar aguardar o retorno de ma activy
  /*      Intent mainValorAux = getIntent();
       
        valorT = mainValorAux.getStringExtra("valor");
		index = mainValorAux.getIntExtra("index",0);
		Toast.makeText(getApplicationContext(),"4/"+valorT, Toast.LENGTH_LONG).show();
		if(status[position] == false)
		{
			total = total + listaDeQuantidades2[position];
			//valor =valor+ Long.parseLong(valorT) ;
			valor +=3 ;
			status[position] = true;
			  startActivityForResult(produtosValor, REQUEST_CODE);
		}
		else
		{
			total = total - listaDeQuantidades2[position];
			//valor =valor - Long.parseLong(valorT);
			valor -= 1;
			status[position] = false;
		}
		totalPeso.setText("Total: " + String.valueOf(total));
		totalValor.setText("Valor Total: " + String.valueOf(valor));
		
		*/
   }
	
	
	
}
