
public class TennisGame2 implements TennisGame
{
    private static final int INITIAL_VALUE_FOR_POINTS = 0;
	public int player1Point = INITIAL_VALUE_FOR_POINTS; // nombres poco descriptivos
    public int player2Point = INITIAL_VALUE_FOR_POINTS; // nombres poco descriptivos
    
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
        score = getPoints(score);
        score = hasAdvantage(score);
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

	private String hasAdvantage(String score) {
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

	private String getPoints(String score) {
		if (player2Point !=player1Point)
        {      
            player1Result = getLiteral(player1Point);
            player2Result = getLiteral(player2Point);
            score = player1Result + "-" + player2Result;
        }
		return score;
	}


	private String getLiteral(int playerPoints) {
		String result="";
		if (playerPoints==0)
			result = "Love";
		if (playerPoints==1)
			result = "Fifteen";
		if (playerPoints==2)
			result = "Thirty";
		if (playerPoints==3)
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
    
    public void setPlayer1Score(int number){
        for (int i = 0; i < number; i++)
        {
            player1Score();
        } 
    }
    
    public void setPlayer2Score(int number){
        for (int i = 0; i < number; i++)
        {
            player2Score();
        }     
    }
    
    public void player1Score(){
        player1Point++;
    }
    
    public void player2Score(){
        player2Point++;
    }

    public void wonPoint(String player) {
        if (player == "player1")
            player1Score();
        else
            player2Score();
    }
}