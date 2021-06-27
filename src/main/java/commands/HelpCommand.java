package commands;

import com.github.m5rian.jdaCommandHandler.Command;
import com.github.m5rian.jdaCommandHandler.CommandContext;
import com.github.m5rian.jdaCommandHandler.CommandSubscribe;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageEmbed;

/**
 * Project: Casel
 * Date: 11/02/2021 @ 21:37
 * Class: HelpCommand
 */
@CommandSubscribe(
        name = "help"
)
public class HelpCommand implements Command{
    @Override
    public void execute(CommandContext ctx) throws Exception {
        final MessageEmbed embed = new EmbedBuilder().setTitle("Casel | Help")
                .setDescription("**Commands**" + "\n" +
                        "/av - You can use this to see other profile photo!" + "\n" +
                        "/clear <amount>- You can use this to clear message!"
                        
                ).setFooter(ctx.getAuthor().getName() + " | Casel")
                .build();
        ctx.getChannel().sendMessage(embed).queue();
    }
}
