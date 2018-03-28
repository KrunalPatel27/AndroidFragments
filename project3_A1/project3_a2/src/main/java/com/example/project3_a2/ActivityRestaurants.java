package com.example.project3_a2;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class ActivityRestaurants extends AppCompatActivity implements RestaurantTitlesFragment.ListSelectionListener

{
    public static String[] mTitleArray;
    public static String[] mLinkArray;
    private RestaurantTitlesFragment mTitlesFragment;
    private RestaurantDetailsFragment mDetailsFragment =  new RestaurantDetailsFragment();
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurants);
        // Get a reference to the QuotesFragment
        mTitleArray = getResources().getStringArray(R.array.RestaurantsTitles);
        mLinkArray = getResources().getStringArray(R.array.RestaurantsLinks);
        // UB: 10-8-2017 Get a reference to the TitlesFragment
        fragmentManager = getFragmentManager();

            mTitlesFragment = (RestaurantTitlesFragment) fragmentManager
                    .findFragmentById(R.id.list_attractions);
            mDetailsFragment = (RestaurantDetailsFragment) fragmentManager
                    .findFragmentById(R.id.details_attractions);


    }

    @Override
    public void onListSelection(int index) {
        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.hide(mTitlesFragment);
            fragmentTransaction.show(mDetailsFragment);
            fragmentTransaction.commit();
            fragmentManager.executePendingTransactions();

        }
        if (mDetailsFragment.getShownIndex() != index) {
            // Tell the QuoteFragment to show the quote string at position index
            mDetailsFragment.showQuoteAtIndex(index);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.restaurants_menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getTitle().toString()){
            case "Attractions":
                Intent intent1 = new Intent(getApplicationContext(), ActivityAttractions.class);
                getApplicationContext().startActivity(intent1);
                break;
            default:
                break;
        }
        return true;
    }
}
