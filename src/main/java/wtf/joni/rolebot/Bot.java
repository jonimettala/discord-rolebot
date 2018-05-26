package wtf.joni.rolebot;

import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.exceptions.RateLimitedException;

import javax.security.auth.login.LoginException;

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
            JDA jda = new JDABuilder(AccountType.BOT)
                    .setToken(SECRET_TOKEN)
                    .addEventListener(new MyListener())
                    .buildBlocking();
        } catch (LoginException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
