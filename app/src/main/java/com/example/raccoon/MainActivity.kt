package com.example.raccoon

import android.accounts.Account
import android.media.Rating
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Math.*

class MainActivity : AppCompatActivity() {


    var one = Player()
    var two = Player()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        one.counterRating = NewRankGliko()
        one.set1(200.0, 1400f, 1500)
        two.counterRating = NewRankElo()
        two.set1(200.0, 1400f, 1500)
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

    fun set1 ( RDold :Double,ratingEnemy : Float, r : Int){
        MyRating = counterRating.setNMR(MyRating, ratingEnemy, r)
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
        if (WaitingResult > 0.92)
            WaitingResult = 0.92
        if (WaitingResult < 0.08)
            WaitingResult = 0.08
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
        if (WaitingResult < 0.1)
            WaitingResult = 0.1
        AccountK(MyRating)
        return MyRating + K *(resulf - WaitingResult)
    }

    fun AccountK(MyRating:Double) {
        if (MyRating > 2400f)
            K = 10
        else K = 40
    }
}
class NewRankGliko:NewRank(){
    override fun setNMR( RDold :Double,s:Float):Double {

        var rN:Double = 0.0
        var j:Int = 1
        var Sum:Double = 0.0
        var m:Int = 0 //Количество игр
        var t:Int = 0 //Количество несыгранных периодов
        var q:Double = log(10.0)/400
        var PI: Double = 3.14159
        var d:Double = 0.0
var r
        var g : Double = 0.0

        var s : Double = 0.0

        var E : Double = 0.0

        var RD = min(sqrt (RDold * RDold + 50 * 50 * t ).toInt(), 350)

        g =1/ sqrt(1 + (3 * q * q) * (RD * RD)/ pow(PI, 2.0) )
        var sum2 = g * (s - E)
        var Sum2 = g * g * E * (s - E)
        E = 1 / (1 + pow(10.0, (-g * (r-ratingEnemy)))/400 )
        d  = sqrt(pow( (q * q * Sum2) ,-1.0))
        rN = r + q / ( (1 / RD * RD)+(1 / d * d ) ) * sum2

return rN
    }
    }