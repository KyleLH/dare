package com.sketchyshitenabler;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class InboxActivity extends Activity {
  private ArrayAdapter<String> dares;
  private ListView listview;
  
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    requestWindowFeature(Window.FEATURE_NO_TITLE);
    setContentView(R.layout.activity_inbox);

    String[] daresArray = {
        "Finish this app.",
        "Win this hackathon.",
        "Eat five pizzas.",
        "Jump in the Charles",
        "Drink a liter of yogurt.",
        "Vote for our team.",
        "Download this app.",
        "Memorize the first 100 digits of pi.",
        "Steal a street sign.",
        "Sing your order at a restaurant.",
        "Return Chipotle burrito to Qudoba."
    };
    

    listview = (ListView) findViewById(R.id.daresList);
    dares = new ArrayAdapter<String> (this, R.layout.listlayout1, daresArray);
    listview.setAdapter(dares);
    
    listview.setOnItemClickListener (new OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {

            Toast.makeText(arg1.getContext(), "Not yet implemented.",
                Toast.LENGTH_SHORT).show();
            
        }
    });
  }
  
  
  
  public void back_home (View view) {
    Intent intent = new Intent (this, MainActivity.class);
    startActivity (intent);
  }
  
}
