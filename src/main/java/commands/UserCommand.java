package commands;

import com.github.m5rian.jdaCommandHandler.Command;
import com.github.m5rian.jdaCommandHandler.CommandContext;
import com.github.m5rian.jdaCommandHandler.CommandSubscribe;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.MessageEmbed;

import java.awt.*;

/**
 * Project: Casel
 * Date: 19/04/2021 @ 16:37
 * Class: UserCommand
 */
@CommandSubscribe(
        name = "user"
)
public class UserCommand implements Command {
    @Override
    public void execute(CommandContext ctx) throws Exception {
        String[] args = ctx.getArguments();
        if (args.length == 0){
            final MessageEmbed embed = new EmbedBuilder().setTitle(":unlock:  **Player Profile**")
                    .setDescription("• Successfully retrieved user information.." + "\n" +
                            "**User**" + "\n" +
                            "• Name: "+ "**" + ctx.getMember().getUser().getName() + "**" + "\n" +
                            "• ID: " + "**" + ctx.getMember().getUser().getId() + "**" +"\n" +
                            "• Tag: " + ctx.getMember().getUser().getAsMention()+ "\n" +
                            "• Custom-Name: " + ctx.getMember().getNickname()+ "\n" +
                            "**Values**" + "\n" +
                            "• Rol: " + ctx.getMember().getRoles().get(1) + "\n" +
                            "• Account Create: " + "**" + ctx.getMember().getTimeCreated() + "**" + "\n" +
                            "• Account Joined: " + "**" + ctx.getMember().getTimeJoined() + "**" + "\n" +
                            "**Statistics**" + "\n" +
                            "• Boost Tier: " + "**" + ctx.getMember().getTimeBoosted() + "**" + "\n")
                    .setFooter(ctx.getAuthor().getName() + "#" + ctx.getAuthor().getDiscriminator())
                    .setColor(Color.RED)
                    .build();
            ctx.getChannel().sendMessage(embed).queue();
        }
        if (args[1].equalsIgnoreCase(ctx.getMember().getAsMention())){
            for (Member member : ctx.getEvent().getMessage().getMentionedMembers()){
                final MessageEmbed embed = new EmbedBuilder().setTitle(":unlock:  **Player Profile**")
                        .setDescription("• Successfully retrieved user information.." + "\n" +
                                "**User**" + "\n" +
                                "• Name: "+ "**" + member.getUser().getName() + "**" + "\n" +
                                "• ID: " + "**" + member.getUser().getId() + "**" +"\n" +
                                "• Tag: " + member.getUser().getAsMention()+ "\n" +
                                "• Custom-Name: " + member.getNickname()+ "\n" +
                                "**Values**" + "\n" +
                                "• Rol: " + member.getRoles().get(1) + "\n" +
                                "• Account Create: " + "**" + member.getTimeCreated() + "**" + "\n" +
                                "• Account Joined: " + "**" + member.getTimeJoined() + "**" + "\n" +
                                "**Statistics**" + "\n" +
                                "• Boost Tier: " + "**" + member.getTimeBoosted() + "**" + "\n")
                        .setFooter(member.getUser().getName() + "#" + member.getUser().getDiscriminator())
                        .setColor(Color.RED)
                        .build();
                ctx.getChannel().sendMessage(embed).queue();
            }
        }
    }
}
