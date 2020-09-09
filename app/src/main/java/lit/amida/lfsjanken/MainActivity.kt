package lit.amida.lfsjanken

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val GU = 0
    val CHOKI = 1
    val PA = 2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonGu.setOnClickListener {
            textPlayer.text = "あなたの手はグーです"
            jud(GU)
        }

        buttonChoki.setOnClickListener {
            textPlayer.text = "あなたの手はチョキです"
            jud(CHOKI)
        }

        buttonPa.setOnClickListener {
            textPlayer.text = "あなたの手はパーです"
            jud(PA)
        }
    }

    private fun jud(player:Int){
        val cpu = (0..2).random()
        Log.d("cpu", "$cpu")

        when(cpu){
            GU -> {
                textCPU.text = "相手の手はグーです"
                when(player){
                    GU -> draw()
                    CHOKI -> lose()
                    PA -> win()
                }
            }
            CHOKI ->{
                textCPU.text = "相手の手はチョキです"
                when(player){
                    GU -> win()
                    CHOKI -> draw()
                    PA -> lose()
                }
            }
            PA ->{
                textCPU.text = "相手の手はパーです"
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
        textResult.text = "引き分けです"
    }

    private fun win(){
        textResult.setTextColor(Color.parseColor("#A00000"))
        textResult.text = "あなたの勝ちです"
    }

    private fun lose(){
        textResult.setTextColor(Color.parseColor("#0000A0"))
        textResult.text = "あなたの負けです"
    }
}