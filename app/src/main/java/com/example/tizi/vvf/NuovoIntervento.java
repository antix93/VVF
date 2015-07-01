package com.example.tizi.vvf;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuItem;
import android.app.ActionBar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import java.io.File;
import java.util.Date;


public class NuovoIntervento extends FragmentActivity {

    CollectionPagerAdapter mCollectionPagerAdapter;
    protected Intervento intervento;
    ViewPager mViewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        intervento = new Intervento();
        setContentView(R.layout.activity_nuovo_intervento);

        final Button indietro = (Button) findViewById(R.id.AnnBtn);
        indietro.setOnClickListener(new View.OnClickListener() {

                                        public void onClick(View v) {

                                            setResult(0);
                                            finish();
                                        }
                                    }
        );
        final Button conferma = (Button) findViewById(R.id.CnfBtn);
        conferma.setOnClickListener(new View.OnClickListener(){

                                        public void onClick(View v){

                                            setResult(1);
                                            finish();
                                        }
                                    }
        );
        final Button congela = (Button) findViewById(R.id.CngBtn);
        congela.setOnClickListener(new View.OnClickListener(){

                                        public void onClick(View v){

                                            setResult(2);
                                            finish();
                                        }
                                    }
        );
        // Create an adapter that when requested, will return a fragment
        // representing an object in
        // the collection.
        //
        // ViewPager and its adapters use support library fragments, so we must
        // use
        // getSupportFragmentManager.
        mCollectionPagerAdapter = new CollectionPagerAdapter(
                getSupportFragmentManager());

        // Set up action bar.
        final ActionBar actionBar = getActionBar();

        // Specify that the Home button should show an "Up" caret, indicating
        // that touching the
        // button will take the user one step up in the application's hierarchy.
        //actionBar.setDisplayHomeAsUpEnabled(true);

