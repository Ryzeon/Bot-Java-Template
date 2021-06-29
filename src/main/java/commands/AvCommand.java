package commands;

import com.github.m5rian.jdaCommandHandler.Command;
import com.github.m5rian.jdaCommandHandler.CommandContext;
import com.github.m5rian.jdaCommandHandler.CommandSubscribe;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.EmbedType;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.MessageEmbed;

import java.awt.*;

/**
 * Project: Casel
 * Date: 08/02/2021 @ 18:00
 * Class: AvCommand
 */
@CommandSubscribe(
        name = "av",
        aliases = {"avatar"}
)
public class AvCommand implements Command {

    @Override
    public void execute(CommandContext ctx) throws Exception {
        String[] args = ctx.getArguments();
        List<Members> tagsMembers = ctx.getEvent().getMessage().getMentionedMembers();
        if (tagsMembers.isEmpty()) {
            final MessageEmbed embed = new EmbedBuilder().setImage(ctx.getAuthor().getAvatarUrl()).setDescription(ctx.getMember().getAsMention()).build();
            ctx.getChannel().sendMessage(embed).queue();   
        } else {
              for (Member member : tagsMembers) {
                 final MessageEmbed embed = new EmbedBuilder().setImage(member.getUser().getAvatarUrl()).setDescription(member.getUser().getAsMention()).build();
                 ctx.getChannel().sendMessage(embed).queue();
            }
        }
    }
}
