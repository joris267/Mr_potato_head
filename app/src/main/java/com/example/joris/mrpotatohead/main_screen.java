package com.example.joris.mrpotatohead;

import android.inputmethodservice.Keyboard;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;


public class main_screen extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);

//        Code below doesn't work since checkbox.isSelected() returns false even when the checkbox is selected.
//        I have an less elegant solution now by adding "android:configChanges="orientation|screenSize" to the manifest
//        The code below is kept since I plan to try to fix this monday.
////        Below code is to ensure that the app behaves properly on turning the screen.
////        The problem was that it would keep the boxes checked but make all the accessories invisible.
//        TableLayout container = (TableLayout)findViewById(R.id.button_container);
//        int num_rows = container.getChildCount();
//        int row_number;
//
////        First we loop over all the rows.
//        for (row_number = 0; row_number < num_rows; row_number++){
//            TableRow row = (TableRow)container.getChildAt(row_number);
//
//            int checkbox_cout = row.getChildCount();
//            int checkbox_number;
//
////            Then we loop over every box in the row.
//            for (checkbox_number = 0; checkbox_number < checkbox_cout; checkbox_number++) {
//                CheckBox checkbox = (CheckBox) row.getChildAt(checkbox_number);
//
////                Then we get a link to the target image and check weather the box is checked.
//                String target_img = checkbox.getTag().toString();
//                boolean checked = checkbox.isSelected();
//                System.out.println("HEEEEEEEEEERE  " + checked + "  " + target_img );
//
////                Lastly we get the imageview and set it to the correct visibility.
//                int drawable_resource_id = this.getResources().getIdentifier(target_img, "id", this.getPackageName());
//                ImageView image = (ImageView) findViewById(drawable_resource_id);
//                if (checked) {
//                    image.setVisibility(View.VISIBLE);
//                } else {
//                    image.setVisibility(View.GONE);
//                }
//            }
//        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_screen, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onClick(View view) {
        boolean checked = ((CheckBox) view).isChecked();

//        get name of target image and convert it to id
        String target_img = view.getTag().toString();
        int drawable_resource_id = this.getResources().getIdentifier(target_img, "id", this.getPackageName());

//        Get target imageView and use it to set visibility
        ImageView image = (ImageView) findViewById(drawable_resource_id);
        if (checked) {
            image.setVisibility(view.VISIBLE);
        }else{
            image.setVisibility(view.GONE);
        }

    }

}


