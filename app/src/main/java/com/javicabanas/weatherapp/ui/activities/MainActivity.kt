package com.javicabanas.weatherapp.ui.activities

import android.os.Bundle
import android.support.v7.app.ActionBarActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.Menu
import android.view.MenuItem
import com.javicabanas.weatherapp.R
import com.javicabanas.weatherapp.domain.commands.RequestForecastCommand
import com.javicabanas.weatherapp.domain.model.Forecast
import com.javicabanas.weatherapp.ui.adapters.ForecastListAdapter
import org.jetbrains.anko.async
import org.jetbrains.anko.find
import org.jetbrains.anko.toast
import org.jetbrains.anko.uiThread


class MainActivity : ActionBarActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val forecastList: RecyclerView = find(R.id.forecast_list)
        forecastList.setLayoutManager(LinearLayoutManager(this))

        async {
            val result = RequestForecastCommand("94043").execute()
            uiThread {
                val adapter= ForecastListAdapter(result, { toast(it.date)})
                forecastList.setAdapter(adapter)
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val id = item!!.getItemId()

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}
