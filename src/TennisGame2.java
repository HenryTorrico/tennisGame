
public class TennisGame2 implements TennisGame
{
    private static final int _FORTY = 3;
	private static final int _THIRTY = 2;
	private static final int _FIFTEEN = 1;
	private static final int _LOVE = 0;
	private static final int INITIAL_VALUE_FOR_POINTS = 0;
	public int player1Point = INITIAL_VALUE_FOR_POINTS; // nombres poco descriptivos
    public int player2Point = INITIAL_VALUE_FOR_POINTS; // nombres poco descriptivos
    
    private String player1Name;
    private String player2Name;
    
    private String literalScore="";

    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getLiteralScore(){
    	if (isNormal())  
    		literalScore = getLiteral(player1Point) + "-" + getLiteral(player2Point);
        if (isTie())
        	literalScore = getLiteral(player1Point)+ "-All";
        if (isDeuce())
            literalScore = "Deuce";
        if (isInAdvantageOver(player1Point,player2Point))
            literalScore = "Advantage player1";
        if (isInAdvantageOver(player2Point,player1Point))
            literalScore = "Advantage player2";
        if (winnerOver(player1Point,player2Point))
            literalScore = "Win for player1";
        if (winnerOver(player2Point,player1Point))
            literalScore = "Win for player2";
        return literalScore;
    }


	private boolean winnerOver(int player1Point,int player2Point) {
		return player1Point>_FORTY && player2Point>=_LOVE && (player1Point-player2Point)>=_THIRTY;
	}


	private boolean isInAdvantageOver(int player1Points,int player2Points) {
		return player1Points > player2Points && player2Points >= _FORTY;
	}

	private boolean isNormal() {
		return player2Point !=player1Point;
	}


	private String getLiteral(int playerPoints) {
		String result="";
		if (playerPoints==_LOVE)
			result = "Love";
		if (playerPoints==_FIFTEEN)
			result = "Fifteen";
		if (playerPoints==_THIRTY)
			result = "Thirty";
		if (playerPoints==_FORTY)
			result = "Forty";
		return result;
	}

	private boolean isTie() {
		return player1Point == player2Point && player1Point <= _FORTY;
	}


	private boolean isDeuce() {
		return player1Point==player2Point && player1Point>=_FORTY;
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