package com.jalon.sample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by JinQiu on 2018/4/15.
 *   fighters = [
     ["Ryu", "E.Honda", "Blanka", "Guile", "Balrog", "Vega"],
     ["Ken", "Chun Li", "Zangief", "Dhalsim", "Sagat", "M.Bison"]
     ]
     initial_position = (0,0)
     moves = ['up', 'left', 'right', 'left', 'left']

     then I should get:
     ['Ryu', 'Vega', 'Ryu', 'Vega', 'Balrog']
 *
 */


public class CharacterSelection {

    public static String[] streetFighterSelection(String[][] fighters, int[] position, String[] moves) {
        int rowLength = fighters[0].length;
        List<String> result = new ArrayList<String>();
        int[] currPost = position;
        int i = 0;
        String[] rs  = new String[moves.length];
        for(String move : moves){
            currPost = doMove(move,currPost,rowLength);
            rs[i]=getValue(fighters,currPost);
            i++;
        }
        return rs;

    }

    public  static int[] doMove(String move,int[] post,int rowLength){
        int onePost = post[0];
        int secPost = post[1];
        if("up".equalsIgnoreCase(move)){  //上下不越界
            post[0] = onePost-1 < 0 ? onePost : onePost-1;
        }else if("down".equalsIgnoreCase(move)){
            post[0] = onePost+1 > 1 ? onePost : onePost+1;
        }else if("left".equalsIgnoreCase(move)){ //左右可越界
            post[1] = secPost-1<0? rowLength-1:secPost-1;
        }else {
            post[1] = secPost+1 == rowLength ? 0 : secPost+1;
        }
        return  post;
    }
    public  static String getValue(String[][] fighters, int[] position){
        int row = position[0];
        int col = position[1];
        return fighters[row][col];
    }


    public static String[] streetFighterSelection2(String[][] fighters, int[] position, String[] moves){
        int x = position[1];
        int y = position[0];
        String[] result = new String[moves.length];

        for (int i = 0; i < moves.length; i++) {
            String mv = moves[i];
            switch(mv) {
                case "up":    y = 0; break;
                case "right": x = (x + 1) % 6; break;
                case "down":  y = 1; break;
                case "left":  x = (x + 5) % 6; break;
                default: break;
            }

            result[i] = fighters[y][x];
        }
        return result;
    }

    public static String[] streetFighterSelection3(String[][] fighters, int[] position, String[] moves){
        String[] res=new String[moves.length];
        int i=0;
        for (String s:moves){
            position[0]= s=="up"? 0: s=="down"? 1: position[0];
            position[1]= s=="left"&&position[1]!=0 ? position[1]-1: s=="left"&&position[1]==0 ? fighters[position[0]].length-1: position[1];
            position[1]= s=="right"&&position[1]<fighters[position[0]].length-1 ? position[1]+1: s=="right"&&position[1]==fighters[position[0]].length-1 ? 0: position[1];
            res[i]=fighters[position[0]][position[1]];
            i++;
        }
        return res;
    }
}
