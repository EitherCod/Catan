package catan;

import java.util.ArrayList;
import java.util.HashSet;

public class Player{
    private String ID;
    private int victoryPoints;
    /* BRICK == 0 WOOD == 1 WHEAT == 2 SHEEP == 3 STONE == 4 */
    private int[] resources = new int[5];
    private ArrayList<DevCard> developmentCards;
    HashSet<Integer> buildingPositions = new HashSet<>();

    public Player(String user, Board x) {
        if(x.playerCount > 4) {
            System.out.println("Maximum Players Has Been Reached");
        } else {
            ID = user + x.playerCount;
            x.playerCount += 1;
        }
    }

    /**
     * Allows a player to build a structure on the board
     * @param structure 'C' == City, 'S' == Settlement, 'R' == Road
     * @param location vertex / edge that is trying to be built on
     * @param x the board the game is being played on
     * @param firstTurn different rules apply for first move settlement placements
     */
    public void build(char structure, int location, Board x, boolean firstTurn){
        if(structure == 'S') {
            if(firstTurn) {

            }
        }
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
