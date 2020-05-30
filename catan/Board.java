package catan;
import java.util.HashMap;
import java.util.Random;

public class Board {
    // 3 , 4 , 4 , 5, 5, 6, 6, 5, 5, 4, 4 , 3  = 54
    HashMap<Integer, String> verticies = new HashMap<>();
    HashMap<int[], String> edges = new HashMap<>();;
    HashMap<int[], String> harbors = new HashMap<>();;
    HashMap<Integer, Integer> tilesToDiceNum = new HashMap<>();;
    HashMap<Integer, Integer> tilesToResource = new HashMap<>();;
    int[][] tiles = new int[19][];
    int[][] adjecenyList = new int[54][];
    int[][] portVerticies = new int[9][];
    int playerCount = 1;

    public Board(){
        mapLayout();
    }


    // function creates the vertex set, the adjaceny list, and also the marks the special port vertices
    private void mapLayout(){
        initGraph();
        initHarbors();
        initTilesToResources();
        initTileToDice();
    }

    private void initGraph(){
        // putting all verticies in hashmap
        for(int i = 0; i < 54; i++){
            verticies.put(i,null);
        }
        //adjecency list for roads
        adjecenyList[0] = new int[]{3, 4};
        adjecenyList[1] = new int[]{4, 5};
        adjecenyList[2] = new int[]{5, 6};
        adjecenyList[3] = new int[]{0, 7};
        adjecenyList[4] = new int[]{0, 1, 8};
        adjecenyList[5] = new int[]{1, 2, 9};
        adjecenyList[6] = new int[]{2, 10};
        adjecenyList[7] = new int[]{3, 11, 12};
        adjecenyList[8] = new int[]{4, 12, 13};
        adjecenyList[9] = new int[]{5, 13, 14};

        adjecenyList[10] = new int[]{6, 14, 15};
        adjecenyList[11] = new int[]{7, 16};
        adjecenyList[12] = new int[]{7, 8, 17};
        adjecenyList[13] = new int[]{8, 9, 18};
        adjecenyList[14] = new int[]{9, 10, 19};
        adjecenyList[15] = new int[]{10, 20};
        adjecenyList[16] = new int[]{11, 21, 22};
        adjecenyList[17] = new int[]{12, 22, 23};
        adjecenyList[18] = new int[]{13, 23, 24};
        adjecenyList[19] = new int[]{14, 24, 25};

        adjecenyList[20] = new int[]{15, 25, 26};
        adjecenyList[21] = new int[]{16, 27};
        adjecenyList[22] = new int[]{16, 17, 28};
        adjecenyList[23] = new int[]{17, 18, 29};
        adjecenyList[24] = new int[]{18, 19, 30};
        adjecenyList[25] = new int[]{19, 20, 31};
        adjecenyList[26] = new int[]{20, 32};
        adjecenyList[27] = new int[]{21, 33};
        adjecenyList[28] = new int[]{22, 33, 34};
        adjecenyList[29] = new int[]{23, 34, 35};

        adjecenyList[30] = new int[]{24, 35, 36};
        adjecenyList[31] = new int[]{25, 36, 37};
        adjecenyList[32] = new int[]{26, 37};
        adjecenyList[33] = new int[]{27, 28, 38};
        adjecenyList[34] = new int[]{28, 29, 39};
        adjecenyList[35] = new int[]{29, 30, 40};
        adjecenyList[36] = new int[]{30, 31, 41};
        adjecenyList[37] = new int[]{31, 32, 42};
        adjecenyList[38] = new int[]{33, 43};
        adjecenyList[39] = new int[]{34, 43, 44};

        adjecenyList[40] = new int[]{35, 44, 45};
        adjecenyList[41] = new int[]{36, 45, 46};
        adjecenyList[42] = new int[]{37, 42};
        adjecenyList[43] = new int[]{38, 39, 47};
        adjecenyList[44] = new int[]{39, 40, 48 };
        adjecenyList[45] = new int[]{40, 41, 49};
        adjecenyList[46] = new int[]{41, 42, 50};
        adjecenyList[47] = new int[]{43, 51};
        adjecenyList[48] = new int[]{44, 51, 52};
        adjecenyList[49] = new int[]{45, 52, 53};

        adjecenyList[50] = new int[]{46, 53};
        adjecenyList[51] = new int[]{47, 48};
        adjecenyList[52] = new int[]{48, 49};
        adjecenyList[53] = new int[]{49, 50};

        //putting all edges in a seperate hashmap
        for(int[] x : adjecenyList){
            edges.put(x, null);
        }
    }
    private void initHarbors(){
        portVerticies[0] = new int[]{1, 4};
        portVerticies[1] = new int[]{2, 6};
        portVerticies[2] = new int[]{15, 20};
        portVerticies[3] = new int[]{37, 42};
        portVerticies[4] = new int[]{50, 53};
        portVerticies[5] = new int[]{48, 52};
        portVerticies[6] = new int[]{38, 43};
        portVerticies[7] = new int[]{21, 27};
        portVerticies[8] = new int[]{7, 11};
        for(int[] x: portVerticies){
            harbors.put(x, null);
        }
    }

