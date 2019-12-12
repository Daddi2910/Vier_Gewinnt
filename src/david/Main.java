package david;

import java.util.Scanner;

public class Main {
    static void print(String text) {
        System.out.print(text);
    }

    static void println(String text) {
        System.out.println(text);
    }

    static char scan_char() {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        if (s.length() == 0)
            return '\n';
        char res = s.charAt(0);
        return res;
    }

    static int scan_int() {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        return s;
    }

    static final int ROWS = 8;
    static final int COLS = 10;

    static void printPlayGround(char[][] playground) {
        // vor allem
        println("nun kommen die DaTeN");
        for (int y = 0; y < ROWS; y++) {
            // vor der Datenzeile
            print("|  ");

            for (int x = 0; x < COLS; x++) {
                print("" + playground[y][x]);

                // Zwischen den Daten
                print("  ");
            }

            // nach der Datenzeile
            print("|");
            print("\n");    //Absatz
        }

        // nach allem

        int unten = 0;
        while (unten <= COLS) {
            print("___");
            unten++;
        }
        print("\n ");   // Absatz + Leerzeichen
        for (int zahl = 0; zahl < COLS; zahl++) {
            print("  " + zahl);
        }
//        for(int unten =0; unten<=COLS; unten++) {
////            print("____");
////        }
        println("");    // Absatz am Ende
    }


    static int get_valid_num() {
        // 1. scan_char aufrufen

        // 2. Wert überpfüfen, muss zwischen 0-9 liegen
        int num;
        do {
            char input = scan_char();
            println("Deine Eingabe ist " + input + ". Liegt die Zahl außerhalb des Geltungsbereich, erscheint erneut die Eingabeaufforderung");
            num = input - '0'; // oder -48 aus ascii ziffer ne echte machen ('0'==48)
        }
        while (num < 0 || num >= 10);

        //      Bei Fehler, Fehlerausgabe machen, so das der Spieler neu eingeben muss ( also zurück zu 1.)
        // 3. char in int umwandeln ( also '0' -> 0 und nicht ascii 65 oder was auch immer) (kann auch vor 2.)
        // 4. Ergebnis zurückgeben (return)
        return num;
    }

    static boolean test_game_draw(char[][] playground)
    {
        for (int x = 0; x < COLS; x++)
        {
            if (playground[0][x] == ' ')
                return false;
        }
        return true;

    }
    static boolean test_game_winner(char[][] playground)
    {

        //Zeile konstant, gucken ob 4 aufeinanderfolgende Spalten mit gleichem Inhalt vorhanden sind
        for (int y=0; y < ROWS; y++)
        {
            int zahl1 =0;
            int zahl2 =1;
            int zahl3 =2;
            int zahl4 =3;

            for (int a =0; a<= COLS-4; a++)
            {
                if (playground[y][zahl1] == 'Z' && playground[y][zahl2] == 'Z' && playground[y][zahl3] == 'Z' && playground[y][zahl4] == 'Z' || playground[y][zahl1] == 'E' && playground[y][zahl2] == 'E' && playground[y][zahl3] == 'E' && playground[y][zahl4] == 'E')
                {
                    return true;
                }
                zahl1++;
                zahl2++;
                zahl3++;
                zahl4++;
            }
        }
        //Spalte konstant, gucken ob 4 aufeinanderfolgende Zeilen mit gleichem Inhalt vorhanden sind
        for (int x=0; x < COLS; x++)
        {
            int zahl1 =0;
            int zahl2 =1;
            int zahl3 =2;
            int zahl4 =3;

            for (int a =0; a<= ROWS-4; a++)
            {
                if (playground[zahl1][x] == 'Z' && playground[zahl2][x] == 'Z' && playground[zahl3][x] == 'Z' && playground[zahl4][x] == 'Z' || playground[zahl1][x] == 'E' && playground[zahl2][x] == 'E' && playground[zahl3][x] == 'E' && playground[zahl4][x] == 'E')
                {
                    return true;
                }
                zahl1++;
                zahl2++;
                zahl3++;
                zahl4++;
            }
        }
        //Die Diagonale nach rechts absteigend
            for (int y=0; y < ROWS; y++) {
                int zahl1 = 0;
                int zahl2 = 1;
                int zahl3 = 2;
                int zahl4 = 3;

                for (int a = 0; a <= COLS - 4; a++) {
                    if (playground[y][zahl1] == 'Z' && playground[y + 1][zahl2] == 'Z' && playground[y + 2][zahl3] == 'Z' && playground[y + 3][zahl4] == 'Z' || playground[y][zahl1] == 'E' && playground[y + 1][zahl2] == 'E' && playground[y + 2][zahl3] == 'E' && playground[y + 3][zahl4] == 'E') {
                        return true;
                    }
                    zahl1++;
                    zahl2++;
                    zahl3++;
                    zahl4++;
                }
            }

            //Diagonale nach links absteigend
         for (int x=0; x < COLS; x++)
            {
                int zahl1 =0;
                int zahl2 =1;
                int zahl3 =2;
                int zahl4 =3;

                for (int a =0; a<= ROWS-4; a++)
                {
                    if (playground[zahl1][x] == 'Z' && playground[zahl2][x] == 'Z' && playground[zahl3][x] == 'Z' && playground[zahl4][x] == 'Z' || playground[zahl1][x] == 'E' && playground[zahl2][x] == 'E' && playground[zahl3][x] == 'E' && playground[zahl4][x] == 'E')
                    {
                        return true;
                    }
                    zahl1++;
                    zahl2++;
                    zahl3++;
                    zahl4++;
                }

            }

        return false;
    }


