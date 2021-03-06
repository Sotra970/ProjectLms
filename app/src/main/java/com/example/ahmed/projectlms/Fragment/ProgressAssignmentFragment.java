package com.example.ahmed.projectlms.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.ahmed.projectlms.Adapter.ProgressAssignmentAdapter;
import com.example.ahmed.projectlms.Models.AssignmentModel;
import com.example.ahmed.projectlms.Models.Class_model;
import com.example.ahmed.projectlms.R;
import com.example.ahmed.projectlms.app.AppController;
import com.example.ahmed.projectlms.app.Config;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Mohab on 4/8/2017.
 */

public class ProgressAssignmentFragment extends Fragment
{
    RecyclerView recyclerViewAssignmentProgress;
    ProgressAssignmentAdapter progressAssignmentAdapter;
    private ArrayList<AssignmentModel> assignmentList = new ArrayList<>();
    String pClassId , pStudentId ;
    public static final String LOG_TAG = ProgressAssignmentFragment.class.getSimpleName();
    Class_model extras ;
    public Class_model getExtras() {
        return extras;
    }

    public void setExtras(Class_model extras) {
        this.extras = extras;
    }
    View view;
    private String TAG = ProgressAssignmentFragment.class.getSimpleName();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        view = inflater.inflate(R.layout.fragment_assignment_progress,  container, false);
        recyclerViewAssignmentProgress = (RecyclerView) view.findViewById(R.id.recycler_view_assignment_progress);
        progressAssignmentAdapter = new ProgressAssignmentAdapter(assignmentList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);

        recyclerViewAssignmentProgress.setLayoutManager(layoutManager);
        recyclerViewAssignmentProgress.setAdapter(progressAssignmentAdapter);
        assignmentData();
        return view;
    }


    private void assignmentData()
    {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, Config.BASE_URL + "progress_assignment.php", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e(LOG_TAG, "onResponse log1 : " + response);
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    String responseString = jsonObject.getString("response");
                    if (responseString.equals("success")) {
                        JSONArray jsonArray = jsonObject.getJSONArray("data");

                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                            AssignmentModel assignment = new AssignmentModel();

                            assignment.setFileName(jsonObject1.getString("fname"));
                            assignment.setAssDescription(jsonObject1.getString("fdesc"));
                            assignment.setDateUpload(jsonObject1.getString("fdatein"));
                            assignment.setAssGrade(jsonObject1.getString("grade"));
                            if (!assignment.getAssGrade().trim().isEmpty())
                                 assignmentList.add(assignment);
                        }
                        progressAssignmentAdapter.notifyDataSetChanged();
                    }
                }
                catch (JSONException e)
                {
                    Log.e(LOG_TAG, "onResponse Exception : " + response);
                }
            }
        }, new Response.ErrorListener()
        {
            @Override
            public void onErrorResponse(VolleyError error)
            {

            }
        }
        )
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError
            {
                Map<String, String> params = new HashMap<>();
                params.put("class_id", AppController.getInstance().getPrefManager().getUser().getClass_id());
                params.put("student_id",AppController.getInstance().getPrefManager().getUser().getStudent_id());
                Log.e(TAG,"params" + params);
                return params;
            }

        };

        int socketTimeout = 10000; // 10 seconds. You can change it
        RetryPolicy policy = new DefaultRetryPolicy(socketTimeout,
                10,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);

        stringRequest.setRetryPolicy(policy);
        //Adding request to request queue
        AppController.getInstance().addToRequestQueue(stringRequest);

    }


}