    private void initTilesToResources(){
        tiles[0] = new int[]{0, 3, 4, 7 , 8, 12};
        tiles[1] = new int[]{1, 4, 5, 8, 9, 13};
        tiles[2] = new int[]{2, 5, 6, 9, 10, 14};
        tiles[3] = new int[]{7, 11, 12, 16, 17, 22};
        tiles[4] = new int[]{8, 12, 13, 17, 18, 23};
        tiles[5] = new int[]{9, 13, 14, 18, 19, 24};
        tiles[6] = new int[]{10, 14, 15, 19, 20, 25};
        tiles[7] = new int[]{16, 24, 22, 27, 28, 33};
        tiles[8] = new int[]{17, 22, 23, 28, 29, 34};
        tiles[9] = new int[]{18, 23, 24, 29, 30, 35};
        tiles[10] = new int[]{19, 24, 25, 30, 31, 36};
        tiles[11] = new int[]{20, 25, 26, 31, 32, 37};
        tiles[12] = new int[]{28, 33, 34, 38, 39, 43};
        tiles[13] = new int[]{29, 34, 35, 39,40, 44};
        tiles[14] = new int[]{30, 35, 36, 40, 41, 45};
        tiles[15] = new int[]{31, 36, 37, 41, 42, 46};
        tiles[16] = new int[]{39, 43, 44, 47, 48, 51};
        tiles[17] = new int[]{40, 44, 45, 48, 49, 52};
        tiles[18] = new int[]{41, 45, 46, 49, 50, 53};

        /* BRICK == 0 WOOD == 1 WHEAT == 2 SHEEP == 3 STONE == 4  THIEF == 5*/
        int[] resourceTiles = new int[]{3, 4, 4, 4, 3, 1};
        Random random = new Random();
        int assignedResource = 0;
        for(int x = 0; x < 19; x++){
            while (true) {
                assignedResource = random.nextInt(6);
                if(resourceTiles[assignedResource] != 0){
                    tilesToResource.put(x, assignedResource);
                    resourceTiles[assignedResource] -= 1;
                    break;
                }
            }
        }
    }

    private void initTileToDice(){
        int[] sequence = {0, 1 , 2, 6 , 11, 15, 18, 17, 16, 12, 7 , 3 , 4, 5, 10, 14, 13, 8, 9};
        int[] diceNums = {5, 2, 6, 3, 8, 10, 9, 12, 11, 4, 8, 10, 9, 4, 5, 6, 3, 9, 11};
        int[] potentialStarts = {0, 2, 8, 6};

        Random random = new Random();

        int startingPoint = random.nextInt(4);
        int start = potentialStarts[startingPoint];

        for(int x = 0; x < 19; x++){
            tilesToDiceNum.put(sequence[start], diceNums[x]);
            start++;
            if(start > 18){
                start = 0;
            }
        }
    }

    @Override
    public String toString(){
        String result = "";
        for(int i = 0; i < 19; i++){
            result += " Tile " + i + " Dice Number: " + tilesToDiceNum.get(i) + " Resource: " + tilesToResource.get(i) + "\n";
        }
        return result;
    }

    public static void main(String[] args){
        Board x = new Board();
        System.out.println(x);
    }
}
