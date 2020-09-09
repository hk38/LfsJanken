package lit.amida.lfsjanken

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val GU = 0
    val CHOKI = 1
    val PA = 2

    var numWin = 0
    var numDraw = 0
    var numLose = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonGu.setOnClickListener {
            imagePlayer.setImageResource(R.drawable.gu)
            jud(GU)
        }

        buttonChoki.setOnClickListener {
            imagePlayer.setImageResource(R.drawable.choki)
            jud(CHOKI)
        }

        buttonPa.setOnClickListener {
            imagePlayer.setImageResource(R.drawable.pa)
            jud(PA)
        }
    }

    private fun jud(player:Int){
        val cpu = (0..2).random()

        when(cpu){
            GU -> {
                imageCPU.setImageResource(R.drawable.gu)
                when(player){
                    GU -> draw()
                    CHOKI -> lose()
                    PA -> win()
                }
            }
            CHOKI ->{
                imageCPU.setImageResource(R.drawable.choki)
                when(player){
                    GU -> win()
                    CHOKI -> draw()
                    PA -> lose()
                }
            }
            PA ->{
                imageCPU.setImageResource(R.drawable.pa)
                when(player){
                    GU -> lose()
                    CHOKI -> win()
                    PA -> draw()
                }
            }
        }
    }

    private fun draw(){
        textResult.setTextColor(Color.parseColor("#00A000"))
        numDraw++
        textResult.text = "${numWin}勝${numLose}敗${numDraw}分"
    }

    private fun win(){
        textResult.setTextColor(Color.parseColor("#A00000"))
        numWin++
        textResult.text = "${numWin}勝${numLose}敗${numDraw}分"
    }

    private fun lose(){
        textResult.setTextColor(Color.parseColor("#0000A0"))
        numLose++
        textResult.text = "${numWin}勝${numLose}敗${numDraw}分"
    }
}