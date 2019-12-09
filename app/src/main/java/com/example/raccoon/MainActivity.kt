package com.example.raccoon

import android.accounts.Account
import android.media.Rating
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Math.*

class MainActivity : AppCompatActivity() {
    fun fhgkk():Double {
        var j: Int = 1
        var Sum: Double = 0.0
        var m: Int = 0 //Количество игр
        var t: Int = 0 //Количество несыгранных периодов
        var q: Double = log(10.0) / 400
        var PI: Double = 3.14159
        var RDold:Double=200.0
        var RD = min(sqrt(RDold * RDold + 50 * 50 * t).toInt(), 350)
        var ratingEnemy = 1400
        var r =1500
        var resulf =1
        var RD1 = 30
        var g: Double  = 1 / sqrt(1 + (3 * q * q) * (RD1 * RD1) / pow(PI, 2.0))
        Log.d("Test", g.toString())
        var E: Double = 1 / (1 + pow(10.0, (-g * (r - ratingEnemy)) / 400))
        Log.d("Test", E.toString())
        var sum2 = g * (resulf - E)
        Log.d("Test", sum2.toString())
        var Sum2 = g * g * E * (1 - E)
        Log.d("Test", Sum2.toString())
        var d: Double  = sqrt(1/(q * q * Sum2))
        Log.d("Test", d.toString())
        var rN: Double = r + (q / ((1 / RD * RD) + (1 / d * d)) * sum2)
        Log.d("Test", rN.toString())
        return rN
    }

    var one = Player()
    var two = Player()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        one.counterRating = NewRankGliko()
        one.set1(200.0, 1400f, 1500, 0)
        two.counterRating = NewRankGliko()
        two.set1(200.0, 1400f, 1500, 1)
f.setText(fhgkk().toString())
    }

}


class Player : RatingManager() {
    override var MyRating: Double = 2000.0
    fun df() = MyRating.toString()
}


open class RatingManager {
   open var MyRating:Double = 0.0
    var counterRating : NewRank = NewRankElo()

    fun set1 ( RDold :Double,ratingEnemy : Float, r : Int, resulf: Int){
        MyRating = counterRating.setNMR(MyRating, ratingEnemy, r, resulf)
    }

}



abstract class NewRank{
    var K:Int = 0
    abstract fun setNMR( MyRating :Double,ratingEnemy : Float,r: Int, resulf : Int):Double


}



class NewRankElo:NewRank(){
    override fun setNMR( MyRating :Double,ratingEnemy : Float,r: Int, resulf : Int):Double{
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
    override fun setNMR( MyRating :Double,ratingEnemy : Float,r: Int, resulf : Int):Double{
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
    override fun setNMR(RDold: Double, ratingEnemy: Float, r: Int, resulf: Int): Double {

        var rN:Double = 0.0
        var j:Int = 1
        var Sum:Double = 0.0
        var m:Int = 0 //Количество игр
        var t:Int = 0 //Количество несыгранных периодов
        var q:Double = log(10.0)/400
        var PI: Double = 3.14159
        var d:Double = 0.0
        var g : Double = 0.0
        var E : Double = 0.0

        var RD = min(sqrt (RDold * RDold + 50 * 50 * t ).toInt(), 350)

        E = 1 / (1 + pow(10.0, (-g * (r-ratingEnemy)))/400 )
        g =1/ sqrt(1 + (3 * q * q) * (RD * RD)/ pow(PI, 2.0) )
        var sum2 = g * (resulf - E)
        var Sum2 = g * g * E * (resulf - E)

        d  = sqrt(pow( (q * q * Sum2) ,-1.0))
        rN = r + q / ( (1 / RD * RD)+(1 / d * d ) ) * sum2

return rN
    }
    }