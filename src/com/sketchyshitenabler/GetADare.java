package com.sketchyshitenabler;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
public class GetADare extends Activity {
  private ArrayAdapter<String> dares;
  private ListView listview;
  
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    requestWindowFeature(Window.FEATURE_NO_TITLE);
    setContentView(R.layout.activity_get_adare);
    
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
    
    final int REQUEST_VIDEO_CAPTURE = 1;
    listview = (ListView) findViewById(R.id.daresList);
    dares = new ArrayAdapter<String> (this, R.layout.listlayout1, daresArray);
    listview.setAdapter(dares);
    listview.setOnItemClickListener (new OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
            String cur_dare = String.valueOf(listview.getItemAtPosition (position));

            Toast.makeText(arg1.getContext(), cur_dare,
                Toast.LENGTH_LONG).show();
            
            Intent takeVideoIntent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
            if (takeVideoIntent.resolveActivity(getPackageManager()) != null) {
                startActivityForResult(takeVideoIntent, REQUEST_VIDEO_CAPTURE);
            } 
        }
    });
  }
  
  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.get_adare, menu);
    return true;
  }
  public void back_home (View view) {
    Intent intent = new Intent (this, MainActivity.class);
    startActivity (intent);
  }
}