    /**
     * Returns the row index of the first empty row at column col.
     * If no row is valid, -1 is returned.
     */
    static int get_first_valid_row(char[][] playground, int col) {
        for (int y = ROWS - 1; y >= 0; y--) {
            //   if (playground [y] [col] != ' ');
            // continue;
            if (playground[y][col] == ' ')
                return y;
        }
        return -1;

    }

    public static void main(String[] args) {


        char[][] playground = new char[ROWS][COLS];
        for (int y = 0; y < ROWS; y++) {
            for (int x = 0; x < COLS; x++) {
                playground[y][x] = ' ';
            }
        }

        /////////// Beispieldaten erzeugen:
       // for (int y = 0; y < ROWS; y++) {
         //   for (int x = 0; x < COLS - 1; x++)

           //     playground[y][x] = 'O';

        //    playground[ROWS - 1][5] = 'O';
        //  playground[ROWS - 1][6] = 'O';
        //playground[ROWS - 2][6] = 'O';
        //////////////////////

        printPlayGround(playground);
        int spieler = 1;
        while (true) {
            // for(;;)

            //Eingabe speichern
            println("Spieler " + spieler + ", wählen Sie eine Feldnummer (0-9):");
            int row = -1;
            int column = 0;
            while (row == -1) {
                column = get_valid_num();

                // passende Zeile finden
                row = get_first_valid_row(playground, column);
                // testen ob eine Zeile existiert (Spalte voll)
                if (row == -1) {
                    println("Die Spalte ist schon voll, bitte eine andere wählen!");
                }
            }
            // feld setzen, für "0" den zurückgegebebn Wert aus get_first_valid_row nehmen!
            if (spieler == 1) {
                playground[row][column] = 'E';
            } else {
                playground[row][column] = 'Z';
            }

            printPlayGround(playground);

            // neues Spielfeld testen:

            // -> Komplett voll: Ende, Unentschieden
            // -> Gewinner?: Ende, Gewonnen

            //Testen, ob Spielfeld voll ist
            boolean is_win= test_game_winner(playground);
            if(is_win)
            {
                println("Spieler " + spieler + " hat gewonnen");
                break;
            }

            boolean is_draw = test_game_draw(playground);
            if (is_draw) {
                println("Unentschieden");
                break;  // Aus der while(true) raus
            }
            if (spieler == 1)
            {
                spieler = 2;
            }
            else
                {
                spieler = 1;
                }
        }

        println("Ende?");

    }


    static void beispiele() {

        // write your code here

        //int[][] matrix = {{1, 2, 3}, {4, 5, 6}};
        char[][] playground = new char[COLS][ROWS]; //Erstellung der Matrix -->Koordinatensystem ist obenlinks!!!
        for (int y = 0; y < playground.length; y++) {  //Anzahl der "Schranksysteme"
            for (int x = 0; x < playground[y].length; x++) { //Anzahl der Fächer des Schrankelements an der Stelle y
                int tmp = x + y;             //Beispieldaten werdden erzeugt
                if (tmp % 3 == 0) {
                    playground[y][x] = '+';
                } else if (tmp % 3 == 1) {
                    playground[y][x] = 'X';
                } else {
                    playground[y][x] = 'O';
                }
            }
        }
    }
}
