
public class TennisGame2 implements TennisGame
{
    public int player1Point = 0; // nombres poco descriptivos
    public int player2Point = 0; // nombres poco descriptivos
    
    public String player1Result = ""; // nombres poco descriptivos
    public String player2Result = ""; // nombres poco descriptivos
    private String player1Name;
    private String player2Name;

    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getScore(){
        String score = "";
        score = tie(score);
        score = deuce(score);
        score = normal(score);
        score = normal1(score);
        
        score = normal2(score);
        score = normal3(score);
        
        //muchas funciones hacen lo mismo
        
        score = advantage(score);
        
        return winner(score);
    }

	private String winner(String score) {
		if (player1Point>=4 && player2Point>=0 && (player1Point-player2Point)>=2) // 2 es valor estatico
        {
            score = "Win for player1";
        }
        if (player2Point>=4 && player1Point>=0 && (player2Point-player1Point)>=2) // 2 es valor estatico
        {
            score = "Win for player2";
        }
        return score;
	}

	private String advantage(String score) {
		if (player1Point > player2Point && player2Point >= 3) // 3 es valor estatico
        {
            score = "Advantage player1";
        }
        
        if (player2Point > player1Point && player1Point >= 3) // 3 es valor estatico
        {
            score = "Advantage player2";
        }
		return score;
	}

	private String normal3(String score) {
		if (player2Point>player1Point && player2Point < 4) // 0-1-2-3 es valor estatico e ifs anidados
        {
			player1Result=getLiteral(player1Point);
            player2Result=getLiteral(player2Point);
            score = player1Result + "-" + player2Result;
        }
		return score;
	}

	private String normal2(String score) {
		if (player1Point>player2Point && player1Point < 4) 
        {
            player1Result=getLiteral(player1Point);
            player2Result=getLiteral(player2Point);
            score = player1Result + "-" + player2Result;
        }
		return score;
	}

	private String normal1(String score) {
		if (player2Point > 0 && player1Point==0)
        {      
            player2Result = getLiteral(player2Point);
            player1Result = "Love";
            score = player1Result + "-" + player2Result;
        }
		return score;
	}

	private String normal(String score) {
		int p1point2 = player1Point;
		int p2point2 = player2Point;
		if (p1point2 > 0 && p2point2==0) // 0-1-2-3 es valor estatico e ifs anidados
        { 
            player1Result=getLiteral(p1point2);
            player2Result = getLiteral(p2point2);
            score = player1Result + "-" + player2Result;
        }
		return score;
	}

	private String getLiteral(int p1point2) {
		String result="";
		if (p1point2==0)
			result = "Love";
		if (p1point2==1)
			result = "Fifteen";
		if (p1point2==2)
			result = "Thirty";
		if (p1point2==3)
			result = "Forty";
		return result;
	}

	private String tie(String score) {
		if (player1Point == player2Point && player1Point < 4)
        {
            score = getLiteral(player1Point);
            score += "-All";
        }
		return score;
	}

	private String deuce(String score) {
		if (player1Point==player2Point && player1Point>=3) // el 3 es un valor estatico
            score = "Deuce";
		return score;
	}
    
    public void SetP1Score(int number){
        
        for (int i = 0; i < number; i++)
        {
            P1Score();
        }
            
    }
    
    public void SetP2Score(int number){
        
        for (int i = 0; i < number; i++)
        {
            P2Score();
        }
            
    }
    
    public void P1Score(){
        player1Point++;
    }
    
    public void P2Score(){
        player2Point++;
    }

    public void wonPoint(String player) {
        if (player == "player1")
            P1Score();
        else
            P2Score();
    }
}