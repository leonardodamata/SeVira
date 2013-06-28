package br.com.especializacao.sevira;


import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.ImageView;
import android.widget.Toast;



public class ListaActivity extends Activity implements OnItemClickListener
{
    private ListView listView;
    private AdapterListView adapterListView;
    private ArrayList<ItemListView> itens;
 
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
        ItemListView item1 = new ItemListView("Guilherme Biff", R.drawable.biff);
        ItemListView item2 = new ItemListView("Lucas Volgarini", R.drawable.volgarini);
        ItemListView item3 = new ItemListView("Eduardo Ricoldi", R.drawable.ricoldi);
        ItemListView item4 = new ItemListView("Felipe Panngo", R.drawable.panngo);
 
        itens.add(item1);
        itens.add(item2);
        itens.add(item3);
        itens.add(item4);
 
        //Cria o adapter
        adapterListView = new AdapterListView(this, itens);
 
        //Define o Adapter
        listView.setAdapter(adapterListView);
        //Cor quando a lista é selecionada para ralagem.
        listView.setCacheColorHint(Color.TRANSPARENT);
    }
 
    public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3)
    {
        //Pega o item que foi selecionado.
        ItemListView item = adapterListView.getItem(arg2);
        //Demostração
        Toast.makeText(this, "Você Clicou em: " + item.getTexto(), Toast.LENGTH_LONG).show();
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
