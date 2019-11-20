package com.example.treelist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

        private static final String URL_PRODUCTS = "http://treetime.ml/api.php";

    //the recyclerview
    ListView listView;
    String name;
    List<Product> productList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.shugam);

        productList = new ArrayList<>();

        final ArrayList<String> arrayList = new ArrayList<>();

        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL_PRODUCTS,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            //converting the string to json array object
                            final JSONArray array = new JSONArray(response);

                            //traversing through all the object
                            for (int i = 0; i < array.length(); i++) {

                                //getting product object from json array
                                JSONObject product = array.getJSONObject(i);

                                //adding the product to product list
                                arrayList.add(product.getString("shugam")
                                );

                                productList.add(new Product(
                                        product.getInt("id"),
                                        product.getString("shugam"),
                                        product.getString("tulguur"),
                                        product.getString("zurag"),
                                        product.getString("temdeglel")
                                ));

                            }

                            //creating adapter object and setting it to recyclerview
                            final ArrayAdapter arrayAdapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, arrayList);

                            listView.setAdapter(arrayAdapter);

                            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                @Override
                                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                                    Intent huudaslalt = new Intent(MainActivity.this, Huudaslalt.class);

                                    Product product = productList.get(position);

                                    huudaslalt.putExtra("Tulguur", product.getTulguur());
                                    huudaslalt.putExtra("Zurag", product.getZurag());
                                    huudaslalt.putExtra("Temdeglel", product.getTemdeglel());

                                    //Toast.makeText(MainActivity.this, " Tulguur :" + product.getTulguur() + "Zurag :" + product.getZurag(), Toast.LENGTH_SHORT).show();


                                    startActivity(huudaslalt);

                                }
                            });


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

        //adding our stringrequest to queue
        Volley.newRequestQueue(this).add(stringRequest);



    }
}
