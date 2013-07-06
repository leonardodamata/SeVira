package br.com.especializacao.sevira;


import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
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
    private int tamanho;
    private String[] listaFinal; 
    private int j;

   
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
		
		
		j = 0;
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
	    listaFinal = new String[listaDeQuantidades2.length];
	    
	    tamanho =  listaDeQuantidades2.length;
		for(int i = 0;i < listaDeProdutos.length;i++)
		{
			if(listaDeQuantidades[i] != 0)
			{
				
				listaDeProdutos2[j] = listaDeProdutos[i];
 				listaDeQuantidades2[j] = listaDeQuantidades[i];
				listaDeUnidadesDeMedidas2[j] = listaDeUnidadesDeMedidas[i];
			 	listaFinal[j] = listaDeProdutos2[j] +" "+listaDeQuantidades2[j] +" "+ listaDeUnidadesDeMedidas2[j]+"s x R$: 0,00"+" = R$ 0,00" ;
				status[j] = false;
			 
			
				j++;
				

			}
			
		}	;
 
		    
	    ListView lViewChekBox = (ListView) findViewById(R.id.listItem);
	    lViewChekBox.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_multiple_choice,  listaFinal) );   
		lViewChekBox.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
		lViewChekBox.setOnItemClickListener(this);

		valor =0 ;
		
		finalizar.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(ListaFeitaActivity.this, MainActivity.class);	 
		 	    startActivityForResult(i, 1);	
		 	  
		    
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
				Intent produtosValor = new Intent(ListaFeitaActivity.this,ValorActivity.class);
				produtosValor.putExtra("listaDeProdutos2",listaDeProdutos2);
				produtosValor.putExtra("listaDeQuantidades2",listaDeQuantidades2);
				produtosValor.putExtra("listaDeUnidadesDeMedidas2",listaDeUnidadesDeMedidas2);
				produtosValor.putExtra("tamanho", tamanho);
				produtosValor.putExtra("posicao",position);
           
			//valor =valor+ Long.parseLong(valorT) ;
			
			status[position] = true;
			

		    startActivityForResult(produtosValor,REQUEST_CODE);

		}
		else
		{
			
			Toast.makeText(getApplicationContext(),"Desmarcando o produto! "+ position, Toast.LENGTH_LONG).show();
					
			SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);
			String strPosicaoMem1 = sharedPreferences.getString("posicao","");
			String strValorMem2 = sharedPreferences.getString("valor","");
			
			Toast.makeText(getApplicationContext(),"Valor! "+ strValorMem2, Toast.LENGTH_LONG).show();
			total = total - listaDeQuantidades2[position];
       		valor= valor - Long.parseLong(strValorMem2) ;
        			
            Toast.makeText(getApplicationContext(),total *  valor+",00", Toast.LENGTH_LONG).show();
        	totalPeso.setText("Total Itens: " + String.valueOf(total));
        	totalValor.setText("Valor Total: R$" + String.valueOf(listaDeQuantidades2[position] *  valor+",00"));
        		
        	listaFinal[position] = listaDeProdutos2[position] +" "+listaDeQuantidades2[position] +" "+ listaDeUnidadesDeMedidas2[position]+"s x R$: 0,00"+" = R$ 0,00" ;
        	status[position] = false; // por  strPosicaoMem1
		
			//	refreshListaList( );
		}
 		
		
   
   }
	
/*	/////@Override
	protected void OnResume(){
		super.onResume();
	refreshListaList();
	}
	
	private void refreshListaList(){
	
		 Toast.makeText(getApplicationContext(),"refreshListaList", Toast.LENGTH_SHORT).show();
	
		valor =valor -1;/// Long.parseLong(valor2);
	
		totalValor.setText("Valor Total: " + String.valueOf(valor));
		
		listaFinal[j] = listaDeProdutos2[j] +" "+listaDeQuantidades2[j] +" "+ listaDeUnidadesDeMedidas2[j]+"s x R$: 0,00"+" = R$ 0,00" ;
		
		
	}
	/*/
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
	    // Check which request we're responding to
	
			   if (resultCode == Activity.RESULT_OK) 
			      { 
			           
			          //  String	posicao = intent.getStringExtra ("posicao"); 
						String valor3 =  intent.getStringExtra("valor2");  

		       			total = total + listaDeQuantidades2[requestCode];
		       			valor +=Long.parseLong(valor3) ;
		        			
		        	
		       			Toast.makeText(getApplicationContext(),String.valueOf(listaDeQuantidades2[requestCode] *  valor+",00"), Toast.LENGTH_LONG).show();
		        		totalPeso.setText("Total Itens: " + String.valueOf(total));
		        		totalValor.setText("Valor Total: R$" + String.valueOf(listaDeQuantidades2[requestCode] *  valor+",00"));
		        		listaFinal[requestCode] = listaDeProdutos2[requestCode] +" "+listaDeQuantidades2[requestCode] +" "+ listaDeUnidadesDeMedidas2[requestCode]+"s x R$: "+valor3+",00 = R$ "+ (listaDeQuantidades2[requestCode] *  Long.parseLong(valor3)+",00");
		        	
		        		SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);
						SharedPreferences.Editor editor = sharedPreferences.edit();
						editor.putString("posicao",String.valueOf(requestCode));
						editor.putString("valor",valor3);
						editor.commit();
		        		
			      }		
	
	
	             if (resultCode == RESULT_CANCELED) {      
	                 Toast.makeText(getApplicationContext(),"Your sim type iss PREEEEE paidddddddddd", Toast.LENGTH_LONG).show();  
	             }   

	}
	
}
