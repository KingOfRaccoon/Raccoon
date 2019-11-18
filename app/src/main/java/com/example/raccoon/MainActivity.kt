package com.example.raccoon

import android.accounts.Account
import android.media.Rating
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {


    var one = Player()
    var two = Player()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        one.setNMR(1300f, 1)
        two.setNMR(1300f, 0)
        one.df()
        two.df()
    }

}

class Player : RatingManager() {
    override var MyRating: Float = 2000f

    fun df(){
        Log.d("TEST",MyRating.toString() )
    }
}


open class RatingManager {
   open var MyRating:Float = 0f
    var K:Int = 0
    var WaitingResult:Float = 0f

    fun setNMR(ratingEnemy : Float, resulf : Int){

        WaitingResult = 1/(1 + 10 *((ratingEnemy - MyRating)/400))
        AccountK()
        MyRating = MyRating + K *(resulf - WaitingResult)
    }

    fun AccountK() {
        if (MyRating > 2400f)
            K = 10
        else K = 40

    }
}
