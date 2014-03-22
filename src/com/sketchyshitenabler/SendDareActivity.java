package com.sketchyshitenabler;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.Toast;

public class SendDareActivity extends Activity {
    	@Override
    	protected void onCreate(Bundle savedInstanceState) {
    		super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
    		setContentView(R.layout.activity_send_dare);
    	}
    	@Override
    	public boolean onCreateOptionsMenu(Menu menu) {
    		// Inflate the menu; this adds items to the action bar if it is present.
    		getMenuInflater().inflate(R.menu.send_dare, menu);
    		return true;
    	}
	
	    static final int PICK_CONTACT_REQUEST = 1;
	    static final int CONTACT_PICKER_RESULT = -1;
    	public void pick_phone (View view) {
    	    //Intent pickContactIntent = new Intent(Intent.ACTION_PICK, Uri.parse("content://contacts"));
    	    //pickContactIntent.setType(Phone.CONTENT_TYPE); // Show user only contacts w/ phone numbers
    		Intent pickContactIntent = new Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI);
        pickContactIntent.setType(Phone.CONTENT_TYPE); // Show user only contacts w/ phone numbers
    		startActivityForResult(pickContactIntent, PICK_CONTACT_REQUEST);
    	}
    	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // Check which request it is that we're responding to
        if (requestCode == PICK_CONTACT_REQUEST) {
            // Make sure the request was successful
            if (resultCode == RESULT_OK) {
                // Get the URI that points to the selected contact
                Uri contactUri = data.getData();
                // We only need the NUMBER column, because there will be only one row in the result
                String[] projection = {Phone.NUMBER};

                // Perform the query on the contact to get the NUMBER column
                // We don't need a selection or sort order (there's only one result for the given URI)
                // CAUTION: The query() method should be called from a separate thread to avoid blocking
                // your app's UI thread. (For simplicity of the sample, this code doesn't do that.)
                // Consider using CursorLoader to perform the query.
                Cursor cursor = getContentResolver()
                        .query(contactUri, projection, null, null, null);
                cursor.moveToFirst();

                // Retrieve the phone number from the NUMBER column
                int column = cursor.getColumnIndex(Phone.NUMBER);

                String number = cursor.getString(column);
                // Do something with the phone number...
                if (cursor != null) {
                    cursor.close();
                }
                EditText emailEntry = (EditText) findViewById(R.id.dare_phone);
                emailEntry.setText(number);
                if (number.length() == 0) {
                    Toast.makeText(this, "No email found for contact.",
                            Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
    	
    public void send (View view) {
      // Implement the twillio API to send someone a dare
      Toast.makeText(this, "Not yet implemented.",
          Toast.LENGTH_LONG).show();
    }

    public void back_home (View view) {
      Intent intent = new Intent (this, MainActivity.class);
      startActivity (intent);
    }
}