        // Set up the ViewPager, attaching the adapter.
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(mCollectionPagerAdapter);

    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //se confermato
        if(resultCode == 1) {
            switch (requestCode) {
                //gestione dati enti
                case 0:
                    String[] stringa = new String[2];
                    stringa[0] = data.getStringExtra("ente1");
                    stringa[1] = data.getStringExtra("ente2");
                    intervento.entiIntervenuti = stringa;
                    break;
                //gestione dati mezzi
                case 1:
                    String[] mezzi = new String[1];
                    mezzi[0] = data.getStringExtra("mezzo1");
                    intervento.mezziIntervenuti = mezzi;
                    break;
                case 2:
                    intervento.orarioArrivo = data.getStringExtra("orario1");
                    break;

            }
        }
    }
    /**
     * A {@link android.support.v4.app.FragmentStatePagerAdapter} that returns a
     * fragment representing an object in the collection.
     */
    public class CollectionPagerAdapter extends FragmentStatePagerAdapter {

        final int NUM_ITEMS = 2; // number of tabs

        public CollectionPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            Fragment fragment = new TabFragment();
            Bundle args = new Bundle();
            args.putInt(TabFragment.ARG_OBJECT, i);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public int getCount() {
            return NUM_ITEMS;
        }

        @Override
        public CharSequence getPageTitle(int position) {

            String tabLabel = null;
            switch (position) {
                case 0:
                    //Titolo delle label nelle tabs
                    tabLabel = getString(R.string.label1);
                    break;
                case 1:
                    tabLabel = getString(R.string.label2);
                    break;
            }

            return tabLabel;
        }
    }

    /**
     * A dummy fragment representing a section of the app, but that simply
     * displays dummy text.
     */
    public static class TabFragment extends Fragment {

        public static final String ARG_OBJECT = "object";

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {

            Bundle args = getArguments();
            int position = args.getInt(ARG_OBJECT);

            int tabLayout = 0;
            View rootView = null;
            switch (position) {
                case 0:
                    tabLayout = R.layout.activity_tab1;
                    rootView = inflater.inflate(tabLayout, container, false);

                    //BOTTONE MOTIVO
                    Button MotIntBtn = (Button) rootView.findViewById(R.id.MotIntBtn);
                    MotIntBtn.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {

                            Intent intent = new Intent(getActivity(), MotivoIntervento.class);
                            startActivityForResult(intent, 0);
                        }
                    });

                    //BOTTONE PERSONALE INTERVENUTO
                    Button PerIntBtn = (Button) rootView.findViewById(R.id.PerIntBtn);
                    PerIntBtn.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {

                            Intent intent = new Intent(getActivity(), PersonaleIntervenuto.class);
                            startActivityForResult(intent, 0);
                        }
                    });

                    //BOTTONE PER ENTI INTERVENUTI
                    Button EntIntBtn = (Button) rootView.findViewById(R.id.EntIntBtn);
                    EntIntBtn.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {

                            Intent intent = new Intent(getActivity(), EntiIntervenuti.class);
                            startActivityForResult(intent, 0);
                        }
                    });

                    //BOTTONE PER MEZZI INTERVENUTI
                    Button MezIntBtn = (Button) rootView.findViewById(R.id.MezIntBtn);
                    MezIntBtn.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {

                            Intent intent = new Intent(getActivity(), MezziIntervenuti.class);
                            startActivityForResult(intent, 1);
                        }
                    });

                    //BOTTONE PER ORARI
                    Button OraBtn = (Button) rootView.findViewById(R.id.OraBtn);
                    OraBtn.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {

                            Intent intent = new Intent(getActivity(), orari.class);
                            startActivityForResult(intent, 2);
                        }
                    });



                    break;
                case 1:
                    tabLayout = R.layout.activity_tab2;
                    rootView = inflater.inflate(tabLayout, container, false);

                    //BOTTONE DETTAGLIO ANAGRAFICA
                    Button DetAna = (Button) rootView.findViewById(R.id.DetAnaBtn);
                    DetAna.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {

                            Intent intent = new Intent(getActivity(), DettaglioAnagrafica.class);
                            startActivityForResult(intent, 2);
                        }
                    });

                    //NOTE
                    Button Note = (Button) rootView.findViewById(R.id.NotBtn);
                    Note.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {

                            Intent intent = new Intent(getActivity(), Note.class);
                            startActivityForResult(intent, 2);
                        }
                    });

                    //BOTTONE PER MAPS
                    ImageButton Maps = (ImageButton) rootView.findViewById(R.id.imgMaps);
                    Maps.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {

                            Intent intent = new Intent(getActivity(), Mappa.class);
                            startActivityForResult(intent, 2);
                        }
                    });


                    //BOTTONE PER FOTOCAMERA
                    ImageButton Camera = (ImageButton) rootView.findViewById(R.id.imgCamera);

                    Camera.setOnClickListener(new View.OnClickListener() {

                        public void onClick(View v) {

                            String name = "Immagine01";
                            File destination = new File(Environment
                                    .getExternalStorageDirectory(), name + ".jpg");

                            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                            intent.putExtra(MediaStore.EXTRA_OUTPUT,
                                    Uri.fromFile(destination));
                            startActivityForResult(intent, 2);

                        }
                    });

                    //BOTTONE PER ORARI
                    Button OraBtn2 = (Button) rootView.findViewById(R.id.OraBtn);
                    OraBtn2.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {

                            Intent intent = new Intent(getActivity(), orari.class);
                            startActivityForResult(intent, 2);
                        }
                    });

                    break;


            }

            return rootView;

        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_nuovo_intervento, menu);
        return true;
    }

    public boolean onPrepareOptionsMenu(Menu menu){
        menu.getItem(0).setEnabled(false);
        return super.onPrepareOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.IcoNome) {

            Intent intent = new Intent(this, DettUtente.class);
            startActivityForResult(intent, 0);
        }

        return super.onOptionsItemSelected(item);
    }

}
