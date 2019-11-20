package com.example.raccoon

import android.accounts.Account
import android.media.Rating
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Math.pow

class MainActivity : AppCompatActivity() {


    var one = Player()
    var two = Player()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        one.setNMR(1300f, 1)
        two.setNMR(1300f, 0)
        f.setText(one.df())
        d.setText(two.df())
    }

}


class Player : RatingManager() {
    override var MyRating: Double = 2000.0

    fun df() = MyRating.toString()
}


open class RatingManager {
   open var MyRating:Double = 0.0
    var K:Int = 0
    var WaitingResult:Double = 0.0

    fun setNMR(ratingEnemy : Float, resulf : Int){

        WaitingResult = 1/(1 +  pow( 10.0 ,(ratingEnemy - MyRating)/400))
        AccountK()
        MyRating = MyRating + K *(resulf - WaitingResult)
    }

    fun AccountK() {
        if (MyRating > 2400f)
            K = 10
        else K = 40

    }
}
