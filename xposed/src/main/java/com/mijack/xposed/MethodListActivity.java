package com.mijack.xposed;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Mi&Jack
 */
public class MethodListActivity extends Activity implements AdapterView.OnItemLongClickListener {
    public static final String APP_NAME = "APP_NAME";
    ListView listView;
    StringDataAdapter methodNameAdapter = new StringDataAdapter();
    private View addView;
    private View removeView;

    private String appName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_method_list);
        appName = getIntent().getStringExtra(APP_NAME);
        setTitle(appName);

        SharedPreferences sharedPreferences = getSharedPreferences();
        Set<String> appList = sharedPreferences.getStringSet(appName, new HashSet<>());
        listView = findViewById(R.id.method_list);

        methodNameAdapter.setData(appList);
        listView.setAdapter(methodNameAdapter);
        listView.setOnItemLongClickListener(this);
    }

    private SharedPreferences getSharedPreferences() {
        String preferenceName = XposedUtils.getPreferenceName();
        return getSharedPreferences(preferenceName, Context.MODE_WORLD_READABLE);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_add_app:
                showAddMethodDialog();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void showAddMethodDialog() {
        if (addView == null) {
            addView = LayoutInflater.from(this).inflate(R.layout.dialog_add_method, null);
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("添加方法名")
                .setView(addView)
                .setNegativeButton("添加", (dialog, which) -> {
                    if (addView == null) {
                        return;
                    }
                    EditText editText = addView.findViewById(R.id.editTextApp);
                    if (TextUtils.isEmpty(editText.getText())) {
                        Toast.makeText(MethodListActivity.this, "请输入方法名", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    List<String> methodNames = new ArrayList<>();
                    for (String methodName : editText.getText().toString().split(";")) {
                        methodNames.add(methodName);
                    }
                    addMethodNames(methodNames);
                })
                .setPositiveButton("取消", (dialog, which) -> {
                    return;

                })
                .create().show();
    }

    private void addMethodNames(List<String> methodNames) {
        methodNameAdapter.addDatas(methodNames);
        SharedPreferences sharedPreferences = getSharedPreferences();
        Set<String> methodNameList = sharedPreferences.getStringSet(appName, new HashSet<String>());
        methodNameList.addAll(methodNames);
        sharedPreferences.edit().putStringSet(appName, methodNameList).apply();
    }

    private void removeMethodName(String methodName) {
        methodNameAdapter.removeData(methodName);
        SharedPreferences sharedPreferences = getSharedPreferences();
        Set<String> methodNameList = sharedPreferences.getStringSet(appName, new HashSet<String>());
        methodNameList.remove(methodName);
        sharedPreferences.edit().putStringSet(appName, methodNameList).apply();
    }

    public Context getContext() {
        return this;
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        // remove
        if (removeView == null) {
            removeView = LayoutInflater.from(this).inflate(R.layout.dialog_remove_method, null);
        }
        String methodName = methodNameAdapter.getItem(position);
        TextView textView = removeView.findViewById(R.id.textApp);
        textView.setText(methodName);

        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("移除方法名")
                .setView(removeView)
                .setNegativeButton("移除", (dialog, which) -> removeMethodName(methodName))
                .setPositiveButton("取消", (DialogInterface dialog, int which) -> {
                })
                .create().show();
        return true;
    }
}
