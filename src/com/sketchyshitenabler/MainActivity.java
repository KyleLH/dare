package com.sketchyshitenabler;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;


public class MainActivity extends Activity {
  
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    requestWindowFeature(Window.FEATURE_NO_TITLE);
    setContentView(R.layout.activity_main);
  }
  
  
  public void goToInbox (View view) {
    Intent intent = new Intent (this, InboxActivity.class);
    startActivity (intent);
  }
  
  public void send_a_dare (View view) {
    Intent intent = new Intent (this, SendDareActivity.class);
    startActivity (intent);
  }
  public void get_a_dare (View view) {
    Intent intent = new Intent (this, GetADare.class);
    startActivity (intent);
  }
}
