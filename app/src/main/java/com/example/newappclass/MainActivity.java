package com.example.newappclass;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<String> coffeeList;
    Button btn;
    private int FW_quantity;
    private int c_quantity;
    private int quantity;
    String paymentType;
    String result;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        coffeeList = new ArrayList<String>();
        quantity =1;
        FW_quantity=0;
        c_quantity=0;
        flatWhiteQunatity();



    }

    public void UpdateCoffee(View v)
    {
        CheckBox coffeeCheckBox = (CheckBox) v;
        if(coffeeCheckBox.isChecked())
        {
            coffeeList.add(coffeeCheckBox.getText().toString());
        }
        else
        {
            coffeeList.remove(coffeeCheckBox.getText().toString());
        }
    }
   // public void updateQuantity()
   // {
   //     TextView QuantityText = (TextView) findViewById(R.id.quantityText);
    //    QuantityText.setText(Integer.toString(quantity));
   // }


    public void flatWhiteQunatity()
    {
        TextView QuantityText = (TextView) findViewById(R.id.FlatWhiteQty);
        if (FW_quantity<0)
        {
            FW_quantity=0;
        }
        QuantityText.setText(Integer.toString(FW_quantity));
    }
    public void increaseFW (View v)
    {
        FW_quantity++;
        flatWhiteQunatity();
    }

    public void decreaseFW (View v)
    {
        FW_quantity--;
        flatWhiteQunatity();
    }

    public void CappuccinoQunatity()
    {
        TextView QuantityText = (TextView) findViewById(R.id.CapQuantity);
        if (c_quantity<0)
        {
            c_quantity=0;
        }
        QuantityText.setText(Integer.toString(c_quantity));
    }
    public void increaseC (View v)
    {
        c_quantity++;
        CappuccinoQunatity();
    }

    public void decreaseC (View v)
    {
        c_quantity--;
        CappuccinoQunatity();
    }




 //    public void IncreaseQuantity(View v)
    // {
   //      quantity++;
   //      updateQuantity();
   //  }
  //  public void DecreaseQuantity(View v)
   // {
   //     quantity--;
   //     updateQuantity();
  //  }
    public void PaymentMethod(View v)
    {
        boolean checked=((RadioButton)v).isChecked();
        switch(v.getId())
        {
            case R.id.card:
                if(checked)
                {
                    paymentType="card";
                    break;
                }

            case R.id.cash:
                if(checked)
                {
                    paymentType="card";
                    break;
                }
        }
    }

    public void submitOrder(View v)
    {
        EditText priceEditText = (EditText) findViewById(R.id.price);
        EditText nameEditText = (EditText) findViewById(R.id.NameText);
        String name=nameEditText.getText().toString();
        if(!priceEditText.getText().toString().isEmpty())
        {
            double price = Double.valueOf(priceEditText.getText().toString());
            double totalPrice = price*quantity;
            result = "Hello "+name+" Thanks for your order\n";
            result+="The total price is "+ Double.toString(totalPrice)+"\n";

            if(!coffeeList.isEmpty())
            {
                result+="The coffees are:";
                for (String topping:coffeeList)
                    result+=topping +"\n";

            }

            result += "\n"+"Your payment method is "+paymentType;
            TextView resultText = (TextView) findViewById(R.id.info_text);
            resultText.setText(result);

        }

    }


}