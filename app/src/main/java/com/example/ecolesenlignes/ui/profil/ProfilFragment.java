package com.example.ecolesenlignes.ui.profil;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.ecolesenlignes.MainActivity;
import com.example.ecolesenlignes.Model.Eleve;
import com.example.ecolesenlignes.Model.Parent;
import com.example.ecolesenlignes.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.button.MaterialButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class ProfilFragment extends Fragment {

    private ProfilViewModel profilViewModel;
    private Parent Parent;
    private Eleve Eleve;
    private LinearLayout modeFormation, modeAbonnement,PhoneLayout,FacebookLayout,TwitterLayout;
    private FirebaseAuth mAuth;
    private MaterialButton logOut;
    private FirebaseFirestore db;
    private String TAG="ProfilFragment";

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        profilViewModel =
                ViewModelProviders.of(this).get(ProfilViewModel.class);
        View root = inflater.inflate(R.layout.fragment_profil, container, false);
        mAuth=FirebaseAuth.getInstance();
       String id=mAuth.getInstance().getCurrentUser().getUid();
        db=FirebaseFirestore.getInstance();
        DocumentReference Ref = db.collection("Users").document("user "+id);
        TextView NomProfil=root.findViewById(R.id.tv_name);
        TextView EmailText=root.findViewById(R.id.Email_text);
        TextView PhoneText=root.findViewById(R.id.Phone_text);
        TextView TwitterText=root.findViewById(R.id.Twitter_link);
        TextView FbText=root.findViewById(R.id.Facebook_text);
        TextView AbonnmentText=root.findViewById(R.id.Abonement_text);
        TextView ModeFormationText=root.findViewById(R.id.ModeFormation_text);
        FacebookLayout=root.findViewById(R.id.Facebok_layout);
        TwitterLayout=root.findViewById(R.id.Twitter_layout);


        modeFormation=root.findViewById(R.id.Formation_layout);
        modeAbonnement=root.findViewById(R.id.Abonement_layout);
        PhoneLayout=root.findViewById(R.id.Phone_layout);
        logOut=root.findViewById(R.id.LogoutButton);


        PhoneLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Creating alert Dialog with one Button
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(getContext());

                // Setting Dialog Title
                alertDialog.setTitle("Phone number");
                // Setting Dialog Message
                alertDialog.setMessage("Enter Phone Number");
                final EditText input = new EditText(getContext());
                input.setInputType(InputType.TYPE_CLASS_PHONE);
                LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.MATCH_PARENT);
                input.setLayoutParams(lp);
                alertDialog.setView(input);                //alertDialog.setView(input);
                // Setting Positive "Yes" Button
                alertDialog.setPositiveButton("Valider",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int which) {
                                // Write your code here to execute after dialog
                                PhoneText.setText(input.getText());
                                Ref
                                        .update("phoneNumber", input.getText().toString())
                                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                                            @Override
                                            public void onSuccess(Void aVoid) {
                                                Log.d(TAG, "DocumentSnapshot successfully updated!");
                                            }
                                        })
                                        .addOnFailureListener(new OnFailureListener() {
                                            @Override
                                            public void onFailure(@NonNull Exception e) {
                                                Log.w(TAG, "Error updating document", e);
                                            }
                                        });
                            }
                        });
                // Setting Negative "NO" Button
                alertDialog.setNegativeButton("Annuler",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // Write your code here to execute after dialog
                                dialog.cancel();
                            }
                        });
                // Showing Alert Message
                alertDialog.show();

            }
        });

        TwitterLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Creating alert Dialog with one Button
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(getContext());

                // Setting Dialog Title
                alertDialog.setTitle("Twitter Profile");
                // Setting Dialog Message
                alertDialog.setMessage("Enter your Twitter Profil");
                final EditText input = new EditText(getContext());
                input.setInputType(InputType.TYPE_CLASS_TEXT);
                LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.MATCH_PARENT);
                input.setLayoutParams(lp);
                alertDialog.setView(input);
                // Setting Positive "Yes" Button
                alertDialog.setPositiveButton("Valider",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int which) {
                                // Write your code here to execute after dialog
                                TwitterText.setText(input.getText());
                                Ref
                                        .update("twitterPage","https://twitter.com/"+input.getText().toString())
                                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                                            @Override
                                            public void onSuccess(Void aVoid) {
                                                Log.d(TAG, "DocumentSnapshot successfully updated!");
                                            }
                                        })
                                        .addOnFailureListener(new OnFailureListener() {
                                            @Override
                                            public void onFailure(@NonNull Exception e) {
                                                Log.w(TAG, "Error updating document", e);
                                            }
                                        });
                            }
                        });
                // Setting Negative "NO" Button
                alertDialog.setNegativeButton("Annuler",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // Write your code here to execute after dialog
                                dialog.cancel();
                            }
                        });
                // Showing Alert Message
                alertDialog.show();

            }
        });


        FacebookLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Creating alert Dialog with one Button
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(getContext());

                // Setting Dialog Title
                alertDialog.setTitle("Facebook Profile");
                // Setting Dialog Message
                alertDialog.setMessage("Enter your facebook Profil");
                final EditText input = new EditText(getContext());
                input.setInputType(InputType.TYPE_CLASS_TEXT);
                LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.MATCH_PARENT);
                input.setLayoutParams(lp);
                alertDialog.setView(input);                //alertDialog.setView(input);
                // Setting Positive "Yes" Button
                alertDialog.setPositiveButton("Valider",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int which) {
                                // Write your code here to execute after dialog
                                FbText.setText(input.getText());
                                Ref
                                        .update("facebookPage","https://www.facebook.com/"+input.getText().toString())
                                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                                            @Override
                                            public void onSuccess(Void aVoid) {
                                                Log.d(TAG, "DocumentSnapshot successfully updated!");
                                            }
                                        })
                                        .addOnFailureListener(new OnFailureListener() {
                                            @Override
                                            public void onFailure(@NonNull Exception e) {
                                                Log.w(TAG, "Error updating document", e);
                                            }
                                        });
                            }
                        });
                // Setting Negative "NO" Button
                alertDialog.setNegativeButton("Annuler",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // Write your code here to execute after dialog
                                dialog.cancel();
                            }
                        });
                // Showing Alert Message
                alertDialog.show();

            }
        });




        MainActivity activity = (MainActivity) getActivity();
        Boolean b=activity.getTypeUser();
        if(b)
        {
            //i??i parent
            Parent=activity.getParentUser();
            Log.d(TAG, "onCreateView: ");
            modeFormation.setVisibility(LinearLayout.GONE);
            modeAbonnement.setVisibility(LinearLayout.GONE);
            NomProfil.setText(Parent.getNom()+" "+Parent.getPrenom());
            EmailText.setText(Parent.getMail());
            if(Parent.getPhoneNumber()!=null)
            {
                PhoneText.setText(Parent.getPhoneNumber());
            }
            if(Parent.getFacebookPage()!=null)
            {
                FbText.setText(Parent.getFacebookPage());
            }

            if(Parent.getTwitterPage()!=null)
            {
                TwitterText.setText(Parent.getTwitterPage());
            }


        }
        else
        {
            //i??i enfant
            Eleve=activity.getEnfantUser();
            NomProfil.setText(Eleve.getNomEleve()+" "+Eleve.getPrenomEleve());
            EmailText.setText(Eleve.getMailEleve());
            AbonnmentText.setText(Eleve.getTypeAbonnement());
            ModeFormationText.setText(Eleve.getModeDeFormation());
            if(Eleve.getPhoneNumber()!=null)
            {
                PhoneText.setText(Eleve.getPhoneNumber());
            }
            if(Eleve.getFacebookPage()!=null)
            {
                FbText.setText(Eleve.getFacebookPage());
            }

            if(Eleve.getTwitterPage()!=null)
            {
                TwitterText.setText(Eleve.getTwitterPage());
            }


        }

        logOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "vous allez vous d??connecter", Toast.LENGTH_SHORT).show();
                getActivity().finish();
            }
        });



        return root;
    }


}
