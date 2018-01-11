package com.example.android.bakingapp.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.bakingapp.R;
import com.example.android.bakingapp.Recipe;
import com.example.android.bakingapp.activities.RecipeStepsActivity;
import com.example.android.bakingapp.adapters.RecipeStepsAdapter;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link RecipeStepsFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {link RecipeStepsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RecipeStepsFragment extends Fragment {

    private TextView debugTextView;

    // Storage variables
    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLayoutManager;
    private RecipeStepsAdapter mAdapter;
    private OnFragmentInteractionListener mListener;

    // Required empty public constructor
    public RecipeStepsFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_recipe_steps, container, false);

        // Get a reference to the GridView in the fragment_master_list xml layout file
        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.rv_recipe_steps);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mAdapter = new RecipeStepsAdapter();

        // Set the adapter on the RecyclerView
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

        // Get and set adapter data from activity
        RecipeStepsActivity activity = (RecipeStepsActivity) getActivity();
        mAdapter.setRecipeStepsData(activity.getRecipe());

        /******* DEBUG *******/
        debugTextView = rootView.findViewById(R.id.tv_debug);
        try {
            debugTextView.setText(Integer.toString(activity.getRecipe().getRecipeSteps().length));
        } catch (Exception e){
            debugTextView.setText(e.getMessage());
        }

        /***********************/

        // Return the root view
        return rootView;
    }

    /* Rename method, update argument and hook method into UI event */
    public void onRecipeSelected(int position) {
        if (mListener != null) {
            mListener.onFragmentInteraction(position);
        }
    }

    /*
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        //  Update argument type and name
        void onFragmentInteraction(int position);
    }
}
