package com.example.rashidalshafee.tasbihforsmartphone;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatDialogFragment;

/**
 * Created by Rashid Al Shafee on 4/2/2018.
 */

public class TasbihDialog extends AppCompatDialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage("A simple Tasbeeh app create for learning purpose."+"\n"+"Developer: Rashid Al Shafee"+"\n"+"Co-founder: Team Shunno")
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
        return builder.create();
    }
}
