package com.example.kleno.botonrojo;

import android.media.MediaPlayer;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button button;
    TextView textView3;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button)findViewById(R.id.button);
        textView3 = (TextView) findViewById(R.id.textView3);
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick()
            {
                textView3.setText();
            }
        });

        //Esta parte del código genera un sonido automático
        MediaPlayer player = MediaPlayer.create(this, Settings.System.DEFAULT_RINGTONE_URI);
        player.setLooping(true);
        player.start();

        private void setText()
        {
            String url = "192.168.201.75:41000/api/hello-world";

            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                    (Request.Method.GET, url, null, new Response.Listener<JSONObject>()
                    {

                        @Override
                        public void onResponse(JSONObject response)
                        {
                            try
                            {
                                tuTextView.setText(response.getString("Message:" + response.toString()));
                            }
                            catch (JSONException e)
                            {
                                tuTextView.setText(e.getMessage());
                            }
                        }
                    }, new Response.ErrorListener()
                    {

                        @Override
                        public void onErrorResponse(VolleyError error)
                        {
                            //card.setText(error.getMessage());
                        }
                    });
            // Instantiate the RequestQueue.
            RequestQueue queue = Volley.newRequestQueue(this);
            queue.add(jsonObjectRequest);
        }
    }
}
