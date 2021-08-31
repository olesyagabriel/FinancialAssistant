package com.example.myfinancialassistant.View;

import android.app.DatePickerDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.myfinancialassistant.Model.Expense_guide;
import com.example.myfinancialassistant.Model.Payment;
import com.example.myfinancialassistant.ViewModel.MyApplication;
import com.example.myfinancialassistant.R;
import com.example.myfinancialassistant.ViewModel.BottomActivity;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AddMonthlyPaymentFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AddMonthlyPaymentFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    int myYear = 2011;
    int myMonth = 02;
    int myDay = 03;
    EditText DateStart;
    EditText DateEnd;
    EditText DateReminder;
    int datenumber=1;
    public AddMonthlyPaymentFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AddAmountPaymentFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AddMonthlyPaymentFragment newInstance(String param1, String param2) {
        AddMonthlyPaymentFragment fragment = new AddMonthlyPaymentFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        Calendar calendar = Calendar.getInstance();

        myYear = calendar.get(Calendar.YEAR);
        myMonth = calendar.get(Calendar.MONTH);
        myDay = calendar.get(Calendar.DAY_OF_MONTH);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view=inflater.inflate(R.layout.fragment_add_monthly_payment, container, false);
        Spinner spinner11 = (Spinner) view.findViewById(R.id.spinner11);
        Expense_guide expense_guide=new Expense_guide();
        int k= ((MyApplication)((BottomActivity)getActivity()).getApplication()).getSomeVariable();
        expense_guide.ExpenseGuideListSelect(k);
        String[] Expense_guide_list=expense_guide.Expense_guide_list;
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, Expense_guide_list);
        // Определяем разметку для использования при выборе элемента
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner11.setAdapter(adapter);
        // Locale.setDefault(Locale.GERMANY);
        DateStart = (EditText) view.findViewById(R.id.editTextDate7);
        DateStart.setFocusable(false);

        DateEnd = (EditText) view.findViewById(R.id.editTextDate8);
        DateEnd.setFocusable(false);

        DateReminder = (EditText) view.findViewById(R.id.editTextDate9);
        DateReminder.setFocusable(false);

        String monthString="";
        if((myMonth+1)<10){
            monthString="0"+String.valueOf(myMonth+1);
        }
        else{
            monthString=String.valueOf(myMonth+1);
        }
        String dayString="";
        if(myDay<10){
            dayString="0"+String.valueOf(myDay);
        }
        else{
            dayString=String.valueOf(myDay);
        }


        DateStart.setText(myYear+"-"+ monthString + "-"+dayString);
        DateStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datenumber=1;
                new DatePickerDialog(getActivity(),
                        myCallBack, myYear, myMonth, myDay)
                        .show();
            }
        });


        DateEnd.setText(myYear+"-"+ monthString + "-"+dayString);
        DateEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datenumber=2;
                new DatePickerDialog(getActivity(),
                        myCallBack, myYear, myMonth, myDay)
                        .show();
            }
        });


        DateReminder.setText(myYear+"-"+ monthString + "-"+dayString);
        DateReminder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datenumber=3;
                new DatePickerDialog(getActivity(),
                        myCallBack, myYear, myMonth, myDay)
                        .show();
            }
        });
        Button button7 = (Button) view.findViewById(R.id.button7);
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getView().setVisibility(View.GONE);
                ((BottomActivity)getActivity()).openPaymentTabFragment();


            }
        });
        Button button4 = (Button) view.findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText textView58 = (EditText) view.findViewById(R.id.textView58);
                String stringtextView58=textView58.getText().toString();
                EditText editTextNumber6 = (EditText) view.findViewById(R.id.editTextNumber6);
                int inteditTextNumber6 = Integer.valueOf(editTextNumber6.getText().toString());
                EditText editTextDate7 = (EditText) view.findViewById(R.id.editTextDate7);
                String stringeditTextDate7 = editTextDate7.getText().toString();
                EditText editTextDate8 = (EditText) view.findViewById(R.id.editTextDate8);
                String stringeditTextDate8 = editTextDate8.getText().toString();
                EditText editTextDate9 = (EditText) view.findViewById(R.id.editTextDate9);
                String stringeditTextDate9 = editTextDate9.getText().toString();
                Spinner spinner11 = (Spinner) view.findViewById(R.id.spinner11);
                String stringspinner11 = spinner11.getSelectedItem().toString();
                Payment newpayment = new Payment();
                int k= ((MyApplication)((BottomActivity)getActivity()).getApplication()).getSomeVariable();
                newpayment.insertPayment(k,stringeditTextDate7, stringeditTextDate8, stringtextView58,inteditTextNumber6,stringeditTextDate9,stringspinner11,1);

                Toast toast = Toast.makeText(getActivity(),
                        "Платеж добавлен!", Toast.LENGTH_LONG);
                toast.show();
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                getView().setVisibility(View.GONE);
                ((BottomActivity)getActivity()).openPaymentTabFragment();
            }
        });
        return view;
    }
    DatePickerDialog.OnDateSetListener myCallBack = new DatePickerDialog.OnDateSetListener() {

        public void onDateSet(DatePicker view, int year, int monthOfYear,
                              int dayOfMonth) {
            myYear = year;
            myMonth = monthOfYear;
            myDay = dayOfMonth;
            String monthString="";
            if((myMonth+1)<10){
                monthString="0"+String.valueOf(myMonth+1);
            }
            else{
                monthString=String.valueOf(myMonth+1);
            }
            String dayString="";
            if(myDay<10){
                dayString="0"+String.valueOf(myDay);
            }
            else{
                dayString=String.valueOf(myDay);
            }
            if (datenumber==1){
                DateStart.setText(myYear+"-"+ monthString + "-"+dayString);
            }
            else if (datenumber==2){
                DateEnd.setText(myYear+"-"+ monthString + "-"+dayString);
            }
            else if(datenumber==3){
                DateReminder.setText(myYear+"-"+ monthString + "-"+dayString);
            }

        }

    };
}