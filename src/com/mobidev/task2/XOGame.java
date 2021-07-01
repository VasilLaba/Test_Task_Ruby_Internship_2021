package com.mobidev.task2;

import java.util.Scanner;

public class XOGame {
    char gameBoard[][];

    public XOGame(char gameBoard [][]) {
        this.gameBoard = gameBoard;
    }

    public void startTheGame(){
        char rez = findWinner();
        if(rez == 'e')
            System.out.println("''");
        else
            System.out.println(findWinner());
    }

    private char findWinner(){
        //000
        //---
        //---
        for(int i = 0; i < gameBoard.length; i++){
            char var = gameBoard[i][0];
            boolean isWinner = true;
            for(int j=0; j < gameBoard[i].length; j++){
                if (var != (gameBoard[i][j]))
                    isWinner = false;
            }
            if (isWinner==true)
                return var;
        }
        //0--
        //0--
        //0--
        for(int i = 0; i < gameBoard.length; i++){
            if ( gameBoard[0][i] == gameBoard[1][i] && gameBoard[1][i] == gameBoard[2][i])
                return gameBoard[0][i];
        }
        //0--
        //-0-
        //--0
        char var = gameBoard[0][0];
        int j = 0, i = 0;
        boolean isWinner = true;
        while(i< gameBoard.length && j< gameBoard[i].length){
            if (var != (gameBoard[i][j]))
                isWinner = false;
            i++;
            j++;
        }
        if (isWinner==true)
            return var;

        //--0
        //-0-
        //0--
        i = gameBoard.length - 1;
        j = 0;
        var = gameBoard[i - 1][j];
        isWinner = true;
        while( i >= 0 && j< gameBoard[i].length){
            if (var != (gameBoard[i][j]))
                isWinner = false;
            i--;
            j++;
        }
        if (isWinner==true)
            return var;

        return 'e';
    }
}
