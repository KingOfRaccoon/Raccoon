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
        one.setNMR(1255, true)
        two.setNMR(1234, false)
    }

}

class Player : RatingManager() {


}


fun jf (Rating1:RatingManager) {
    Rating1.setNMR()
    println(Rating1.NewMyRating)

}


open class RatingManager {
    var MyRating:Float = 0f
    var K:Int = 0
    var NewMyRating:Float = 0f
    var WaitingResult:Float = 0f

    fun setNMR(ratingEnemy : Float, resulf : Int){

        WaitingResult = 1/(1 + 10 *((ratingEnemy - MyRating)/400))
        AccountK()
        NewMyRating = MyRating + K *(resulf - WaitingResult)
    }

    fun AccountK() {
        if (MyRating > 2400f)
            K = 10
        else K = 40

    }
}
