    package com.example.tizi.vvf;

    import android.app.AlertDialog;
    import android.app.Dialog;
    import android.content.DialogInterface;
    import android.content.Intent;
    import android.graphics.Color;
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

    import com.example.tizi.vvf.AuxiliaryClass.Intervento;

    import java.io.File;

    public class NuovoIntervento extends FragmentActivity {

        CollectionPagerAdapter mCollectionPagerAdapter;
        ViewPager mViewPager;

        @Override
        protected void onCreate(Bundle savedInstanceState) {

            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_nuovo_intervento);
            final InterActivityData globalVariables = (InterActivityData) getApplicationContext();
            final Button conferma = (Button) findViewById(R.id.CnfBtn);
            final Button indietro = (Button) findViewById(R.id.AnnBtn);
            final Button congela = (Button) findViewById(R.id.CngBtn);

            indietro.setOnClickListener(new View.OnClickListener() {
                                            public void onClick(View v){
                                                AlertDialog alert = new AlertDialog.Builder(NuovoIntervento.this).create();
                                                alert.setTitle("Annulla");
                                                alert.setMessage("Le modifiche verranno scartate. Sei sicuro ?");
                                                alert.setButton( Dialog.BUTTON_POSITIVE, "Conferma", new DialogInterface.OnClickListener() {
                                                    public void onClick(DialogInterface dialog, int which) {
                                                        globalVariables.resetValues();
                                                        setResult(0);
                                                        finish();
                                                    }
                                                });

                                                alert.setButton( Dialog.BUTTON_NEGATIVE, "Annulla", new DialogInterface.OnClickListener()    {
                                                    public void onClick(DialogInterface dialog, int which) {

                                                    }
                                                });
                                                alert.show();
                                            }
            });

            conferma.setOnClickListener(new View.OnClickListener(){

                                            public void onClick(View v){
                                                AlertDialog alert = new AlertDialog.Builder(NuovoIntervento.this).create();
                                                alert.setTitle("Conferma");
                                                alert.setMessage("Confermando non potrai più modificare. Sei sicuro ?");

                                                alert.setButton( Dialog.BUTTON_POSITIVE, "Conferma", new DialogInterface.OnClickListener() {
                                                            public void onClick(DialogInterface dialog, int which) {
                                                                globalVariables.resetValues();
                                                                setResult(1);
                                                                finish();
                                                            }
                                                });

                                                alert.setButton( Dialog.BUTTON_NEGATIVE, "Annulla", new DialogInterface.OnClickListener()    {
                                                            public void onClick(DialogInterface dialog, int which) {
                                                            }
                                                });
                                                alert.show();
                                            }
            });

            congela.setOnClickListener(new View.OnClickListener() {

                                           public void onClick(View v) {
                                               AlertDialog alert = new AlertDialog.Builder(NuovoIntervento.this).create();
                                               alert.setTitle("Congela");
                                               alert.setMessage("I dati verranno congelati per poter terminare l'intervento in un secondo momento.");

                                               alert.setButton(Dialog.BUTTON_POSITIVE, "Conferma", new DialogInterface.OnClickListener() {
                                                   public void onClick(DialogInterface dialog, int which) {
                                                       globalVariables.setFrozen(true);
                                                       setResult(2);
                                                       finish();
                                                   }
                                               });

                                               alert.setButton(Dialog.BUTTON_NEGATIVE, "Annulla", new DialogInterface.OnClickListener() {
                                                   public void onClick(DialogInterface dialog, int which) {
                                                   }
                                               });
                                               alert.show();
                                           }
            });
            // Create an adapter that when requested, will return a fragment
            // representing an object in
            // the collection
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
        public class TabFragment extends Fragment {
            public static final String ARG_OBJECT = "object";
            final InterActivityData globalVariables = (InterActivityData) getApplicationContext();
            private Button MotIntBtn;

            @Override
            public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                     Bundle savedInstanceState) {
                Bundle args = getArguments();
                int position = args.getInt(ARG_OBJECT);
                boolean[] previousResult = globalVariables.getSelectedArray();
                int tabLayout = 0;
                View rootView = null;
                switch (position) {
                    case 0:
                        tabLayout = R.layout.activity_tab1;
                        rootView = inflater.inflate(tabLayout, container, false);
                        Button MotIntBtn = (Button) rootView.findViewById(R.id.MotIntBtn);
                        Button PerIntBtn = (Button) rootView.findViewById(R.id.PerIntBtn);
                        Button EntIntBtn = (Button) rootView.findViewById(R.id.EntIntBtn);
                        Button MezIntBtn = (Button) rootView.findViewById(R.id.MezIntBtn);
                        Button OraBtn = (Button) rootView.findViewById(R.id.OraBtn);
                        //Init Button Colors
                        if(previousResult != null){
                           if (previousResult[0])
                                MotIntBtn.setBackgroundColor(Color.GREEN);
                            if (previousResult[1])
                                PerIntBtn.setBackgroundColor(Color.GREEN);
                            if (previousResult[2])
                                EntIntBtn.setBackgroundColor(Color.GREEN);
                            if (previousResult[3])
                                MezIntBtn.setBackgroundColor(Color.GREEN);
                            if (previousResult[4])
                                OraBtn.setBackgroundColor(Color.GREEN);
                        }

                        //BOTTONE MOTIVO
                        MotIntBtn.setOnClickListener(new View.OnClickListener() {
                            public void onClick(View v) {
                                Intent intent = new Intent(getActivity(), MotivoIntervento.class);
                                startActivityForResult(intent, 0);
                            }
                        });

                        //BOTTONE PERSONALE INTERVENUTO
                        PerIntBtn.setOnClickListener(new View.OnClickListener() {
                            public void onClick(View v) {
                                Intent intent = new Intent(getActivity(), PersonaleIntervenuto.class);
                                startActivityForResult(intent, 1);
                            }
                        });

                        //BOTTONE PER ENTI INTERVENUTI
                        EntIntBtn.setOnClickListener(new View.OnClickListener() {
                            public void onClick(View v) {
                                Intent intent = new Intent(getActivity(), EntiIntervenuti.class);
                                startActivityForResult(intent, 2);
                            }
                        });

                        //BOTTONE PER MEZZI INTERVENUTI
                        MezIntBtn.setOnClickListener(new View.OnClickListener() {
                            public void onClick(View v) {
                                Intent intent = new Intent(getActivity(), MezziIntervenuti.class);
                                startActivityForResult(intent, 3);
                            }
                        });

                        //BOTTONE PER ORARI
                        OraBtn.setOnClickListener(new View.OnClickListener() {
                            public void onClick(View v) {
                                Intent intent = new Intent(getActivity(), OrariIntevento.class);
                                startActivityForResult(intent, 4);
                            }
                        });
                        break;
                    case 1:
                        tabLayout = R.layout.activity_tab2;
                        rootView = inflater.inflate(tabLayout, container, false);
                        Button DetAna = (Button) rootView.findViewById(R.id.DetAnaBtn);
                        Button Note = (Button) rootView.findViewById(R.id.NotBtn);
                        ImageButton Maps = (ImageButton) rootView.findViewById(R.id.imgMaps);
                        ImageButton Camera = (ImageButton) rootView.findViewById(R.id.imgCamera);
                        Button OraBtn2 = (Button) rootView.findViewById(R.id.OraBtn);

                        if(previousResult != null) {
                            if (previousResult[5])
                                DetAna.setBackgroundColor(Color.GREEN);
                            if (previousResult[6])
                                Note.setBackgroundColor(Color.GREEN);
                            if (previousResult[4])
                                OraBtn2.setBackgroundColor(Color.GREEN);
                        }

                        //BOTTONE DETTAGLIO ANAGRAFICA
                        DetAna.setOnClickListener(new View.OnClickListener() {
                            public void onClick(View v) {
                                Intent intent = new Intent(getActivity(), DettaglioAnagrafica.class);
                                startActivityForResult(intent, 5);
                            }
                        });

                        //NOTE
                        Note.setOnClickListener(new View.OnClickListener() {
                            public void onClick(View v) {
                                Intent intent = new Intent(getActivity(), Note.class);
                                startActivityForResult(intent, 6);
                            }
                        });

                        //BOTTONE PER MAPS
                        Maps.setOnClickListener(new View.OnClickListener() {
                            public void onClick(View v) {
                                Intent intent = new Intent(getActivity(), Mappa.class);
                                startActivityForResult(intent, 7);
                            }
                        });

                        //BOTTONE PER FOTOCAMERA
                        Camera.setOnClickListener(new View.OnClickListener() {

                            public void onClick(View v) {
                                String name = "Immagine01";
                                File destination = new File(Environment.getExternalStorageDirectory(), name + ".jpg");
                                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(destination));
                                startActivityForResult(intent, 8);
                            }
                        });

                        //BOTTONE PER ORARI
                        OraBtn2.setOnClickListener(new View.OnClickListener() {
                            public void onClick(View v) {
                                Intent intent = new Intent(getActivity(), OrariIntevento.class);
                                startActivityForResult(intent, 9);
                            }
                        });
                    break;
                }
                return rootView;
            }

            public void onActivityResult(int requestCode, int resultCode, Intent data) {
               //se confermato
                if(resultCode == 1) {
                    switch (requestCode) {
                        //gestione dati enti
                        case 2:
                            Button ente = (Button) findViewById(R.id.EntIntBtn);
                            ente.setBackgroundColor(Color.GREEN);
                            break;
                        //gestione motivo intervento
                        case 0:
                            Button MotIntBtn = (Button) findViewById(R.id.MotIntBtn);
                            MotIntBtn.setBackgroundColor(Color.GREEN);
                            break;
                        //personale intervenuto
                        case 1:
                            Button pers = (Button) findViewById(R.id.PerIntBtn);
                            pers.setBackgroundColor(Color.GREEN);
                            break;
                        //mezzi
                        case 3:
                            Button mezzi = (Button) findViewById(R.id.MezIntBtn);
                            mezzi.setBackgroundColor(Color.GREEN);
                            break;
                        //ora
                        case 4:
                            Button ora = (Button) findViewById(R.id.OraBtn);
                            ora.setBackgroundColor(Color.GREEN);
                            break;
                        //dettaglio
                        case 5:
                            Button dettaglio = (Button) findViewById(R.id.DetAnaBtn);
                            dettaglio.setBackgroundColor(Color.GREEN);
                            break;
                        //note
                        case 6:
                            Button note = (Button) findViewById(R.id.NotBtn);
                            note.setBackgroundColor(Color.GREEN);
                            break;
                        case 9:
                            Button ora2 = (Button) findViewById(R.id.OraBtn);
                            ora2.setBackgroundColor(Color.GREEN);
                            break;
                    }
                }
            }
        }

    }
