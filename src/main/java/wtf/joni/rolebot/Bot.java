package wtf.joni.rolebot;

import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDABuilder;

import javax.security.auth.login.LoginException;

/**
 * Main class of the bot
 */
public class Bot {

    /**
     * Character which starts all the bot commands
     * For example, if "!", commands look like: !ping
     */
    public static final String CMD = ".";

    /**
     * Secret bot token, generated from Discord developer pages
     */
    private static final String SECRET_TOKEN = "";

    public static void main(String[] args) {
        try {
            new JDABuilder(AccountType.BOT)
                    .setToken(SECRET_TOKEN)
                    .addEventListener(new PingListener())
                    .buildBlocking();
        } catch (LoginException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
