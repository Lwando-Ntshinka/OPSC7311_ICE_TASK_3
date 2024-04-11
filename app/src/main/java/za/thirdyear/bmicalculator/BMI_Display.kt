package za.thirdyear.bmicalculator

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.widget.TextView
import java.util.prefs.Preferences

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
        var weightpreference : SharedPreferences = getSharedPreferences(WEIGHT_NAME, MODE_PRIVATE)
        var heightpreference : SharedPreferences = getSharedPreferences(HEIGHT_NAME, MODE_PRIVATE)


        /******Calculate BMI******/
        //Formula: BMI = weight(lbs) / height(inches)^2
        var weightString = weightpreference.getString("WEIGHT_NAME", "")
        var heightString = heightpreference.getString("HEIGHT_NAME", "")

        bmiValueText.text = weightString

        //val weight : Double = weightString?.toDouble() ?: 0.0
        //val height : Double = heightString?.toDouble() ?:0.0

        //var bmi = weight / height * height
//
        //bmiValueText.text = bmi.toString()



    }
}