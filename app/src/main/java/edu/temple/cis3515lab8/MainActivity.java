package edu.temple.cis3515lab8;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
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
                webPageAdapter.createNewWebFragment(); // creates the new page within the viewpager
                viewPager.setCurrentItem(webPageAdapter.getCount() - 1); //goes to the last page
                return true;

            case R.id.previous:
                if (viewPager.getCurrentItem() > 0){ //
                    viewPager.setCurrentItem(viewPager.getCurrentItem() - 1);
                }
                return true;

            case R.id.next:
                if (viewPager.getCurrentItem() < webPageAdapter.getCount() - 1){
                    viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
                }
                return true;
            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }

    }
}

