package br.com.especializacao.sevira;


import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;



public class ListaActivity extends Activity implements OnItemClickListener
{
    private ListView listView;
    private AdapterListView adapterListView;
    private ArrayList<ItemListView> itens;
    
    private String medida;
    
    String[] listaDeUnidadesDeMedidas =   {"Kilo","Litro","Kilo","Kilo","Kilo",
            "Kilo","Kilo","Unidade","Kilo","Kilo","Litro",
            "Unidade","Kilo","Kilo","Pacote","Unidade"}; 
    long[] listaDeQuantidades = new long[16];
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        //carrega o layout onde contem o ListView
        setContentView(R.layout.activity_lista);
 
        //Pega a referencia do ListView
        listView = (ListView) findViewById(R.id.Lista);
        //Define o Listener quando alguem clicar no item.
        listView.setOnItemClickListener(this);
 
        createListView();
    }
 
    private void createListView()
    {
        //Criamos nossa lista que preenchera o ListView
        itens = new ArrayList<ItemListView>();
        ItemListView item1 = new ItemListView("Carne", R.drawable.carne);
        ItemListView item2 = new ItemListView("Leite", R.drawable.leite);
        ItemListView item3 = new ItemListView("Feijão", R.drawable.feijao);
        ItemListView item4 = new ItemListView("Arroz", R.drawable.arroz);
        ItemListView item5 = new ItemListView("Farinha", R.drawable.farinha);
        ItemListView item6 = new ItemListView("Batata", R.drawable.batata);
        ItemListView item7 = new ItemListView("Tomate", R.drawable.tomate);
        ItemListView item8 = new ItemListView("Pão Francês", R.drawable.pao);
        ItemListView item9 = new ItemListView("Café em Pó", R.drawable.cafe);
        ItemListView item10 = new ItemListView("Açúcar", R.drawable.acucar);
        ItemListView item11 = new ItemListView("Óleo", R.drawable.oleo);
        ItemListView item12 = new ItemListView("Manteiga", R.drawable.manteiga);
        ItemListView item13 = new ItemListView("Banana", R.drawable.banana);
        ItemListView item14 = new ItemListView("Maçã", R.drawable.maca);
        ItemListView item15 = new ItemListView("Sal", R.drawable.sal);
        ItemListView item16 = new ItemListView("Alface", R.drawable.alface);

        itens.add(item1);
        itens.add(item2);
        itens.add(item3);
        itens.add(item4);
        itens.add(item5);
        itens.add(item6);
        itens.add(item7);
        itens.add(item8);
        itens.add(item9);
        itens.add(item10);
        itens.add(item11);
        itens.add(item12);
        itens.add(item13);
        itens.add(item14);
        itens.add(item15);
        itens.add(item16);
 
        //Cria o adapter
        adapterListView = new AdapterListView(this, itens);
 
        //Define o Adapter
        listView.setAdapter(adapterListView);
        //Cor quando a lista é selecionada para rolagem.
        listView.setCacheColorHint(Color.TRANSPARENT);
    }
    
 
    public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3)
    {
    	  //Pega o item que foi selecionado.
        ItemListView item = adapterListView.getItem(arg2);
        medida = listaDeUnidadesDeMedidas[arg2];
        
    	//chamando a activity de quantidade e passando a lista 
    	 Intent quantia = new Intent(ListaActivity.this,QuantidadeActivity.class); 	
    	 
    	 quantia.putExtra("listaDeProdutos",item.getTexto());
		 quantia.putExtra("listaDeQuantidades",listaDeQuantidades[arg2]);
		 quantia.putExtra("listaDeUnidadesDeMedidas",listaDeUnidadesDeMedidas[arg2]);
		 quantia.putExtra("index",arg2);
		 
		 startActivityForResult(quantia,1);
		 
		 
		 
		 
		 
      
        
    }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.lista, menu);
		return true;
	}
	
	public class ItemListView
	{
	    private String texto;
	    private int iconeRid;
	 
	    public ItemListView()
	    {
	    }
	 
	    public ItemListView(String texto, int iconeRid)
	    {
	        this.texto = texto;
	        this.iconeRid = iconeRid;
	    }
	 
	    public int getIconeRid()
	    {
	        return iconeRid;
	    }
	 
	    public void setIconeRid(int iconeRid)
	    {
	        this.iconeRid = iconeRid;
	    }
	 
	    public String getTexto()
	    {
	        return texto;
	    }
	 
	    public void setTexto(String texto)
	    {
	        this.texto = texto;
	    }
	}
	
	public class AdapterListView extends BaseAdapter
	{
	    private LayoutInflater mInflater;
	    private ArrayList<ItemListView> itens;
	 
	    public AdapterListView(Context context, ArrayList<ItemListView> itens)
	    {
	        //Itens que preencheram o listview
	        this.itens = itens;
	        //responsavel por pegar o Layout do item.
	        mInflater = LayoutInflater.from(context);
	    }
	 
	    /**
	     * Retorna a quantidade de itens
	     *
	     * @return
	     */
	    public int getCount()
	    {
	        return itens.size();
	    }
	 
	    /**
	     * Retorna o item de acordo com a posicao dele na tela.
	     *
	     * @param position
	     * @return
	     */
	    public ItemListView getItem(int position)
	    {
	        return itens.get(position);
	    }
	 
	    /**
	     * Sem implementação
	     *
	     * @param position
	     * @return
	     */
	    public long getItemId(int position)
	    {
	        return position;
	    }
	 
	    public View getView(int position, View view, ViewGroup parent)
	    {
	        //Pega o item de acordo com a posição.
	        ItemListView item = itens.get(position);
	        //infla o layout para podermos preencher os dados
	        view = mInflater.inflate(R.layout.item_listview, null);
	 
	        //atravez do layout pego pelo LayoutInflater, pegamos cada id relacionado
	        //ao item e definimos as informações.
	        ((TextView) view.findViewById(R.id.text)).setText(item.getTexto());
      		
	        ((ImageView) view.findViewById(R.id.imagemview)).setImageResource(item.getIconeRid());
	 
	        return view;
	    }
	}
	


}
