package commands.interaction.music;

import com.github.m5rian.jdaCommandHandler.Command;
import com.github.m5rian.jdaCommandHandler.CommandContext;
import com.github.m5rian.jdaCommandHandler.CommandSubscribe;
import commands.interaction.music.manager.MusicManager;
import net.dv8tion.jda.api.entities.VoiceChannel;
import net.dv8tion.jda.api.managers.AudioManager;

/**
 * Project: Casel
 * Date: 11/02/2021 @ 17:49
 * Class: PlayCommand
 */
@CommandSubscribe(
        name = "play"
)
public class PlayCommand implements Command {
    @Override
    public void execute(CommandContext ctx) throws Exception {
        if (ctx.getEvent().getAuthor().isBot()) return;
        // This will get the first voice channel with the name "music"
        // matching by voiceChannel.getName().equalsIgnoreCase("music")
        VoiceChannel channel = ctx.getGuild().getVoiceChannelsByName("music", true).get(0);
        AudioManager manager = ctx.getGuild().getAudioManager();

        // MySendHandler should be your AudioSendHandler implementation
        //manager.setSendingHandler(new MusicManager());
        // Here we finally connect to the target voice channel
        // and it will automatically start pulling the audio from the MySendHandler instance
        manager.openAudioConnection(channel);
    }
}
