package za.thirdyear.bmicalculator

import android.content.Intent
import android.content.SharedPreferences
import android.health.connect.datatypes.units.Length
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton



class MainActivity : AppCompatActivity() {

    /******Variable Declaration******/
    lateinit var appCompatButton: AppCompatButton
    lateinit  var weightText : EditText
    lateinit var heightText : EditText





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /******Hooks*****/
        appCompatButton = findViewById(R.id.btnCompute)
        weightText = findViewById(R.id.txtWeight)
        heightText  = findViewById(R.id.txtHeight)

        /******Declaring Keys******/
        val WEIGHT_NAME : String = "weightTextName"
        val HEIGHT_NAME : String = "heightTextName"


        /***Create shared preference object****/
        var sharedPreferrenceWeight : SharedPreferences =
            getSharedPreferences(WEIGHT_NAME, MODE_PRIVATE)
        var sharedPreferrenceHeight : SharedPreferences =
            getSharedPreferences(HEIGHT_NAME, MODE_PRIVATE)




    appCompatButton.setOnClickListener(View.OnClickListener
    {

        /******Editor******/
                val editorWeight: SharedPreferences.Editor = sharedPreferrenceWeight.edit()
                val editorHeight: SharedPreferences.Editor = sharedPreferrenceHeight.edit()

                editorWeight.putFloat(WEIGHT_NAME, weightText.text.toString().toFloat())
                editorHeight.putFloat(HEIGHT_NAME, heightText.text.toString().toFloat())

                // Apply changes to SharedPreferences
                editorWeight.apply()
                editorHeight.apply()
                editorWeight.commit()
                editorHeight.commit()
            // Start BMI_Display activity
            val bmiDisplayActivity = Intent(this, BMI_Display::class.java)
            startActivity(bmiDisplayActivity)

    })


    }
}