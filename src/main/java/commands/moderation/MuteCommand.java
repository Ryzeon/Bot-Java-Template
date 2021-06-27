package commands.moderation;

import com.github.m5rian.jdaCommandHandler.Command;
import com.github.m5rian.jdaCommandHandler.CommandContext;
import com.github.m5rian.jdaCommandHandler.CommandSubscribe;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Member;

import java.util.Arrays;
import java.util.Objects;

/**
 * Project: Casel
 * Date: 10/02/2021 @ 19:34
 * Class: MuteCommand
 */
@CommandSubscribe(
        name = "mute"
)
public class MuteCommand implements Command {
    @Override
    public void execute(CommandContext ctx) throws Exception {
        if (!ctx.getMember().hasPermission(Permission.ADMINISTRATOR))
            ctx.getChannel().sendMessage("You dont have permissions to use this!").queue();
            if (ctx.getMember().hasPermission(Permission.ADMINISTRATOR)) {
            for (Member member : ctx.getEvent().getMessage().getMentionedMembers()) {
                member.mute(true).queue();
                ctx.getChannel().sendMessage("Member " + member.getAsMention() + " has been muted by operator.").queue();
            }
        }
    }
}
