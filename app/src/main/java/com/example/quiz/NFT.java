package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class NFT extends AppCompatActivity implements View.OnClickListener{

    Button option1,option2,option3,option4;
    Button Submit;
    TextView questionView;
    int score = 0;
    int totalQuestion = DataQueAns.Question.length;
    int currentQuestionIndex = 0;
    String selectedAnswer = "";
    ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nft);


        Submit = findViewById(R.id.submit);
        questionView = findViewById(R.id.question);
        back = findViewById(R.id.back);
        option1 = findViewById(R.id.option1);
        option2 = findViewById(R.id.option2);
        option3 = findViewById(R.id.option3);
        option4 = findViewById(R.id.option4);

        option1.setOnClickListener(this);
        option2.setOnClickListener(this);
        option3.setOnClickListener(this);
        option4.setOnClickListener(this);
        Submit.setOnClickListener(this);

        loadNewQuestion();

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(NFT.this,MainActivity.class);
                startActivity(i);
                System.exit(0);
            }
        });
//        next.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent i = new Intent(Blockchain.this,MainActivity.class);
//                startActivity(i);
//            }
//        });
    }

    @Override
    public void onClick(View view) {
        Button clickedBtn = (Button) view;

        option1.setBackgroundColor(Color.TRANSPARENT);
        option2.setBackgroundColor(Color.WHITE);
        option3.setBackgroundColor(Color.WHITE);
        option4.setBackgroundColor(Color.WHITE);


        if(clickedBtn.getId()==R.id.submit){
            if(selectedAnswer.equals(DataQueAns.correctAnsweres[currentQuestionIndex])){
                score++;
            }
            currentQuestionIndex++;
            loadNewQuestion();
        }else{
            //Choice Btn Clicked
            selectedAnswer = clickedBtn.getText().toString();
            clickedBtn.setBackgroundColor(Color.CYAN);
        }
    }

    void loadNewQuestion(){

        if(currentQuestionIndex == totalQuestion){
            finishQuiz();
            return;
        }
        questionView.setText(DataQueAns.Question[currentQuestionIndex]);
        option1.setText(DataQueAns.choice[currentQuestionIndex][0]);
        option2.setText(DataQueAns.choice[currentQuestionIndex][1]);
        option3.setText(DataQueAns.choice[currentQuestionIndex][2]);
        option4.setText(DataQueAns.choice[currentQuestionIndex][3]);
    }

    void finishQuiz(){
        String passStatus = "";
        if(score > totalQuestion*0.70){
            passStatus = "Passed";
        }else{
            passStatus = "Failed";
        }

        new AlertDialog.Builder(this)
                .setTitle(passStatus)
                .setMessage("Your Score is " + score + " out of " + totalQuestion)
                .setPositiveButton("Restart",((dialogInterface, i) -> restartQuiz()))
                .setCancelable(false)
                .show();
    }
    void restartQuiz() {
        Intent i = new Intent(NFT.this,MainActivity.class);
        startActivity(i);
        System.exit(0);    }
}