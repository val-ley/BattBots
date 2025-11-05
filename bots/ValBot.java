
package bots;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import arena.BattleBotArena;
import arena.BotInfo;
import arena.Bullet;
public class ValBot extends Bot {
BotHelper helpme = new BotHelper(); //creates a new bothelper class
    double moveDist = 50; //sets a move distance to 100 pixels
    public void newRound() {
    }

     /**
      * 
      tasks:
      - make a case system, avoid graves, if exploded bot is near, ignore, 
      - look at how ddgey bot works
      - see where bulet is going, dodge perependicular where mnore bots are, seperate board into 4 sections
      - 

      order:
      -  basic movemnts
      - doding first
      - moving towardsotehrs w/ out dying
      - notice what direction other bot is going shoot where it expects it to be
        prln
        liveBots 
             BattleBotArena.STAY
            BattleBotArena.UP
            BattleBotArena.DOWN
            BattleBotArena.LEFT
            BattleBotArena.RIGHT

        Fire:
            BattleBotArena.FIREUP
            BattleBotArena.FIREDOWN
            BattleBotArena.FIRELEFT
            BattleBotArena.FIRERIGHT
       
    
        Messaging:
            BattleBotArena.SEND_MESSAGE
   
    Parameters:
    me       A BotInfo object with all publicly available info about this Bot
    shotOK   True iff a FIRE move is currently allowed
    liveBots An array of BotInfo objects for the other Bots currently in play
    deadBots An array of BotInfo objects for the dead Bots littering the arena
    bullets  An array of all Bullet objects currently in play

    Returns:
    must return a legal move (use the constants defined in BattleBotArena)
     */
    public int getMove(BotInfo me, boolean shotOK, BotInfo[] liveBots, BotInfo[] deadBots, Bullet[] bullets) {
        
        Bullet closestbullet = helpme.findClosest(me, bullets); //finds the closest bot
        double distX, distY;
        distX = Math.abs(closestbullet.getX() - me.getX());
        distY = Math.abs(closestbullet.getY() - me.getY());

        if (closestbullet.getY() > me.getY() && distX < moveDist) {
            return BattleBotArena.UP;
        }  else if (closestbullet.getY() < me.getY() && distX > moveDist) {
            return BattleBotArena.DOWN;
        } else if (closestbullet.getX() > me.getX() && distY < moveDist) {
            return BattleBotArena.LEFT;
        } else if (closestbullet.getX() < me.getX() && distY > moveDist) {
            return BattleBotArena.RIGHT;
        } else {
            return BattleBotArena.STAY;
        }
    }

     public void draw(Graphics g, int x, int y) {
        g.setColor(Color.orange);
        g.fillOval(x, y, Bot.RADIUS*2, Bot.RADIUS*2);
    }

    public String getName() {
        return "ValBot";
    }
    public String getTeamName() {
        return "NA";
    }

        public String outgoingMessage() {
        return null;
    }
    public void incomingMessage(int botNum, String msg) {
    }

    public String[] imageNames() {
            return null;
    }
    public void loadedImages(Image[] images) {
    }
}
