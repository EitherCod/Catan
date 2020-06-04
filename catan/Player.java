package catan;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Player{
    private String ID;
    private int victoryPoints;
    /* BRICK == 0 WOOD == 1 WHEAT == 2 SHEEP == 3 STONE == 4 */
    private HashMap<Resource,Integer> playerResources = new HashMap<>();
    private ArrayList<DevCard> developmentCards;
    HashSet<Integer> buildingPositions = new HashSet<>();

    public Player(String user, Board x) {
        if(x.getPlayerCount() > 4) {
            System.out.println("Maximum Players Has Been Reached");
        } else {
            ID = user + "#" +x.getPlayerCount();
            x.incrementCount();
        }
        playerResources.put(Resource.BRICK, 0);
        playerResources.put(Resource.WOOD, 0);
        playerResources.put(Resource.STONE, 0);
        playerResources.put(Resource.SHEEP, 0);
        playerResources.put(Resource.WHEAT, 0);
    }

    /**
     * Allows a player to build a structure on the board
     * @param structure 'C' == City, 'S' == Settlement, 'R' == Road, 'D' == Development Card
     * @param location vertex / edge that is trying to be built on
     * @param x the board the game is being played on
     * @param firstTurn different rules apply for first move settlement placements
     */
    public boolean build(char structure, int location, Board x, boolean firstTurn){
        return true;
    }

    private boolean buildStruct(char structure){

        int wood = playerResources.get(Resource.WOOD);
        int sheep = playerResources.get(Resource.SHEEP);
        int stone = playerResources.get(Resource.STONE);
        int brick = playerResources.get(Resource.BRICK);
        int wheat = playerResources.get(Resource.WHEAT);

        boolean feasable = haveResources(structure);

        if(!feasable){
            System.out.println("Don't have required resources for build");
            return false;
        }
        else {
            if(structure == 'S'){
                playerResources.put(Resource.WOOD, wood-1);
                playerResources.put(Resource.BRICK, brick-1);
                playerResources.put(Resource.WHEAT, wheat-1);
                playerResources.put(Resource.SHEEP, sheep-1);
            }
            else if(structure == 'C'){
                playerResources.put(Resource.WHEAT, wheat-2);
                playerResources.put(Resource.STONE, stone-3);
            }
            else if(structure == 'R'){
                playerResources.put(Resource.WOOD, wood-1);
                playerResources.put(Resource.BRICK, brick-1);
            }
            else if(structure == 'D'){
                playerResources.put(Resource.STONE, stone-1);
                playerResources.put(Resource.WHEAT, wheat-1);
                playerResources.put(Resource.SHEEP, sheep-1);
            }
        }
        return true;
    }

    private boolean haveResources(char structure){
        int wood = playerResources.get(Resource.WOOD);
        int sheep = playerResources.get(Resource.SHEEP);
        int stone = playerResources.get(Resource.STONE);
        int brick = playerResources.get(Resource.BRICK);
        int wheat = playerResources.get(Resource.WHEAT);
        if(structure == 'S'){
            return wood >= 1 && sheep >= 1 && brick >= 1 && wheat >= 1;
        }
        else if(structure == 'C'){
            return wheat >= 2 && stone >= 3;
        }
        else if(structure == 'R'){
            return wood >= 1 && brick >= 1;
        }
        else if(structure == 'D'){
            return stone >= 1 && sheep >= 1 && wheat >= 1;
        }
        return false;
    }

    private boolean adjecentChecker(int position, Board x){
        int[] adjecentList = x.getAdjecenyList()[position];
        HashMap<Integer, String> vertecies = x.getVerticies();
        for(int neighbor : adjecentList){
            if(vertecies.get(neighbor) != null){
                return false;
            }
        }
        return true;
    }

    private boolean isRoadConnected(int position, Board x){
        int[] adjecentList = x.getAdjecenyList()[position];
        HashMap<int[], String> edges = x.getEdges();
        int[] currentEdge = new int[2];
        currentEdge[0] = position;
        for(int neighbor: adjecentList){
            currentEdge[1] = neighbor;
            if(edges.get(currentEdge).equals(ID)){
                return true;
            }
        }
        return false;
    }


    /**
     * Iterate through buildingPositions and check if resources can be added based on dice roll.
     * @param diceRoll number rolled
     */
    public void collectResources(int diceRoll){

    }

    /**
     * Ability to propose trade to players or banks
     * @param proposal row one is resources you are giving, row two resources you are requesting
     * @param type 'B' for bank 'P' for player
     */
    public void trade(int[][] proposal, char type){

    }

    /**
     * If player trade ask every player if they are willing to make the trade if feasible.
     * @param proposal row one resources to be received, row two resources to be given away
     * @return true if trade has been accepted
     */
    public boolean acceptTrade(int[][] proposal){
        return false;
    }

    /**
     * Play development card from Arraylist
     * @param type 'K' if knight 'Y' if year of plenty 'M' if monopoly 'R' if road builder, 'V' if victory point
     */
    public void playDevCard(char type){

    }

    /**
     * Prints info about the player who requested it
     * (Victory points, Your Longest Road, # of settlements, # of cities)
     */
    public void status(){

    }
}
