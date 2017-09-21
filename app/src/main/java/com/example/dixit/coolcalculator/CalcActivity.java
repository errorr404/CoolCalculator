package com.example.dixit.coolcalculator;

import android.app.Activity;
import android.media.Image;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class CalcActivity extends Activity {
     TextView resultview;
    public enum Operation{
        ADD, SUBSTRACT, MULTIPLY, DIVIDE, EQUAL
    }
     String runningnumber="";
    String leftview="";
    String rightview="";
    Operation currentOperation;
    int result=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);
        Button one=(Button)findViewById(R.id.one);
        Button two=(Button)findViewById(R.id.two);
        Button three=(Button)findViewById(R.id.three);
        Button four=(Button)findViewById(R.id.four);
        Button five=(Button)findViewById(R.id.five);
        Button six=(Button)findViewById(R.id.six);
        Button seven=(Button)findViewById(R.id.seven);
        Button eight=(Button)findViewById(R.id.eight);
        Button nine=(Button)findViewById(R.id.nine);
        Button zero=(Button)findViewById(R.id.zero);
        ImageButton res=(ImageButton)findViewById(R.id.calcbtn);
        ImageButton add=(ImageButton)findViewById(R.id.add);
        ImageButton subs=(ImageButton)findViewById(R.id.subs);
        ImageButton div=(ImageButton)findViewById(R.id.div);
        ImageButton mul=(ImageButton)findViewById(R.id.mul);
        Button clear=(Button)findViewById(R.id.clear);
        resultview=(TextView)findViewById(R.id.resultview);
        resultview.setText("0");

        one.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                numberPressed(1);
            }

        });
        two.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                numberPressed(2);
            }

        });
        three.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                numberPressed(3);
            }

        });
        four.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                numberPressed(4);
            }

        });
        five.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                numberPressed(5);
            }

        });
        six.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                numberPressed(6);
            }

        });
        seven.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                numberPressed(7);
            }

        });
        eight.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                numberPressed(8);
            }

        });
        nine.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                numberPressed(9);
            }

        });
        zero.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                numberPressed(0);
            }

        });
        add.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
             pressOperation(Operation.ADD);
            }

        });
        subs.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
pressOperation(Operation.SUBSTRACT);
            }

        });
        mul.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
pressOperation(Operation.MULTIPLY);
            }

        });
        div.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
pressOperation(Operation.DIVIDE);
            }

        });
        clear.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
              leftview="";
                rightview="";
                result=0;
                currentOperation=null;
                resultview.setText("0");
            }

        });
         res.setOnClickListener(new View.OnClickListener()
         {
             @Override
             public void onClick(View v)
             {
              pressOperation(Operation.EQUAL);
             }

         });

    }
    void pressOperation(Operation opeartion)
    {

        if(currentOperation !=null)
        {
            if(runningnumber != null)
            {
               rightview=runningnumber;
                runningnumber="";
                switch (currentOperation)
                {
                    case ADD:
                          result=Integer.parseInt(leftview)+Integer.parseInt(rightview);
                        break;
                    case SUBSTRACT:
                        result=Integer.parseInt(leftview)-Integer.parseInt(rightview);
                        break;
                    case MULTIPLY:
                        result=Integer.parseInt(leftview)*Integer.parseInt(rightview);
                        break;
                    case DIVIDE:
                        result=Integer.parseInt(leftview)/Integer.parseInt(rightview);
                        break;
                }
                leftview=String.valueOf(result);
                resultview.setText(leftview);
            }
        }
        else
        {
            leftview=runningnumber;
            runningnumber="";
        }
        currentOperation=opeartion;
    }
   void numberPressed(int number)
   {
       runningnumber+=String.valueOf(number);
       resultview.setText(runningnumber);
   }
}
