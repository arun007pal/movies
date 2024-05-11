package com.example.movieapp.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.movieapp.ListAdapter;
import com.example.movieapp.Movie;
import com.example.movieapp.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class Movies extends Fragment {
    RecyclerView Recyclerview;
    FirebaseDatabase firebaseDatabase;
    List<Movie> Movielist=new ArrayList<>();
    ListAdapter adapter;
    public Movies() {
        // Required empty public constructor
    }






    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movies, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        adapter=new ListAdapter(Movielist,requireContext());
        firebaseDatabase = FirebaseDatabase.getInstance();
        firebaseDatabase.getReference().child("movie").addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot childSnapshot : snapshot.getChildren()){
                    Movie movie = new Movie(childSnapshot.child("image").getValue(String.class),childSnapshot.child("title").getValue(String.class),childSnapshot.child("url").getValue(String.class));
                    Movielist.add(movie);
//                    Log.d("Hr00",movie.getTitle());
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.d("Hello","Bye");
            }
        });
        Recyclerview=view.findViewById(R.id.Recyclerview);


        Recyclerview.setLayoutManager(new GridLayoutManager(requireContext(),3));

        Recyclerview.setAdapter(adapter);
    }
}