package tictactoe;

import java.util.*;

public class Main {
    public static char[][] ticTacToe = new char[3][3];
    public static char currentCharacter = 'X';
    public static int toFill = 9;
    public static String player1;
    public static String player2;
    public static String gameStart;
    public static boolean gameEnd = false;
    public static boolean applicationEnd = false;
    public static void setInitialBoard() {
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                ticTacToe[i][j] = ' ';
            }
        }
    }
    public static boolean inputHandle(int xCor, int yCor) {
        try {
            if(ticTacToe[xCor][yCor] == ' '){
                ticTacToe[xCor][yCor] = currentCharacter;
                if(currentCharacter == 'X'){
                    currentCharacter = 'O';
                } else {
                    currentCharacter = 'X';
                }
                toFill--;
                return true;
            }
            else {
                System.out.println("This cell is occupied! Choose another one!");
                return false;
            }
        } catch (Exception e){
            System.out.println("Coordinates should be from 1 to 3!");
            return false;
        }
    }
    public static boolean handleCurrentMove(int xCor, int yCor){
        if(toFill > 0){
            if(xCor >=0 && xCor <= 2 && yCor >= 0 && yCor <= 2){
                if(ticTacToe[xCor][yCor] == ' '){
                    ticTacToe[xCor][yCor] = currentCharacter;
                    if(currentCharacter == 'X'){
                        currentCharacter = 'O';
                    } else if(currentCharacter == 'O'){
                        currentCharacter = 'X';
                    }
                    toFill--;
                    return true;
                }
            }
        }
        return false;
    }
    public static void calculateWinning(char currChar){
        Map<Character, List<Integer>> storage = new HashMap<>();
        for(int i = 0; i < 3; i++){
            int xCount = 0;
            int oCount = 0;
            for(int j = 0; j < 3; j++){
                if(ticTacToe[i][j] == 'X'){
                    xCount++;
                } else if(ticTacToe[i][j] == 'O'){
                    oCount++;
                }
            }
            if(xCount == 2 || oCount == 2){
                List<Integer> temp = new ArrayList<>();
                for(int j = 0; j < 3; j++){
                    if(ticTacToe[i][j] == ' '){
                        temp.add(i);
                        temp.add(j);
                    }
                }
                if(xCount == 2){
                    storage.put('X', temp);
                } else if(oCount == 2){
                    storage.put('O', temp);
                }

            }
        }
        for(int j = 0; j < 3; j++){
            int xCount = 0;
            int oCount = 0;
            for(int i = 0; i < 3; i++){
                if(ticTacToe[i][j] == 'X'){
                    xCount++;
                } else if(ticTacToe[i][j] == 'O'){
                    oCount++;
                }
            }
            if(xCount == 2 || oCount == 2){
                List<Integer> temp = new ArrayList<>();
                for(int i = 0; i < 3; i++){
                    if(ticTacToe[i][j] == ' '){
                        temp.add(i);
                        temp.add(j);
                    }
                }
                if(xCount == 2){
                    storage.put('X', temp);
                } else if(oCount == 2){
                    storage.put('O', temp);
                }

            }
        }
        int xCount = 0;
        int oCount = 0;
        for(int i = 0; i < 3; i++){
            if(ticTacToe[i][i] == 'X'){
                xCount++;
            } else if(ticTacToe[i][i] == 'O'){
                oCount++;
            }

        }
        if(xCount == 2 || oCount == 2){
            List<Integer> temp = new ArrayList<>();
            for(int i = 0; i < 3; i++){
                if(ticTacToe[i][i] == ' '){
                    temp.add(i);
                    temp.add(i);
                }
            }
            if(xCount == 2){
                storage.put('X', temp);
            } else if(oCount == 2){
                storage.put('O', temp);
            }

        }
        xCount = 0;
        oCount = 0;
        for(int i = 0; i < 3; i++){
            if(ticTacToe[i][2 - i] == 'X'){
                xCount++;
            } else if(ticTacToe[i][2 - i] == 'O'){
                oCount++;
            }
        }
        if(xCount == 2 || oCount == 2){
            List<Integer> temp = new ArrayList<>();
            for(int i = 0; i < 3; i++){
                if(ticTacToe[i][2 - i] == ' '){
                    temp.add(i);
                    temp.add(2 - i);
                }
            }
            if(xCount == 2){
                storage.put('X', temp);
            } else if(oCount == 2){
                storage.put('O', temp);
            }

        }
        boolean toHappen = true;
        if(storage.containsKey(currChar)){
            List<Integer> val = storage.get(currChar);
            if(val.size() > 0){
                int xPos = val.get(0);
                int yPos = val.get(1);
                toHappen = false;
                ticTacToe[xPos][yPos] = currChar;
                if(currentCharacter == 'X'){
                    currentCharacter = 'O';
                } else if(currentCharacter == 'O'){
                    currentCharacter = 'X';
                }
                toFill--;
            }

        }
        else if(currChar == 'X' && storage.containsKey('O')){
            List<Integer> val = storage.get('O');
            if(val.size() > 0){
                int xPos = val.get(0);
                int yPos = val.get(1);
                toHappen = false;
                ticTacToe[xPos][yPos] = 'X';
                if(currentCharacter == 'X'){
                    currentCharacter = 'O';
                } else if(currentCharacter == 'O'){
                    currentCharacter = 'X';
                }
                toFill--;
            }

        } else if(currChar == 'O' && storage.containsKey('X')){
            List<Integer> val = storage.get('X');
            if(val.size() > 0){
                int xPos = val.get(0);
                int yPos = val.get(1);
                toHappen = false;
                ticTacToe[xPos][yPos] = 'O';
                if(currentCharacter == 'X'){
                    currentCharacter = 'O';
                } else if(currentCharacter == 'O'){
                    currentCharacter = 'X';
                }
                toFill--;
            }

        }
        if(toHappen){
            boolean compInputSuccess = false;
            while(!compInputSuccess){
                Random random = new Random();
                int compXCor = random.nextInt(3);
                int compYCor = random.nextInt(3);
                compInputSuccess = handleCurrentMove(compXCor, compYCor);
            }

        }
        storage.clear();

    }

    public static void hardMove(char currentPlayer) {
        Deepak deepak = new Deepak();
        deepak.player = currentPlayer;
        deepak.opponent = (currentPlayer == 'X' ? 'O' : 'X');
        Deepak.Move bestMove = deepak.findBestMove(ticTacToe);
        ticTacToe[bestMove.row][bestMove.col] = currentPlayer;
        if(currentCharacter == 'X'){
            currentCharacter = 'O';
        } else if(currentCharacter == 'O'){
            currentCharacter = 'X';
        }
        toFill--;

    }



    public static void play(String player){
        Random random = new Random();
        Scanner scan = new Scanner(System.in);
        if(Objects.equals(player, "easy")){
            System.out.println("Making move level \"easy\"");
            boolean compInputSuccess = false;
            while(!compInputSuccess){
                int compXCor = random.nextInt(3);
                int compYCor = random.nextInt(3);
                compInputSuccess = handleCurrentMove(compXCor, compYCor);
            }
        }
        else if(Objects.equals(player, "user")){
            try {
                boolean userInputSuccess = false;
                while(!userInputSuccess){
                    System.out.print("Enter the coordinates: > ");
                    int userXCor = scan.nextInt();
                    int userYCor = scan.nextInt();
                    userInputSuccess = inputHandle(userXCor - 1, userYCor - 1);
                }
            } catch (Exception e){
                System.out.println("You should enter numbers!");
            }
        }
        else if(Objects.equals(player, "medium")){
            System.out.println("Making move level \"medium\"");
            calculateWinning(currentCharacter);

        }
        else if(Objects.equals(player, "hard")){
            System.out.println("Making move level \"hard\"");
            hardMove(currentCharacter);

        }
    }
    public static char checkWinner(){
        for(int i = 0; i < 3; i++){
            if(ticTacToe[0][i] != ' ' && ticTacToe[0][i] == ticTacToe[1][i] && ticTacToe[1][i] == ticTacToe[2][i]){
                return ticTacToe[0][i];
            }
            if(ticTacToe[i][0] != ' ' && ticTacToe[i][0] == ticTacToe[i][1] && ticTacToe[i][1] == ticTacToe[i][2]){
                return ticTacToe[i][0];
            }
            if(ticTacToe[0][0] != ' ' && ticTacToe[0][0] == ticTacToe[1][1] && ticTacToe[1][1] == ticTacToe[2][2]){
                return ticTacToe[0][0];
            }
            if(ticTacToe[0][2] != ' ' && ticTacToe[0][2] == ticTacToe[1][1] && ticTacToe[2][0] == ticTacToe[1][1]){
                return ticTacToe[0][2];
            }
        }
        return 'D';
    }
    public static void printWinner(char result) {
        if(result == 'X'){
            System.out.println("X wins");
            gameEnd = true;
        } else if(result == 'O'){
            System.out.println("O wins");
            gameEnd = true;
        } else if(result == 'D' && toFill <= 0){
            System.out.println("Draw");
            gameEnd = true;
        }
    }
    public static void startGame(){
        while(toFill > 0 && !gameEnd){
            play(player1);
            printBoard();
            char player1Result = checkWinner();
            printWinner(player1Result);
            if(!gameEnd){
                play(player2);
                printBoard();
                char player2Result = checkWinner();
                printWinner(player2Result);
            }
        }
    }
    public static void getPlayersInfo(){
        Scanner scan = new Scanner(System.in);
        boolean playersInfo = false;
        while(!playersInfo){
            System.out.print("Input command: > ");
            try {
                String userInput = scan.nextLine();
                String[] words = userInput.split("\\s+");
                gameStart = words[0];
                player1 = words[1];
                player2 = words[2];
                if(Objects.equals("start", gameStart)){
                    if(Objects.equals("user", player1) || Objects.equals("easy", player1) || Objects.equals("medium", player1) || Objects.equals("hard", player1)){
                        if(Objects.equals("user", player2) || Objects.equals("easy", player2) || Objects.equals("medium", player2) || Objects.equals("hard", player2)){
                            playersInfo = true;
                            break;
                        }
                    }
                }
                throw new Exception("Bad input");
            } catch (Exception e) {
                if(Objects.equals(gameStart, "exit")){
                    applicationEnd = true;
                    playersInfo = true;
                }else {
                    System.out.println("Bad parameters!");
                }
            }
        }
    }
    public static void printBoard(){
        System.out.println("---------");
        for(int i = 0; i < 3; i++){
            System.out.print("| ");
            for(int j = 0; j < 3; j++){
                System.out.print(ticTacToe[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }
    public static void gameReset(){
        ticTacToe = new char[3][3];
        toFill = 9;
        gameEnd = false;
        currentCharacter = 'X';
    }
    public static void main(String[] args){
        while(!applicationEnd){
            setInitialBoard();
            getPlayersInfo();
            if(applicationEnd){
                break;
            }
            printBoard();
            startGame();
            gameReset();
        }
    }
}


