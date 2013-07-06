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
	private String[] listaDeProdutos2;
	private long[] listaDeQuantidades2;
	private long[] listaDeValor2;
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
    private int posicao;
    private long auxValor;
    private boolean status2[];
    private ListView lViewChekBox;
    private long[] listaDeQuantidades;
    private String[] listaDeProdutos;
    private String[] listaDeUnidadesDeMedidas;
    

   
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_lista_feita);
		
	 
		totalPeso = (TextView) findViewById(R.id.textPeso);
		totalValor = (TextView) findViewById(R.id.textValor);
		Button finalizar = (Button) findViewById(R.id.buttonFinalizar);		
		
		Intent mainAux = getIntent();
		
		listaDeProdutos = mainAux.getStringArrayExtra("listaDeProdutos");
		listaDeQuantidades = mainAux.getLongArrayExtra("listaDeQuantidades");
		listaDeUnidadesDeMedidas = mainAux.getStringArrayExtra("listaDeUnidadesDeMedidas");
		
		
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
		listaDeValor2 = new long[j];
		status = new boolean[j];
		status2 = new boolean[j];
		j = 0;
	    listaFinal = new String[listaDeQuantidades2.length];
	    
	  //  tamanho =  listaDeQuantidades2.length;
		for(int i = 0;i < listaDeProdutos.length;i++)
		{
			if(listaDeQuantidades[i] != 0)
			{
				
				listaDeProdutos2[j] = listaDeProdutos[i];
 				listaDeQuantidades2[j] = listaDeQuantidades[i];
				listaDeUnidadesDeMedidas2[j] = listaDeUnidadesDeMedidas[i];
			 	listaFinal[j] = listaDeProdutos2[j] +" "+listaDeQuantidades2[j] +" "+ listaDeUnidadesDeMedidas2[j]+"s R$ " + String.valueOf(listaDeValor2[j]) + ",00" ;
				listaDeValor2[j] = 0;
				status[j] = false;
				j++;
				

			}
			
		}	;
 
		    
	    lViewChekBox = (ListView) findViewById(R.id.listItem);
	    lViewChekBox.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_multiple_choice,  listaFinal) );   
		lViewChekBox.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
		lViewChekBox.setOnItemClickListener(this);

		
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
			Intent produtosValor = new Intent(ListaFeitaActivity.this,ValorActivity.class);
			produtosValor.putExtra("listaDeProdutos2",listaDeProdutos2);
			produtosValor.putExtra("listaDeQuantidades2",listaDeQuantidades2);
			produtosValor.putExtra("listaDeUnidadesDeMedidas2",listaDeUnidadesDeMedidas2);
			produtosValor.putExtra("tamanho", tamanho);
			posicao = position;
			startActivityForResult(produtosValor,1);
		}
		else
		{
			valor = valor - listaDeValor2[position];
			listaDeValor2[position] = 0;
			status[position] = false; 
			status2[position] = true;
			posicao = position;
			totalValor.setText("Valor Total: R$" + String.valueOf(valor+",00"));				    
   			
		}
   
   }
	

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
	    // Check which request we're responding to
	
    

		       			total = total + listaDeQuantidades2[posicao];
		       			//long quantidade = Long.parseLong(data.getExtras().getString("quantidade"));
		       			auxValor = Long.parseLong(intent.getExtras().getString("valor2"));
		       			//int index = Integer.parseInt(intent.getExtras().getString("index"));
		       			listaDeValor2[posicao] = auxValor;
		       			valor = valor + auxValor;
		       			status[posicao] = true;		    
		       			status2[posicao] = true;	
		       			totalValor.setText("Valor Total: R$" + String.valueOf(valor+",00"));
		       			
		       			//Toast.makeText(getApplicationContext(),String.valueOf(auxValor), Toast.LENGTH_LONG).show();
		        		//totalPeso.setText("Total Itens: " + String.valueOf(total));
		        		//listaFinal[requestCode] = listaDeProdutos2[requestCode] +" "+listaDeQuantidades2[requestCode] +" "+ listaDeUnidadesDeMedidas2[requestCode]+"s";
		        	

		 
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		
		Toast.makeText(getApplicationContext(),String.valueOf(posicao), Toast.LENGTH_LONG).show();
	
		if(status2[posicao] = true){


			listaFinal[posicao] = listaDeProdutos2[posicao] +" "+listaDeQuantidades2[posicao] +" "+ listaDeUnidadesDeMedidas2[posicao]+"s R$ " + String.valueOf(listaDeValor2[posicao]) + ",00" ;
			status2[posicao] = true;
		}
		else
		{

			listaDeValor2[posicao] = 0;
			listaFinal[posicao] = listaDeProdutos2[posicao] +" "+listaDeQuantidades2[posicao] +" "+ listaDeUnidadesDeMedidas2[posicao]+"s R$ " + String.valueOf(listaDeValor2[posicao]) + ",00" ;

			status2[posicao] = false;
		}

	}
	
//	
//	 public void onBackPressed() {  
//		   // Não funcionar o botão back;
//		      return;
//		}
	
	
}
