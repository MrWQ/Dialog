package com.example.administrator.dialog;

import android.content.DialogInterface;
import android.preference.DialogPreference;
import android.preference.EditTextPreference;
import android.preference.Preference;
import android.support.annotation.MainThread;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class testdialog extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testdialog);

        Button button = (Button) findViewById(R.id.tishi);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(testdialog.this);
                builder.setMessage("userid:abc   password:123").setTitle("提示");
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(testdialog.this, "用户按下了确定", Toast.LENGTH_LONG).show();
                    }
                });
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(testdialog.this, "用户按下了取消", Toast.LENGTH_LONG).show();
                    }
                });
                builder.show();
            }
        });


        Button button_longin = (Button) findViewById(R.id.denglu);
        button_longin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder_login = new AlertDialog.Builder(testdialog.this);
                LayoutInflater inflater = getLayoutInflater();
                final View view1 = inflater.inflate(R.layout.dialong, null);
                builder_login.setView(view1).setTitle("login")
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                EditText userid = (EditText) view1.findViewById(R.id.edittextuserid);
                                EditText password = (EditText) view1.findViewById(R.id.edittextpassword);

                                String useridstring = userid.getText().toString().trim();
                                String passwordstring = password.getText().toString().trim();
                                String user = getString(R.string.userid);
                                String prd = getString(R.string.password);

                                if (useridstring.equals(user)) {
                                    if (passwordstring.equals(prd)) {
                                        Toast.makeText(testdialog.this, "登录成功", Toast.LENGTH_LONG).show();
                                    } else {
                                        Toast.makeText(testdialog.this, "密码错误", Toast.LENGTH_LONG).show();
                                    }
                                } else {
                                    Toast.makeText(testdialog.this, "用户名不存在", Toast.LENGTH_LONG).show();
                                }
                            }

                        })
                        .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(testdialog.this, "您点击了取消", Toast.LENGTH_LONG).show();
                            }
                        });
                builder_login.show();

            }
        });

    }
}
