package com.magicdate.pesometer.DataBaseHandlers;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FireBaseModel {

    protected DatabaseReference databaseReference;

    public FireBaseModel() {
        databaseReference = FirebaseDatabase.getInstance().getReference();
    }

}
