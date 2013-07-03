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
	TextView totalPeso;
	boolean[] status;
	
	String[] totalFinal;
	
 
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
				listaDeProdutos2[j] = "Item: "+listaDeProdutos[i];
				//listaDeQuantidades2[j] = "Quantidade: "+  listaDeQuantidades[i].toString();
				listaDeUnidadesDeMedidas2[j] = " Medida: "+listaDeUnidadesDeMedidas[i];
				status[j] = false;
			 
				//totalFinal = listaDeProdutos2[j].append(listaDeUnidadesDeMedidas2[j]);
				j++;
				

			}
			
		}	;
 
		// como concatenar dois arrays
		 StringBuilder stb = new StringBuilder();
		stb.append(listaDeProdutos2);
		stb.append(" ");
		stb.append(listaDeUnidadesDeMedidas2);
	   
		//String[] lines = stb.toString().split(" ");
	///	for(String s: lines){
		//    System.out.println("Content = " + s);
		 //   System.out.println("Length = " + s.length());
	//	}
	    
	        ListView lViewChekBox = (ListView) findViewById(R.id.listItem);
		//descrição do item
	     //   lViewChekBox.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_multiple_choice,  listaDeProdutos2) ); 
       lViewChekBox.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_multiple_choice,  listaDeProdutos2) );
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
	
	/*public String[] append(String[] a1, String[] a2) {
		String[] a1a2 = Arrays.copyOf(a1, a1.length  + a2.length);
	    for (int i = a1.length; i < a1a2.length; i++) {
	        a1a2[i] = a1[i] + a2[i];
	    }  
	    return a1a2;
	}
	
   public String[] concat(String[] A, String[] B) {
		  int aLen = A.length;
		  int bLen = B.length;
		  String[] C= new String[aLen+bLen];
		  System.arraycopy(A, 0, C, 0, aLen);
		  System.arraycopy(B, 0, C, aLen, bLen);
		  return C;
		}
	
	 public String[] generalConcatAll(String[]... jobs) {
	        int len = 0;
	        for (final String[] job : jobs) {
	            len += job.length;
	        }

	        final String[] result = new String[len];

	        int currentPos = 0;
	        for (final String[] job : jobs) {
	            System.arraycopy(job, 0, result, currentPos, job.length);
	            currentPos += job.length;
	        }

	        return result;
	    }
 
	public static String[] join(String [] ... parms) {
	    // calculate size of target array
	    int size = 0;
	    for (String[] array : parms) {
	      size += array.length;
	    }

	    String[] result = new String[size];
	    
	    int j = 0;
	    for (String[] array : parms) {
	      for (String s : array) {
	        result[j++] = s;
	      }
	    }
	    return result;
	  }/*/
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.lista, menu);
		return true;
	}

	@Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		
		 // Chamar a tela de compras
		Toast.makeText(getApplicationContext(), totalPeso.getText().toString(), Toast.LENGTH_SHORT).show();
    	//--Intent i = new Intent(ListaFeitaActivity.this, ValorActivity.class);
 	    //--startActivityForResult(i, 1);	
		
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
