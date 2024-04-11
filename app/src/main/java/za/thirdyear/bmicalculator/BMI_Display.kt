package za.thirdyear.bmicalculator

import android.content.SharedPreferences
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class BMI_Display : AppCompatActivity() {
    private lateinit var bmiValueText : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bmi_display)

        /******Hooks******/
        bmiValueText = findViewById(R.id.txtBMI)
        val WEIGHT_NAME = "weightTextName"
        val HEIGHT_NAME = "heightTextName"

        /******Get Shared Preference******/
        val weightpreference : SharedPreferences = getSharedPreferences(WEIGHT_NAME, MODE_PRIVATE)
        val heightpreference : SharedPreferences = getSharedPreferences(HEIGHT_NAME, MODE_PRIVATE)


        /******Calculate BMI******/
        //Formula: BMI = weight(lbs) / height(inches)^2
        val weight = weightpreference.getFloat(WEIGHT_NAME, 0.0F)
        val height = heightpreference.getFloat(HEIGHT_NAME, 0.0F)
        bmiValueText.text = height.toString()
        val bmi = ((weight / (height * height)) * 703)
        bmiValueText.text = String.format("%.1f", bmi)



    }
}