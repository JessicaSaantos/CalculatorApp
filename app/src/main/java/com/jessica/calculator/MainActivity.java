package com.jessica.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button numeroZero, numeroUm, numeroDois, numeroTres, numeroQuatro, numeroCinco,
                    numeroSeis, numeroSete, numeroOito, numeroNove, ponto, adicao, subtracao,
                    multiplicacao, divisao, igual, botao_limpar;

    private TextView txtExpressao, txtResultado;

    private ImageButton backspace;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        IniciarComponentes();
        getSupportActionBar().hide();

        numeroZero.setOnClickListener(this);
        numeroUm.setOnClickListener(this);
        numeroDois.setOnClickListener(this);
        numeroTres.setOnClickListener(this);
        numeroQuatro.setOnClickListener(this);
        numeroCinco.setOnClickListener(this);
        numeroSeis.setOnClickListener(this);
        numeroSete.setOnClickListener(this);
        numeroOito.setOnClickListener(this);
        numeroNove.setOnClickListener(this);
        ponto.setOnClickListener(this);
        adicao.setOnClickListener(this);
        subtracao.setOnClickListener(this);
        multiplicacao.setOnClickListener(this);
        divisao.setOnClickListener(this);

        botao_limpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                txtExpressao.setText("");
                txtResultado.setText("");
            }
        });

        backspace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TextView expressao = findViewById(R.id.txt_expressao);
                String string = expressao.getText().toString();

                if (!string.isEmpty()){

                    byte var0 = 0;
                    int var1 = string.length()-1;
                    String txtExpressao = string.substring(var0, var1);
                    expressao.setText(txtExpressao);
                }
                txtResultado.setText("");
            }
        });

        igual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    Expression expression = new ExpressionBuilder(
                            txtExpressao.
                                    getText().
                                    toString()).build();

                    double resultado = expression.evaluate();
                    long longResult = (long) resultado;

                    if (resultado == (double)longResult){
                        txtResultado.setText((CharSequence)
                                String.valueOf(longResult));
                    }
                    else {
                        txtResultado.setText((CharSequence)
                                String.valueOf(resultado));
                    }
                } catch (Exception e) {

                }
            }
        });
    }

    private void IniciarComponentes(){
        numeroZero = findViewById(R.id.number_zero);
        numeroUm = findViewById(R.id.number_um);
        numeroDois = findViewById(R.id.number_dois);
        numeroTres = findViewById(R.id.number_tres);
        numeroQuatro = findViewById(R.id.number_quatro);
        numeroCinco = findViewById(R.id.number_cinco);
        numeroSeis = findViewById(R.id.number_seis);
        numeroSete = findViewById(R.id.number_sete);
        numeroOito = findViewById(R.id.number_oito);
        numeroNove = findViewById(R.id.number_nove);
        ponto = findViewById(R.id.ponto);
        adicao = findViewById(R.id.adicao);
        subtracao = findViewById(R.id.subtracao);
        multiplicacao = findViewById(R.id.multiplicacao);
        divisao = findViewById(R.id.divisao);
        igual = findViewById(R.id.igual);
        botao_limpar = findViewById(R.id.bt_limpar);
        backspace = findViewById(R.id.backspace);
        txtExpressao = findViewById(R.id.txt_expressao);
        txtResultado = findViewById(R.id.txt_resultado);
    }

    public void AddExpressao(String string, boolean limpar_dados){

        if (txtResultado.getText().equals("")){
            txtExpressao.setText(" ");
        }

        if (limpar_dados){
            txtResultado.setText(" ");
            txtExpressao.append(string);
        }
        else {
            txtExpressao.append(txtResultado.getText());
            txtExpressao.append(string);
            txtResultado.setText(" ");
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.number_zero:
                AddExpressao("0", true);
                break;

            case R.id.number_um:
                AddExpressao("1", true);
                break;

            case R.id.number_dois:
                AddExpressao("2", true);
                break;

            case R.id.number_tres:
                AddExpressao("3", true);
                break;

            case R.id.number_quatro:
                AddExpressao("4", true);
                break;

            case R.id.number_cinco:
                AddExpressao("5", true);
                break;

            case R.id.number_seis:
                AddExpressao("6", true);
                break;

            case R.id.number_sete:
                AddExpressao("7", true);
                break;

            case R.id.number_oito:
                AddExpressao("8", true);
                break;

            case R.id.number_nove:
                AddExpressao("9", true);
                break;

            case R.id.ponto:
                AddExpressao(".", true);
                break;

            case R.id.adicao:
                AddExpressao("+", false);
                break;

            case R.id.subtracao:
                AddExpressao("-", false);
                break;

            case R.id.multiplicacao:
                AddExpressao("*", false);
                break;

            case R.id.divisao:
                AddExpressao("/", false);
                break;
        }
    }
}