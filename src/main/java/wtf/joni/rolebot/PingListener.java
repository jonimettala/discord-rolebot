package wtf.joni.rolebot;

import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

/**
 * Ping listener mainly just to test whether the bot is working
 */
public class PingListener extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if (event.getAuthor().isBot()) return;

        Message message = event.getMessage();
        String content = message.getContentRaw();
        if (content.equals(Bot.CMD + "ping")) {
            MessageChannel channel = event.getChannel();
            // Joni 73083635258896384
            if (event.getAuthor().getId().equals("73083635258896384"))
                channel.sendMessage("Hello master <@73083635258896384>!").queue();
            // Trooper 214489850701807616
            else if (event.getAuthor().getId().equals("214489850701807616"))
                channel.sendMessage("OMG HI <@214489850701807616>!").queue();
            // Lireoy 331756964801544202
            else if (event.getAuthor().getId().equals("331756964801544202"))
                channel.sendMessage("Heya <@331756964801544202>!").queue();
            // Hess 128557464537792512
            else if (event.getAuthor().getId().equals("128557464537792512"))
                channel.sendMessage("Nice road, <@128557464537792512>. " +
                        "https://clips.twitch.tv/GiantGoldenYamTBTacoLeft").queue();
            else channel.sendMessage("Pong!").queue();
        }
    }
}
