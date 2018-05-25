package wtf.joni.rolebot;

import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.exceptions.RateLimitedException;

import javax.security.auth.login.LoginException;

public class Bot {

    public static void main(String[] args) throws RateLimitedException {
        try {
            JDA jda = new JDABuilder(AccountType.BOT)
                    .setToken("")
                    .addEventListener(new MyListener())
                    .buildBlocking();
        } catch (LoginException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
