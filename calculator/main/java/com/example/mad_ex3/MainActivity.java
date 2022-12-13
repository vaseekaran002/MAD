package com.example.mad_ex3;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputConnection;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    int flag=0,op=0,pt=0,oprnds=0;
    double num1,num2;
    String cur="";

    Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b0,badd,bsub,bmul,bdiv,bmod,bop,bcp,bac,bpt,beq;
    EditText history,expr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=(Button)findViewById(R.id.b1); b2=(Button)findViewById(R.id.b2);
        b3=(Button)findViewById(R.id.b3); b4=(Button)findViewById(R.id.b4);
        b5=(Button)findViewById(R.id.b5); b6=(Button)findViewById(R.id.b6);
        b7=(Button)findViewById(R.id.b7); b8=(Button)findViewById(R.id.b8);
        b9=(Button)findViewById(R.id.b9); b0=(Button)findViewById(R.id.b0);
        badd=(Button)findViewById(R.id.add); bsub=(Button)findViewById(R.id.sub);
        bmul=(Button)findViewById(R.id.mul); bdiv=(Button)findViewById(R.id.div);
        bmod=(Button)findViewById(R.id.mod); bop=(Button)findViewById(R.id.op);
        bcp=(Button)findViewById(R.id.cp); bac=(Button)findViewById(R.id.ac);
        bpt=(Button)findViewById(R.id.pt); beq=(Button)findViewById(R.id.eq);
        history=(EditText)findViewById(R.id.history);
        expr=(EditText)findViewById(R.id.expression);


        b0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expr.setText(expr.getText()+"0");
                cur=cur+"0";
                if(flag==0) flag=1;
                if(flag==2) flag=3;
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expr.setText(expr.getText()+"1");
                cur=cur+"1";
                if(flag==0) flag=1;
                if(flag==2) flag=3;
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expr.setText(expr.getText()+"2");
                cur=cur+"2";
                if(flag==0) flag=1;
                if(flag==2) flag=3;
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expr.setText(expr.getText()+"3");
                cur=cur+"3";
                if(flag==0) flag=1;
                if(flag==2) flag=3;
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expr.setText(expr.getText()+"4");
                cur=cur+"4";
                if(flag==0) flag=1;
                if(flag==2) flag=3;
            }
        });

        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expr.setText(expr.getText()+"5");
                cur=cur+"5";
                if(flag==0) flag=1;
                if(flag==2) flag=3;
            }
        });

        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expr.setText(expr.getText()+"6");
                cur=cur+"6";
                if(flag==0) flag=1;
                if(flag==2) flag=3;
            }
        });

        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expr.setText(expr.getText()+"7");
                cur=cur+"7";
                if(flag==0) flag=1;
                if(flag==2) flag=3;
            }
        });

        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expr.setText(expr.getText()+"8");
                cur=cur+"8";
                if(flag==0) flag=1;
                if(flag==2) flag=3;
            }
        });

        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expr.setText(expr.getText()+"9");
                cur=cur+"9";
                if(flag==0) flag=1;
                if(flag==2) flag=3;
            }
        });

        bpt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(cur.indexOf('.')==-1) {
                    expr.setText(expr.getText()+".");
                    cur=cur+".";
                    if(flag==0) flag=1;
                    if(flag==2) flag=3;
                }
            }
        });

        bop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(expr.getText().length()>0 && !Character.isDigit(expr.getText().charAt(expr.getText().length()-1))){
                    expr.setText(expr.getText()+"(");
                    op++;
                }
            }
        });

        bcp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(expr.getText().length()>0 && Character.isDigit(expr.getText().charAt(expr.getText().length()-1)) && op>0){
                    expr.setText(expr.getText()+")");
                    op--;
                }
            }
        });

        badd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(flag==1) {
                    num1=Double.parseDouble(cur);
                    cur="";
                    history.setText(expr.getText()+"+");
                    expr.setText("");
                    flag=2;
                    op=1;
                }
            }
        });

        bsub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(flag==1) {
                    num1=Double.parseDouble(cur);
                    cur="";
                    history.setText(expr.getText()+"-");
                    expr.setText("");
                    flag=2;
                    op=2;
                }
            }
        });

        bmul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(flag==1) {
                    num1 = Double.parseDouble(cur);
                    cur = "";
                    history.setText(expr.getText() + "*");
                    expr.setText("");
                    flag = 2;
                    op=3;
                }
            }
        });

        bdiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(flag==1) {
                    num1=Double.parseDouble(cur);
                    cur="";
                    history.setText(expr.getText()+"/");
                    expr.setText("");
                    flag=2;
                    op=4;
                }
            }
        });

        bmod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(flag==1) {
                    num1=Double.parseDouble(cur);
                    num1=(int)num1;
                    cur="";
                    history.setText(expr.getText()+"%");
                    expr.setText("");
                    flag=2;
                    op=5;
                }
            }
        });

        bac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expr.setText("");
                history.setText("");
                flag=0;
                num1=0;
                num2=0;
                cur="";
                op=0;
                pt=0;
            }
        });

        beq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(flag==3) {
                    history.setText(history.getText()+""+expr.getText());
                    num2=Double.parseDouble(cur);
                    double val=0;
                    if(op==1) {
                        val=num1+num2;
                    } else if(op==2) {
                        val=num1-num2;
                    } else if(op==3) {
                        val=num1*num2;
                    } else if(op==4) {
                        val=num1/num2;
                    } else if(op==5) {
                        val=(int)num1%(int)num2;
                    }
                    val=Math.round(val*100.0)/100.0;
                    expr.setText(""+val);
                    cur=""+val;
                    flag=1;
                }
            }
        });
    }
}