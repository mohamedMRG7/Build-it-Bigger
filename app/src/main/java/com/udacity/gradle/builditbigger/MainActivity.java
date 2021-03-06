package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.dev.mohamed.showjokelib.ShowJokeActivity;
import com.udacity.gradle.builditbigger.connection.CheckConnection;


public class MainActivity extends AppCompatActivity implements RetrieveJokeClass.OnRetrieveComplet{



    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar=findViewById(R.id.loading);



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    public void tellJoke(View view) {

       // Toast.makeText(this, theJoke, Toast.LENGTH_SHORT).show();

        if (CheckConnection.isOnline(this))
        RetrieveJokeClass.getJoke(this,progressBar);

        else Toast.makeText(this, R.string.no_conn_message,Toast.LENGTH_LONG).show();


    }


    @Override
    public void onComplete(String joke) {

        Intent intent=new Intent(MainActivity.this, ShowJokeActivity.class);
        intent.putExtra("joke",joke);
        startActivity(intent);
    }



}
