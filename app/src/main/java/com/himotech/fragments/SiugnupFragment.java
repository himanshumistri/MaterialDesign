package com.himotech.fragments;

import android.app.Activity;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.himotech.matrialdesign.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link SiugnupFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link SiugnupFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SiugnupFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    protected EditText  mName;
    protected EditText  mEmail;
    protected EditText  mPhno;
    protected EditText  mAdd;
    protected EditText  mPwd;
    protected EditText  mCpwd;
    protected Cursor mCursor;
    protected Button    mSignup;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SiugnupFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SiugnupFragment newInstance(String param1, String param2) {
        SiugnupFragment fragment = new SiugnupFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public SiugnupFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View mView=inflater.inflate(R.layout.fragment_siugnup, container, false);

        initView(mView);

        return mView;

    }




    private void initView(View mView){


        mName  = (EditText)mView.findViewById(R.id.txtname);
        mEmail = (EditText)mView.findViewById(R.id.txtemail);
        mAdd   = (EditText)mView.findViewById(R.id.txtadd);
        mPhno = (EditText)mView.findViewById(R.id.txtphone);
        mPwd   = (EditText)mView.findViewById(R.id.txtpwd);
        mCpwd  = (EditText)mView.findViewById(R.id.txtcpwd);


        mSignup = (Button)mView.findViewById(R.id.btnSignup);


        mName.setHintTextColor(getResources().getColor(R.color.accent));
        mName.setTextColor(getResources().getColor(R.color.accent));




    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

}
