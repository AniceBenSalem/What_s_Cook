package fr.whatscook.wc;

    import java.util.ArrayList;
    import java.util.List;

    import android.app.AlertDialog;
    import android.app.Fragment;
    import android.app.FragmentManager;
    import android.app.SearchManager;
    import android.app.SearchableInfo;
    import android.content.Context;
    import android.content.DialogInterface;
    import android.content.Intent;
    import android.content.SharedPreferences;
    import android.content.res.Configuration;
    import android.content.res.TypedArray;
    import android.graphics.Color;
    import android.graphics.drawable.ColorDrawable;
    import android.os.Bundle;
    import android.support.v4.app.ActionBarDrawerToggle;
    import android.support.v4.widget.DrawerLayout;
    import android.support.v7.app.ActionBarActivity;
    import android.view.KeyEvent;
    import android.view.Menu;
    import android.view.MenuInflater;
    import android.view.MenuItem;
    import android.view.View;
    import android.view.Window;
    import android.widget.AdapterView;
    import android.widget.Button;
    import android.widget.LinearLayout;
    import android.widget.ListView;
    import android.widget.SearchView;
    import android.widget.TextView;

    import fr.whatscook.wc.Fragments.FragmentAcceuil;
    import fr.whatscook.wc.Fragments.FragmentCompte;
    import fr.whatscook.wc.Fragments.FragmentEvenements;
    import fr.whatscook.wc.Fragments.FragmentFrigo;
    import fr.whatscook.wc.Fragments.FragmentConnexion;
    import fr.whatscook.wc.Fragments.FragmentParametre;
    import fr.whatscook.wc.Fragments.FragmentRecettes;
    import fr.whatscook.wc.Fragments.User;

public class Acceuil extends ActionBarActivity{
        final String EXTRA_LOGIN = "user_login";
        final String EXTRA_PASSWORD = "user_password";
        private DrawerLayout mDrawerLayout;
        private ListView mDrawerList;
        private ActionBarDrawerToggle mDrawerToggle;
        private CharSequence mDrawerTitle;
        private CharSequence mTitle;
        private String[] navMenuTitles;
        private TypedArray navMenuIcons;
        private ArrayList<NavDrawerItem> navDrawerItems;
        private NavDrawerListAdapter adapter;

    protected User u;


    public User getU() {
        return u;
    }


    @Override
        protected void onCreate(Bundle savedInstanceState) {

            super.onCreate(savedInstanceState);
            setContentView(R.layout.acceuil);

            mTitle =  getTitle();
            mDrawerTitle = getTitle();
            navMenuTitles = getResources().getStringArray(R.array.nav_drawer_items);
            navMenuIcons = getResources().obtainTypedArray(R.array.nav_drawer_icons);
            mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
            mDrawerList = (ListView) findViewById(R.id.list_slidermenu);
            navDrawerItems = new ArrayList<NavDrawerItem>();

            // Ajout des éléments aux drawer
            navDrawerItems.add(new NavDrawerItem(navMenuTitles[0], navMenuIcons.getResourceId(0, 10)));
            navDrawerItems.add(new NavDrawerItem(navMenuTitles[1], navMenuIcons.getResourceId(1, -1)));
            navDrawerItems.add(new NavDrawerItem(navMenuTitles[2], navMenuIcons.getResourceId(2, -1)));
            navDrawerItems.add(new NavDrawerItem(navMenuTitles[3], navMenuIcons.getResourceId(3, -1)/*, true, "2222"*/));
            navDrawerItems.add(new NavDrawerItem(navMenuTitles[4], navMenuIcons.getResourceId(4, -1)));
           navDrawerItems.add(new NavDrawerItem(navMenuTitles[5], navMenuIcons.getResourceId(5, -1)));
            navDrawerItems.get(2).setCount("1");
             navDrawerItems.get(2).setCounterVisibility(true);
            navMenuIcons.recycle();

            mDrawerList.setOnItemClickListener(new SlideMenuClickListener());

            adapter = new NavDrawerListAdapter(getApplicationContext(),
                    navDrawerItems);
            mDrawerList.setAdapter(adapter);



            getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#F46200")));
            mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
                    R.drawable.ic_drawer, //nav menu toggle icon
                    R.string.app_name, // nav drawer open - description for accessibility
                    R.string.app_name // nav drawer close - description for accessibility
            ) {
                public void onDrawerClosed(View view) {
                    getSupportActionBar().setTitle(mTitle);
                    invalidateOptionsMenu();
                }

                public void onDrawerOpened(View drawerView) {
                    getSupportActionBar().setTitle(mDrawerTitle);
                    invalidateOptionsMenu();
                }
            };
            mDrawerLayout.setDrawerListener(mDrawerToggle);

