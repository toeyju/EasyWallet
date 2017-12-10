package com.example.easywallet;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.example.easywallet.Adapter.aListAdapter;
import com.example.easywallet.db.DbHelper;
import com.example.easywallet.model.Money;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView mListView;

    private ArrayList<Money> aList = new ArrayList<>();
    private aListAdapter mAdapter;

    private DbHelper mHelper;
    private SQLiteDatabase mDatabase;
    Button income , expense;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        income = findViewById(R.id.income_button);
        expense = findViewById(R.id.expense_button);

        mHelper = new DbHelper(this);
        mDatabase = mHelper.getReadableDatabase();


            Cursor cursor = mDatabase.query(
                    DbHelper.TABLE_NAME,
                null,
                null,
                null,
                null,
                null,
                null
        );

            aList.clear();

        while (cursor.moveToNext()) {
            int id = cursor.getInt(cursor.getColumnIndex(DbHelper.COLL_ID));
            String picture = cursor.getString(cursor.getColumnIndex(DbHelper.COLL_PICTURE));
            String detail = cursor.getString(cursor.getColumnIndex(DbHelper.COLL_DETAILS));
            int money = cursor.getInt(cursor.getColumnIndex(DbHelper.COLL_MONEY));

            Money item = new Money(id, picture, detail, money);
            //aListAdapter.add(item);
        }

            mListView = (ListView) findViewById(R.id.list_view);

        mAdapter = new aListAdapter(
                this,
                R.layout.item,
                aList
        );

            mListView.setAdapter(mAdapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);

                String[] items = new String[]{"YES", "NO"};

                dialog.setItems(items, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if (i == 0) {
                            Money item = aList.get(i);
                            int phoneId = item.id;

                            mAdapter.notifyDataSetChanged();

                        } else if (i == 1) {
                            finish();
                        }
                    }
                });
                dialog.show();
            }
        });

        income.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(MainActivity.this,Income.class);
                startActivity(in);
            }
        });

        expense.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ex = new Intent(MainActivity.this, Expense.class);
                startActivity(ex);
            }
        });

    }


}
