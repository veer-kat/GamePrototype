package Game;
import static java.lang.Math.ceil;
import java.util.*;
class Char
{
    private ArrayList<String> avail=new ArrayList<String>();
    private ArrayList<String> own=new ArrayList<String>();
    Assets a1=new Assets();
    private int lvl=(int)a1.exp();
    void charAvail()// All available characters at current level
    {
        System.out.println("Level: "+lvl);
        if(lvl>30)
        {
            System.out.println("Your level is greater tha 30 so the first 3 characters are premium:");
            avail.add("Emz");
            avail.add("Jessie");
            avail.add("Nita");
        }
        avail.add("Lou");
        avail.add("Stu");
        avail.add("Crow");
        avail.add("Xbow");
        avail.add("Dragons");
        System.out.println("Character Available:");
        for(int i=0;i<8;i++)
        {
            System.out.println(avail.get(i));
        }
    }
    void charOwned()// All obtained characters from charAvail()
    {
        
        own.add("Lou");
        own.add("Xbow");
        own.add("Dragons");
        System.out.println("Character Owned:");
        for(int i=0;i<3;i++)
        {
            System.out.println(own.get(i));
        }
    }
    void charAttri()// Character levels, powerups, weapons
    {
        int[] x = new int[]{999,369,11}; 
        System.out.println("Health= "+x[0]);
        System.out.println("Damage per second= "+x[1]);
        System.out.println("Level= "+x[2]);        
    }
    void charSkin()// holiday skins, specials etc
    {
        System.out.println("Christmas skin");
        System.out.println("Champion special skin");
    }
}
class UI
{
    public static int ft=0;
    public static int ex=369278;
    private int ch;
    private String s;
    Assets a=new Assets();
    Char c=new Char();
    public static int wins=98;
    private int b1=0;
    private int b2=0;
    private static final Random r = new Random();
    private static final int NUMBER = r.nextInt(100) + 1;
    private static int guess = 0;
    public void InGameStore()
    {
        System.out.println("Gifts available:"+a.gifts());
        System.out.println("Originally Gold owned= "+(a.gold()));
        System.out.println("Originally Gems owned= "+(a.gem()));
        Scanner sc=new Scanner(System.in);
        System.out.println("What do you want to buy?\n1) Gold\n2) Gems");
        ch=sc.nextInt();
        if(ch==1)
        {
            System.out.println("Buy Gold\n1) 499\n2) 999\n3) 1999");
            ch=sc.nextInt();
            switch(ch)
            {
                case 1:
                    System.out.println("499 gold bought");
                    b1=499;
                    break;
                case 2:
                    System.out.println("999 gold bought");
                    b1=999;
                    break;
                case 3:
                    System.out.println("1999 gold bought");
                    b1=1499;
                    break;
            }
            System.out.println("Gold owned= "+(a.gold()+b1));
        }
        else if(ch==2)
        {
            System.out.println("Buy Gems\n1) 49\n2) 99\n3) 999");
            ch=sc.nextInt();
            switch(ch)
            {
                case 1:
                    System.out.println("49 gems bought");
                    b2=49;
                    break;
                case 2:
                    System.out.println("99 gems bought");
                    b2=99;
                    break;
                case 3:
                    System.out.println("999 gems bought");
                    b2=999;
                    break;
            }
            System.out.println("Gems owned= "+(a.gem()+b2));
        }
    }
    public void frontLine()// Team for battle(characters+weapons?)
    {
        c.charAvail();
        c.charOwned();
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Character name to be evaluated: ");
        s=sc.next();
        System.out.println("1) Attributes\n2) Skins ");
        ch=sc.nextInt();
        if(ch==1)
            c.charAttri();
        else if(ch==2)
            c.charSkin();
    }
    public void battle()// 1v1,2v2,gamemode etc
    {
            Scanner player = new Scanner(System.in);
	    while ( guess != NUMBER )
            {
                // prompt player for guess
                System.out.println("Guess a number between 1 and 100");
                guess = player.nextInt();
                if ( guess > NUMBER )
                {
                    System.out.println("Too high");
                }
                else if ( guess < NUMBER )
                {
                    System.out.println("Too low");
                }
                else
                {
                    System.out.println("That's right!");
                    wins=wins+1;
                    System.out.println("Total Wins= "+wins);
                    ft=a.trophies();
                    ex+=50;
                    System.out.println("New Experience= "+(ex));
                    System.out.println("Level= "+a.exp());
                    break;
                }
            }
            guess=0;
    }
    public void clan()// friends group
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter message to send to your friends");
        s=sc.nextLine();
        System.out.println("Message sent...");
    }
    public void tourney()// open tornaments...
    {
        System.out.println("Currently there are no tournaments going on");
    }
}
class Assets
{
    private int x=1;
    private int t=68;
    private double level;
    private int f=0;
    public int trophies()// loot from battle victory
    {   
        if(UI.wins<100)
        {
            System.out.println("You have "+UI.wins*20+" trophies");
            f=UI.wins*40;
        }
        else if(UI.wins>=100 && UI.wins<500)
        {
            System.out.println("You have "+UI.wins*30+" trophies");
            f=UI.wins*25;
        }
        else
            System.out.println("Keep Improving, you have 0 trophies");
        return f;
    }
    public int gifts()// free gifts
    {
        return 3;
    }
    public double exp()//decides player level
    {
        level=UI.ex/10000;
        level= ceil(level);
        return level;
    }
    public int gold()//Available Gold
    {
        return 4206971;
    }
    public int gem()// Available gems
    {
        return 3333;
    }
}
public class Game
{
    private String start;
    private int choice;
    private String name;
    private String pwd;
    public void login()
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Username and password");
        name=sc.nextLine();
        pwd=sc.nextLine();
        start();
    }
    public void start()
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Play to start the Game");
        start=sc.next();
        if(start.equalsIgnoreCase("PLAY"))
        {
            while(1>0){
            System.out.println("In Game Options:\n1) Shop\n2) Team\n3) Battle\n4) Clan\n5) Tourneys");
            choice=sc.nextInt();
            UI u=new UI();
            switch(choice)
            {
                case 1: 
                    u.InGameStore();
                    break;
                case 2:
                    u.frontLine();
                    break;
                case 3: 
                    u.battle();
                    break;
                case 4:
                    u.clan();
                    break;
                case 5:
                    u.tourney();
                    break;
                default:
                    System.out.println("Error 404");
                    stop();
            }
            }
        }
        else if(start.equalsIgnoreCase("EXIT"))
            stop();
    }
    public void stop()
    {
        System.exit(0);
    }
    public static void main(String arg[])
    {
        Game[] g=new Game[5];
        for(int i=0;i<5;i++)
        {
            System.out.println("User "+(i+1)+":");
            g[i]= new Game();
            g[i].login();
        }
    }
}
