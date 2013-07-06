package br.com.especializacao.sevira;

import java.util.Calendar;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;

public class AlarmeActivity extends Activity {

	private DatePicker dp;
	private TimePicker tp;
	private int dia;
	private int mes;
	private int ano;
	private int hora;
	private int minuto;
	
	PendingIntent pendingIntent1;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_alarme);
				
		Button lembrete = (Button) findViewById(R.id.button1);
		
		
		
		lembrete.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				dp = (DatePicker) findViewById(R.id.datePicker1);
				tp = (TimePicker) findViewById(R.id.timePicker1);
				dia = dp.getDayOfMonth();
				mes = dp.getMonth();
				ano = dp.getYear();
				hora = tp.getCurrentHour();
				minuto = tp.getCurrentMinute();
				aciona();
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	private void aciona() {

		Intent mainAux = getIntent();		
		Intent myIntent1 = new Intent(AlarmeActivity.this, ListaFeitaActivity.class);
	    myIntent1.putExtra("listaDeProdutos",mainAux.getStringArrayExtra("listaDeProdutos"));
	    myIntent1.putExtra("listaDeQuantidades",mainAux.getLongArrayExtra("listaDeQuantidades"));
	    myIntent1.putExtra("listaDeUnidadesDeMedidas",mainAux.getStringArrayExtra("listaDeUnidadesDeMedidas"));	    
	    pendingIntent1 = PendingIntent.getActivity(this, 0, myIntent1, 0);
	    AlarmManager alarmManager1 = (AlarmManager)getSystemService(ALARM_SERVICE);
	    Calendar calendar1 = Calendar.getInstance();
	    calendar1.set(ano,mes,dia,hora,minuto,0);
	    alarmManager1.set(AlarmManager.RTC, calendar1.getTimeInMillis(), pendingIntent1);
	    finish();
	}
	
//	 public void onBackPressed() {  
//		   // Não funcionar o botão back;
//		      return;
//		}
}