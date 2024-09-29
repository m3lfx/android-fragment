package com.example.infobook.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.infobook.R;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentItaly#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentItaly extends Fragment {
    public static FragmentItaly newInstance()
    {
        return new FragmentItaly();
    }

    private ImageView imageViewItaly;
    private ProgressBar progressBarItaly;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_italy,container,false);

        imageViewItaly = view.findViewById(R.id.imageViewItaly);
        progressBarItaly = view.findViewById(R.id.progressBarItaly);

        Picasso.get().load("https://upload.wikimedia.org/wikipedia/en/thumb/0/03/" +
                        "Flag_of_Italy.svg/1024px-Flag_of_Italy.svg.png")
                .into(imageViewItaly, new Callback() {
                    @Override
                    public void onSuccess() {

                        progressBarItaly.setVisibility(View.INVISIBLE);

                    }

                    @Override
                    public void onError(Exception e) {
                        Toast.makeText(getActivity(),e.getLocalizedMessage(),Toast.LENGTH_LONG).show();
                        progressBarItaly.setVisibility(View.INVISIBLE);
                    }
                });

        return view;
    }
}