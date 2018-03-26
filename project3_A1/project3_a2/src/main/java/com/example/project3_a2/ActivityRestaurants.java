package com.example.project3_a2;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ActivityRestaurants extends AppCompatActivity implements TitlesFragment.ListSelectionListener

{
    public static String[] mTitleArray;
    public static String[] mLinkArray;
    private TitlesFragment mTitlesFragment;
    private DetailsFragment mDetailsFragment =  new DetailsFragment();
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attractions);
        // Get a reference to the QuotesFragment
        mTitleArray = getResources().getStringArray(R.array.RestaurantsTitles);
        mLinkArray = getResources().getStringArray(R.array.RestaurantsLinks);
        // UB: 10-8-2017 Get a reference to the TitlesFragment
        fragmentManager = getFragmentManager();

            mTitlesFragment = (TitlesFragment) fragmentManager
                    .findFragmentById(R.id.list_attractions);
            mDetailsFragment = (DetailsFragment) fragmentManager
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
}
