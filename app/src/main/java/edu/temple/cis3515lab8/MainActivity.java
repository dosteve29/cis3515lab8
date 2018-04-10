package edu.temple.cis3515lab8;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    WebPageAdapter webPageAdapter;
    ViewPager viewPager;
    EditText urlText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Create the ToolBar
        Toolbar my_toolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(my_toolbar);

        //Create the FragmentStatePagerAdapter and ViewPager
        webPageAdapter = new WebPageAdapter(getSupportFragmentManager());
        viewPager = findViewById(R.id.webViewPager);
        viewPager.setAdapter(webPageAdapter);

        //Button and EditText from Main Activity Layout
        Button goBtn = findViewById(R.id.goBtn);
        urlText = findViewById(R.id.urlText);

        //Listener for Button
        goBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (webPageAdapter.getCount() > 0) { //make sure there is a page available
                    WebFragment webFragment = (WebFragment) webPageAdapter.getItem(viewPager.getCurrentItem());
                    webFragment.updateText(urlText.getText().toString());
                    webFragment.loadURL();
                } else{
                    Toast.makeText(getApplicationContext(), "There is no Page available!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()) {
            case R.id.newpageview:
                webPageAdapter.createNewWebFragment(); // creates the new page within the viewpager
                viewPager.setCurrentItem(webPageAdapter.getCount() - 1); //goes to the last page
                WebFragment webFragment = (WebFragment) webPageAdapter.getItem(viewPager.getCurrentItem());
                webFragment.updateText("");
                urlText.setText(webFragment.getURL(), TextView.BufferType.EDITABLE);
                return true;

            case R.id.previous:
                if (viewPager.getCurrentItem() > 0){ //
                    viewPager.setCurrentItem(viewPager.getCurrentItem() - 1);
                    webFragment = (WebFragment) webPageAdapter.getItem(viewPager.getCurrentItem());
                    urlText.setText(webFragment.getURL(), TextView.BufferType.EDITABLE);
                }
                return true;

            case R.id.next:
                if (viewPager.getCurrentItem() < webPageAdapter.getCount() - 1){
                    viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
                    webFragment = (WebFragment) webPageAdapter.getItem(viewPager.getCurrentItem());
                    urlText.setText(webFragment.getURL(), TextView.BufferType.EDITABLE);
                }
                return true;
            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }

    }
}