            if (savedInstanceState == null) {
               displayView(1);
            }
           getSupportActionBar().setDisplayHomeAsUpEnabled(true);
           getSupportActionBar().setHomeButtonEnabled(true);







        }
        private class SlideMenuClickListener implements
                ListView.OnItemClickListener {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
               displayView(position);
            }
        }
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        switch(keyCode){
            case KeyEvent.KEYCODE_BACK : ;
                new AlertDialog.Builder(this)
                        .setTitle("Quitter")
                        .setMessage("Voulez vous vraiment quitter ?")
                        .setPositiveButton(android.R.string.ok,
                                new DialogInterface.OnClickListener()
                                {
                                    public void onClick(DialogInterface dialog, int which)
                                    {
                                        System.exit(0);
                                    }
                                })
                        .setNegativeButton(android.R.string.cancel,
                                new DialogInterface.OnClickListener()
                                {
                                    public void onClick(DialogInterface dialog, int which)
                                    {
                                        // AlertDialog.cancel();
                                    }
                                })
                        .create()
                        .show();
                return true;
        }
        return false;
    }



   /*     public boolean onCreateOptionsMenu(Menu menu) {
            getMenuInflater().inflate(R.menu.menu_main, menu);
            return true;
        }*/


        public boolean onOptionsItemSelected(MenuItem item) {
            if (mDrawerToggle.onOptionsItemSelected(item)) {
                return true;
            }

                    return super.onOptionsItemSelected(item);

        }


        @Override
        public boolean onPrepareOptionsMenu(Menu menu) {
            boolean drawerOpen = mDrawerLayout.isDrawerOpen(mDrawerList);
                return super.onPrepareOptionsMenu(menu);
        }


        public void displayView(int position) {
            Fragment fragment = null;
            switch (position) {
                case 0:

                 /*   if (settings.getString("login",null).equals(null))

                    else*/
                    fragment=new FragmentConnexion();
                    break;
                case 1:
                    fragment = new FragmentAcceuil();

                    break;
                case 2:
                    fragment = new FragmentFrigo();

                    break;
                case 3:
                    fragment = new FragmentRecettes();

                    break;
                case 4:
                    fragment = new FragmentEvenements();

                    break;
                case 5:
                    fragment = new FragmentParametre();

                    break;
                default:
                    break;
            }

            if (fragment != null) {
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.frame_container, fragment).commit();
                mDrawerList.setItemChecked(position, true);
                mDrawerList.setSelection(position);
            setTitle(navMenuTitles[position]);
                mDrawerLayout.closeDrawer(mDrawerList);
            }

        }

        @Override
        public void setTitle(CharSequence title) {
            mTitle = title;
            getSupportActionBar().setTitle(mTitle);
        }

          @Override
        protected void onPostCreate(Bundle savedInstanceState) {
            super.onPostCreate(savedInstanceState);
            mDrawerToggle.syncState();
        }

        @Override
        public void onConfigurationChanged(Configuration newConfig) {
            super.onConfigurationChanged(newConfig);
             mDrawerToggle.onConfigurationChanged(newConfig);
        }



}

