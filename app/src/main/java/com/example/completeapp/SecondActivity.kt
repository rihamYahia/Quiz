package com.example.completeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_second.*
import java.util.*

class SecondActivity : AppCompatActivity() {
    var val_ques : Array<String>?= null
    var val_ans : Array<String>?= null
    var index : Int ?= null
    var Ttos : TextToSpeech ? = null
    var res:Int ?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val_ques = resources.getStringArray(R.array.quiz)
        val_ans = resources.getStringArray(R.array.quiz_answer)
        index=0
        qustionID.text = "${val_ques!![index!!]}"
        qustion_number.text = "${index!! + 1}"
        qustion_count.text = "/ ${val_ques!!.size}"

        Ttos = TextToSpeech(this,object:TextToSpeech.OnInitListener{
            override fun onInit(status: Int) {
                res = Ttos!!.setLanguage(Locale.ENGLISH)
            }

        })

        voice.setOnClickListener{
            if(res == TextToSpeech.LANG_NOT_SUPPORTED || res == TextToSpeech.LANG_MISSING_DATA)
            {
                Toast.makeText(this,"LANG_NOT_SUPPORTED or LANG_MISSING_DATA",Toast.LENGTH_LONG).show()
            }else{
                Ttos!!.speak(qustionID.text,TextToSpeech.QUEUE_FLUSH,null,null)
            }

        }

        back.setOnClickListener{
            try{
                answerID.text = "click answer to show answer of qustion"
                index = index!! -1
                qustionID.text = "${val_ques!![index!!]}"
                qustion_number.text = "${index!! + 1}"

            }catch(e : ArrayIndexOutOfBoundsException)
            {
                index = "${val_ques!!.size - 1}".toInt()
                qustionID.text = "${val_ques!![index!!]}"
                qustion_number.text = "${index!! + 1}"
            }
        }

        forward.setOnClickListener{
            try{
                answerID.text = "click answer to show answer of qustion"
                index = index!! +1
                qustionID.text = "${val_ques!![index!!]}"
                qustion_number.text = "${index!! + 1}"

            }catch (e : ArrayIndexOutOfBoundsException)
            {
                index = 0
                qustionID.text = "${val_ques!![index!!]}"
                qustion_number.text = "${index!! + 1}"
            }


        }

        answer.setOnClickListener{
            answerID.text = "${val_ans!![index!!]}"
        }
    }
}