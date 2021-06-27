package commands;

import com.github.m5rian.jdaCommandHandler.Command;
import com.github.m5rian.jdaCommandHandler.CommandContext;
import com.github.m5rian.jdaCommandHandler.CommandSubscribe;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageEmbed;

import java.awt.*;

/**
 * Project: Casel
 * Date: 13/02/2021 @ 23:35
 * Class: ServerCommand
 */
@CommandSubscribe(
        name = "server"
)
public class ServerCommand implements Command {
    @Override
    public void execute(CommandContext ctx) throws Exception {
        final MessageEmbed embed = new EmbedBuilder().setTitle(":unlock:  **Server Profile**")
                .setDescription("• Successfully retrieved server information.." + "\n" +
                        "**Server**" + "\n" +
                        "• Name: "+ "**" + ctx.getGuild().getName() + "**" + "\n" +
                        "• ID: " + "**" + ctx.getGuild().getId() + "**" +"\n" +
                        "• Owner: " + ctx.getGuild().getOwner().getAsMention() + "\n" +
                        "**Values**" + "\n" +
                        "• Members: " + "**" + ctx.getGuild().getMemberCount() + "**" + "\n" +
                        "**Statistics**" + "\n" +
                        "• Boost Tier: " + "**" + ctx.getGuild().getBoostTier() + "**" + "\n" +
                        "• Boosters: " + "**" +  ctx.getGuild().getBoostCount() + "**" +  "\n" +
                        "• Region: " + "**" +  ctx.getGuild().getRegion() + "**")
                .setFooter(ctx.getAuthor().getName() + "#" + ctx.getAuthor().getDiscriminator())
                .setColor(Color.RED)
                .build();
        ctx.getChannel().sendMessage(embed).queue();

    }
    //• Successfully retrieved server information..
    //Server
    //• Name: Ace Services | Official Discord
    //• ID: 652342115803856896
    //• Owner: Dalton#8496
    //Values
    //• Channels: 61
    //• Members: 544
    //• Bots: 5
    //Security
    //• Moderation: Medium
    //• Filter: All messages from members are checked.
    //Statistics
    //• Boost Tier: No Tier
    //• Boosters: 1
    //• Region: Us-west
}
