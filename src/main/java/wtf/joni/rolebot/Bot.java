package wtf.joni.rolebot;

import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.OnlineStatus;
import net.dv8tion.jda.core.entities.Game;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import javax.security.auth.login.LoginException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.URL;

/**
 * Main class of the bot
 */
public class Bot {

    /**
     * Secret bot token, generated from Discord developer pages
     * Imported from settings.json
     */
    private static String SECRET_TOKEN;

    /**
     * Character which starts all the bot commands
     * For example, if "!", commands look like: !ping
     * Imported from settings.json
     */
    public static String CMD;

    public static void main(String[] args) {
        JSONParser jsonParser = new JSONParser();
        try {
            URL path = Bot.class.getResource("settings.json");
            File f = new File(path.getFile());
            JSONObject jsonObject = (JSONObject) jsonParser.parse(new BufferedReader(new FileReader(f)));

            SECRET_TOKEN = (String) jsonObject.get("Token");
            CMD = (String) jsonObject.get("CommandKey");

        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            new JDABuilder(AccountType.BOT)
                    .setToken(SECRET_TOKEN)
                    .setGame(Game.watching("cute cat videos"))
                    .setStatus(OnlineStatus.DO_NOT_DISTURB)
                    .addEventListener(new PingListener())
                    .buildBlocking();
        } catch (LoginException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
