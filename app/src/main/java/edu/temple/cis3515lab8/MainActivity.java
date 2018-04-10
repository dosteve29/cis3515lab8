package edu.temple.cis3515lab8;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    WebPageAdapter webPageAdapter;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar my_toolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(my_toolbar);

        webPageAdapter = new WebPageAdapter(getSupportFragmentManager());
        viewPager = findViewById(R.id.webViewPager);
        viewPager.setAdapter(webPageAdapter);


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
                // User chose the "Settings" item, show the app settings UI...
                Toast.makeText(getApplicationContext(), "New Page", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.previous:
                // User chose the "Favorite" action, mark the current item
                // as a favorite...
                Toast.makeText(getApplicationContext(), "Previous Page", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.next:
                Toast.makeText(getApplicationContext(), "Next Page", Toast.LENGTH_SHORT).show();
                return true;
            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }

    }
}

