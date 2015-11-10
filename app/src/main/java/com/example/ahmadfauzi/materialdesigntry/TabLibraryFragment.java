package com.example.ahmadfauzi.materialdesigntry;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.ahmadfauzi.network.VolleySingleton;


/**
 * A simple {@link Fragment} subclass.
 */
public class TabLibraryFragment extends Fragment {
    private TextView textView;
    public TabLibraryFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    public static TabLibraryFragment getInstance(int position){
        TabLibraryFragment tabFragment = new TabLibraryFragment();
        Bundle args = new Bundle();
        args.putInt("position", position);
        tabFragment.setArguments(args);
        return tabFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        View layout = inflater.inflate(R.layout.fragment_tab_library, container, false);
        textView = (TextView) layout.findViewById(R.id.position);
        Bundle bundle = getArguments();
        if(bundle != null){
            textView.setText("The page selected is " + bundle.getInt("position"));
        }

        RequestQueue requestQueue = VolleySingleton.getInstance().getmRequestQueue();
        StringRequest request = new StringRequest(Request.Method.GET, "http://php.net/", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(getActivity(), "RESPONSE" + response, Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getActivity(), "ERROR" + error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        requestQueue.add(request);
        return layout;
    }
}
