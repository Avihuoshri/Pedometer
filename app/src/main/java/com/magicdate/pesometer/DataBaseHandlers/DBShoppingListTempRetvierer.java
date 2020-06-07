package com.magicdate.pesometer.DataBaseHandlers;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class DBShoppingListTempRetvierer extends FireBaseModel
{
    private LinkedList<String> shopping_lst;

    public DBShoppingListTempRetvierer() {
        shopping_lst = new LinkedList<>();
    }

    LinkedList<String> getProductsFromDb(String date)
    {

        databaseReference.child("Users").child("This line should be = <user name> ").child("<user name>'s shopping history").child(date);
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists())
                {
                    for (DataSnapshot snapshot:dataSnapshot.getChildren())
                    {
                            String item = snapshot.getKey() + snapshot.getValue(String.class);
                            shopping_lst.add(item);
                    }
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        return shopping_lst;
    }

    public static DatabaseReference checkRF(String date)
    {
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference()
                .child("Users").child("This line should be = <user name> ").child("<user name>'s shopping history").child(date);
        return reference;

    }
    public static LinkedList<String> getProductsFromDb(DatabaseReference ref,String date)
    {
        final LinkedList<String> prods = new LinkedList<String>();
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()){
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        String item = snapshot.getKey() + snapshot.getValue(String.class);
                        prods.add(item);
                    }
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        return prods;
    }

    public static void main(String... a)
    {
        String shoping = "ShoppingList : 20:05:2020 17:55:40";
        DatabaseReference reference = DBShoppingListTempRetvierer.checkRF(shoping);
        LinkedList<String> strings = DBShoppingListTempRetvierer.getProductsFromDb(reference,shoping);
        for (String s : strings)
        {
            System.out.println(s);
        }


    }


}
