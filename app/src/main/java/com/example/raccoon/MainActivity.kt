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
        one.counterRating = NewRankOther()
        one.set1(1300f, 1)

        two.set1(1300f, 0)
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
    var counterRating : NewRank = NewRankElo()

    fun set1 ( ratingEnemy : Float, resulf : Int){
        MyRating = counterRating.setNMR(MyRating, ratingEnemy, resulf)
    }

}



abstract class NewRank{
    var K:Int = 0
    abstract fun setNMR( MyRating :Double,ratingEnemy : Float, resulf : Int):Double
}



class NewRankElo:NewRank(){
    override fun setNMR( MyRating :Double,ratingEnemy : Float, resulf : Int):Double{
        var WaitingResult:Double = 0.0
        WaitingResult = 1/(1 +  pow( 10.0 ,(ratingEnemy - MyRating)/400))
        if (WaitingResult > 0.9)
            WaitingResult = 0.9
        AccountK(MyRating)
        return MyRating + K *(resulf - WaitingResult)
    }

    fun AccountK(MyRating:Double) {
        if (MyRating > 2400f)
            K = 10
        else K = 40
    }
}
class NewRankOther:NewRank(){
    override fun setNMR( MyRating :Double,ratingEnemy : Float, resulf : Int):Double{
        var WaitingResult:Double = 0.0
        WaitingResult = 1/(1 +  pow( 1.0 ,(ratingEnemy - MyRating)/400))
        if (WaitingResult > 0.9)
            WaitingResult = 0.9
        AccountK(MyRating)
        return MyRating + K *(resulf - WaitingResult)
    }

    fun AccountK(MyRating:Double) {
        if (MyRating > 2400f)
            K = 10
        else K = 40
    }
}