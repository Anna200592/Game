import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GameTest {
    Game game = new Game();
    Player player1 = new Player(17,"Vasya",100);
    Player player2 = new Player(2, "Petya", 120);
    Player player3 = new Player(2, "Olya", 100);

    @BeforeEach
    public void setup(){
        game.register(player1);
        game.register(player2);
        game.register(player3);
    }

    @Test
    public void shouldFirstPlayerWin(){
        int expected = 1;
        int actual = game.round("Petya", "Vasya");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldSecondPlayerWin(){
        int expected = 2;
        int actual = game.round("Vasya", "Petya");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testEquals(){
        int expected = 0;
        int actual = game.round("Vasya", "Olya");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void NotRegisteredExceptionPlayer1(){
        Assertions.assertThrows(NotRegisteredException.class, () ->{
            game.round("Anya", "Vasya");
        });
    }
    @Test
    public void NotRegisteredExceptionPlayer2(){
        Assertions.assertThrows(NotRegisteredException.class, () ->{
            game.round("Olya", "Nikita");
        });
    }
    @Test
    public void testNoPlayers(){
        Assertions.assertThrows(NotRegisteredException.class, () ->{
            game.round("Nikita", "Lena");
        });
    }
}