package com.example.shepur.myapplication;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class QuizActivity extends AppCompatActivity implements View.OnClickListener{

    private int serialNo =1;

    private String outOf = "/20";
    TextView serialNoText;
    private List<Integer> quizQuestionNotes = Arrays.asList(R.raw.sa, R.raw.re_komal, R.raw.re, R.raw.ga_komal,
    R.raw.ga, R.raw.ma, R.raw.ma_tivra, R.raw.pa, R.raw.dha_komal, R.raw.dha, R.raw.ni_komal, R.raw.ni, R.raw.ss);

    private Random random = new Random();

    private int currentQuizQuestion;

    MediaPlayer mp;

//    private boolean questionBtnNotClicked = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        setClickListeners();

        serialNoText = findViewById(R.id.serialNoText);
        serialNoText.setText(serialNo+outOf);
        fetchNextQuizQuestion();
    }

    private void fetchNextQuizQuestion(){

        int question = random.nextInt(quizQuestionNotes.size());
        currentQuizQuestion = quizQuestionNotes.get(question);

    }
    @Override
    public void onBackPressed() {
        //Open Pop Up to Show end Quix
        super.onBackPressed();
    }

    private void setClickListeners() {

        Button button = findViewById(R.id.saAnsButton);
        button.setOnClickListener(this);

        button = findViewById(R.id.reKomalAnsButton);
        button.setOnClickListener(this);

        button = findViewById(R.id.reAnsButton);
        button.setOnClickListener(this);

        button = findViewById(R.id.gaKomalAnsButton);
        button.setOnClickListener(this);

        button = findViewById(R.id.gaAnsButton);
        button.setOnClickListener(this);

        button = findViewById(R.id.maAnsButton);
        button.setOnClickListener(this);

        button = findViewById(R.id.maTivraAnsButton);
        button.setOnClickListener(this);

        button = findViewById(R.id.paAnsButton);
        button.setOnClickListener(this);

        button = findViewById(R.id.dhaKomalAnsButton);
        button.setOnClickListener(this);

        button = findViewById(R.id.dhaAnsButton);
        button.setOnClickListener(this);

        button = findViewById(R.id.niKomalAnsButton);
        button.setOnClickListener(this);

        button = findViewById(R.id.niAnsButton);
        button.setOnClickListener(this);

        button = findViewById(R.id.ssAnsButton);
        button.setOnClickListener(this);

        button = findViewById(R.id.questionNote);
        button.setOnClickListener(this);

        button = findViewById(R.id.nextQuestionButton);
        button.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {

        Button nextBtn = findViewById(R.id.nextQuestionButton);
        if(v.getId() == R.id.questionNote){
            if(mp != null){
                mp.release();
            }
            mp = MediaPlayer.create(getApplicationContext(), currentQuizQuestion);
            mp.start();
        }

        if(MappingHelper.getMediaIdOfButton(v.getId()) != 0){
            if ( MappingHelper.getMediaIdOfButton(v.getId()) == currentQuizQuestion ){
                Button button = findViewById(v.getId());
                button.setBackgroundColor(Color.GREEN);

                TextView resultText = findViewById(R.id.resultText);


                if(serialNo < 20){

                    nextBtn.setClickable(true);
                    resultText.setText("Correct Answer!!");
                }else if(serialNo == 20){
                    resultText.setText("Correct Answer. Quiz Completed!!");
                }

            }
            else{
                Button button = findViewById(v.getId());
                button.setBackgroundColor(Color.RED);
                TextView resultText = findViewById(R.id.resultText);
                resultText.setText("Wrong Answer. Listen again and Try to answer.");
            }
        }
        if(v.getId() == R.id.nextQuestionButton){
            nextBtn.setClickable(false);
            serialNo++;
            serialNoText.setText(serialNo+outOf);
            fetchNextQuizQuestion();
            setAllBtnColors();
        }

    }

    private void setAllBtnColors() {

        List<Integer> btnToBeReset = Arrays.asList(R.id.saAnsButton, R.id.reKomalAnsButton, R.id.reAnsButton, R.id.gaKomalAnsButton, R.id.gaAnsButton,
                R.id.maAnsButton, R.id.maTivraAnsButton, R.id.paAnsButton, R.id.dhaKomalAnsButton, R.id.dhaAnsButton, R.id.niKomalAnsButton, R.id.niAnsButton, R.id.ssAnsButton
        );

        for (int i : btnToBeReset){
            Button btn = findViewById(i);
            btn.setBackgroundColor(Color.GRAY);
        }
    }
}
