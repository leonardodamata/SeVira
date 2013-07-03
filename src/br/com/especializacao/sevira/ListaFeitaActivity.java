package br.com.especializacao.sevira;



 
import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
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
	
	String[] total_geral;
 
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
				listaDeQuantidades2[j] = "Quantidade: "+ listaDeQuantidades[i];
				listaDeUnidadesDeMedidas2[j] = " Medida: "+listaDeUnidadesDeMedidas[i];
				status[j] = false;
				
			//	total_geral[j] = listaDeProdutos2[j] +  listaDeUnidadesDeMedidas2[j] ;
				j++;
				

			}
			
		}	;
 
		// como concatenar dois arrays
		total_geral = listaDeProdutos2 +listaDeUnidadesDeMedidas2;
		
		
		ListView lViewChekBox = (ListView) findViewById(R.id.listItem);
		//descrição do item
	
        lViewChekBox.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_multiple_choice,  total_geral ));   
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
		Toast.makeText(getApplicationContext(), "teste", Toast.LENGTH_SHORT).show();
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
