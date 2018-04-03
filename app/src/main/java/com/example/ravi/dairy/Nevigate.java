package com.example.ravi.dairy;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

public class Nevigate extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    public String name3;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nevigate);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final Button btn2=(Button)findViewById(R.id.btnbegin);

        Intent intent=getIntent();
        final String name=intent.getStringExtra("name");
        name3=name;

        final TextView tvmsg=(TextView) findViewById(R.id.textView49);
        String msg=" Welcome " +name3;
        tvmsg.setText(msg);

        btn2.setOnClickListener(new View.OnClickListener() {
            final String name2=name;
            @Override
            public void onClick(View view) {
                Intent myintnt=new Intent(Nevigate.this,Main3Activity.class);
                myintnt.putExtra("name",name2);
                Nevigate.this.startActivity(myintnt);

            }
        });

        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.nevigate, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        //if (id == R.id.action_settings) {
          //  return true;
       // }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.home) {
            // Handle the camera action
        } else if (id == R.id.product_detail) {
            Intent myintnt=new Intent(Nevigate.this,OrderDetails.class);
            myintnt.putExtra("name",name3);
            Nevigate.this.startActivity(myintnt);


        } else if (id == R.id.dairy) {
            Intent intent =new Intent(Nevigate.this,product2.class);
            intent.putExtra("name",name3);
            Nevigate.this.startActivity(intent);



        } else if (id == R.id.fruits) {

            Intent intent =new Intent(Nevigate.this,fruits.class);
            intent.putExtra("name",name3);
            Nevigate.this.startActivity(intent);


        } else if (id == R.id.vegitable) {

            Intent intent =new Intent(Nevigate.this,vegi.class);
            intent.putExtra("name",name3);
            Nevigate.this.startActivity(intent);


        } else if (id == R.id.logout) {
            Intent intent =new Intent(Nevigate.this,Main2Activity.class);
            Nevigate.this.startActivity(intent);

        }else if (id == R.id.about) {
            Intent intent =new Intent(Nevigate.this,About.class);
            Nevigate.this.startActivity(intent);


        }  //else if (id == R.id.action_settings) {
            //Intent intent =new Intent(Nevigate.this,Main2Activity.class);
            //Nevigate.this.startActivity(intent);

        //}



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
